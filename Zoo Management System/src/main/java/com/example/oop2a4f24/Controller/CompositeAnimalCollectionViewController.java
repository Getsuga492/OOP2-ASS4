package com.example.oop2a4f24.Controller;

import com.example.oop2a4f24.Helpers.ImportHelper;
import com.example.oop2a4f24.Model.AnimalCollection;
import com.example.oop2a4f24.Model.CompositeAnimalCollection;
import com.example.oop2a4f24.Model.Enclosure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class CompositeAnimalCollectionViewController {

    @FXML
    private ListView<String> enclosureListView;
    @FXML
    private Button displayButton;
    @FXML
    private Button exitButton;

    private CompositeAnimalCollection bigCatsCollection;

    @FXML
    public void initialize() {
        // Initialize the "Big Cats" collection and populate ListView
        bigCatsCollection = ImportHelper.createAnimals();
        for (AnimalCollection collection : bigCatsCollection.getCollections()) {
            enclosureListView.getItems().add(collection.getName());
        }
    }

    @FXML
    protected void onDisplayButtonClick(ActionEvent pEvent) throws IOException {
        String selectedEnclosureName = enclosureListView.getSelectionModel().getSelectedItem();

        // Check if no item is selected
        if (selectedEnclosureName == null) {
            // Create an alert
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Enclosure Selected");
            alert.setContentText("Please select an enclosure.");

            // Show the alert
            alert.showAndWait();
            return; // Exit the method if no selection
        }

        // Find the selected collection based on the selected name
        var selectedCollection = bigCatsCollection.findCollectionByName(selectedEnclosureName);

        if (selectedCollection instanceof Enclosure) {
            // Load EnclosureView.fxml if it's a single enclosure
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/oop2a4f24/EnclosureView.fxml"));
            Parent view = fxmlLoader.load();
            EnclosureViewController newEnclosureViewController = fxmlLoader.getController();
            newEnclosureViewController.setEnclosure((Enclosure) selectedCollection);

            // Create and show the new stage for Enclosure view
            Scene nextScene = new Scene(view, 400, 400);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle(((Enclosure) selectedCollection).getName());
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();
        } else if (selectedCollection instanceof CompositeAnimalCollection) {
            // Load composite-animal-view.fxml if it’s a composite collection (e.g., "Tigers")
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/oop2a4f24/composite-animal-view.fxml"));
            Parent view = fxmlLoader.load();
            CompositeAnimalCollectionViewController newController = fxmlLoader.getController();
            newController.setCompositeAnimalCollection((CompositeAnimalCollection) selectedCollection);

            // Create and show the new stage for the nested composite collection view
            Scene nextScene = new Scene(view, 500, 500);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle(((CompositeAnimalCollection) selectedCollection).getName());
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();
        }
    }

    private Enclosure getSelectedEnclosure() {
        String selectedName = enclosureListView.getSelectionModel().getSelectedItem();
        if (selectedName == null) return null;

        // Look for an Enclosure with the matching name in the bigCatsCollection
        var selectedCollection = bigCatsCollection.findCollectionByName(selectedName);
        return selectedCollection instanceof Enclosure ? (Enclosure) selectedCollection : null;
    }

    @FXML
    protected void onExitButtonClick() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void setCompositeAnimalCollection(CompositeAnimalCollection collection) {
        this.bigCatsCollection = collection;

        // Clear and update ListView for nested collections
        enclosureListView.getItems().clear();
        for (var subCollection : bigCatsCollection.getCollections()) {
            enclosureListView.getItems().add(subCollection.getName());
        }
    }
}

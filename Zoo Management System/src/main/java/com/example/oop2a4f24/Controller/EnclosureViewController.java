package com.example.oop2a4f24.Controller;

import com.example.oop2a4f24.HelloApplication;
import com.example.oop2a4f24.Model.Enclosure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EnclosureViewController {

    @FXML
    private ListView<String> enclosureListView;

    private EnclosureViewController aEnclosureViewController;

    private Enclosure aEnclosure;


    @FXML
    protected void addButton(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent view = fxmlLoader.load();
        EnclosureViewController newEnclosureViewController = fxmlLoader.getController();
        newEnclosureViewController.setEnclosure(getSelectedEnclosure());
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(aEnclosureViewController.getName());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }

    private String getName() {
        return this.aEnclosure.getName();
    }

    private Enclosure getSelectedEnclosure() {
        return new Enclosure(); //TODO Find right enclosure from list
    }

    @FXML
    protected void displayButton() {
        // Get the selected index from the ListView
        int selectedIndex = enclosureListView.getSelectionModel().getSelectedIndex();

        // Check if an item is selected
        if (selectedIndex != -1) {
            // display the animal view with the detailed



        } else {
            System.out.println("No item selected to display.");
        }
    }

    @FXML
    protected void deleteButton() {
        // Get the selected index from the ListView
        int selectedIndex = enclosureListView.getSelectionModel().getSelectedIndex();

        // Check if an item is selected
        if (selectedIndex != -1) {
            // Remove the selected item from the ListView
            enclosureListView.getItems().remove(selectedIndex);
        } else {
            System.out.println("No item selected to delete.");
        }
    }


    @FXML
    protected void closeButton(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void setEnclosure(Enclosure pEnclosure) {

    }
}

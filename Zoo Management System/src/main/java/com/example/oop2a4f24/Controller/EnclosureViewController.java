package com.example.oop2a4f24.Controller;

import com.example.oop2a4f24.HelloApplication;
import com.example.oop2a4f24.Model.Animal;
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
    @FXML
    private Label nameLabel;

    private EnclosureViewController aEnclosureViewController;

    private Enclosure aEnclosure;

    public void setEnclosure(Enclosure enclosure) {
        this.aEnclosure = enclosure;
        nameLabel.setText(enclosure.getName());

        // Populate ListView with animal names from the enclosure
        enclosureListView.getItems().clear();
        for (Animal animal : enclosure.getAnimals()) {
            enclosureListView.getItems().add(animal.getaName());
        }
    }
    private void openAnimal(String fxmlFile, ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Parent view = fxmlLoader.load();
        AnimalViewController newAnimalViewController = fxmlLoader.getController();
        newAnimalViewController.setAnimal(getSelectedAnimal());
        newAnimalViewController.setEnclosure(getSelectedEnclosure());

        Scene nextScene = new Scene(view, 400, 400);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.initModality(Modality.WINDOW_MODAL);

        if (pEvent != null) {
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        } else {
            nextStage.initOwner(enclosureListView.getScene().getWindow());
        }

        nextStage.showAndWait();
    }
    @FXML
    protected void addButton(ActionEvent pEvent) throws IOException {
        openAnimal("/com/example/oop2a4f24/AnimalView.fxml", pEvent);
    }

    private String getName() {
        return this.aEnclosure.getName();
    }

    private Enclosure getSelectedEnclosure() {
        return new Enclosure(); //TODO Find right enclosure from list
    }
    // public void setEnclosure(Enclosure pEnclosure) {}

    @FXML
    protected void displayButton() {
        // Get the selected index from the ListView
        int selectedIndex = enclosureListView.getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {
            try {
                openAnimal("/com/example/oop2a4f24/AnimalView.fxml", null);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        //Close the window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private Animal getSelectedAnimal() {
        // Assume enclosureListView contains the names of the animals, and we match the selected name
        int selectedIndex = enclosureListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedAnimalName = enclosureListView.getItems().get(selectedIndex);
            // Now get the animal object from the enclosure using the name
            return aEnclosure.getAnimalByName(selectedAnimalName); // Ensure this method is available in Enclosure
        }
        return null; // Return null if no animal is selected
    }

}
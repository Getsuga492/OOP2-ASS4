package com.example.oop2a4f24.Controller;

import com.example.oop2a4f24.Model.Animal;
import com.example.oop2a4f24.Model.Enclosure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AnimalViewController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField sexTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private Button closeButton;

    private Enclosure enclosure;

    public void setAnimal(Animal animal) {
        if (animal != null) {
            nameTextField.setText(animal.getaName());
            sexTextField.setText(animal.getaSex());
            ageTextField.setText(String.valueOf(animal.getaAge()));
            weightTextField.setText(String.valueOf(animal.getaWeight()));
        }
    }

    // Set the enclosure for the current view
    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    // Handle the save button action (save or update animal data)
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        String sex = sexTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());
        int weight = Integer.parseInt(weightTextField.getText());

        // Method to either update an existing animal or create a new one
        Animal existingAnimal = enclosure.getAnimalByName(name);
        if (existingAnimal != null) {
            // Update existing animal's details
            existingAnimal.setaSex(sex);
            existingAnimal.setaAge(age);
            existingAnimal.setaWeight(weight);
        } else {
            // Create a new animal and add it to the enclosure
            Animal newAnimal = new Animal(name, sex, age, weight);
            enclosure.addAnimal(newAnimal);
        }

        // Navigate back to EnclosureView after saving the data
        navigateToEnclosureView();
    }

    // Handle the close button action (cancel or exit the view)
    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    // Helper to navigate back to the EnclosureView
    private void navigateToEnclosureView() {
        // Close the current window
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

package com.example.oop2a4f24.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    @FXML
    private Button saveButton;

    private CompositeAnimalCollection animalCollection;

    public void initialize() {
        // Initialize the animal collection or retrieve it from a service
        animalCollection = new CompositeAnimalCollection();
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        String sex = sexTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());
        double weight = Double.parseDouble(weightTextField.getText());

        com.example.oop2a4f24.Model.Animal newAnimal = new com.example.oop2a4f24.Model.Animal(name, sex, age, weight);
        animalCollection.addAnimal(newAnimal);

        // Navigate back to EnclosureView
        navigateToEnclosureView();
    }

    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        // Navigate back to EnclosureView
        navigateToEnclosureView();
    }

    private void navigateToEnclosureView() {
        // Logic to navigate back to EnclosureView
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        // You might want to open the EnclosureView here
    }
}
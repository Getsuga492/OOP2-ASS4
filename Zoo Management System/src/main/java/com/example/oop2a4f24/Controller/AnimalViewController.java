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
    private TextField enclosureNameTextField;

    @FXML
    private Button closeButton;

    @FXML
    private Button saveButton;

    private Enclosure enclosure;

    public void initialize() {

    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
        displayEnclosureInfo();
    }

    private void displayEnclosureInfo() {
        if (enclosure != null) {
            enclosureNameTextField.setText(enclosure.getName());

        }
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        String sex = sexTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());
        double weight = Double.parseDouble(weightTextField.getText());

        Animal newAnimal = new Animal(name, sex, age, weight);
        enclosure.addAnimal(newAnimal);

        // Navigate back to EnclosureView
        navigateToEnclosureView();
    }

    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        // Navigate back to EnclosureView
        navigateToEnclosureView();
    }

    private void navigateToEnclosureView() {
        // Close the current window
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

        // Open the EnclosureView
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EnclosureView.fxml"));
            Parent root = loader.load();

            EnclosureViewController enclosureController = loader.getController();

            enclosureController.setEnclosure(this.enclosure);

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
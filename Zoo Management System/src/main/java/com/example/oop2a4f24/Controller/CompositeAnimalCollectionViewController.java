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

public class CompositeAnimalCollectionViewController {

    @FXML
    protected void onDisplayButtonClick(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EnclosureView.fxml"));
        Parent view = fxmlLoader.load();
        EnclosureViewController newEnclosureViewController = fxmlLoader.getController();
        newEnclosureViewController.setEnclosure(getSelectedEnclosure());
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        // nextStage.setTitle(pEnclosure.getName());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }

    private Enclosure getSelectedEnclosure() {
        return new Enclosure();
    }

    @FXML
    protected void onExitButtonClick() {
        
    }
}

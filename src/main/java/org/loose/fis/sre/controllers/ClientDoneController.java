package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.loose.fis.sre.Main;

import java.io.IOException;

public class ClientDoneController {

    @FXML
    private TextField done;

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientViewPrograms.fxml");
    }

    public void handleDoneButton(){
        done.setText("Today's workout successfully done");
        done.setStyle("-fx-text-fill: red");
    }

}
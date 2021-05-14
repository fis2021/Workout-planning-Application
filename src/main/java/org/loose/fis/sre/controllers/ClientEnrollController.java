package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.loose.fis.sre.Main;

import java.io.IOException;

public class ClientEnrollController {

    @FXML
    private TextField enroll;

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientViewPrograms.fxml");
    }

    public void handleEnrolledButton(){
        enroll.setText("Successfully enrolled!");
        enroll.setStyle("-fx-text-fill: red");
    }

}
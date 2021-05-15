package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.loose.fis.sre.Main;
import org.loose.fis.sre.model.ProgramName;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.ProgramService;

import static org.loose.fis.sre.services.ProgramService.addClient;
import java.io.IOException;

public class ClientEnrollController {

    @FXML
    private TextField enroll;
    @FXML
    private TextField enrollfield;

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientViewPrograms.fxml");
    }

    public void handleEnrolledButton(){
        String name = User.getCurrentUser();
        ProgramService.addClient(ProgramService.getProgramName(enrollfield.getText()),name);

        enroll.setText("Successfully enrolled!");
        enroll.setStyle("-fx-text-fill: red");
    }

}
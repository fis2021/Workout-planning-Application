package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.Main;
import org.loose.fis.sre.exceptions.AccException;
import org.loose.fis.sre.model.ProgramName;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.ProgramService;
import static org.loose.fis.sre.services.ProgramService.workout;
import static org.loose.fis.sre.services.ProgramService.findClient;
import java.io.IOException;


public class ClientDoneController {

    @FXML
    private TextField done;
    @FXML
    private TextField prognamefield;

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientViewPrograms.fxml");
    }

    public void handleDoneButton() {
        String thisname = User.getCurrentUser();

    }


}
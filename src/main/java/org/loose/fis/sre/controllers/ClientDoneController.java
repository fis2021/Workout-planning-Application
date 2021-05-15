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

        if (ProgramService.findClient(ProgramService.getProgramName(prognamefield.getText()),thisname)==-1)
        {
            done.setText("You're not enrolled to this program");
        }
        else
        {
            done.setText(ProgramService.workout(ProgramService.getProgramName(prognamefield.getText()),ProgramService.findClient(ProgramService.getProgramName(programnemfield.getText()),thisname)));
        }
        done.setStyle("-fx-text-fill: red");

    }


}
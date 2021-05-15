package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.loose.fis.sre.Main;
import org.loose.fis.sre.model.ProgramName;
import org.loose.fis.sre.services.ProgramService;

import static org.loose.fis.sre.services.ProgramService.programNamelist;
import static org.loose.fis.sre.services.ProgramService.programIntensitylist;
import static org.loose.fis.sre.services.ProgramService.programDurationlist;

import java.io.IOException;
import java.util.Objects;

public class ClientProgressController {



    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientHome.fxml");
    }


}
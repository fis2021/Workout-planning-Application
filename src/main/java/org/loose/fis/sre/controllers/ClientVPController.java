package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.loose.fis.sre.Main;
import org.loose.fis.sre.model.ProgramName;
import org.loose.fis.sre.services.ProgramService;

import java.io.IOException;

public class ClientVPController {

    @FXML
    private TableView<ProgramName> table;
    @FXML
    private TableColumn<ProgramName,String> colname;
    @FXML
    private TableColumn <ProgramName,String>  colintensity;
    @FXML
    private TableColumn <ProgramName,String> colduration;

    public void initialize(){
        colname.setCellValueFactory(new PropertyValueFactory<ProgramName,String>("name"));
        colintensity.setCellValueFactory(new PropertyValueFactory<ProgramName,String>("intensity"));
        colduration.setCellValueFactory(new PropertyValueFactory<ProgramName,String>("duration"));
        table.getColumns().add(colname);
        table.getColumns().add(colintensity);
        table.getColumns().add(colduration);
        for (ProgramName helper : ProgramService.programNames()){
            table.getItems().add(helper);
        }
    }

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientHome.fxml");
    }

    public void handleWorkoutButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientDone.fxml");
    }

    public void handleEnrollButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientEnroll.fxml");
    }
}

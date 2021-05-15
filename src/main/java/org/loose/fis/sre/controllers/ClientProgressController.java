package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.loose.fis.sre.Main;
import org.loose.fis.sre.model.ProgramName;
import org.loose.fis.sre.services.ProgramService;

import static org.loose.fis.sre.services.ProgramService.programNames;
import static org.loose.fis.sre.services.ProgramService.programIntensitylist;
import static org.loose.fis.sre.services.ProgramService.programDurationlist;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ClientProgressController {

    @FXML
    private TableView <ProgramName> table;
    @FXML
    private TableColumn <ProgramName,String> columnname;
    @FXML
    private TableColumn <ProgramName,String>  columnintensity;
    @FXML
    private TableColumn <ProgramName,String> columnprogress;

    public void initialize(){
        columnname.setCellValueFactory(new PropertyValueFactory<ProgramName,String>("name"));
        columnintensity.setCellValueFactory(new PropertyValueFactory<ProgramName,String>("intensity"));
        columnprogress.setCellValueFactory(new PropertyValueFactory<ProgramName,String>("duration"));
        table.getColumns().add(columnname);
        table.getColumns().add(columnintensity);
        table.getColumns().add(columnprogress);
        for (ProgramName helper : ProgramService.programNames()){
            table.getItems().add(helper);
        }
    }

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientHome.fxml");
    }


}
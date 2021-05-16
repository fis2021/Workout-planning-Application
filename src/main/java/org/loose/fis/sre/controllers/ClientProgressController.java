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
        columnname.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnintensity.setCellValueFactory(new PropertyValueFactory<>("intensity"));
        columnprogress.setCellValueFactory(new PropertyValueFactory<>("duration"));

        table.setItems(every);
    }

    private ObservableList<ProgramName> every = FXCollections.observableArrayList(ProgramService.programNames());
    public List<ProgramName> getProgramNamesFromTable() {
        return table.getItems();
    }

    public void handleBackButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientHome.fxml");
    }


}
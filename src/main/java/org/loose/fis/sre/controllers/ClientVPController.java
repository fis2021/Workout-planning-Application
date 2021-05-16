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
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colintensity.setCellValueFactory(new PropertyValueFactory<>("intensity"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("duration"));

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

    public void handleWorkoutButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientDone.fxml");
    }

    public void handleEnrollButton() throws IOException{
        Main x = new Main();
        x.changeWindow("ClientEnroll.fxml");
    }

}

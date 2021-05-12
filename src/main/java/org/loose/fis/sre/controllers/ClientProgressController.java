package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.ProgramName;
import org.loose.fis.sre.services.ProgramService;
import java.util.Objects;

public class ClientProgressController {

    @FXML
    private TableView<ProgramName> programTable;
    @FXML
    private TableColumn<ProgramName, String> programNameColumn;
    @FXML
    private TableColumn<ProgramName, String> intensityColumn;
    @FXML
    private TableColumn<ProgramName, Integer> programDurationColumn;


    public void initialize() {
        programNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        intensityColumn.setCellValueFactory(new PropertyValueFactory<>("intensity"));
        programDurationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        programTable.setItems(categories);

    }

    public void handleHomeButtonAction() {
        Stage window = (Stage) programTable.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Home.fxml")));
        window.setScene(new Scene(root, 600,600));
    }

    public void handleCoachesButtonAction() {
        Stage window = (Stage) programTable.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("ClientViewCoaches.fxml")));
        window.setScene(new Scene(root, 600,600));
    }

    public void handleRatingsButtonAction() {
        Stage window = (Stage) programTable.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("ClientViewRatings.fxml")));
        window.setScene(new Scene(root, 600,600));
    }

    public void handleBackButtonAction() throws Exception{
        Stage window = (Stage) programTable.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("ClientViewPrograms.fxml")));
        window.setScene(new Scene(root, 800,600));
    }

    private ObservableList<ProgramName> categories = FXCollections.observableArrayList(ProgramService.programNames());

}
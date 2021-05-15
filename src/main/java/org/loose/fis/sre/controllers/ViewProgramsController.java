package org.loose.fis.sre.controllers;

  import org.loose.fis.sre.Main;
  import java.io.IOException;

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
  import javafx.scene.control.Button;
  import org.loose.fis.sre.model.ProgramName;
  import org.loose.fis.sre.services.ProgramService;
  import java.util.List;

public class ViewProgramsController {

    @FXML
    private TableView<ProgramName> programTable;
    @FXML
    private TableColumn<ProgramName, String> programNameColumn;
    @FXML
    private TableColumn<ProgramName, String> programDurationColumn;
    @FXML
    private TableColumn<ProgramName, String> programIntensityColumn;
    @FXML
    private Button addButton;


    public void initialize() {
        programNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        programIntensityColumn.setCellValueFactory(new PropertyValueFactory<>("intensity"));
        programDurationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        programTable.setItems(categories);
    }

    public void handleAddPrograms() throws IOException {
        Main x = new Main();
        x.changeWindow("Coach_AddPrograms.fxml");
    }

    public void handleBackPrograms() throws IOException {
        Main x = new Main();
        x.changeWindow("CoachHome.fxml");
    }

    private ObservableList<ProgramName> categories = FXCollections.observableArrayList(ProgramService.programNames());
    public List <ProgramName> getProgramNamesFromTable() {
        return programTable.getItems();
    }
}
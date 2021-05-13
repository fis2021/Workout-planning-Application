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

public class ViewProgramsController {

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


    public void handleAddButtonAction() throws Exception{
        Stage window = (Stage) programTable.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addPrograms.fxml"));
        window.setScene(new Scene(root, 800,600));
    }

    public void handleDeleteNameButtonAction() {
        ObservableList<ProgramName> categoriesSelected;
        categoriesSelected = programTable.getSelectionModel().getSelectedItems();
        for(ProgramName productName : categoriesSelected) {
            ProgramService.removeName(productName);
        }
        categoriesSelected.forEach(categories::remove);
    }




    public void handleBackButtonAction() throws Exception{
        Stage window = (Stage) programTable.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("pCoach.fxml")));
        window.setScene(new Scene(root, 800,600));
    }

    private ObservableList<ProgramName> categories = FXCollections.observableArrayList(ProgramService.programNames());

}
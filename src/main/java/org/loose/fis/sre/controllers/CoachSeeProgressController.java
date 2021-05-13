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

public class CoachSeeProgressController {

    @FXML
    private TableView<ProgramName> programTable;
    @FXML
    private TableColumn<ProgramName, String> programNameColumn;
    @FXML
    private TableColumn<ProgramName, String> progressColumn;


    public void initialize() {
        programNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        progressColumn.setCellValueFactory(new PropertyValueFactory<>("progress"));

        programTable.setItems(categories);

    }

    public void handleBackButtonAction() throws Exception{
        Stage window = (Stage) programTable.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("CoachHome.fxml")));
        window.setScene(new Scene(root, 800,600));
    }

    private ObservableList<ProgramName> categories = FXCollections.observableArrayList(ProgramService.programNames());

}
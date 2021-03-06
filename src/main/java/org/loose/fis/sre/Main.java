package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.model.ProgramName;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.ProgramService;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main extends Application {

    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        initDirectory();
        UserService.initDatabase();
        ProgramService.initDatabase();
        stage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public void changeWindow(String fxml) throws IOException{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
        stage.setScene(new Scene(root, 800,600));
        stage.getScene().setRoot(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
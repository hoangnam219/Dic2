package application;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;




public class MainLunch extends Application{

    @Override
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\asus\\IdeaProjects\\dic\\src\\application\\Test.fxml"));
        Button showAllWords = (Button) root.lookup("#ShowAllWords");

        stage.show();
    }

    public static void main (String[] args) {
        //launch(args);

    }
}

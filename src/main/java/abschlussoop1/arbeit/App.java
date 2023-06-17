package abschlussoop1.arbeit;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static ObservableList<VersichertePerson> versicherungsList = FXCollections.observableArrayList();

    public App(){
        versicherungsList.add(new VersichertePerson("Stucker", "Alexander", 0));
        versicherungsList.add(new VersichertePerson("Müller", "Hans", 0));
    }

    private static Scene scene;

    public static void main(String[] args) {
        launch();
    }

        public static ObservableList<VersichertePerson> getVersichgerungsList(){
        return versicherungsList;
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setSceneRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

}

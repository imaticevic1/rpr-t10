package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller con = new Controller();
        ResourceBundle bundle = ResourceBundle.getBundle("Translation", con.getLocale());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/geografijaDAO.fxml"), bundle);
        loader.setController(con);
        Parent root = loader.load();
        primaryStage.setTitle(bundle.getString("Drzaveigradovi"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}

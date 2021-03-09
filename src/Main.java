import javafx.application.Application;
import javafx.stage.Stage;
import model.OSInterface;
import ui.mainScreen;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Initialize at main UI screen
        new mainScreen();


    }


    public static void main(String[] args) {
        Thread thread = new Thread(OSInterface.getInstance());
        thread.start();

        launch(args);

        OSInterface.getInstance().stop();
    }
}

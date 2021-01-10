package lesson6.client;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;


public class EchoClient extends Application {

    public static final List<String> USERS_TEST_DATA = List.of("Boris Nikolaevich", "Martin Nekotov", "Gandalf the White");

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(EchoClient.class.getResource("chat-view.fxml"));

        Parent root = loader.load();

        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        Network network = new Network();
//        if(!network.connect()) {
//           showErrorMessage("Проблемы с соединением", "", "Ошибка подключения к серверу");
//        }

        ViewController viewController = loader.getController();
        viewController.setNetwork(network);

//        network.waitMessage(viewController);

        primaryStage.setOnCloseRequest(windowEvent -> network.close());


    }

    public static void showErrorMessage(String title, String message, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
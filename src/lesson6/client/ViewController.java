package lesson6.client;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ViewController {

    @FXML
    public ListView<String> usersList;

    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;

    private Network network;

    public void setNetwork(Network network) {
        this.network = network;
    }

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(lesson6.client.EchoClient.USERS_TEST_DATA));
        sendButton.setOnAction(event -> ViewController.this.sendMessage());
        textField.setOnAction(event -> ViewController.this.sendMessage());
    }

    private void sendMessage() {
        String message = textField.getText();
//        appendMessage(message);
        textField.clear();

        try {
            network.getOut().writeUTF(message);

        } catch (IOException e) {
            e.printStackTrace();
            EchoClient.showErrorMessage("Ошибка подключения", "Ошибка при отправке сообщения", e.getMessage());
        }

    }

    public void appendMessage(String message) {
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
    }

}
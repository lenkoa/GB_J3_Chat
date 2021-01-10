package client.controllers;

import client.NetworkClient;
import client.models.History;
import client.models.Network;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ChatController {

    @FXML
    public ListView<String> usersList;

    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;
    @FXML
    private Label usernameTitle;

    private Network network;
    private History history;
    private String selectedRecipient;


    public void setLabel(String usernameTitle) {
        this.usernameTitle.setText(usernameTitle);
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setHistoryFile(History history) {
        this.history = history;
    }

    @FXML
    public void initialize() {
//        usersList.setItems(FXCollections.observableArrayList(NetworkClient.USERS_TEST_DATA));
        sendButton.setOnAction(event -> ChatController.this.sendMessage());
        textField.setOnAction(event -> ChatController.this.sendMessage());


        usersList.setCellFactory(lv -> {
            MultipleSelectionModel<String> selectionModel = usersList.getSelectionModel();
            ListCell<String> cell = new ListCell<>();
            cell.textProperty().bind(cell.itemProperty());
            cell.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
                usersList.requestFocus();
                if (!cell.isEmpty()) {
                    int index = cell.getIndex();
                    if (selectionModel.getSelectedIndices().contains(index)) {
                        selectionModel.clearSelection(index);
                        selectedRecipient = null;
                    } else {
                        selectionModel.select(index);
                        selectedRecipient = cell.getItem();
                    }
                    event.consume();
                }
            });
            return cell;
        });

    }

    private void sendMessage() {
        String message = textField.getText();

        if (message.isBlank()) {
            return;
        }

        appendMessage("Я: " + message);
        textField.clear();

        try {
            if (selectedRecipient != null) {
                network.sendPrivateMessage(message, selectedRecipient);
            } else {
                network.sendMessage(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
            NetworkClient.showErrorMessage("Ошибка подключения", "Ошибка при отправке сообщения", e.getMessage());
        }

    }

    public void appendMessage(String message) {
        String timestamp = DateFormat.getInstance().format(new Date());
        String msg = String.format("%s%s%s%s",
                timestamp, System.lineSeparator(), message, System.lineSeparator());
        System.lineSeparator();
        chatHistory.appendText(msg);

        try {
            history.writeMessageIntoHistory(msg);
        } catch (IOException e) {
            e.printStackTrace();
            NetworkClient.showErrorMessage("Error", "Ошибка записи в историю", e.getMessage());
        }
    }

    public void showHistory(String username) {
        List<String> messages = null;
        try {
            history.open(username);
            messages = history.readAllMessagesFromHistory();
            for (int i = Math.max(0, messages.size() - 101); i < messages.size(); i++)
                chatHistory.appendText(messages.get(i));
        } catch (IOException e) {
            e.printStackTrace();
            NetworkClient.showErrorMessage("Error", "Ошибка чтения истории", e.getMessage());
        }
    }

    public void setUsernameTitle(String username) {

    }

    public void updateUsers(List<String> users) {
        usersList.setItems(FXCollections.observableArrayList(users));
    }

}
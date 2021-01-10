package client.models;

import java.io.*;
import java.util.ArrayList;

public class History {
    private File historyFile;
    private BufferedWriter writer;

    public History() {
    }

    public void writeMessageIntoHistory(String message) throws IOException {
        String preparedMessage = message.replace("\r", "\\r").replace("\n", "\\n");
        writer.write(preparedMessage + "\n");
        writer.flush();
    }

    public ArrayList<String> readAllMessagesFromHistory() throws IOException {
        try (FileReader fr = new FileReader(historyFile)) {
            BufferedReader reader = new BufferedReader(fr);
            ArrayList<String> messages = new ArrayList<>();
            String msg = reader.readLine();
            while (msg != null) {
                messages.add(msg.replace("\\n", "\n").replace("\\r", "\r"));
                msg = reader.readLine();
            }
            return messages;
        }
    }

    public boolean open(String userName) {
        historyFile = new File(userName+".txt");
        try {
            FileWriter fw = new FileWriter(historyFile, true);
            writer = new BufferedWriter(fw);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

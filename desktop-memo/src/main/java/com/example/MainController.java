package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainController {

    @FXML
    private TextField textField;

    @FXML
    private void saveText() {
        String text = textField.getText();

        try {
            Files.writeString(
                Path.of("note.txt"),
                text
            );

            System.out.println("保存しました！");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void deleteText() {

        try {
            Files.delete(Path.of("note.txt"));

            System.out.println("削除しました！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void showMemo() {
        try {
            String memo = Files.readString(
                Path.of("note.txt")
            );

            Stage stage = new Stage();

            TextArea textArea = new TextArea();
            textArea.setText(memo);
            textArea.setEditable(false);

            stage.setScene(new Scene(textArea, 300, 200));

            stage.setTitle("保存したメモ");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

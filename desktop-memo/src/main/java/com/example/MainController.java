package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

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
}

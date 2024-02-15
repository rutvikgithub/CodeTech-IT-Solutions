package InternshipTasks;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.security.SecureRandom;

public class PasswordGeneratorApp extends Application {

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Generator");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Label lengthLabel = new Label("Password Length:");
        TextField lengthTextField = new TextField();
        lengthTextField.setPromptText("Enter length");

        Label complexityLabel = new Label("Password Complexity:");
        CheckBox lowercaseCheckBox = new CheckBox("Lowercase");
        CheckBox uppercaseCheckBox = new CheckBox("Uppercase");
        CheckBox digitsCheckBox = new CheckBox("Digits");
        CheckBox specialCharsCheckBox = new CheckBox("Special Characters");

        Button generateButton = new Button("Generate Password");
        TextArea resultTextArea = new TextArea();
        resultTextArea.setEditable(false);

        generateButton.setOnAction(e -> {
            int length = Integer.parseInt(lengthTextField.getText());
            boolean useLowercase = lowercaseCheckBox.isSelected();
            boolean useUppercase = uppercaseCheckBox.isSelected();
            boolean useDigits = digitsCheckBox.isSelected();
            boolean useSpecialChars = specialCharsCheckBox.isSelected();

            String generatedPassword = generatePassword(length, useLowercase, useUppercase, useDigits, useSpecialChars);
            resultTextArea.setText(generatedPassword);
        });

        grid.add(lengthLabel, 0, 0);
        grid.add(lengthTextField, 1, 0);
        grid.add(complexityLabel, 0, 1, 2, 1);
        grid.add(lowercaseCheckBox, 0, 2);
        grid.add(uppercaseCheckBox, 1, 2);
        grid.add(digitsCheckBox, 0, 3);
        grid.add(specialCharsCheckBox, 1, 3);
        grid.add(generateButton, 0, 4, 2, 1);
        grid.add(resultTextArea, 0, 5, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useDigits, boolean useSpecialChars) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String characters = "";
        if (useLowercase) characters += LOWERCASE_CHARS;
        if (useUppercase) characters += UPPERCASE_CHARS;
        if (useDigits) characters += DIGITS;
        if (useSpecialChars) characters += SPECIAL_CHARS;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}

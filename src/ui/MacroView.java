package ui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.controlsfx.control.textfield.TextFields;

/**
 * KeybindView is the view screen for adding a new keybind to the active profile.
 * There are two fields to enter the details of the keybind, a back button to go
 * back to the main UI, and a save button which writes the keybind to the profile.
 */
public class MacroView extends Pane {
    //The key to be pressed for the keybind action
    TextField  keyToBind = new TextField();
    //The key action once the bound buttton is pressed
    TextField keyAction = new TextField();
    //Options for selecting keys
    OptionsList lists = new OptionsList();
    //Mapping of key selections and key code integers
    KeyValueMap keyValueMap = new KeyValueMap();

    public MacroView() {
        this.setStyle("-fx-background-color: #99aab5;");
        keyAction.setLayoutX(60);
        keyAction.setLayoutY(200);
        keyAction.setStyle("-fx-background-color: #2c2f33; -fx-text-fill: white; -fx-font-size: 30; " +
                "-fx-pref-width: 400px; -fx-pref-height: 50px;");

        //Available options to select in the text fields
        String[] keyActionOptions = lists.getActionsPress();

        //Labels for the text fields
        Label keyActionLabel = new Label("Assign Action:");
        keyActionLabel.setLayoutX(60);
        keyActionLabel.setLayoutY(150);
        keyActionLabel.setStyle("-fx-text-fill: #2c2f33; -fx-font-size: 30;");

        TextFields.bindAutoCompletion(keyAction, keyActionOptions);
        this.getChildren().addAll(keyAction, keyActionLabel);

    }

    /**
     * Returns an Integer value for the Windows key code for the string representation of a key.
     * Corresponds to the resulting action when the bound key is pressed
     * @return an Integer value for the Windows key code for the string representation of a key
     */
    public Integer getKeyAction() {

        return keyValueMap.getKeyCode(keyAction.getText());
    }

}
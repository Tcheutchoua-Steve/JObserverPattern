/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackexercise;

import StackImplementation.JStack;
import StackImplementation.StackCMPrompt;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author TcheutchouaSteve
 */
public class FXMLStackViewController implements Initializable, Observer {
    
    private Label label;
    @FXML
    private TextField pushTextField;
    @FXML
    private TextField msgTextField;
    @FXML
    private Button pushButton;
    @FXML
    private Button topButton;
    @FXML
    private Button popButton;
    @FXML
    private Button emptyButton;
    @FXML
    private Button isEmptyButton;
    @FXML
    private Button isFullButton;
    @FXML
    private ListView<Integer> stackListView;
    
    ObservableList<Integer> items ;
   
    JStack stack;
    StackCMPrompt stackCmPrompt ;
    @FXML
    private Button createButton;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pushButton.setVisible(false);
        topButton.setVisible(false);
        popButton.setVisible(false);
        isEmptyButton.setVisible(false);
        isFullButton.setVisible(false);
        emptyButton.setVisible(false);
        pushTextField.setVisible(false);
        // TODO
        items = stackListView.getItems();
        stackListView.setVisible(false);
    }    

    @FXML
    private void pushButtonFired(ActionEvent event) {
        //mStack.push(Integer.valueOf(pushTextField.getText()));
        if(!pushTextField.getText().trim().isEmpty()){
        stack.push(Integer.valueOf(pushTextField.getText()));
        try {
            items.add(0,stack.top());
            pushTextField.clear();
        } catch (Exception ex) {
            giveMessage(AlertType.ERROR, "No Element To ADD", "Add An Element", ex.getMessage());
        }
       }
        else 
            giveMessage(AlertType.ERROR, "No Element To ADD", "Add An Element", "Input field should not be empty");
    }

    @FXML
    private void topButtonFired(ActionEvent event) {
        try {
            giveMessage(AlertType.INFORMATION,"TOP Button","Top Button requested","Top Button is " + stack.top());
        } catch (Exception ex) {
            giveMessage(AlertType.ERROR, "TOP Element", "No Top Element", ex.getMessage());
        }
    }

    @FXML
    private void popButtonFired(ActionEvent event) {
        //Dialogs.create().title("Pop Button").message("Top Value is" + items.get(0)).showInformation();
        if(!stack.isEmpty()) {
            stack.pop();
            items.remove(0);
        }
        else 
            giveMessage(AlertType.ERROR, "POP ACIION", "No item to remove", "Please insert an item before removing");
    }

    @FXML
    private void emptyButtonClicked(ActionEvent event) {
        stack.empty();
        items.clear();
    }

    @FXML
    private void isEmptyButtonClicked(ActionEvent event) {
        //()
        if(stack.isEmpty())
            giveMessage(AlertType.ERROR, "ISEMPTY BUTTON", "Stack Empty", "Your Stack is emtpy");
        else 
            giveMessage(AlertType.ERROR, "ISEMPTY BUTTON", "Stack Not Empty", "Your Stack is NOT emtpy");

    }

    @FXML
    private void isFullButtonClicked(ActionEvent event) {
        if(stack.isFull())
            giveMessage(AlertType.ERROR, "ISFULL BUTTON", "Stack full", "Your Stack is full");
        else 
            giveMessage(AlertType.ERROR, "ISFULL BUTTON", "Stack Not full", "Your Stack is Not full");
    }

    @FXML
    private void createButtonFired(ActionEvent event) {
        pushButton.setVisible(true);
        topButton.setVisible(true);
        popButton.setVisible(true);
        isEmptyButton.setVisible(true);
        isFullButton.setVisible(true);
        emptyButton.setVisible(true);
        pushTextField.setVisible(true);
        
        stackListView.setVisible(true);
       stack = JStack.create();
       this.stackCmPrompt = new StackCMPrompt(this.stack) ;
       this.stack.addObserver(this);
       this.stack.addObserver(stackCmPrompt);
       stackCmPrompt.start();
    }
    
    public void giveMessage(AlertType alertType, String title, String headerText, String context){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(context);

        alert.showAndWait();
    }

    @Override
    public void update(Observable o, Object arg) {
        Platform.runLater(() -> {
            System.out.println("Something happened in the Stack class " + arg);
            if (Integer.valueOf(arg.toString()) == 0) {
                try {
                    items.add(0, this.stack.top());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (Integer.valueOf(arg.toString()) == 1) {
                items.remove(0);
            } else {
                items.clear();
            }
        });
    }
}

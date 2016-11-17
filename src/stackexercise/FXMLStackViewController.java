/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackexercise;

import StackImplementation.JStack;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FXMLStackViewController implements Initializable {
    
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
   
    JStack mStack;
    @FXML
    private Button createButton;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        items = stackListView.getItems();
        stackListView.setVisible(false);
    }    

    @FXML
    private void pushButtonFired(ActionEvent event) {
        //mStack.push(Integer.valueOf(pushTextField.getText()));
        
        mStack.push(Integer.valueOf(pushTextField.getText()));
        
        try {
            items.add(0,mStack.top());
            pushTextField.clear();
        } catch (Exception ex) {
            giveMessage(AlertType.ERROR, "No Element To ADD", "Add An Element", ex.getMessage());
        }
    }

    @FXML
    private void topButtonFired(ActionEvent event) {
        try {
            giveMessage(AlertType.INFORMATION,"TOP Button","Top Button requested","Top Button is " + mStack.top());
        } catch (Exception ex) {
            giveMessage(AlertType.ERROR, "TOP Element", "No Top Element", ex.getMessage());
        }
    }

    @FXML
    private void popButtonFired(ActionEvent event) {
        //Dialogs.create().title("Pop Button").message("Top Value is" + items.get(0)).showInformation();
        if(!mStack.isEmpty()) {
            mStack.pop();
            items.remove(0);
        }
        else 
            giveMessage(AlertType.ERROR, "POP ACIION", "No item to remove", "Please insert an item before removing");
    }

    @FXML
    private void emptyButtonClicked(ActionEvent event) {
        mStack.empty();
        items.clear();
    }

    @FXML
    private void isEmptyButtonClicked(ActionEvent event) {
        //()
        if(mStack.isEmpty())
            giveMessage(AlertType.ERROR, "ISEMPTY BUTTON", "Stack Empty", "Your Stack is emtpy");
        else 
            giveMessage(AlertType.ERROR, "ISEMPTY BUTTON", "Stack Not Empty", "Your Stack is NOT emtpy");

    }

    @FXML
    private void isFullButtonClicked(ActionEvent event) {
        if(mStack.isFull())
            giveMessage(AlertType.ERROR, "ISFULL BUTTON", "Stack full", "Your Stack is full");
        else 
            giveMessage(AlertType.ERROR, "ISFULL BUTTON", "Stack Not full", "Your Stack is Not full");
    }

    @FXML
    private void createButtonFired(ActionEvent event) {
        stackListView.setVisible(true);
       mStack = JStack.create();
    }
    
    public void giveMessage(AlertType alertType, String title, String headerText, String context){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(context);

        alert.showAndWait();
    }
}

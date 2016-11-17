/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackexercise;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
    
   /* private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        items = stackListView.getItems();
    }    

    @FXML
    private void pushButtonFired(ActionEvent event) {
        items.add(Integer.valueOf(pushTextField.getText()));
    }

    @FXML
    private void topButtonFired(ActionEvent event) {
    }

    @FXML
    private void popButtonFired(ActionEvent event) {
    }

    @FXML
    private void emptyButtonClicked(ActionEvent event) {
    }

    @FXML
    private void isEmptyButtonClicked(ActionEvent event) {
    }

    @FXML
    private void isFullButtonClicked(ActionEvent event) {
    }
    
}

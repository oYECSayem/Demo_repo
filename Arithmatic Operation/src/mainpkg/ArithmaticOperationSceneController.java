
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ArithmaticOperationSceneController implements Initializable {

    @FXML
    private TextField xTextField;
    @FXML
    private TextField yTextField;
    @FXML
    private Label resLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addNUm(MouseEvent event) {
        String xStr = xTextField.getText();
        String yStr = yTextField.getText();
        int xVal=Integer.parseInt(xStr);
        int yVal=Integer.parseInt(yStr);
        int res = xVal + yVal;
        String resStr=Integer.toString(res);
        resLabel.setText("x + y = " + resStr);
    }

    @FXML
    private void subNum(MouseEvent event) {
        int xVal = Integer.parseInt(xTextField.getText());
        int yVal = Integer.parseInt(yTextField.getText());
        resLabel.setText("x + y = " +Integer.toString(xVal - yVal));
        
        
    }

    @FXML
    private void mulNum(MouseEvent event) {
    }

    @FXML
    private void divNum(MouseEvent event) {
    }
    
}

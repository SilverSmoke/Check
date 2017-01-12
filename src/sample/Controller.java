package sample;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Controller {

    @FXML
    private TextField market;
    @FXML
    private TextField section;
    @FXML
    private TextField transaction;
    @FXML
    private DatePicker purchaseDate;

    //public CheckNode node = new CheckNode(1);

    @FXML
    public void onClickMarket(){
        System.out.println(market.getOnMouseClicked());
        purchaseDate.setValue(LocalDate.now());
        market.setText("Готово");
    }

    @FXML
    public void setTransaction(){
        CheckNode node = new CheckNode(Integer.parseInt(transaction.getText()));
        transaction.setText("0");
    }

}

package sample;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField market;
    @FXML
    private TextField section;

    @FXML
    public void onClickMarket(){
        System.out.println(market.getOnMouseClicked());
        market.setText("Готово");
    }

}

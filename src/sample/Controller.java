package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
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
    private TextField product;
    @FXML
    private TextField price;
    @FXML
    private TextField number;
    @FXML
    private TextField sum;
    @FXML
    private TextField transaction;
    @FXML
    private DatePicker purchaseDate;

    //public CheckNode node = new CheckNode(1);
    @FXML
    public void initialize(){
        purchaseDate.setValue(LocalDate.now());
        clearPosition();
        sum.setEditable(false);
        price.addEventHandler(Event.ANY, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                handlerField(event);
            }
        });

        number.addEventHandler(Event.ANY, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                handlerField(event);
            }
        });


    }

    public void handlerField(Event event){
        System.out.println(event);
        TextField field = (TextField) event.getSource();
        System.out.println(field);
        if(event.getEventType().getName().equals("KEY_RELEASED")){
            System.out.println(event.getEventType().getName());
            try{
                calcSum();
            }catch (Exception e){
                System.out.println(e);
                field.setText(field.getText().substring(0, field.getText().length()-1));
                field.end();
            }
        }
    }

    @FXML
    private void calcSum() {
        int numb = Integer.parseInt(number.getText());
        double price = Double.parseDouble(this.price.getText());
        sum.setText(String.valueOf(numb * price));
        System.out.println("Работает");
    }

    @FXML
    public void onClickMarket(){
        //System.out.println(market.getOnMouseClicked());
        clearPosition();
    }

    @FXML
    public void setTransaction(){
        CheckNode node = new CheckNode(Integer.parseInt(transaction.getText()));
        transaction.setText("0");
    }

    @FXML
    public void savePosition(){
        try {
            CheckNode node = new CheckNode(Integer.parseInt(transaction.getText()));
            node.setMarket(market.getText());
            node.setSection(section.getText());
            node.setProduct(product.getText());
            node.setPrice(Double.parseDouble(price.getText()));
            node.setNumber(Integer.parseInt(number.getText()));
            node.setPurchaseDate(purchaseDate.getValue());
            System.out.println(node);
        }catch (Exception e){
            System.out.println("Не установлена цена!");
        }
    }

    @FXML
    public void clearPosition(){
        market.setText("-");
        section.setText("-");
        product.setText("-");
        price.setText("0.0");
        number.setText("1");
        calcSum();
    }
}

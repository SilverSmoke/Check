package sample;

import java.util.Date;

/**
 * Created by belikov.a on 12.01.2017.
 */
public class CheckNode {

    private String market;
    private String section;
    private String product;
    private double price;
    private Date purchaseDate;
    private int transaction;

    public CheckNode(int transaction){
        if(transaction == 0) {
            System.out.println("Новый элемент");
        }else if(transaction == -1){
            System.out.println("Прибыль");
        }else{
            System.out.println("Получить из базы");
            extractOfBase();
        }
    }
    
    public void setMarket(String market){
        this.market = market;
    }

    public void setSection(String section){
        this.section = section;
    }

    public void setProduct(String product){
        this.product = product;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public void setPurchaseDate(Date purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public void setTransaction(int transaction){
        this.transaction = transaction;
    }

    public String getMarket(){
        return this.market;
    }

    public String getSection(){
        return this.section;
    }

    public String getProduct(){
        return this.product;
    }

    public Double getPrice(){
        return this.price;
    }

    public Date getPurchaseDate(){
        return this.purchaseDate;
    }

    public int getTransaction(){
        return this.transaction;
    }

    public void addInBase(){
        //добавление позиции в базу
    }

    private void extractOfBase(){
        //извлечение из базы
    }


}

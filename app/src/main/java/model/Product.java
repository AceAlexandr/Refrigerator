package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shustov Alexandr on 11.12.2016.
 */

public class Product {
    private String productName;
    private String dateBegin;
    private String dateEnd;

    public Product(){

    }
    public Product(String product , String dateBeg , String dateEn ){

        this.productName = product;
        this.dateBegin = dateBeg;
        this.dateEnd = dateEn;
    }
    public Product(Product product){
        this.productName = product.productName;
        this.dateBegin = product.dateBegin;
        this.dateEnd =  product.dateEnd;
    }
    public String getDateBegin(){
        return dateBegin;
    }

    public void setDateBegin(String date){
        this.dateBegin = date;
    }

    public void setDateBegin(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        this.dateBegin=dateFormat.format(date);
    }
    public String getDateEnd(){
        return dateEnd;
    }

    public void setDateEnd(String date){
        this.dateEnd = date;
    }

    public void setDateEnd(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        this.dateEnd=dateFormat.format(date);
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    @Override
    public String toString(){
        String str;
        str = this.getProductName() + " " + this.getDateBegin().toString()+ " " + this.getDateEnd().toString();

        return str;
    }
    public String toMyString(){
        String str;
        str = this.getProductName() + System.lineSeparator() + this.getDateBegin() + System.lineSeparator() +
                this.getDateEnd() + System.lineSeparator();
        return str;
    }




}

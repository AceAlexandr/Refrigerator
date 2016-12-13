package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr Shustov on 12.12.2016.
 */

public class ProductList {

   private List<Product> productList = new ArrayList<>();



    public void addProducts(Product addProd){
        Product product = new Product(addProd);
        productList.add(product);

    }
    public void delete(Product deleteProd){
        productList.remove(deleteProd);
    }
    public void viewAllProducts(){

        for (Product item : productList ){
            System.out.println(item.getProductName()+ " " + item.getDateBegin().toString()+ " " + item.getDateEnd().toString());
        }
    }
    public List<Product> getProductList(){
        return productList;
    }
    public int size(){
        return productList.size();
    }
}

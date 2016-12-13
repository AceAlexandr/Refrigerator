package com.example.user.refrigerator;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import model.Product;
import model.ProductList;

/**
 * Created by Shustov Alexandr on 12.12.2016.
 */

public class ShowAllProducts extends AppCompatActivity {
    Product product = new Product();
    ProductList productList = new ProductList();
    final String FILENAME = "file";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products);



       textView = (TextView)findViewById(R.id.showP);
        readFile();
        String str = "";
        for(int i = 0 ; i < productList.size();i++){
            str += productList.getProductList().get(i).toMyString();
        }
        textView.setText(str);



        //System.out.println( productList.getProductList());






    }
    void readFile() {
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput(FILENAME)));
            String str;

            // читаем содержимое
             while((str = br.readLine()) != null ) {

                 System.out.println(str);
                 StringTokenizer st = new StringTokenizer(str);
                 while(st.hasMoreTokens()){
                     product.setProductName(st.nextToken());
                     product.setDateBegin(st.nextToken());
                     product.setDateEnd(st.nextToken());
                     productList.addProducts(product);
                 }




             }
            productList.viewAllProducts();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

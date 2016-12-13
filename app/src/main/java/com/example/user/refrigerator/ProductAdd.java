package com.example.user.refrigerator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import model.Product;
import model.ProductList;

/**
 * Created by Alexandr Shustov on 12.12.2016.
 */

public class ProductAdd extends AppCompatActivity {
    EditText editProductName;
    EditText editDataBegin;
    EditText editDataEnd;
    final String FILENAME = "file";
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    ProductList productList = new ProductList();
    private static final int DELAY = 2000;
    TextView text;
    Product product = new Product();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
        addProduct();





    }

    public void backToMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addProduct() {
        editProductName = (EditText) findViewById(R.id.editProductName);
        editDataBegin = (EditText) findViewById(R.id.editDateBegin);
        editDataEnd = (EditText) findViewById(R.id.editDateEnd);


        final Button addProd = (Button) findViewById(R.id.addProduct);
        addProd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View w) {

                product.setProductName(editProductName.getText().toString());
                product.setDateBegin(editDataBegin.getText().toString());
                product.setDateEnd(editDataEnd.getText().toString());



                productList.addProducts(product);
                writeFile(" " + product.toString() + " ");




                System.out.println(product.getProductName());
                System.out.println(product.getDateBegin().toString());
                System.out.println(product.getDateEnd().toString());
                editProductName.setText("");
                editDataBegin.setText("");
                editDataEnd.setText("");
                Toast toast =  Toast.makeText(getApplicationContext() , "Продукт успешно добавлен!" , Toast.LENGTH_LONG);
                toast.show();
                productList.viewAllProducts();






            }

        });

    }
    public void writeFile(String str){
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_APPEND)));
            // пишем данные
            bw.write(str);
            // закрываем поток
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






}




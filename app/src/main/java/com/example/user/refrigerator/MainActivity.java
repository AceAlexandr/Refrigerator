package com.example.user.refrigerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void addProduct(View view){
        Intent intent = new Intent(this, ProductAdd.class);
        startActivity(intent);


    }
    public void showProduct(View view){
        Intent intent = new Intent(this, ShowAllProducts.class);
        startActivity(intent);
    }
    //создать текстовик и туда записывать туда добавленный продукт
    //после завершениядобавки открыть текстовик и добавить все продукты

}

package com.example.candyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quant = 0;
    Spinner spinner;
    ArrayList spinnerArray;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    String goodsName;
    double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         createSpinner();
         createMap();

    }

    void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArray = new ArrayList();
        spinnerArray.add("M&M's");
        spinnerArray.add("Kit Kat");
        spinnerArray.add("Charms Blow Pops");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }
     void createMap() {
         goodsMap = new HashMap();
         goodsMap.put("M&M's", 20.0);
         goodsMap.put("Kit Kat", 11.0);
         goodsMap.put("Charms Blow Pops", 63.0);

     }

    public void increaseQuant(View view) {
        quant = quant + 1;
        TextView price4 = findViewById(R.id.price4);
        price4.setText(" " + quant);
        TextView priceTextView  = findViewById(R.id.price2);
        priceTextView.setText(" " + quant * price);
    }

    public void decreaseQuant(View view) {
        quant = quant - 1;
        if(quant < 0) {
            quant = 0;
        }
        TextView price4 = findViewById(R.id.price4);
        price4.setText(" " + quant);
        TextView priceTextView  = findViewById(R.id.price2);
        priceTextView.setText(" " + quant * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       goodsName = spinner.getSelectedItem().toString();
       price = (double)goodsMap.get(goodsName);
       TextView priceTextView  = findViewById(R.id.price2);
       priceTextView.setText(" " + quant * price);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);
        switch (goodsName) {
            case "M&M's":
                goodsImageView.setImageResource(R.drawable._8525_a);
                break;
            case "Kit Kat":
                goodsImageView.setImageResource(R.drawable.kitkat);
                break;
            case "Charms Blow Pops":
                goodsImageView.setImageResource(R.drawable.blow);
                break;
            default:
                goodsImageView.setImageResource(R.drawable._8525_a);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
package com.cursoandroid.ph.alcoolgasolina;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText inputAlcool, inputGas;
    private TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputAlcool = findViewById(R.id.inputAlcool);
        inputGas = findViewById(R.id.inputGas);
        textResult = findViewById(R.id.textViewResult);
    }

    public void calcBestPrice (View view) {
        String priceAlcool = inputAlcool.getText().toString();
        String priceGas = inputGas.getText().toString();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Alerta!");
        alert.setMessage("Digite o preço dos dois combustíveis.");
        alert.setCancelable(false);
        alert.setIcon(R.drawable.kisspngiconsgasoline);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        if (!validateInputs(priceAlcool, priceGas)) {
            alert.show();
        } else {
            double priceAlc = Double.parseDouble(priceAlcool);
            double priceG = Double.parseDouble(priceGas);
            if (priceAlc / priceG >= 0.7) {
                textResult.setText("Melhor utilizar gasolina.");
            } else {
                textResult.setText("Melhor utilizar álcool.");
            }
        }
    }

    public boolean validateInputs (String priceAlcool, String priceGas) {
        boolean validate = true;
        if(priceAlcool == null || priceGas.equals("")) {
           validate = false;
        } else if (priceGas == null || priceGas.equals("")){
            validate = false;
        }
        return validate;
    }

}
package com.example.trabalho2mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button btnVoltarI, btnVoltarF, btnCalcI, btnCalcF, btnImc, btnF;
    EditText edtAlt, edtPeso, edtCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarregarTelaPrincipal();
    }

    public void CarregarTelaPrincipal(){
        setContentView(R.layout.activity_main);
        btnImc = findViewById(R.id.btnImc);
        btnF = findViewById(R.id.btnF);

        btnImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaIMC();
            }
        });

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaF();
            }
        });
    }

    public void CarregarTelaIMC(){
        setContentView(R.layout.imc);
        btnCalcI = findViewById(R.id.btnCalcI);
        btnVoltarI = findViewById(R.id.btnVoltarI);
        edtAlt = findViewById(R.id.edtAlt);
        edtPeso = findViewById(R.id.edtPeso);

        btnCalcI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Verification = edtAlt.getText().toString();
                String num2Verification = edtPeso.getText().toString();
                double alt = 0, peso = 0;
                boolean podeCalc = true;

                if(TextUtils.isEmpty(num1Verification))
                {
                    podeCalc = false;
                    edtAlt.setError("Este campo é obrigatório");
                } else {
                    alt = Double.parseDouble(edtAlt.getText().toString());
                }
                if(TextUtils.isEmpty(num2Verification))
                {
                    podeCalc = false;
                    edtPeso.setError("Este campo é obrigatório");
                } else {
                    peso = Double.parseDouble(edtPeso.getText().toString());
                }
                if(podeCalc)
                {
                    double result = peso/(alt*alt);
                    String msg = "";

                    if(result < 17){
                        msg = "Muito Abaixo do Peso";
                    } else if(result < 18.5){
                        msg = "Abaixo do Peso";
                    } else if(result < 25){
                        msg = "Peso Normal";
                    } else if(result < 30){
                        msg = "Acima do peso";
                    } else if(result < 35){
                        msg = "Obesidade Grau I";
                    }else if(result < 40){
                        msg = "Obesidade Grau II";
                    }else{
                        msg = "Obesidade Grau III";
                    }

                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Resultado");
                    dialog.setMessage(msg);
                    dialog.setNeutralButton("Fechar", null);
                    dialog.show();

                }

            }
        });

        btnVoltarI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });
    }

    public void CarregarTelaF(){
        setContentView(R.layout.fahrenheit);
        btnCalcF = findViewById(R.id.btnCalcF);
        btnVoltarF = findViewById(R.id.btnVoltarF);
        edtCelsius = findViewById(R.id.edtCelsius);

        btnCalcF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numVerification = edtCelsius.getText().toString();
                boolean podeCalc = true;
                double celsius = 0, fahr = 0;
                if(TextUtils.isEmpty(numVerification))
                {
                    podeCalc = false;
                    edtCelsius.setError("Este campo é obrigatório");
                } else{
                    celsius = Double.parseDouble(edtCelsius.getText().toString());
                    fahr = (celsius*1.8) + 32;
                }

                if(podeCalc)
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Resultado");
                    dialog.setMessage("O Resultado é: " + fahr +" Fahrenheit");
                    dialog.setNeutralButton("Fechar", null);
                    dialog.show();
                }
            }
        });

        btnVoltarF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CarregarTelaPrincipal();
            }
        });

    }
}
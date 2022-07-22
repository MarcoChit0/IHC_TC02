package com.example.tarefa01questao01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultado = findViewById(R.id.Resultado);
        Button button = (Button) findViewById(R.id.Somar);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText xEditText = (EditText) findViewById(R.id.X);
                int x = Integer.parseInt(xEditText.getText().toString());

                EditText yEditText = (EditText) findViewById(R.id.Y);
                int y = Integer.parseInt(yEditText.getText().toString());

                int soma = x + y;
                resultado.setText("Resultado: " + String.valueOf(soma));
            }
        });
    }
}
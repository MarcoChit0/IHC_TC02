package com.example.tarefa01questao02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Tela02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);

        String textoTela01 = getIntent().getStringExtra("keytexto");
        TextView textoTela02 = findViewById(R.id.TextoTela02);
        textoTela02.setText(textoTela01);
    }
}
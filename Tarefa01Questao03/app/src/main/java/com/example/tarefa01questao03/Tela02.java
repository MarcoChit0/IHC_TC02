package com.example.tarefa01questao03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tela02 extends AppCompatActivity {
    TextView textoTela02;
    Button botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra_tela);

        Intent intent = getIntent();
        String textoTela01 = intent.getExtras().getString("keytexto");
        textoTela02 = findViewById(R.id.textoTela02);
        textoTela02.setText(textoTela01);

        botaoVoltar = findViewById(R.id.botaoVoltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
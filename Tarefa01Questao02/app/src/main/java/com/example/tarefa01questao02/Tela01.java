package com.example.tarefa01questao02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText textoTela01 = findViewById(R.id.TextoTela01);
        Button enviar = findViewById(R.id.Enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = textoTela01.getText().toString();
                Intent intent = new Intent(Tela01.this, Tela02.class);
                intent.putExtra("keytexto", texto);
                startActivity(intent);
            }
        });
    }
}
package com.example.tarefa01questao03;

import static java.lang.Math.abs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Tela01 extends AppCompatActivity implements SensorEventListener {
    Intent intent;
    private static final String TAG = "Tela01";
    public final String texto = "Mudei de tela :)";
    private SensorManager sensorManager;
    Sensor accelerometer;
    float x = 0.0f, y = 0.0f, z = 0.0f;
    static final float VALOR_TRANSICAO_ABRUPTA = 3.71f;
    TextView textViewX, textViewY, textViewZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(Tela01.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        textViewX = findViewById(R.id.textoX);
        textViewY = findViewById(R.id.textoY);
        textViewZ = findViewById(R.id.textoZ);

        AtualizaCoordenadas();
        Log.d(TAG, "onCreate: Registered accelerometer listener");
        intent = new Intent(this, Tela02.class);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x -= sensorEvent.values[0];
        y -= sensorEvent.values[1];
        z -= sensorEvent.values[2];

        if(abs(x) >= VALOR_TRANSICAO_ABRUPTA || abs(y) >= VALOR_TRANSICAO_ABRUPTA || abs(z) >= VALOR_TRANSICAO_ABRUPTA) {
            Tela01.this.intent.putExtra("keytexto", Tela01.this.texto);
            Tela01.this.startActivity(Tela01.this.intent);
        }

        Log.d(TAG, "onSensorChanged X: " + sensorEvent.values[0] + "/  onSensorChanged Y: " + sensorEvent.values[1] + "/  onSensorChanged Z: " + sensorEvent.values[2] );
        x = sensorEvent.values[0];
        y = sensorEvent.values[1];
        z = sensorEvent.values[2];
        AtualizaCoordenadas();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void AtualizaCoordenadas(){
        textViewX.setText("X: " +   x);
        textViewY.setText("Y: " +   y);
        textViewZ.setText("Z: " +   z);
    }


}
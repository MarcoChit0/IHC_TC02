package com.example.tarefa02;

import static java.lang.Math.abs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    Sensor light, magneticField;
    TextView lightText, magneticFieldText, longitudeText, latitudeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(MainActivity.this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);

        magneticField = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(MainActivity.this, magneticField, SensorManager.SENSOR_DELAY_NORMAL);

        lightText = findViewById(R.id.lightText);
        magneticFieldText = findViewById(R.id.magneticFieldText);
        latitudeText = findViewById(R.id.latitudeText);
        longitudeText = findViewById(R.id.longitudeText);

        GPSTracker g = new GPSTracker(getApplicationContext());
        Location l = g.getLocation();
        if(l!=null)
        {
            double lat = l.getLatitude();
            double lon = l.getLongitude();
            latitudeText.setText("Latitude: " + lat);
            longitudeText.setText("Longitude: " + lon);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightText.setText("Light: " + sensorEvent.values[0]);
        }
        if(sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magneticFieldText.setText("MF: " + sensorEvent.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

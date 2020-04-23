package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class IsikSensor extends AppCompatActivity implements SensorEventListener {

    TextView tvIsıkSensor;
    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isik_sensor);
        tvIsıkSensor=findViewById(R.id.tvIsikSensor);
        sensorManager=(SensorManager) getSystemService(Service.SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_LIGHT){
            if (event.values[0]>5000){
                tvIsıkSensor.setBackgroundColor(Color.WHITE);
                tvIsıkSensor.setTextColor(Color.BLACK);
            }
            else{
                tvIsıkSensor.setBackgroundColor(Color.BLACK);
                tvIsıkSensor.setTextColor(Color.WHITE);
            }
            tvIsıkSensor.setText("Işık Sensörü Değeri:"+event.values[0]);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

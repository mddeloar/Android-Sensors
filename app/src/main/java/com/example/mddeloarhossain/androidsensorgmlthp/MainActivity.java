package com.example.mddeloarhossain.androidsensorgmlthp;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "MainActivity";

    private SensorManager sensorManager;

    private Sensor accelerometer, mGyro, mMagno, mLight, mPressure, mTemp, mHumi, mproximity;
    TextView xValue, yValue, zValue, xGyroValue, yGyroValue, zGyroValue, xMagnoValue, yMagnoValue, zMagnoValue, light, pressure, temp, humi, proximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        zValue = findViewById(R.id.zValue);

        xGyroValue = findViewById(R.id.xGyroValue);
        yGyroValue = findViewById(R.id.yGyroValue);
        zGyroValue = findViewById(R.id.zGyroValue);

        xMagnoValue = findViewById(R.id.xMagnoValue);
        yMagnoValue = findViewById(R.id.yMagnoValue);
        zMagnoValue = findViewById(R.id.zMagnoValue);

        light = findViewById(R.id.light);
        pressure = findViewById(R.id.pressure);
        temp = findViewById(R.id.temp);
        humi = findViewById(R.id.humi);
        proximity = findViewById(R.id.proximity);

        Log.d(TAG, "onCreate: Initializing Sensor Services.");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(accelerometer != null){
            sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered accelerometer listener.");
        }else{
            xValue.setText("Accelerometer Not Supported");
            yValue.setText("Accelerometer Not Supported");
            zValue.setText("Accelerometer Not Supported");
        }

        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(mGyro != null){
            sensorManager.registerListener( MainActivity.this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered GYROSCOPE listener.");
        }else{
            xGyroValue.setText("GYROSCOPE Not Supported");
            yGyroValue.setText("GYROSCOPE Not Supported");
            zGyroValue.setText("GYROSCOPE Not Supported");
        }

        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if(mMagno != null){
            sensorManager.registerListener( MainActivity.this, mMagno, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered MAGNETIC_FIELD listener.");
        }else{
            xMagnoValue.setText("MAGNETIC_FIELD Not Supported");
            yMagnoValue.setText("MAGNETIC_FIELD Not Supported");
            zMagnoValue.setText("MAGNETIC_FIELD Not Supported");
        }

        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(mLight != null){
            sensorManager.registerListener( MainActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered LIGHT listener.");
        }else{
            light.setText(" Light: Not Supported");

        }

        mPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if(mPressure != null){
            sensorManager.registerListener( MainActivity.this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered PRESSURE listener.");
        }else{
            pressure.setText(" Pressure: Not Supported");

        }

        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(mTemp != null){
            sensorManager.registerListener( MainActivity.this, mTemp, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered AMBIENT_TEMPERATURE listener.");
        }else{
            temp.setText(" Ambient Temparature: Not Supported");

        }

        mHumi = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if(mHumi != null){
            sensorManager.registerListener( MainActivity.this, mHumi, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: Registered RELATIVE_HUMIDITY listener.");
        }else{
            humi.setText(" Realative Humadity: Not Supported");

        }

        mproximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(mproximity != null){
            sensorManager.registerListener( MainActivity.this, mproximity, 2*1000*1000);
            Log.d(TAG, "onCreate: Registered TYPE_PROXIMITY listener.");
        }else{
            proximity.setText(" Proximity: Not Supported");

        }

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Sensor sensor = sensorEvent.sensor;
        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2]);

            xValue.setText("x: " + sensorEvent.values[0]);
            yValue.setText(",y: " + sensorEvent.values[1]);
            zValue.setText(",z: " + sensorEvent.values[2]);
        }else if(sensor.getType() == Sensor.TYPE_GYROSCOPE){
            Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2]);

            xGyroValue.setText("xG: " + sensorEvent.values[0]);
            yGyroValue.setText(",yG: " + sensorEvent.values[1]);
            zGyroValue.setText(",zG: " + sensorEvent.values[2]);
        }else if(sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2]);

            xMagnoValue.setText("xM: " + sensorEvent.values[0]);
            yMagnoValue.setText(",yM: " + sensorEvent.values[1]);
            zMagnoValue.setText(",zM: " + sensorEvent.values[2]);
        }else if(sensor.getType() == Sensor.TYPE_LIGHT){
            light.setText(" Light: " + sensorEvent.values[0]);
        }else if(sensor.getType() == Sensor.TYPE_PRESSURE){
            pressure.setText(" Pressure: " + sensorEvent.values[0]);
        }else if(sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            temp.setText(" Temparature: " + sensorEvent.values[0]);
        }else if(sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY){
            humi.setText(" Humidity: " + sensorEvent.values[0]);
        }else if(sensor.getType() == Sensor.TYPE_PROXIMITY){
            if(sensorEvent.values[0]<mproximity.getMaximumRange()){
                proximity.setText(" Proximity: Detected");
                proximity.setBackgroundColor(Color.RED);
            }else {
                proximity.setText(" Proximity: Not Detected");
                proximity.setBackgroundColor(Color.GREEN);
            }
        }

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

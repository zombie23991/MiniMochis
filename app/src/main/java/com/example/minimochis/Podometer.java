package com.example.minimochis;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Podometer extends Fragment implements SensorEventListener {

    private SensorManager sensorManager;
    TextView textView;
    Sensor mStepCounter;
    boolean isConuterSensorPresent;
    FloatingActionButton buttontext;
    int stepcounter = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_podometro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
         textView = getView().findViewById(R.id.tv_stepsTaken);

         if (sensorManager.getDefaultSensor((Sensor.TYPE_STEP_COUNTER)) != null) {
              mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
              isConuterSensorPresent = true;
         } else {
            textView.setText("Not Found");
             isConuterSensorPresent = false;
         }

        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){ //ask for permission

            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);

        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mStepCounter) {
            stepcounter = (int) sensorEvent.values[0];
            textView.setText(String.valueOf(stepcounter));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!= null) {
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!= null) {
            sensorManager.unregisterListener(this,mStepCounter);
        }

        }
}

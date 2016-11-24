package ca.brocku.as12ga.sensorexample;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    SensorManager mSensorManager;
    TextView total, list;
    List<Sensor> listSensor;
    int numSensors;
    String[] sensorTypes;

    // When we create the app.
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_sensor);

        total = (TextView) findViewById(R.id.total);
        list = (TextView) findViewById(R.id.list);
        list.setMovementMethod(new ScrollingMovementMethod());

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        listSensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        numSensors = listSensor.size();
        sensorTypes = getResources().getStringArray(R.array.sensorType);

        total.append("Number of Sensors: " + numSensors);
        for(int i = 0; i < numSensors; i++) {
            list.append("Name: " + listSensor.get(i).getName() + "\nType: " + sensorTypes[listSensor.get(i).getType()] + "\nBrand: " + listSensor.get(i).getVendor());
            if (i < numSensors - 1){
                list.append("\n\n");
            }
        }
    }

    // The intent function to "proceed" to the next activity.
    public void proceed(View view) {
        Intent intent = new Intent(this, ProximitySensor.class);
        startActivity(intent);
    }

}
package ca.brocku.as12ga.sensorexample;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    SensorManager mSensorManager;
    TextView total, list;
    List<Sensor> listSensor;
    int numSensors;
    String[] sensorTypes;

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
            list.append("Name: " + listSensor.get(i).getName() + "\nType: " + sensorTypes[listSensor.get(i).getType()] + "\nBrand: " + listSensor.get(i).getVendor() + "\n\n");
        }
    }
}
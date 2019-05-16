package cat.tecnocampus.mobileapps.listsensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Sensor> sensorItems;
    private RecyclerView list;
    private RecyclerView.LayoutManager lm;
    private SensorManager mSensorManager;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = findViewById(R.id.userList);
        list.setHasFixedSize(true);

        lm = new LinearLayoutManager(this);
        list.setLayoutManager(lm);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorItems = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        adapter = new MyAdapter(sensorItems);
        list.setAdapter(adapter);
    }
}

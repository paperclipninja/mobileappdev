package arsze.finalapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements SensorEventListener {
    private SensorManager sensMan;
    private Sensor senAccelerometer;
    private long lastUpdate;
    private float x,y,z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensMan = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = sensMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensMan.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);

        lastUpdate=0;

    }
    protected void onPause(){
        super.onPause();
        sensMan.unregisterListener(this);
    }
    protected void onResume(){
        super.onResume();
        sensMan.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
   @Override
   public void onSensorChanged(SensorEvent event) {

       Sensor mySensor = event.sensor;
       if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
           float x = event.values[0];
           float y = event.values[1];
           float z = event.values[2];
           // Log.i("System.out", "X=" + x + " Y= " + y + " Z= " + z);
           TextView txtVw = (TextView) findViewById(R.id.POSITION);
           TextView direction = (TextView) findViewById(R.id.what);
           String eh = "TILT DIRECTION: ";
           long curTime = System.currentTimeMillis();
           if ((curTime - lastUpdate) > 100) {
               txtVw.setText("X=" + x + " Y= " + y + " Z= " + z);

                   if (x < -2) {
                       eh = eh + "RIGHT ";
                   }
                   if (x > 2) {
                       eh = eh + "LEFT ";
                   }
                   if (y < -2) {
                       eh = eh + " DOWN ";
                   }
                   if (y > 2) {
                       eh = eh + "UP";
                   }
               if (z < -2) {
                   eh ="Your phone is upside down";
               }
               direction.setText(eh);
                   long diffTime = (curTime - lastUpdate);
                   lastUpdate = (curTime);
               }
           }
       }



    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

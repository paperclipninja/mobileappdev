package arsze.widgetapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private DatePickerDialog myDatePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Calendar newCalendar= Calendar.getInstance();
        myDatePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate=Calendar.getInstance();
                newDate.set(year,monthOfYear,dayOfMonth);
                Log.i("DatePicker", year + " " + monthOfYear);
            }
        },newCalendar.get(Calendar.YEAR),newCalendar.get(Calendar.MONTH),newCalendar.get(Calendar.DAY_OF_MONTH));
        */
        TextView name=(TextView) findViewById(R.id.name);
       name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        TextView age=(TextView) findViewById(R.id.age);
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAge();
            }
        });
    }
    public void changeAge(String s)
    {
        TextView agg= (TextView)findViewById(R.id.age);
        agg.setText(s);
    }

    public void showAge()
    {
        //this handles the picker for AGE.
        //adjust this to take in the birthday paramater
        //and change the value of hte
        final Dialog d=new Dialog(MainActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog_main);
       // NumberPicker np=(NumberPicker) d.findViewById(R.id.nPick);

        Button b1=(Button) d.findViewById(R.id.button1);
        Button b2=(Button) d.findViewById(R.id.button2);
        final NumberPicker nP=(NumberPicker) d.findViewById(R.id.nPick);
        nP.setMinValue(0);
        nP.setMaxValue(20);
        List arrayL=new ArrayList<String>();
        for(int x=10; x<=30; x++){
            arrayL.add(""+x);
        }
        String[] array=new String[arrayL.size()];
        arrayL.toArray(array);
        nP.setDisplayedValues( array  );
        nP.setWrapSelectorWheel(false);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                String x=""+(nP.getValue()+10);
                changeAge(x);
                d.dismiss();
        }});
        //findDayOfWeek(x)
        //  age=parseInt(x);
        //  FINAL birtha
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();}
        });
        d.show();

    }

    public void show()
    {
        //This should be the picker for the NAME
        //Modify this to select the name/get the json file
        //and then eventually set the birthday so when the age is picked
        //it calculates what day of the week it will fall on
        final Dialog d=new Dialog(MainActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog_main);
        // NumberPicker np=(NumberPicker) d.findViewById(R.id.nPick);

        Button b1=(Button) d.findViewById(R.id.button1);
        Button b2=(Button) d.findViewById(R.id.button2);
        final NumberPicker nP=(NumberPicker) d.findViewById(R.id.nPick);
        nP.setMinValue(0);
        nP.setMaxValue(20);
        String[] array=new String[]{"Fred","Bob","Joe"};
        nP.setDisplayedValues( array  );
        nP.setWrapSelectorWheel(false);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x=nP.getValue();
                String s=nP.getDisplayedValues()[x];
                changeAge(s);
                d.dismiss();
            }});
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();}
        });
        d.show();
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

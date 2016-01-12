package arsze.listviewlabact;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source
        final ArrayList<State> arrayOfStates = new ArrayList<State>();
        // Create the adapter to convert the array to views
        final StatesAdapter adapter = new StatesAdapter(this, arrayOfStates);
        // Attach the adapter to a ListView
        final MyListView listView = (MyListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Add item to adapter
        adapter.add( new State("Delaware", "Dover","0") );
        adapter.add( new State("Virginia", "Richmond","0") );
        adapter.add( new State("Alaska", "Juneau","0") );
        adapter.add( new State("New York", "Albany","0") );
        adapter.add( new State("Idaho", "Boise","0") );
        adapter.add( new State("Wyoming", "Cheyenne","0") );
        adapter.add( new State("Maryland", "Annapolis","0") );
        adapter.add( new State("California", "Sacramento","0") );
        adapter.add( new State("New Hampshire", "Concord","0") );
        adapter.add( new State("Michigan", "Lansing","0") );
        adapter.add( new State("Massachusetts", "Boston","0") );
        adapter.add( new State("Ohio", "Columbus","0") );
        adapter.add( new State("Kentucky", "Frankfort","0") );
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
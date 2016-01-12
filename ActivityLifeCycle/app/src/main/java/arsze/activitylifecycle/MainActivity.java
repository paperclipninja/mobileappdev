package arsze.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    int onstart;
    int onresume,oncreate, onpause,onstop, onrestart, ondestroy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oncreate++;
        final TextView textViewToChange = (TextView) findViewById(R.id.create);
        textViewToChange.setText(
                "onCreate: "+oncreate);

        final Button topButton = (Button) findViewById(R.id.changeActiv);
        topButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyActivity2.class);
                startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onstart++;
        final TextView textViewToChange = (TextView) findViewById(R.id.start);
        textViewToChange.setText(
                "onStart: "+onstart);
    }

    @Override
    protected void onResume() {
        super.onResume();
        onresume++;
        final TextView textViewToChange = (TextView) findViewById(R.id.resume);
        textViewToChange.setText(
                "onResume: "+onresume);
    }

    @Override
    protected void onPause() {
        super.onPause();
        onpause++;
        final TextView textViewToChange = (TextView) findViewById(R.id.pause);
        textViewToChange.setText(
                "onPause: "+onpause);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onrestart++;
        final TextView textViewToChange = (TextView) findViewById(R.id.restart);
        textViewToChange.setText(
                "onRestart: "+onrestart);
    }

    @Override
    protected void onStop() {
        super.onStop();
        onstop++;
        final TextView textViewToChange = (TextView) findViewById(R.id.stop);
        textViewToChange.setText(
                "onStop: "+onstop);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ondestroy++;
        final TextView textViewToChange = (TextView) findViewById(R.id.destroy);
        textViewToChange.setText(
                "onDestroy: "+ondestroy);

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

package arsze.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Arianna on 3/18/2015.
 */

public class MyActivity2 extends Activity {

    TextView textViewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);

        textViewOne = (TextView) findViewById(R.id.myTextView);

        Intent receiveIntent = getIntent();
        textViewOne.setText(
                receiveIntent.getStringExtra(MyActivity.INTENT_DATA)
        );
    }
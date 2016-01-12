package arsze.tabswithswipe;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Arianna on 5/7/2015.
 */
public class Timer extends CountDownTimer {
    private TextView  timeElapsedView;
    private long startTime, timeElapsed;
    public Timer(long startT, long interval, TextView timeView)
    {
        super(startT, interval);
        startTime=startT;
        timeElapsed=0;
       // text=txt;
        timeElapsedView=timeView;
        Log.i("System.out", "startT= " + startT);
    }
    @Override
    public void onFinish()
    {
       // text.setText("Time's up!");
        timeElapsedView.setText("" + 0);
    }

    @Override
    public void onTick(long millisUntilFinished)
    {
        Log.i("System.out","Mil until fin"+millisUntilFinished);
        timeElapsedView.setText(""+ (int)(millisUntilFinished/1000));
        //timeElapsed = startTime - millisUntilFinished;
        //timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
    }


}

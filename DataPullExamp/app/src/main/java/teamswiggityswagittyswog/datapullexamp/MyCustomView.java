package teamswiggityswagittyswog.datapullexamp;

/**
 * Created by Arianna on 3/11/2015.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MyCustomView extends TextView{
    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        setText("text");
        return false;
    }
    */

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        GenericDownloader genericDownloader = new GenericDownloader() {
            @Override
            protected void onPostExecute(String result) {
                setText(result);
            }
        };
        genericDownloader.execute("http://www.tjhsst.edu/~pckosek/");
        return false;
    }

}
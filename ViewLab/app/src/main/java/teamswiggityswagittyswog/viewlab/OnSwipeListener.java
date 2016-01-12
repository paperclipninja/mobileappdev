package teamswiggityswagittyswog.viewlab;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Arianna on 2/11/2015.
 */
public class OnSwipeListener implements View.OnTouchListener {
   private GestureDetector gestureDetector;
    public onSwipeTouchListener(Context c){
        gestureDetector=new GestureDetector(c,new GestureListener());
    }
    public boolean onTouch(final View view, final MotionEvent motionEvent){
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public final class GestureListener extends GestureDetector.SimpleOnGestureListener{
        private static final int SWIPE_THRESHOLED=100;
        private static final int SWIPE_VELOCITY_THRESHOLD=100;
        @Override
    }

}

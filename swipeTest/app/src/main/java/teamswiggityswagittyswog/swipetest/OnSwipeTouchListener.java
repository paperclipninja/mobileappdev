package teamswiggityswagittyswog.swipetest;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Arianna on 2/27/2015.
 */
/*

Usage:

  myView.setOnTouchListener(new OnSwipeTouchListener(this) {
    @Override
    public void onSwipeDown() {
      Toast.makeText(MainActivity.this, "Down", Toast.LENGTH_SHORT).show();
    }
  }

*/
public class OnSwipeTouchListener implements View.OnTouchListener {

    private GestureDetector gestureDetector;

    public OnSwipeTouchListener(Context c) {
        gestureDetector = new GestureDetector(c, new GestureListener());
    }

    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            onMySingleTap(e);
            return false;
        }

        // Determines the fling velocity and then fires the appropriate swipe event accordingly
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try{
                float dify=e2.getY()-e1.getY();
                float diffx=e2.getX()-e1.getX();
                if(Math.abs(dify)>Math.abs(diffx)){
                    if(Math.abs(dify)> SWIPE_THRESHOLD && Math.abs(velocityX)>SWIPE_VELOCITY_THRESHOLD){
                        if (dify>0){onSwipeUp();}
                        else{onSwipeDown();}
                }
            }}
                catch(Exception exception){exception.printStackTrace();}
            return result;
        }
    }
public void onSwipeUp(){}
    public void onSwipeDown(){}
    public void onMySingleTap(MotionEvent e) {}
}

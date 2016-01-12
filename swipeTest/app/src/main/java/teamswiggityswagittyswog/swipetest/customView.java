package teamswiggityswagittyswog.swipetest;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Arianna on 2/27/2015.
 */
public class customView extends View {
    private int  radius,x;
    private Paint paint;
    private int viewWidthHalf;
    private int viewHeightHalf;
    private float flingMin = 100;
    private float velocityMin = 100;
    private GestureDetectorCompat gDetect;

    public customView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        radius=20;
        x=0;
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);

        setOnTouchListener(new OnSwipeTouchListener(context) {
            @Override
            public void onMySingleTap(MotionEvent e) {
                changeColor();
            }
            @Override
            public void onSwipeUp(){
                incrementRadius();
            }
            @Override
            public void onSwipeDown(){
                deRadius();
            }
        });
    }
    public void changeColor()
    {
        if(x==0) {paint.setColor(android.R.color.holo_orange_light); x++;}
        if(x==1){paint.setColor(android.R.color.holo_blue_bright); x++;}
        if(x==2){paint.setColor(android.R.color.holo_purple); x=0;}
        postInvalidate();

    }
    public void deRadius()
    {
        if(radius>=10)
        radius-=10;
        postInvalidate();
    }
    public void incrementRadius() {
        radius += 10;
        postInvalidate();
    }

    protected void onDraw(Canvas canvas){
        viewWidthHalf=this.getMeasuredWidth()/2;
        viewHeightHalf=this.getMeasuredHeight()/2;
        canvas.drawCircle(viewWidthHalf,viewHeightHalf,radius, paint);

    }


    /*
    @Override
    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
    }
public class GestureListener extends GestureDetector.SimpleOnGestureListener {
    //class content
    private float flingMin = 100;
    private float velocityMin = 100;


    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }
    public boolean onTouch(MotionEvent event1){
        x+=1;
        if(x==0) {paint.setColor(android.R.color.holo_orange_light);}
        if(x==1){paint.setColor(android.R.color.holo_blue_bright);}
        if(x==2){paint.setColor(android.R.color.holo_purple);}
        return true;
    }
}

    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        boolean forward = false;
        boolean backward = false;
        float horizontalDiff = event2.getX() - event1.getX();

        float verticalDiff = event2.getY() - event1.getY();
        float absHDiff = Math.abs(horizontalDiff);
        float absVDiff = Math.abs(verticalDiff);
        float absVelocityX = Math.abs(velocityX);
        float absVelocityY = Math.abs(velocityY);
        if(absHDiff>absVDiff && absHDiff>flingMin && absVelocityX>velocityMin){
            if(horizontalDiff>0) backward=true;
            else forward=true;
        }
        else if(absVDiff>flingMin && absVelocityY>velocityMin){
            if(verticalDiff>0) backward=true;
            else forward=true;
        }
        if(forward){
            radius+=1;
        }

        else if(backward){
            if (radius>1)
            {
                radius-=1;
            }
        }
        return true;
    }
*/


}
//just have it set up so that on a tap, it changes color
//right swipe; increase radius
//left swipe decrease radius


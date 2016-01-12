package teamswiggityswagittyswog.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arianna on 2/23/2015.
 */
public class DotsView extends View{
    private List myList=new ArrayList();
    private Paint myPaint;


    public DotsView( Context context, AttributeSet attrs) {
        super(context, attrs);
    myPaint=new Paint();
        setOnTouchListener(new OnTouchListener()){
            @Override
                    public boolean onTouch(View v, MotionEvent event){
               return true;
            }

        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int x=0; x<myList.length; x++)
        {
            canvas.drawCircle(radius, radius2,color )
        }
        postInvalidate();
    }


    public boolean onTouchEvent(MotionEvent event){
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            boolean result=false;

        }
        boolean result=super.onTouchEvent(event);

    }
    public void changeColor(String s)
    {
        for(int i=0; i<myList.length; i++){
            //some kind of color changing thing
        }
    }
    //on tap
    //add a new square/circle object to the array
    //on swipe
    //change the color of all the stuff


}

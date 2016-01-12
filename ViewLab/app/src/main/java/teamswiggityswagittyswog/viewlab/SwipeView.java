package teamswiggityswagittyswog.viewlab;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;


/**
 * Created by Arianna on 2/11/2015.
 */
public class SwipeView extends View{
    public SwipeView(Context context, AttributeSet attrs){
        super(context,attrs);

    setOnTouchListener(new onSwipeTouchListener(context)){
            @Override
             public void onSwipeDown() {
                        //action here
                         postInvalidate();
                     }
             public void onSwipeUp(){
                //action here
                postInvalidate();
            }
            public void
        }
    }

}

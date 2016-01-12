package arsze.listviewlabact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Arianna on 4/15/2015.
 */
public class MyListView extends ListView {
    public MyListView(Context c, AttributeSet attrs){
        super(c, attrs);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                State state = (State) parent.getItemAtPosition(position);
                state.updateTemp();
                updateAdapter();
            }
        });

        setOnTouchListener((GestureDetector.OnDoubleTapListener) (parent, view, position,id) -> {
             parent.removeItemAtPostion(position);
            updateAdapter();
            });
        }



    private void updateAdapter() {
        final StatesAdapter statesAdapter = (StatesAdapter) this.getAdapter();
        statesAdapter.notifyDataSetChanged();
    }

}


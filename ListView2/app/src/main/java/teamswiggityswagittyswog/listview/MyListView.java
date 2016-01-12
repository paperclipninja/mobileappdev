package teamswiggityswagittyswog.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Arianna on 3/13/2015.
 */
public class MyListView extends ListView{
    public MyListView(Context context, AttributeSet attrs){
        super(context, attrs);

        setOnItemClickListener(new OnItemClickListener() {
        });
    }
}

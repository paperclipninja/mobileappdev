package arsze.tabswithswipe;

/**
 * Created by Arianna on 4/24/2015.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class CountUp extends Fragment {
    private int swtch;
    private Timer tim;
    private Frag1Interface delegate;

    public interface Frag1Interface{
        public void f1BtnClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       final View rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);
        swtch=0;
       final Button btn= (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()
        {
                         public void onClick(View v){
                             TextView counterThing=(TextView) rootView.findViewById(R.id.counter);
                             if(swtch==0){
                                 btn.setText("Stop Time");
                                 swtch+=1;
                                 //put stuff to start the timer here.
                             }
                             else{
                                 swtch=0;
                                 btn.setText("Start Time");
                                 //when the timer is stopped, update the value in the countDown timer
                                 delegate.f1BtnClick();
                             }
                           //  delegate.f1BtnClick();
                         }
                               }
        );
        return rootView;
    }
//WRITE ON ATTATCH METHOD SOMEWHERE
// Store the listener (activity) that will have events fired once the fragment is attached
@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
        //try and do something
    try {
        delegate = (Frag1Interface) activity;
    } catch (ClassCastException e) {
        throw new ClassCastException(activity.toString()
                + " must implement OnHeadlineSelectedListener");
    }
}
}

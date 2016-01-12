package arsze.tabswithswipe;
//NOTE THIS IS THE OLD MOVIES FRAGMENT

/**
 * Created by Arianna on 4/24/2015.
 */
        import android.app.Activity;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;

public class CountDown extends Fragment {
    public MainActivity delegate;
    public TextView counter;
    public int num,number,swtch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       final View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        swtch=0;
        delegate=(MainActivity) getActivity();
        counter= (TextView) rootView.findViewById(R.id.count);
        num=30;//delegate.cOnt;


        final Button btn= (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()
                               {
                                   public void onClick(View v){
                                       final Timer ti= new Timer((num)*1000,1000,counter);
                                       TextView counterThing=(TextView) rootView.findViewById(R.id.counter);
                                       if(swtch==0){
                                           btn.setText("Stop Time");
                                           ti.start();
                                           swtch+=1;
                                           //put stuff to start the timer here.
                                       }
                                       else{
                                           swtch=0;
                                           Log.i("System.out","ELSE STATEMENT CALLED");
                                          // delegate.cOnt=0;
                                            num=0;
                                           btn.setText("Start Time");
                                          // countDownTimer.cancel();
                                           //when the timer is stopped, update the value in the countDown timer
                                           delegate.f1BtnClick();
                                       }
                                       //  delegate.f1BtnClick();
                                   }
                               });



       counter.setText(""+num);
       // Log.i("System.out", "CREATED");
        return rootView;
    }

    public void update(){
        if(delegate.cOnt>=num){
          //  Log.i("System.out","UPDATE");
            num=delegate.cOnt;
            counter.setText(""+num);
        }
    }

}
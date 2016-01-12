package arsze.tabswithswipe;
import arsze.tabswithswipe.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
 // private  MoviesFragment movFrag;


    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        if(index==0) {
            // Top Rated fragment activity
            return new CountUp();
        }
        else if(index==1) {
           CountDown m = new CountDown();
           // m.update();
            return m;
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }


}

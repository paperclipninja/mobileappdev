package arsze.tabswithswipe;

//import info.tabswipe.adapter.TabsPagerAdapter;
import java.util.Locale;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener, CountUp.Frag1Interface {
    public int cOnt;
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = {"Top Rated", "Count Up",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cOnt=0;
        //Log.i("System.out","COUNT GOT RESET");

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
    @Override
    public void f1BtnClick() {
        FragmentManager fragMan = getSupportFragmentManager();
        cOnt += 1;
       // Log.i("System.out", "Button click... cont=" + cOnt);
        for (Fragment frag :fragMan.getFragments()) {
         //   Log.i("System.out","for loop");
            if (frag == null) {
           //     Log.i("System.out", "Your fragment does not exist");
            }
            if (frag instanceof CountDown) {
               CountDown fragment =(CountDown) frag;
           //     Log.i("System.out", "If statement...");
                fragment.update();
            }
         else if(frag!=null) {
         //   Log.i("System.out", "SOmething went wrong");
        }

            // fragment.increment();
        }
    }


    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }


}

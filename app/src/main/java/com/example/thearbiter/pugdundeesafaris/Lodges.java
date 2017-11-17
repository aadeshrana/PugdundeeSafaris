package com.example.thearbiter.pugdundeesafaris;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thearbiter.pugdundeesafaris.Adapters.InfinitePagerAdapter;
import com.example.thearbiter.pugdundeesafaris.Adapters.SlideShowAdapter;
import com.example.thearbiter.pugdundeesafaris.Adapters.SlidingTabLayout;

public class Lodges extends AppCompatActivity {
    ViewPager viewPager;
    SlidingTabLayout tabs;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodges);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs = (SlidingTabLayout)findViewById(R.id.tabs);
        tabs.setBackgroundColor(Color.parseColor("#b0ab9c"));

        tabs.setSmoothScrollingEnabled(true);
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lodges, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;

        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] tabs={"Kings Lodge","Tree House Hideaway","Kahna Earth Lodge","Ken River Lodge","Pench","Barahi"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            MyFragment myFragment = MyFragment.getInstance(position);
            Log.d("ss", "" + position);
            return myFragment;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
    public static class MyFragment extends Fragment{

        public static MyFragment getInstance(int position){
            MyFragment myFragment = new MyFragment();
            Bundle args =  new Bundle();
            args.putInt("position",position);
            myFragment.setArguments(args);
            return myFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            TextView textView;
            Bundle bundle = getArguments();
            View layout;
            ViewPager viewPagerSlideShowCommon;
            SlideShowAdapter adaterCommon;
            switch (bundle.getInt("position")){
                case 0:
                    ViewPager viewPagerSlideShow;
                    SlideShowAdapter adater;
                    layout= inflater.inflate(R.layout.fragment_kings_lodge,container,false);
                    viewPagerSlideShow =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    adater = new SlideShowAdapter(getContext(),bundle.getInt("position"));
                    PagerAdapter wrapperAdapter = new InfinitePagerAdapter(adater);
                    viewPagerSlideShow.setAdapter(wrapperAdapter);


                 //   textView = (TextView)layout.findViewById(R.id.kingsLodgeTitle);
                  /*  Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/lobster.ttf");
                    textView.setTypeface(typeface);
*/
                    break;
                case 1:
                    ViewPager viewPagerSlideShow1;
                    SlideShowAdapter adater1;
                    layout= inflater.inflate(R.layout.fragment_tree_house,container,false);
                    viewPagerSlideShow1 =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    adater1 = new SlideShowAdapter(getContext(),bundle.getInt("position"));
                    PagerAdapter wrapperAdapter1 = new InfinitePagerAdapter(adater1);
                    viewPagerSlideShow1.setAdapter(wrapperAdapter1);
                    break;
                case 2:
                    layout= inflater.inflate(R.layout.fragment_kahna,container,false);
                   viewPagerSlideShowCommon = (ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    adaterCommon = new SlideShowAdapter(getContext(),bundle.getInt("position"));
                    PagerAdapter wrapperAdater2 = new InfinitePagerAdapter(adaterCommon);
                    viewPagerSlideShowCommon.setAdapter(wrapperAdater2);

                    break;
                case 3:
                    layout= inflater.inflate(R.layout.fragment_ken_river,container,false);
                    ViewPager viewPagerSlideShow3;
                    SlideShowAdapter adater3;

                    viewPagerSlideShow3 =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    adater3 = new SlideShowAdapter(getContext(),bundle.getInt("position"));
                    PagerAdapter wrapperAdapter3 = new InfinitePagerAdapter(adater3);
                    viewPagerSlideShow3.setAdapter(wrapperAdapter3);
                    break;
                case 4:
                    layout=inflater.inflate(R.layout.fragment_pench,container,false);
                    ViewPager viewPagerSlideShow4;
                    SlideShowAdapter adater4;

                    viewPagerSlideShow4 =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    adater4 = new SlideShowAdapter(getContext(),bundle.getInt("position"));
                    PagerAdapter wrapperAdapter4 = new InfinitePagerAdapter(adater4);
                    viewPagerSlideShow4.setAdapter(wrapperAdapter4);
                    break;
                case 5:
                    layout=inflater.inflate(R.layout.fragment_barahi,container,false);
                    ViewPager viewPagerSlideShow5;
                    SlideShowAdapter adater5;

                    viewPagerSlideShow5 =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    adater5 = new SlideShowAdapter(getContext(),bundle.getInt("position"));
                    PagerAdapter wrapperAdapter5 = new InfinitePagerAdapter(adater5);
                    viewPagerSlideShow5.setAdapter(wrapperAdapter5);
                    break;
                default:
                    layout= inflater.inflate(R.layout.fragment_kings_lodge,container,false);
                    break;
            }

            return layout;
        }
    }
}

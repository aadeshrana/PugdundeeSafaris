package com.example.thearbiter.pugdundeesafaris;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.thearbiter.pugdundeesafaris.Adapters.InfinitePagerAdapter;
import com.example.thearbiter.pugdundeesafaris.Adapters.SlideShowAdapter;
import com.example.thearbiter.pugdundeesafaris.Adapters.SlideShowAdapterParks;
import com.example.thearbiter.pugdundeesafaris.Adapters.SlidingTabLayout;

public class Parks extends AppCompatActivity {
    ViewPager viewPager;
    SlidingTabLayout tabs;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parks);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyPagerAdapterPark(getSupportFragmentManager()));

        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setBackgroundColor(Color.parseColor("#b0ab9c"));

        tabs.setSmoothScrollingEnabled(true);
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parks, menu);
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

    class MyPagerAdapterPark extends FragmentPagerAdapter {
        String[] tabs = {"Kanha National Park", "Panna National Park", "Satpura National Park", "Bandhavghar National Park", "Pench National Park", "Chitwan National Park"};

        public MyPagerAdapterPark(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            MyfragmentPark myfragmentPark = MyfragmentPark.getInstance(position);
            return myfragmentPark;
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

    public static class MyfragmentPark extends Fragment {

        public static MyfragmentPark getInstance(int position) {
            MyfragmentPark myfragmentPark = new MyfragmentPark();
            Bundle args = new Bundle();
            args.putInt("position", position);
            myfragmentPark.setArguments(args);
            return myfragmentPark;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View layout;
            ViewPager viewPagerSlide;
            SlideShowAdapterParks adaterslide;
            Bundle bundle = getArguments();
            PagerAdapter pagerAdapter;
            switch (bundle.getInt("position")) {
                case 0:
                    layout = inflater.inflate(R.layout.fragment_park_kahna, container, false);
                    adaterslide = new SlideShowAdapterParks(getContext(),bundle.getInt("position"));
                    viewPagerSlide =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                     pagerAdapter = new InfinitePagerAdapter(adaterslide);
                    viewPagerSlide.setAdapter(pagerAdapter);
                    break;
                case 1:
                    layout = inflater.inflate(R.layout.fragment_park_panna, container, false);
                    adaterslide = new SlideShowAdapterParks(getContext(),bundle.getInt("position"));
                    viewPagerSlide =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    pagerAdapter = new InfinitePagerAdapter(adaterslide);
                    viewPagerSlide.setAdapter(pagerAdapter);
                    break;
                case 2:
                    layout = inflater.inflate(R.layout.fragment_park_satpura, container, false);
                    adaterslide = new SlideShowAdapterParks(getContext(),bundle.getInt("position"));
                    viewPagerSlide =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    pagerAdapter = new InfinitePagerAdapter(adaterslide);
                    viewPagerSlide.setAdapter(pagerAdapter);
                    break;
                case 3:
                    layout = inflater.inflate(R.layout.fragment_park_bandhavgarh, container, false);
                    adaterslide = new SlideShowAdapterParks(getContext(),bundle.getInt("position"));
                    viewPagerSlide =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    pagerAdapter = new InfinitePagerAdapter(adaterslide);
                    viewPagerSlide.setAdapter(pagerAdapter);
                    break;
                case 4:
                    layout = inflater.inflate(R.layout.fragment_park_pench, container, false);

                    adaterslide = new SlideShowAdapterParks(getContext(),bundle.getInt("position"));
                    viewPagerSlide =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    pagerAdapter = new InfinitePagerAdapter(adaterslide);
                    viewPagerSlide.setAdapter(pagerAdapter);
                    break;
                case 5:
                    layout = inflater.inflate(R.layout.fragment_park_chitwan, container, false);

                    adaterslide = new SlideShowAdapterParks(getContext(),bundle.getInt("position"));
                    viewPagerSlide =(ViewPager)layout.findViewById(R.id.kingsLodgeslideshow);
                    pagerAdapter = new InfinitePagerAdapter(adaterslide);
                    viewPagerSlide.setAdapter(pagerAdapter);
                    break;


                default:
                    layout = inflater.inflate(R.layout.fragment_park_kahna, container, false);


            }
            return layout;
        }
    }
}

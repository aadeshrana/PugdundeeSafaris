package com.example.thearbiter.pugdundeesafaris;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thearbiter.pugdundeesafaris.Adapters.SlideShowAdapter;
import com.example.thearbiter.pugdundeesafaris.Adapters.SlidingTabLayout;
import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {
SlidingTabLayout tabs;
    ViewPager viewPager;
    Context context;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        context = getBaseContext();
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setBackgroundColor(Color.parseColor("#b0ab9c"));

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyPagerAdapterAboutUs(getSupportFragmentManager()));

        tabs.setSmoothScrollingEnabled(true);
        tabs.setDistributeEvenly(true);
        tabs.setViewPager(viewPager);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about_us, menu);
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
    class MyPagerAdapterAboutUs extends FragmentPagerAdapter {
        String[] tabs = {"About Us", "Guest Experience", "Careers", "Partner With Us", "Awards"};

        public MyPagerAdapterAboutUs(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            MyfragmentAboutUs myfragmentAboutUs = MyfragmentAboutUs.getInstance(position);
            return myfragmentAboutUs;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

    }
    public static class MyfragmentAboutUs extends Fragment {

        public static MyfragmentAboutUs getInstance(int position) {
            MyfragmentAboutUs myfragmentPark = new MyfragmentAboutUs();
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
            SlideShowAdapter adaterslide;
            Bundle bundle = getArguments();

            switch (bundle.getInt("position")) {
                case 0:
                    layout = inflater.inflate(R.layout.fragment_about_main, container, false);
                    ImageView imageView =(ImageView)layout.findViewById(R.id.aboutUsimage);
                    TextView textView=(TextView)layout.findViewById(R.id.aboutisMain);
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/lobster.ttf");
                    textView.setTypeface(typeface);

                    imageView.setImageResource(R.drawable.aboutuspix);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                 //   Picasso.with(getContext()).load(R.drawable.aboutuspix).fit().into(imageView);
                    break;
                case 1:
                    layout = inflater.inflate(R.layout.fragment_about_guest, container, false);
                    ImageView imageView1 =(ImageView)layout.findViewById(R.id.aboutUsimage);
                    TextView textView1=(TextView)layout.findViewById(R.id.aboutisMain);
                    Typeface typeface1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/lobster.ttf");
                    textView1.setTypeface(typeface1);
                    Picasso.with(getContext()).load(R.drawable.aboutusguest).fit().into(imageView1);
                    break;
                case 2:
                    layout = inflater.inflate(R.layout.fragment_about_careers, container, false);
                    ImageView imageView2 =(ImageView)layout.findViewById(R.id.aboutUsimage);
                    TextView textView2=(TextView)layout.findViewById(R.id.aboutisMain);
                    Typeface typeface2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/lobster.ttf");
                    textView2.setTypeface(typeface2);
                    Picasso.with(getContext()).load(R.drawable.aboutusjoin).fit().into(imageView2);
                    break;
                case 3:
                    layout = inflater.inflate(R.layout.fragment_about_partner, container, false);
                    ImageView imageView3 =(ImageView)layout.findViewById(R.id.aboutUsimage);
                    TextView textView3=(TextView)layout.findViewById(R.id.aboutisMain);
                    Typeface typeface3 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/lobster.ttf");
                    textView3.setTypeface(typeface3);
                    Picasso.with(getContext()).load(R.drawable.aboutuspartner).fit().into(imageView3);
                    break;
                /*case 4:
                    layout = inflater.inflate(R.layout.fragment_about_team, container, false);
                    break;
*/                case 4:
                    layout = inflater.inflate(R.layout.fragment_about_awards, container, false);

                    ImageView imageAward1 = (ImageView)layout.findViewById(R.id.award1);
                    ImageView imageAward2 = (ImageView)layout.findViewById(R.id.award2);
                    ImageView imageAward3 = (ImageView)layout.findViewById(R.id.award3);
                    ImageView imageAward4 = (ImageView)layout.findViewById(R.id.award4);
                    ImageView imageAward5 = (ImageView)layout.findViewById(R.id.award5);
                    ImageView imageAward6 = (ImageView)layout.findViewById(R.id.award6);

                    TextView textView4=(TextView)layout.findViewById(R.id.aboutisMain);
                    Typeface typeface4 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/lobster.ttf");
                    textView4.setTypeface(typeface4);

                    Picasso.with(getContext()).load(R.drawable.award1).into(imageAward1);
                    Picasso.with(getContext()).load(R.drawable.award2).into(imageAward2);
                    Picasso.with(getContext()).load(R.drawable.award2).into(imageAward3);
                    Picasso.with(getContext()).load(R.drawable.award3).into(imageAward4);
                    Picasso.with(getContext()).load(R.drawable.award3).into(imageAward5);
                    Picasso.with(getContext()).load(R.drawable.award3).into(imageAward6);
                    break;


                default:
                    layout = inflater.inflate(R.layout.fragment_about_main, container, false);


            }
            return layout;
        }
    }
}

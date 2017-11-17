package com.example.thearbiter.pugdundeesafaris;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.thearbiter.pugdundeesafaris.Adapters.InfinitePagerAdapter;
import com.example.thearbiter.pugdundeesafaris.Adapters.SlideShowAdapter;
import com.example.thearbiter.pugdundeesafaris.Adapters.SlideShowAdapterMain;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment navigationDrawerFragment =(NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentDrawer);
        navigationDrawerFragment.setUp(R.id.fragmentDrawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/lobster.ttf");
        TextView textView = (TextView)findViewById(R.id.titleMain);
        textView.setTypeface(typeface);

        FragmentDrawerView fragmentDrawerView = new FragmentDrawerView();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentDrawer,fragmentDrawerView,"abc");
        fragmentTransaction.commit();

        ViewPager viewPagerSlideShow;
        SlideShowAdapterMain adater;
        viewPagerSlideShow =(ViewPager)findViewById(R.id.mainSlideShow);
        adater = new SlideShowAdapterMain(getApplicationContext());
        PagerAdapter wrapperAdapter = new InfinitePagerAdapter(adater);
        viewPagerSlideShow.setAdapter(wrapperAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void learnMore(View view){
        Intent intent = new Intent(this,AboutUs.class);
        startActivity(intent);
    }
}

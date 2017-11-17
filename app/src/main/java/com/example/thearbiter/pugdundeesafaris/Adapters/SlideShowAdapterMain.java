package com.example.thearbiter.pugdundeesafaris.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.thearbiter.pugdundeesafaris.R;

/**
 * Created by Aadesh Rana on 20-08-16.
 */
public class SlideShowAdapterMain extends PagerAdapter {

    int x[];
    private Context context;
    private LayoutInflater inflater;

    public  SlideShowAdapterMain(Context context){
        this.context = context;

        x = new int[]{R.drawable.sat,R.drawable.kahna1, R.drawable.kingslodge1, R.drawable.kingslodge2, R.drawable.kingslodge3};
    }

    @Override
    public int getCount() {
        return x.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout)object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.swipelayout,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.swipImage1);
        imageView.setImageResource(x[position]);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}

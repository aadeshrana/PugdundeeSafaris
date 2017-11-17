package com.example.thearbiter.pugdundeesafaris.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.thearbiter.pugdundeesafaris.R;

/**
 * Created by Aadesh Rana on 14-08-16.
 */
public class SlideShowAdapterParks extends PagerAdapter{
    int x[];
    private Context context;
    private LayoutInflater inflater;
    public int choice;
    public SlideShowAdapterParks(Context context,int y){

        this.context = context;
        switch (y){
            case 0:
                x = new int[]{R.drawable.park_kahna, R.drawable.park_kahna1, R.drawable.park_kahna2, R.drawable.park_kahna3,R.drawable.park_kahna4};
                break;
            case 1:
                x = new int[]{R.drawable.park_panna, R.drawable.park_panna1, R.drawable.park_panna3, R.drawable.park_panna4};
                break;
            case 2:
                x = new int[]{R.drawable.park_satpura,R.drawable.park_satpura2,R.drawable.park_satpura3,R.drawable.park_satpura4};
                break;
            case 3:
                x = new int[]{R.drawable.park_badhv, R.drawable.park_badhv2, R.drawable.park_badhv3, R.drawable.park_badhv5};
                break;
            case 4:
                x = new int[]{R.drawable.park_pench,R.drawable.park_pench1};
                break;
            case 5:
                x = new int[]{R.drawable.park_chitwan,R.drawable.park_chitwan1,R.drawable.park_chitwan2,R.drawable.park_chitwan3};
                break;
            default:
                x = new int[]{R.drawable.kingslodge, R.drawable.kingslodge1, R.drawable.kingslodge2, R.drawable.kingslodge3};

        }
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
        container.removeView((LinearLayout)object);
    }
}



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
 * Created by Aadesh Rana on 11-08-16.
 */
public class SlideShowAdapter extends PagerAdapter {
    int x[];
    private Context context;
    private LayoutInflater inflater;
    public int choice;
    public SlideShowAdapter(Context context,int y){

        this.context = context;
        choice = y;
        switch (choice){
            case 0:
                x = new int[]{R.drawable.kingslodge, R.drawable.kingslodge1, R.drawable.kingslodge2, R.drawable.kingslodge3};
                break;
            case 1:
                x = new int[]{R.drawable.treehouse1, R.drawable.treehouse2, R.drawable.treehouse3, R.drawable.treehouse4,R.drawable.treehouse5};
                break;
            case 2:
                x = new int[]{R.drawable.kahna1,R.drawable.kahna2,R.drawable.kahna3,R.drawable.kahna4,R.drawable.kahna5};
                break;
            case 3:
                x = new int[]{R.drawable.kenriver, R.drawable.kenriver1,R.drawable.kenriver2,R.drawable.kenriver3,R.drawable.kenriver4};
                break;
            case 4:
                x = new int[]{R.drawable.pench1,R.drawable.pench2,R.drawable.pench3,R.drawable.pench4,R.drawable.pench5};
                break;
            case 5:
                x = new int[]{R.drawable.barahi,R.drawable.pench2,R.drawable.pench3,R.drawable.pench4,R.drawable.pench5};
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

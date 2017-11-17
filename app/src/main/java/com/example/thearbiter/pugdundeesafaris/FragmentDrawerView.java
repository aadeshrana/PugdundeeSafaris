package com.example.thearbiter.pugdundeesafaris;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thearbiter.pugdundeesafaris.Adapters.AdapterForDrawerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aadesh Rana on 10-08-16.
 */
public class FragmentDrawerView extends android.app.Fragment {

    String title[]={"LODGES","PARKS","PROGRAMS","ABOUT US","PHOTOS","CONTACT US","BOOK ONLINE"};
    int icons[] ={R.drawable.icon1,R.drawable.icon2,R.drawable.icon3,R.drawable.icon4,R.drawable.icon5,R.drawable.icon6,R.drawable.icon7};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.drawer_layout_view,container,false);

        RecyclerView recyclerView = (RecyclerView)layout.findViewById(R.id.recyclerviewlayout);
        AdapterForDrawerView adapter = new AdapterForDrawerView(getActivity(), getData());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }
   public List<Information> getData(){
       List<Information> data = new ArrayList<>();

       for (int i = 0; i < title.length && i < icons.length; i++) {
           Information current = new Information();

           current.name = title[i];

           current.iconId = icons[i];

           data.add(current);
       }
       return data;
   }
}

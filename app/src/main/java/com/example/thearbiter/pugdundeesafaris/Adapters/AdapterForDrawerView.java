package com.example.thearbiter.pugdundeesafaris.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thearbiter.pugdundeesafaris.AboutUs;
import com.example.thearbiter.pugdundeesafaris.BookNow;
import com.example.thearbiter.pugdundeesafaris.ContactUs;
import com.example.thearbiter.pugdundeesafaris.Information;
import com.example.thearbiter.pugdundeesafaris.Lodges;
import com.example.thearbiter.pugdundeesafaris.Parks;
import com.example.thearbiter.pugdundeesafaris.PhotosView;
import com.example.thearbiter.pugdundeesafaris.Programs;
import com.example.thearbiter.pugdundeesafaris.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Aadesh Rana on 10-08-16.
 */
public class    AdapterForDrawerView extends RecyclerView.Adapter<AdapterForDrawerView.MyViewHolder> {
   Context context;
    LayoutInflater inflater;
    List<Information> data = Collections.emptyList();
    public AdapterForDrawerView(Context context,List<Information> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_layout,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
       final Information current = data.get(position);
        holder.title.setText(current.name);
        Picasso.with(context).load(current.iconId).fit().centerCrop().into(holder.iconId);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(context, Lodges.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, Parks.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, Programs.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, AboutUs.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(context, PhotosView.class);
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(context,ContactUs.class);
                        context.startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(context, BookNow.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView iconId;
        public CardView cardview;
        public MyViewHolder(View itemView) {

            super(itemView);
            title = (TextView)itemView.findViewById(R.id.textCustomMain);
            iconId= (ImageView)itemView.findViewById(R.id.imageCustomLayoutMain);
            cardview =(CardView)itemView.findViewById(R.id.cardviewmain);
        }
    }
}

package com.example.thearbiter.pugdundeesafaris.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thearbiter.pugdundeesafaris.Information;
import com.example.thearbiter.pugdundeesafaris.InformationProgram;
import com.example.thearbiter.pugdundeesafaris.R;
import com.squareup.picasso.Picasso;

import java.lang.annotation.IncompleteAnnotationException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aadesh Rana on 16-08-16.
 */
public class AdapterForProgramR extends RecyclerView.Adapter<AdapterForProgramR.MyViewHolder> {
    Context context;
    public LayoutInflater layoutInflater;
    List<InformationProgram> data= Collections.emptyList();

    public AdapterForProgramR(Context context,List<InformationProgram> data){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view =   layoutInflater.inflate(R.layout.program_custom_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       final InformationProgram asdf = data.get(position);
       Picasso.with(context).load(asdf.icons).into(holder.image1);


        holder.text1.setText(asdf.title);

            holder.text2.setText(asdf.subtext);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        public   TextView text1,text2;
        public   ImageView image1;
        public MyViewHolder(View itemView) {

            super(itemView);
            text1 =(TextView)itemView.findViewById(R.id.programTitleText);
            image1 =(ImageView)itemView.findViewById(R.id.programMainImage);
            text2 =(TextView)itemView.findViewById(R.id.programSecondText);
        }
    }
}

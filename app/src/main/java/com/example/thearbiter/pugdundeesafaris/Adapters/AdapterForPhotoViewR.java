package com.example.thearbiter.pugdundeesafaris.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thearbiter.pugdundeesafaris.InformationRecycler;
import com.example.thearbiter.pugdundeesafaris.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by Aadesh Rana on 16-08-16.
 */
public class AdapterForPhotoViewR extends RecyclerView.Adapter<AdapterForPhotoViewR.MyViewHolder> {
    Context context;
    public LayoutInflater layoutInflater;
    List<InformationRecycler> data= Collections.emptyList();

    public AdapterForPhotoViewR(Context context,List<InformationRecycler> data){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =   layoutInflater.inflate(R.layout.custom_layout_photo_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final InformationRecycler asdf = data.get(position);
        Picasso.with(context).load(asdf.imageIcon).fit().into(holder.image1);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View promtView = layoutInflater.inflate(R.layout.custom_layout_photo_size, null);

                final ImageView realSizeImage = (ImageView)promtView.findViewById(R.id.photoDialogImage);
                final ProgressBar progressBar = (ProgressBar)promtView.findViewById(R.id.photoDialogprogressBar);
                progressBar.setVisibility(View.VISIBLE);
                final AlertDialog builder = new AlertDialog.Builder(context).create();
                builder.setView(promtView);
                builder.show();
                final Activity a = (Activity)context;
                        a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                Window window = builder.getWindow();
                lp.copyFrom(window.getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

                window.setAttributes(lp);

                builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {

                            dialog.dismiss();
                            a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        }
                        return true;
                    }
                });

                String urlCommon;
                switch (position){
                    case 0:
                        urlCommon="http://i.imgur.com/V9dkwqs.jpg?1";
                        break;
                    case 1:
                        urlCommon="http://i.imgur.com/133PEdv.png?1";
                        break;
                    case 2:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/barahi-lodge/6.jpg";
                        break;
                    case 3:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/barahi-lodge/1.jpg";
                        break;
                    case 4:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/barahi-lodge/2.jpg";
                        break;
                    case 5:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/ken-river-lodge/9.jpg";
                        break;
                    case 6:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/ken-river-lodge/11.jpg";
                        break;
                    case 7:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/ken-river-lodge/6.jpg";
                        break;
                    case 8:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/ken-river-lodge/7.jpg";
                        break;
                    case 9:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/ken-river-lodge/12.jpg";
                        break;
                    case 10:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/kings-lodge-bandhavgarh/2.jpg";
                        break;
                    case 11:
                        urlCommon="http://www.pugdundeesafaris.com/images/gallery/kings-lodge-bandhavgarh/6.jpg";
                        break;


                    default:
                        urlCommon="http://adsoftheworld.com/sites/default/files/media-vimeo/70533052.jpg";

                }
                DisplayMetrics displaymetrics = new DisplayMetrics();
                a.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int height = displaymetrics.heightPixels;
                int width = displaymetrics.widthPixels;
                Log.d("gg",""+height+" "+width);

                Picasso.with(context).load(urlCommon).resize(width+350,height).into(realSizeImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(context, "Please Check Ur Internet Connection", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }

                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView image1;
        public CardView cardView;
        public MyViewHolder(View itemView) {

            super(itemView);

            image1 =(ImageView)itemView.findViewById(R.id.imageView11);
            cardView=(CardView)itemView.findViewById(R.id.photoViewCard);
        }
    }
}

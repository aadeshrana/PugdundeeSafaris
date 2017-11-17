package com.example.thearbiter.pugdundeesafaris;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {
    TextView nameEnter, phoneEnter,emailEnter,queryEnter;
    CardView nameCardView, phoneCardView,emailCardView,queryCardView;
    Context context;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = getBaseContext();
        nameEnter = (TextView)findViewById(R.id.CUName);
        phoneEnter=(TextView)findViewById(R.id.CUPhone);
        emailEnter=(TextView)findViewById(R.id.CUEmail);
        queryEnter=(TextView)findViewById(R.id.CUQuery);

        nameCardView=(CardView)findViewById(R.id.CUCardView);
        phoneCardView=(CardView)findViewById(R.id.CUEmailCV);
        emailCardView=(CardView)findViewById(R.id.CUphoneCV);
        queryCardView=(CardView)findViewById(R.id.CUQueryCV);

        nameEnter.clearFocus();
        phoneEnter.clearFocus();
        emailEnter.clearFocus();
        queryEnter.clearFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_us, menu);
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

    public void submitQuery(View view){
        nameCardView.setCardBackgroundColor(Color.parseColor("#b0ab9c"));
        if(nameEnter.getText().toString().equals("")){
            nameCardView.setCardBackgroundColor(Color.parseColor("#ff0000"));
            Toast.makeText(ContactUs.this, "Name Cant Be Empty", Toast.LENGTH_SHORT).show();
        }
        if(phoneEnter.getText().toString().equals("")){
            phoneCardView.setCardBackgroundColor(Color.parseColor("#ff0000"));
            Toast.makeText(ContactUs.this, "Phone No. Cant Be Empty", Toast.LENGTH_SHORT).show();
        }
        if(emailEnter.getText().toString().equals("")){
            emailCardView.setCardBackgroundColor(Color.parseColor("#ff0000"));
            Toast.makeText(ContactUs.this, "Email Cant Be Empty", Toast.LENGTH_SHORT).show();
        }
        if(queryEnter.getText().toString().equals("")){
            queryCardView.setCardBackgroundColor(Color.parseColor("#ff0000"));
            Toast.makeText(ContactUs.this, "Query Cant Be Empty", Toast.LENGTH_SHORT).show();
        }
        else{
            AlertDialog.Builder builder1 = new AlertDialog.Builder(ContactUs.this);
            builder1.setMessage("Query Successfully Posted");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Okay",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });



            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
    }
}

package com.example.thearbiter.pugdundeesafaris;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BookNow extends AppCompatActivity {
    Button checkinButton;
    Calendar myCalendar;
    Button checkOutButton;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/lobster.ttf");
        TextView textView = (TextView)findViewById(R.id.avForm);
        textView.setTypeface(typeface);

        Spinner spinnerhotel = (Spinner) findViewById(R.id.spinnerhotel);
        Spinner spinnerroom = (Spinner) findViewById(R.id.spinnerrooms);
        Spinner spinnertype = (Spinner) findViewById(R.id.spinnerroomtype);
        Spinner spinnernation = (Spinner) findViewById(R.id.spinnernation);


        final String[] hotel = {"Kahna Earth Lodge", "Ken River Lodge", "Kings Lodge", "Tree House","Denwa Backwater Escape","Barahi Lodge"};
        final String[] numberr = {"1", "2", "3", "4"};
        final ArrayList<String> roomtype = new ArrayList<>();

        final String[] nation = {"Indian","Foreigner"};


        ArrayAdapter<String> adapterhotel = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, hotel);
        spinnerhotel.setAdapter(adapterhotel);

        ArrayAdapter<String> adapterroom = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, numberr);
        spinnerroom.setAdapter(adapterroom);

        ArrayAdapter<String> adapterrnation = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, nation);
        spinnernation.setAdapter(adapterrnation);

        final ArrayAdapter<String> adaptertype = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, roomtype);
        spinnertype.setAdapter(adaptertype);

        spinnerhotel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        roomtype.clear();
                        roomtype.add(0, "Ac Bungalow");
                        adaptertype.notifyDataSetChanged();

                        break;
                    case 1:
                        roomtype.clear();
                        roomtype.add(0, "Hut");
                        roomtype.add(1, "Cottage");
                        adaptertype.notifyDataSetChanged();
                        break;
                    case 2:
                        roomtype.clear();
                        roomtype.add(0, "Ac Cottages");
                        adaptertype.notifyDataSetChanged();
                        break;
                    case 3:
                        roomtype.clear();
                        roomtype.add(0, "Ac TreeHouse");
                        adaptertype.notifyDataSetChanged();
                        break;
                    case 4:
                        roomtype.clear();
                        roomtype.add(0, "Ac TreeHouse");
                        roomtype.add(1, "Ac Cottages");
                        adaptertype.notifyDataSetChanged();
                        break;
                    case 5:
                        roomtype.clear();
                        roomtype.add(0, "Delux Boutique Room");
                        adaptertype.notifyDataSetChanged();
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkinButton = (Button)findViewById(R.id.buttondate1);
        checkOutButton = (Button)findViewById(R.id.buttondate2);


        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        String nextDay = dt1.format(tomorrow);
        checkinButton.setText(timeStamp);
        checkOutButton.setText(nextDay);
        Log.d("gg", "" + timeStamp);
        /* FOR DATE AND STUFF*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_now, menu);
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
    public void checkInDate(View view){
        myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        new DatePickerDialog(BookNow.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public  void updateLabel(){
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        checkinButton.setText(sdf.format(myCalendar.getTime()));
    }

    public void checkOutDate(View view){
        myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel2();
            }
        };
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        new DatePickerDialog(BookNow.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH + 1)).show();
    }
    public  void updateLabel2(){
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        checkOutButton.setText(sdf.format(myCalendar.getTime()));
    }
public void checkAvail(View view){
    Toast.makeText(BookNow.this, "Server error", Toast.LENGTH_SHORT).show();
}
}

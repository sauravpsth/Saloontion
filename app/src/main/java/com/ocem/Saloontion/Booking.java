package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ocem.Saloontion.model.BookingResponse;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class Booking extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button,button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,mainButton;
    String[] years = { "2021", "2022" };
    String[] months = { "Jan", "Feb","Mar","Apr","May","June","Jul","Aug","Sept","Oct","Nov","Dec" };
    String[] days = { "20", "21","22","23","24","25","26","27","28","29","30" };

    SharedPrefsHelper sharedPrefsHelper;
    BookingResponse bookingResponse;
    String serviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_booking );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );
        sharedPrefsHelper.saveValue( Constant.DATE,"2021/7/22" );
        /*sharedPrefsHelper.saveValue( Constant.TIME,"9:00" );*/

        button = findViewById( R.id.btproceed );
        button1 = findViewById( R.id.eight );
        button2 = findViewById( R.id.nine);
        button3  = findViewById( R.id.ten );
        button4 = findViewById( R.id.eleven );
        button5 = findViewById( R.id.twelve );
        button6 = findViewById( R.id.one );
        button7 = findViewById( R.id.two );
        button8 = findViewById( R.id.three );
        button9 = findViewById( R.id.four );
        button10 = findViewById( R.id.five );
        button11 = findViewById( R.id.six);
        button12 = findViewById( R.id.seven );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookingList();
            }
        } );

        Toolbar toolbar = findViewById( R.id.atool7 );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( "Booking" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener( this );

        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);
        spin2.setOnItemSelectedListener( this );

        Spinner spin3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adapter3);
        spin3.setOnItemSelectedListener(this );
        String string2 = spin3.toString().trim();


        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"8:00" );
            }
        } );

        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"9:00" );
            }
        } );

        button3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"10:00" );
            }
        } );

        button4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"11:00" );
            }
        } );

        button5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button5.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"6:00" );
            }
        } );

        button6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button6.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"12:00" );
            }
        } );

        button7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button7.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"1:00" );
            }
        } );

        button8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button8.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"2:00" );
            }
        } );

        button9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button9.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"3:00" );
            }
        } );
        button10.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefsHelper.saveValue( Constant.BUTTON,"7:00" );
                button10.setTextColor( Color.BLUE );
            }
        } );

        button11.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button11.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"4:00" );
            }
        } );
        button12.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button12.setTextColor( Color.BLUE );
                sharedPrefsHelper.saveValue( Constant.BUTTON,"5:00" );
            }
        } );



    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }

    private void bookingList() {
        Services apiService = ApiUtils.getServices();
        apiService.bookingRequest("Bearer " + sharedPrefsHelper.getValue( Constant.TOKEN,"" ),sharedPrefsHelper.getValue( Constant.NAME,"" ),sharedPrefsHelper.getValue( Constant.EMAIL," " ),sharedPrefsHelper.getValue( "service",0)+"",sharedPrefsHelper.getValue( "saloon",0 )+"",sharedPrefsHelper.getValue( Constant.DATE,"" ),sharedPrefsHelper.getValue( Constant.BUTTON,"" )).enqueue( new Callback<BookingResponse>() {
            @Override
            public void onResponse(Call<BookingResponse> call, Response<BookingResponse> response) {
                Log.v("msg","code"+response);
                if(response.isSuccessful()){
                    Toast.makeText( Booking.this, "Booking Successful", Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent(Booking.this,MainActivity.class) );
                }
                else {
                    Toast.makeText( Booking.this, "Sorry, but u r not eligible for booking", Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void onFailure(Call<BookingResponse> call, Throwable t) {
                Toast.makeText(Booking.this,"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        } );
    }

}

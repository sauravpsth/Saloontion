package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ocem.Saloontion.adapter.MyAppointmentAdapter;
import com.ocem.Saloontion.adapter.SaloonServiceAdapter;
import com.ocem.Saloontion.model.BookingResponse;
import com.ocem.Saloontion.model.Contact;
import com.ocem.Saloontion.model.Datum;
import com.ocem.Saloontion.model.HistoryResponse;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.model.UpComingHistoryModel;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAppointments extends AppCompatActivity {

    private RecyclerView recylerView,recyclerView1;
    private HistoryResponse lstContact;
    MyAppointmentAdapter recylerViewAdaptor;
    SharedPrefsHelper sharedPrefsHelper;
    TextView textView,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_appointments );

        Toolbar toolbar = findViewById( R.id.atool8 );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( "My Appointment" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

    /*    Intent intent = getIntent();
        String saloon = intent.getExtras().getString( "Saloon" );
        String service = intent.getExtras().getString( "Service" );
        String date = intent.getExtras().getString( "Date" );
        String time = intent.getExtras().getString( "Time" );
        String price = intent.getExtras().getString( "Price" );*/

        textView = findViewById( R.id.tvYou );
  /*      textView1 = findViewById( R.id.tvMy );*/

        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );

        recylerView = findViewById( R.id.recycleView );
      recylerViewAdaptor = new MyAppointmentAdapter( lstContact,this );

/*
      recyclerView1 =findViewById( R.id.recycleViewHistory );
        recyclerView1.setLayoutManager( new LinearLayoutManager( MyAppointments.this ) );
        recyclerView1.setAdapter( recylerViewAdaptor );
*/

      bookingList();

    }

    private void bookingList() {
        Services apiService = ApiUtils.getServices();
        apiService.getHistoryList("Bearer " + sharedPrefsHelper.getValue( Constant.TOKEN,"" )).enqueue( new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                if(response.isSuccessful()) {
                    if (!response.body().getData().isEmpty()) {
                        textView.setVisibility( View.INVISIBLE );
                        lstContact = response.body();
                        recylerViewAdaptor.setBookingList( lstContact );
                        recylerView.setLayoutManager( new LinearLayoutManager( MyAppointments.this ) );
                        recylerView.setAdapter( recylerViewAdaptor );

                    }
                }
                else {
                    Toast.makeText( MyAppointments.this, "Error", Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
                Toast.makeText(MyAppointments.this,"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        } );
    }

}
package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ocem.Saloontion.adapter.AvailableSaloonAdapter;
import com.ocem.Saloontion.adapter.SaloonAdapter;
import com.ocem.Saloontion.adapter.SaloonServiceAdapter;
import com.ocem.Saloontion.model.Contact;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableSaloon extends AppCompatActivity {

    private TextView tvtitle,tvdescript;
    private ImageView img;
    private RecyclerView recylerView;
    private List<ServicesResponse> servicesResponses;
    AvailableSaloonAdapter saloonServiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_available_saloon );

        Toolbar toolbar = findViewById( R.id.tool );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( "Service" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        tvtitle = (TextView) findViewById( R.id.salonname2 );
        img = (ImageView) findViewById( R.id.cimgv2 );
        tvdescript = (TextView) findViewById( R.id.cont2 );


        Intent intent = getIntent();
        String Title = intent.getExtras().getString( "Title1" );
        String image = intent.getExtras().getString( "Image1" );
        String detail = intent.getExtras().getString( "Description" );

        tvtitle.setText( Title );
        tvdescript.setText( detail );
        Glide.with( this ).load( image ).into( img );



        recylerView = findViewById( R.id.recycle1 );
        saloonServiceAdapter = new AvailableSaloonAdapter( this, servicesResponses);

        saloonList();

    }


    private void saloonList() {
        Services apiService = ApiUtils.getServices();
        apiService.getSaloonService().enqueue( new Callback<List<ServicesResponse>>() {
            @Override
            public void onResponse(Call<List<ServicesResponse>> call, Response<List<ServicesResponse>> response) {
                if(response.isSuccessful()){
                    servicesResponses = response.body();
                    saloonServiceAdapter.setSaloonService( servicesResponses );
                    recylerView.setLayoutManager( new LinearLayoutManager( AvailableSaloon.this) );
                    recylerView.setAdapter( saloonServiceAdapter );
                }
            }

            @Override
            public void onFailure(Call<List<ServicesResponse>> call, Throwable t) {
                Toast.makeText(AvailableSaloon.this,"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        } );
    }
}
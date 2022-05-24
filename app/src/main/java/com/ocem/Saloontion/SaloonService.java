package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.ocem.Saloontion.adapter.SaloonServiceAdapter;
import com.ocem.Saloontion.adapter.categoryAdapter;
import com.ocem.Saloontion.model.Contact;
import com.ocem.Saloontion.model.LoginResponse;
import com.ocem.Saloontion.model.ServicesResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class SaloonService extends AppCompatActivity {

    private TextView tvtitle, tvaddress, tvphone;
    private ImageView img;
    private RecyclerView myrecylerview1;
    private List<ServicesResponse> servicesResponses;
    SaloonServiceAdapter saloonServiceAdapter;
    SharedPrefsHelper sharedPrefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_saloon_service );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );
        Toolbar toolbar = findViewById( R.id.tool1 );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( "Saloontion" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        tvtitle = (TextView) findViewById( R.id.salonname );
        img = (ImageView) findViewById( R.id.cimgv );
        tvaddress = (TextView) findViewById( R.id.address );
        tvphone = (TextView) findViewById( R.id.cont );

        Intent intent = getIntent();
        String Title = intent.getExtras().getString( "Title" );
        String  image = intent.getExtras().getString( "Thumbnail" );
        String address = intent.getExtras().getString( "Address" );
        String number = intent.getExtras().getString( "Phone" );

        tvtitle.setText( Title );
        tvaddress.setText( address );
        tvphone.setText( number );
        Glide.with( this ).load( image ).into( img );



        myrecylerview1 = (RecyclerView) findViewById( R.id.recycle );
        saloonServiceAdapter = new SaloonServiceAdapter(this,servicesResponses);



        saloonService();

    }

    private void saloonService() {
        Services apiService = ApiUtils.getServices();
        apiService.getSaloonService().enqueue( new Callback<List<ServicesResponse>>() {
            @Override
            public void onResponse(Call<List<ServicesResponse>> call, Response<List<ServicesResponse>> response) {
                if(response.isSuccessful()){
                    servicesResponses = response.body();
                    saloonServiceAdapter.setSaloonService( servicesResponses );
                    myrecylerview1.setLayoutManager( new LinearLayoutManager( SaloonService.this) );
                    myrecylerview1.setAdapter( saloonServiceAdapter );
                }
            }

            @Override
            public void onFailure(Call<List<ServicesResponse>> call, Throwable t) {
                Toast.makeText(SaloonService.this,"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        } );
    }
}

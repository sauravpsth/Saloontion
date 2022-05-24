package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;


public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_about_us );

        Toolbar toolbar = findViewById( R.id.atoolc );
        setSupportActionBar( toolbar );
        getSupportActionBar().setTitle( "About Us" );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }
}
package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import de.hdodenhof.circleimageview.CircleImageView;

public class Splashscreen extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    CircleImageView circleImageView;
    SharedPrefsHelper sharedPrefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splashscreen );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );

        ImageView imageView = findViewById( R.id.cirimg );
       imageView.animate().alpha( 100 ).setDuration( 0 );

        handler = new Handler();
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                if (sharedPrefsHelper.getValue( Constant.FIRST_LOAD, false )) {
                    Intent dsp = new Intent( Splashscreen.this, MainActivity.class );
                    startActivity( dsp );
                    finish();
                }
                else {
                    Intent dsp = new Intent( Splashscreen.this, LoginActivity.class );
                    startActivity( dsp );
                    finish();
                }
            }
        }, 1200 );
    }
}


package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ocem.Saloontion.fragment.HomeFragment;

public class RequestAppointment extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_request_appointment );

        button =  findViewById( R.id.confirm );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RequestAppointment.this, MainActivity.class );
                startActivity( intent );
                Toast.makeText( RequestAppointment.this,"Booking Successfully",Toast.LENGTH_SHORT ).show();

            }
        } );
    }
}
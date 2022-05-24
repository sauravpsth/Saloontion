package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ocem.Saloontion.model.ResetResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPassword extends AppCompatActivity {

    Button button;
    EditText etCode,etPassword,etConfirm;
    SharedPrefsHelper sharedPrefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_reset_password );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );

        etCode = findViewById( R.id.etEmailCode );
        etPassword = findViewById( R.id.etnewpass );
        etConfirm = findViewById( R.id.etrenewpass );
        button =  findViewById( R.id.btreset );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userReset();
            }
        } );
    }
    private void userReset() {
        Services apiService = ApiUtils.getServices();
        apiService.resetRequest( etCode.getText().toString().trim(),sharedPrefsHelper.getValue( Constant.RE_EMAIL,"" ),etPassword.getText().toString().trim(),etConfirm.getText().toString().trim() ).enqueue( new Callback<ResetResponse>() {
            @Override
            public void onResponse(Call<ResetResponse> call, Response<ResetResponse> response) {

                if (response.isSuccessful()) {
                    Toast.makeText( ResetPassword.this, "Password changed successfully", Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent( ResetPassword.this, LoginActivity.class ) );

                } else {
                    Toast.makeText( ResetPassword.this, "Invalid username. Try Again !!!", Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void onFailure(Call<ResetResponse> call, Throwable t) {
                Toast.makeText( ResetPassword.this, "Wifi Unavailable", Toast.LENGTH_SHORT ).show();
            }
        } );

    }
}

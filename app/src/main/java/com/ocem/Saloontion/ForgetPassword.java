package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ocem.Saloontion.model.ForgetResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgetPassword extends AppCompatActivity {

    EditText etEmail;
    SharedPrefsHelper sharedPrefsHelper;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_forget_password );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );
        etEmail = findViewById( R.id.etEmail1 );
        Button button = findViewById( R.id.btforgetproceed );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userForget();
            }
        } );
    }

    private void userForget() {
        Services apiService = ApiUtils.getServices();
        apiService.forgetRequest( etEmail.getText().toString().trim() ).enqueue( new Callback<ForgetResponse>() {
            @Override
            public void onResponse(Call<ForgetResponse> call, Response<ForgetResponse> response) {
                if (response.isSuccessful()) {
                    sharedPrefsHelper.saveValue( Constant.RE_EMAIL,etEmail.getText().toString().trim() );
                    Toast.makeText( ForgetPassword.this, "Otp code send", Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent( ForgetPassword.this, ResetPassword.class ) );

                } else {
                    Toast.makeText( ForgetPassword.this, "Invalid username. Try Again !!!", Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void onFailure(Call<ForgetResponse> call, Throwable t) {
                Toast.makeText( ForgetPassword.this, "Wifi Unavailable", Toast.LENGTH_SHORT ).show();
            }
        } );

    }
}

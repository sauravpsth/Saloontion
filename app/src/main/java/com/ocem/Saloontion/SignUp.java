package com.ocem.Saloontion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.ocem.Saloontion.model.RegisterResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUp extends AppCompatActivity {
    TextView textView2;
    TextInputEditText textName,textEmail,textNumber,textPass,textConfirm;
    Button button;
    ProgressDFragment progressDFragment;
    SharedPrefsHelper sharedPrefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_up );

        textView2 = (TextView) findViewById( R.id.tvLogin );
        textName =  findViewById( R.id.textName );
        textEmail =  findViewById( R.id.textEmail );
        textNumber =  findViewById( R.id.textNumber);
        textPass =  findViewById( R.id.textPass );
        textConfirm =  findViewById( R.id.textConfirm );
        button = findViewById( R.id.btSignUp );
        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );

        textView2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( SignUp.this, LoginActivity.class );
                startActivity( intent );


            }
        } );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        } );


    }

    private void userRegister(){
        Services apiService = ApiUtils.getServices();
        apiService.signUpRequest(textName.getText().toString(),textEmail.getText().toString(),textPass.getText().toString()).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.e("USER_REGISTER","Status code = "+response.code());
                if (response.isSuccessful()) {

                    progressDFragment = ProgressDFragment.newInstance( "Registering.. wait..." );
                    Toast.makeText( SignUp.this, "Register Successful", Toast.LENGTH_SHORT ).show();

                    startActivity(new Intent(SignUp.this, LoginActivity.class));

                }else{
                    Toast.makeText(SignUp.this, "Failed to register. Try Again !!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(SignUp.this,"Wifi unavailable",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ocem.Saloontion.model.VerifyResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Verify extends AppCompatActivity {

    EditText etVerify;
    ProgressDFragment progressDFragment;
    SharedPrefsHelper sharedPrefsHelper;
    String textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_verify );

        etVerify = findViewById( R.id.etCode );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );
        textView =sharedPrefsHelper.getValue( Constant.REMAIL,"" );
        etVerify.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userVerify();
            }
        } );
    }

    private void userVerify(){
        Services apiService = ApiUtils.getServices();
        apiService.verifyRequest(textView,etVerify.getText().toString().trim()).enqueue( new Callback<VerifyResponse>() {
            @Override
            public void onResponse(Call<VerifyResponse> call, Response<VerifyResponse> response) {
                Log.e("VERIFY","Status code = "+response.code());
                if (response.isSuccessful()) {

                    progressDFragment = ProgressDFragment.newInstance( "verifying.. wait..." );
                    Toast.makeText( Verify.this, "user verified", Toast.LENGTH_SHORT ).show();
                    startActivity(new Intent(Verify.this, MainActivity.class));

                }else{
                    Toast.makeText(Verify.this, "wrong otp!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VerifyResponse> call, Throwable t) {
                Toast.makeText(Verify.this,"Check your wifi",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
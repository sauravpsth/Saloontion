package com.ocem.Saloontion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ocem.Saloontion.model.LoginResponse;
import com.ocem.Saloontion.network.ApiUtils;
import com.ocem.Saloontion.network.Services;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextView textView, textView1;
    Button button;
    TextInputEditText textEmail, textPassword;
    SharedPrefsHelper sharedPrefsHelper;
    ProgressDFragment progressDFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( this );

        textView = (TextView) findViewById( R.id.account );
        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, SignUp.class );
                startActivity( intent );

            }
        } );

        textView1 = (TextView) findViewById( R.id.forgot );
        textView1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( LoginActivity.this, ForgetPassword.class );
                startActivity( intent );
            }
        } );

        button = (Button) findViewById( R.id.login );
        textEmail = findViewById( R.id.textUser );
        textPassword = findViewById( R.id.textPassword);
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        } );
    }

    private void userLogin(){
        Services apiService = ApiUtils.getServices();
        apiService.logInRequest(textEmail.getText().toString(),textPassword.getText().toString()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d("LOGINACTIVITY","Status code = "+response.code());
                if (response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                    progressDFragment = ProgressDFragment.newInstance( "loading.. wait..." );
                    sharedPrefsHelper.saveValue( Constant.TOKEN,response.body().getToken() );
                    sharedPrefsHelper.saveValue( Constant.FIRST_LOAD, true );
                    sharedPrefsHelper.saveValue( Constant.EMAIL,response.body().getUser().getEmail());
                    sharedPrefsHelper.saveValue( Constant.NAME,response.body().getUser().getName() );
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                }else{
                    Toast.makeText(LoginActivity.this, "Invalid username or password. Try Again !!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Check your internet connection",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService( Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();

    }
}
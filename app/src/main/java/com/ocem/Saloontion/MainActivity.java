package com.ocem.Saloontion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ocem.Saloontion.fragment.HomeFragment;
import com.ocem.Saloontion.fragment.NotificationFragment;
import com.ocem.Saloontion.fragment.ProfileFragement;
import com.ocem.Saloontion.fragment.SaloontionFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;
    private SharedPreferences sharedPreferences;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        broadcastReceiver = new BroadcastReceiver();

        bnv_Main = findViewById( R.id.bnv_Main );
        bnv_Main.add( new MeowBottomNavigation.Model( 1, R.drawable.ic_baseline_home_24 ) );
        bnv_Main.add( new MeowBottomNavigation.Model( 2, R.drawable.ic_baseline_list_alt_24 ) );
        bnv_Main.add( new MeowBottomNavigation.Model( 3, R.drawable.ic_baseline_notifications_none_24 ) );
        bnv_Main.add( new MeowBottomNavigation.Model( 4, R.drawable.ic_baseline_account_circle_24 ) );

        bnv_Main.show( 1, true );
        replace( new HomeFragment() );
        bnv_Main.setOnClickMenuListener( new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()) {
                    case 1:
                        replace( new HomeFragment() );
                        break;

                    case 2:
                        replace( new SaloontionFragment() );
                        break;


                    case 3:
                        replace( new NotificationFragment() );
                        break;

                    case 4:
                        replace( new ProfileFragement() );
                        break;
                }

                return null;
            }

        } );

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace( R.id.frame,fragment );
        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver( broadcastReceiver, intentFilter );
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver( broadcastReceiver );
    }
}

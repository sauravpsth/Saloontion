package com.ocem.Saloontion.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.ocem.Saloontion.AboutUs;
import com.ocem.Saloontion.LoginActivity;
import com.ocem.Saloontion.MainActivity;
import com.ocem.Saloontion.MyAppointments;
import com.ocem.Saloontion.Permission;
import com.ocem.Saloontion.R;
import com.ocem.Saloontion.SignUp;
import com.ocem.Saloontion.adapter.MyAppointmentAdapter;
import com.ocem.Saloontion.sharedpreference.Constant;
import com.ocem.Saloontion.sharedpreference.SharedPrefsHelper;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragement extends Fragment {
    TextView textView2, textView3,email;
    CircleImageView image;
    SharedPrefsHelper sharedPrefsHelper;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    TextView textView,tvTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate( R.layout.fragment_profile,container,false );

        sharedPrefsHelper = SharedPrefsHelper.getInstance( getActivity() );

        textView2=v.findViewById( R.id.tvab );
        email = v.findViewById( R.id.tve );
        image = v.findViewById( R.id.imageview1 );
        tvTV = v.findViewById( R.id.tvapp1 );

      /*  textView.setText( sharedPrefsHelper.getValue( Constant.ID,"" ) );*/

        textView2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(getActivity(),AboutUs.class);
                startActivity( intent2 );
            }
        } );

        textView3 = v.findViewById( R.id.log );
        textView3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefsHelper.clear();
                Intent intent3 = new  Intent(getActivity(),LoginActivity.class);
                startActivity( intent3 );
            }
        } );
        email.setText( sharedPrefsHelper.getValue( Constant.EMAIL,"" ) );

        image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     /*           Intent gallery = new Intent();
                gallery.setType( "image/" );
                gallery.setAction( Intent.ACTION_GET_CONTENT );

                startActivityForResult( Intent.createChooser( gallery,"Select Picture" ), PICK_IMAGE );
*/
            }
        } );

        tvTV.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getActivity(), MyAppointments.class ) );
            }
        } );

return v;
    }

/*    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );
        if (requestCode == CAMERA_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText( getActivity(), "Permission granted", Toast.LENGTH_SHORT ).show();
                Intent cameraIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
                startActivityForResult( cameraIntent, CAMERA_REQUEST );
            } else {
                Toast.makeText( getActivity(), "Permission denied", Toast.LENGTH_SHORT ).show();
            }
        }
    }

        @Override
        public void onActivityResult ( int requestCode, int resultCode, Intent data){
            if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
                imageUri= data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap( getActivity().getContentResolver(),imageUri );
                    image.setImageBitmap( bitmap );

                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }

    public void callCamera(Activity activity,String... permissions) {

        if (ContextCompat.checkSelfPermission( activity, Manifest.permission.CAMERA ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions( activity, new String[]{Manifest.permission.CAMERA},CAMERA_REQUEST );
        }
        else {
            startActivity( new Intent(MediaStore.ACTION_IMAGE_CAPTURE) );

        }

    }*/
    }

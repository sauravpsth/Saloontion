package com.ocem.Saloontion;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Permission {

    private static final int REQUEST_CALL = 1;
    private static final int GALLERY_REQUEST = 2;
    private static final int CAMERA_REQUEST = 3;
    private static final int CALL_REQUEST= 4;
    private static final int LOCATION_REQUEST= 4;


  /*  public void makePhoneCall(Activity activity,String number, String... permissions) {

        if (Build.VERSION.SDK_INT >= 23) {

            if (number.trim().length() > 0) {

                if (ContextCompat.checkSelfPermission( activity, Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions( activity, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL );
                } else {
                    String dial = "tel:" + number;
                    activity.startActivity( new Intent( Intent.ACTION_CALL, Uri.parse( dial ) ) );

                }

            } else {
                Toast.makeText( activity, "Enter Phone number", Toast.LENGTH_SHORT ).show();
            }
        }
        else {

        }
    }
*/
/*    public void onRequestPermissionResult(Activity activity,int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall(activity, "number" );
            } else {
                Toast.makeText(activity, "Permission denied", Toast.LENGTH_SHORT ).show();
            }
        }
    }*/

    public void callGallery(Activity activity,String... permissions) {

        if (ContextCompat.checkSelfPermission( activity, Manifest.permission.WRITE_EXTERNAL_STORAGE ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions( activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},GALLERY_REQUEST );
        }
        else {
            activity.startActivity(new Intent( Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI));

        }

    }

    public void askGallery(Activity activity,int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == GALLERY_REQUEST){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText( activity, "Permission granted", Toast.LENGTH_SHORT ).show();
            } else {
                Toast.makeText(activity, "Permission denied", Toast.LENGTH_SHORT ).show();
            }
        }
    }

    public void callCamera(Activity activity,String... permissions) {

        if (ContextCompat.checkSelfPermission( activity, Manifest.permission.CAMERA ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions( activity, new String[]{Manifest.permission.CAMERA},CAMERA_REQUEST );
        }
        else {
            activity.startActivity(new Intent( MediaStore.ACTION_IMAGE_CAPTURE ));

        }

    }

    public void askCamera(Activity activity,int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_REQUEST){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText( activity, "Permission granted", Toast.LENGTH_SHORT ).show();
                Intent cameraIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
                activity.startActivityForResult( cameraIntent, CAMERA_REQUEST );
            } else {
                Toast.makeText(activity, "Permission denied", Toast.LENGTH_SHORT ).show();
            }
        }
    }

    public void onActivityResult (int requestCode,int resultCode, Intent data){
        if (requestCode == CAMERA_REQUEST && resultCode==Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get( "data" );

        }
    }

    public void callContact(Activity activity,String... permissions) {

        if (ContextCompat.checkSelfPermission( activity, Manifest.permission.READ_CONTACTS ) != PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions( activity, new String[]{Manifest.permission.READ_CONTACTS},CALL_REQUEST );
        }
        else {
            activity.startActivity(new Intent( Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI));

        }

    }

/*    public void askContact(Activity activity,int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CALL_REQUEST){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText( activity, "Permission granted", Toast.LENGTH_SHORT ).show();
            } else {
                Toast.makeText(activity, "Permission denied", Toast.LENGTH_SHORT ).show();
            }
        }
    }*/


}

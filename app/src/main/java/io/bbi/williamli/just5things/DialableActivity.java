package io.bbi.williamli.just5things;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class DialableActivity extends AppCompatActivity {
    final int MY_PERMISSIONS_REQUEST_CALL_PRIVILEGED = 9;

    private String phone = "";

    protected void dial(String number, Activity activity, View view) {

        phone = number;

        // try to get call permission if possible
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.CALL_PHONE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                Snackbar.make(view, getString(R.string.dial_permission_explaination) + " " + phone, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

                doCall();

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PRIVILEGED);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.

                Snackbar.make(view, getString(R.string.dial_permission_explaination) + " " + phone, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        } else {

            // have permission

            doCall();
        }



    }

    private void doCall () {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));


        try {

            startActivity(callIntent);

        } catch (Exception e) {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));

            startActivity(dialIntent);

            //Snackbar.make(view, "Error calling "+R.string.phone_05+", make sure you have enough permission", Snackbar.LENGTH_LONG)
            //.setAction("Action", null).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PRIVILEGED: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    doCall();

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    doCall();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}

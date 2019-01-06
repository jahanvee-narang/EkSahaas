package com.example.jahanveenarang.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Danger extends AppCompatActivity {

    AppLocation appLocationService;
    String mess,m;
    String number1 = "8872512428";
    String number2 = "9990119716";
    String number3 = "8383973668";
    String n ;

    String number;

    Geocoder geocoder;
    List<Address> addresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danger);

        appLocationService=new AppLocation(Danger.this);

        number=number2+","+number1+","+number3;
        n=number1.concat(",").concat(number2).concat(", ").concat(number3);
        n=n.trim();


        Location nwLocation = appLocationService.getLocation(LocationManager.NETWORK_PROVIDER);
        if(nwLocation!=null) {
            Double latitude = nwLocation.getLatitude();
            Double longitude = nwLocation.getLongitude();
            geocoder = new Geocoder(this, Locale.getDefault());
            try {
                addresses = geocoder.getFromLocation(latitude, longitude, 2);
                String address = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                m = "Current Location : " + "\nLatitude : " + latitude + " \nLongitude : " + longitude + "\nAddress : " + address +","+ city +","+ state
                        + ","+ country ;
                mess = m + " " +
                        " \nMessage : " + "\nI am in danger!";
                /* tv1.setText(m);*/
                Toast.makeText(getApplicationContext(),"Latitude :"+latitude+"  Longitude:"+longitude+"   Address  :"+address+" " +
                        "  City :"+city+"   State :"+state+"  Country :"+country,Toast.LENGTH_LONG).show();
                SendSms();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        else {
            showSettingsAlert("Network");
        }



    }

    private void SendSms() {


        /* Intent i = new Intent(Intent.ACTION_SENDTO, Uri.("smsto:"number1));*/
        Intent i = new Intent(Intent.ACTION_VIEW);

        /* i.putExtra("sms_body",mess);*/
        i.setData(Uri.parse("smsto:"));
        i.setType("vnd.android-dir/mms-sms");
        i.putExtra("address"  , new String (n));
        i.putExtra("sms_body",mess);

        startActivity(i);
    }







    public void showSettingsAlert(String provider)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Danger.this);
        builder.setTitle(provider + " SETTINGS");
        builder.setMessage(provider + " is not enabled!" + " Want to go to Settings menu ?");
        builder.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                Danger.this.startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}

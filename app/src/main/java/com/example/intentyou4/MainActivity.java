package com.example.intentyou4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    protected Button b1;
    protected EditText et1;
    protected EditText et2;
    protected EditText et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       b1=findViewById(R.id.buttom);
       et1=findViewById(R.id.et1);
       et2=findViewById(R.id.et2);
       et3=findViewById(R.id.et3);
       String[]A={"dcosxx@gmail.com"};
       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL ,new String[]{et1.getText().toString()});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, " email subject");
                emailIntent.putExtra(Intent.EXTRA_CC, new String[]{et2.getText().toString()});
                emailIntent.putExtra(Intent.EXTRA_TEXT, et3.getText().toString());

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activitiesList = packageManager.queryIntentActivities(emailIntent, 0);
                if (activitiesList.size() >= 1) {
                    startActivity(emailIntent);
                } else {

                }


            }
        });
    }
}
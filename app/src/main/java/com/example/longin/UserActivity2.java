package com.example.longin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserActivity2 extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);

        mp=MediaPlayer.create(getApplicationContext(),R.raw.dingdong);
        mp.start();
        Bundle data = this.getIntent().getExtras();
        String name=data.getString("account");
        int age = data.getInt("age");
        Toast.makeText(getApplicationContext(),name+age, Toast.LENGTH_LONG).show();

        Button dialbtn = findViewById(R.id.dialbtn);
        dialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri  phone = Uri.parse("tel://123456");
                Intent it = new Intent(Intent.ACTION_CALL,phone);
                startActivity(it);
            }
        });

        Button webbtn = findViewById(R.id.webbtn);
        webbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri web = Uri.parse("http://www.pu.edu.tw");
                Intent it  = new Intent(Intent.ACTION_VIEW, web);
                startActivity(it);
            }
        });
        Button exitbtn = findViewById(R.id.exitbtn);
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =getIntent();
                Bundle data = new Bundle();
                data.putString("key","mydata");
                it.putExtras(data);
                setResult(1000,it);
                finish();
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("log", "onStop");
        //  mp.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("log", "onPause");
        mp.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("log", "onResume");
        mp.start();
    }
}
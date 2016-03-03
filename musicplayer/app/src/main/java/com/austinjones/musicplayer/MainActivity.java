package com.austinjones.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mPlayBtn;
    Button mPauseBtn;
    Button mStopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayBtn = (Button)findViewById(R.id.playBtn);
        mPauseBtn = (Button)findViewById(R.id.pauseBtn);
        mStopBtn = (Button)findViewById(R.id.stopBtn);

        mPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MyService.class);
                startService(i);
            }
        });

        mPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MyService.class);
                i.putExtra("PAUSE",true);
                stopService(i);
            }
        });

        mStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MyService.class);
                stopService(i);
            }
        });

    }
}

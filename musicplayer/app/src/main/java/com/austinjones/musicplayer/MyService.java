package com.austinjones.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by austinjones on 3/2/16.
 */
public class MyService extends Service {

    final MediaPlayer mPlayer = new MediaPlayer();
    boolean isPlaying = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            //isPlaying = intent.getBooleanExtra("PAUSE",false);
            String url = "http://download.lisztonian.com/music/download/Clair+de+Lune-113.mp3";
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mPlayer.setDataSource(url);
            mPlayer.prepareAsync();
            mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mPlayer.start();
                    Toast.makeText(MyService.this, "Starting", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Throwable thr){
        }
        //Toast.makeText(MyService.this, "Running", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
        Toast.makeText(MyService.this, "Stopped", Toast.LENGTH_SHORT).show();
    }
}

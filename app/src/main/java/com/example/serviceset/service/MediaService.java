package com.example.serviceset.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.serviceset.R;

/**
 * Created by Administrator on 2018/4/20.
 */

public class MediaService extends Service {
    private String mTag="mediaService";
    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"mediaService onBind",Toast.LENGTH_LONG).show();
        Log.e(mTag,"mediaService onBind");
        player.start();
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"mediaService unBind",Toast.LENGTH_LONG).show();
        Log.e(mTag,"mediaService unBind");

        player.stop();
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
//        super.onCreate();
        Toast.makeText(this,"mediaService oncreate",Toast.LENGTH_LONG).show();
        Log.e(mTag,"mediaService oncreate");
        player=MediaPlayer.create(this, R.raw.demo);
        player.setLooping(true);//设置重复播放

    }

    @Override
    public void onStart(Intent intent, int startId) {
//        super.onStart(intent, startId);
        Toast.makeText(this,"mediaService onstart",Toast.LENGTH_LONG).show();
        Log.e(mTag,"mediaService onstart");

        player.start();

    }

    @Override
    public void onDestroy() {
//        super.onDestroy();
        Toast.makeText(this,"mediaService ondestroy",Toast.LENGTH_LONG).show();
        Log.e(mTag,"mediaService ondestroy");
        player.stop();

    }
}

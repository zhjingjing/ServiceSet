package com.example.serviceset.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.serviceset.R;

public class ServiceActivity extends Activity implements View.OnClickListener {
    private Button btStart,btStop,btBind,btUnBind;
    private String mTag="ServiceActivity";
    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Toast.makeText(ServiceActivity.this,"onServiceConnected",Toast.LENGTH_LONG).show();
            Log.e("ServiceActivity","onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Toast.makeText(ServiceActivity.this,"onServiceDisconnected",Toast.LENGTH_LONG).show();
            Log.e("ServiceActivity","onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initView();
        btStart.setOnClickListener(this);
        btStop.setOnClickListener(this);
        btBind.setOnClickListener(this);
        btUnBind.setOnClickListener(this);
    }



    private void initView() {
        btStart=findViewById(R.id.bt_start);
        btStop=findViewById(R.id.bt_stop);
        btBind=findViewById(R.id.bt_bind);
        btUnBind=findViewById(R.id.bt_unbind);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(ServiceActivity.this,com.example.serviceset.service.MediaService.class);
        switch (view.getId()){
            case R.id.bt_bind:
                this.bindService(intent,conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.bt_start:
                startService(intent);
                break;
            case R.id.bt_stop:
                stopService(intent);
                break;
            case R.id.bt_unbind:
                unbindService(conn);
                break;

        }
    }
}

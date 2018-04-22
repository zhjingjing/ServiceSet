package com.example.serviceset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.serviceset.service.ServiceActivity;

public class MainActivity extends Activity {
    private Button btnService,btnMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();

        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        btnMedia=findViewById(R.id.bt_media);
        btnService=findViewById(R.id.bt_service);

    }
}

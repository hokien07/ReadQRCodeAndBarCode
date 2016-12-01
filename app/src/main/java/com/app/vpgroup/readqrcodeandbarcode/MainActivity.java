package com.app.vpgroup.readqrcodeandbarcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnBarCode, btnQrCode, btnCreateQrCode, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControl();

        btnBarCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReadBarCodeActivity.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentDialog fragmentDialog = new FragmentDialog();
                fragmentDialog.show(fm, "fragment");
            }
        });

    }

    private void AddControl(){
        btnBarCode      = (Button) findViewById(R.id.btnReadBarCode);
        btnQrCode       = (Button) findViewById(R.id.btnReadQrCode);
        btnCreateQrCode = (Button) findViewById(R.id.btnCreatQrCode);
        btnInfo          = (Button) findViewById(R.id.btnInfo);
    }

}

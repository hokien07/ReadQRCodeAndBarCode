package com.app.vpgroup.readqrcodeandbarcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class ReadBarCodeActivity extends AppCompatActivity {

    TextView barcodeInfo;
    SurfaceView cameraView;
    CameraSource cameraSource;
    Button btnFindContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_bar_code);

        AddControl();

        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.CODE_128).build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector).setRequestedPreviewSize(640, 480).build();

        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
//                try {
//                    cameraSource.start(cameraView.getHolder());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cameraSource.stop();

            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                if (barcodes.size() != 0){
                    barcodeInfo.post(new Runnable() {
                        @Override
                        public void run() {
                            barcodeInfo.setText(barcodes.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });


        btnFindContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReadBarCodeActivity.this, "Thong tin san pham", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void AddControl(){
        barcodeInfo     = (TextView)findViewById(R.id.txtContent);
        cameraView      = (SurfaceView)findViewById(R.id.surfaceView);
        btnFindContent  = (Button) findViewById(R.id.btnFind);
    }

}

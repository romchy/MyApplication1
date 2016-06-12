package com.example.roman.iot_nadzor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);
    }

    public void QrScanner(View view){


        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Start camera

    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

        Log.e("handler", rawResult.getText()); // Prints scan results
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        // check if result is a json object
        /*
        Gson gson = new Gson();
        String json = rawResult.getText();
        Device device = gson.fromJson(json, Device.class);
        boolean isDevice = false;
        Pattern URL_PATTERN = Patterns.WEB_URL;
        boolean isURL = URL_PATTERN.matcher(json).matches();
        if(device != null){
            // return the object od Device to QrScannerActivity result
            isDevice = true;
        }
        else if(isURL){     // check if rawResult.getText() returns a string that represents an url
            // if it's an URL then make a request to get JSON string as response
        }
*/

        // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(this,"You clicked no button", Toast.LENGTH_LONG).show();
                mScannerView.stopCamera();
                mScannerView.stopCameraPreview();
                setContentView(R.layout.activity_qr_scanner);
            }
        });
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(ac,"You clicked yes button", Toast.LENGTH_LONG).show();
                //Toast.makeText(ac, "BRISANJE" + position,Toast.LENGTH_SHORT).show();
                //Device d = mDataset.remove(position);
                //notifyItemRemoved(position);
                mScannerView.stopCamera();
                mScannerView.stopCameraPreview();
                setContentView(R.layout.activity_qr_scanner);
            }
        });
        AlertDialog alert1 = builder.create();
        alert1.show();

        // If you would like to resume scanning, call this method below:
        // mScannerView.resumeCameraPreview(this);
    }
}

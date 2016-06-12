package com.example.roman.iot_nadzor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.Device;
import com.example.DeviceType;

public class StatusActivity extends AppCompatActivity {

    private TextView tvOutType;
    private TextView tvOut;
    private RadioGroup rgOut;
    private RadioButton rbOutBtn;
    private RadioButton rbOutSw;
    private RadioButton rbOutEt;
    private Button btnOut;
    private Switch swOut;
    private EditText etOut;

    private TextView tvInType;
    private TextView tvIn;
    private RadioGroup rgIn;
    private RadioButton rbInBtn;
    private RadioButton rbInEt;
    private Button lightIn;
    private EditText textIn;

    private ApplicationMy app;
    private Device current;
    private DeviceType type;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        //System.out.println();
        //current = app.getAll().getDevice(position);
        Intent intent = getIntent();
        position = intent.getIntExtra("POSITION_DEVICE",0);
        System.out.println("POSITION " + position);
        app = (ApplicationMy) getApplication();
        current = app.getAll().getDevice(position);
        // status.putExtra(PARAMETER_POSITION_1,position);
        //position = intent.getStringExtra("POSITION_DEVICE");

        tvOutType = (TextView) findViewById(R.id.tvOutputType);
        tvOut = (TextView) findViewById(R.id.tvOutput);
        rgOut = (RadioGroup) findViewById(R.id.rgOutputType);
        rbOutBtn = (RadioButton) findViewById(R.id.rbButton);
        rbOutSw = (RadioButton) findViewById(R.id.rbSwitch);
        rbOutEt = (RadioButton) findViewById(R.id.rbEditText);
        btnOut = (Button) findViewById(R.id.buttonOut);
        swOut = (Switch) findViewById(R.id.switchOut);
        etOut = (EditText) findViewById(R.id.etOut);

        tvInType = (TextView) findViewById(R.id.tvInputType);
        tvIn = (TextView) findViewById(R.id.tvInput);
        rgIn = (RadioGroup) findViewById(R.id.rgInputType);
        rbInBtn = (RadioButton) findViewById(R.id.rbLight);
        rbInEt = (RadioButton) findViewById(R.id.rbInEditText);
        lightIn = (Button) findViewById(R.id.buttonIn);
        textIn = (EditText) findViewById(R.id.etInp);

        btnOut.setVisibility(View.INVISIBLE);
        swOut.setVisibility(View.INVISIBLE);
        etOut.setVisibility(View.INVISIBLE);

        lightIn.setVisibility(View.INVISIBLE);
        textIn.setVisibility(View.INVISIBLE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        current = all.getDevice(Integer.parseInt(position));*/
        type = current.getType();
        setViewByType(type);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void selectOutput(View v){
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.rbButton:
                if(checked){
                    btnOut.setVisibility(View.VISIBLE);
                    swOut.setVisibility(View.INVISIBLE);
                    etOut.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.rbSwitch:
                if(checked){
                    btnOut.setVisibility(View.INVISIBLE);
                    swOut.setVisibility(View.VISIBLE);
                    etOut.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.rbEditText:
                if(checked){
                    btnOut.setVisibility(View.INVISIBLE);
                    swOut.setVisibility(View.INVISIBLE);
                    etOut.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    public void selectInput(View v){
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.rbLight:
                if (checked){
                    lightIn.setVisibility(View.VISIBLE);
                    textIn.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.rbInEditText:
                if (checked){
                    lightIn.setVisibility(View.INVISIBLE);
                    textIn.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    public void setViewByType(DeviceType devType){
        switch (type){
            case SENSOR:
                tvOutType.setVisibility(View.GONE);
                tvOut.setVisibility(View.GONE);
                rgOut.setVisibility(View.GONE);
                rbOutBtn.setVisibility(View.GONE);
                rbOutSw.setVisibility(View.GONE);
                rbOutEt.setVisibility(View.GONE);
                btnOut.setVisibility(View.GONE);
                swOut.setVisibility(View.GONE);
                etOut.setVisibility(View.GONE);

                tvInType.setVisibility(View.VISIBLE);
                tvIn.setVisibility(View.VISIBLE);
                rgIn.setVisibility(View.VISIBLE);
                rbInBtn.setVisibility(View.VISIBLE);
                rbInEt.setVisibility(View.VISIBLE);
                lightIn.setVisibility(View.INVISIBLE);
                textIn.setVisibility(View.INVISIBLE);
                break;
            case ACTUATOR:
                tvOutType.setVisibility(View.VISIBLE);
                tvOut.setVisibility(View.VISIBLE);
                rgOut.setVisibility(View.VISIBLE);
                rbOutBtn.setVisibility(View.VISIBLE);
                rbOutSw.setVisibility(View.VISIBLE);
                rbOutEt.setVisibility(View.VISIBLE);
                btnOut.setVisibility(View.INVISIBLE);
                swOut.setVisibility(View.INVISIBLE);
                etOut.setVisibility(View.INVISIBLE);

                tvInType.setVisibility(View.GONE);
                tvIn.setVisibility(View.GONE);
                rgIn.setVisibility(View.GONE);
                rbInBtn.setVisibility(View.GONE);
                rbInEt.setVisibility(View.GONE);
                lightIn.setVisibility(View.GONE);
                textIn.setVisibility(View.GONE);
                break;
            case TRANSDUCER:
                tvOutType.setVisibility(View.VISIBLE);
                tvOut.setVisibility(View.VISIBLE);
                rgOut.setVisibility(View.VISIBLE);
                rbOutBtn.setVisibility(View.VISIBLE);
                rbOutSw.setVisibility(View.VISIBLE);
                rbOutEt.setVisibility(View.VISIBLE);
                btnOut.setVisibility(View.INVISIBLE);
                swOut.setVisibility(View.INVISIBLE);
                etOut.setVisibility(View.INVISIBLE);

                tvInType.setVisibility(View.VISIBLE);
                tvIn.setVisibility(View.VISIBLE);
                rgIn.setVisibility(View.VISIBLE);
                rbInBtn.setVisibility(View.VISIBLE);
                rbInEt.setVisibility(View.VISIBLE);
                lightIn.setVisibility(View.INVISIBLE);
                textIn.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
/*
 private RadioGroup rgOut;
rbOutBtn;
rbOutSw;
rbOutEt;
btnOut;
swOut;
etOut;

rgIn;
rbInBtn;
rbInEt;
lightIn;
textIn;
*/
/*
 private RadioGroup rgOut;
    private RadioButton rbOutBtn;
    private RadioButton rbOutSw;
    private RadioButton rbOutEt;
    private Button btnOut;
    private Switch swOut;
    private EditText etOut;

    private RadioGroup rgIn;
    private RadioButton rbInBtn;
    private RadioButton rbInEt;
    private Button lightIn;
    private EditText textIn;
    */
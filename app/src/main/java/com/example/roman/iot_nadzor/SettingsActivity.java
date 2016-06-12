package com.example.roman.iot_nadzor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Device;
import com.example.DeviceType;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public final static String JSON_MESSAGE = "some json message";
    private EditText etName;
    private RadioGroup rGroup;
    private RadioButton rbIn;
    private RadioButton rbOut;
    private RadioButton rbInOut;

    /** ali pa namesto treh dolocimo kar enega skupnega: */
    //private RadioButton radio_b;

    private EditText etUrl;
    private EditText etchId;
    private Spinner inField;
    private Spinner outField;
    private TextView inTxt;
    private TextView outTxt;

    private EditText etApiKey;
    private EditText etWriteKey;
    private EditText etReadKey;

    private ApplicationMy app;
    private Device selected;
    private DeviceType type;
    private int position;
    private Activity ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        position = intent.getIntExtra("POSITION_DEVICE",0);
        System.out.println("POSITION " + position);

        app = (ApplicationMy) getApplication();
        selected = app.getAll().getDevice(position);

        etName = (EditText) findViewById(R.id.etNameSet);
        rGroup = (RadioGroup) findViewById(R.id.radioGroupSet);
        rbIn = (RadioButton) findViewById(R.id.rbInputSet);
        rbOut = (RadioButton) findViewById(R.id.rbOutputSet);
        rbInOut = (RadioButton) findViewById(R.id.rbInOutSet);
        etUrl = (EditText) findViewById(R.id.etURLSet);
        etchId = (EditText) findViewById(R.id.etChIDSet);
        inField = (Spinner) findViewById(R.id.inField);
        outField = (Spinner) findViewById(R.id.outField);
        inTxt = (TextView) findViewById(R.id.intxt);
        outTxt = (TextView) findViewById(R.id.outtxt);

        etApiKey = (EditText) findViewById(R.id.etApiKeySet);
        etWriteKey = (EditText) findViewById(R.id.etWriteKeySet);
        etReadKey = (EditText) findViewById(R.id.etReadKeySet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.fields,android.R.layout.simple_spinner_item);
        inField.setAdapter(adapter);
        inField.setOnItemSelectedListener(this);
        outField.setAdapter(adapter);
        outField.setOnItemSelectedListener(this);

        inField.setVisibility(View.GONE);
        outField.setVisibility(View.GONE);
        inTxt.setVisibility(View.GONE);
        outTxt.setVisibility(View.GONE);

        //app = (ApplicationMy) getApplication();
        //selected = app.getAll().getDevice(0);
        if(selected!=null){
            setForm(selected);
        }



        /*
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //super.onOptionsItemSelected(item);


        switch (item.getItemId()) {
            case R.id.action_add:
                // krneki
                Toast.makeText(this, "Menus item is selected: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                //return super.onOptionsItemSelected(item);
                break;
            case R.id.action_save:
                // krneki
                Toast.makeText(this, "Menus item is selected: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                //return true;
                break;
            case R.id.action_qr:
                Toast.makeText(this, "Menus item is selected: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                /*
                Intent qrintent = new Intent(SettingsActivity.this, QrEncodeActivity.class);
                //qrintent.putExtra(JSON_MESSAGE, "Some extra message");
                startActivity(qrintent);
                */
                // krneki
                //return true;
                break;
            default:
                Toast.makeText(this, "Menus item is selected: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                super.onBackPressed();
                break;
            //return super.onOptionsItemSelected(item);
        }
        /*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView mytext = (TextView) view;
        //Toast.makeText(this,"Item selected: " + mytext.getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void selectType(View v) {
        boolean checked = ((RadioButton) v).isChecked(); // TODO: Dokončaj
        switch (v.getId()){
            case R.id.rbInputSet:
                if(checked){
                    rbIn.setChecked(true);
                    inField.setVisibility(View.VISIBLE);
                    outField.setVisibility(View.GONE);
                    inTxt.setVisibility(View.VISIBLE);
                    outTxt.setVisibility(View.GONE);
                }
                break;
            case R.id.rbOutputSet:
                if(checked){
                    rbOut.setChecked(true);
                    inField.setVisibility(View.GONE);
                    outField.setVisibility(View.VISIBLE);
                    inTxt.setVisibility(View.GONE);
                    outTxt.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.rbInOutSet:
                if(checked){
                    rbInOut.setChecked(true);
                    inField.setVisibility(View.VISIBLE);
                    outField.setVisibility(View.VISIBLE);
                    inTxt.setVisibility(View.VISIBLE);
                    outTxt.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    public int getPosition(Spinner spinner, String fieldName){
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(fieldName)){
                index = i;
            }
        }
        return index;
    }
/*
    public void openQrEncodeActivity(View view){
        Intent intent = new Intent(this, QrEncodeActivity.class);
        intent.putExtra("JsonTest", "testJson");
        startActivity(intent);
    }
*/
    public void setForm(Device d){
        etName.setText(d.getName());
        /*
        rbIn = (RadioButton) findViewById(R.id.rbInputSet);
        rbOut = (RadioButton) findViewById(R.id.rbOutputSet);
        rbInOut = (RadioButton) findViewById(R.id.rbInOutSet);*/
        type = d.getType();
        switch (type){
            case SENSOR:
                rbIn.setChecked(true);
                inTxt.setVisibility(View.VISIBLE);
                inField.setVisibility(View.VISIBLE);
                inField.setSelection(getPosition(inField, "field" + d.getInfield().getNr()));
                outTxt.setVisibility(View.GONE);
                outField.setVisibility(View.GONE);
                break;
            case ACTUATOR:
                rbOut.setChecked(true);
                inTxt.setVisibility(View.GONE);
                inField.setVisibility(View.GONE);
                outTxt.setVisibility(View.VISIBLE);
                outField.setVisibility(View.VISIBLE);
                outField.setSelection(getPosition(inField, "field" + d.getInfield().getNr()));
                break;
            case TRANSDUCER:
                rbInOut.setChecked(true);
                inTxt.setVisibility(View.VISIBLE);
                inField.setVisibility(View.VISIBLE);
                inField.setSelection(getPosition(inField, "field" + d.getInfield().getNr()));
                outTxt.setVisibility(View.VISIBLE);
                outField.setVisibility(View.VISIBLE);
                outField.setSelection(getPosition(inField, "field" + d.getInfield().getNr()));
                break;
        }
        etUrl.setText(d.getUrl());
        etchId.setText(d.getChannelID());

        etApiKey.setText(d.getApiKey());
        etWriteKey.setText(d.getWrieKey());
        etReadKey.setText(d.getReadKey());
    }
}

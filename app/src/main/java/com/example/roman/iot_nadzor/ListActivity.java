package com.example.roman.iot_nadzor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ApplicationMy app;
    Activity ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        app = (ApplicationMy) getApplication();
        ac = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //settingsDialog(view);
                //qrGenerator(view);
                //qrScanner(view);
                addDialog(view);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new AdapterDevice(app.getAll(), this);
        mRecyclerView.setAdapter(mAdapter);
        registerForContextMenu(mRecyclerView);
    }

    public void toast(View v){
        View view = getLayoutInflater().inflate(R.layout.toast, (ViewGroup) findViewById(R.id.root));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    public void  qrGenerator(View v){
        Intent gen = new Intent(ac, QrGeneratorActivity.class);
        //status.putExtra(PARAMETER_POSITION_1,position);
        ac.startActivity(gen);
    }

    public void qrScanner(View v){
        Intent scan = new Intent(ac, QrScannerActivity.class);
        ac.startActivity(scan);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.list_popup_menu, menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Snackbar.make(findViewById(R.id.SettingsLayout), "Dodana nova naprava", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(ac);
        builder.setTitle("Add Device");
        builder.setItems(R.array.add_dialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ac,"You clicked item" + which, Toast.LENGTH_LONG).show();
                switch (which){
                    case 0:
                        // Export to QR
                        /*
                        Intent qr_encode = new Intent(ac, QrEncodeActivity.class);
                        qr_encode.putExtra(PARAMETER_POSITION_1,position);
                        ac.startActivity(qr_encode);
                        */
                        Intent qrScan = new Intent(ac, QrScannerActivity.class);
                        ac.startActivity(qrScan);
                        break;
                    case 1:
                        // Import from QR
                        Intent manualInput = new Intent(ac, SettingsActivity.class);
                        ac.startActivity(manualInput);
                        break;
                }
            }
        });



        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
/*
    public void settingsDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ac);
        builder.setTitle("Settings");
        builder.setItems(R.array.add_dialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ListActivity.this, "You clicked item" + which, Toast.LENGTH_LONG).show();
                switch (which) {
                    case 0:
                        // Export to QR
                        break;
                    case 1:
                        // Import from QR
                        break;
                }
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ListActivity.this,"You clicked Cancel button", Toast.LENGTH_LONG).show();
            }
        });
    }*/
/*
   // @Override
    public boolean onContextItemSelected(MenuItem item){
        //mAdapter.
        mAdapter.getItemSelected(item);
        return super.onContextItemSelected(item);
    }*/
}

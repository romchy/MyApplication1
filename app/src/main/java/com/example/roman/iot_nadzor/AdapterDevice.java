package com.example.roman.iot_nadzor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.DataAll;
import com.example.Device;
import com.google.gson.Gson;

/**
 * Created by Roman on 16.5.2016.
 */
public class AdapterDevice extends RecyclerView.Adapter<AdapterDevice.ViewHolder> {
    public static final String PARAMETER_POSITION_1 = "POSITION_DEVICE";
    private DataAll mDataset;
    Activity ac;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnLongClickListener */{
        // each data item is just a string in this case

        public CardView cv;
        public ImageView icon;
        public TextView tv_Name;
        public TextView tv_Desc;
        public TextView tv_In;
        public TextView tv_Out;
        public ImageView iv;
        public ImageView ivDelete;
        public ImageView ivStatus;
        LongClickListener longClickListener;

        //ThingSpeakChannel tsPrivateChannel = new ThingSpeakChannel(CHANNEL_ID, READ_API_KEY);

        public ViewHolder(View v) {
            super(v);

            cv = (CardView) v.findViewById(R.id.cv);
            icon = (ImageView) v.findViewById(R.id.iot_photo);
            tv_Name = (TextView) v.findViewById(R.id.iot_name);
            tv_Desc = (TextView) v.findViewById(R.id.iot_desc);
            tv_In = (TextView) v.findViewById(R.id.iot_indic_in);
            tv_Out = (TextView) v.findViewById(R.id.iot_indic_out);
            iv = (ImageView)v.findViewById(R.id.iot_photo);
            ivDelete = (ImageView) v.findViewById(R.id.iot_delete);
            ivStatus = (ImageView) v.findViewById(R.id.iot_indicator);

 /*           v.setOnLongClickListener(this);*/
            //v.setOnCreateContextMenuListener(this);

        }

        public void setLongClickListener(LongClickListener lc){
            this.longClickListener = lc;
        }

/*
        @Override
        public boolean onLongClick(View view){
            //super(view);
            this.longClickListener.onItemLongClick(getLayoutPosition());
            return false;
        }*/
/*
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
            menu.setHeaderTitle("Select An Option");
            menu.add(0,0,0,"Edit");
            menu.add(0,1,0,"Delete");
        }*/

    }

    public AdapterDevice(DataAll myDataset, Activity ac) {
        this.ac = ac;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterDevice.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Device current = mDataset.getDevice(position);

        // ThingSpeakChannel tsPrivateChannel = new ThingSpeakChannel(CHANNEL_ID, READ_API_KEY);
        /*
        long CHANNEL_ID = Long.parseLong(current.getChannelID());
        String READ_API_KEY = current.getReadKey();
        ThingSpeakChannel tsPrivateChannel = new ThingSpeakChannel(CHANNEL_ID, READ_API_KEY);
        tsPrivateChannel.setChannelFeedUpdateListener(new ThingSpeakChannel.ChannelFeedUpdateListener() {
            @Override
            public void onChannelFeedUpdated(long channelId, String channelName, ChannelFeed channelFeed) {
                // Make use of your Channel feed here!
            }
        });
        tsPrivateChannel.loadChannelFeed();
        */

        final String name = current.getName();
        holder.tv_Name.setText(current.getName());
        //holder.txtTip.setText(current.getTip());
        switch (current.getType()) {
            case SENSOR:
                holder.icon.setImageResource(R.mipmap.ic_sensor);
                break;
            case ACTUATOR:
                holder.icon.setImageResource(R.mipmap.ic_actuator);
                break;
            case TRANSDUCER:
                holder.icon.setImageResource(R.mipmap.ic_transducer);
                break;
        }
        /*
        if (DataAll.picture(current.getTip())==1)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.chronometer));
        if (DataAll.picture(current.getTip())==2)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.recordicon));*/
        /*

         */
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {           // TODO: DOKONCAJ, KO UREDIS STRAN Z NASTAVITVAMI
                /*
                Intent status = new Intent(ac, StatusActivity.class);
                status.putExtra(PARAMETER_POSITION_1,position);
                ac.startActivity(status);
                */

                Toast.makeText(ac, "STATUS " + position,Toast.LENGTH_SHORT).show();
                System.out.println(name);
                Intent status = new Intent(ac, StatusActivity.class);
                status.putExtra(PARAMETER_POSITION_1,position);
                ac.startActivity(status);
            }
        });

/*
        holder.ivSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {           // TODO: DOKONCAJ, KO UREDIS STRAN Z NASTAVITVAMI
                Toast.makeText(ac, "Test OnClickListener: Toast",Toast.LENGTH_SHORT).show();
            /*
                Intent settings = new Intent(ac, SettingsActivity.class);
                settings.putExtra(PARAMETER_POSITION_1,position);
                ac.startActivity(settings);

                System.out.println(name);*/
 /*           }
        });*/


        holder.cv.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                /*
                Intent status = new Intent(ac, StatusActivity.class);
                status.putExtra(PARAMETER_POSITION_1,position);
                ac.startActivity(status);*/
                /*
                Intent settings = new Intent(ac, SettingsActivity.class);
                settings.putExtra(PARAMETER_POSITION_1,position);
                ac.startActivity(settings);
                */
/*
                Toast.makeText(ac, "NASTAVITVE " + position,Toast.LENGTH_SHORT).show();
                Intent settings = new Intent(ac, SettingsActivity.class);
                settings.putExtra(PARAMETER_POSITION_1,position);
                ac.startActivity(settings);*/
                settingsDialog(v, position);
                return true;
            }
        });

        holder.ivDelete.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                //Toast.makeText(ac, "BRISANJE" + position,Toast.LENGTH_SHORT).show();
                //showDialog(v);
                deleteDialog(v, position);
                return true;
            }
        });

        holder.tv_Desc.setText(current.getDescr());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public void getItemSelected(MenuItem item){
        Toast.makeText(ac,"\"getItemSelected\" Id: " + item.getItemId(),Toast.LENGTH_SHORT).show();
    }


    public void deleteDialog(View view, final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(ac);
        builder.setTitle("Delete element");
        builder.setMessage("Are you sure,You want to delete?");

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ac,"You clicked no button", Toast.LENGTH_LONG).show();
            }
        });

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(ac,"You clicked yes button", Toast.LENGTH_LONG).show();
                Toast.makeText(ac, "BRISANJE" + position,Toast.LENGTH_SHORT).show();
                Device d = mDataset.remove(position);
                notifyItemRemoved(position);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void settingsDialog(View view, final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(ac);
        builder.setTitle("Settings");
        builder.setItems(R.array.settings_dialog, new DialogInterface.OnClickListener() {
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
                        Gson gson = new Gson();
                        String json = gson.toJson(mDataset.getDevice(position));
                        Intent qrGenerate = new Intent(ac, QrGeneratorActivity.class);
                        qrGenerate.putExtra("URL", "https://www.thingspeak.com/channels/6855/feed.json");
                        ac.startActivity(qrGenerate);
                        break;
                    case 1:
                        // Import from QR
                        Intent scan = new Intent(ac, QrScannerActivity.class);
                        ac.startActivity(scan);
                        break;
                    case 2:
                        // SettingsActivity
                        Intent settings = new Intent(ac, SettingsActivity.class);
                        settings.putExtra(PARAMETER_POSITION_1,position);
                        ac.startActivity(settings);
                        break;
                }
            }
        });



        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

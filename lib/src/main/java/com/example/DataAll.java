package com.example;

import java.util.ArrayList;

/**
 * Created by Roman on 16.5.2016.
 */
public class DataAll {
    ArrayList<Device> devices;

    public DataAll(){
        this.devices = new ArrayList<>();
    }

    public DataAll(ArrayList<Device> alist){
        this.devices = alist;
    }

    public void addDevice(Device dev){
        this.devices.add(dev);
    }

    public Device getDevice(int index){
        return this.devices.get(index);
    }

    public void setDevice(int index, Device dev){
        this.devices.set(index, dev);
    }

    public Device remove(int index){
        return this.devices.remove(index);
    }

    public int size(){
        return this.devices.size();
    }

    @Override
    public String toString(){
        return "Naprave:{" + this.devices + "}";
    }

    public ArrayList<Device> search(String somethingYouSearchFor){
        ArrayList<Device> tmp = new ArrayList<>();
        // TODO: Dokoncaj iskanje
        return tmp;
    }

    public static DataAll getScenarij(){
        DataAll all = new DataAll();
        /*
        Field f = new Field("field2", "false", true, true);
        // public Device(String name, String descr, String status, DeviceType type)
        Device d = new Device("LUC V DNEVNI", "a short description 1", "false", DeviceType.SENSOR);
        d.setUrl("https://thingspeak.com/channels/");
        d.setChannelID("FOFSEDKDFIDQ");
        d.setInfield(f);
        d.setOutfield(null);
        d.setApiKey("CMBENRTKDS");
        d.setWrieKey("FEJEI43MFI4MD");
        d.setReadKey("OERROGRVMV034");*/
        /*
        private String url;
        private String channelID;
        private Field outfield;
        private Field infield;
        private String apiKey;
        private String wrieKey;
        private String readKey;

        this.name = name;
        this.value = value;
        this.enabled = enabled;
        this.inUse = inUse;
        this.nr = nr;
        */
        all.addDevice(new Device("Luc", "luc v dnevni sobi", "false", DeviceType.ACTUATOR,
                "https://thingspeak.com/channels/", "FOFSEDKDFIDQ",
                new Field("Stikalo luc", "false", true, true, 2),
                new Field("Stikalo luc", "false", false, true, 2),
                "CMBENRTKDS", "FEJEI43MFI4MD", "OERROGRVMV034"));

        all.addDevice(new Device("Ogrevanje", "luc v dnevni sobi", "20.0", DeviceType.TRANSDUCER,
                "https://thingspeak.com/channels/", "FOFSEDKDFIDQ",
                new Field("Zeljena temperatura", "20.0", true, true, 1),
                new Field("Dejanska temperatura", "19.5", true, true, 3),
                "CMBENRTKDS", "FEJEI43MFI4MD", "OERROGRVMV034"));

        all.addDevice(new Device("Zvonec", "zvonec stanovanje", "false", DeviceType.SENSOR,
                "https://thingspeak.com/channels/", "FOFSEDKDFIDQ",
                new Field("Stikalo luc", "false", true, true, 4),
                new Field("Stikalo luc", "false", false, true, 4),
                "CMBENRTKDS", "FEJEI43MFI4MD", "OERROGRVMV034"));

        all.addDevice(new Device("Stikalo", "luc v dnevni sobi", "false", DeviceType.SENSOR,
                "https://thingspeak.com/channels/", "FOFSEDKDFIDQ",
                new Field("Stikalo luc", "false", true, true, 2),
                new Field("Stikalo luc", "false", false, true, 2),
                "CMBENRTKDS", "FEJEI43MFI4MD", "OERROGRVMV034"));

        all.addDevice(new Device("Stikalo", "luc v dnevni sobi", "false", DeviceType.SENSOR,
                "https://thingspeak.com/channels/", "FOFSEDKDFIDQ",
                new Field("Stikalo luc", "false", true, true, 2),
                new Field("Stikalo luc", "false", false, true, 2),
                "CMBENRTKDS", "FEJEI43MFI4MD", "OERROGRVMV034"));/*
        all.addDevice(new Device("name2", "a short description 2", "status2", DeviceType.ACTUATOR));
        all.addDevice(new Device("name3", "a short description 3", "status3", DeviceType.TRANSDUCER));
        all.addDevice(new Device("name4", "a short description 4", "status1", DeviceType.SENSOR));
        all.addDevice(new Device("name5", "a short description 5", "status2", DeviceType.SENSOR));
        all.addDevice(new Device("name6", "a short description 6", "status3", DeviceType.ACTUATOR));
        all.addDevice(new Device("name7", "a short description 7", "status1", DeviceType.TRANSDUCER));
        all.addDevice(new Device("name8", "a short description 8", "status2", DeviceType.ACTUATOR));
        all.addDevice(new Device("name9", "a short description 9", "status3", DeviceType.TRANSDUCER));*/
        //new Channel("name", "description");
        //new Key("apiKey", "writeKey", "readKey");
        return all;
    }
}

package com.example;


public class Device {

    private String name;
    private String descr;
    private String status;
    private DeviceType type;
    private String url;
    private String channelID;
    private Field outfield;
    private Field infield;
    private String apiKey;
    private String wrieKey;
    private String readKey;


    public Device(){
        this.name = "";
        this.descr = "";
        this.status = "";
        this.type = DeviceType.SENSOR;
        this.url = "";
        this.channelID = "";
        this.outfield = new Field();
        this.infield = new Field();
        this.apiKey = "";
        this.wrieKey = "";
        this.readKey = "";
    }

    public Device(String name,
                  String descr,
                  String status,
                  DeviceType type,
                  String url,
                  String channelID,
                  Field outfield,
                  Field infield,
                  String apiKey,
                  String wrieKey,
                  String readKey
                  ){
        this.name = name;
        this.descr = descr;
        this.status = status;
        this.type = type;
        this.url = url;
        this.channelID = channelID;
        this.outfield = outfield;
        this.infield = infield;
        this.apiKey = apiKey;
        this.wrieKey = wrieKey;
        this.readKey = readKey;
    }

    public Device(String name, String descr, DeviceType type){
        this.name = name;
        this.descr = descr;
        this.status = "";
        this.type = type;
        this.url = "";
        this.channelID = "";
        this.outfield = new Field();
        this.infield = new Field();
        this.apiKey = "";
        this.wrieKey = "";
        this.readKey = "";
    }

    public Device(String name, DeviceType type){
        this.name = name;
        this.descr = "";
        this.status = "";
        this.type = type;
        this.url = "";
        this.channelID = "";
        this.outfield = new Field();
        this.infield = new Field();
        this.apiKey = "";
        this.wrieKey = "";
        this.readKey = "";
    }

    public Device(Device dev){
        this.name = dev.name;
        this.descr = dev.descr;
        this.status = dev.status;
        this.type = dev.type;
        this.url = dev.url;
        this.channelID = dev.channelID;
        this.outfield = dev.outfield;
        this.infield = dev.infield;
        this.apiKey = dev.apiKey;
        this.wrieKey = dev.wrieKey;
        this.readKey = dev.readKey;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescr(String description){
        this.descr = description;
    }

    public String getDescr(){
        return this.descr;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public DeviceType getType() {
        return this.type;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

    public void setChannelID(String chID){
        this.channelID = chID;
    }

    public String getChannelID(){
        return this.channelID;
    }

    public void setOutfield(Field f){
        this.outfield = f;
    }

    public Field getOutfield(){
        return this.outfield;
    }

    public void setInfield(Field f){
        this.infield = f;
    }

    public Field getInfield(){
        return this.infield;
    }

    public void setApiKey(String apiKey){
        this.apiKey = apiKey;
    }

    public String getApiKey(){
        return this.apiKey;
    }

    public void setWrieKey(String wrieKey){
        this.wrieKey = wrieKey;
    }

    public String getWrieKey(){
        return this.wrieKey;
    }

    public void setReadKey(String readKey){
        this.readKey = readKey;
    }

    public String getReadKey(){
        return this.readKey;
    }
}

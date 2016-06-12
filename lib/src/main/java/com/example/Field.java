package com.example;

/**
 * Created by Roman on 25.5.2016.
 */
public class Field {
    private String name;
    private String value;
    private boolean enabled;
    private boolean inUse;
    private int nr;

    public Field(){
        this.name = "";
        this.value = "";
        this.enabled = false;
        this.inUse = false;
        this.nr = 0;
    }

    public Field(String name, String value, boolean enabled, boolean inUse, int nr){
        this.name = name;
        this.value = value;
        this.enabled = enabled;
        this.inUse = inUse;
        this.nr = nr;
    }

    public Field(String name, String value){
        this.name = name;
        this.value = value;
        this.enabled = false;
        this.inUse = false;
        this.nr = 0;
    }

    public Field(String name){
        this.name = name;
        this.value = "";
        this.enabled = false;
        this.inUse = false;
        this.nr = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public boolean isEnabled(){
        return this.enabled;
    }

    public void setInUse(boolean inUse){
        this.inUse = inUse;
    }

    public boolean isInUse(){
        return this.inUse;
    }

    public void setNr(int number){
        this.nr = number;
    }

    public int getNr(){
        return this.nr;
    }
}

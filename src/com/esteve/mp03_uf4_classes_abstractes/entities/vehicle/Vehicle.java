package com.esteve.mp03_uf4_classes_abstractes.entities.vehicle;

import org.json.simple.JSONObject;

public abstract class Vehicle {
    protected double minConsume;
    protected double currConsume;
    protected double maxCapacity;
    protected double consumeByKm;
    protected char type;
    protected String id;
    protected double avgSpeed;
    protected String personNif;

    public Vehicle(String id) {
        this.id = id;
        this.minConsume = 0;
        this.currConsume = 0;
        this.maxCapacity = 0;
        this.consumeByKm = 0;
        this.avgSpeed = 0;
        this.personNif = null;
    }

    public JSONObject toJson() {
        return new JSONObject();
    }

    protected void createFromJson(JSONObject src) {

    }

    protected void baseFromJson(JSONObject src) {
        this.minConsume = (double) src.get("minConsume");
        this.currConsume = (double) src.get("currConsume");
        this.maxCapacity = (double) src.get("maxCapacity");
        this.consumeByKm = (double) src.get("consumeByKm");
        this.avgSpeed = (double) src.get("avgSpeed");
        this.type = ((String) src.get("type")).charAt(0);
        this.id = (String) src.get("id");
        this.personNif = (String) src.get("personNif");
    }

    public double calcConsume() {
        return 0;
    }

    public double getMinConsume() {
        return minConsume;
    }

    public void setMinConsume(double minConsume) {
        this.minConsume = minConsume;
    }

    public double getCurrConsume() {
        return currConsume;
    }

    public void setCurrConsume(double currConsume) {
        this.currConsume = currConsume;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getConsumeByKm() {
        return consumeByKm;
    }

    public void setConsumeByKm(double consumeByKm) {
        this.consumeByKm = consumeByKm;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public String getPersonId() {
        return personNif;
    }

    public void setPersonId(String personId) {
        this.personNif = personId;
    }

}

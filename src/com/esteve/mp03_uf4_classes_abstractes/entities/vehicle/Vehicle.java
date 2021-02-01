package com.esteve.mp03_uf4_classes_abstractes.entities.vehicle;

public class Vehicle {
    public enum TYPE {
        LAND('T'),
        AIR('A'),
        SEA('M');

        char type;

        TYPE(char t) {
            this.type = t;
        }
    }

    protected double minConsume;
    protected double currConsume;
    protected double maxCapacity;
    protected double consumeByKm;
    protected TYPE type;
    protected String id;
    protected double avgSpeed;
    protected String personId;

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

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
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
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Vehicle(String id) {
        this.id = id;
        this.minConsume = 0;
        this.currConsume = 0;
        this.maxCapacity = 0;
        this.consumeByKm = 0;
        this.avgSpeed = 0;
        this.personId = null;
    }
}

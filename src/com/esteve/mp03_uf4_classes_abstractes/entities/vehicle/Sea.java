package com.esteve.mp03_uf4_classes_abstractes.entities.vehicle;

import org.json.simple.JSONObject;

public class Sea extends Vehicle {
    protected int length, year, handle;
    protected String build_date;

    public Sea(String id) {
        super(id);
        this.type = 'S';
    }

    public JSONObject toJson() {
        JSONObject res = new JSONObject();
        res.put("minConsume", this.minConsume);
        res.put("currConsume", this.currConsume);
        res.put("maxCapacity", this.maxCapacity);
        res.put("consumeByKm", this.consumeByKm);
        res.put("type", String.valueOf(this.type));
        res.put("id", this.id);
        res.put("avgSpeed", this.avgSpeed);
        res.put("personNif", this.personNif);

        res.put("length", this.length);
        res.put("year", this.year);
        res.put("handle", this.handle);
        res.put("build_date", this.build_date);

        return res;
    }

    public void createFromJson(JSONObject src) {
        this.baseFromJson(src);
        this.length = (int)((long)src.get("length"));
        this.year = (int)((long)src.get("year"));
        this.handle = (int)((long)src.get("handle"));
        this.build_date = (String) src.get("build_year");
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHandle() {
        return handle;
    }

    public void setHandle(int handle) {
        this.handle = handle;
    }

    public String getBuild_date() {
        return build_date;
    }

    public void setBuild_date(String build_date) {
        this.build_date = build_date;
    }

}

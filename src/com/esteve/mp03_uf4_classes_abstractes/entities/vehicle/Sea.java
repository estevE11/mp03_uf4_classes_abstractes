package com.esteve.mp03_uf4_classes_abstractes.entities.vehicle;

public class Sea extends Vehicle {
    protected int length, year, handle;
    protected String build_date;

    public Sea(String id) {
        super(id);
        this.type = 'S';
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

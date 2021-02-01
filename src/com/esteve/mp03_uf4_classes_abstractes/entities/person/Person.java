package com.esteve.mp03_uf4_classes_abstractes.entities.person;

import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Vehicle;
import org.json.simple.JSONObject;

public class Person {
    protected String nif;
    protected String name;
    protected String birth;
    protected Vehicle.TYPE esp;
    protected boolean assigned = false;

    public Person(String nif) {
        this.nif = nif;
    }

    private Person createFromJSON(JSONObject obj) {
        String nif = (String) obj.get("nif");
        Person res = new Person(nif);
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Vehicle.TYPE getEsp() {
        return esp;
    }

    public void setEsp(Vehicle.TYPE esp) {
        this.esp = esp;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
}

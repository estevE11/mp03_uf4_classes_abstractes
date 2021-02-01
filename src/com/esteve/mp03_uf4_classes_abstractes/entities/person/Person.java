package com.esteve.mp03_uf4_classes_abstractes.entities.person;

import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Vehicle;
import org.json.simple.JSONObject;

public class Person {
    protected String nif;
    protected String name;
    protected String birth;
    protected char esp;
    protected boolean assigned;

    public Person(String nif) {
        this.nif = nif;
        this.assigned = false;
    }

    public static Person createFromJSON(JSONObject obj) {
        String nif = (String) obj.get("nif");
        Person res = new Person(nif);
        res.setName((String) obj.get("name"));
        res.setBirth((String) obj.get("birth"));
        res.setAssigned((boolean) obj.get("assigned"));
        res.setEsp(((String) obj.get("esp")).charAt(0));
        return res;
    }

    public JSONObject toJson() {
        JSONObject res = new JSONObject();
        res.put("nif", this.nif);
        res.put("name", this.name);
        res.put("birth", this.birth);
        res.put("esp", String.valueOf(this.esp));
        res.put("assigned", this.assigned);
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

    public char getEsp() {
        return esp;
    }

    public void setEsp(char esp) {
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

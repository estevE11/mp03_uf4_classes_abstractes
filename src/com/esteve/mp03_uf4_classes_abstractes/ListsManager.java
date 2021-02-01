package com.esteve.mp03_uf4_classes_abstractes;

import com.esteve.mp03_uf4_classes_abstractes.entities.person.Person;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Vehicle;
import com.esteve.mp03_uf4_classes_abstractes.utils.JSONUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedList;

public class ListsManager {
    private LinkedList<Vehicle> vehicles;
    private LinkedList<Person> people;

    public ListsManager() {
        this.people = new LinkedList<>();
        this.vehicles = new LinkedList<>();
    }

    public void load(){
        JSONObject src = JSONUtils.loadJson("res/save.json");
        JSONArray json_people = (JSONArray) src.get("people");
        for (int i = 0; i < json_people.size(); i++) {
            JSONObject json_person = (JSONObject) json_people.get(i);
            this.people.add(Person.createFromJSON(json_person));
        }
    }

    public void saveToJson() {
        JSONObject toSave = new JSONObject();
        JSONArray json_vehicles = new JSONArray();
        JSONArray json_people = new JSONArray();

        for(Person p : this.people) {
            json_people.add(p.toJson());
        }

        toSave.put("vehicles", json_vehicles);
        toSave.put("people", json_people);
        JSONUtils.saveJson("res/save.json", toSave);
    }

    public void add(Person p) {
        this.people.add(p);
    }

    public void add(Vehicle v) {
        this.vehicles.add(v);
    }

    public LinkedList<Person> getPeople() {
        return this.people;
    }

    public LinkedList<Vehicle> getVehicles() {
        return this.vehicles;
    }
}

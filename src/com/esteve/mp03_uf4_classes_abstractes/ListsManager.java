package com.esteve.mp03_uf4_classes_abstractes;

import com.esteve.mp03_uf4_classes_abstractes.entities.person.Person;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Air;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Land;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Sea;
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

        JSONArray json_vehicles = (JSONArray) src.get("vehicles");
        for (int i = 0; i < json_vehicles.size(); i++) {
            JSONObject json_vehicle = (JSONObject) json_vehicles.get(i);
            char type = ((String) json_vehicle.get("type")).charAt(0);
            switch(type) {
                case 'L':
                    Land l = new Land(null);
                    l.createFromJson(json_vehicle);
                    this.add(l);
                    break;
                case 'S':
                    Sea s = new Sea(null);
                    s.createFromJson(json_vehicle);
                    this.add(s);
                    break;
                case 'A':
                    Air a = new Air(null);
                    a.createFromJson(json_vehicle);
                    this.add(a);
                    break;
            }
        }
    }

    public void saveToJson() {
        JSONObject toSave = new JSONObject();
        JSONArray json_vehicles = new JSONArray();
        JSONArray json_people = new JSONArray();

        for(Person p : this.people) {
            json_people.add(p.toJson());
        }

        for(Vehicle v : this.vehicles) {
            json_vehicles.add(v.toJson());
        }

        toSave.put("vehicles", json_vehicles);
        toSave.put("people", json_people);
        JSONUtils.saveJson("res/save.json", toSave);
    }

    public Person getPersonByNif(String nif) {
        for (Person p : this.people) {
            if(p.getNif().equals(nif)) return p;
        }
        return null;
    }

    public Vehicle getVehicleById(String id) {
        for (Vehicle v : this.vehicles) {
            if(v.getId().equals(id)) return v;
        }
        return null;
    }

    public LinkedList<Person> getUnassignedPeople() {
        LinkedList<Person> res = new LinkedList<Person>();
        for (Person p : this.people) {
            if(!p.isAssigned()) res.add(p);
        }
        return res;
    }

    public LinkedList<Vehicle> getUnassignedVehiclesByType(char type) {
        LinkedList<Vehicle> res = new LinkedList<Vehicle>();
        for (Vehicle v : this.vehicles) {
            if(v.getPersonId() == null && v.getType() == type) res.add(v);
        }
        return res;
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

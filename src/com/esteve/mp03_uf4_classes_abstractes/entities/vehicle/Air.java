package com.esteve.mp03_uf4_classes_abstractes.entities.vehicle;

import org.json.simple.JSONObject;

public class Air extends Vehicle {
    protected int engines, workTime;

    public Air(String id) {
        super(id);
        this.type = 'A';
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

        res.put("engines", this.workTime);
        res.put("workTime", this.workTime);

        return res;
    }

    public void createFromJson(JSONObject src) {
        this.baseFromJson(src);
        this.engines = (int)((long)src.get("engines"));
        this.workTime = (int)((long)src.get("workTime"));
    }

    public int getEngines() {
        return engines;
    }

    public void setEngines(int engines) {
        this.engines = engines;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}

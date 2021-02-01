package com.esteve.mp03_uf4_classes_abstractes.entities.vehicle;

import org.json.simple.JSONObject;

public class Land extends Vehicle {
    protected int horsePower, issues, issuesCost;

    public Land(String id) {
        super(id);
        this.type = 'L';
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

        res.put("horsePower", this.horsePower);
        res.put("issues", this.issues);
        res.put("issuesCost", this.issues);
        return res;
    }

    public void createFromJson(JSONObject src) {
        this.baseFromJson(src);
        this.horsePower = (int)((long)src.get("horsePower"));
        this.issues = (int)((long)src.get("issues"));
        this.issuesCost = (int)((long)src.get("issuesCost"));
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    public int getIssuesCost() {
        return issuesCost;
    }

    public void setIssuesCost(int issuesCost) {
        this.issuesCost = issuesCost;
    }
}

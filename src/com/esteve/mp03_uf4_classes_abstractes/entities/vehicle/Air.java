package com.esteve.mp03_uf4_classes_abstractes.entities.vehicle;

public class Air extends Vehicle {
    public Air(String id) {
        super(id);
        this.type = 'A';
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

    protected int engines, workTime;
}

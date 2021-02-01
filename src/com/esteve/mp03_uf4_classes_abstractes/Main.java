package com.esteve.mp03_uf4_classes_abstractes;

import com.esteve.mp03_uf4_classes_abstractes.entities.person.Person;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Vehicle;
import com.esteve.mp03_uf4_classes_abstractes.menus.Menus;
import com.esteve.mp03_uf4_classes_abstractes.utils.JSONUtils;

import java.util.List;

public class Main {

    private Menus menus;
    private ListsManager manager;

    public void start() {
        this.manager = new ListsManager();
        this.menus = new Menus(this.manager);

        this.manager.load();

        this.menus.mainMenu();

        this.manager.saveToJson();
    }
}

package com.esteve.mp03_uf4_classes_abstractes.menus;

import com.esteve.mp03_uf4_classes_abstractes.ListsManager;
import com.esteve.mp03_uf4_classes_abstractes.entities.person.Person;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Air;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Land;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Sea;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Vehicle;
import com.esteve.mp03_uf4_classes_abstractes.utils.JSONUtils;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.LinkedList;
import java.util.Scanner;

public class Menus {

    private Scanner sc = new Scanner(System.in);
    private ListsManager manager;

    public Menus(ListsManager manager) {
        this.manager = manager;
    }

    public void mainMenu() {
        int ipt = 0;
        do {
            System.out.println("1) Administrar vehicles");
            System.out.println("2) Administrar persones");
            System.out.println("3) Vincular");
            System.out.println("0) Sortir");

            System.out.print("> ");
            ipt = sc.nextInt();

            switch (ipt) {
                case 1:
                    this.manageVehicles();
                    break;
                case 2:
                    this.managePeople();
                    break;
                case 3:
                    this.menuLink();
                    break;
                default:
                    ipt = 0;
            }

        } while(ipt > 0);
        System.out.println();
    }

    private void manageVehicles() {
        int ipt = 0;
        do {
            System.out.println("1) Inserir vehicle");
            System.out.println("2) Imprimir vehicles");
            System.out.println("0) Sortir");

            System.out.print("> ");
            ipt = sc.nextInt();

            switch (ipt) {
                case 1:
                    this.menuCreateVehicle();
                    break;
                case 2:
                    this.printVehicles();
                    break;
                default:
                    ipt = 0;
            }
        } while(ipt > 0);
        System.out.println();
    }

    private void managePeople() {
        int ipt = 0;
        do {
            System.out.println("1) Inserir perona");
            System.out.println("2) Imprimir persones");
            System.out.println("0) Sortir");

            System.out.print("> ");
            ipt = sc.nextInt();

            switch (ipt) {
                case 1:
                    this.menuCreatePerson();
                    break;
                case 2:
                    this.printPeople();
                    break;
                default:
                    ipt = 0;
            }
        } while(ipt > 0);
        System.out.println();
    }

    public void menuCreateVehicle() {
        int ipt = 0;
        do {
            System.out.println("1) Terrestre");
            System.out.println("2) Maritim");
            System.out.println("3) Aeri");
            System.out.println("0) Sortir");

            System.out.print("> ");
            ipt = sc.nextInt();

            if(ipt < 4 && ipt > 0) {
                this.createVehicle(ipt);
            }
        } while(ipt > 0);
        System.out.println();
    }

    public void createVehicle(int type) {
        sc = new Scanner(System.in);
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Consum minim: ");
        double minCons = sc.nextDouble();
        System.out.print("Consum actual: ");
        double currCons = sc.nextDouble();
        System.out.print("Capacitat maxima: ");
        double maxCapacity = sc.nextDouble();
        System.out.print("Consum/Km: ");
        double consumeByKm = sc.nextDouble();
        System.out.print("Mitjana de velocitat: ");
        double avgSpeed = sc.nextDouble();

        switch(type) {
            case 1:
                Land v;
                System.out.print("Cavalls: ");
                int horsePower = sc.nextInt();
                System.out.print("Averies: ");
                int issues = sc.nextInt();
                System.out.print("Cost d'averies: ");
                int issuesCost = sc.nextInt();

                v = new Land(id);
                v.setMinConsume(minCons);
                v.setCurrConsume(currCons);
                v.setMaxCapacity(maxCapacity);
                v.setConsumeByKm(consumeByKm);
                v.setAvgSpeed(avgSpeed);

                v.setHorsePower(horsePower);
                v.setIssues(issues);
                v.setIssuesCost(issuesCost);
                this.manager.add(v);
                break;
            case 2:
                Sea s;
                System.out.print("Eslora: ");
                int length = sc.nextInt();
                System.out.print("Manega: ");
                int handle = sc.nextInt();
                System.out.print("Any flotació: ");
                int year = sc.nextInt();
                System.out.print("Any flotació: ");
                String build_date = sc.nextLine();

                s = new Sea(id);
                s.setMinConsume(minCons);
                s.setCurrConsume(currCons);
                s.setMaxCapacity(maxCapacity);
                s.setConsumeByKm(consumeByKm);
                s.setAvgSpeed(avgSpeed);

                s.setLength(length);
                s.setHandle(handle);
                s.setYear(year);
                s.setBuild_date(build_date);
                this.manager.add(s);
                break;
            case 3:
                Air a;
                System.out.print("Numero de motors: ");
                int engines = sc.nextInt();
                System.out.print("Temps de funcionament: ");
                int workTime = sc.nextInt();

                a = new Air(id);
                a.setMinConsume(minCons);
                a.setCurrConsume(currCons);
                a.setMaxCapacity(maxCapacity);
                a.setConsumeByKm(consumeByKm);
                a.setAvgSpeed(avgSpeed);

                a.setEngines(engines);
                a.setWorkTime(workTime);
                this.manager.add(a);
                break;
        }
        System.out.println();
    }

    public void menuCreatePerson() {
        Person res;
        System.out.println(". : Menu de creació d'una persona : .");
        System.out.print("NIF: ");
        sc = new Scanner(System.in); // Nou buffer buit
        String nif = sc.nextLine();
        res = new Person(nif);
        System.out.print("Nom: ");
        String name = sc.nextLine();
        res.setName(name);
        System.out.print("Vehicle type: ");
        char type = sc.nextLine().charAt(0);
        res.setEsp(type);

        this.manager.add(res);
        System.out.println("Persona inserida correctement!");
        System.out.println();
    }

    public void printPeople() {
        LinkedList<Person> people = this.manager.getPeople();
        for(int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            System.out.println((i+1) + ") " + p.getName() + " - " + (p.isAssigned() ? "A" : "No a") + "ssignat" + (p.isAssigned() ? (" a ") : ""));
        }
        System.out.println();
    }

    public void printVehicles() {
        LinkedList<Vehicle> vehicles = this.manager.getVehicles();
        for(int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);
            String type_name = "UNKNOWN";
            switch (v.getType()) {
            case 'L':
                type_name = "Terrestre";
                break;
            case 'S':
                type_name = "Maritim";
                break;
            case 'A':
                type_name = "Aeri";
                break;
            }
            System.out.println(v.getId() + ") " + type_name + (v.getPersonId() != null ?  " amb " + v.getPersonId() : ""));
        }
        System.out.println();
    }

    public void menuLink() {
        int ipt = 0;
        do {
            LinkedList<Person> unasPeople = this.manager.getUnassignedPeople();
            for(int i = 0; i < unasPeople.size(); i++) {
                System.out.println((i+1) + ") " + unasPeople.get(i).getName());
            }
            System.out.println("0) Sortir");
            System.out.print("> ");
            ipt = sc.nextInt();

            if(ipt > 0) menuLinkVehicles(unasPeople.get(ipt-1));

        } while(ipt > 0);
        System.out.println();
    }

    public void menuLinkVehicles(Person p) {
        int ipt = 0;
        do {
            LinkedList<Vehicle> unasVehicles = this.manager.getUnassignedVehiclesByType(p.getEsp());
            for(int i = 0; i < unasVehicles.size(); i++) {
                System.out.println((i+1) + ") " + unasVehicles.get(i).getId());
            }
            System.out.println("0) Sortir");
            System.out.print("> ");
            ipt = sc.nextInt();
            if(ipt > unasVehicles.size() || ipt < 1) {
                System.out.println("Numero incorrecte");
                continue;
            }
            if(p.link(unasVehicles.get(ipt-1))) System.out.println("La persona de nom " + p.getName() + " ha estat assignada a el vehicle amb id " + unasVehicles.get(ipt-1).getId());
            else System.out.println("Hi ha algut algun error!");
        } while(ipt > 0);
        System.out.println();
    }

}

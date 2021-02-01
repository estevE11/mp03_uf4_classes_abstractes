package com.esteve.mp03_uf4_classes_abstractes.menus;

import com.esteve.mp03_uf4_classes_abstractes.ListsManager;
import com.esteve.mp03_uf4_classes_abstractes.entities.person.Person;
import com.esteve.mp03_uf4_classes_abstractes.entities.vehicle.Vehicle;
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
                default:
                    ipt = 0;
            }

        } while(ipt > 0);
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
//                    this.menuCreatePerson();
                    break;
                default:
                    ipt = 0;
            }
        } while(ipt > 0);
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
    }

    public void printPeople() {
        LinkedList<Person> people = this.manager.getPeople();
        for(int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            System.out.println((i+1) + ") " + p.getName() + " - " + (p.isAssigned() ? "A" : "No a") + "ssignat");
        }
    }

}

package org.example;

import org.example.lectores.LectorCSV;
import org.example.lectores.LectorDB;

public class Main {
    public static void main(String[] args) {
        LectorCSV lectorCSV = new LectorCSV();
        LectorDB lectorDB = new LectorDB();

        lectorCSV.cargarResultados();


    }

}
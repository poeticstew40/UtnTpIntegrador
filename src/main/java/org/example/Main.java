package org.example;

import org.example.lectores.LectorCSV;
import org.example.lectores.LectorDB;

public class Main {
    public static void main(String[] args) {
        LectorCSV lectorCSV = new LectorCSV();
        LectorDB lectorDB = new LectorDB(lectorCSV);

        lectorCSV.cargarResultados();
        lectorDB.cargarPronosticos();

        
    }

}

//Todo min 51

/// TODO: 21/4/2023  VER MIN 1:25 
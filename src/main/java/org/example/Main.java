package org.example;

import org.example.lectores.LectorCSV;
import org.example.lectores.LectorDB;

public class Main {
    public static void main(String[] args) {
        LectorCSV lectorCSV = new LectorCSV();
        LectorDB lectorDB = new LectorDB(lectorCSV);

//        int puntajePartido = Integer.parseInt(args[1]);
//        int puntajeExtraRonda = Integer.parseInt(args[2]);
//        int puntajeExtraFase = Integer.parseInt(args[3]);


        int puntajePartido = 2;
        int puntajeExtraRonda = 10;
        int puntajeExtraFase = 20;


        lectorCSV.cargarResultados();
        lectorDB.cargarPronosticos();

        
    }

}

/// TODO: 21/4/2023 HAY QUE HACER EL ARCHIVO DE CONFIG, CON LA CONEXION A LA DB

//Todo min 51

/// TODO: 21/4/2023  VER MIN 1:25:00
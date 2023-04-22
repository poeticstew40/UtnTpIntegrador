package org.example;

import org.example.lectores.LectorCSV;
import org.example.lectores.LectorDB;
import org.example.torneo.Persona;
import org.example.torneo.Pronostico;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        LectorCSV lectorCSV = new LectorCSV();
        LectorDB lectorDB = new LectorDB(lectorCSV);

//        int puntajePartido = Integer.parseInt(args[1]);
//        int puntajeExtraRonda = Integer.parseInt(args[2]);
//        int puntajeExtraFase = Integer.parseInt(args[3]);


        int puntajePartido = 1;
        int puntajeExtraRonda = 10;
        int puntajeExtraFase = 20;


        lectorCSV.cargarResultados();
        lectorDB.cargarPronosticos();

        calcularPuntos(lectorDB, puntajePartido, puntajeExtraRonda, puntajeExtraFase);

        
    }
    //Todo 1:34:00
    private static void calcularPuntos(LectorDB lectorDB, int puntajePartido, int puntajeExtraRonda, int puntajeExtraFase) {
        for (Pronostico p : lectorDB.getPronosticos()){
            if (p.resultadoAcertado()){
                p.getPersona().sumarPuntos(puntajePartido);
                p.getPersona().agregarAcierto();
            }
        }

        for (Persona p : lectorDB.getPersonas()){
            System.out.println("Nombre:" + p.getNombre());
            System.out.println("Aciertos " + p.getCantidadAciertos());
            System.out.println("Puntaje " + p.getPuntos());
        }
    }


}

/// TODO: 21/4/2023 HAY QUE HACER EL ARCHIVO DE CONFIG, CON LA CONEXION A LA DB

//Todo min 51

/// TODO: 21/4/2023  VER MIN 1:25:00
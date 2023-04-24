package org.example;

import org.example.lectores.LectorCSV;
import org.example.lectores.LectorDB;
import org.example.torneo.Persona;
import org.example.torneo.Pronostico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String configFilePath = args[0];
        String dbConnection = args[1];
        int puntajePartido = 0;
        int puntajeExtraRonda = 0;
        int puntajeExtraFase = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(configFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    switch (key) {
                        case "puntajePartido" -> puntajePartido = Integer.parseInt(value);
                        case "puntajeExtraRonda" -> puntajeExtraRonda = Integer.parseInt(value);
                        case "puntajeExtraFase" -> puntajeExtraFase = Integer.parseInt(value);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading config file: " + e.getMessage());
        }

        LectorCSV lectorCSV = new LectorCSV();
        LectorDB lectorDB = new LectorDB(lectorCSV, dbConnection);

        lectorCSV.cargarResultados("C:/Users/nicol/OneDrive/Escritorio/UTN Curso Java Inicial/UtnTpIntegrador/src/main/java/org/example/csv/partidos.csv");
        lectorDB.cargarPronosticos();

        calcularPuntos(lectorDB, puntajePartido, puntajeExtraRonda, puntajeExtraFase);

    }


    //Todo 1:34:00
    private static void calcularPuntos(LectorDB lectorDB, int puntajePartido, int puntajeExtraRonda, int puntajeExtraFase) {
        for (Pronostico p : lectorDB.getPronosticos()) {
            if (p.resultadoAcertado()) {
                p.getPersona().sumarPuntos(puntajePartido);
                p.getPersona().agregarAcierto();
                if (p.getPersona().getCantidadAciertos() % 4 == 0) { // Verifica si la persona ha acertado 4 partidos
                    p.getPersona().agregarRondaAcertada();
                    p.getPersona().sumarPuntos(puntajeExtraRonda);
                    if(p.getPersona().getCantidadAciertos() == 8){
                        p.getPersona().agregarFaseAcertada();
                        p.getPersona().sumarPuntos(puntajeExtraFase);
                    }
                }
            }
        }

        for (Persona p : lectorDB.getPersonas()) {
            System.out.println("Nombre:" + p.getNombre());
            System.out.println("Aciertos: " + p.getCantidadAciertos());
            System.out.println("Puntaje: " + p.getPuntos());
            System.out.println("Rondas Acertadas " + p.getRondasAcertadas());
            System.out.println("Fases Acertadas " + p.getFasesAcertadas());
            System.out.println();
        }
    }


}

/// TODO: 21/4/2023 HAY QUE HACER EL ARCHIVO DE CONFIG, CON LA CONEXION A LA DB

//Todo min 51

/// TODO: 21/4/2023  VER MIN 1:25:00
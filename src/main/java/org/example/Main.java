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

    private static void calcularPuntos(LectorDB lectorDB, int puntajePartido, int puntajeExtraRonda, int puntajeExtraFase) {
        for (Pronostico p : lectorDB.getPronosticos()) {
            if (p.resultadoAcertado()) {
                Persona persona = p.getPersona();
                persona.sumarPuntos(puntajePartido);
                persona.agregarAcierto();
                int aciertosRonda = persona.getAciertosEnLaRondaActual();
                if (aciertosRonda == 4) {
                    persona.agregarRondaAcertada();
                    persona.sumarPuntos(puntajeExtraRonda);
                    persona.setAciertosEnLaRondaActual(0);
                }
                int aciertosFase = persona.getCantidadAciertos();
                if (aciertosFase == 8) {
                    persona.agregarFaseAcertada();
                    persona.sumarPuntos(puntajeExtraFase);
                }
            } else {
                Persona persona = p.getPersona();
                persona.setAciertosEnLaRondaActual(0);
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

package org.example.lectores;

import org.example.torneo.Equipo;
import org.example.torneo.Fase;
import org.example.torneo.Partido;
import org.example.torneo.Ronda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {

    private List<Equipo> equipos;
    private List<Fase> fases;

    public LectorCSV() {
        this.equipos = new ArrayList<>();
        this.fases = new ArrayList<>();
    }

    public void cargarResultados(String rutaArchivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoCSV))) {
            String linea;
            Fase faseActual = null;
            Ronda rondaActual = null;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String nombreEquipo1 = campos[0];
                String nombreEquipo2 = campos[1];
                int golesEquipo1 = Integer.parseInt(campos[2]);
                int golesEquipo2 = Integer.parseInt(campos[3]);

                Equipo equipo1 = buscarEquipo(nombreEquipo1);
                Equipo equipo2 = buscarEquipo(nombreEquipo2);
                if (equipo1 == null) {
                    equipo1 = new Equipo(nombreEquipo1);
                    agregarEquipo(equipo1);
                }
                if (equipo2 == null) {
                    equipo2 = new Equipo(nombreEquipo2);
                    agregarEquipo(equipo2);
                }

                Partido partido = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);

                if (faseActual == null || rondaActual == null) {
                    // Aún no se ha creado ninguna fase o ronda, así que creamos una nueva
                    faseActual = new Fase(1);
                    rondaActual = new Ronda(1);
                    faseActual.agregarRonda(rondaActual);
                    this.fases.add(faseActual);
                } else if (rondaActual.getPartidos().size() >= 4) {
                    // Ya se han creado cuatro partidos en la ronda actual, así que creamos una nueva
                    rondaActual = new Ronda(rondaActual.getNumRonda() + 1);
                    faseActual.agregarRonda(rondaActual);
                }

                rondaActual.agregarPartido(partido);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public void agregarEquipo(Equipo equipo) {
        for (Equipo e : this.equipos) {
            if (e.getNombre().equals(equipo.getNombre())) {
                throw new RuntimeException("El partido ya existe");
            }
        }
        this.equipos.add(equipo);
    }

    public void agregarFase(Fase fase) {
        for (Fase f : this.fases) {
            if (f.getNumFase() == fase.getNumFase()) {
                throw new RuntimeException("El fase ya existe");
            }
        }
        this.fases.add(fase);
    }

    public Fase buscarFase(int numFase){
        Fase fase = null;

        for (Fase f : this.fases){
            if (f.getNumFase() == numFase){
                fase = f;
            }
        }
        return fase;

    }

    private Equipo buscarEquipo(String nombreEquipo) {
        for (Equipo equipo : this.equipos) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                return equipo;
            }
        }
        return null;
    }
}
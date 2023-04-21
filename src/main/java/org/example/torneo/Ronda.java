package org.example.torneo;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

    private int numRonda;
    private List<Partido> partidos;


    public Ronda(int numRonda){
        this.numRonda = numRonda;
        this.partidos = new ArrayList<>();
    }

    public int getNumRonda() {
        return numRonda;
    }

    public void setNumRonda(int numRonda) {
        this.numRonda = numRonda;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void agregarPartido(Partido partido){
        for (Partido p : this.partidos){
            if (p.igual(partido)){
                throw  new RuntimeException("El partido ya existe");
            }
        }
        this.partidos.add(partido);
    }

    public Partido obtenerPartido(String equipo1, String equipo2) {

        Partido partido = null;

        for(Partido p : this.partidos){
            if (p.tieneEquipos(equipo1, equipo2)){
                partido = p;
            }
        }

        return partido;
    }
    //todo MIN 41
}

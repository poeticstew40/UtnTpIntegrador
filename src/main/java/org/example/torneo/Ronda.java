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
}

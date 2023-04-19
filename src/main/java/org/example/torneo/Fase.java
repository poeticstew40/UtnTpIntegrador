package org.example.torneo;

import java.util.ArrayList;
import java.util.List;

public class Fase {

    private List<Ronda> rondas;
    private int numFase;

    public  Fase(int numFase) {
        this.rondas = new ArrayList<>();
        this.numFase = numFase;
    }

    public void agregarRonda(Ronda ronda){
        for(Ronda r : this.rondas){
            if (r.getNumRonda() == ronda.getNumRonda()){
                //TODO HACER UNA EXCEPCION RONDA EXCEPCION
                throw new RuntimeException("La ronda ya existe");
            }
        }
        this.rondas.add(ronda);
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    public int getNumFase() {
        return numFase;
    }

    public void setNumFase(int numFase) {
        this.numFase = numFase;
    }
}

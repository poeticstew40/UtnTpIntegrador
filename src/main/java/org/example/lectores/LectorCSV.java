package org.example.lectores;

import org.example.torneo.Equipo;
import org.example.torneo.Fase;
import org.example.torneo.Partido;
import org.example.torneo.Ronda;

import java.util.ArrayList;
import java.util.List;


//Todo  HAY QUE HACER QUE EL LECTOR CSV LEA LOS CSVS, TERMINAR DE CREAR LA CLASE
public class LectorCSV {

    private List<Equipo> equipos;
    private List<Fase> fases;

    public LectorCSV() {
        this.equipos = new ArrayList<>();
        this.fases = new ArrayList<>();
    }

    public void cargarResultados() {

        Equipo argentina = new Equipo("Argentina");
        Equipo arabia = new Equipo("Arabia Saudita");
        Equipo polonia = new Equipo("Polonia");
        Equipo mexico = new Equipo("Mexico");
        Equipo alemania  = new Equipo("Alemania");
        Equipo japon = new Equipo("Japon");
        Equipo españa  = new Equipo("España");
        Equipo costaRica = new Equipo("Costa Rica");

        this.agregarEquipo(argentina);
        this.agregarEquipo(arabia);
        this.agregarEquipo(polonia);
        this.agregarEquipo(mexico);

        Partido p1 = new Partido(argentina, arabia, 1, 2);
        Partido p2 = new Partido(polonia, mexico, 0, 0);
        Partido p3 = new Partido(argentina, mexico, 2, 0);
        Partido p4 = new Partido(arabia, polonia, 0, 2);

        Partido p5 = new Partido(alemania , japon, 1, 2);
        Partido p6 = new Partido(españa, costaRica, 7, 0);
        Partido p7 = new Partido(japon, costaRica, 0, 1);
        Partido p8 = new Partido(españa, alemania, 1, 1);

        Ronda r1 = new Ronda(1);
        Ronda r2 = new Ronda(2);

        r1.agregarPartido(p1);
        r1.agregarPartido(p2);
        r1.agregarPartido(p3);
        r1.agregarPartido(p4);

        r2.agregarPartido(p5);
        r2.agregarPartido(p6);
        r2.agregarPartido(p7);
        r2.agregarPartido(p8);

        Fase f1 = new Fase(1);

        f1.agregarRonda(r1);
        f1.agregarRonda(r2);

        this.fases.add(f1);
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
}
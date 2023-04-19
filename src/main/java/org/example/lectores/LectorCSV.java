package org.example.lectores;

import org.example.torneo.Equipo;
import org.example.torneo.Fase;
import org.example.torneo.Partido;
import org.example.torneo.Ronda;

import java.util.List;


//Todo  HAY QUE HACER QUE EL LECTOR CSV LEA LOS CSVS, TERMINAR DE CREAR LA CLASE
public class LectorCSV {

    List<Equipo> equipos;
    List<Partido> partidos;
    List<Ronda> rondas;
    List<Fase> fases;

    public void cargarResultados() {

        Equipo argentina = new Equipo("Argentina");
        Equipo arabia = new Equipo("Arabia Saudita");
        Equipo polonia = new Equipo("Polonia");
        Equipo mexico = new Equipo("Mexico");

        this.agregarEquipo(argentina);
        this.agregarEquipo(arabia);
        this.agregarEquipo(polonia);
        this.agregarEquipo(mexico);

        Partido p1 = new Partido(argentina, arabia, 1, 2);
        Partido p2 = new Partido(polonia, mexico, 0, 0);
        Partido p3 = new Partido(argentina, mexico, 2, 0);
        Partido p4 = new Partido(arabia, polonia, 0, 2);

        Ronda r1 = new Ronda(1);

        r1.agregarPartido(p1);
        r1.agregarPartido(p2);
        r1.agregarPartido(p3);
        r1.agregarPartido(p4);

        Fase f1 = new Fase(1);

        f1.agregarRonda(r1);


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
}
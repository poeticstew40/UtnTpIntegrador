package org.example.torneo;

import java.util.Objects;

public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;
    private int goles1;
    private int goles2;

    public Partido(Equipo equipo1, Equipo equipo2, int goles1, int goles2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.goles1 = goles1;
        this.goles2 = goles2;
    }

    public boolean igual(Partido partido) {
        return (this.equipo1.equals(partido.equipo1) && this.equipo2.equals(partido.equipo2))
                || (this.equipo1.equals(partido.equipo2) && this.equipo2.equals(partido.equipo1));
    }

    public boolean tieneEquipos(String equipo1, String equipo2) {

        return (this.equipo1.getNombre().equals(equipo1) && this.equipo2.getNombre().equals(equipo2))
                || (this.equipo1.getNombre().equals(equipo2)) && this.equipo2.getNombre().equals(equipo1);
    }

    public Resultado getResultado(){
        if(goles1 == goles2){
            return  Resultado.EMPATE;
        }else if (goles1 > goles2){
            return  Resultado.GANA1;
        }else{
            return Resultado.GANA2;
        }
    }
}

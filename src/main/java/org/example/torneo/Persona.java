package org.example.torneo;

public class Persona {

    private String nombre;
    private Integer puntos;
    private int cantidadAciertos;
    private int rondasAcertadas;
    private int aciertosEnLaRondaActual;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.cantidadAciertos = 0;
        this.rondasAcertadas = 0;
        this.aciertosEnLaRondaActual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public int getCantidadAciertos() {
        return cantidadAciertos;
    }

    public void sumarPuntos(Integer puntosASumar){
        this.puntos += puntosASumar;
    }

    public void agregarAcierto(){
        this.cantidadAciertos++;
        this.aciertosEnLaRondaActual++;
    }

    public int getRondasAcertadas() {
        return rondasAcertadas;
    }

    public void agregarRondaAcertada() {
        if (this.aciertosEnLaRondaActual == 4) {
            this.rondasAcertadas++;
            this.aciertosEnLaRondaActual = 0;
        }
    }
}



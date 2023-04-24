package org.example.torneo;

public class Persona {

    private String nombre;
    private int puntos;
    private int cantidadAciertos;
    private int rondasAcertadas;
    private int fasesAcertadas;
    private int aciertosUltimaRonda;
    private int aciertosUltimaFase;
    private int aciertosEnLaRondaActual;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.cantidadAciertos = 0;
        this.rondasAcertadas = 0;
        this.fasesAcertadas = 0;
        this.aciertosUltimaRonda = 0;
        this.aciertosUltimaFase = 0;
        this.aciertosEnLaRondaActual = 0;
    }

    public int getAciertosEnLaRondaActual() {
        return aciertosEnLaRondaActual;
    }

    public void setAciertosEnLaRondaActual(int aciertosEnLaRondaActual) {
        this.aciertosEnLaRondaActual = aciertosEnLaRondaActual;
    }

    public int getAciertosUltimaRonda() {
        return aciertosUltimaRonda;
    }

    public void setAciertosUltimaRonda(int aciertosUltimaRonda) {
        this.aciertosUltimaRonda = aciertosUltimaRonda;
    }

    public int getAciertosUltimaFase() {
        return aciertosUltimaFase;
    }

    public void setAciertosUltimaFase(int aciertosUltimaFase) {
        this.aciertosUltimaFase = aciertosUltimaFase;
    }

    public int getFasesAcertadas() {
        return fasesAcertadas;
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
        }
        this.aciertosEnLaRondaActual = 0; // Reiniciar contador de aciertos en la ronda actual
    }

    public void agregarFaseAcertada() {
        if (this.cantidadAciertos == 8){
            this.fasesAcertadas++;
        }
    }
}

package org.example.torneo;

public class Pronostico {

    private Fase fase;
    private Ronda ronda;
    private Persona persona;
    private Partido partido;
    private Resultado resultado;

    public Pronostico(Fase fase, Ronda ronda, Persona persona, Partido partido, Resultado resultado) {
        this.fase = fase;
        this.ronda = ronda;
        this.persona = persona;
        this.partido = partido;
        this.resultado = resultado;
    }

    public Fase getFase() {
        return fase;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public Persona getPersona() {
        return persona;
    }

    public Partido getPartido() {
        return partido;
    }

    public boolean resultadoAcertado(){
        return this.partido.getResultado().equals(this.resultado);
    }


}

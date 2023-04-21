package org.example.torneo;

public class Pronostico {

    private Fase fase;
    private Ronda ronda;
    private Persona persona;
    private Partido partido;
    private  EnumResultado enumResultado;

    public Pronostico(Fase fase, Ronda ronda, Persona persona, Partido partido, EnumResultado enumResultado) {
        this.fase = fase;
        this.ronda = ronda;
        this.persona = persona;
        this.partido = partido;
        this.enumResultado = enumResultado;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public EnumResultado getEnumResultado() {
        return enumResultado;
    }

    public void setEnumResultado(EnumResultado enumResultado) {
        this.enumResultado = enumResultado;
    }
}

package org.example.torneo;

public class Pronostico {

    private int fase;
    private int ronda;
    private Persona persona;
    private Partido partido;
    private  EnumResultado enumResultado;

    public Pronostico(int fase, int ronda, Persona persona, Partido partido, EnumResultado enumResultado) {
        this.fase = fase;
        this.ronda = ronda;
        this.persona = persona;
        this.partido = partido;
        this.enumResultado = enumResultado;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
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

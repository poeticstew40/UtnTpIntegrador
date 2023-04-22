package org.example.lectores;

import org.example.torneo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorDB {

    private LectorCSV lectorCSV;
    private List<Persona> personas;
    private List<Pronostico> pronosticos;



    public LectorDB(LectorCSV lectorCSV) {
        this.lectorCSV = lectorCSV;
        this.personas = new ArrayList<>();
        this.pronosticos = new ArrayList<>();
    }

    public void cargarPronosticos(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pronosticos", "root", "44186324");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pronosticos");

            while (rs.next()) {

                Fase fase = lectorCSV.buscarFase(rs.getInt("fase"));
                if(fase == null){
                    throw new RuntimeException("La fase no existe ");
                    //Todo crear la excepcion
                }
                Ronda ronda = fase.buscarRonda(rs.getInt("ronda"));
                if(ronda == null){
                    throw new RuntimeException("La ronda no existe ");
                    //Todo crear la excepcion
                }

                Persona persona = this.obtenerPersona(rs.getString("persona"));

                Partido partido = ronda.obtenerPartido(rs.getString("equipo1"),rs.getString("equipo2"));
                if(partido == null){
                    throw new RuntimeException("El partido no xiste");
                    /// TODO: 21/4/2023 Crear la excepcion
                }

                boolean gana1 = rs.getBoolean("gana1");
                boolean empate = rs.getBoolean("empate");
                boolean gana2 = rs.getBoolean("gana2");

                Resultado resultado = null;

                if (gana1){
                    resultado = Resultado.GANA1;
                } else if (gana2) {
                    resultado = Resultado.GANA2;
                } else if (empate){
                    resultado = Resultado.EMPATE;
                }

                Pronostico pronostico = new Pronostico(fase, ronda, persona, partido, resultado);

                this.agregarPronostico(pronostico);
            }

            con.close();
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    private void agregarPronostico(Pronostico pronostico) {
        for (Pronostico p : this.pronosticos){
            if (p.getFase().equals(pronostico.getFase())
                && p.getPartido().equals(pronostico.getPartido())
                && p.getRonda().equals(pronostico.getRonda())
                && p.getPersona().equals(pronostico.getPersona())){
                throw new RuntimeException("Ya hay un pronostico de x persona para el partido x");
            }
        }
        this.pronosticos.add(pronostico);
    }

    private Persona obtenerPersona(String nombrePersona) {

        Persona persona = null;

        for (Persona p : this.personas){
            if (p.getNombre().equals(nombrePersona)){
                persona = p;
            }
        }
        if (persona == null){
            persona = new Persona(nombrePersona);
            this.personas.add(persona);
        }
        return persona;

    }

    public List<Persona> getPersonas() {
        return personas;
    }


    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }



}


/// TODO: 21/4/2023  1:02:48
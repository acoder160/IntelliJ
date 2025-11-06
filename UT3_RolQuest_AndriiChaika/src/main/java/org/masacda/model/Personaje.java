package org.masacda.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Personaje")
public class Personaje {

    @Id
    private int personajeID;

    @Column
    private String nombre;

    @Enumerated(EnumType.STRING)
    private clase clase;

    @Column
    private int nivel;

    @Column
    private int puntosVida;

    @Column
    private String armaPrincipal;



    public int getPersonajeID() {
        return personajeID;
    }

    public void setPersonajeID(int personajeID) {
        this.personajeID = personajeID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public clase getClase() {
        return clase;
    }

    public void setClase(clase clase) {
        this.clase = clase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public String getArmaPrincipal() {
        return armaPrincipal;
    }

    public void setArmaPrincipal(String armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }


}

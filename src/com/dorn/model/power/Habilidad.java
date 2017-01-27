/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model.power;

/**
 *
 * @author t30r3m4
 */
public class Habilidad {
    private String nombre;
    private String texto;
    private boolean cuestaAtaque;
    private boolean cuestaSangre;
    private boolean unoPorTurno;
    private int distancia;
    private int daño;
    
    public Habilidad(){
        this.cuestaAtaque = false;
        this.cuestaSangre = false;
        this.unoPorTurno = false;
        this.distancia=0;
        this.daño=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isCuestaAtaque() {
        return cuestaAtaque;
    }

    public void setCuestaAtaque(boolean cuestaAtaque) {
        this.cuestaAtaque = cuestaAtaque;
    }

    public boolean isCuestaSangre() {
        return cuestaSangre;
    }

    public void setCuestaSangre(boolean cuestaSangre) {
        this.cuestaSangre = cuestaSangre;
    }

    public boolean isUnoPorTurno() {
        return unoPorTurno;
    }

    public void setUnoPorTurno(boolean unoPorTurno) {
        this.unoPorTurno = unoPorTurno;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
    
}

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
    
    public Habilidad(){
        this.cuestaAtaque = false;
        this.cuestaSangre = false;
        this.unoPorTurno = false;
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
    
}

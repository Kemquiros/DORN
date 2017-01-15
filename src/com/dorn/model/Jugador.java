/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model;

import com.dorn.model.heroe.Heroe;

/**
 *
 * @author t30r3m4
 */
public class Jugador {
    private String nombre;
    private Heroe h;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Heroe getHeroe() {
        return h;
    }

    public void setHeroe(Heroe h) {
        this.h = h;
    }
    
    
}

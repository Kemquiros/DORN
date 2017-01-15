/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model.ritual;

/**
 *
 * @author t30r3m4
 */
public class Ritual {
    private String nombre,descripcion,rutaImagen;
    private int costoSangre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }   

    public int getCostoSangre() {
        return costoSangre;
    }

    public void setCostoSangre(int costoSangre) {
        this.costoSangre = costoSangre;
    }
    
}

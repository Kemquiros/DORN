/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model.heroe;

import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class Vargen extends Heroe{
    public Vargen(){
        this.nombre="Vargen";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("./assets/heroe/img/vargen.png");       
        this.setRutaCarta("./assets/heroe/card/vargen.png");
        
        this.setRutaRostro("./assets/heroe/face/vargen.png");
    }      
}

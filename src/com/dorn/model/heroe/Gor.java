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
public class Gor extends Heroe{
    public Gor(){
        this.nombre="Gor";
        this.ataqueFisico=false;
        this.habilidad = new ArrayList();
        this.setRutaImagen("./assets/heroe/img/gor.png");       
        this.setRutaCarta("./assets/heroe/card/gor.png");
        
        this.setRutaRostro("./assets/heroe/face/gor.png");
    }       
}

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
public class Ragnar extends Heroe{
    public Ragnar(){
        this.nombre="Ragnar";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("./assets/heroe/img/ragnar.png");       
        this.setRutaCarta("./assets/heroe/card/ragnar.png");
        
        this.setRutaRostro("./assets/heroe/face/ragnar.png");
    }        
}

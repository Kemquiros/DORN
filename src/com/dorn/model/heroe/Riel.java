/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model.heroe;

import com.dorn.model.power.Habilidad;
import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class Riel extends Heroe{
    public Riel(){
        this.nombre="Riel";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("./assets/heroe/img/riel.png");       
        this.setRutaCarta("./assets/heroe/card/riel.png");
        
        this.setRutaRostro("./assets/heroe/face/riel.png");
        this.setRutaSprite("./assets/heroe/sprite/riel1.png");
    }     
    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        this.movimientoMax=6;
        
        this.vidaMax=4;
        this.vida=vidaMax;
        
        this.ataqueMax=1;
        //0:Mágico
        //1:Contacto
        //2:Pica
        //3:Arco        
        setTipoAtaque(3);        
        
        this.experienciaMax=5;
        this.experiencia=0;
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Arco Largo");
        h.setTexto("Riel causa 1 daño a una criatura hasta a 4 casillas.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Evitar Flechas");
        h.setTexto("Riel es inmune al ataque de las Gorgonas.");
        habilidad.add(h);  
    }      
}

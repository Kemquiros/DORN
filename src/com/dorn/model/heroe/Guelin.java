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
public class Guelin extends Heroe{
    public Guelin(){
        this.nombre="Guelin";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("./assets/heroe/img/guelin.png");       
        this.setRutaCarta("./assets/heroe/card/guelin.png");
        
        this.setRutaRostro("./assets/heroe/face/guelin.png");
        this.setRutaSprite("./assets/heroe/sprite/guelin1.png");
    }  
    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        this.movimientoMax=6;
        
        this.vidaMax=5;
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
        h.setNombre("Arco Corto");
        h.setTexto("Guelin causa 1 daño a una criatura hasta a 3 casillas.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Avance Inexorable");
        h.setTexto("Guelin puede atacar antes de comenzar la fase de movimiento. Estos ataques se contabilizan y no estarán disponibles durante la fase de ataque de ese turno.");
        habilidad.add(h);  
    }     
}

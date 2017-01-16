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
public class Choros extends Heroe{
    public Choros(){
        this.nombre="Choros";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("./assets/heroe/img/choros.png");       
        this.setRutaCarta("./assets/heroe/card/choros.png");
        
        this.setRutaRostro("./assets/heroe/face/choros.png");
        this.setRutaSprite("./assets/heroe/sprite/choros1.png");
    }     
    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        this.movimientoMax=5;
        
        this.vidaMax=6;
        this.vida=vidaMax;
        
        this.ataqueMax=1;
        //0:Mágico
        //1:Contacto
        //2:Pica
        //3:Arco        
        setTipoAtaque(1);        
        
        this.experienciaMax=5;
        this.experiencia=0;
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Hacha");
        h.setTexto("Choros causa 1 daño a una criatura adyacente.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Remolino");
        h.setTexto("Durante un ataque con hacha, Choros causa 1 daño a todas las criaturas adyacentes.");
        h.setUnoPorTurno(true);
        habilidad.add(h);
                //--------------------------------------
        h = new Habilidad();
        h.setNombre("Cruce Táctico");
        h.setTexto("Cada vez que Choros acaba con una criatura, puede moverse a la casilla que ésta ocupaba.");
        habilidad.add(h);  
    }    
}

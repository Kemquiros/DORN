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
        setNombre("Riel");
        isAtaqueFisico(true);        

        this.habilidad = new ArrayList();
        this.setRutaImagen("/com/dorn/assets/heroe/img/riel.png");       
        this.setRutaCarta("/com/dorn/assets/heroe/card/riel.png");
        
        this.setRutaRostro("/com/dorn/assets/heroe/face/riel.png");
        this.setRutaSprite("/com/dorn/assets/heroe/sprite/riel1.png");
        setIsHeroe(true);
    }     
    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        setMovimientoMax(6);
        
        setVidaMax(4);
        setVida(getVidaMax());
        
        setAtaqueMax(1);
        //0:Mágico
        //1:Contacto
        //2:Pica
        //3:Arco        
        setTipoAtaque(3);        
        
        setExperienciaMax(5);
        setExperiencia(0);
        
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Arco Largo");
        h.setTexto("Riel causa 1 daño a una criatura hasta a 4 casillas.");
        h.setCuestaAtaque(true);
        h.setDaño(1);
        h.setDistancia(4);        
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Evitar Flechas");
        h.setTexto("Riel es inmune al ataque de las Gorgonas.");
        habilidad.add(h);  
    }      
}

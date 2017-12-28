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
        setNombre("Guelin");
        isAtaqueFisico(true);        

        this.habilidad = new ArrayList();
        this.setRutaImagen("/com/dorn/assets/heroe/img/guelin.png");       
        this.setRutaCarta("/com/dorn/assets/heroe/card/guelin.png");
        
        this.setRutaRostro("/com/dorn/assets/heroe/face/guelin.png");
        this.setRutaSprite("/com/dorn/assets/heroe/sprite/guelin1.png");
        setIsHeroe(true);
    }  
    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        setMovimientoMax(6);
        
        setVidaMax(5);
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
        h.setNombre("Arco Corto");
        h.setTexto("Guelin causa 1 daño a una criatura hasta a 3 casillas.");
        h.setCuestaAtaque(true);
        h.setDaño(1);
        h.setDistancia(3);        
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Avance Inexorable");
        h.setTexto("Guelin puede atacar antes de comenzar la fase de movimiento. Estos ataques se contabilizan y no estarán disponibles durante la fase de ataque de ese turno.");
        habilidad.add(h);  
    }     
}

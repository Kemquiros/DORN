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
public class Gor extends Heroe{
    public Gor(){
        setNombre("Gor");
        isAtaqueFisico(false);        

        this.habilidad = new ArrayList();
        this.setRutaImagen("/com/dorn/assets/heroe/img/gor.png");       
        this.setRutaCarta("/com/dorn/assets/heroe/card/gor.png");
        
        this.setRutaRostro("/com/dorn/assets/heroe/face/gor.png");
        this.setRutaSprite("/com/dorn/assets/heroe/sprite/gor1.png");
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
        setTipoAtaque(0);
        
        setExperienciaMax(5);
        setExperiencia(0);
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Regeneración Espiritual");
        h.setTexto("Gor puede curar 1 punto de vida a un héroe adyacente o a él mismo.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Exorcismo");
        h.setTexto("Gor causa 2 daños a una criatura adyacente");
        h.setCuestaAtaque(true);
        h.setCuestaSangre(true);
        habilidad.add(h);        
    }    
}

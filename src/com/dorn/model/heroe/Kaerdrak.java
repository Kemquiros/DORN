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
public class Kaerdrak extends Heroe{
    public Kaerdrak(){
        this.nombre="Kaerdrak";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("/com/dorn/assets/heroe/img/kaerdrak.png");       
        this.setRutaCarta("/com/dorn/assets/heroe/card/kaerdrak.png");
        
        this.setRutaRostro("/com/dorn/assets/heroe/face/kaerdrak.png");
        this.setRutaSprite("/com/dorn/assets/heroe/sprite/kaerdrak1.png");
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
        setTipoAtaque(1);        
        
        this.experienciaMax=5;
        this.experiencia=0;
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Hacha");
        h.setTexto("Kaerdrak causa 1 daño a una criatura adyacente.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Virtud del Paladín");
        h.setTexto("Si Kaerdrak no se mueve de la casilla en la que ha comenzado el turno, puede curarse 1 punto de vida al final del mismo.");
        h.setUnoPorTurno(true);
        habilidad.add(h);  
    }      
}

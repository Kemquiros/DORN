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
        setNombre("Choros");
        isAtaqueFisico(true);
        
        this.habilidad = new ArrayList();
        this.setRutaImagen("/com/dorn/assets/heroe/img/choros.png");       
        this.setRutaCarta("/com/dorn/assets/heroe/card/choros.png");
        
        this.setRutaRostro("/com/dorn/assets/heroe/face/choros.png");
        this.setRutaSprite("/com/dorn/assets/heroe/sprite/choros1.png");
        setIsHeroe(true);
    }     
    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        setMovimientoMax(5);
        
        setVidaMax(6);
        setVida(getVidaMax());
        
        setAtaqueMax(1);                
        //0:Mágico
        //1:Contacto
        //2:Pica
        //3:Arco        
        setTipoAtaque(1);        
        
        setExperienciaMax(5);
        setExperiencia(0);
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Hacha");
        h.setTexto("Choros causa 1 daño a una criatura adyacente.");
        h.setDaño(1);
        h.setDistancia(1);        
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

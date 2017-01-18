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
public class Eleanor extends Heroe{
    public Eleanor(){
        this.nombre="Eleanor";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("/com/dorn/assets/heroe/img/eleanor.png");       
        this.setRutaCarta("/com/dorn/assets/heroe/card/eleanor.png");
        
        this.setRutaRostro("/com/dorn/assets/heroe/face/eleanor.png");
        this.setRutaSprite("/com/dorn/assets/heroe/sprite/eleanor1.png");
    }       
    
    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        this.movimientoMax=7;
        
        this.vidaMax=5;
        this.vida=vidaMax;
        
        this.ataqueMax=1;
        //0:Mágico
        //1:Contacto
        //2:Pica
        //3:Arco        
        setTipoAtaque(2);        
        
        this.experienciaMax=5;
        this.experiencia=0;
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Pica");
        h.setTexto("Eleanor causa 1 daño a una criatura a 2 casillas de distancia.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Paseo Élfico");
        h.setTexto("Si durante su turno Eleanor no mueve, puede teleportarse hasta 5 casillas de distancia");
        habilidad.add(h);  
    }      
}

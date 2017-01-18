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
public class Vargen extends Heroe{
    public Vargen(){
        this.nombre="Vargen";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("/com/dorn/assets/heroe/img/vargen.png");       
        this.setRutaCarta("/com/dorn/assets/heroe/card/vargen.png");
        
        this.setRutaRostro("/com/dorn/assets/heroe/face/vargen.png");
        this.setRutaSprite("/com/dorn/assets/heroe/sprite/vargen1.png");
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
        setTipoAtaque(1);        
        
        this.experienciaMax=5;
        this.experiencia=0;
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Garras");
        h.setTexto("Vargen causa 1 daño a una criatura adyacente.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Bocado Fresco");
        h.setTexto("Si Vargen mata a una Rata Gigante o a un Engendro, recupera 1 punto de vida además de conseguir la experiencia.");
        h.setUnoPorTurno(true);
        habilidad.add(h);  
    }        
}

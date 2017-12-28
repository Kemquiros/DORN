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
public class Almanor extends Heroe{
    public Almanor(){
        setNombre("Almanor");
        isAtaqueFisico(false);        
       
        this.setRutaImagen("/com/dorn/assets/heroe/img/almanor.png");       
        this.setRutaCarta("/com/dorn/assets/heroe/card/almanor.png");
        this.setRutaRostro("/com/dorn/assets/heroe/face/almanor.png");
        this.setRutaSprite("/com/dorn/assets/heroe/sprite/almanor1.png");
    }

    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        setMovimientoMax(6);
        
        setVidaMax(3);
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
        h.setNombre("Proyectil Encantado");
        h.setTexto("Almanor causa 1 daño a una criatura hasta a 3 casillas.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Bola de Fuego");
        h.setTexto("Impacta contra una casilla hasta 3 de distancia. Causa 1 daño a cualquier criatura o héroe en esa casilla y todas las adyacentes.");
        h.setCuestaAtaque(true);
        h.setCuestaSangre(true);
        habilidad.add(h);        
    }
    
    @Override
    public void subirNivelDos() {
        setNivel(2);
        
        int nuevaVida=4;
        if(nuevaVida > getVidaMax()){
            setVida(getVida()+1);            
        }
        setVidaMax(nuevaVida);  
        setExperienciaMax(7);        
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Teleportación");
        h.setTexto("Alamanor puede hacer que él u otro héroe adyacente se teleporten hasta 3 casillas.");
        h.setCuestaAtaque(true);
        habilidad.add(h);  
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Ventisca");
        h.setTexto("Ninguna criatura a 3 de distancia puede moverse o atacar durante el turno del Guardián.");
        h.setCuestaAtaque(true);
        h.setCuestaSangre(true);
        habilidad.add(h);        
    }    
    
    @Override
    public void subirNivelTres() {
        setNivel(3);
        
        int nuevaVida=5;
        if(nuevaVida > getVidaMax()){
            setVida(getVida()+1);            
        }
        setVidaMax(nuevaVida);  
        
        setExperienciaMax(0);
        
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Archimago");
        h.setTexto("Almanor puede lanzar Bola de Fuego o invocar Ventisca sin perder puntos de vida.");        
        habilidad.add(h);
        //--------Habilidad 1 y 3 no cuestan sangre
        h = (Habilidad)habilidad.get(1);
        h.setCuestaSangre(false);
        h = (Habilidad)habilidad.get(3);
        h.setCuestaSangre(false);      
    }




    
}

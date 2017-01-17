/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model.heroe;

import com.dorn.model.monster.Criatura;
import com.dorn.model.power.Habilidad;
import com.dorn.model.ritual.Ritual;
import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class Zorkal extends Heroe{
    ArrayList<Ritual> ritual = new ArrayList<Ritual>();
    ArrayList<Criatura> criatura = new ArrayList<Criatura>();
    public Zorkal(){
        this.nombre="Zorkal";
        this.ataqueFisico=true;
        this.habilidad = new ArrayList();
        this.setRutaImagen("./assets/heroe/img/zorkal.png");       
        this.setRutaCarta("./assets/heroe/card/zorkal.png");
        
        this.setRutaRostro("./assets/heroe/face/zorkal.png");
        this.setRutaSprite("./assets/heroe/sprite/zorkal1.png");
    }    
    
    @Override
    public void subirNivelUno() {
        setNivel(1);
        
        this.movimientoMax=6;
        
        this.vidaMax=4;
        this.vida=vidaMax;
        
        this.ataqueMax=2;
        this.setTipoAtaque(1);//Contacto
        
        this.experienciaMax=5;
        this.experiencia=0;
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Horcada Infernal");
        h.setTexto("Zorkal causa 1 daño a un enemigo adyacente.");
        h.setCuestaAtaque(true);
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Invocar Criaturas");
        h.setTexto("Al comienzo de su turno puede invocar criaturas. Durante el día puede invocar a 1 Criatura Menor. Durante la noche, puede invocar 2 Criaturas Menores y 1 Criatura Mayor al azar");
        habilidad.add(h);
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Capa de Incontables Lágrimas");
        h.setTexto("Zorkal es inmune a las cartas de bendición y tesoro, también a las habilidades Exorcismo, Paz Sacra y Ventisca.");
        habilidad.add(h);        
        
    }    
    public void addRitual(Ritual r){
        System.out.println("Zorkal -> Se añade el ritual : "+r.getNombre());
        ritual.add(r);
    }
    public ArrayList<Ritual> getRituales(){
        return ritual;
    }
    public int numRituales(){
        return ritual.size();
    }
    public void addCriatura(Criatura c){
        System.out.println("Zorkal -> Se añade la criatura : "+c.getNombre());
        criatura.add(c);
    }
    public ArrayList<Criatura> getCriaturas(){
        return criatura;
    }  
    public Criatura getCriatura(int indice){
        return criatura.get(indice);
    }    
    
}

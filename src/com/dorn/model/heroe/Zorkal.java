/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model.heroe;

import com.dorn.model.monster.Criatura;
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
    
}

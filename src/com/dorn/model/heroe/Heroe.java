/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model.heroe;

import com.dorn.model.Avatar;
import com.dorn.model.bless.Bendicion;
import com.dorn.model.power.Habilidad;
import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class Heroe extends Avatar{
    
    private String rutaImagen,rutaRostro;
    private int nivel;
    private int experienciaMax,experiencia;   
    private boolean ataqueFisico;
    private boolean usaBendicion=false;
    private boolean usaDetenerAtaque=false;
    private Bendicion bendicion;    
    
    
    
    
    public void subirNivelUno(){};
    public void subirNivelDos(){};
    public void subirNivelTres(){};
    public void iniciarTurno(){
        setMovimiento(getMovimientoMax());
        setAtaque(getAtaqueMax());        
    }
    

    public void subirExperiencia(){
        experiencia+=1;
    };
    public void bajarExperiencia(){
        experiencia-=1;
    };

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Bendicion getBendicion() {
        return bendicion;
    }

    public void setBendicion(Bendicion bendicion) {
        System.out.println(getNombre()+" -> añade bendición: "+bendicion.getNombre());
        this.bendicion = bendicion;
    }

    public boolean isUsaBendicion() {
        return usaBendicion;
    }

    public void usaBendicion() {
        this.usaBendicion = true;
    }
    
    public void setExperienciaMax(int newExperiencia){
        this.experienciaMax = newExperiencia;
    }

    public int getExperienciaMax() {
        return experienciaMax;
    }

    public void setExperiencia(int newExperiencia){
        this.experiencia = newExperiencia;
    }
    
    public int getExperiencia() {
        return experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public boolean isAtaqueFisico() {
        return ataqueFisico;
    }
    
    public void isAtaqueFisico(boolean isIt){
        this.ataqueFisico = isIt;
    }

    public String getRutaRostro() {
        return rutaRostro;
    }

    public void setRutaRostro(String rutaRostro) {
        this.rutaRostro = rutaRostro;
    }

    public boolean isUsaDetenerAtaque() {
        return usaDetenerAtaque;
    }

    public void setUsaDetenerAtaque(boolean usaDetenerAtaque) {
        this.usaDetenerAtaque = usaDetenerAtaque;
    }
    
    
    

    
    
    
}

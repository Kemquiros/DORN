/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.model.heroe;

import com.dorn.model.bless.Bendicion;
import com.dorn.model.map.Casilla;
import com.dorn.model.power.Habilidad;
import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class Heroe {
    String nombre;
    private String rutaImagen,rutaCarta,rutaRostro,rutaSprite;
    private int nivel;
    int vidaMax,vida;
    int experienciaMax,experiencia;
    int ataqueMax,ataque;
    int movimientoMax,movimiento;
    private int tipoAtaque;
    boolean ataqueFisico;
    private boolean usaBendicion=false;
    private Bendicion bendicion;
    //private Casilla casilla;   
    private Object ficha;
    
    ArrayList<Habilidad> habilidad;
    
    
    public void subirNivelUno(){};
    public void subirNivelDos(){};
    public void subirNivelTres(){};
    public void iniciarTurno(){
        this.movimiento=this.movimientoMax;
        this.ataque=this.ataqueMax;
    }
    
    public void subirVida(){
        vida+=1;
    };
    public void bajarVida(){
        vida-=1;
    };
    public void subirExperiencia(){
        experiencia+=1;
    };
    public void bajarExperiencia(){
        experiencia-=1;
    };
    public void atacar(){
        ataque-=1;
    };
    public void mover(){
        movimiento-=1;
    }
    public void establecerTodoMovimiento(){
        movimiento=this.movimientoMax;
    }    
    public void establecerTodoAtaque(){
        ataque=this.ataqueMax;
    }  

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getRutaCarta() {
        return rutaCarta;
    }

    public void setRutaCarta(String rutaCarta) {
        this.rutaCarta = rutaCarta;
    }
    

    public Bendicion getBendicion() {
        return bendicion;
    }

    public void setBendicion(Bendicion bendicion) {
        System.out.println(this.nombre+" -> añade bendición: "+bendicion.getNombre());
        this.bendicion = bendicion;
    }

    public boolean isUsaBendicion() {
        return usaBendicion;
    }

    public void usaBendicion() {
        this.usaBendicion = true;
    }

    public ArrayList<Habilidad> getHabilidad() {
        return habilidad;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public String getNombre() {
        return nombre;
    }

    public int getExperienciaMax() {
        return experienciaMax;
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

    public int getMovimientoMax() {
        return movimientoMax;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public int getAtaqueMax() {
        return ataqueMax;
    }

    public int getAtaque() {
        return ataque;
    }

    public boolean isAtaqueFisico() {
        return ataqueFisico;
    }

    public String getRutaRostro() {
        return rutaRostro;
    }

    public void setRutaRostro(String rutaRostro) {
        this.rutaRostro = rutaRostro;
    }
    /*
    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }*/

    public String getRutaSprite() {
        return rutaSprite;
    }

    public void setRutaSprite(String rutaSprite) {
        this.rutaSprite = rutaSprite;
    }

    public int getTipoAtaque() {
        return tipoAtaque;
    }

    public void setTipoAtaque(int tipoAtaque) {
        //0:Mágico
        //1:Contacto
        //2:Pica
        //3:Arco
        this.tipoAtaque = tipoAtaque;
    }

    public Object getFicha() {
        return ficha;
    }

    public void setFicha(Object ficha) {
        this.ficha = ficha;
    }
    
    
    

    
    
    
}

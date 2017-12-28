/*
 * Copyright (C) 2017 eva
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dorn.model;

import com.dorn.model.map.Ficha;
import com.dorn.model.power.Habilidad;
import java.util.ArrayList;

/**
 *
 * @author Kemquiros
 */
public class Avatar {
    String nombre;
    int movimientoMax,movimiento;
    int vidaMax,vida;
    int ataqueMax,ataque;
    private String rutaCarta;
    private String rutaSprite;
    private int tipoAtaque;
    private Ficha ficha;
    public ArrayList<Habilidad> habilidad;

    public Avatar() {
        this.habilidad = new ArrayList<>();
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }
    

    public int getMovimientoMax() {
        return movimientoMax;
    }

    public void setMovimientoMax(int movimientoMax) {
        this.movimientoMax = movimientoMax;
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

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaqueMax() {
        return ataqueMax;
    }

    public void setAtaqueMax(int ataqueMax) {
        this.ataqueMax = ataqueMax;
    }
    
    public void subirVida(){
        vida+=1;
    }
    
    public void bajarVida(){
        vida-=1;
    }
    
    public void atacar(){
        ataque-=1;
    }
    
    public void mover(){
        movimiento-=1;
    }
    
    public void establecerTodoMovimiento(){
        movimiento=this.movimientoMax;
    }  
    
    public void establecerTodoAtaque(){
        ataque=this.ataqueMax;
    }  
    
    public ArrayList<Habilidad> getHabilidad() {
        return habilidad;
    }    

    public String getRutaCarta() {
        return rutaCarta;
    }

    public void setRutaCarta(String rutaCarta) {
        this.rutaCarta = rutaCarta;
    }

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
    
    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }    
    
    
}

/*
 * Copyright (C) 2017 t30r3m4
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
package com.dorn.model.map;

import com.dorn.model.heroe.Heroe;
import com.dorn.model.monster.Criatura;

/**
 *
 * @author t30r3m4
 */
public class Casilla {

    private int x;
    private int y;
    private int tipo;
    private Casilla arriba;
    private Casilla abajo;
    private Casilla derecha;
    private Casilla izquierda;
    private Casilla c1;
    private Casilla c2;
    private Casilla c3;
    private Casilla c4;
    private boolean esOcupada;
    Object ocupante;
    /*
    -----TIPO DE CASILLA-----
    0:Normal
    1:Argos
    2:Camino de piedra
    */
    public Casilla(int x_,int y_,int tipoCasilla){
        this.x= x_;
        this.y = y_;
        this.tipo= tipoCasilla;
        this.arriba=null;
        this.abajo=null;
        this.derecha=null;
        this.izquierda=null;
        this.c1=null;
        this.c2=null;
        this.c3=null;
        this.c4=null;
        this.esOcupada=false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Casilla getArriba() {
        return arriba;
    }

    public void setArriba(Casilla arriba) {
        this.arriba = arriba;
        if(arriba.getAbajo() == null){
            arriba.setAbajo(this);
        }    
    }
    public void desconectarArriba(){
        this.arriba=null;
    }    

    public Casilla getAbajo() {
        return abajo;
    }

    public void setAbajo(Casilla abajo) {
        this.abajo = abajo;
        if(abajo.getArriba() == null){
            abajo.setArriba(this);
        }   
    }
    public void desconectarAbajo(){
        this.abajo=null;
    }    

    public Casilla getDerecha() {
        return derecha;
    }

    public void setDerecha(Casilla derecha) {
        this.derecha = derecha;
        if(derecha.getIzquierda() == null){
            derecha.setIzquierda(this);
        }        
    }
    public void desconectarDerecha(){
        this.derecha=null;
    }

    public Casilla getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Casilla izquierda) {
        this.izquierda = izquierda;
        if(izquierda.getDerecha()==null){
            izquierda.setDerecha(this);
        }        
    }
    public void desconectarIzquierda(){
        this.izquierda=null;
    }    

    public Casilla getC1() {
        return c1;
    }

    public void setC1(Casilla c1) {
        this.c1 = c1;
        if(c1.getC3() == null){
            c1.setC3(this);
        }           
        
    }

    public Casilla getC2() {
        return c2;
    }

    public void setC2(Casilla c2) {
        this.c2 = c2;
        if(c2.getC4() == null){
            c2.setC4(this);
        }         
    }

    public Casilla getC3() {
        return c3;
    }

    public void setC3(Casilla c3) {
        this.c3 = c3;
        if(c3.getC1() == null){
            c3.setC1(this);
        }          
    }

    public Casilla getC4() {
        return c4;
    }

    public void setC4(Casilla c4) {
        this.c4 = c4;
        if(c4.getC2() == null){
            c4.setC2(this);
        }         
    }
    public void ocupar(Ficha ficha){
        this.ocupante = ficha; 
        ficha.setCasilla(this);
        esOcupada=true;
    }
    public void desocupar(){
        esOcupada=false;
        //Object temp = ocupante;
        this.ocupante=null;
        //return temp;
    }

    public boolean esOcupada() {
        return esOcupada;
    }
    
    public Ficha getFicha(){
        return (Ficha)this.ocupante;
    }
    public Object getOcupante(){
        return ((Ficha)this.ocupante).getOcupante();
    }
    public void desconectar(Casilla objetivo){
        Casilla temp;
        if(this.arriba.equals(objetivo)){
            temp = objetivo;
            this.arriba=null;
            temp.setAbajo(null);            
        }else if(this.derecha.equals(objetivo)){
            temp = objetivo;
            this.derecha=null;
            temp.setIzquierda(null);
        }else if(this.abajo.equals(objetivo)){
            temp = objetivo;
            this.abajo=null;
            temp.setArriba(null);
        }else if(this.izquierda.equals(objetivo)){
            temp = objetivo;
            this.izquierda=null;
            temp.setDerecha(null);
        }else if(this.c1.equals(objetivo)){
            temp = objetivo;
            this.c1=null;
            temp.setC3(null);
        }else if(this.c2.equals(objetivo)){
            temp = objetivo;
            this.c2=null;
            temp.setC4(null);
        }else if(this.c3.equals(objetivo)){
            temp = objetivo;
            this.c3=null;
            temp.setC1(null);
        }else if(this.c4.equals(objetivo)){
            temp = objetivo;
            this.c4=null;
            temp.setC2(null);
        }
        
    }
    public void desconectarDerecha(Casilla objetivo){
        Casilla temp = objetivo;
        desconectarDerecha();
        temp.desconectarIzquierda();
    }
    public void desconectarAbajo(Casilla objetivo){
        Casilla temp = objetivo;
        desconectarAbajo();
        temp.desconectarArriba();
    }    

    
    
}

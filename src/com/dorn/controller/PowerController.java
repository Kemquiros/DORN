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
package com.dorn.controller;

import com.dorn.model.heroe.Heroe;
import com.dorn.model.map.Casilla;
import com.dorn.model.map.Ficha;
import com.dorn.model.map.Mapa;
import com.dorn.model.monster.Criatura;
import com.dorn.model.power.Habilidad;
import com.dorn.view.Tablero;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author t30r3m4
 */
public class PowerController {
    private Mapa mapa;
    private Tablero tablero;
    private int alcanceMax;
    private int alcance;
    private Casilla casillaOrigen,casillaObjetivo;

    PowerController(Mapa _mapa,Tablero _tablero) {
        this.mapa = _mapa;
        this.tablero = _tablero;
    }

    public void resolverHabilidad(Object cliente, Habilidad hab){
        limpiarVariables();
        /*
        1.Primero se determina si es Heroe o Criatura
        2.Se determina si es un ataque
        2.1.Se determina el rango
        */
        if(cliente.getClass().getSuperclass().getCanonicalName().contains("Heroe")){
            Heroe h = (Heroe) cliente;
            //Es un ataque
            if(hab.isCuestaAtaque()){
                setAlcanceMax(hab.getDistancia());
                setAlcanceMax(hab.getDistancia());  
                setCasillaOrigen(((Ficha)h.getFicha()).getCasilla());
                tablero.dibujarAtacarHabilidad(cliente,hab);
            }else{
                tablero.mostrarMensajeHabilidad(hab);
            }
        }else if(cliente.getClass().getSuperclass().getCanonicalName().contains("Criatura")){
            Criatura c = (Criatura)cliente;
            //Es un ataque
            if(hab.isCuestaAtaque()){
                setAlcanceMax(hab.getDistancia());
                setAlcanceMax(hab.getDistancia());  
                setCasillaOrigen(((Ficha)c.getFicha()).getCasilla());                
                tablero.dibujarAtacarHabilidad(cliente,hab);
                //Casilla actual del sujeto
               // Casilla casillaAct = ((Ficha)c.getFicha()).getCasilla();
                //Distancia
                //hab.getDistancia();
                
                //Establecer posibles caminos
//                ArrayList posiblesCaminos = new ArrayList();
//                for(int nivel=0;nivel < hab.getDistancia();nivel++){
//                    if(casillaAct.getArriba() != null){
//                        posiblesCaminos.add(casillaAct.getArriba());
//                    }
//                }
                //Graficar posibles enemigos
                
                //Obtener enemigo seleccionado
                
                //Resolver ataque
                //hab.getDaño();
                
                
            }else{
                tablero.mostrarMensajeHabilidad(hab);
            }
        }
    }

    public int getAlcanceMax() {
        return alcanceMax;
    }

    public void setAlcanceMax(int alcanceMax) {
        this.alcanceMax = alcanceMax;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public Casilla getCasillaOrigen() {
        return casillaOrigen;
    }

    public void setCasillaOrigen(Casilla casillaOrigen) {
        this.casillaOrigen = casillaOrigen;
    }

    public Casilla getCasillaObjetivo() {
        return casillaObjetivo;
    }

    public void setCasillaObjetivo(Casilla casillaObjetivo) {
        this.casillaObjetivo = casillaObjetivo;
    }

    private void limpiarVariables() {
        casillaObjetivo = null;
        casillaOrigen = null;
        setAlcance(0);
        setAlcanceMax(0);
    }

}

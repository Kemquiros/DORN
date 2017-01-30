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

import com.dorn.model.map.Casilla;
import com.dorn.model.map.Ficha;
import com.dorn.model.map.Mapa;
import com.dorn.model.monster.Criatura;
import com.dorn.model.power.Habilidad;
import com.dorn.view.Tablero;
import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class PowerController {
    private Mapa mapa;
    private Tablero tablero;

    PowerController(Mapa _mapa,Tablero _tablero) {
        this.mapa = _mapa;
        this.tablero = _tablero;
    }

    public void resolverHabilidad(Object cliente, Habilidad hab){
        /*
        1.Primero se determina si es Heroe o Criatura
        2.Se determina si es un ataque
        2.1.Se determina el rango
        */
        if(cliente.getClass().getSuperclass().getCanonicalName().contains("Heroe")){
            //Es un ataque
            if(hab.isCuestaAtaque()){
                
            }
        }else if(cliente.getClass().getSuperclass().getCanonicalName().contains("Criatura")){
            Criatura c = (Criatura)cliente;
            //Es un ataque
            if(hab.isCuestaAtaque()){
                //Casilla actual del sujeto
                Casilla casillaAct = ((Ficha)c.getFicha()).getCasilla();
                //Distancia
                hab.getDistancia();
                
                //Establecer posibles caminos
                ArrayList posiblesCaminos = new ArrayList();
                for(int nivel=0;nivel < hab.getDistancia();nivel++){
                    if(casillaAct.getArriba() != null){
                        posiblesCaminos.add(casillaAct.getArriba());
                    }
                }
                //Graficar posibles enemigos
                
                //Obtener enemigo seleccionado
                
                //Resolver ataque
                hab.getDaño();
                
                
            }
        }
    }

}

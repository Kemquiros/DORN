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
package com.dorn.model.monster;

import com.dorn.model.power.Habilidad;

/**
 *
 * @author t30r3m4
 */
public class Engendro extends Criatura{
    public Engendro(){
        setNombre("Engendro");
        setTipoAtaque(1);
        setMovimientoMax(5);
        setMovimiento(getMovimientoMax());
        setVidaMax(2);
        setVida(getVidaMax());
        setAtaqueMax(1);
        setAtaque(getAtaqueMax());
        setLugarInvocacion("Pantano Negro");
        setCriaturaMayor(false);
        setRutaCarta("/com/dorn/assets/monster/card/engendro.png");
        setRutaSprite("/com/dorn/assets/monster/sprite/engendro.png");
        
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Embestir");
        h.setTexto("");
        h.setCuestaAtaque(true);
        h.setDaño(1);
        h.setDistancia(1);
        habilidad.add(h);
        //--------------------------------------     
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Maldición de Pantano");
        h.setTexto("Siempre son invocados en el Pantano.");
        habilidad.add(h);          
    }
}

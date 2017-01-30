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
import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class Esqueleto extends Criatura{
    public Esqueleto(){
        setNombre("Esqueleto");
        setTipoAtaque(2);//Pica
        setMovimientoMax(6);
        setVidaMax(1);
        setVida(getVidaMax());
        setAtaqueMax(1);
        setLugarInvocacion("Cripta");
        setCriaturaMayor(false);
        setRutaCarta("/com/dorn/assets/monster/card/esqueleto.png");
        setRutaSprite("/com/dorn/assets/monster/sprite/esqueleto.png");
        this.habilidad = new ArrayList();
        
        //Habilidades
        //--------------------------------------
        Habilidad h = new Habilidad();
        h.setNombre("Pica");
        h.setTexto("Sólo puede atacar a dos casillas estrictas de distancia.");
        h.setCuestaAtaque(true);
        h.setDaño(1);
        h.setDistancia(2);
        habilidad.add(h);
        //--------------------------------------     
        //--------------------------------------
        h = new Habilidad();
        h.setNombre("Maldición de Cripta");
        h.setTexto("Siempre son invocados en la Cripta.");
        habilidad.add(h);            
    }
}

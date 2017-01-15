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

/**
 *
 * @author t30r3m4
 */

public class Momia extends Criatura{
    public Momia(){
        setNombre("Momia");
        setTipoAtaque(1);
        setMovimientoMax(6);
        setVidaMax(2);
        setAtaqueMax(2);
        setLugarInvocacion("Templo Oscuro");
        setCriaturaMayor(true);
        setRutaCarta("./assets/monster/card/momia.png");
        setRutaSprite("./assets/monster/sprite/momia.png");
    }
}

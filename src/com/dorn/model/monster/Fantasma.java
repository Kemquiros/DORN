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

public class Fantasma extends Criatura{
    public Fantasma(){
        setNombre("Fantasma");
        setTipoAtaque(1);
        setMovimientoMax(12);
        setVidaMax(2);
        setVida(getVidaMax());
        setAtaqueMax(1);
        setLugarInvocacion("Templo Oscuro");
        setCriaturaMayor(true);
        setRutaCarta("/com/dorn/assets/monster/card/fantasma.png");
        setRutaSprite("/com/dorn/assets/monster/sprite/fantasma.png");
    }
}

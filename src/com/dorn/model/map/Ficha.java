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

/**
 *
 * @author t30r3m4
 */
public class Ficha {
    private Object figuraOriginal,figuraEscalada;
    private Casilla casilla;



    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Object getFiguraOriginal() {
        return figuraOriginal;
    }

    public void setFiguraOriginal(Object figuraOriginal) {
        this.figuraOriginal = figuraOriginal;
    }

    public Object getFiguraEscalada() {
        return figuraEscalada;
    }

    public void setFiguraEscalada(Object figuraEscalada) {
        this.figuraEscalada = figuraEscalada;
    }

    
    
    
    
}

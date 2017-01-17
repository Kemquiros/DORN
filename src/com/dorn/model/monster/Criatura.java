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
public class Criatura {
    private String nombre;
    private int movimiento;
    private int movimientoMax;
    private int vida;
    private int vidaMax;
    private int ataque;
    private int ataqueMax;
    private String lugarInvocacion;
    private String descripcion;
    private String rutaCarta;
    private String rutaSprite;
    private boolean criaturaMayor;    
    private int tipoAtaque;
    private Object ficha;

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

    public String getLugarInvocacion() {
        return lugarInvocacion;
    }

    public void setLugarInvocacion(String lugarInvocacion) {
        this.lugarInvocacion = lugarInvocacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCriaturaMayor() {
        return criaturaMayor;
    }

    public void setCriaturaMayor(boolean criaturaMayor) {
        this.criaturaMayor = criaturaMayor;
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

    public Object getFicha() {
        return ficha;
    }

    public void setFicha(Object ficha) {
        this.ficha = ficha;
    }
    
    
}

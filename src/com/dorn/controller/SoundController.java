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

import com.dorn.sound.Sound;

/**
 *
 * @author t30r3m4
 */
public class SoundController {
    public void sonidoInicio() {
        Thread sonidoPrincipal= new Thread(){
             public void run() {
                Sound s = new Sound();
                //s.playSound("./assets/sound/main.wav");
                s.playSound("/com/dorn/assets/sound/main.wav");
                //s.playSound(AssetsController.getRecurso("sound/main.wav"));
                
             }
        };
        sonidoPrincipal.start();
    }
    public void sonidoClick(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                //s.playSound("./assets/sound/click.wav");
                //s.playSound(getClass().getResource(rutaMapa));
                s.playSound("/com/dorn/assets/sound/click.wav");
             }
        };
        t.start();
    }
    public void sonidoTablero(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/fondo.wav");
                
             }
        };
        t.start();
    }
    public void sonidoMover(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/move.wav");
             }
        };
        t.start();
    }
    //Criatura menor
    public void sonidoEsqueleto(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/monster/esqueleto.wav");
             }
        };
        t.start();
    }    
    public void sonidoEngendro(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/monster/engendro.wav");
             }
        };
        t.start();
    } 
    public void sonidoRata(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/monster/rata.wav");
             }
        };
        t.start();
    }     
    public void sonidoZombi(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/monster/no-mercy.wav");
             }
        };
        t.start();
    }       
    //Criatura mayor
    public void sonidoGorgona(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/monster/gorgona.wav");
             }
        };
        t.start();
    }         
    public void sonidoFantasma(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/monster/fantasma.wav");
             }
        };
        t.start();
    } 
    public void sonidoVampiro(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/monster/vampiro.wav");
             }
        };
        t.start();
    }     
    public void sonidoMomia(){
        Thread t= new Thread(){
             public void run() {
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/monster/momia.wav");
             }
        };
        t.start();
    }        
    public void sonidoTableroFondo(){
        Thread t= new Thread(){
             public void run() {
                
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/fondo.wav");
             }
        };
        t.start();
    }    
    public void sonidoGuardian(){
        Thread t= new Thread(){
             public void run() {
                
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/zorkal.wav");
             }
        };
        t.start();
    }  
    public void sonidoHeroes(){
        Thread t= new Thread(){
             public void run() {
                
                Sound s = new Sound();
                s.playSound("/com/dorn/assets/sound/party.wav");
             }
        };
        t.start();
    }      
}

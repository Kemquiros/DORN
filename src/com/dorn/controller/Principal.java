/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.controller;

import com.dorn.view.Tablero;

/**
 *
 * @author t30r3m4
 */
public final class Principal {
    private static Tablero tablero;
    private static Thread hiloTablero;
    private Principal(){  
        System.out.println("Crea");
    }
    public static void iniciaTablero(){
        hiloTablero= new Thread(){
            public void run() {
                tablero= new Tablero();                
            }        
        };
        hiloTablero.start();        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.controller;


import com.dorn.model.Jugador;
import com.dorn.model.bless.*;
import com.dorn.model.heroe.*;
import com.dorn.model.monster.*;
import com.dorn.model.ritual.*;
import com.dorn.view.Inicio;
import com.dorn.view.Seleccion;
import com.dorn.view.Tablero;
import java.util.ArrayList;

/**
 *
 * @author t30r3m4
 */
public class Principal {
    private static Heroe[] heroes;
    private static String rutaMapa="./assets/map/mapa_escalado.jpg";
    private static Tablero tablero;
    private static Inicio inicio;
    private static Seleccion seleccion;    
    private static Thread hiloTablero,hiloInicio,hiloSeleccion;
    private static int numeroJugadores;
    private static ArrayList<Jugador> jugadores;
    private static boolean esNoche;
    private static boolean juegoTermina=false;


    
    public Principal(){  
        inicio = new Inicio(this); 
        iniciarHeroes();

    }
//-----------------------------------------
// --------------- MENÚ -------------------
//-----------------------------------------    
    public void iniciarMenu(){
        hiloInicio= new Thread(){
             public void run() {
                 inicio.start();                 
             }
        };
        hiloInicio.start();
        
    }
    
//-----------------------------------------
// ------------- SELECCIÓN ----------------
//-----------------------------------------     
    public void iniciarSeleccion() {
        seleccion = new Seleccion(this);
        inicio.setVisible(false);
        hiloInicio.suspend();
        
        hiloSeleccion= new Thread(){
             public void run() {
                 seleccion.start();                 
             }
        };    
        hiloSeleccion.start();
        
    }  
    public void cancelarSeleccion() {
       seleccion.setVisible(false);
       hiloSeleccion.stop();
       hiloInicio.resume();
       inicio.ajustarPantalla();
       inicio.setVisible(true);
    }    
    
    public void finalizarSeleccion(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        
        //Kill selection window
        seleccion.setVisible(false);
        hiloSeleccion.stop();
        //Kill menu window
        hiloInicio.stop();
        //Reciclar Elementos
        System.gc();
        
        //Iniciar parametros del juego
        this.iniciarJuego();

    }    
    
//-----------------------------------------
// --------------- TABLERO ----------------
//-----------------------------------------     
    public static void iniciaTablero(){
        hiloTablero= new Thread(){
        public void run() {
                tablero= new Tablero(); 
                tablero.dibujarTablero(rutaMapa);
                tablero.dibujarSecuencia(jugadores);
                //tablero.dibujarHeroe(jugador[0].getHeroe());
                
                //---Colocar 6 Fichas artefactos
                
                //---Colocar 24 Fichas tesoros
                
                //---Colocar fichas Héroes en pueblo Argos
                
                tablero.pack();
                tablero.setVisible(true);
            }        
        };
        hiloTablero.start();        
    }
    
//-----------------------------------------
// --------------- JUEGO ------------------
//-----------------------------------------     
    public void iniciarJuego() {
        //Establecer orden turno aleatoriamente
        establecerOrdenTurno();
        
        //Establecer a todos los héroes en nivel 1
        for(Jugador j:this.jugadores){
            j.getHeroe().subirNivelUno();
        }
        
        //Dotar de 6 rituales al guardián
        dotarRituales();
        
        //Dotar de 1 bención a cada héroe
        dotarBendiciones();
        
        //Brindar al guardían 5 criaturas menores al azar
        dotarCritaturasMenores();
        
        //Brindar al guardían 1 criatura mayor al azar        
        dotarCritaturasMayores();
        
        //Primer turno de Zorkal es de día
        esNoche=false;
        
        
        
        /*jugador = new Jugador[numJugadores];
        jugador[0] = new Jugador();
        jugador[0].setNombre("John");
        jugador[0].setHeroe(new Almanor());
        jugador[0].getHeroe().subirNivelUno();
        jugador[0].getHeroe().subirNivelDos();
        jugador[0].getHeroe().bajarVida();
        jugador[0].getHeroe().subirExperiencia();
        jugador[0].getHeroe().iniciarTurno();
        jugador[0].getHeroe().mover();
        jugador[0].getHeroe().mover();
        */
        

    }
    public static void jugar(){
        /*
        --------------------------
        TURNO ZORKAL
        --------------------------
        1.Jugar ritual
        2.Invocar critaura
        3.Mueve criatura
        4.Ataca criatura
        5.Alterna día/noche
        --------------------------
        TURNO HEROES
        --------------------------    
        1.Jugar bendición
        2.Todos los héroes mueven
        2.1 Recoger objeto/artefacto
        2.2 Usar o entregar objeto
        3.Todos los héroes atacan
        4.Se resuelven efectos de curación
        */
        while(!juegoTermina){
            //----Turno Zorkal
            //----Turno Heroes
            
        }
    }

    private void iniciarHeroes() {
        heroes = new Heroe[9];
        heroes[0] = new Almanor();
        heroes[1] = new Choros();
        heroes[2] = new Eleanor();
        heroes[3] = new Gor();
        heroes[4] = new Guelin();
        heroes[5] = new Kaerdrak();
        heroes[6] = new Ragnar();
        heroes[7] = new Riel();
        heroes[8] = new Vargen();
    }
    public Heroe[] getHeroes() {
        return heroes;
    }    

    private void establecerOrdenTurno() {
        System.out.println("------Viejo Orden Jugadores----");
        for(Jugador j:jugadores){
            System.out.println(j.getNombre()+ " - "+j.getHeroe().getNombre());
        }        
        int tam = this.jugadores.size();
        ArrayList<Jugador> nueva = new ArrayList<>();
        int[] numHeroes = new int[tam];
        int temp;
        //El primer turno siempre será del Guardián
        nueva.add(this.jugadores.get(0));
        numHeroes[0]=1;
        //Se establecen los turnos de los héroes al azar
        while(nueva.size()<tam){
            temp=(int)Math.floor((Math.random()*tam));
            if(numHeroes[temp]!=1){//No se ha agregado
                nueva.add(this.jugadores.get(temp));
                numHeroes[temp]=1;
            }
        }
        this.jugadores= nueva;
        System.out.println("------Nuevo Orden Jugadores----");
        for(Jugador j:jugadores){
            System.out.println(j.getNombre()+ " - "+j.getHeroe().getNombre());
        }
    }

    private void dotarRituales() {
        //Son 12 rituales en total
        //Se deben dotar 6 al Guardián
        int temp;
        int[] ritualesDisponibles = new int[12];        
        Zorkal zorkal = (Zorkal)jugadores.get(0).getHeroe();
        
        while(zorkal.numRituales()<6){
            temp=(int)Math.floor((Math.random()*12));
            if(ritualesDisponibles[temp] != 1){//No se ha agregado
                try {
                  Class<?> r =  Class.forName("com.dorn.model.ritual.R"+(temp+1));                
                  zorkal.addRitual((Ritual)r.newInstance()); 
                  ritualesDisponibles[temp]=1;//Se agrega
                } catch (Exception e) {
                    System.err.println("Error -> ");
                    System.err.println(e.getMessage());
                }

            }
        }
        //zorkal.addRitual(r);
    }

    private void dotarBendiciones() {
        int temp;
        int[] bendicionesDisponibles = new int[12];       
        
        //Cuenta desde 1 porque 0 es el guardían
        for(int i=1;i<jugadores.size();i++){
            boolean asignado=false;
            //jugadores.get(i).getHeroe().setBendicion(bendicion);
            while(!asignado){//Mientras no se le asigne bendición
                temp=(int)Math.floor((Math.random()*12));//Son 12 bendiciones
                if(bendicionesDisponibles[temp] != 1 ){//No se ha agregado
                    try {
                      Class<?> b =  Class.forName("com.dorn.model.bless.B"+(temp+1));                
                      jugadores.get(i).getHeroe().setBendicion((Bendicion)b.newInstance()); 
                      bendicionesDisponibles[temp]=1;//Se agrega
                      asignado=true;
                    } catch (Exception e) {
                        System.err.println("Error -> ");
                        System.err.println(e.getMessage());
                    }
                }
                
            }
        }
    }

    private void dotarCritaturasMenores() {
        int temp;
        //5 criaturas menores
        for(int i=0;i<5;i++){
            Criatura menor=null;
            temp=(int) Math.floor(((Math.random()*4)+1));
            switch(temp){
                case 1://Rata Gigante
                    menor = new Rata();
                    break;
                case 2://Zombi
                    menor = new Zombi();
                    break;
                case 3: //Esqueleto
                    menor = new Esqueleto();
                    break;
                case 4://Engendro
                    menor = new Engendro();
                    break;
            }
            //Agregar a zorkal
            ((Zorkal)jugadores.get(0).getHeroe()).addCriatura(menor);
        }
    }

    private void dotarCritaturasMayores() {
        int temp=(int) Math.floor(((Math.random()*4)+1));
        Criatura mayor=null;
        switch(temp){
            case 1://Rata Gigante
                mayor = new Fantasma();
                break;
            case 2://Zombi
                mayor = new Momia();
                break;
            case 3: //Esqueleto
                mayor = new Vampiro();
                break;
            case 4://Engendro
                mayor = new Gorgona();
                break;
        }   
        //Agregar a zorkal
        ((Zorkal)jugadores.get(0).getHeroe()).addCriatura(mayor);        
    }








}

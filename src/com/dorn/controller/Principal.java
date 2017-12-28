/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.controller;


import com.dorn.model.Jugador;
import com.dorn.model.bless.*;
import com.dorn.model.heroe.*;
import com.dorn.model.map.Ficha;
import com.dorn.model.map.Mapa;
import com.dorn.model.monster.*;
import com.dorn.model.ritual.*;
import com.dorn.view.Inicio;
import com.dorn.view.Seleccion;
import com.dorn.view.Tablero;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author t30r3m4
 */
public class Principal {
    private Mapa mapa;
    private static Heroe[] heroes;
    private static String rutaMapa="/assets/map/mapa_escalado.jpg";
    private static Tablero tablero;
    private static Inicio inicio;
    private static Seleccion seleccion;    
    private static Thread hiloTablero,hiloInicio,hiloSeleccion;
    private static int numeroJugadores;
    private static ArrayList<Jugador> jugadores;
    private static ArrayList<Ficha> fichas;
    private static boolean esNoche;
    private static boolean juegoTermina=false;
    private boolean isZorkalLibre= false;
    private int turnoActual=0;
    public SoundController sonido;
    public CursorController cursor;
    public PowerController power;
    public SpellsController spell;
    


//-----------------------------------------
// ------- PRINCIPAL'S BUILDER ------------
//-----------------------------------------    
    public Principal(){  
        inicio = new Inicio(this); 
        mapa = new Mapa();
        tablero = new Tablero();
        sonido = new SoundController();
        cursor = new CursorController();        
        power = new PowerController(mapa,tablero);
        fichas = new ArrayList<>();
        iniciarHeroes();
        sonido.sonidoInicio();
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
        cursor.setNormal(inicio);
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
        cursor.setNormal(seleccion);
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
// --------------- JUEGO ------------------
//-----------------------------------------     
    public void iniciarJuego() {
        turnoActual=1;
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
        
        tablero.setParent(this);
        this.iniciaTablero();  
        
    }
//-----------------------------------------
// --------------- TABLERO ----------------
//-----------------------------------------     
    public void iniciaTablero(){
        //Sonido de fondo del talblero
        //Dura 17 segundos
        SoundController sc = this.sonido;
        new Thread(){
            public void run() {
                while(!juegoTermina){            
                    try {
                        sc.sonidoTableroFondo();
                        Thread.sleep(17000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();

        hiloTablero= new Thread(){
        public void run() {
            tablero.dibujarTablero(rutaMapa);
            
            //mapa.escalar(tablero.getFactorEscaladoX(), tablero.getFactorEscaladoY(),true);
            tablero.dibujarSecuencia(jugadores);

            //---Colocar 6 Fichas artefactos

            //---Colocar 24 Fichas tesoros

            //---Colocar fichas Héroes en pueblo Argos
            tablero.dibujarFichasHeroes(mapa);

            //---Colocar ficha Zorkal en pueblo Argos
            tablero.dibujarFichaZorkal();
            tablero.show();
            tablero.setVisible(true);
                        
            
            jugar();
                
            }        
        };
        hiloTablero.start();   
        spell.setH(tablero.getHeight());
        spell.setW(tablero.getWidth());
        cursor.setNormal(tablero);
    }    
    public void jugar(){
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
        cambiarTurnoZorkal();
    }
    
    //------------------------------
    //--------- TURNO ZORKAL  ------
    //------------------------------
    public void jugarZorkal(){
        
        
        tablero.dibujarSecuenciaZorkal();

        tablero.setJugadorActual(0);
        tablero.setPersonajeActual(jugadores.get(0).getHeroe());
        tablero.dibujarHeroe();
        //-------Iniciar stats de turno
        iniciarStatsTurno(jugadores.get(0).getHeroe());
        //Jugar ritual
        jugarRitual();        
    }
    public void jugarRitual(){
        tablero.dibujarRitual();
    }
    public void jugarInvocar(){
        /*if(turnoActual!=1){//En el turno 1 ya se dotó 6 criaturas
            if(esNoche){
                tablero.dibujarEscogerCriaturaNoche();
            }else{
                tablero.dibujarEscogerCriaturaDia();
            }
        }*/
        tablero.dibujarInvocar();
    }
    public void jugarMoverGuardian(){
        //Inicia stats
        for(Criatura c:((Zorkal)jugadores.get(0).getHeroe()).getCriaturasInvocada()){
            iniciarStatsTurno(c);
        }
        tablero.setCamaraPersonal();        
        jugarMoverCriaturas(0);        
    }
    public void jugarMoverZorkal(){
            tablero.dibujarMoverZorkal();        
    }
    public void jugarMoverCriaturas(int indiceCriatura){
        
        if(indiceCriatura<((Zorkal)jugadores.get(0).getHeroe()).getCriaturasInvocada().size()){
            tablero.setPersonajeActual(((Zorkal)jugadores.get(0).getHeroe()).getCriaturasInvocada().get(indiceCriatura));
            tablero.dibujarMoverCriaturas(indiceCriatura);
        }else{//Ya movieron todas las criaturas
            if(isZorkalLibre){//Si Zorkal está libre
                jugarMoverZorkal();
            }else{
                jugarAtacarGuardian();
            }
        }
    }
    public void jugarAtacarGuardian(){    
        jugarAtacarCriaturas(0);
    }
    public void jugarAtacarCriaturas(int indiceCriatura){
        if(indiceCriatura<((Zorkal)jugadores.get(0).getHeroe()).getCriaturasInvocada().size()){
        tablero.setPersonajeActual(((Zorkal)jugadores.get(0).getHeroe()).getCriaturasInvocada().get(indiceCriatura));
        tablero.dibujarAtacarCriaturas(indiceCriatura);
        }else{//Ya movieron todas las criaturas
            if(isZorkalLibre){//Si Zorkal está libre
                jugarAtacarZorkal();
            }else{
                finalizarTurnoZorkal();
            }
        }        
    }    
    public void jugarAtacarZorkal(){
        //tablero.dibujarAtacarCriaturas();
        //if(isZorkalLibre){
            tablero.dibujarAtacarZorkal();
        //}        
    }
    public void finalizarTurnoZorkal(){
        alternarDiaNoche();
        tablero.alternarDiaNoche(esNoche);
        cambiarTurnoHeroes();
    }
    public void cambiarTurnoZorkal(){
        tablero.setCamaraGlobal();
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        ImageIcon ic = new ImageIcon(getClass().getResource("/com/dorn/assets/other/guardian.png"));
        final JOptionPane optionPane = new JOptionPane("Guardían", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, ic, new Object[]{}, null);

        final JDialog dialog = new JDialog();
        dialog.setTitle("Cambio de turno");
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.getRootPane().setOpaque(false);
        dialog.setContentPane(optionPane);
        
        

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocation(((w/2)-(dialog.getWidth()/2)), ((h/2)-(dialog.getHeight()/2)));
        //create timer to dispose of dialog after 5 seconds
        
        sonido.sonidoGuardian();
        new Timer(4000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        }).start();

        dialog.setVisible(true);
        jugarZorkal();
    }
    public void cambiarTurnoHeroes(){
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        tablero.setCamaraGlobal();
        //Genera retraso
        ImageIcon ic = new ImageIcon(getClass().getResource("/com/dorn/assets/other/party.png"));

        final JOptionPane optionPane = new JOptionPane("HÉROES", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, ic, new Object[]{}, null);

        final JDialog dialog = new JDialog();
        dialog.setTitle("Cambio de turno");
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.getRootPane().setOpaque(false);
        dialog.setContentPane(optionPane);
        
        

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocation(((w/2)-(dialog.getWidth()/2)), ((h/2)-(dialog.getHeight()/2)));
        
        sonido.sonidoHeroes();
        //create timer to dispose of dialog after 5 seconds
        new Timer(4000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        }).start();
        //timer.setRepeats(false);//the timer should only go off once

        //start timer to close JDialog as dialog modal we must start the timer before its visible
        //timer.start();
        dialog.setVisible(true);
        
        jugarHeroes();
    }
    
    //------------------------------
    //--------- TURNO HEROES  ------
    //------------------------------    
    public void jugarHeroes(){
        tablero.setCamaraPersonal();
        tablero.dibujarSecuenciaHeroes(); 
        //Iniciar stats turno
        for(int i=1;i<jugadores.size();i++){
            iniciarStatsTurno(jugadores.get(i).getHeroe());
        }
        jugarBencion(1);
    }
    public void jugarBencion(int jugador){
        if(jugador<jugadores.size()){
            tablero.setJugadorActual(jugador);
            tablero.posicionarCamara(jugadores.get(jugador).getHeroe().getFicha());
            tablero.dibujarHeroe();
            tablero.dibujarBendicion();
        }else{//No quedan más jugadores
            jugarMoverHeroes(1);
        }

    }
    public void jugarMoverHeroes(int jugador){
        if(jugador<jugadores.size()){
            tablero.setPersonajeActual(jugadores.get(jugador).getHeroe());
            tablero.setJugadorActual(jugador);
            tablero.posicionarCamara(jugadores.get(jugador).getHeroe().getFicha());
            tablero.dibujarHeroe();
            tablero.dibujarMover();
        }else{//No quedan más jugadores
            jugarAtacarHeroes(1);
        }
    }
    public void jugarAtacarHeroes(int jugador){
        if(jugador<jugadores.size()){
            tablero.setJugadorActual(jugador);
            tablero.setPersonajeActual(jugadores.get(jugador).getHeroe());
            tablero.posicionarCamara(jugadores.get(jugador).getHeroe().getFicha());
            tablero.dibujarHeroe();
            tablero.dibujarAtacar();
        }else{//No quedan más jugadores
            jugarCurarHeroes();
        }        
    }    
    public void jugarCurarHeroes(){
        //Se consideran las posiciones de los héroes
        //Se cura al que se debe curar
        
        //Termina turno
        cambiarTurnoZorkal();
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
    public void iniciarStatsTurno(Object personaje){
        if(personaje.getClass().getSuperclass().getCanonicalName().contains("Heroe")){
            ((Heroe)personaje).establecerTodoMovimiento();
            ((Heroe)personaje).establecerTodoAtaque();
        }else if(personaje.getClass().getSuperclass().getCanonicalName().contains("Criatura")){
            System.out.println("Reestablece criatura");
            ((Criatura)personaje).establecerTodoMovimiento();
            ((Criatura)personaje).establecerTodoAtaque();
        }

    }

    private void alternarDiaNoche() {
        if(esNoche){
            esNoche = false;
        }else{
            esNoche=true;
        }
    }



    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void addFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }
    
    public void resolverHabilidad(){
        
    }










}

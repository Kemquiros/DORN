/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.view;

import com.dorn.controller.Principal;
import com.dorn.model.Jugador;
import com.dorn.model.heroe.Zorkal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author t30r3m4
 */
public class Seleccion extends javax.swing.JFrame {    
    Principal parent;
    ArrayList<Jugador> jugadores;
    int w = Toolkit.getDefaultToolkit().getScreenSize().width;
    int h = Toolkit.getDefaultToolkit().getScreenSize().height;
    int[] selectHeroes = new int[9];
    JButton[] boton = new JButton[9]; 
    int indiceHeroe =-1;
    int numjugador=0;
    
    ActionListener zorkalListener;

    
    public Seleccion(Principal p) {
        parent=p;

    }
    public void start(){
        initComponents();
        initComponents2();
        jugadores=new ArrayList<>();
        crearBotonesZorkal();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpGeneral = new javax.swing.JPanel();
        jpIzquierda = new javax.swing.JPanel();
        jpHeroe = new javax.swing.JPanel();
        jpFigura = new javax.swing.JPanel();
        jpOpcion = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbFinalizar = new javax.swing.JButton();
        jpDerecha = new javax.swing.JPanel();
        jpJugadores = new javax.swing.JPanel();
        jpLista = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jpGeneral.setLayout(new javax.swing.BoxLayout(jpGeneral, javax.swing.BoxLayout.X_AXIS));

        jpIzquierda.setLayout(new javax.swing.BoxLayout(jpIzquierda, javax.swing.BoxLayout.Y_AXIS));

        jpHeroe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selección de Guardián", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 1, 18))); // NOI18N

        jpFigura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpFigura.setLayout(new javax.swing.BoxLayout(jpFigura, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jpHeroeLayout = new javax.swing.GroupLayout(jpHeroe);
        jpHeroe.setLayout(jpHeroeLayout);
        jpHeroeLayout.setHorizontalGroup(
            jpHeroeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFigura, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        jpHeroeLayout.setVerticalGroup(
            jpHeroeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFigura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );

        jpIzquierda.add(jpHeroe);

        jpOpcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 1, 18))); // NOI18N
        jpOpcion.setLayout(new java.awt.GridLayout(1, 4));

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jpOpcion.add(jbCancelar);

        jbFinalizar.setText("Finalizar");
        jbFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarActionPerformed(evt);
            }
        });
        jpOpcion.add(jbFinalizar);

        jpIzquierda.add(jpOpcion);

        jpGeneral.add(jpIzquierda);

        jpJugadores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 1, 18))); // NOI18N

        jpLista.setLayout(new javax.swing.BoxLayout(jpLista, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jpJugadoresLayout = new javax.swing.GroupLayout(jpJugadores);
        jpJugadores.setLayout(jpJugadoresLayout);
        jpJugadoresLayout.setHorizontalGroup(
            jpJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpJugadoresLayout.createSequentialGroup()
                .addComponent(jpLista, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpJugadoresLayout.setVerticalGroup(
            jpJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJugadoresLayout.createSequentialGroup()
                .addComponent(jpLista, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpDerechaLayout = new javax.swing.GroupLayout(jpDerecha);
        jpDerecha.setLayout(jpDerechaLayout);
        jpDerechaLayout.setHorizontalGroup(
            jpDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDerechaLayout.createSequentialGroup()
                .addComponent(jpJugadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpDerechaLayout.setVerticalGroup(
            jpDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDerechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jpGeneral.add(jpDerecha);

        getContentPane().add(jpGeneral);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        parent.sonido.sonidoClick();
        parent.cancelarSeleccion();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarActionPerformed
        parent.sonido.sonidoClick();
        parent.finalizarSeleccion(jugadores);
    }//GEN-LAST:event_jbFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbFinalizar;
    private javax.swing.JPanel jpDerecha;
    private javax.swing.JPanel jpFigura;
    private javax.swing.JPanel jpGeneral;
    private javax.swing.JPanel jpHeroe;
    private javax.swing.JPanel jpIzquierda;
    private javax.swing.JPanel jpJugadores;
    private javax.swing.JPanel jpLista;
    private javax.swing.JPanel jpOpcion;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {

        int wp=w;//(w/2);
        int hp=h;//(h/2); 

       
        this.dispose();


        this.setSize(wp, hp);
        this.setPreferredSize(new Dimension(wp, hp));
        //setLocation(new Point((wp/2), (hp/2)));
        setUndecorated(true);
        
        jpFigura.setSize(wp, jpHeroe.getHeight());
        jpHeroe.setSize(wp, ((hp*9)/10));
        jpOpcion.setSize(wp, ((hp*1)/10));

        

        this.setPreferredSize(new Dimension(wp, hp+(hp/10)));
        jbFinalizar.setEnabled(false);
        this.show();
    }


    public void agregarJugadorLista(Jugador j){
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(1, 2));
        JLabel ji = new JLabel();
        JLabel jn = new JLabel(j.getNombre());
        jn.setBackground(Color.DARK_GRAY);
        ji.setIcon(escalarImagen(((w*8)/100), ((h*8)/100), j.getHeroe().getRutaRostro()));
        jp.add(ji);
        jp.add(jn);
        
        jpLista.add(jp);
        if(numjugador==1){//Acaba de agregar a Zorkal
            JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
            jpLista.add(sep);
        }
        
        //jp.add(jp)
        this.show();
    }

    public void crearBotonesZorkal(){
        jpFigura.setLayout(new GridLayout(3, 3, 2, 2));
        for(int i=0;i<9;i++){
            if(i==4){
               boton[i] = new JButton(this.escalarImagen(((w*8)/100), ((h*8)/100), "/com/dorn/assets/heroe/face/zorkal.png")) ;
               boton[i].setText("ZORKAL");
               boton[i].setEnabled(true);
                //Listener Zorkal     
                zorkalListener = new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        botonZorkal_ActionPerformed(evt);
                    }
                };
                boton[i].addActionListener(zorkalListener);                
            }else{
                boton[i] = new JButton();                
                boton[i].setEnabled(false);
                //boton[i].setVisible(false);
            }
            boton[i].setSize(((w*6)/100), ((h*6)/100));

            boton[i].setName("b"+i);
            jpFigura.add(boton[i]);
            
        }        
    }
    private void crearBotonesHeroes() {
        //jpFigura = new JPanel();


        //lbl1.setVisible(false);
        /*------Heroes
        1:Almanor
        2:Choros
        3:Eleanor
        4:Gor
        5:Guelin
        6:Kaerdrak
        7:Ragnar
        8:Riel
        9:Vargen
        //-----------*/
        //jpFigura.setLayout(new GridLayout(3, 3, 2, 2));

        for(int i=0;i<9;i++){
            //boton[i] = new JButton(this.escalarImagen(((w*8)/100), ((h*8)/100), parent.getHeroes()[i].getRutaRostro()));       
            boton[i].setIcon(this.escalarImagen(((w*8)/100), ((h*8)/100), parent.getHeroes()[i].getRutaRostro()));
            boton[i].setText(parent.getHeroes()[i].getNombre());
            boton[i].setName(Integer.toString(i));
            
            if(i==4){//Remover Listener Zorkal
                boton[i].removeActionListener(zorkalListener);
            }
            //boton[i].setSize(((w*6)/100), ((h*6)/100));

            //boton[i].setName("b"+i);
            //Poner el listener en el botón
            boton[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonHeroe_ActionPerformed(evt);
                }
            });  
            //jpFigura.add(boton[i]);
            boton[i].setEnabled(true);
        }
    }
    private void mostrarHeroes(){
        //Si el heroe ya está seleccionado
        //Deshabilita el botón        
        for(int i=0;i<9;i++){
            boton[i].setVisible(true);
            if(selectHeroes[i]==1){
                boton[i].setEnabled(false);
            }else{
                boton[i].setEnabled(true);
            } 
        }
    }
    private void botonHeroe_ActionPerformed(ActionEvent evt) {
        parent.sonido.sonidoClick();
//        jbSiguiente.setEnabled(true);
//        jbFinalizar.setEnabled(false);
        JButton origen = ((JButton)evt.getSource());
        String nombreJugador = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador #"+numjugador);//origen.getName();        
        indiceHeroe = Integer.parseInt(origen.getName());
        //Héroe seleccionado
        selectHeroes[indiceHeroe]=1;
        origen.setEnabled(false);

        //------------------------------------------------
            if(numjugador>=1){ 
            //--------Transformación Gráfica
            jbFinalizar.setEnabled(true);
            //--------
            }
            //------Crear nuevo Jugador
            Jugador j= new Jugador();
            j.setNombre(nombreJugador);
            j.setHeroe(parent.getHeroes()[indiceHeroe]);
            jugadores.add(j);
            numjugador++;
            //------------------------------

            agregarJugadorLista(j);         
            //------------------------------            
            indiceHeroe =-1;
            //Bloquear
            if(numjugador==6){//Ya escogieron a todos los personajes
                bloquearSeleccion();
            }         
        //------------------------------------------------
    }
    
    private void botonZorkal_ActionPerformed(ActionEvent evt) {
        parent.sonido.sonidoClick();
        //jbSiguiente.setEnabled(true);
        boton[4].setEnabled(false);
        
        
        //-------------------------------
        //------Crear nuevo Jugador
        Jugador j= new Jugador();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
        j.setNombre(nombre);
        j.setHeroe(new Zorkal());
        jugadores.add(j);
        numjugador++;
        //-------------------------

        //--------Transformación Gráfica            
        jpHeroe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selección de Héroes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 1, 18))); 
        agregarJugadorLista(j);
        crearBotonesHeroes();        
    }    
    private void bloquearSeleccion(){
        jbFinalizar.setEnabled(true);
        for(int i=0;i<9;i++){
            boton[i].setEnabled(false);
        }
    }
    
    
    public ImageIcon escalarImagen(int w_,int h_, String url){
        ImageIcon ic = new ImageIcon(getClass().getResource(url));
        Image icRes = ic.getImage().getScaledInstance(w_, h_, Image.SCALE_SMOOTH);
        ic = new ImageIcon(icRes);
        return ic;
    }    
    public ImageIcon escalarImagenOptimizado(int w_,int h_, String url){
        int tempW=0,tempH=0;
        Double factEsca,a,b;
        ImageIcon ic = new ImageIcon(getClass().getResource(url));
        a=Double.parseDouble(Integer.toString(ic.getIconHeight()) );
        b=Double.parseDouble(Integer.toString(h_) );
        factEsca= (a/b);
        if(factEsca<=1){
           // System.err.println("PAILAS");
        }else{
            tempW= (int) (ic.getIconWidth()/factEsca);
            tempH= (int) (ic.getIconHeight()/factEsca);
        }
        //System.err.println("FAc Real Esc "+tempH);
        /*
        tempW=Math.min(w,ic.getIconWidth());
        tempH=Math.min(h,ic.getIconHeight());
        */

        Image icRes = ic.getImage().getScaledInstance(tempW, tempH, Image.SCALE_SMOOTH);
        ic = new ImageIcon(icRes);
        return ic;
    }     
    
}

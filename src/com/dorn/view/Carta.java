/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author t30r3m4
 */
public class Carta extends JDialog{
    public JPanel jpExterno;
    public JPanel jpImagen;
    public JScrollPane spImagen; 
    JButton jbCancelar;
    JButton jbAceptar;
    /*
    TIPO CARTA:
    1:Ritual
    2:Bendicion
    3:Invocar
    4:Héroe
    */
    public Carta(JFrame parent,String rutaImagen, int tipoCarta) {
        
        super(parent,true);
        initComponents(rutaImagen,parent);
        pack();
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
        switch(tipoCarta){
            case 1:
                cartaRitual();
                break;
            case 2:
                cartaBendicion();
                break;
            case 3:
                InvocarInicial();
                break;
            case 4:
                cartaInvocar();
                break;
            case 5:
                cartaHeroe();
                break;
            default:
                break;
        }
        
    }

    private void initComponents(String rutaImagen,JFrame parent) {
        //Panel externo
        jpExterno = new JPanel();
        jpExterno.setLayout(new BoxLayout(jpExterno,BoxLayout.Y_AXIS));
        
        //Menu inferior
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1,2));
        jbCancelar = new JButton("Cancelar");
        jbAceptar = new JButton("Aceptar");          
        
        
        menu.add(jbCancelar);
        menu.add(jbAceptar);
        this.add(jpExterno);
        
        //Imagen carta
        Dimension size=parent.getSize();
        ImageIcon ic = new ImageIcon(getClass().getResource(rutaImagen));
        int w = Math.min(size.width, ic.getIconWidth());
        int h = Math.min(size.height,ic.getIconHeight());        
        JLabel imagenCarta = new JLabel( this.escalarImagen(w, h,ic) );
        jpImagen = new JPanel();
        spImagen = new JScrollPane(jpImagen);
        spImagen.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spImagen.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);         
        
        jpImagen.setPreferredSize(new Dimension(w, h));
        spImagen.setBounds(0, 0, w, h);        
        
        //Añadir
        jpImagen.add(imagenCarta);
        jpExterno.add(spImagen);
        jpExterno.add(menu);
        
        //Listeners
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });        

                
    }
    private void cancelarActionPerformed(ActionEvent evt) {
        this.dispose();
    }
    
    public ImageIcon escalarImagen(int w,int h, ImageIcon ic){
        
        Image icRes = ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ic = new ImageIcon(icRes);
        return ic;
    }    

    private void cartaRitual() {
        this.setTitle("Carta Ritual");
        jbAceptar.setText("Jugar");
        this.show();
    }

    private void cartaBendicion() {
        this.setTitle("Carta Bendición");
        jbAceptar.setText("Jugar");
        this.show();
    }

    private void InvocarInicial() {
        this.setTitle("Invocación inicial de criaturas");
        this.setTitle("Invocar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               invocarInicial();
            }


        });   
        this.show();
    }

    private void cartaInvocar() {
        
        this.setTitle("Jugar carta Invocar");
        this.setTitle("Invocar");
        this.show();
    }

    private void cartaHeroe() {
        this.setTitle("Carta Héroe");
        jbAceptar.setVisible(false);
        this.show();
    }
    
    private void invocarInicial() {
        ((Tablero)this.getParent()).invocarCriaturaInicial();
        this.dispose();
    }    
}

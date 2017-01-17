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
    public Carta(JFrame parent,String rutaImagen) {
        
        super(parent,true);
        initComponents(rutaImagen,parent);
        pack();
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
    }

    private void initComponents(String rutaImagen,JFrame parent) {
        //Panel externo
        jpExterno = new JPanel();
        jpExterno.setLayout(new BoxLayout(jpExterno,BoxLayout.Y_AXIS));
        
        //Menu inferior
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1,2));
        JButton cancelar = new JButton("Cancelar");
        JButton invocar = new JButton("Aceptar");          
        
        
        menu.add(cancelar);
        menu.add(invocar);
        this.add(jpExterno);
        
        //Imagen carta
        Dimension size=parent.getSize();
        ImageIcon ic = new ImageIcon(rutaImagen);
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
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });        

                
    }
    private void cancelarActionPerformed(ActionEvent evt) {
        System.out.println("PRUSUSUDASDS");
        this.dispose();
    }
    
    public ImageIcon escalarImagen(int w,int h, ImageIcon ic){
        
        Image icRes = ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ic = new ImageIcon(icRes);
        return ic;
    }    
}

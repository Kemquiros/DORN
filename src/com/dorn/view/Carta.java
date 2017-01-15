/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dorn.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
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
        Dimension size=parent.getSize();
        ImageIcon ic = new ImageIcon(rutaImagen);
        int w = Math.min(size.width, ic.getIconWidth());
        int h = Math.min(size.height,ic.getIconHeight());        
        JLabel imagenCarta = new JLabel( this.escalarImagen(w, h,ic) );
        JPanel pImagenCarta = new JPanel();
        JScrollPane spImagenCarta = new JScrollPane(pImagenCarta);
        spImagenCarta.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spImagenCarta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);         
        
        pImagenCarta.setPreferredSize(new Dimension(w, h));
        spImagenCarta.setBounds(0, 0, w, h);        
        pImagenCarta.add(imagenCarta);
        this.add(spImagenCarta);
                
    }
    public ImageIcon escalarImagen(int w,int h, ImageIcon ic){
        
        Image icRes = ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ic = new ImageIcon(icRes);
        return ic;
    }    
}

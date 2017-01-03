
package com.dorn.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javafx.scene.paint.Color;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author t30r3m4
 */
public class Tablero extends javax.swing.JFrame{
    JLabel picMapa ;
    JLabel picPersonaje ;
    JPanel panelInterno1 ;
    JScrollPane scrollPane1 ;
    JPanel panelExterno1 ;
    JPanel panelInterno2 ;
    JScrollPane scrollPane2 ;
    JPanel panelExterno2 ;
    
    public Tablero() {
        initComponents();
        
    }

    private void initComponents() {     
        
        int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
        int heightScreen = Toolkit.getDefaultToolkit().getScreenSize().height;
        //-------------------------
        //Tablero
        //-------------------------
        picMapa = new JLabel(new ImageIcon("./assets/map/mapa_escalado.jpg"));        
        panelInterno1 = new JPanel();
        scrollPane1 = new JScrollPane(panelInterno1);
        panelExterno1 = new JPanel(null);

        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panelInterno1.add(picMapa);
        //setLayout(new FlowLayout());

        int w = (int)((widthScreen*9)/10);
        int h = (int)((heightScreen*3)/6);
        scrollPane1.setBounds(10, 10,w, h);
       // scrollPane1.setBounds(10, 10,200, 200);
        //scrollPane1.setBounds(10, 10, Toolkit.getDefaultToolkit().getScreenSize().width-100, Toolkit.getDefaultToolkit().getScreenSize().height-300);
        
        panelExterno1.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panelExterno1.add(scrollPane1);

        //setContentPane(panelExterno1);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        
        
        //-------------------------
        //Carta personaje
        //-------------------------  
        w = (int)((widthScreen*7)/10);
        h = (int)((heightScreen*3)/6);
        ImageIcon ic = new ImageIcon(new ImageIcon("./assets/heroe/card/choros.png").getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        picPersonaje = new JLabel( );
        picPersonaje.setIcon(ic);
        
        panelInterno2 = new JPanel();
        scrollPane2 = new JScrollPane(panelInterno2);
        panelExterno2 = new JPanel(null);
        
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);        
        
        panelInterno2.add(picPersonaje);
        //setLayout(new FlowLayout());
        //System.err.println((int)((widthScreen*7)/10));
        h = (int)((heightScreen*2)/6);
        scrollPane2.setBounds(10, 0, w, h);
        panelExterno2.setPreferredSize(new Dimension(400, 700));        
        panelExterno2.add(scrollPane2);
        //setContentPane(panelExterno2);
       // this.add(panelExterno2);
        
        
        
        /*javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.addLayoutComponent("1", panelExterno1);
        layout.addLayoutComponent("2", panelExterno2);
        */
        JPanel container = new JPanel();
        //BoxLayout.X_AXIS
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(panelExterno1);
        container.add(panelExterno2);
        //container.setBackground(java.awt.Color.red);
        this.add(container);
        //getContentPane().setBackground( java.awt.Color.BLACK );
        pack();

        scrollPane1.getHorizontalScrollBar().setValue(((scrollPane1.getVerticalScrollBar().getMaximum())/2)*1);
        scrollPane1.getVerticalScrollBar().setValue(scrollPane1.getVerticalScrollBar().getMaximum());
        setVisible(true);
    }
}

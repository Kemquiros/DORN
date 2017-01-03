
package com.dorn.view;

import java.awt.FlowLayout;
import java.awt.Toolkit;
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
    JLabel picLabel ;
    JPanel panelInterno ;
    JScrollPane scrollPane ;
    JPanel panelExterno ;
    
    public Tablero() {
        initComponents();
        
    }

    private void initComponents() {
        System.out.println("Grafica");
        picLabel = new JLabel(new ImageIcon("./assets/map/mapa_escalado.jpg"));
        panelInterno = new JPanel();
        scrollPane = new JScrollPane(panelInterno);
        panelExterno = new JPanel(null);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panelInterno.add(picLabel);
        setLayout(new FlowLayout());

        scrollPane.setBounds(10, 10, Toolkit.getDefaultToolkit().getScreenSize().width-200, Toolkit.getDefaultToolkit().getScreenSize().height-100);

        panelExterno.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        panelExterno.add(scrollPane);

        setContentPane(panelExterno);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        pack();

        scrollPane.getHorizontalScrollBar().setValue((scrollPane.getVerticalScrollBar().getMaximum())/2);
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        setVisible(true);
    }
}

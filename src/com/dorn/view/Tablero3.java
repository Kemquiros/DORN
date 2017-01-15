
package com.dorn.view;

import com.dorn.model.heroe.Heroe;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javafx.scene.paint.Color;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author t30r3m4
 */
public class Tablero3 extends javax.swing.JFrame{
    
    int widthScreen,heightScreen;
    JLabel picMapa ;
    JLabel picPersonaje ;
    JPanel panelInterno1 ;
    JScrollPane scrollPane1 ;
    JPanel panelExterno1 ;
    JPanel panelInterno2 ;
    JScrollPane scrollPane2 ;
    JPanel panelExterno2 ;
    
    JPanel l ;
    
    public Tablero3() {
        widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
        heightScreen = Toolkit.getDefaultToolkit().getScreenSize().height;
        l = new JPanel();        
        initComponents();

    }

    private void initComponents() {     

        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);

        BoxLayout box = new BoxLayout(l, BoxLayout.X_AXIS);
        l.setLayout(box);

        this.add(l);

    }
    public void dibujarTablero(String rutaMapa){
        int w,h;
        //-------------------------
        //Panel externo 1
        //-------------------------  
        w = (int)((widthScreen*14)/20);
        h = (int)((heightScreen*10)/12);             
        panelExterno1 = new JPanel(null);
        panelExterno1.setLayout(new BoxLayout(panelExterno1, BoxLayout.Y_AXIS));             
        panelExterno1.setBackground(java.awt.Color.BLACK);
        panelExterno1.setPreferredSize(new Dimension(w, h));
        l.add(panelExterno1);  
        
        //-------------------------
        //Tablero
        //-------------------------
        w = (int)((widthScreen*14)/20);
        h = (int)((heightScreen*9)/12);
        
        
        JLabel imagenMapa = new JLabel( this.escalarImagen(w, h, rutaMapa) );
        JPanel pImagenMapa = new JPanel();
        JScrollPane spImagenMapa = new JScrollPane(pImagenMapa);
        spImagenMapa.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spImagenMapa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);         
        
        pImagenMapa.setPreferredSize(new Dimension(w, h));
        spImagenMapa.setBounds(0, 0, w, h);        
        pImagenMapa.add(imagenMapa);
 
        //-------------------------
        //Secuencia
        //-------------------------   
        JPanel secuencia0 = new JPanel(new GridLayout(1, 2));
        JPanel secuencia1 = new JPanel(new GridLayout(1, 2));
        JPanel secuencia2 = new JPanel(new GridLayout(1, 4));
        JPanel secuencia3 = new JPanel(new GridLayout(1, 5));
        
        secuencia0.add(crearLabel("DÍA"));
        secuencia0.add(crearLabel("NOCHE"));        
        
        secuencia1.add(crearLabel("ZORKAL"));
        secuencia1.add(crearLabel("HEROES"));
        
        secuencia2.add(crearLabel("BENDICIÓN"));
        secuencia2.add(crearLabel("MOVER"));
        secuencia2.add(crearLabel("ATACAR"));
        secuencia2.add(crearLabel("CURAR"));
        
        secuencia3.add(crearLabel("ALMANOR"));
        secuencia3.add(crearLabel("CHOROS"));
        secuencia3.add(crearLabel("KAERDRAK"));
        secuencia3.add(crearLabel("GUELIN"));
        secuencia3.add(crearLabel("VARGEN"));

        panelExterno1.add(secuencia0);
        panelExterno1.add(spImagenMapa);         
        panelExterno1.add(secuencia1);
        panelExterno1.add(secuencia2);
        panelExterno1.add(secuencia3);
        

    }
    public void dibujarHeroe(Heroe heroe){
        int w,h;
        //-------------------------
        //Panel externo 2
        //-------------------------
        w = (int)((widthScreen*5)/20);
        h = (int)((heightScreen*9)/12);
        panelExterno2 = new JPanel(null);
        panelExterno2.setLayout(new BoxLayout(panelExterno2, BoxLayout.Y_AXIS));             
        panelExterno2.setBackground(java.awt.Color.red);
        panelExterno2.setPreferredSize(new Dimension(w, h));
        l.add(panelExterno2); 
        
        //-------------------------
        //Imagen Heroe
        //-------------------------          
        w = (int)((widthScreen*4)/20);
        h = (int)((heightScreen*4)/12);
        JLabel imagenHeroe = new JLabel( this.escalarImagen(w, h, heroe.getRutaImagen()) );
        JPanel pImagenHeroe = new JPanel();
        pImagenHeroe.setBackground(java.awt.Color.black);
        JScrollPane spImagenHeroe = new JScrollPane(pImagenHeroe);
        spImagenHeroe.setBackground(java.awt.Color.ORANGE);
        spImagenHeroe.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spImagenHeroe.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);         
        
        pImagenHeroe.setPreferredSize(new Dimension(w, h));
        spImagenHeroe.setBounds(0, 0, w, h);        
        pImagenHeroe.add(imagenHeroe);
        panelExterno2.add(spImagenHeroe);

        //-------------------------
        //Ver Heroe
        //-------------------------    
        JButton botonVer = new JButton();
        botonVer.setText("Ver");
        botonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerActionPerformed(evt);
            }
        });
        panelExterno2.add(botonVer);
        //-------------------------
        //Habilidades Heroe
        //------------------------- 
        JLabel lblHabAc = new JLabel("Activas");
        panelExterno2.add(lblHabAc);
        
        
        
       
    }
    public ImageIcon escalarImagen(int w,int h, String url){
        ImageIcon ic = new ImageIcon(url);
        Image icRes = ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ic = new ImageIcon(icRes);
        return ic;
    }
    private void botonVerActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new Carta(this,"./assets/heroe/card/almanor.png").setVisible(true);
        //new Carta(this,"./assets/card/bless/1.png").setVisible(true);
    }    
    private JLabel crearLabel(String texto){
     JLabel j = new JLabel(texto);
     //j.setFont(ne);
     j.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
     j.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
     return j;
    }
}

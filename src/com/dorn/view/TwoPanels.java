/*
 * Copyright (C) 2017 t30r3m4
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dorn.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author t30r3m4
 */
public class TwoPanels {
    public static void main(String[] args) {

        JPanel p = new JPanel();
        // setting layout to null so we can make panels overlap
        p.setLayout(null);

        CirclePanel topPanel = new CirclePanel();
        // drawing should be in blue
        topPanel.setForeground(Color.blue);
        // background should be black, except it's not opaque, so 
        // background will not be drawn
        topPanel.setBackground(Color.black);
        // set opaque to false - background not drawn
        topPanel.setOpaque(false);
        topPanel.setBounds(50, 50, 100, 100);
        // add topPanel - components paint in order added, 
        // so add topPanel first

       /* 
        OvalPanel topPanel = new OvalPanel();
        topPanel.setBackground(Color.MAGENTA);
        */
        
        p.add(topPanel);

        CirclePanel bottomPanel = new CirclePanel();
        // drawing in green
        bottomPanel.setForeground(Color.green);
        // background in cyan
        bottomPanel.setBackground(Color.cyan);
        // and it will show this time, because opaque is true
        bottomPanel.setOpaque(true);
        bottomPanel.setBounds(30, 30, 100, 100);
        // add bottomPanel last...
        p.add(bottomPanel);

        // frame handling code...
        JFrame f = new JFrame("Two Panels");
        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    // Panel with a circle drawn on it.
    private static class CirclePanel extends JPanel {

        // This is Swing, so override paint*Component* - not paint
        protected void paintComponent(Graphics g) {
            // call super.paintComponent to get default Swing 
            // painting behavior (opaque honored, etc.)
            super.paintComponent(g);
            int x = 10;
            int y = 10;
            int width = getWidth() - 20;
            int height = getHeight() - 20;
            g.drawArc(x, y, width, height, 0, 360);
            
        }
    }
    private static  class OvalPanel extends JPanel{
                protected void paintComponent(Graphics g) {
            // call super.paintComponent to get default Swing 
            // painting behavior (opaque honored, etc.)
            super.paintComponent(g);
            int x = 10;
            int y = 10;
            int width = getWidth() - 20;
            int height = getHeight() - 20;
            g.fillOval(x, y, width, height);
            
        }
    }
}

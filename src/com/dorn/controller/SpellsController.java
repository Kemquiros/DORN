/*
 * Copyright (C) 2017 eva
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
package com.dorn.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author eva
 */
public class SpellsController {

    private int w;
    private int h;

    public JLabel getSpell1() {
        JLabel jl = new JLabel();
        jl.setIcon(escalarImagen(0, 0, "/com/dorn/assets/spells/spells.png"));
        return jl;
    }

    public ImageIcon escalarImagen(int w, int h, String url) {
        ImageIcon ic = new ImageIcon(getClass().getResource(url));

        Image image = ic.getImage();
        BufferedImage bi = toBufferedImage(image);
        BufferedImage bsi = bi.getSubimage(0, 0, 20, 20);
        ic = new ImageIcon(bsi);
        try {
            Image icRes = ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);

            //icRes = icRes.getGraphics().create(0, 0, 10, 10).;
            ic = new ImageIcon(icRes);
        } catch (Exception e) {
            System.err.println("Daña URL -> " + url);
        }

        return ic;
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

}

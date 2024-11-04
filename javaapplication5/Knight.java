/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;

import javax.swing.ImageIcon;

/**
 *
 * @author SSP
 */
public class Knight {
    public ImageIcon[] im = new ImageIcon[7];
    public int x;
    public int count = 0;
    Knight(){
        for(int i=0;i<im.length;i++){
            im[i] = new ImageIcon(this.getClass().getResource((i+1)+".png"));
	}
    }
}

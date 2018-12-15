/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Personal
 */
public class finish extends Sel {
  private int tinggi ;
  private int lebar ;
  private char nilai ;

    public finish(int tinggi, int lebar, char nilai , int x , int y) {
        super(x,y); // 
        URL loc = this.getClass().getResource("");// isi gawang / finish 
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.tinggi = tinggi;
        this.lebar = lebar;
        this.nilai = nilai;
        this.setImage(image);
        this.setNilai(nilai);
    }
  
  
     @Override
    public int getTinggi() {
        return tinggi;
    }
     @Override
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }
     @Override
    public int getLebar() {
        return lebar;
    }
     @Override
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }
     @Override
    public char getNilai() {
        return nilai;
    }
     @Override
    public void setNilai(char nilai) {
        this.nilai = nilai;
    }
  
  
}

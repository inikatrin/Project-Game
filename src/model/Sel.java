/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author user only
 */
public class Sel {

    private int posisiX;
    private int posisiY;
    private int lebar;
    private int tinggi;
    private char nilai;
    private Image image;
    private int jarak=30;

    public Sel(int x, int y) {
        this.posisiX=x;
        this.posisiY=y;
    }
    
    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX=posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public char getNilai() {
        return nilai;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean posisiKiri (Sel Object){
        if(((this.getLebar()-jarak)== Object.getLebar())&&(this.getTinggi()==Object.getTinggi())){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean posisiKanan (Sel Object){
        if(((this.getLebar()+jarak)==Object.getLebar())&&(this.getTinggi()==Object.getTinggi())){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean posisiAtas (Sel Object){
        if(((this.getTinggi()-jarak)==Object.getTinggi())&&(this.getLebar()== Object.getLebar())){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean posisiBawah (Sel Object){
        if(((this.getTinggi()+jarak)== Object.getTinggi())&&(this.getLebar()==Object.getLebar())){
            return true;
        }else{
            return false;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author user only
 */
public class Tempat extends JPanel {

    private int tinggi = 0; // tinggi tempat Game
    private int lebar = 0;
    private int jarak = 30;// lebar tempat Game
    private boolean completed = false;
    private ArrayList<Sel> sel = new ArrayList<>(); // daftar sel
    private ArrayList<dinding> dinding = new ArrayList();
    private finish Finish;
    private orang  Orang ;
    private LinkedList<String> undo = new LinkedList<>();
    private String isi; // isi file konfigurasi
    private final char DINDING = '#';
    private final char ORANG = '@';
    private final char KOSONG = '-';
    private final char FINISH = 'O';

    private File alamatPeta;
    private ArrayList semuaPerintah = new ArrayList();

    public Tempat() {
        setFocusable(true);
    }

    public Tempat(File file) {
        bacaKonfigurasi(file);
    }
    
    public ArrayList<dinding>getDinding(){
        return dinding;
    }
    
    public void setDinding(dinding Dinding){
        this.dinding.add(Dinding);
    }
    
    public ArrayList<Sel>getSel(){
        return sel;
    }
    
     public void setSel(orang Orang, ArrayList<dinding> dinding, finish Finish ) {
        this.sel.add(Orang);
        this.sel.addAll(dinding );
        this.sel.add(Finish);
    }

    public void bacaKonfigurasi(File file) {
         FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Tempat peta = (Tempat) ois.readObject();
            this.setIsi(peta.getIsi());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void simpanObjekKonfigurasi(File file) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(isi.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the isi
     */
    public String getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Object getDaftarSel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Sel;
import model.Tempat;

/**
 *
 * @author user only
 */
public class GameFrame extends JFrame {
    
     Tempat tempat = new Tempat();
    private TempatPanel tempatPanel;

    private JLabel perintahlabel;
    private JTextField perintahText;

    private JButton pindahKananButton;
    private JButton pindahKiriButton;
    private JButton pindahAtasButton;
    private JButton PindahBawahButton;
    private JButton okButton ;
    private JButton tambahButton;
    private JButton hapusButton;
    
    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem , simpanKonfigurasiMenuItem;

    public GameFrame(String title ) {
        this.setTitle(title);
        this.init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public GameFrame(String title, TempatPanel tempatPanel) {
        setTitle(title);
        this.tempatPanel = tempatPanel;
        this.init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {
        // set ukuran dan layout
        this.setSize(500,300);
        this.setLayout(new BorderLayout());

        // set menu Bar
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        exitMenuItem = new JMenuItem("Keluar");
        bacaKonfigurasiMenuItem = new JMenuItem("Baca");
        simpanKonfigurasiMenuItem = new JMenuItem("Simpan");
        gameMenu.add(simpanKonfigurasiMenuItem);
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
        
         bacaKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                Tempat peta = null;
                int returnVal = jf.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    boolean check = false;
                    if (!check) {
                        peta = new Tempat(jf.getSelectedFile());
                        check = true;
                    } else {
                        peta.bacaObjekKonfigurasi(jf.getSelectedFile());
                    }
                    // menampilkan atribut 'isi' dari kelas Tempat
                    System.out.println("\nIsi peta Baru = ");
                    System.out.println(peta.getIsi());
                    if (peta.getSel() != null) {
                        for (int i = 0; i < peta.getSel().size(); i++) {
                            // menampilkan nilai posisiX,posisiY dan nilai
                            System.out.println(
                                    peta.getSel().get(i).getPosisiX() + ","
                                    + peta.getSel().get(i).getPosisiY() + ",");
                        }
                    }
                }
                // buat tempatPanel dan tambahkan tempat ke tempatPanel
                peta = new Tempat();
                init();
            }
        });
        simpanKonfigurasiMenuItem.addActionListener(
                new ActionListener() {
            @Override
              public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnVal = fc.showSaveDialog(null);
                Tempat peta = new Tempat();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    peta.simpanObjekKonfigurasi(fc.getSelectedFile());
                }
            }
        });
        //action perform for exitMenuItem
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );
        // panel selatan
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        this.perintahlabel = new JLabel("Perintah");
        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(20);
        southPanel.add(perintahText);

        this.okButton = new JButton("ok");
        southPanel.add(okButton);
        
        
       okButton.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent ae) {
                if ("L".equalsIgnoreCase(perintahText.getText())) {
                    pindahKiri();
                } else if ("R".equalsIgnoreCase(perintahText.getText())) {
                    pindahKanan();
                } else if ("U".equalsIgnoreCase(perintahText.getText())) {
                    pindahAtas();
                } else if ("D".equalsIgnoreCase(perintahText.getText())) {
                    pindahBawah();
           }
             }
       }
       );
       
       // set contentPane
        Container cp = this.getContentPane();
        if (tempatPanel != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }
        cp.add(southPanel, BorderLayout.SOUTH);

        // set visible= true
        this.setVisible(true);
    }
       

         
    public void pindahKanan() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if( getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@'){
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan(i);
            
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }
    }
    public void pindahKiri() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
          if(getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@'){  
            getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri(i);
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }
    }
    public void pindahAtas() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
             if(getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@'){  
             getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas(i);
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }
    }

    public void pindahBawah() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
           if(getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@'){  
              getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah(i);
           }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    /**
     * @return the tempatPanel
     */
    public TempatPanel getTempatPanel() {
        return tempatPanel;
    }

    /**
     * @param tempatPanel the tempatPanel to set
     */
    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }

}

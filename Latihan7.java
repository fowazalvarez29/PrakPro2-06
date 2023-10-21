/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

/**
 *
 * @author alvarez
 */
public class Latihan7 extends JFrame {
    
    public Latihan7 () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Membuat label dengan teks "Form Biodata" yang berada di tengah jendela
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);
        headerLabel.setBounds(0, 20, 350, 10);
        
        // Label untuk nama
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 40, 350, 10);
        
        // TextField untuk input nama
        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);
        
        // Label untuk Nomor Telepon
        JLabel labelTelp = new JLabel("Nomor Telepon: ");
        labelTelp.setBounds(15, 100, 350, 10);
        
        // TextField untuk input Nomor Telepon
        JTextField textFieldTelp = new JTextField();
        textFieldTelp.setBounds(15, 120, 350, 30);
        
        // Label Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin: ");
        labelRadio.setBounds(15, 130, 350, 10);
        
        // RadioButton untuk memilih jenis kelamin (Laki-Laki atau Perempuan)
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 150, 350, 30);
        
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 175, 350, 30);
        
        // Mengelompokkan RadioButton agar hanya satu yang bisa dipilih
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        
         // CheckBox untuk menandai apakah pengguna adalah Warga Negara Asing
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 205, 350, 30);
        
        // Tombol untuk menyimpan data yang diinputkan
        JButton button = new JButton("Simpan");
        button.setBounds(15,250,100,40);
        
        // Tabel untuk menampilkan data pengguna
        javax.swing.JTable table = new JTable();
        
        // JScrollPane untuk membuat tabel dapat di-scroll jika data melebihi ukuran tabel
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,300,350,200);
        
        // Menggunakan kustom model tabel (MyTableModelLatihan7) untuk mengelola data tabel
        MyTableModelLatihan7 tableModel = new MyTableModelLatihan7();
        table.setModel(tableModel);
        
        // Menambahkan KeyListener untuk membatasi input telepon hanya angka
        textFieldTelp.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldTelp.getText();
                int len = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textFieldTelp.setEditable(true);
                } else {
                    textFieldTelp.setEditable(false);
                }
            }
        });
        
        // Menambahkan ActionListener untuk tombol "Simpan"
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengambil nilai input dari elemen-elemen GUI
                String wna = "";
                String jenisKelamin = "";
                String nama = textField.getText();
                String telepon = textFieldTelp.getText();
                
                if(radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if(radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                
                if (checkBox.isSelected()) {
                    wna = "Ya";
                } else {
                    wna = "Bukan";
                }
                
                // Menambahkan data ke model tabel
                tableModel.add(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, wna)));
                
                // Mengosongkan elemen-elemen input setelah data disimpan
                textField.setText("");
                textFieldTelp.setText("");
                radioButton1.setSelected(true);
                radioButton2.setSelected(false);
                checkBox.setSelected(false);
            }
        });
        
        // Menambahkan semua elemen GUI ke JFrame
        this.add(headerLabel);
        this.add(button);
        this.add(textField);
        this.add(labelTelp);
        this.add(textFieldTelp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelInput);
        this.add(scrollableTable);
        
        // Mengatur ukuran dan tata letak jendela
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
    // Metode utama (entry point) untuk menjalankan aplikasi Latihan7.
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                // Membuat objek Latihan7 dan menampilkannya
                Latihan7 h = new Latihan7();
                h.setVisible(true);
            }
        });
    }
    
}
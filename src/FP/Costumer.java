/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FP;

/**
 *
 * @author RIZKI HERIANA
 */
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;

public class Costumer extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stat;
    int harga,total_bayar,qty,total_harga,nomor_meja,status;
    String kode_transaksi = "1",kode_menu,nama,keterangan, tanggal_transaksi;
    LocalDateTime tgl;
    
    private void koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/fppbo"; //url database
            String user = "root"; //user database
            String pass = ""; //password database
            con = DriverManager.getConnection(url, user, pass);
            stat = con.createStatement();
            rs = stat.executeQuery("select * from transaksi_temporary");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }
    }

    private void display() {
        try {
            if(status==1){
            String sql = "SELECT transaksi_temporary.kode_menu, menu.nama_menu, transaksi_temporary.harga, transaksi_temporary.qty FROM menu INNER JOIN transaksi_temporary ON menu.kode_menu = transaksi_temporary.kode_menu WHERE transaksi_temporary.kode_transaksi = '"+kode_transaksi+"';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            Pesan.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void totalharga () {
        try {
            if(status==1){
                koneksi();
                stat = con.createStatement();
                String sql = "SELECT SUM(total_harga) FROM `transaksi_temporary`WHERE kode_transaksi = '"+kode_transaksi+"';";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    total_bayar = rs.getInt(1);
                }
                jTextTotal.setEditable(false);
                jTextTotal.setText(String.valueOf(total_bayar));
            }
        } catch (Exception e) {}
    }
    
    private String dateTime(){
        tgl = LocalDateTime.now();
        tanggal_transaksi = String.valueOf(tgl);
        tanggal_transaksi.replace("T", " ");
        
        return tanggal_transaksi;
    }
    
    private void Clear(){
        jTextJumlahAirMineral.setText(null);
        jTextJumlahCeker.setText(null);
        jTextJumlahEsGenderuwo.setText(null);
        jTextJumlahEsOrange.setText(null);
        jTextJumlahEsPocong.setText(null);
        jTextJumlahEsSundelBolong.setText(null);
        jTextJumlahEsTeh.setText(null);
        jTextJumlahEsTuyul.setText(null);
        jTextJumlahLemonTea.setText(null);
        jTextJumlahLumpiangUdang.setText(null);
        jTextJumlahMieAngel.setText(null);
        jTextJumlahMieIblis.setText(null);
        jTextJumlahMieSetan.setText(null);
        jTextJumlahMilo.setText(null);
        jTextJumlahPangsitGoreng.setText(null);
        jTextJumlahSiomay.setText(null);
        jTextJumlahTehTarik.setText(null);
        jTextJumlahUdangKeju.setText(null);
        jTextJumlahUdangRambutan.setText(null);
        jTextJumlahVanilaLatte.setText(null);
        jTextNama.setText(null);
        jTextNomorMeja.setText(null);
    }
      
    private void LevelMieSetan(){
        try {
            koneksi();
            String klik_kode_menu = jComboBoxMieSetan.getSelectedItem().toString();
            String sql = "SELECT kode_menu FROM menu WHERE nama_menu = 'Mie Setan "+klik_kode_menu+"'";
            stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                kode_menu = rs.getString("kode_menu");
            }
        }catch(Exception e){}
    }
    
    private void LevelMieIblis(){
        try {
            koneksi();
            String klik_kode_menu = jComboBoxMieSetan.getSelectedItem().toString();
            String sql = "SELECT kode_menu FROM menu WHERE nama_menu = 'Mie Iblis "+klik_kode_menu+"'";
            stat = con.prepareStatement(sql);
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                kode_menu = rs.getString("kode_menu");
            }
        }catch(Exception e){}
    }
    
    private void ComboKeterangan(){
        keterangan = jComboBoxKeterangan.getSelectedItem().toString();
    }
    /**
     * Creates new form Costumer
     */
    public Costumer() {
        initComponents();
        koneksi();   //memanggil fungsi koneksi
        display();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanelMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        menu1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BeliMieAngel = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextJumlahMieAngel = new javax.swing.JTextField();
        jTambahMieAngel = new javax.swing.JButton();
        jKurangMieAngel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        menu2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        BeliMieSetan = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jComboBoxMieSetan = new javax.swing.JComboBox<>();
        jTextJumlahMieSetan = new javax.swing.JTextField();
        jTambahMieSetan = new javax.swing.JButton();
        jKurangMieSetan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        menu3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        BeliMieIblis = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jComboBoxMieIblis = new javax.swing.JComboBox<>();
        jTextJumlahMieIblis = new javax.swing.JTextField();
        jTambahMieIblis = new javax.swing.JButton();
        jKurangMieIblis = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        menu4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        BeliSiomay = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jTextJumlahSiomay = new javax.swing.JTextField();
        jTambahSiomay = new javax.swing.JButton();
        jKurangSiomay = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        menu5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        BeliCeker = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jTextJumlahCeker = new javax.swing.JTextField();
        jTambahCeker = new javax.swing.JButton();
        jKurangCeker = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        menu6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        BeliUdangRambutan = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jTextJumlahUdangRambutan = new javax.swing.JTextField();
        jTambahUdangRambutan = new javax.swing.JButton();
        jKurangUdangRambutan = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        menu7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        BeliUdangkeju = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jTextJumlahUdangKeju = new javax.swing.JTextField();
        jTambahUdangkeju = new javax.swing.JButton();
        jKurangUdangKeju = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        menu8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        BeliLumpiangUdang = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jTextJumlahLumpiangUdang = new javax.swing.JTextField();
        jTambahLumpiangUdang = new javax.swing.JButton();
        jKurangLumpiangUdang = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        menu9 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        BeliPangsitGoreng = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jTextJumlahPangsitGoreng = new javax.swing.JTextField();
        jTambahPangsitGoreng = new javax.swing.JButton();
        jKurangPangsitGoreng = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        menu10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        BeliEsGenderuwo = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jTextJumlahEsGenderuwo = new javax.swing.JTextField();
        jTambahEsGenderuwo = new javax.swing.JButton();
        jKurangEsGenderuwo = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        menu11 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        BeliEsTuyul = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jTextJumlahEsTuyul = new javax.swing.JTextField();
        jTambahEsTuyul = new javax.swing.JButton();
        jKurangEsTuyul = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        menu12 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        BeliEsSundelBolong = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jTextJumlahEsSundelBolong = new javax.swing.JTextField();
        jTambahEsSundelBolong = new javax.swing.JButton();
        jKurangEsSundelBolong = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        menu13 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        BeliEsPocong = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jTextJumlahEsPocong = new javax.swing.JTextField();
        jTambahEsPocong = new javax.swing.JButton();
        jKurangEsPocong = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        menu14 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        BeliEsTeh = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jTextJumlahEsTeh = new javax.swing.JTextField();
        jTambahEsTeh = new javax.swing.JButton();
        jKurangEsTeh = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        menu15 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        BeliEsOrange = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jTextJumlahEsOrange = new javax.swing.JTextField();
        jTambahEsOrange = new javax.swing.JButton();
        jKurangEsOrange = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        menu16 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        BeliLemonTea = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jTextJumlahLemonTea = new javax.swing.JTextField();
        jTambahLemonTea = new javax.swing.JButton();
        jKurangLemonTea = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        menu17 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        BeliTehTarik = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jTextJumlahTehTarik = new javax.swing.JTextField();
        jTambahTehTarik = new javax.swing.JButton();
        jKurangTehTarik = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        menu18 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        BeliMilo = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jTextJumlahMilo = new javax.swing.JTextField();
        jTambahMilo = new javax.swing.JButton();
        jKurangMilo = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        menu19 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        BeliVanilaLate = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jTextJumlahVanilaLatte = new javax.swing.JTextField();
        jTambahVanilaLatte = new javax.swing.JButton();
        jKurangVanilaLatte = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        menu20 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        BeliAirMineral = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jTextJumlahAirMineral = new javax.swing.JTextField();
        jTambahAirMineral = new javax.swing.JButton();
        jKurangAirMineral = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPaneTabel = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Total = new javax.swing.JLabel();
        jTextTotal = new javax.swing.JTextField();
        jCancelMenu = new javax.swing.JButton();
        jCheckBoxMenu = new javax.swing.JCheckBox();
        Pesan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNomorMeja = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxKeterangan = new javax.swing.JComboBox<>();
        jButtonOke = new javax.swing.JButton();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMenu.setBackground(new java.awt.Color(18, 23, 89));

        jLabel2.setFont(new java.awt.Font("Bulletto Killa¬", 0, 55)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(245, 219, 35));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menu");

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        menu1.setBackground(new java.awt.Color(18, 23, 89));

        jLabel1.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mie Angel");

        BeliMieAngel.setBackground(new java.awt.Color(0, 170, 19));
        BeliMieAngel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliMieAngel.setText("Beli");
        BeliMieAngel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliMieAngelActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/01.jpg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTambahMieAngel.setText("+");
        jTambahMieAngel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahMieAngelActionPerformed(evt);
            }
        });

        jKurangMieAngel.setText("-");
        jKurangMieAngel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangMieAngelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah");

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahMieAngel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahMieAngel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangMieAngel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(menu1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(BeliMieAngel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1Layout.createSequentialGroup()
                        .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahMieAngel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahMieAngel)
                            .addComponent(jKurangMieAngel)
                            .addComponent(jLabel4))
                        .addGap(60, 60, 60)
                        .addComponent(BeliMieAngel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGap(23, 23, 23))
        );

        menu2.setBackground(new java.awt.Color(18, 23, 89));

        jLabel5.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mie Setan");

        BeliMieSetan.setBackground(new java.awt.Color(0, 170, 19));
        BeliMieSetan.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliMieSetan.setText("Beli");
        BeliMieSetan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliMieSetanActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 51));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/02.jpg"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBoxMieSetan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1", "Level 2", "Level 3", "Level 4", "Level 6", "Level 7", "Level 8", " " }));
        jComboBoxMieSetan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMieSetanActionPerformed(evt);
            }
        });

        jTambahMieSetan.setText("+");
        jTambahMieSetan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahMieSetanActionPerformed(evt);
            }
        });

        jKurangMieSetan.setText("-");
        jKurangMieSetan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangMieSetanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Level");

        jLabel13.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Jumlah");

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMieSetan, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(menu2Layout.createSequentialGroup()
                                .addComponent(jTextJumlahMieSetan, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTambahMieSetan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangMieSetan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(menu2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(BeliMieSetan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu2Layout.createSequentialGroup()
                        .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxMieSetan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahMieSetan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahMieSetan)
                            .addComponent(jKurangMieSetan)
                            .addComponent(jLabel13))
                        .addGap(59, 59, 59)
                        .addComponent(BeliMieSetan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGap(23, 23, 23))
        );

        menu3.setBackground(new java.awt.Color(18, 23, 89));

        jLabel14.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Mie Iblis");

        BeliMieIblis.setBackground(new java.awt.Color(0, 170, 19));
        BeliMieIblis.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliMieIblis.setText("Beli");
        BeliMieIblis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliMieIblisActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 51));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/03.jpg"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBoxMieIblis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 0", "Level 1", "Level 2", "Level 3", "Level 4", "Level 6", "Level 7", "Level 8", " " }));
        jComboBoxMieIblis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMieIblisActionPerformed(evt);
            }
        });

        jTambahMieIblis.setText("+");
        jTambahMieIblis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahMieIblisActionPerformed(evt);
            }
        });

        jKurangMieIblis.setText("-");
        jKurangMieIblis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangMieIblisActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Level");

        jLabel16.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Jumlah");

        javax.swing.GroupLayout menu3Layout = new javax.swing.GroupLayout(menu3);
        menu3.setLayout(menu3Layout);
        menu3Layout.setHorizontalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMieIblis, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(menu3Layout.createSequentialGroup()
                                .addComponent(jTextJumlahMieIblis, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTambahMieIblis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangMieIblis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(menu3Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(BeliMieIblis, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu3Layout.setVerticalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu3Layout.createSequentialGroup()
                        .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxMieIblis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahMieIblis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahMieIblis)
                            .addComponent(jKurangMieIblis)
                            .addComponent(jLabel16))
                        .addGap(55, 55, 55)
                        .addComponent(BeliMieIblis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGap(23, 23, 23))
        );

        menu4.setBackground(new java.awt.Color(18, 23, 89));

        jLabel17.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Siomay");

        BeliSiomay.setBackground(new java.awt.Color(0, 170, 19));
        BeliSiomay.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliSiomay.setText("Beli");
        BeliSiomay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliSiomayActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(255, 255, 51));
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/04.jpg"))); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jTambahSiomay.setText("+");
        jTambahSiomay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahSiomayActionPerformed(evt);
            }
        });

        jKurangSiomay.setText("-");
        jKurangSiomay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangSiomayActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Jumlah");

        javax.swing.GroupLayout menu4Layout = new javax.swing.GroupLayout(menu4);
        menu4.setLayout(menu4Layout);
        menu4Layout.setHorizontalGroup(
            menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahSiomay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahSiomay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangSiomay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(menu4Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(BeliSiomay, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu4Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu4Layout.setVerticalGroup(
            menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu4Layout.createSequentialGroup()
                        .addGroup(menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahSiomay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahSiomay)
                            .addComponent(jKurangSiomay)
                            .addComponent(jLabel19))
                        .addGap(58, 58, 58)
                        .addComponent(BeliSiomay, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGap(23, 23, 23))
        );

        menu5.setBackground(new java.awt.Color(18, 23, 89));

        jLabel20.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Ceker");

        BeliCeker.setBackground(new java.awt.Color(0, 170, 19));
        BeliCeker.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliCeker.setText("Beli");
        BeliCeker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliCekerActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(255, 255, 51));
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/05.jpg"))); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jTambahCeker.setText("+");
        jTambahCeker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahCekerActionPerformed(evt);
            }
        });

        jKurangCeker.setText("-");
        jKurangCeker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangCekerActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Jumlah");

        javax.swing.GroupLayout menu5Layout = new javax.swing.GroupLayout(menu5);
        menu5.setLayout(menu5Layout);
        menu5Layout.setHorizontalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahCeker)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahCeker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangCeker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(menu5Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(BeliCeker, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(221, Short.MAX_VALUE))))
            .addGroup(menu5Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu5Layout.setVerticalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu5Layout.createSequentialGroup()
                        .addGroup(menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahCeker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahCeker)
                            .addComponent(jKurangCeker)
                            .addComponent(jLabel22))
                        .addGap(62, 62, 62)
                        .addComponent(BeliCeker, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGap(23, 23, 23))
        );

        menu6.setBackground(new java.awt.Color(18, 23, 89));

        jLabel23.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Udang Rambutan");

        BeliUdangRambutan.setBackground(new java.awt.Color(0, 170, 19));
        BeliUdangRambutan.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliUdangRambutan.setText("Beli");
        BeliUdangRambutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliUdangRambutanActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(255, 255, 51));
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/06.jpg"))); // NOI18N
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jTambahUdangRambutan.setText("+");
        jTambahUdangRambutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahUdangRambutanActionPerformed(evt);
            }
        });

        jKurangUdangRambutan.setText("-");
        jKurangUdangRambutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangUdangRambutanActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Jumlah");

        javax.swing.GroupLayout menu6Layout = new javax.swing.GroupLayout(menu6);
        menu6.setLayout(menu6Layout);
        menu6Layout.setHorizontalGroup(
            menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu6Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(menu6Layout.createSequentialGroup()
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menu6Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jTextJumlahUdangRambutan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTambahUdangRambutan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jKurangUdangRambutan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addGroup(menu6Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(BeliUdangRambutan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        menu6Layout.setVerticalGroup(
            menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu6Layout.createSequentialGroup()
                        .addGroup(menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahUdangRambutan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahUdangRambutan)
                            .addComponent(jKurangUdangRambutan)
                            .addComponent(jLabel25))
                        .addGap(58, 58, 58)
                        .addComponent(BeliUdangRambutan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGap(23, 23, 23))
        );

        menu7.setBackground(new java.awt.Color(18, 23, 89));

        jLabel26.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Udang Keju");

        BeliUdangkeju.setBackground(new java.awt.Color(0, 170, 19));
        BeliUdangkeju.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliUdangkeju.setText("Beli");
        BeliUdangkeju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliUdangkejuActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(255, 255, 51));
        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/07.jpg"))); // NOI18N
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jTambahUdangkeju.setText("+");
        jTambahUdangkeju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahUdangkejuActionPerformed(evt);
            }
        });

        jKurangUdangKeju.setText("-");
        jKurangUdangKeju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangUdangKejuActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Jumlah");

        javax.swing.GroupLayout menu7Layout = new javax.swing.GroupLayout(menu7);
        menu7.setLayout(menu7Layout);
        menu7Layout.setHorizontalGroup(
            menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahUdangKeju)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahUdangkeju, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangUdangKeju, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(menu7Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(BeliUdangkeju, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel26)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu7Layout.setVerticalGroup(
            menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu7Layout.createSequentialGroup()
                        .addGroup(menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahUdangKeju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahUdangkeju)
                            .addComponent(jKurangUdangKeju)
                            .addComponent(jLabel28))
                        .addGap(66, 66, 66)
                        .addComponent(BeliUdangkeju, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGap(23, 23, 23))
        );

        menu8.setBackground(new java.awt.Color(18, 23, 89));

        jLabel29.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Lumpiang Udang");

        BeliLumpiangUdang.setBackground(new java.awt.Color(0, 170, 19));
        BeliLumpiangUdang.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliLumpiangUdang.setText("Beli");
        BeliLumpiangUdang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliLumpiangUdangActionPerformed(evt);
            }
        });

        jButton38.setBackground(new java.awt.Color(255, 255, 51));
        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/08.jpg"))); // NOI18N
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jTambahLumpiangUdang.setText("+");
        jTambahLumpiangUdang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahLumpiangUdangActionPerformed(evt);
            }
        });

        jKurangLumpiangUdang.setText("-");
        jKurangLumpiangUdang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangLumpiangUdangActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Jumlah");

        javax.swing.GroupLayout menu8Layout = new javax.swing.GroupLayout(menu8);
        menu8.setLayout(menu8Layout);
        menu8Layout.setHorizontalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu8Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahLumpiangUdang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahLumpiangUdang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangLumpiangUdang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(menu8Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(BeliLumpiangUdang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        menu8Layout.setVerticalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu8Layout.createSequentialGroup()
                        .addGroup(menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahLumpiangUdang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahLumpiangUdang)
                            .addComponent(jKurangLumpiangUdang)
                            .addComponent(jLabel31))
                        .addGap(58, 58, 58)
                        .addComponent(BeliLumpiangUdang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(23, 23, 23))
        );

        menu9.setBackground(new java.awt.Color(18, 23, 89));

        jLabel32.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Pangsit Goreng");

        BeliPangsitGoreng.setBackground(new java.awt.Color(0, 170, 19));
        BeliPangsitGoreng.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliPangsitGoreng.setText("Beli");
        BeliPangsitGoreng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliPangsitGorengActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(255, 255, 51));
        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/09.jpg"))); // NOI18N
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jTambahPangsitGoreng.setText("+");
        jTambahPangsitGoreng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahPangsitGorengActionPerformed(evt);
            }
        });

        jKurangPangsitGoreng.setText("-");
        jKurangPangsitGoreng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangPangsitGorengActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Jumlah");

        javax.swing.GroupLayout menu9Layout = new javax.swing.GroupLayout(menu9);
        menu9.setLayout(menu9Layout);
        menu9Layout.setHorizontalGroup(
            menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahPangsitGoreng)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahPangsitGoreng, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangPangsitGoreng, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu9Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(BeliPangsitGoreng, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel32)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu9Layout.setVerticalGroup(
            menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu9Layout.createSequentialGroup()
                        .addGroup(menu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahPangsitGoreng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahPangsitGoreng)
                            .addComponent(jKurangPangsitGoreng)
                            .addComponent(jLabel34))
                        .addGap(58, 58, 58)
                        .addComponent(BeliPangsitGoreng, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(23, 23, 23))
        );

        menu10.setBackground(new java.awt.Color(18, 23, 89));

        jLabel35.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Es Genderuwo");

        BeliEsGenderuwo.setBackground(new java.awt.Color(0, 170, 19));
        BeliEsGenderuwo.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliEsGenderuwo.setText("Beli");
        BeliEsGenderuwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliEsGenderuwoActionPerformed(evt);
            }
        });

        jButton46.setBackground(new java.awt.Color(255, 255, 51));
        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/10.jpg"))); // NOI18N
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jTambahEsGenderuwo.setText("+");
        jTambahEsGenderuwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahEsGenderuwoActionPerformed(evt);
            }
        });

        jKurangEsGenderuwo.setText("-");
        jKurangEsGenderuwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangEsGenderuwoActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Jumlah");

        javax.swing.GroupLayout menu10Layout = new javax.swing.GroupLayout(menu10);
        menu10.setLayout(menu10Layout);
        menu10Layout.setHorizontalGroup(
            menu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahEsGenderuwo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahEsGenderuwo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangEsGenderuwo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(menu10Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(BeliEsGenderuwo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu10Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel35)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu10Layout.setVerticalGroup(
            menu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu10Layout.createSequentialGroup()
                        .addGroup(menu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahEsGenderuwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahEsGenderuwo)
                            .addComponent(jKurangEsGenderuwo)
                            .addComponent(jLabel37))
                        .addGap(57, 57, 57)
                        .addComponent(BeliEsGenderuwo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu11.setBackground(new java.awt.Color(18, 23, 89));

        jLabel38.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Es Tuyul");

        BeliEsTuyul.setBackground(new java.awt.Color(0, 170, 19));
        BeliEsTuyul.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliEsTuyul.setText("Beli");
        BeliEsTuyul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliEsTuyulActionPerformed(evt);
            }
        });

        jButton50.setBackground(new java.awt.Color(255, 255, 51));
        jButton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/11.jpg"))); // NOI18N
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jTambahEsTuyul.setText("+");
        jTambahEsTuyul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahEsTuyulActionPerformed(evt);
            }
        });

        jKurangEsTuyul.setText("-");
        jKurangEsTuyul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangEsTuyulActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Jumlah");

        javax.swing.GroupLayout menu11Layout = new javax.swing.GroupLayout(menu11);
        menu11.setLayout(menu11Layout);
        menu11Layout.setHorizontalGroup(
            menu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu11Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel38)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(menu11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(menu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu11Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahEsTuyul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahEsTuyul, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangEsTuyul, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu11Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(BeliEsTuyul, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        menu11Layout.setVerticalGroup(
            menu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGroup(menu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu11Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(menu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahEsTuyul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahEsTuyul)
                            .addComponent(jKurangEsTuyul)
                            .addComponent(jLabel40))
                        .addGap(67, 67, 67)
                        .addComponent(BeliEsTuyul, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menu11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );

        menu12.setBackground(new java.awt.Color(18, 23, 89));

        jLabel39.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Es Sundel Bolong");

        BeliEsSundelBolong.setBackground(new java.awt.Color(0, 170, 19));
        BeliEsSundelBolong.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliEsSundelBolong.setText("Beli");
        BeliEsSundelBolong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliEsSundelBolongActionPerformed(evt);
            }
        });

        jButton51.setBackground(new java.awt.Color(255, 255, 51));
        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/12.jpg"))); // NOI18N
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jTambahEsSundelBolong.setText("+");
        jTambahEsSundelBolong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahEsSundelBolongActionPerformed(evt);
            }
        });

        jKurangEsSundelBolong.setText("-");
        jKurangEsSundelBolong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangEsSundelBolongActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Jumlah");

        javax.swing.GroupLayout menu12Layout = new javax.swing.GroupLayout(menu12);
        menu12.setLayout(menu12Layout);
        menu12Layout.setHorizontalGroup(
            menu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(menu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu12Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahEsSundelBolong, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahEsSundelBolong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangEsSundelBolong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu12Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliEsSundelBolong, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        menu12Layout.setVerticalGroup(
            menu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu12Layout.createSequentialGroup()
                        .addGroup(menu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahEsSundelBolong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahEsSundelBolong)
                            .addComponent(jKurangEsSundelBolong)
                            .addComponent(jLabel41))
                        .addGap(67, 67, 67)
                        .addComponent(BeliEsSundelBolong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu13.setBackground(new java.awt.Color(18, 23, 89));

        jLabel42.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Es Pocong");

        BeliEsPocong.setBackground(new java.awt.Color(0, 170, 19));
        BeliEsPocong.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliEsPocong.setText("Beli");
        BeliEsPocong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliEsPocongActionPerformed(evt);
            }
        });

        jButton52.setBackground(new java.awt.Color(255, 255, 51));
        jButton52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/13.jpg"))); // NOI18N
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jTambahEsPocong.setText("+");
        jTambahEsPocong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahEsPocongActionPerformed(evt);
            }
        });

        jKurangEsPocong.setText("-");
        jKurangEsPocong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangEsPocongActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Jumlah");

        javax.swing.GroupLayout menu13Layout = new javax.swing.GroupLayout(menu13);
        menu13.setLayout(menu13Layout);
        menu13Layout.setHorizontalGroup(
            menu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu13Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahEsPocong, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahEsPocong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangEsPocong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu13Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliEsPocong, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu13Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel42)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu13Layout.setVerticalGroup(
            menu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu13Layout.createSequentialGroup()
                        .addGroup(menu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahEsPocong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahEsPocong)
                            .addComponent(jKurangEsPocong)
                            .addComponent(jLabel43))
                        .addGap(67, 67, 67)
                        .addComponent(BeliEsPocong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu14.setBackground(new java.awt.Color(18, 23, 89));

        jLabel44.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Es Teh");

        BeliEsTeh.setBackground(new java.awt.Color(0, 170, 19));
        BeliEsTeh.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliEsTeh.setText("Beli");
        BeliEsTeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliEsTehActionPerformed(evt);
            }
        });

        jButton53.setBackground(new java.awt.Color(255, 255, 51));
        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/14.jpg"))); // NOI18N
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jTambahEsTeh.setText("+");
        jTambahEsTeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahEsTehActionPerformed(evt);
            }
        });

        jKurangEsTeh.setText("-");
        jKurangEsTeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangEsTehActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Jumlah");

        javax.swing.GroupLayout menu14Layout = new javax.swing.GroupLayout(menu14);
        menu14.setLayout(menu14Layout);
        menu14Layout.setHorizontalGroup(
            menu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu14Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahEsTeh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahEsTeh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangEsTeh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu14Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliEsTeh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu14Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel44)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu14Layout.setVerticalGroup(
            menu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu14Layout.createSequentialGroup()
                        .addGroup(menu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahEsTeh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahEsTeh)
                            .addComponent(jKurangEsTeh)
                            .addComponent(jLabel45))
                        .addGap(67, 67, 67)
                        .addComponent(BeliEsTeh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu15.setBackground(new java.awt.Color(18, 23, 89));

        jLabel46.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("\t Es Orange");

        BeliEsOrange.setBackground(new java.awt.Color(0, 170, 19));
        BeliEsOrange.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliEsOrange.setText("Beli");
        BeliEsOrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliEsOrangeActionPerformed(evt);
            }
        });

        jButton54.setBackground(new java.awt.Color(255, 255, 51));
        jButton54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/15.jpg"))); // NOI18N
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jTambahEsOrange.setText("+");
        jTambahEsOrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahEsOrangeActionPerformed(evt);
            }
        });

        jKurangEsOrange.setText("-");
        jKurangEsOrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangEsOrangeActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Jumlah");

        javax.swing.GroupLayout menu15Layout = new javax.swing.GroupLayout(menu15);
        menu15.setLayout(menu15Layout);
        menu15Layout.setHorizontalGroup(
            menu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu15Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel47)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahEsOrange, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahEsOrange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangEsOrange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu15Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliEsOrange, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu15Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel46)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu15Layout.setVerticalGroup(
            menu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu15Layout.createSequentialGroup()
                        .addGroup(menu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahEsOrange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahEsOrange)
                            .addComponent(jKurangEsOrange)
                            .addComponent(jLabel47))
                        .addGap(67, 67, 67)
                        .addComponent(BeliEsOrange, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu16.setBackground(new java.awt.Color(18, 23, 89));

        jLabel48.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("\t Lemon Tea");

        BeliLemonTea.setBackground(new java.awt.Color(0, 170, 19));
        BeliLemonTea.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliLemonTea.setText("Beli");
        BeliLemonTea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliLemonTeaActionPerformed(evt);
            }
        });

        jButton55.setBackground(new java.awt.Color(255, 255, 51));
        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/16.jpg"))); // NOI18N
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jTambahLemonTea.setText("+");
        jTambahLemonTea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahLemonTeaActionPerformed(evt);
            }
        });

        jKurangLemonTea.setText("-");
        jKurangLemonTea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangLemonTeaActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Jumlah");

        javax.swing.GroupLayout menu16Layout = new javax.swing.GroupLayout(menu16);
        menu16.setLayout(menu16Layout);
        menu16Layout.setHorizontalGroup(
            menu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu16Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahLemonTea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahLemonTea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangLemonTea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu16Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliLemonTea, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu16Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel48)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu16Layout.setVerticalGroup(
            menu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu16Layout.createSequentialGroup()
                        .addGroup(menu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahLemonTea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahLemonTea)
                            .addComponent(jKurangLemonTea)
                            .addComponent(jLabel49))
                        .addGap(67, 67, 67)
                        .addComponent(BeliLemonTea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu17.setBackground(new java.awt.Color(18, 23, 89));

        jLabel54.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Teh Tarik");

        BeliTehTarik.setBackground(new java.awt.Color(0, 170, 19));
        BeliTehTarik.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliTehTarik.setText("Beli");
        BeliTehTarik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliTehTarikActionPerformed(evt);
            }
        });

        jButton58.setBackground(new java.awt.Color(255, 255, 51));
        jButton58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/17.jpg"))); // NOI18N
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jTambahTehTarik.setText("+");
        jTambahTehTarik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahTehTarikActionPerformed(evt);
            }
        });

        jKurangTehTarik.setText("-");
        jKurangTehTarik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangTehTarikActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Jumlah");

        javax.swing.GroupLayout menu17Layout = new javax.swing.GroupLayout(menu17);
        menu17.setLayout(menu17Layout);
        menu17Layout.setHorizontalGroup(
            menu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu17Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu17Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel55)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahTehTarik, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahTehTarik, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangTehTarik, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu17Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliTehTarik, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu17Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel54)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu17Layout.setVerticalGroup(
            menu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu17Layout.createSequentialGroup()
                        .addGroup(menu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahTehTarik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahTehTarik)
                            .addComponent(jKurangTehTarik)
                            .addComponent(jLabel55))
                        .addGap(67, 67, 67)
                        .addComponent(BeliTehTarik, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu18.setBackground(new java.awt.Color(18, 23, 89));

        jLabel56.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Milo");

        BeliMilo.setBackground(new java.awt.Color(0, 170, 19));
        BeliMilo.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliMilo.setText("Beli");
        BeliMilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliMiloActionPerformed(evt);
            }
        });

        jButton59.setBackground(new java.awt.Color(255, 255, 51));
        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/18.jpg"))); // NOI18N
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jTambahMilo.setText("+");
        jTambahMilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahMiloActionPerformed(evt);
            }
        });

        jKurangMilo.setText("-");
        jKurangMilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangMiloActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Jumlah");

        javax.swing.GroupLayout menu18Layout = new javax.swing.GroupLayout(menu18);
        menu18.setLayout(menu18Layout);
        menu18Layout.setHorizontalGroup(
            menu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu18Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu18Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel57)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahMilo, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahMilo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangMilo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu18Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliMilo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu18Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel56)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu18Layout.setVerticalGroup(
            menu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu18Layout.createSequentialGroup()
                        .addGroup(menu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahMilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahMilo)
                            .addComponent(jKurangMilo)
                            .addComponent(jLabel57))
                        .addGap(67, 67, 67)
                        .addComponent(BeliMilo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu19.setBackground(new java.awt.Color(18, 23, 89));

        jLabel58.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Vanila Latte");

        BeliVanilaLate.setBackground(new java.awt.Color(0, 170, 19));
        BeliVanilaLate.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliVanilaLate.setText("Beli");
        BeliVanilaLate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliVanilaLateActionPerformed(evt);
            }
        });

        jButton60.setBackground(new java.awt.Color(255, 255, 51));
        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/19.jpg"))); // NOI18N
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jTambahVanilaLatte.setText("+");
        jTambahVanilaLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahVanilaLatteActionPerformed(evt);
            }
        });

        jKurangVanilaLatte.setText("-");
        jKurangVanilaLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangVanilaLatteActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Jumlah");

        javax.swing.GroupLayout menu19Layout = new javax.swing.GroupLayout(menu19);
        menu19.setLayout(menu19Layout);
        menu19Layout.setHorizontalGroup(
            menu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu19Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu19Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel59)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahVanilaLatte, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahVanilaLatte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangVanilaLatte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu19Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliVanilaLate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu19Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel58)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu19Layout.setVerticalGroup(
            menu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu19Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu19Layout.createSequentialGroup()
                        .addGroup(menu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahVanilaLatte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahVanilaLatte)
                            .addComponent(jKurangVanilaLatte)
                            .addComponent(jLabel59))
                        .addGap(67, 67, 67)
                        .addComponent(BeliVanilaLate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        menu20.setBackground(new java.awt.Color(18, 23, 89));

        jLabel60.setFont(new java.awt.Font("Bulletto Killa¬", 0, 30)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Air Mineral");

        BeliAirMineral.setBackground(new java.awt.Color(0, 170, 19));
        BeliAirMineral.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        BeliAirMineral.setText("Beli");
        BeliAirMineral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliAirMineralActionPerformed(evt);
            }
        });

        jButton61.setBackground(new java.awt.Color(255, 255, 51));
        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/20.jpg"))); // NOI18N
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jTambahAirMineral.setText("+");
        jTambahAirMineral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTambahAirMineralActionPerformed(evt);
            }
        });

        jKurangAirMineral.setText("-");
        jKurangAirMineral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKurangAirMineralActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Jumlah");

        javax.swing.GroupLayout menu20Layout = new javax.swing.GroupLayout(menu20);
        menu20.setLayout(menu20Layout);
        menu20Layout.setHorizontalGroup(
            menu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu20Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menu20Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel61)
                        .addGap(18, 18, 18)
                        .addComponent(jTextJumlahAirMineral, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTambahAirMineral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKurangAirMineral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(menu20Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(BeliAirMineral, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(menu20Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel60)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu20Layout.setVerticalGroup(
            menu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu20Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu20Layout.createSequentialGroup()
                        .addGroup(menu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextJumlahAirMineral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTambahAirMineral)
                            .addComponent(jKurangAirMineral)
                            .addComponent(jLabel61))
                        .addGap(67, 67, 67)
                        .addComponent(BeliAirMineral, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(menu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel3.setBackground(new java.awt.Color(18, 23, 89));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Bulletto Killa¬", 0, 35)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(245, 219, 35));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PEMBAYARAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(18, 23, 89));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Menu", "Nama Menu", "Harga", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPaneTabel.setViewportView(jTable1);

        Total.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        Total.setForeground(new java.awt.Color(255, 255, 255));
        Total.setText("Total :");

        jTextTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTotalActionPerformed(evt);
            }
        });

        jCancelMenu.setBackground(new java.awt.Color(204, 0, 0));
        jCancelMenu.setForeground(new java.awt.Color(255, 255, 255));
        jCancelMenu.setText("Cancel");
        jCancelMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelMenuActionPerformed(evt);
            }
        });

        jCheckBoxMenu.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxMenu.setText("Tandai Bila Pesanan anda sudah Benar");
        jCheckBoxMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuActionPerformed(evt);
            }
        });

        Pesan.setBackground(new java.awt.Color(0, 170, 19));
        Pesan.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        Pesan.setText("Pesan");
        Pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabel, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jCheckBoxMenu)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(Total)
                        .addGap(18, 18, 18)
                        .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCancelMenu)
                        .addGap(56, 56, 56))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCancelMenu))
                .addGap(39, 39, 39)
                .addComponent(jCheckBoxMenu)
                .addGap(51, 51, 51)
                .addComponent(Pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(18, 23, 89));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/LogoMieGacoan 1.png"))); // NOI18N

        jTextNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNamaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");

        jLabel8.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nomor Meja");

        jComboBoxKeterangan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBoxKeterangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dine In", "Take Away" }));
        jComboBoxKeterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKeteranganActionPerformed(evt);
            }
        });

        jButtonOke.setText("Oke");
        jButtonOke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNomorMeja, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel9)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOke)
                .addGap(197, 197, 197))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNomorMeja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jComboBoxKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButtonOke)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BeliMieAngelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliMieAngelActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '01';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahMieAngel.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "01";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"','"+ kode_menu +"','" + harga +"','" + jTextJumlahMieAngel.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_BeliMieAngelActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTambahMieAngelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahMieAngelActionPerformed
        if (jTextJumlahMieAngel.getText().equals("")){
            jTextJumlahMieAngel.setText("1");
        }else{
            jTextJumlahMieAngel.setText(String.valueOf(Integer.valueOf(jTextJumlahMieAngel.getText())+1));
        }
    }//GEN-LAST:event_jTambahMieAngelActionPerformed

    private void jKurangMieAngelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangMieAngelActionPerformed
        if (jTextJumlahMieAngel.getText().equals("")){
            jTextJumlahMieAngel.setText("0");
        }else if(Integer.valueOf(jTextJumlahMieAngel.getText())>0){
            jTextJumlahMieAngel.setText(String.valueOf(Integer.valueOf(jTextJumlahMieAngel.getText())-1));
        }else{
            jTextJumlahMieAngel.setText("0");
        }
    }//GEN-LAST:event_jKurangMieAngelActionPerformed

    private void BeliMieSetanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliMieSetanActionPerformed
        try{
            LevelMieSetan();
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '"+kode_menu+"';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahMieSetan.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahMieSetan.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BeliMieSetanActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBoxMieSetanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMieSetanActionPerformed
        
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMieSetanActionPerformed

    private void jTambahMieSetanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahMieSetanActionPerformed
        if (jTextJumlahMieSetan.getText().equals("")){
            jTextJumlahMieSetan.setText("1");
        }else{
            jTextJumlahMieSetan.setText(String.valueOf(Integer.valueOf(jTextJumlahMieSetan.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahMieSetanActionPerformed

    private void jKurangMieSetanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangMieSetanActionPerformed
        if (jTextJumlahMieSetan.getText().equals("")){
            jTextJumlahMieSetan.setText("0");
        }else if(Integer.valueOf(jTextJumlahMieSetan.getText())>0){
            jTextJumlahMieSetan.setText(String.valueOf(Integer.valueOf(jTextJumlahMieSetan.getText())-1));
        }else{
            jTextJumlahMieSetan.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangMieSetanActionPerformed

    private void BeliMieIblisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliMieIblisActionPerformed
        try{
            LevelMieIblis();
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '"+kode_menu+"';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahMieIblis.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahMieIblis.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliMieIblisActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTambahMieIblisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahMieIblisActionPerformed
        if (jTextJumlahMieIblis.getText().equals("")){
            jTextJumlahMieIblis.setText("1");
        }else{
            jTextJumlahMieIblis.setText(String.valueOf(Integer.valueOf(jTextJumlahMieIblis.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahMieIblisActionPerformed

    private void jKurangMieIblisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangMieIblisActionPerformed
        if (jTextJumlahMieIblis.getText().equals("")){
            jTextJumlahMieIblis.setText("0");
        }else if(Integer.valueOf(jTextJumlahMieIblis.getText())>0){
            jTextJumlahMieIblis.setText(String.valueOf(Integer.valueOf(jTextJumlahMieIblis.getText())-1));
        }else{
            jTextJumlahMieIblis.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangMieIblisActionPerformed

    private void BeliSiomayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliSiomayActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '17';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahSiomay.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "17";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahSiomay.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BeliSiomayActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jTambahSiomayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahSiomayActionPerformed
        if (jTextJumlahSiomay.getText().equals("")){
            jTextJumlahSiomay.setText("1");
        }else{
            jTextJumlahSiomay.setText(String.valueOf(Integer.valueOf(jTextJumlahSiomay.getText())+1));
        }
    }//GEN-LAST:event_jTambahSiomayActionPerformed

    private void jKurangSiomayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangSiomayActionPerformed
        if (jTextJumlahSiomay.getText().equals("")){
            jTextJumlahSiomay.setText("0");
        }else if(Integer.valueOf(jTextJumlahSiomay.getText())>0){
            jTextJumlahSiomay.setText(String.valueOf(Integer.valueOf(jTextJumlahSiomay.getText())-1));
        }else{
            jTextJumlahSiomay.setText("0");
        }
    }//GEN-LAST:event_jKurangSiomayActionPerformed

    private void BeliCekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliCekerActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '18';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahCeker.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "18";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahCeker.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BeliCekerActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jTambahCekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahCekerActionPerformed
        if (jTextJumlahCeker.getText().equals("")){
            jTextJumlahCeker.setText("1");
        }else{
            jTextJumlahCeker.setText(String.valueOf(Integer.valueOf(jTextJumlahCeker.getText())+1));
        }
    }//GEN-LAST:event_jTambahCekerActionPerformed

    private void jKurangCekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangCekerActionPerformed
        if (jTextJumlahCeker.getText().equals("")){
            jTextJumlahCeker.setText("0");
        }else if(Integer.valueOf(jTextJumlahCeker.getText())>0){
            jTextJumlahCeker.setText(String.valueOf(Integer.valueOf(jTextJumlahCeker.getText())-1));
        }else{
            jTextJumlahCeker.setText("0");
        }
    }//GEN-LAST:event_jKurangCekerActionPerformed

    private void BeliUdangRambutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliUdangRambutanActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '19';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahUdangRambutan.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "19";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahUdangRambutan.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BeliUdangRambutanActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jTambahUdangRambutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahUdangRambutanActionPerformed
        if (jTextJumlahUdangRambutan.getText().equals("")){
            jTextJumlahUdangRambutan.setText("1");
        }else{
            jTextJumlahUdangRambutan.setText(String.valueOf(Integer.valueOf(jTextJumlahUdangRambutan.getText())+1));
        }
    }//GEN-LAST:event_jTambahUdangRambutanActionPerformed

    private void jKurangUdangRambutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangUdangRambutanActionPerformed
        if (jTextJumlahUdangRambutan.getText().equals("")){
            jTextJumlahUdangRambutan.setText("0");
        }else if(Integer.valueOf(jTextJumlahUdangRambutan.getText())>0){
            jTextJumlahUdangRambutan.setText(String.valueOf(Integer.valueOf(jTextJumlahUdangRambutan.getText())-1));
        }else{
            jTextJumlahUdangRambutan.setText("0");
        }
    }//GEN-LAST:event_jKurangUdangRambutanActionPerformed

    private void BeliUdangkejuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliUdangkejuActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '20';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahUdangKeju.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "20";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahUdangKeju.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BeliUdangkejuActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jTambahUdangkejuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahUdangkejuActionPerformed
        if (jTextJumlahUdangKeju.getText().equals("")){
            jTextJumlahUdangKeju.setText("1");
        }else{
            jTextJumlahUdangKeju.setText(String.valueOf(Integer.valueOf(jTextJumlahUdangKeju.getText())+1));
        }
    }//GEN-LAST:event_jTambahUdangkejuActionPerformed

    private void jKurangUdangKejuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangUdangKejuActionPerformed
        if (jTextJumlahUdangKeju.getText().equals("")){
            jTextJumlahUdangKeju.setText("0");
        }else if(Integer.valueOf(jTextJumlahUdangKeju.getText())>0){
            jTextJumlahUdangKeju.setText(String.valueOf(Integer.valueOf(jTextJumlahUdangKeju.getText())-1));
        }else{
            jTextJumlahUdangKeju.setText("0");
        }
    }//GEN-LAST:event_jKurangUdangKejuActionPerformed

    private void BeliLumpiangUdangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliLumpiangUdangActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '21';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahLumpiangUdang.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "21";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahLumpiangUdang.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BeliLumpiangUdangActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jTambahLumpiangUdangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahLumpiangUdangActionPerformed
        if (jTextJumlahLumpiangUdang.getText().equals("")){
            jTextJumlahLumpiangUdang.setText("1");
        }else{
            jTextJumlahLumpiangUdang.setText(String.valueOf(Integer.valueOf(jTextJumlahLumpiangUdang.getText())+1));
        }
    }//GEN-LAST:event_jTambahLumpiangUdangActionPerformed

    private void jKurangLumpiangUdangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangLumpiangUdangActionPerformed
        if (jTextJumlahLumpiangUdang.getText().equals("")){
            jTextJumlahLumpiangUdang.setText("0");
        }else if(Integer.valueOf(jTextJumlahUdangKeju.getText())>0){
            jTextJumlahLumpiangUdang.setText(String.valueOf(Integer.valueOf(jTextJumlahLumpiangUdang.getText())-1));
        }else{
            jTextJumlahLumpiangUdang.setText("0");
        }
    }//GEN-LAST:event_jKurangLumpiangUdangActionPerformed

    private void BeliPangsitGorengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliPangsitGorengActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '22';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahPangsitGoreng.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "22";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahPangsitGoreng.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliPangsitGorengActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jTambahPangsitGorengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahPangsitGorengActionPerformed
        if (jTextJumlahPangsitGoreng.getText().equals("")){
            jTextJumlahPangsitGoreng.setText("1");
        }else{
            jTextJumlahPangsitGoreng.setText(String.valueOf(Integer.valueOf(jTextJumlahPangsitGoreng.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahPangsitGorengActionPerformed

    private void jKurangPangsitGorengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangPangsitGorengActionPerformed
        if (jTextJumlahPangsitGoreng.getText().equals("")){
            jTextJumlahPangsitGoreng.setText("0");
        }else if(Integer.valueOf(jTextJumlahPangsitGoreng.getText())>0){
            jTextJumlahPangsitGoreng.setText(String.valueOf(Integer.valueOf(jTextJumlahPangsitGoreng.getText())-1));
        }else{
            jTextJumlahPangsitGoreng.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangPangsitGorengActionPerformed
                                                                                                        
    private void BeliEsGenderuwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliEsGenderuwoActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '23';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahEsGenderuwo.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "23";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahEsGenderuwo.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliEsGenderuwoActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jTambahEsGenderuwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahEsGenderuwoActionPerformed
        if (jTextJumlahEsGenderuwo.getText().equals("")){
            jTextJumlahEsGenderuwo.setText("1");
        }else{
            jTextJumlahEsGenderuwo.setText(String.valueOf(Integer.valueOf(jTextJumlahEsGenderuwo.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahEsGenderuwoActionPerformed

    private void jKurangEsGenderuwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangEsGenderuwoActionPerformed
        if (jTextJumlahEsGenderuwo.getText().equals("")){
            jTextJumlahEsGenderuwo.setText("0");
        }else if(Integer.valueOf(jTextJumlahEsGenderuwo.getText())>0){
            jTextJumlahEsGenderuwo.setText(String.valueOf(Integer.valueOf(jTextJumlahEsGenderuwo.getText())-1));
        }else{
            jTextJumlahEsGenderuwo.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangEsGenderuwoActionPerformed

    private void BeliEsTuyulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliEsTuyulActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '24';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahEsTuyul.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "24";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahEsTuyul.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliEsTuyulActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jTambahEsTuyulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahEsTuyulActionPerformed
        if (jTextJumlahEsTuyul.getText().equals("")){
            jTextJumlahEsTuyul.setText("1");
        }else{
            jTextJumlahEsTuyul.setText(String.valueOf(Integer.valueOf(jTextJumlahEsTuyul.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahEsTuyulActionPerformed

    private void jKurangEsTuyulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangEsTuyulActionPerformed
        if (jTextJumlahEsTuyul.getText().equals("")){
            jTextJumlahEsTuyul.setText("0");
        }else if(Integer.valueOf(jTextJumlahEsTuyul.getText())>0){
            jTextJumlahEsTuyul.setText(String.valueOf(Integer.valueOf(jTextJumlahEsTuyul.getText())-1));
        }else{
            jTextJumlahEsTuyul.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangEsTuyulActionPerformed

    private void BeliEsSundelBolongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliEsSundelBolongActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '25';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahEsSundelBolong.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "25";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahEsSundelBolong.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliEsSundelBolongActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jTambahEsSundelBolongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahEsSundelBolongActionPerformed
        if (jTextJumlahEsSundelBolong.getText().equals("")){
            jTextJumlahEsSundelBolong.setText("1");
        }else{
            jTextJumlahEsSundelBolong.setText(String.valueOf(Integer.valueOf(jTextJumlahEsSundelBolong.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahEsSundelBolongActionPerformed

    private void jKurangEsSundelBolongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangEsSundelBolongActionPerformed
        if (jTextJumlahEsSundelBolong.getText().equals("")){
            jTextJumlahEsSundelBolong.setText("0");
        }else if(Integer.valueOf(jTextJumlahEsSundelBolong.getText())>0){
            jTextJumlahEsSundelBolong.setText(String.valueOf(Integer.valueOf(jTextJumlahEsSundelBolong.getText())-1));
        }else{
            jTextJumlahEsSundelBolong.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangEsSundelBolongActionPerformed

    private void BeliEsPocongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliEsPocongActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '26';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahEsPocong.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "26";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahEsPocong.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliEsPocongActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jTambahEsPocongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahEsPocongActionPerformed
        if (jTextJumlahEsPocong.getText().equals("")){
            jTextJumlahEsPocong.setText("1");
        }else{
            jTextJumlahEsPocong.setText(String.valueOf(Integer.valueOf(jTextJumlahEsPocong.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahEsPocongActionPerformed

    private void jKurangEsPocongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangEsPocongActionPerformed
        if (jTextJumlahEsPocong.getText().equals("")){
            jTextJumlahEsPocong.setText("0");
        }else if(Integer.valueOf(jTextJumlahEsPocong.getText())>0){
            jTextJumlahEsPocong.setText(String.valueOf(Integer.valueOf(jTextJumlahEsPocong.getText())-1));
        }else{
            jTextJumlahEsPocong.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangEsPocongActionPerformed

    private void BeliEsTehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliEsTehActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '27';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahEsTeh.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "27";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahEsTeh.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliEsTehActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jTambahEsTehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahEsTehActionPerformed
        if (jTextJumlahEsTeh.getText().equals("")){
            jTextJumlahEsTeh.setText("1");
        }else{
            jTextJumlahEsTeh.setText(String.valueOf(Integer.valueOf(jTextJumlahEsTeh.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahEsTehActionPerformed

    private void jKurangEsTehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangEsTehActionPerformed
        if (jTextJumlahEsTeh.getText().equals("")){
            jTextJumlahEsTeh.setText("0");
        }else if(Integer.valueOf(jTextJumlahEsTeh.getText())>0){
            jTextJumlahEsTeh.setText(String.valueOf(Integer.valueOf(jTextJumlahEsTeh.getText())-1));
        }else{
            jTextJumlahEsTeh.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangEsTehActionPerformed

    private void BeliEsOrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliEsOrangeActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '28';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahEsOrange.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "28";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahEsOrange.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliEsOrangeActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jTambahEsOrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahEsOrangeActionPerformed
        if (jTextJumlahEsOrange.getText().equals("")){
            jTextJumlahEsOrange.setText("1");
        }else{
            jTextJumlahEsOrange.setText(String.valueOf(Integer.valueOf(jTextJumlahEsOrange.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahEsOrangeActionPerformed

    private void jKurangEsOrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangEsOrangeActionPerformed
        if (jTextJumlahEsOrange.getText().equals("")){
            jTextJumlahEsOrange.setText("0");
        }else if(Integer.valueOf(jTextJumlahEsOrange.getText())>0){
            jTextJumlahEsOrange.setText(String.valueOf(Integer.valueOf(jTextJumlahEsOrange.getText())-1));
        }else{
            jTextJumlahEsOrange.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangEsOrangeActionPerformed

    private void BeliLemonTeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliLemonTeaActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '29';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahLemonTea.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "29";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahLemonTea.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliLemonTeaActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jTambahLemonTeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahLemonTeaActionPerformed
        if (jTextJumlahLemonTea.getText().equals("")){
            jTextJumlahLemonTea.setText("1");
        }else{
            jTextJumlahLemonTea.setText(String.valueOf(Integer.valueOf(jTextJumlahLemonTea.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahLemonTeaActionPerformed

    private void jKurangLemonTeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangLemonTeaActionPerformed
        if (jTextJumlahLemonTea.getText().equals("")){
            jTextJumlahLemonTea.setText("0");
        }else if(Integer.valueOf(jTextJumlahLemonTea.getText())>0){
            jTextJumlahLemonTea.setText(String.valueOf(Integer.valueOf(jTextJumlahLemonTea.getText())-1));
        }else{
            jTextJumlahLemonTea.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangLemonTeaActionPerformed

    private void BeliTehTarikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliTehTarikActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '30';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahTehTarik.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "30";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahTehTarik.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliTehTarikActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jTambahTehTarikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahTehTarikActionPerformed
        if (jTextJumlahTehTarik.getText().equals("")){
            jTextJumlahTehTarik.setText("1");
        }else{
            jTextJumlahTehTarik.setText(String.valueOf(Integer.valueOf(jTextJumlahTehTarik.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahTehTarikActionPerformed

    private void jKurangTehTarikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangTehTarikActionPerformed
        if (jTextJumlahTehTarik.getText().equals("")){
            jTextJumlahTehTarik.setText("0");
        }else if(Integer.valueOf(jTextJumlahTehTarik.getText())>0){
            jTextJumlahTehTarik.setText(String.valueOf(Integer.valueOf(jTextJumlahTehTarik.getText())-1));
        }else{
            jTextJumlahTehTarik.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangTehTarikActionPerformed

    private void BeliMiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliMiloActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '31';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahMilo.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "31";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahMilo.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliMiloActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jTambahMiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahMiloActionPerformed
        if (jTextJumlahMilo.getText().equals("")){
            jTextJumlahMilo.setText("1");
        }else{
            jTextJumlahMilo.setText(String.valueOf(Integer.valueOf(jTextJumlahMilo.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahMiloActionPerformed

    private void jKurangMiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangMiloActionPerformed
        if (jTextJumlahMilo.getText().equals("")){
            jTextJumlahMilo.setText("0");
        }else if(Integer.valueOf(jTextJumlahMilo.getText())>0){
            jTextJumlahMilo.setText(String.valueOf(Integer.valueOf(jTextJumlahMilo.getText())-1));
        }else{
            jTextJumlahMilo.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangMiloActionPerformed

    private void BeliVanilaLateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliVanilaLateActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '32';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahVanilaLatte.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "32";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahVanilaLatte.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliVanilaLateActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jTambahVanilaLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahVanilaLatteActionPerformed
        if (jTextJumlahVanilaLatte.getText().equals("")){
            jTextJumlahVanilaLatte.setText("1");
        }else{
            jTextJumlahVanilaLatte.setText(String.valueOf(Integer.valueOf(jTextJumlahVanilaLatte.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahVanilaLatteActionPerformed

    private void jKurangVanilaLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangVanilaLatteActionPerformed
        if (jTextJumlahVanilaLatte.getText().equals("")){
            jTextJumlahVanilaLatte.setText("0");
        }else if(Integer.valueOf(jTextJumlahVanilaLatte.getText())>0){
            jTextJumlahVanilaLatte.setText(String.valueOf(Integer.valueOf(jTextJumlahVanilaLatte.getText())-1));
        }else{
            jTextJumlahVanilaLatte.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangVanilaLatteActionPerformed

    private void BeliAirMineralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliAirMineralActionPerformed
        try{
            koneksi();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '33';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = jTextJumlahAirMineral.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            kode_menu = "33";
            dateTime();
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','"+tanggal_transaksi+"' ,'"+ kode_menu +"','" + harga +"','" + jTextJumlahAirMineral.getText() + "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_BeliAirMineralActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jTambahAirMineralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTambahAirMineralActionPerformed
        if (jTextJumlahAirMineral.getText().equals("")){
            jTextJumlahAirMineral.setText("1");
        }else{
            jTextJumlahAirMineral.setText(String.valueOf(Integer.valueOf(jTextJumlahAirMineral.getText())+1));
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTambahAirMineralActionPerformed

    private void jKurangAirMineralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKurangAirMineralActionPerformed
        if (jTextJumlahAirMineral.getText().equals("")){
            jTextJumlahAirMineral.setText("0");
        }else if(Integer.valueOf(jTextJumlahAirMineral.getText())>0){
            jTextJumlahAirMineral.setText(String.valueOf(Integer.valueOf(jTextJumlahAirMineral.getText())-1));
        }else{
            jTextJumlahAirMineral.setText("0");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jKurangAirMineralActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            koneksi();
            int row =jTable1.getSelectedRow();
            String tabel_klik=(jTable1.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT transaksi_temporary.kode_menu, menu.nama_menu, transaksi_temporary.harga, transaksi_temporary.qty FROM menu INNER JOIN transaksi_temporary ON menu.kode_menu = '"+tabel_klik+"'");
            if(sql.next()){
                kode_transaksi = sql.getString("kode_transaksi");
                kode_menu = sql.getString("kode_menu");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTotalActionPerformed

    private void jCancelMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelMenuActionPerformed
        try{
            koneksi();
            int row =jTable1.getSelectedRow();
            String tabel_klik=(jTable1.getModel().getValueAt(row, 0).toString());
            stat = con.createStatement();
            String SQL = "DELETE FROM transaksi_temporary WHERE kode_transaksi = '"+kode_transaksi+"' AND kode_menu = '"+tabel_klik+"'";
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            JOptionPane.showMessageDialog(null, "berhasil hapus");

        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jCancelMenuActionPerformed

    private void jTextNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNamaActionPerformed

    private void jComboBoxKeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKeteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxKeteranganActionPerformed

    private void jButtonOkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkeActionPerformed
        try {
            koneksi();
            String sql = "SELECT MAX(kode_transaksi) AS kode_transaksi FROM `transaksi`;";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                kode_transaksi = rs.getString("kode_transaksi");
            }
            kode_transaksi = String.valueOf(Integer.valueOf(kode_transaksi)+1);
            status = 1;
            ComboKeterangan();
            dateTime();
            String SQL = "insert into transaksi values('"+kode_transaksi+"','"+tanggal_transaksi+"','"+status+"', 1,'"+keterangan+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            nama=jTextNama.getText();
            nomor_meja=Integer.valueOf(jTextNomorMeja.getText());
            
            this.setVisible(false);
            jFrame1.setVisible(true);
            jFrame1.setSize(1300,700);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }//GEN-LAST:event_jButtonOkeActionPerformed

    private void jCheckBoxMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxMenu.isSelected()){
            Pesan.setEnabled(true);
        }else if(jCheckBoxMenu.isSelected() == false){
            Pesan.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxMenuActionPerformed

    private void PesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesanActionPerformed
        try {
            koneksi();
            status=2;
            dateTime();
            String SQL = "UPDATE transaksi SET kode_transaksi ='"+kode_transaksi+"',tanggal_transaksi='"+tanggal_transaksi+"',status = '"+status+"',status_kitchen = 1,keterangan ='"+keterangan+"' WHERE kode_transaksi = '"+kode_transaksi+"';";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            DefaultTableModel table1 = (DefaultTableModel) jTable1.getModel();
            table1.setRowCount(0);
            Clear();
            jFrame1.setVisible(false);
            this.setVisible(true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
// TODO add your handling code here:
    }//GEN-LAST:event_PesanActionPerformed

    private void jComboBoxMieIblisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMieIblisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMieIblisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Costumer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Costumer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Costumer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Costumer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Costumer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BeliAirMineral;
    private javax.swing.JButton BeliCeker;
    private javax.swing.JButton BeliEsGenderuwo;
    private javax.swing.JButton BeliEsOrange;
    private javax.swing.JButton BeliEsPocong;
    private javax.swing.JButton BeliEsSundelBolong;
    private javax.swing.JButton BeliEsTeh;
    private javax.swing.JButton BeliEsTuyul;
    private javax.swing.JButton BeliLemonTea;
    private javax.swing.JButton BeliLumpiangUdang;
    private javax.swing.JButton BeliMieAngel;
    private javax.swing.JButton BeliMieIblis;
    private javax.swing.JButton BeliMieSetan;
    private javax.swing.JButton BeliMilo;
    private javax.swing.JButton BeliPangsitGoreng;
    private javax.swing.JButton BeliSiomay;
    private javax.swing.JButton BeliTehTarik;
    private javax.swing.JButton BeliUdangRambutan;
    private javax.swing.JButton BeliUdangkeju;
    private javax.swing.JButton BeliVanilaLate;
    private javax.swing.JButton Pesan;
    private javax.swing.JLabel Total;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonOke;
    private javax.swing.JButton jCancelMenu;
    private javax.swing.JCheckBox jCheckBoxMenu;
    private javax.swing.JComboBox<String> jComboBoxKeterangan;
    private javax.swing.JComboBox<String> jComboBoxMieIblis;
    private javax.swing.JComboBox<String> jComboBoxMieSetan;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JButton jKurangAirMineral;
    private javax.swing.JButton jKurangCeker;
    private javax.swing.JButton jKurangEsGenderuwo;
    private javax.swing.JButton jKurangEsOrange;
    private javax.swing.JButton jKurangEsPocong;
    private javax.swing.JButton jKurangEsSundelBolong;
    private javax.swing.JButton jKurangEsTeh;
    private javax.swing.JButton jKurangEsTuyul;
    private javax.swing.JButton jKurangLemonTea;
    private javax.swing.JButton jKurangLumpiangUdang;
    private javax.swing.JButton jKurangMieAngel;
    private javax.swing.JButton jKurangMieIblis;
    private javax.swing.JButton jKurangMieSetan;
    private javax.swing.JButton jKurangMilo;
    private javax.swing.JButton jKurangPangsitGoreng;
    private javax.swing.JButton jKurangSiomay;
    private javax.swing.JButton jKurangTehTarik;
    private javax.swing.JButton jKurangUdangKeju;
    private javax.swing.JButton jKurangUdangRambutan;
    private javax.swing.JButton jKurangVanilaLatte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneTabel;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jTambahAirMineral;
    private javax.swing.JButton jTambahCeker;
    private javax.swing.JButton jTambahEsGenderuwo;
    private javax.swing.JButton jTambahEsOrange;
    private javax.swing.JButton jTambahEsPocong;
    private javax.swing.JButton jTambahEsSundelBolong;
    private javax.swing.JButton jTambahEsTeh;
    private javax.swing.JButton jTambahEsTuyul;
    private javax.swing.JButton jTambahLemonTea;
    private javax.swing.JButton jTambahLumpiangUdang;
    private javax.swing.JButton jTambahMieAngel;
    private javax.swing.JButton jTambahMieIblis;
    private javax.swing.JButton jTambahMieSetan;
    private javax.swing.JButton jTambahMilo;
    private javax.swing.JButton jTambahPangsitGoreng;
    private javax.swing.JButton jTambahSiomay;
    private javax.swing.JButton jTambahTehTarik;
    private javax.swing.JButton jTambahUdangRambutan;
    private javax.swing.JButton jTambahUdangkeju;
    private javax.swing.JButton jTambahVanilaLatte;
    private javax.swing.JTextField jTextJumlahAirMineral;
    private javax.swing.JTextField jTextJumlahCeker;
    private javax.swing.JTextField jTextJumlahEsGenderuwo;
    private javax.swing.JTextField jTextJumlahEsOrange;
    private javax.swing.JTextField jTextJumlahEsPocong;
    private javax.swing.JTextField jTextJumlahEsSundelBolong;
    private javax.swing.JTextField jTextJumlahEsTeh;
    private javax.swing.JTextField jTextJumlahEsTuyul;
    private javax.swing.JTextField jTextJumlahLemonTea;
    private javax.swing.JTextField jTextJumlahLumpiangUdang;
    private javax.swing.JTextField jTextJumlahMieAngel;
    private javax.swing.JTextField jTextJumlahMieIblis;
    private javax.swing.JTextField jTextJumlahMieSetan;
    private javax.swing.JTextField jTextJumlahMilo;
    private javax.swing.JTextField jTextJumlahPangsitGoreng;
    private javax.swing.JTextField jTextJumlahSiomay;
    private javax.swing.JTextField jTextJumlahTehTarik;
    private javax.swing.JTextField jTextJumlahUdangKeju;
    private javax.swing.JTextField jTextJumlahUdangRambutan;
    private javax.swing.JTextField jTextJumlahVanilaLatte;
    private javax.swing.JTextField jTextNama;
    private javax.swing.JTextField jTextNomorMeja;
    private javax.swing.JTextField jTextTotal;
    private javax.swing.JPanel menu1;
    private javax.swing.JPanel menu10;
    private javax.swing.JPanel menu11;
    private javax.swing.JPanel menu12;
    private javax.swing.JPanel menu13;
    private javax.swing.JPanel menu14;
    private javax.swing.JPanel menu15;
    private javax.swing.JPanel menu16;
    private javax.swing.JPanel menu17;
    private javax.swing.JPanel menu18;
    private javax.swing.JPanel menu19;
    private javax.swing.JPanel menu2;
    private javax.swing.JPanel menu20;
    private javax.swing.JPanel menu3;
    private javax.swing.JPanel menu4;
    private javax.swing.JPanel menu5;
    private javax.swing.JPanel menu6;
    private javax.swing.JPanel menu7;
    private javax.swing.JPanel menu8;
    private javax.swing.JPanel menu9;
    // End of variables declaration//GEN-END:variables
}

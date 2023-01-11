/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FP;
/**
 *
 * @author Lenovo
 */

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class Admin extends javax.swing.JFrame {
    Connection con = null;
    ResultSet rs = null;
    Statement stat;
    DefaultTableModel tabmode;
    
    private void koneksi() {
	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/fppbo"; //url database
            String user="root"; //user database
            String pass=""; //password database
            con = DriverManager.getConnection(url,user,pass);
            stat = con.createStatement();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }
    }
    
    private void displayEdit (){
        tabmode = (DefaultTableModel) Tabel_EditTransaksi.getModel();
        tabmode.setRowCount(0);
        ((DefaultTableCellRenderer) Tabel_EditTransaksi.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        String strsql = "select * from transaksi_temporary";
        try{
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            while(rs.next()){
                String[] data = {rs.getString("no_meja"), rs.getString("nama_pelanggan"), rs.getString("kode_transaksi"),
                                 rs.getString("tanggal_transaksi"), rs.getString("kode_menu"),
                                 rs.getString("harga"), rs.getString("qty"), rs.getString("total_harga")};
                tabmode.addRow(data);
            }
            NamaMenuEdit.setEditable(false);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void displayRiwayat (){
        tabmode = (DefaultTableModel) Tabel_Riwayat.getModel();
        tabmode.setRowCount(0);
        ((DefaultTableCellRenderer) Tabel_Riwayat.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        String strsql = "select * from detailtransaksi";
        try{
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            while(rs.next()){
                String[] data = {rs.getString("kode_transaksi"), rs.getString("tanggal_transaksi"),
                                rs.getString("kode_menu"), rs.getString("harga"), rs.getString("qty"),
                                rs.getString("total_harga")};
                tabmode.addRow(data);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void displayMenu (){
        tabmode = (DefaultTableModel) Tabel_Menu.getModel();
        tabmode.setRowCount(0);
        ((DefaultTableCellRenderer) Tabel_Menu.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        String strsql =  "select * from menu";
        try{
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            while(rs.next()){
                String[] data = {rs.getString("kode_menu"), rs.getString("nama_menu"), rs.getString("harga")};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void displayKasir (){
        tabmode = (DefaultTableModel) Tabel_Kasir.getModel();
        tabmode.setRowCount(0);
        ((DefaultTableCellRenderer) Tabel_Kasir.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        String strsql = "select * from kasir";
        try{
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            while(rs.next()){
                String[] data = {rs.getString("id_kasir"), rs.getString("nama_kasir"),
                                 rs.getString("password"), rs.getString("nomor_hp"), rs.getString("alamat")};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void displayAdmin (){
        tabmode = (DefaultTableModel) Tabel_Admin.getModel();
        tabmode.setRowCount(0);
        ((DefaultTableCellRenderer) Tabel_Admin.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        String strsql = "select * from admin";
        try{
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            while(rs.next()){
                String[] data = {rs.getString("id_admin"), rs.getString("nama_admin"),
                                 rs.getString("password"), rs.getString("nomor_hp"), rs.getString("alamat")};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setNamaMenuEdit(){
        try{
            koneksi();
            String kode_menu = KodeMenuCombo.getSelectedItem().toString();
            String strsql = "select * from menu where kode_menu = '"+kode_menu+"'";
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            if(rs.next()){
                NamaMenuEdit.setText(rs.getString("nama_menu"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void clearKasir(){
        ID_KasirKelola.setText(null);
        Nama_KasirKelola.setText(null);
        Password_KasirKelola.setText(null);
        Telp_KasirKelola.setText(null);
        Alamat_KasirKelola.setText(null);
    }
    
    private void clearAdmin(){
        ID_AdminKelola.setText(null);
        Nama_AdminKelola.setText(null);
        Password_AdminKelola.setText(null);
        Telp_AdminKelola.setText(null);
        Alamat_AdminKelola.setText(null);
    }
    
    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        koneksi();
        if(Login.status_admin.equals("Biasa")){
            jTabbedPane1.setEnabledAt(4, false);
        }
        displayAdmin();
        displayEdit();
        displayKasir();
        displayMenu();
        displayRiwayat();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        TEditTrans = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_EditTransaksi = new javax.swing.JTable();
        QtyEdit = new javax.swing.JTextField();
        KodeMenuCombo = new javax.swing.JComboBox<>();
        Ubah_Transaksi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NamaMenuEdit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Hapus_Transaksi = new javax.swing.JButton();
        jScrollPanel = new javax.swing.JScrollPane();
        Tabel_Riwayat = new javax.swing.JTable();
        TKelolaMenu = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tabel_Menu = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Kode_MenuKelola = new javax.swing.JTextField();
        Nama_MenuKelola = new javax.swing.JTextField();
        Harga_MenuKelola = new javax.swing.JTextField();
        Ubah_MenuKelola = new javax.swing.JButton();
        TKelolaKasir = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabel_Kasir = new javax.swing.JTable();
        ID_KasirKelola = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Nama_KasirKelola = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Password_KasirKelola = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Telp_KasirKelola = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Alamat_KasirKelola = new javax.swing.JTextArea();
        Tambah_Kasir = new javax.swing.JButton();
        Hapus_Kasir = new javax.swing.JButton();
        Edit_Kasir = new javax.swing.JButton();
        TKelolaAdmin = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabel_Admin = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        Alamat_AdminKelola = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        ID_AdminKelola = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Nama_AdminKelola = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Password_AdminKelola = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Telp_AdminKelola = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Tambah_Admin = new javax.swing.JButton();
        Hapus_Admin = new javax.swing.JButton();
        Edit_Admin = new javax.swing.JButton();
        Logout_Admin = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Admin");
        setBackground(new java.awt.Color(204, 204, 255));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        TEditTrans.setBackground(new java.awt.Color(0, 255, 153));

        Tabel_EditTransaksi.setBackground(new java.awt.Color(154, 255, 187));
        Tabel_EditTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Meja", "Nama Pelanggan", "Kode Transaksi", "Tanggal Transaksi", "Kode Menu", "Harga", "Qty", "Total Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabel_EditTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_EditTransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabel_EditTransaksi);

        QtyEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QtyEditMouseClicked(evt);
            }
        });
        QtyEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtyEditActionPerformed(evt);
            }
        });

        KodeMenuCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));
        KodeMenuCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                KodeMenuComboItemStateChanged(evt);
            }
        });
        KodeMenuCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KodeMenuComboMouseClicked(evt);
            }
        });
        KodeMenuCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeMenuComboActionPerformed(evt);
            }
        });

        Ubah_Transaksi.setBackground(new java.awt.Color(0, 0, 255));
        Ubah_Transaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Ubah_Transaksi.setForeground(new java.awt.Color(255, 255, 255));
        Ubah_Transaksi.setText("Ubah");
        Ubah_Transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ubah_TransaksiActionPerformed(evt);
            }
        });

        jLabel1.setText("Kode Menu");

        jLabel2.setText("Nama Menu");

        jLabel3.setText("Qty");

        Hapus_Transaksi.setBackground(new java.awt.Color(255, 0, 0));
        Hapus_Transaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Hapus_Transaksi.setForeground(new java.awt.Color(255, 255, 255));
        Hapus_Transaksi.setText("Hapus");
        Hapus_Transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hapus_TransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TEditTransLayout = new javax.swing.GroupLayout(TEditTrans);
        TEditTrans.setLayout(TEditTransLayout);
        TEditTransLayout.setHorizontalGroup(
            TEditTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TEditTransLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(TEditTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TEditTransLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(KodeMenuCombo, 0, 105, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TEditTransLayout.createSequentialGroup()
                        .addComponent(Ubah_Transaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Hapus_Transaksi))
                    .addGroup(TEditTransLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addGroup(TEditTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(NamaMenuEdit)
                            .addComponent(QtyEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        TEditTransLayout.setVerticalGroup(
            TEditTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TEditTransLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(TEditTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TEditTransLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(KodeMenuCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TEditTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NamaMenuEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TEditTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(QtyEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(TEditTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ubah_Transaksi)
                    .addComponent(Hapus_Transaksi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Edit Transaksi", TEditTrans);

        jScrollPanel.setBackground(new java.awt.Color(255, 153, 102));

        Tabel_Riwayat.setBackground(new java.awt.Color(255, 204, 153));
        Tabel_Riwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Transaksi", "Tanggal Transaksi", "Kode Menu", "Harga", "Qty", "Total Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPanel.setViewportView(Tabel_Riwayat);

        jTabbedPane1.addTab("Riwayat Transaksi", jScrollPanel);

        TKelolaMenu.setBackground(new java.awt.Color(190, 190, 12));

        Tabel_Menu.setBackground(new java.awt.Color(236, 236, 85));
        Tabel_Menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Menu", "Nama Menu", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabel_Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_MenuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Tabel_Menu);

        jLabel14.setText("Kode Menu");

        jLabel15.setText("Nama Menu");

        jLabel16.setText("Harga");

        Ubah_MenuKelola.setBackground(new java.awt.Color(0, 0, 204));
        Ubah_MenuKelola.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Ubah_MenuKelola.setForeground(new java.awt.Color(255, 255, 255));
        Ubah_MenuKelola.setText("Ubah");
        Ubah_MenuKelola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ubah_MenuKelolaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TKelolaMenuLayout = new javax.swing.GroupLayout(TKelolaMenu);
        TKelolaMenu.setLayout(TKelolaMenuLayout);
        TKelolaMenuLayout.setHorizontalGroup(
            TKelolaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKelolaMenuLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(TKelolaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TKelolaMenuLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(TKelolaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(Kode_MenuKelola)
                            .addComponent(Nama_MenuKelola)
                            .addComponent(jLabel16)
                            .addComponent(Harga_MenuKelola, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(TKelolaMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(Ubah_MenuKelola, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        TKelolaMenuLayout.setVerticalGroup(
            TKelolaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKelolaMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Kode_MenuKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nama_MenuKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Harga_MenuKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Ubah_MenuKelola)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Kelola Menu", TKelolaMenu);

        TKelolaKasir.setBackground(new java.awt.Color(0, 153, 204));

        Tabel_Kasir.setBackground(new java.awt.Color(153, 204, 255));
        Tabel_Kasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Password", "No Telepon", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabel_Kasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_KasirMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabel_Kasir);

        jLabel4.setText("ID");

        jLabel5.setText("Nama");

        jLabel6.setText("Password");

        jLabel7.setText("No Telepon");

        jLabel8.setText("Alamat");

        Alamat_KasirKelola.setColumns(20);
        Alamat_KasirKelola.setRows(5);
        jScrollPane1.setViewportView(Alamat_KasirKelola);

        Tambah_Kasir.setBackground(new java.awt.Color(51, 255, 51));
        Tambah_Kasir.setText("Tambah");
        Tambah_Kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tambah_KasirActionPerformed(evt);
            }
        });

        Hapus_Kasir.setBackground(new java.awt.Color(255, 0, 0));
        Hapus_Kasir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Hapus_Kasir.setForeground(new java.awt.Color(255, 255, 255));
        Hapus_Kasir.setText("Hapus");
        Hapus_Kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hapus_KasirActionPerformed(evt);
            }
        });

        Edit_Kasir.setBackground(new java.awt.Color(255, 255, 0));
        Edit_Kasir.setText("Edit");
        Edit_Kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_KasirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TKelolaKasirLayout = new javax.swing.GroupLayout(TKelolaKasir);
        TKelolaKasir.setLayout(TKelolaKasirLayout);
        TKelolaKasirLayout.setHorizontalGroup(
            TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKelolaKasirLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TKelolaKasirLayout.createSequentialGroup()
                        .addComponent(Tambah_Kasir)
                        .addGap(17, 17, 17)
                        .addComponent(Edit_Kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(Hapus_Kasir))
                    .addGroup(TKelolaKasirLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(TKelolaKasirLayout.createSequentialGroup()
                                    .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel4))
                                    .addGap(27, 27, 27)
                                    .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ID_KasirKelola)
                                        .addComponent(Nama_KasirKelola)
                                        .addComponent(Password_KasirKelola)
                                        .addComponent(Telp_KasirKelola)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        TKelolaKasirLayout.setVerticalGroup(
            TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKelolaKasirLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ID_KasirKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Nama_KasirKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Password_KasirKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Telp_KasirKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(TKelolaKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tambah_Kasir)
                    .addComponent(Hapus_Kasir)
                    .addComponent(Edit_Kasir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Kelola Kasir", TKelolaKasir);

        TKelolaAdmin.setBackground(new java.awt.Color(5, 183, 94));

        Tabel_Admin.setBackground(new java.awt.Color(125, 236, 125));
        Tabel_Admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Password", "No Telepon", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabel_Admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_AdminMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Tabel_Admin);

        Alamat_AdminKelola.setColumns(20);
        Alamat_AdminKelola.setRows(5);
        jScrollPane5.setViewportView(Alamat_AdminKelola);

        jLabel9.setText("ID");

        jLabel10.setText("Nama");

        jLabel11.setText("Password");

        jLabel12.setText("No Telepon");

        jLabel13.setText("Alamat");

        Tambah_Admin.setBackground(new java.awt.Color(0, 255, 0));
        Tambah_Admin.setText("Tambah");
        Tambah_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tambah_AdminActionPerformed(evt);
            }
        });

        Hapus_Admin.setBackground(new java.awt.Color(255, 0, 0));
        Hapus_Admin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Hapus_Admin.setForeground(new java.awt.Color(255, 255, 255));
        Hapus_Admin.setText("Hapus");
        Hapus_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hapus_AdminActionPerformed(evt);
            }
        });

        Edit_Admin.setBackground(new java.awt.Color(255, 255, 0));
        Edit_Admin.setText("Edit");
        Edit_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_AdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TKelolaAdminLayout = new javax.swing.GroupLayout(TKelolaAdmin);
        TKelolaAdmin.setLayout(TKelolaAdminLayout);
        TKelolaAdminLayout.setHorizontalGroup(
            TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKelolaAdminLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TKelolaAdminLayout.createSequentialGroup()
                        .addComponent(Tambah_Admin)
                        .addGap(18, 18, 18)
                        .addComponent(Edit_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Hapus_Admin))
                    .addGroup(TKelolaAdminLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(TKelolaAdminLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(77, 77, 77)
                                .addComponent(ID_AdminKelola))
                            .addGroup(TKelolaAdminLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(56, 56, 56)
                                .addComponent(Nama_AdminKelola))
                            .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addGroup(TKelolaAdminLayout.createSequentialGroup()
                                    .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel11))
                                    .addGap(27, 27, 27)
                                    .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Telp_AdminKelola, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Password_AdminKelola, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        TKelolaAdminLayout.setVerticalGroup(
            TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TKelolaAdminLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(TKelolaAdminLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TKelolaAdminLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(ID_AdminKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TKelolaAdminLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(Nama_AdminKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Password_AdminKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TKelolaAdminLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12))
                    .addComponent(Telp_AdminKelola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(TKelolaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tambah_Admin)
                    .addComponent(Edit_Admin)
                    .addComponent(Hapus_Admin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kelola Admin", TKelolaAdmin);

        Logout_Admin.setBackground(new java.awt.Color(255, 0, 0));
        Logout_Admin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Logout_Admin.setForeground(new java.awt.Color(255, 255, 255));
        Logout_Admin.setText("Log Out");
        Logout_Admin.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        Logout_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout_AdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(475, 475, 475)
                .addComponent(Logout_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(475, 475, 475))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Logout_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Logout_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout_AdminActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_Logout_AdminActionPerformed

    private void QtyEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtyEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtyEditActionPerformed

    private void KodeMenuComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeMenuComboActionPerformed
        // TODO add your handling code here:
        setNamaMenuEdit();
    }//GEN-LAST:event_KodeMenuComboActionPerformed

    private void QtyEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QtyEditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_QtyEditMouseClicked

    private void Ubah_TransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ubah_TransaksiActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            int row = Tabel_EditTransaksi.getSelectedRow();
            String no_meja = Tabel_EditTransaksi.getModel().getValueAt(row, 0).toString();
            String nama_pelanggan = Tabel_EditTransaksi.getModel().getValueAt(row, 1).toString();
            String kode_transaksi = Tabel_EditTransaksi.getModel().getValueAt(row, 2).toString();
            String tanggal_transaksi = Tabel_EditTransaksi.getModel().getValueAt(row, 3).toString();
            String kode_menu = Tabel_EditTransaksi.getModel().getValueAt(row, 4).toString();
            String harga = null;
            String qty = QtyEdit.getText();
            String strsql = "select harga from menu where kode_menu = '"+KodeMenuCombo.getSelectedItem().toString()+"'";
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            if(rs.next()){
                harga = rs.getString("harga");
            }
            String total_harga = String.valueOf(Integer.parseInt(qty)*Integer.valueOf(harga));
            strsql = "UPDATE transaksi_temporary SET no_meja = '"+no_meja+"', nama_pelanggan = '"+nama_pelanggan+"', kode_transaksi = '"+
                     kode_transaksi+"', tanggal_transaksi = '"+tanggal_transaksi+"', kode_menu = '"+KodeMenuCombo.getSelectedItem().toString()+"', harga = "+harga+
                     ", qty = "+qty+", total_harga = "+total_harga+" where kode_transaksi = '"+kode_transaksi+"' AND kode_menu = '"+kode_menu+"'";
            stat = con.prepareCall(strsql);
            stat.executeUpdate(strsql);
            displayEdit();
            stat.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Berhasil diubah!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Ubah_TransaksiActionPerformed

    private void Tabel_EditTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_EditTransaksiMouseClicked
        // TODO add your handling code here:
        koneksi();
        int row = Tabel_EditTransaksi.getSelectedRow();
        String menu_clicked = (Tabel_EditTransaksi.getModel().getValueAt(row, 4).toString());
        String qty_clicked = (Tabel_EditTransaksi.getModel().getValueAt(row, 6).toString());
        KodeMenuCombo.setSelectedItem(menu_clicked);
        QtyEdit.setText(qty_clicked);
        setNamaMenuEdit();
    }//GEN-LAST:event_Tabel_EditTransaksiMouseClicked

    private void KodeMenuComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KodeMenuComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeMenuComboMouseClicked

    private void KodeMenuComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_KodeMenuComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeMenuComboItemStateChanged

    private void Hapus_TransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hapus_TransaksiActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            int row = Tabel_EditTransaksi.getSelectedRow();
            String kode_transaksi = (Tabel_EditTransaksi.getModel().getValueAt(row, 2).toString());
            String kode_menu = (Tabel_EditTransaksi.getModel().getValueAt(row, 4).toString());
            String strsql = "delete from transaksi_temporary where kode_transaksi = '"+kode_transaksi+"' AND kode_menu = '"+kode_menu+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            strsql = "delete from transaksi where kode_transaksi = '"+kode_transaksi+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            displayEdit();
            stat.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Berhasil diedit!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Hapus_TransaksiActionPerformed

    private void Tabel_MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_MenuMouseClicked
        // TODO add your handling code here:
        try{
            koneksi();
            int row = Tabel_Menu.getSelectedRow();
            String kode_menu = (Tabel_Menu.getModel().getValueAt(row, 0).toString());
            String strsql = "select * from menu where kode_menu = '"+kode_menu+"'";
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            if(rs.next()){
                Kode_MenuKelola.setText(rs.getString("kode_menu"));
                Nama_MenuKelola.setText(rs.getString("nama_menu"));
                Harga_MenuKelola.setText(rs.getString("harga"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Tabel_MenuMouseClicked

    private void Ubah_MenuKelolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ubah_MenuKelolaActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            int row = Tabel_Menu.getSelectedRow();
            String kode_menu = Tabel_Menu.getModel().getValueAt(row, 0).toString();
            String strsql = "update menu set kode_menu = '"+Kode_MenuKelola.getText()+"', nama_menu = '"+Nama_MenuKelola.getText()+
                            "', harga = "+Harga_MenuKelola.getText()+" where kode_menu = '"+kode_menu+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            displayMenu();
            stat.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Berhasil diubah!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Ubah_MenuKelolaActionPerformed

    private void Tambah_KasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tambah_KasirActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            String strsql = "insert into kasir values('"+ID_KasirKelola.getText()+"','"+Nama_KasirKelola.getText()+"','"+
                            Password_KasirKelola.getText()+"','"+Alamat_KasirKelola.getText()+"','"+Telp_KasirKelola.getText()+"')";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            displayKasir();
            stat.close();
            con.close();
            clearKasir();
            JOptionPane.showMessageDialog(null, "Berhasil ditambah!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Tambah_KasirActionPerformed

    private void Edit_KasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_KasirActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            int row = Tabel_Kasir.getSelectedRow();
            String ID = Tabel_Kasir.getModel().getValueAt(row, 0).toString();
            String strsql = "update kasir set id_kasir = '"+ID_KasirKelola.getText()+"', nama_kasir = '"+Nama_KasirKelola.getText()+
                            "', password = '"+Password_KasirKelola.getText()+"', alamat = '"+Alamat_KasirKelola.getText()+"', nomor_hp = '"+
                            Telp_KasirKelola.getText()+"' where id_kasir = '"+ID+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            displayKasir();
            stat.close();
            con.close();
            clearKasir();
            JOptionPane.showMessageDialog(null, "Berhasil diedit!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Edit_KasirActionPerformed

    private void Hapus_KasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hapus_KasirActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            String strsql = "delete from kasir where id_kasir = '"+ID_KasirKelola.getText()+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            displayKasir();
            stat.close();
            con.close();
            clearKasir();
            JOptionPane.showMessageDialog(null, "Berhasil dihapus!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Hapus_KasirActionPerformed

    private void Tambah_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tambah_AdminActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            String strsql = "insert into admin values('"+ID_AdminKelola.getText()+"','"+Nama_AdminKelola.getText()+"','"+
                            Password_AdminKelola.getText()+"','"+Alamat_AdminKelola.getText()+"','"+Telp_AdminKelola.getText()+"')";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            displayAdmin();
            stat.close();
            con.close();
            clearAdmin();
            JOptionPane.showMessageDialog(null, "Berhasil ditambah!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Tambah_AdminActionPerformed

    private void Edit_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_AdminActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            int row = Tabel_Admin.getSelectedRow();
            String ID = Tabel_Admin.getModel().getValueAt(row, 0).toString();
            String strsql = "update admin set id_admin = '"+ID_AdminKelola.getText()+"', nama_admin = '"+Nama_AdminKelola.getText()+
                            "', password = '"+Password_AdminKelola.getText()+"', alamat = '"+Alamat_AdminKelola.getText()+"', nomor_hp = '"+
                            Telp_AdminKelola.getText()+"' where id_admin = '"+ID+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            displayAdmin();
            stat.close();
            con.close();
            clearAdmin();
            JOptionPane.showMessageDialog(null, "Berhasil diedit!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Edit_AdminActionPerformed

    private void Hapus_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hapus_AdminActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            String strsql = "delete from admin where id_admin = '"+ID_AdminKelola.getText()+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            displayAdmin();
            stat.close();
            con.close();
            clearAdmin();
            JOptionPane.showMessageDialog(null, "Berhasil dihapus!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Hapus_AdminActionPerformed

    private void Tabel_KasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_KasirMouseClicked
        // TODO add your handling code here:
        try{
            koneksi();
            int row = Tabel_Kasir.getSelectedRow();
            String id_kasir = (Tabel_Kasir.getModel().getValueAt(row, 0).toString());
            String strsql = "select * from kasir where id_kasir = '"+id_kasir+"'";
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            if(rs.next()){
                ID_KasirKelola.setText(rs.getString("id_kasir"));
                Nama_KasirKelola.setText(rs.getString("nama_kasir"));
                Password_KasirKelola.setText(rs.getString("password"));
                Telp_KasirKelola.setText(rs.getString("nomor_hp"));
                Alamat_KasirKelola.setText(rs.getString("alamat"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Tabel_KasirMouseClicked

    private void Tabel_AdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_AdminMouseClicked
        // TODO add your handling code here:
        try{
            koneksi();
            int row = Tabel_Admin.getSelectedRow();
            String id_admin = (Tabel_Admin.getModel().getValueAt(row, 0).toString());
            String strsql = "select * from admin where id_admin = '"+id_admin+"'";
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            if(rs.next()){
                ID_AdminKelola.setText(rs.getString("id_admin"));
                Nama_AdminKelola.setText(rs.getString("nama_admin"));
                Password_AdminKelola.setText(rs.getString("password"));
                Telp_AdminKelola.setText(rs.getString("nomor_hp"));
                Alamat_AdminKelola.setText(rs.getString("alamat"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Tabel_AdminMouseClicked

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Alamat_AdminKelola;
    private javax.swing.JTextArea Alamat_KasirKelola;
    private javax.swing.JButton Edit_Admin;
    private javax.swing.JButton Edit_Kasir;
    private javax.swing.JButton Hapus_Admin;
    private javax.swing.JButton Hapus_Kasir;
    private javax.swing.JButton Hapus_Transaksi;
    private javax.swing.JTextField Harga_MenuKelola;
    private javax.swing.JTextField ID_AdminKelola;
    private javax.swing.JTextField ID_KasirKelola;
    private javax.swing.JComboBox<String> KodeMenuCombo;
    private javax.swing.JTextField Kode_MenuKelola;
    private javax.swing.JButton Logout_Admin;
    private javax.swing.JTextField NamaMenuEdit;
    private javax.swing.JTextField Nama_AdminKelola;
    private javax.swing.JTextField Nama_KasirKelola;
    private javax.swing.JTextField Nama_MenuKelola;
    private javax.swing.JTextField Password_AdminKelola;
    private javax.swing.JTextField Password_KasirKelola;
    private javax.swing.JTextField QtyEdit;
    private javax.swing.JPanel TEditTrans;
    private javax.swing.JPanel TKelolaAdmin;
    private javax.swing.JPanel TKelolaKasir;
    private javax.swing.JPanel TKelolaMenu;
    private javax.swing.JTable Tabel_Admin;
    private javax.swing.JTable Tabel_EditTransaksi;
    private javax.swing.JTable Tabel_Kasir;
    private javax.swing.JTable Tabel_Menu;
    private javax.swing.JTable Tabel_Riwayat;
    private javax.swing.JButton Tambah_Admin;
    private javax.swing.JButton Tambah_Kasir;
    private javax.swing.JTextField Telp_AdminKelola;
    private javax.swing.JTextField Telp_KasirKelola;
    private javax.swing.JButton Ubah_MenuKelola;
    private javax.swing.JButton Ubah_Transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FP;


import java.awt.event.KeyEvent;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RIZKI HERIANA
 */
public class Kasir extends javax.swing.JFrame {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    Statement stat;
    int harga,total_bayar,qty,total_harga,status;
    String kode_transaksi,kode_menu,nama,nama_menu,nomor_meja,keterangan;
    
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
            if(status==2){
                koneksi();
                stat = con.createStatement();
                String sql = "SELECT transaksi_temporary.kode_menu, menu.nama_menu, transaksi_temporary.harga, transaksi_temporary.qty, transaksi_temporary.total_harga FROM menu INNER JOIN transaksi_temporary ON menu.kode_menu = transaksi_temporary.kode_menu WHERE kode_transaksi = '"+kode_transaksi+"';";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                totalharga();
            }        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void totalharga () {
        try {
            if(status==2){
                koneksi();
                stat = con.createStatement();
                String sql = "SELECT SUM(total_harga) FROM `transaksi_temporary`WHERE kode_transaksi = '"+kode_transaksi+"';";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    total_bayar = rs.getInt(1);
                }
                TotalHarga.setEditable(false);
                TotalHarga.setText(String.valueOf(total_bayar));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    void Clear(){
        TNo_Meja.setText(null);
        TNama.setText(null);
        TKode_Menu.setText(null);
        TQty.setText(null);
    }
    
    void Confirm(){
        TBayar.setText(null);
        TotalHarga.setText(null);
        TKembali.setText(null);
    }
    public Kasir() {
        initComponents();
        koneksi();   //memanggil fungsi koneksi
        display();
        Nama_Kasir.setText(Login.nama_kasir);
        setLocationRelativeTo(null);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TNama = new javax.swing.JTextField();
        TNo_Meja = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TotalHarga = new javax.swing.JTextField();
        BInput = new javax.swing.JButton();
        BUpdate = new javax.swing.JButton();
        BDelete = new javax.swing.JButton();
        BConfirm = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TBayar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TKembali = new javax.swing.JTextField();
        TKode_Menu = new javax.swing.JTextField();
        TQty = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Logout = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        LogoutYa = new javax.swing.JButton();
        LogoutNo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextKodeTransaksi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonOke = new javax.swing.JButton();
        Nama_Kasir = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(18, 23, 89));
        jPanel1.setForeground(new java.awt.Color(18, 23, 89));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 219, 35));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DETAIL TRANSAKSI");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No. Meja");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Pelanggan");

        TNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNamaActionPerformed(evt);
            }
        });

        TNo_Meja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNo_MejaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kode Menu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Qty");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Bayar");

        BInput.setBackground(new java.awt.Color(51, 102, 255));
        BInput.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BInput.setText("INPUT");
        BInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInputActionPerformed(evt);
            }
        });

        BUpdate.setBackground(new java.awt.Color(255, 255, 0));
        BUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BUpdate.setText("UPDATE");
        BUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUpdateActionPerformed(evt);
            }
        });

        BDelete.setBackground(new java.awt.Color(255, 0, 0));
        BDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BDelete.setText("DELETE");
        BDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeleteActionPerformed(evt);
            }
        });

        BConfirm.setBackground(new java.awt.Color(0, 170, 19));
        BConfirm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BConfirm.setText("CONFIRM");
        BConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConfirmActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bayar");

        TBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBayarKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Kembalian");

        TKode_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKode_MenuActionPerformed(evt);
            }
        });

        TQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TQtyActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Menu", "Nama Menu", "Harga", "Qty", "Total Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(163, 163, 163)
                            .addComponent(BInput)
                            .addGap(12, 12, 12)
                            .addComponent(BUpdate)
                            .addGap(14, 14, 14)
                            .addComponent(BDelete))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(TQty, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(TNo_Meja, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(TNama, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(TKode_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TNo_Meja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TKode_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BInput)
                    .addComponent(BUpdate)
                    .addComponent(BDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(BConfirm)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel5.setText("Apakah Anda ingin Logout?");

        LogoutYa.setBackground(new java.awt.Color(0, 255, 0));
        LogoutYa.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        LogoutYa.setText("YA");
        LogoutYa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogoutYa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutYaActionPerformed(evt);
            }
        });

        LogoutNo.setBackground(new java.awt.Color(255, 0, 0));
        LogoutNo.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        LogoutNo.setText("TIDAK");
        LogoutNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogoutNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LogoutNo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutYa, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogoutYa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogoutNo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LogoutLayout = new javax.swing.GroupLayout(Logout.getContentPane());
        Logout.getContentPane().setLayout(LogoutLayout);
        LogoutLayout.setHorizontalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(18, 23, 89));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/LogoMieGacoan 1.png"))); // NOI18N

        jTextKodeTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextKodeTransaksiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kode Transaksi");

        jButtonOke.setText("Oke");
        jButtonOke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkeActionPerformed(evt);
            }
        });

        Nama_Kasir.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        Nama_Kasir.setForeground(new java.awt.Color(255, 255, 255));
        Nama_Kasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu gacoan/orang.png"))); // NOI18N
        Nama_Kasir.setText("Nama_Kasir");
        Nama_Kasir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Nama_Kasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Nama_KasirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel11)
                        .addGap(36, 36, 36)
                        .addComponent(Nama_Kasir, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonOke, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(Nama_Kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButtonOke, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNamaActionPerformed

    private void TNo_MejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNo_MejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNo_MejaActionPerformed

    private void BInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInputActionPerformed
        try{
            koneksi();
            nomor_meja = TNo_Meja.getText();
            nama = TNama.getText();
            kode_menu = TKode_Menu.getText();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '"+kode_menu+"';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = TQty.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            String SQL = "insert into transaksi_temporary values('" + nomor_meja +"','"+nama+"','" + kode_transaksi +"','2022-12-21 13:22:02.000000' ,'"+ kode_menu +"','" + harga +"','" +qty+ "','"+total_harga+"')";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BInputActionPerformed

    private void BUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUpdateActionPerformed
        try{
            koneksi();
            nomor_meja = TNo_Meja.getText();
            nama = TNama.getText();
            kode_menu = TKode_Menu.getText();
            stat = con.createStatement();
            String sql = "SELECT menu.harga FROM menu WHERE kode_menu = '"+kode_menu+"';";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                harga = rs.getInt(1);
            }
            String jumlah_qty = TQty.getText();
            qty = Integer.parseInt(jumlah_qty);
            total_harga = harga*qty;
            String SQL = "UPDATE transaksi_temporary SET no_meja ='"+nomor_meja+"', nama_pelanggan ='"+nama+"', kode_transaksi ='"+kode_transaksi+"', tanggal_transaksi = '2022-12-30 03:46:18', kode_menu ='"+kode_menu+"', harga ='"+harga+"', qty ='"+qty+"', total_harga ='"+total_harga+"' WHERE kode_transaksi = '"+kode_transaksi+"' AND kode_menu = '"+kode_menu+"';";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BUpdateActionPerformed

    private void BDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeleteActionPerformed
        try{
            koneksi();
            kode_menu = TKode_Menu.getText();
            String SQL = "DELETE FROM transaksi_temporary WHERE kode_transaksi = '"+kode_transaksi+"' AND kode_menu = '"+kode_menu+"';";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            display();
            stat.close();
            con.close();
            totalharga();
            Clear();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_BDeleteActionPerformed

    private void BConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConfirmActionPerformed
        try {
            koneksi();
            String sql = "SELECT keterangan, tanggal_transaksi FROM transaksi WHERE kode_transaksi = '"+kode_transaksi+"';";
            String tanggal_transaksi = null;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                keterangan = rs.getString("keterangan");
                tanggal_transaksi = rs.getString("tanggal_transaksi");
            }
            status=3;
            String SQL = "UPDATE transaksi SET kode_transaksi ='"+kode_transaksi+"',tanggal_transaksi='"+tanggal_transaksi+"',status = '"+status+"',keterangan ='"+keterangan+"' WHERE kode_transaksi = '"+kode_transaksi+"';";// TODO add your handling code here:
            stat.executeUpdate(SQL);
            DefaultTableModel table1 = (DefaultTableModel) jTable1.getModel();
            table1.setRowCount(0);
            Confirm();
            Clear();
            jFrame1.setVisible(false);
            this.setVisible(true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_BConfirmActionPerformed

    private void TBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBayarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            int kembalian = Integer.parseInt(TBayar.getText())-Integer.parseInt(TotalHarga.getText());
            TKembali.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_TBayarKeyPressed

    private void TKode_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKode_MenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TKode_MenuActionPerformed

    private void TQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TQtyActionPerformed

    private void jTextKodeTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextKodeTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextKodeTransaksiActionPerformed

    private void jButtonOkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkeActionPerformed
        try {
            koneksi();
            kode_transaksi = jTextKodeTransaksi.getText();
            String sql = "SELECT status FROM `transaksi` WHERE kode_transaksi = '"+kode_transaksi+"';";// TODO add your handling code here:
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                status = rs.getInt(1);
            }
            if(status == 2){
                display();
                jTextKodeTransaksi.setText(null);
                this.setVisible(false);
                jFrame1.setVisible(true);
                jFrame1.setSize(1030,800);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jButtonOkeActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            koneksi();
            int row =jTable1.getSelectedRow();
            String tabel_klik=(jTable1.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM transaksi_temporary WHERE kode_transaksi = '"+kode_transaksi+"' AND kode_menu = '"+tabel_klik+"';");
            if(sql.next()){
                nomor_meja = sql.getString("no_meja");
                TNo_Meja.setText(nomor_meja);
                nama = sql.getString("nama_pelanggan");
                TNama.setText(nama);
                kode_menu = sql.getString("kode_menu");
                TKode_Menu.setText(kode_menu);
                String qty = sql.getString("qty");
                TQty.setText(qty);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_jTable1MouseClicked

    private void Nama_KasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nama_KasirMouseClicked
        // TODO add your handling code here:
        Logout.setVisible(true);
        Logout.setSize(325, 260);
        Logout.setLocationRelativeTo(null);
    }//GEN-LAST:event_Nama_KasirMouseClicked

    private void LogoutYaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutYaActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        this.setVisible(false);
        Logout.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_LogoutYaActionPerformed

    private void LogoutNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutNoActionPerformed
        // TODO add your handling code here:
        Logout.setVisible(false);
    }//GEN-LAST:event_LogoutNoActionPerformed

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
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BConfirm;
    private javax.swing.JButton BDelete;
    private javax.swing.JButton BInput;
    private javax.swing.JButton BUpdate;
    private javax.swing.JFrame Logout;
    private javax.swing.JButton LogoutNo;
    private javax.swing.JButton LogoutYa;
    private javax.swing.JLabel Nama_Kasir;
    private javax.swing.JTextField TBayar;
    private javax.swing.JTextField TKembali;
    private javax.swing.JTextField TKode_Menu;
    private javax.swing.JTextField TNama;
    private javax.swing.JTextField TNo_Meja;
    private javax.swing.JTextField TQty;
    private javax.swing.JTextField TotalHarga;
    private javax.swing.JButton jButtonOke;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextKodeTransaksi;
    // End of variables declaration//GEN-END:variables
}

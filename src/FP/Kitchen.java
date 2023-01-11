/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FP;

import java.awt.Color;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lenovo
 */
public class Kitchen extends javax.swing.JFrame {
    Connection con = null;
    ResultSet rs = null;
    Statement stat;
    DefaultTableModel tabmode[] = new DefaultTableModel[4];
    Integer status = 0;
    String kode_transaksi[] = new String[4], tanggal_transaksi[] = new String[4], keterangan[] = new String[4];
    
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
    
    private void StatusAntrian(int no){
        try{
            koneksi();
            String strsql = "update transaksi set kode_transaksi = '"+kode_transaksi[no]+"', tanggal_transaksi = '"+tanggal_transaksi[no]+
                            "', status = 3, status_kitchen = 1, keterangan = '"+keterangan[no]+"' where kode_transaksi = '"+kode_transaksi[no]+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            stat.close();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void StatusDibuat(int no){
        try{
            koneksi();
            String strsql = "update transaksi set kode_transaksi = '"+kode_transaksi[no]+"', tanggal_transaksi = '"+tanggal_transaksi[no]+
                            "', status = 3, status_kitchen = 2, keterangan = '"+keterangan[no]+"' where kode_transaksi = '"+kode_transaksi[no]+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            stat.close();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void StatusSelesai(int no){
        try{
            koneksi();
            String strsql = "update transaksi set kode_transaksi = '"+kode_transaksi[no]+"', tanggal_transaksi = '"+tanggal_transaksi[no]+
                            "', status = 0, status_kitchen = 3, keterangan = '"+keterangan[no]+"' where kode_transaksi = '"+kode_transaksi[no]+"'";
            stat = con.prepareStatement(strsql);
            stat.executeUpdate(strsql);
            stat.close();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void DisplayTabel(){
        String strsql = "select transaksi.keterangan, transaksi.tanggal_transaksi, transaksi.kode_transaksi, transaksi_temporary.no_meja, transaksi_temporary.nama_pelanggan, menu.nama_menu, transaksi_temporary.qty, transaksi.status_kitchen FROM transaksi_temporary INNER JOIN menu ON transaksi_temporary.kode_menu = menu.kode_menu INNER JOIN transaksi ON transaksi_temporary.kode_transaksi = transaksi.kode_transaksi WHERE transaksi.status = 3";
        try{
            stat = con.prepareStatement(strsql);
            rs = stat.executeQuery(strsql);
            tabmode[0] = (DefaultTableModel) TabelAntrian1.getModel();
            tabmode[1] = (DefaultTableModel) TabelAntrian2.getModel();
            tabmode[2] = (DefaultTableModel) TabelAntrian3.getModel();
            tabmode[3] = (DefaultTableModel) TabelAntrian4.getModel();
            tabmode[0].setRowCount(0);
            tabmode[1].setRowCount(0);
            tabmode[2].setRowCount(0);
            tabmode[3].setRowCount(0);
            Integer count = 0;
            String no_meja = "";
            while(rs.next()){
                if(no_meja.equals(rs.getString("no_meja")) == false){
                    count += 1;
                }
                Integer status_kitchen = Integer.valueOf(rs.getString("status_kitchen"));
                if(count == 1){
                    ((DefaultTableCellRenderer) TabelAntrian1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                    String[] data = {rs.getString("no_meja"), rs.getString("nama_pelanggan"), rs.getString("nama_menu"), rs.getString("qty")};
                    tabmode[0].addRow(data);
                    kode_transaksi[0] = rs.getString("kode_transaksi");
                    tanggal_transaksi[0] = rs.getString("tanggal_transaksi");
                    keterangan[0] = rs.getString("keterangan");
                    no_meja = rs.getString("no_meja");
                    if(status_kitchen == 1){
                        Antrian1.setSelected(true);
                        Panel1.setBackground(Color.cyan);
                    }else if(status_kitchen == 2){
                        Dibuat1.setSelected(true);
                        Panel1.setBackground(Color.green);
                    }
                }else if(count == 2){
                    ((DefaultTableCellRenderer) TabelAntrian2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                    String[] data = {rs.getString("no_meja"), rs.getString("nama_pelanggan"), rs.getString("nama_menu"), rs.getString("qty")};
                    tabmode[1].addRow(data);
                    kode_transaksi[1] = rs.getString("kode_transaksi");
                    tanggal_transaksi[1] = rs.getString("tanggal_transaksi");
                    keterangan[1] = rs.getString("keterangan");
                    no_meja = rs.getString("no_meja");
                    if(status_kitchen == 1){
                        Antrian2.setSelected(true);
                        Panel2.setBackground(Color.cyan);
                    }else if(status_kitchen == 2){
                        Dibuat2.setSelected(true);
                        Panel2.setBackground(Color.green);
                    }
                }else if(count == 3){
                    ((DefaultTableCellRenderer) TabelAntrian3.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                    String[] data = {rs.getString("no_meja"), rs.getString("nama_pelanggan"), rs.getString("nama_menu"), rs.getString("qty")};
                    tabmode[2].addRow(data);
                    kode_transaksi[2] = rs.getString("kode_transaksi");
                    tanggal_transaksi[2] = rs.getString("tanggal_transaksi");
                    keterangan[2] = rs.getString("keterangan");
                    no_meja = rs.getString("no_meja");
                    if(status_kitchen == 1){
                        Antrian3.setSelected(true);
                        Panel3.setBackground(Color.cyan);
                    }else if(status_kitchen == 2){
                        Dibuat3.setSelected(true);
                        Panel3.setBackground(Color.green);
                    }
                }else if(count == 4){
                    ((DefaultTableCellRenderer) TabelAntrian4.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                    String[] data = {rs.getString("no_meja"), rs.getString("nama_pelanggan"), rs.getString("nama_menu"), rs.getString("qty")};
                    tabmode[3].addRow(data);
                    kode_transaksi[3] = rs.getString("kode_transaksi");
                    tanggal_transaksi[3] = rs.getString("tanggal_transaksi");
                    keterangan[3] = rs.getString("keterangan");
                    no_meja = rs.getString("no_meja");
                    if(status_kitchen == 1){
                        Antrian4.setSelected(true);
                        Panel4.setBackground(Color.cyan);
                    }else if(status_kitchen == 2){
                        Dibuat4.setSelected(true);
                        Panel4.setBackground(Color.green);
                    }
                }else{
                    break;
                }
            }
            if(TabelAntrian1.getRowCount() == 0){
                Antrian1.setEnabled(false);
                Dibuat1.setEnabled(false);
                Selesai1.setEnabled(false);
            }
            if(TabelAntrian2.getRowCount() == 0){
                Antrian2.setEnabled(false);
                Dibuat2.setEnabled(false);
                Selesai2.setEnabled(false);
            }
            if(TabelAntrian3.getRowCount() == 0){
                Antrian3.setEnabled(false);
                Dibuat3.setEnabled(false);
                Selesai3.setEnabled(false);
            }
            if(TabelAntrian4.getRowCount() == 0){
                Antrian4.setEnabled(false);
                Dibuat4.setEnabled(false);
                Selesai4.setEnabled(false);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * Creates new form Kitchen
     */
    public Kitchen() {
        initComponents();
        koneksi();
        DisplayTabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tombol1 = new javax.swing.ButtonGroup();
        Tombol2 = new javax.swing.ButtonGroup();
        Tombol3 = new javax.swing.ButtonGroup();
        Tombol4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Refresh = new javax.swing.JButton();
        Panel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelAntrian1 = new javax.swing.JTable();
        Antrian1 = new javax.swing.JRadioButton();
        Dibuat1 = new javax.swing.JRadioButton();
        Selesai1 = new javax.swing.JRadioButton();
        Panel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelAntrian2 = new javax.swing.JTable();
        Antrian2 = new javax.swing.JRadioButton();
        Dibuat2 = new javax.swing.JRadioButton();
        Selesai2 = new javax.swing.JRadioButton();
        Panel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelAntrian3 = new javax.swing.JTable();
        Antrian3 = new javax.swing.JRadioButton();
        Dibuat3 = new javax.swing.JRadioButton();
        Selesai3 = new javax.swing.JRadioButton();
        Panel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelAntrian4 = new javax.swing.JTable();
        Antrian4 = new javax.swing.JRadioButton();
        Dibuat4 = new javax.swing.JRadioButton();
        Selesai4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        Refresh.setBackground(new java.awt.Color(204, 204, 204));
        Refresh.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Refresh.setText("Refresh");
        Refresh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        Panel1.setBackground(java.awt.Color.lightGray);
        Panel1.setPreferredSize(new java.awt.Dimension(400, 350));

        TabelAntrian1.setBackground(new java.awt.Color(255, 204, 255));
        TabelAntrian1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Meja", "Nama", "Menu", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelAntrian1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(TabelAntrian1);

        Tombol1.add(Antrian1);
        Antrian1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Antrian1.setText("Antrian");
        Antrian1.setToolTipText("");
        Antrian1.setName(""); // NOI18N
        Antrian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Antrian1ActionPerformed(evt);
            }
        });

        Tombol1.add(Dibuat1);
        Dibuat1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Dibuat1.setText("Dibuat");
        Dibuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dibuat1ActionPerformed(evt);
            }
        });

        Tombol1.add(Selesai1);
        Selesai1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Selesai1.setText("Selesai");
        Selesai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Selesai1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Antrian1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dibuat1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Selesai1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(169, 169, 169))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Antrian1)
                .addGap(18, 18, 18)
                .addComponent(Dibuat1)
                .addGap(18, 18, 18)
                .addComponent(Selesai1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Panel2.setBackground(java.awt.Color.lightGray);
        Panel2.setName(""); // NOI18N
        Panel2.setPreferredSize(new java.awt.Dimension(400, 350));

        TabelAntrian2.setBackground(new java.awt.Color(255, 204, 255));
        TabelAntrian2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Meja", "Nama", "Menu", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelAntrian2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(TabelAntrian2);

        Tombol2.add(Antrian2);
        Antrian2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Antrian2.setText("Antrian");
        Antrian2.setToolTipText("");
        Antrian2.setName(""); // NOI18N
        Antrian2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Antrian2ActionPerformed(evt);
            }
        });

        Tombol2.add(Dibuat2);
        Dibuat2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Dibuat2.setText("Dibuat");
        Dibuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dibuat2ActionPerformed(evt);
            }
        });

        Tombol2.add(Selesai2);
        Selesai2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Selesai2.setText("Selesai");
        Selesai2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Selesai2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Antrian2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dibuat2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Selesai2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(169, 169, 169))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Antrian2)
                .addGap(18, 18, 18)
                .addComponent(Dibuat2)
                .addGap(18, 18, 18)
                .addComponent(Selesai2)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        Panel3.setBackground(java.awt.Color.lightGray);
        Panel3.setPreferredSize(new java.awt.Dimension(400, 350));

        TabelAntrian3.setBackground(new java.awt.Color(255, 204, 255));
        TabelAntrian3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Meja", "Nama", "Menu", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelAntrian3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(TabelAntrian3);

        Tombol3.add(Antrian3);
        Antrian3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Antrian3.setText("Antrian");
        Antrian3.setToolTipText("");
        Antrian3.setName(""); // NOI18N
        Antrian3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Antrian3ActionPerformed(evt);
            }
        });

        Tombol3.add(Dibuat3);
        Dibuat3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Dibuat3.setText("Dibuat");
        Dibuat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dibuat3ActionPerformed(evt);
            }
        });

        Tombol3.add(Selesai3);
        Selesai3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Selesai3.setText("Selesai");
        Selesai3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Selesai3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(Panel3Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Antrian3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dibuat3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Selesai3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(169, 169, 169))
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Antrian3)
                .addGap(18, 18, 18)
                .addComponent(Dibuat3)
                .addGap(18, 18, 18)
                .addComponent(Selesai3)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        Panel4.setBackground(java.awt.Color.lightGray);
        Panel4.setPreferredSize(new java.awt.Dimension(400, 350));

        TabelAntrian4.setBackground(new java.awt.Color(255, 204, 255));
        TabelAntrian4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Meja", "Nama", "Menu", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelAntrian4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(TabelAntrian4);

        Tombol4.add(Antrian4);
        Antrian4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Antrian4.setText("Antrian");
        Antrian4.setToolTipText("");
        Antrian4.setName(""); // NOI18N
        Antrian4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Antrian4ActionPerformed(evt);
            }
        });

        Tombol4.add(Dibuat4);
        Dibuat4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Dibuat4.setText("Dibuat");
        Dibuat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dibuat4ActionPerformed(evt);
            }
        });

        Tombol4.add(Selesai4);
        Selesai4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Selesai4.setText("Selesai");
        Selesai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Selesai4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel4Layout = new javax.swing.GroupLayout(Panel4);
        Panel4.setLayout(Panel4Layout);
        Panel4Layout.setHorizontalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(Panel4Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Antrian4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dibuat4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Selesai4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(169, 169, 169))
        );
        Panel4Layout.setVerticalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Antrian4)
                .addGap(18, 18, 18)
                .addComponent(Dibuat4)
                .addGap(18, 18, 18)
                .addComponent(Selesai4)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(369, Short.MAX_VALUE)
                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(369, 369, 369))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(565, Short.MAX_VALUE)
                .addComponent(Refresh)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        Panel1.setBackground(Color.lightGray);
        Panel2.setBackground(Color.lightGray);
        Panel3.setBackground(Color.lightGray);
        Panel4.setBackground(Color.lightGray);
        Tombol1.clearSelection();
        Tombol2.clearSelection();
        Tombol3.clearSelection();
        Tombol4.clearSelection();
        koneksi();
        DisplayTabel();
    }//GEN-LAST:event_RefreshActionPerformed

    private void Antrian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Antrian1ActionPerformed
        // TODO add your handling code here:
        if(Antrian1.isEnabled()){
            Panel1.setBackground(Color.cyan);
        }
        StatusAntrian(0);
    }//GEN-LAST:event_Antrian1ActionPerformed

    private void Antrian2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Antrian2ActionPerformed
        // TODO add your handling code here:
        if(Antrian2.isEnabled()){
            Panel2.setBackground(Color.cyan);
        }
        StatusAntrian(1);
    }//GEN-LAST:event_Antrian2ActionPerformed

    private void Antrian3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Antrian3ActionPerformed
        // TODO add your handling code here:
        if(Antrian3.isEnabled()){
            Panel3.setBackground(Color.cyan);
        }
        StatusAntrian(2);
    }//GEN-LAST:event_Antrian3ActionPerformed

    private void Antrian4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Antrian4ActionPerformed
        // TODO add your handling code here:
        if(Antrian4.isEnabled()){
            Panel4.setBackground(Color.cyan);
        }
        StatusAntrian(3);
    }//GEN-LAST:event_Antrian4ActionPerformed

    private void Dibuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dibuat1ActionPerformed
        // TODO add your handling code here:
        if(Dibuat1.isEnabled()){
            Panel1.setBackground(Color.green);
        }
        StatusDibuat(0);
    }//GEN-LAST:event_Dibuat1ActionPerformed

    private void Dibuat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dibuat2ActionPerformed
        // TODO add your handling code here:
        if(Dibuat2.isEnabled()){
            Panel2.setBackground(Color.green);
        }
        StatusDibuat(1);
    }//GEN-LAST:event_Dibuat2ActionPerformed

    private void Dibuat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dibuat3ActionPerformed
        // TODO add your handling code here:
        if(Dibuat3.isEnabled()){
            Panel3.setBackground(Color.green);
        }
        StatusDibuat(2);
    }//GEN-LAST:event_Dibuat3ActionPerformed

    private void Dibuat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dibuat4ActionPerformed
        // TODO add your handling code here:
        if(Dibuat4.isEnabled()){
            Panel4.setBackground(Color.green);
        }
        StatusDibuat(3);
    }//GEN-LAST:event_Dibuat4ActionPerformed

    private void Selesai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Selesai1ActionPerformed
        // TODO add your handling code here:
        if(Selesai1.isEnabled()){
            Panel1.setBackground(Color.red);
        }
        StatusSelesai(0);
    }//GEN-LAST:event_Selesai1ActionPerformed

    private void Selesai2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Selesai2ActionPerformed
        // TODO add your handling code here:
        if(Selesai2.isEnabled()){
            Panel2.setBackground(Color.red);
        }
        StatusSelesai(1);
    }//GEN-LAST:event_Selesai2ActionPerformed

    private void Selesai3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Selesai3ActionPerformed
        // TODO add your handling code here:
        if(Selesai3.isEnabled()){
            Panel3.setBackground(Color.red);
        }
        StatusSelesai(2);
    }//GEN-LAST:event_Selesai3ActionPerformed

    private void Selesai4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Selesai4ActionPerformed
        // TODO add your handling code here:
        if(Selesai4.isEnabled()){
            Panel4.setBackground(Color.red);
        }
        StatusSelesai(3);
    }//GEN-LAST:event_Selesai4ActionPerformed

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
            java.util.logging.Logger.getLogger(Kitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kitchen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Antrian1;
    private javax.swing.JRadioButton Antrian2;
    private javax.swing.JRadioButton Antrian3;
    private javax.swing.JRadioButton Antrian4;
    private javax.swing.JRadioButton Dibuat1;
    private javax.swing.JRadioButton Dibuat2;
    private javax.swing.JRadioButton Dibuat3;
    private javax.swing.JRadioButton Dibuat4;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JButton Refresh;
    private javax.swing.JRadioButton Selesai1;
    private javax.swing.JRadioButton Selesai2;
    private javax.swing.JRadioButton Selesai3;
    private javax.swing.JRadioButton Selesai4;
    private javax.swing.JTable TabelAntrian1;
    private javax.swing.JTable TabelAntrian2;
    private javax.swing.JTable TabelAntrian3;
    private javax.swing.JTable TabelAntrian4;
    private javax.swing.ButtonGroup Tombol1;
    private javax.swing.ButtonGroup Tombol2;
    private javax.swing.ButtonGroup Tombol3;
    private javax.swing.ButtonGroup Tombol4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}

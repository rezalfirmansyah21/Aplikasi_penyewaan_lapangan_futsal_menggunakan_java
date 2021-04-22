/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksiData.koneksi;
import org.freixas.jcalendar.JCalendarCombo;
import java.text.SimpleDateFormat;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import koneksiData.koneksilaporan;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;


/**
 *
 * @author LENOVO-PC
 */
public class menu extends javax.swing.JFrame {
    String username = session.getUserLogin();
    private ArrayList<JPanel> menus = new ArrayList<>();
    private Color primaryColor = new Color(0,51,153);
    private Color primaryColorHover = new Color(0,51,204);
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmodefp;
    private DefaultTableModel tabmodefpm;
    private DefaultTableModel tabmodeadmin;
    
    Statement st;
    ResultSet rs;
    java.util.Date tglsekarang = new java.util.Date();
    private SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private String tanggal = smpdtfmt.format(tglsekarang);
    
    java.util.Date tglsekarang1 = new java.util.Date();
    private SimpleDateFormat smpdtfmt1 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
    private String tanggal1 = smpdtfmt1.format(tglsekarang1);

    /**
     * Creates new form
     */
    public menu() {
        initComponents();
        txtuser.setText(username);
        initHome();
        setMenus();
        hargaperjam();
        datatablefp();
        datatablememberfp();
        datatablemember();
        datatableadmin();
        calendarfp.setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); //yyyy-MM-dd
        calendar1fm.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        calendar2fm.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        setLocationRelativeTo(this);
        tgl.setText(tanggal);
        tgl1.setText(tanggal1);
        setJam();
        kosongfp();
        kosongfm();
        tampil_combo();
        autonumber();
        automember();
        autotransaksi();
        autotransmember();

    }
    
    
    
     public void autotransmember() {
        try {
            String sql = "SELECT * FROM transmember ORDER BY notransmember DESC";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String noid = rs.getString("notransmember").substring(3);
                String AN = "" + (Integer.parseInt(noid) + 1);
                String Nol = "";

                if(AN.length()==1)
                    {Nol = "000";
                }else if(AN.length()==2){
                    Nol = "00";
                }else if(AN.length()==3){
                    Nol = "0";
                }else if(AN.length()==4){
                    Nol = "";
                }
                txtnotransmember.setText("T" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                txtnotransmember.setText("T0001");//sesuaikan dengan variable namenya
            }
//            rs.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }
    
     public void autotransaksi() {
        try {
            String sql = "SELECT * FROM transaksi ORDER BY notransaksi DESC";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String noid = rs.getString("notransaksi").substring(3);
                String AN = "" + (Integer.parseInt(noid) + 1);
                String Nol = "";

                if(AN.length()==1)
                    {Nol = "000";
                }else if(AN.length()==2){
                    Nol = "00";
                }else if(AN.length()==3){
                    Nol = "0";
                }else if(AN.length()==4){
                    Nol = "";
                }
                txtnotransaksi.setText("T" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                txtnotransaksi.setText("T0001");//sesuaikan dengan variable namenya
            }
//            rs.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }
    
     public void autonumber() {
        try {
            String sql = "SELECT * FROM pemesanan ORDER BY faktur DESC";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String noid = rs.getString("faktur").substring(3);
                String AN = "" + (Integer.parseInt(noid) + 1);
                String Nol = "";

                if(AN.length()==1)
                    {Nol = "000";
                }else if(AN.length()==2){
                    Nol = "00";
                }else if(AN.length()==3){
                    Nol = "0";
                }else if(AN.length()==4){
                    Nol = "";
                }
                txtktpfp.setText("P" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                txtktpfp.setText("P0001");//sesuaikan dengan variable namenya
            }
//            rs.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }
     
     public void automember() {
        try {
            String sql = "SELECT * FROM member ORDER BY faktur DESC";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String noid = rs.getString("faktur").substring(3);
                String AN = "" + (Integer.parseInt(noid) + 1);
                String Nol = "";

                if(AN.length()==1)
                    {Nol = "000";
                }else if(AN.length()==2){
                    Nol = "00";
                }else if(AN.length()==3){
                    Nol = "0";
                }else if(AN.length()==4){
                    Nol = "";
                }
                txtfaktur.setText("M" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                txtfaktur.setText("M0001");//sesuaikan dengan variable namenya
            }
//            rs.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    } 
    
    public void tampil_combo()
      {
          try{
              Connection conn = new koneksi().connect();
              Statement st = conn.createStatement();
              String sql = "select paket from tab_paket order by paket asc";
              ResultSet rs = st.executeQuery(sql);
              
              while(rs.next()){
                  Object[] ob = new Object[3];
                  ob[0] = rs.getString(1);
                  
                  cpaket.addItem((String) ob[0]);
              }
              rs.close(); st.close(); 
          }catch(Exception e){
              System.out.println(e.getMessage());
              
          }
      }
      
      public void tampil()
      {
          try{
              Connection conn = new koneksi().connect();
              Statement st = conn.createStatement();
              String sql = "select bulan,jam,harga from tab_paket where paket='"+cpaket.getSelectedItem()+"'";
              ResultSet rs = st.executeQuery(sql);
              
              while(rs.next()){
                  Object[] ob = new Object[3];
                  ob[0] = rs.getString(1);
                  ob[1] = rs.getString(2);
                  ob[2] = rs.getString(3);
                  
                  txtdurasibulan.setText((String) ob[0]);
                  txtdurasijam.setText((String) ob[1]);
                  txthargafm.setText((String) ob[2]);
              }
              rs.close(); st.close();
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
      }
      
       protected void datatableadmin(){
        Object[] Baris ={"nik","username","password","nama","level"};
        tabmodeadmin = new DefaultTableModel(null, Baris);
        tabeladmin.setModel(tabmodeadmin);
        String sql = "select * from admin";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nik");
                String b = hasil.getString("username");
                String c = hasil.getString("password");
                String d = hasil.getString("nama_admin");
                String e = hasil.getString("level");
             
                String[] data={a,b,c,d,e};
                tabmodeadmin.addRow(data);
            }
        } catch (Exception e){
    }
    }
 
    protected void datatablemember(){
        Object[] Baris ={"No member","nama","telp","alamat","paket","harga","tanggal mulai","tanggal selesai","hari","jam mulai","jam akhir","lapangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelfm.setModel(tabmode);
        String sql = "select * from member";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("faktur");
                String b = hasil.getString("nama");
                String c = hasil.getString("telp");
                String d = hasil.getString("alamat");
                String e = hasil.getString("paket");
                String f = hasil.getString("harga");
                String g = hasil.getString("tanggalmulai");
                String h = hasil.getString("tanggalselesai");
                String i = hasil.getString("hari");
                String j = hasil.getString("jammulai");
                String k = hasil.getString("jamakhir");
                String l = hasil.getString("lapangan");
               
                
                
                
                String[] data={a,b,c,d,e,f,g,h,i,j,k,l};
                tabmode.addRow(data);
            }
        } catch (Exception e){
    }
    }
    
    protected void datatablefp(){
        Object[] Baris ={"No Faktur","nama","telp","alamat","mulai","selesai","tanggal","lapangan","jammain","biaya","uangmuka","sisabayar"};
        tabmodefp = new DefaultTableModel(null, Baris);
        tabelfp.setModel(tabmodefp);
        String sql = "select * from pemesanan";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("faktur");
                String b = hasil.getString("nama");
                String c = hasil.getString("telp");
                String d = hasil.getString("alamat");
                String e = hasil.getString("mulai");
                String f = hasil.getString("selesai");
                String g = hasil.getString("tanggal");
                String h = hasil.getString("lapangan");
                String i = hasil.getString("jammain");
                String j = hasil.getString("biaya");
                String k = hasil.getString("uangmuka");
                String l = hasil.getString("sisabayar");
               
                String[] data={a,b,c,d,e,f,g,h,i,j,k,l};
                tabmodefp.addRow(data);
            }
        } catch (Exception e){
    }
    }
    
    protected void datatablememberfp(){
        Object[] Baris ={"No member","nama","telp","alamat","paket","harga","tanggal mulai","tanggal selesai","hari","jam mulai","jam akhir","lapangan"};
        tabmodefpm = new DefaultTableModel(null, Baris);
        tabelmemberfp.setModel(tabmodefpm);
        String sql = "select * from member";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("faktur");
                String b = hasil.getString("nama");
                String c = hasil.getString("telp");
                String d = hasil.getString("alamat");
                String e = hasil.getString("paket");
                String f = hasil.getString("harga");
                String g = hasil.getString("tanggalmulai");
                String h = hasil.getString("tanggalselesai");
                String i = hasil.getString("hari");
                String j = hasil.getString("jammulai");
                String k = hasil.getString("jamakhir");
                String l = hasil.getString("lapangan");
            
                String[] data={a,b,c,d,e,f,g,h,i,j,k,l};
                tabmodefpm.addRow(data);
            }
        } catch (Exception e){
    }
    }
    
    
    
     protected void aktif() {
        txtktpfp.setEnabled(true);
         txtnamafp.setEnabled(true);
         txttelpfp.setEnabled(true);
          txtalamatfp.setEnabled(true);
          txtjammainfp.setEnabled(true);
          txtbiayafp.setEnabled(true);
          txtuangmukafp.setEnabled(true);
          txtsisabayarfp.setEnabled(true);
          txthargaperjamfp.setEnabled(true);
          txtktpfp.requestFocus();
    }
    
    protected void kosongfp() {
        txtktpfp.setText("");
        txtnamafp.setText("");
        txttelpfp.setText("");
        txtalamatfp.setText("");
        clapanganfp.setSelectedItem(0);
        cjammulaifp.setSelectedItem(0);
        cjamselesaifp.setSelectedItem(0);
        txtjammainfp.setText("");
        txtbiayafp.setText("");
        txtcarifp.setText("");
         txtuangmukafp.setText("");
         txtsisabayarfp.setText("");
       // calendarfp.setDate(null);
        
    }
    
    protected void kosongfm(){
     
        txtnamafm.setText("");
        txttelpfm.setText("");
        txtalamatfm.setText("");
        cpaket.setSelectedItem(0);
        txtdurasibulan.setText("");
        txtdurasijam.setText("");
        txthargafm.setText("");
//        calendar1fm.setDate(null);
//        calendar2fm.setDate(null);
        charifm.setSelectedItem(0);
        cjammulaifm.setSelectedItem(0);
        cjamselesaifm.setSelectedItem(0);
        clapanganfm.setSelectedItem(0);
    }
    
   
    
   
     public final void setJam(){
ActionListener taskPerformer = new ActionListener() {

            @Override
public void actionPerformed(ActionEvent evt) {
String nol_jam = "", nol_menit = "",nol_detik = "";

java.util.Date dateTime = new java.util.Date();
int nilai_jam = dateTime.getHours();
int nilai_menit = dateTime.getMinutes();
int nilai_detik = dateTime.getSeconds();

if(nilai_jam <= 9) nol_jam= "0";
if(nilai_menit <= 9) nol_menit= "0";
if(nilai_detik <= 9) nol_detik= "0";

String jam = nol_jam + Integer.toString(nilai_jam);
String menit = nol_menit + Integer.toString(nilai_menit);
String detik = nol_detik + Integer.toString(nilai_detik);

lblwaktu.setText(jam+":"+menit+":"+detik+"");
}
};
new Timer(1000, taskPerformer).start();
}
       
     public void hargaperjam() {
     
     try {
            st = conn.createStatement();
     
            rs = st.executeQuery("select * from harga where hargaperjam");
            while(rs.next()) {
             String hg = rs.getString("hargaperjam");    
                txthargaperjamfp.setText(hg);
   
            }
        } catch(Exception e) {
            
        }
    }  
     
    private void resetActiveMenu() {
        menus.forEach(menu -> menu.setBackground(primaryColor));
       
    }
   
     
    private void setActiveMenu(JPanel menu) {
        resetActiveMenu();
        menu.setBackground(primaryColorHover);
    }
    
    private void setMenus() {
        menus.add(btnhome);
        menus.add(btnpenyewaan);
        menus.add(btnmember);
        menus.add(btntransaksi);
      //  menus.add(btndashboard);
        menus.add(btnlaporan);
        
    }
    
    private void initHome() {
       setActiveMenu(btnhome); 
       setActivePanel(panelcontent, pnlhome);
    }
    
    private void setActivePanel(JPanel parentPanel, JPanel panel) {
        parentPanel.removeAll();
        parentPanel.repaint();
        parentPanel.revalidate();
        parentPanel.add(panel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        sb = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnpenyewaan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnhome = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btnmember = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btntransaksi = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        btnlaporan = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        btnexit = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        lblwaktu = new javax.swing.JLabel();
        tgl1 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        btnuser = new javax.swing.JPanel();
        txtuser = new javax.swing.JLabel();
        panelcontent = new javax.swing.JPanel();
        pnlhome = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        pnlpemesanan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelfp = new javax.swing.JTable();
        bsavefp = new javax.swing.JButton();
        bdeletefp = new javax.swing.JButton();
        bclearfp = new javax.swing.JButton();
        bcarimemberfp = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JSeparator();
        txtcarimemberfp = new javax.swing.JTextField();
        beditsp = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelmemberfp = new javax.swing.JTable();
        txtcarifp = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        bcarifp = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        txtnamafp = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        txttelpfp = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        txtalamatfp = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        clapanganfp = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        bjammainfp = new javax.swing.JButton();
        txtjammainfp = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        bsisabayarfp = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        cjammulaifp = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cjamselesaifp = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        bbiayafp = new javax.swing.JButton();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        txtuangmukafp = new javax.swing.JTextField();
        jSeparator23 = new javax.swing.JSeparator();
        txthargaperjamfp = new javax.swing.JLabel();
        txtbiayafp = new javax.swing.JLabel();
        txtsisabayarfp = new javax.swing.JLabel();
        calendarfp = new org.freixas.jcalendar.JCalendarCombo();
        txtktpfp = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        pnlmember = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelfm = new javax.swing.JTable();
        bsave = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtcarifm = new javax.swing.JTextField();
        bcarifm = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtnamafm = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txtalamatfm = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cpaket = new javax.swing.JComboBox<>();
        txtdurasibulan = new javax.swing.JLabel();
        txtdurasijam = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txthargafm = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cjammulaifm = new javax.swing.JComboBox<>();
        clapanganfm = new javax.swing.JComboBox<>();
        charifm = new javax.swing.JComboBox<>();
        cjamselesaifm = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txttelpfm = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        calendar1fm = new org.freixas.jcalendar.JCalendarCombo();
        calendar2fm = new org.freixas.jcalendar.JCalendarCombo();
        txtfaktur = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        pnllaporan = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnlaporanpenyewa = new javax.swing.JButton();
        btnlaporanmember = new javax.swing.JButton();
        btnlaporantransaksi = new javax.swing.JButton();
        btnlaporantransmember = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        pnltransaksi = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtnotransaksi = new javax.swing.JLabel();
        txtfakturtransaksi = new javax.swing.JLabel();
        txtnamatransaksi = new javax.swing.JLabel();
        txttglmaintransaksi = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtlapangantransaksi = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtbayartransaksi = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtjammaintransaksi = new javax.swing.JLabel();
        txtbiayatransaksi = new javax.swing.JLabel();
        txtumtransaksi = new javax.swing.JLabel();
        txtsisabayartransaksi = new javax.swing.JLabel();
        txtkembalitransaksi = new javax.swing.JLabel();
        txtcaritransaksi = new javax.swing.JTextField();
        btncaritransaksi = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        btncetaktransaksi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtcaritransmember = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        btncaritransmember = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        btncetaktransmember = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtnotransmember = new javax.swing.JLabel();
        txtnomember = new javax.swing.JLabel();
        txtnamatransmember = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtkembalitransmember = new javax.swing.JLabel();
        txtpakettransmember = new javax.swing.JLabel();
        txthargatransmember = new javax.swing.JLabel();
        txtbayartransmember = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        pnldashboard = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        txtcariadmin = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        btncaripaket = new javax.swing.JButton();
        jSeparator27 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel53 = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        jLabel54 = new javax.swing.JLabel();
        jSeparator30 = new javax.swing.JSeparator();
        btnsavep = new javax.swing.JButton();
        btnedditp = new javax.swing.JButton();
        btndeletep = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeladmin = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        jSeparator31 = new javax.swing.JSeparator();
        txtnik = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        txtnamaadmin = new javax.swing.JTextField();
        txtlevel = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        sb.setBackground(new java.awt.Color(0, 51, 153));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AL-YAMIN FUTSAL");

        btnpenyewaan.setBackground(new java.awt.Color(0, 51, 153));
        btnpenyewaan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpenyewaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpenyewaanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnpenyewaanMouseEntered(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sewa.png"))); // NOI18N
        jLabel3.setText("Pemesanan");
        jLabel3.setIconTextGap(12);

        javax.swing.GroupLayout btnpenyewaanLayout = new javax.swing.GroupLayout(btnpenyewaan);
        btnpenyewaan.setLayout(btnpenyewaanLayout);
        btnpenyewaanLayout.setHorizontalGroup(
            btnpenyewaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpenyewaanLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnpenyewaanLayout.setVerticalGroup(
            btnpenyewaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpenyewaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnhome.setBackground(new java.awt.Color(0, 51, 153));
        btnhome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhomeMouseExited(evt);
            }
        });

        jLabel156.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 255, 255));
        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homeicon.png"))); // NOI18N
        jLabel156.setText("Menu Utama");
        jLabel156.setIconTextGap(12);

        javax.swing.GroupLayout btnhomeLayout = new javax.swing.GroupLayout(btnhome);
        btnhome.setLayout(btnhomeLayout);
        btnhomeLayout.setHorizontalGroup(
            btnhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnhomeLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel156)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnhomeLayout.setVerticalGroup(
            btnhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnhomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel156)
                .addContainerGap())
        );

        btnmember.setBackground(new java.awt.Color(0, 51, 153));
        btnmember.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmemberMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmemberMouseEntered(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/member.png"))); // NOI18N
        jLabel6.setText("Anggota");
        jLabel6.setIconTextGap(12);

        javax.swing.GroupLayout btnmemberLayout = new javax.swing.GroupLayout(btnmember);
        btnmember.setLayout(btnmemberLayout);
        btnmemberLayout.setHorizontalGroup(
            btnmemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnmemberLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnmemberLayout.setVerticalGroup(
            btnmemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnmemberLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btntransaksi.setBackground(new java.awt.Color(0, 51, 153));
        btntransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntransaksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntransaksiMouseEntered(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transaksi.png"))); // NOI18N
        jLabel61.setText("Transaksi");
        jLabel61.setIconTextGap(12);

        javax.swing.GroupLayout btntransaksiLayout = new javax.swing.GroupLayout(btntransaksi);
        btntransaksi.setLayout(btntransaksiLayout);
        btntransaksiLayout.setHorizontalGroup(
            btntransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btntransaksiLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel61)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btntransaksiLayout.setVerticalGroup(
            btntransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btntransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnlaporan.setBackground(new java.awt.Color(0, 51, 153));
        btnlaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlaporanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlaporanMouseEntered(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        jLabel80.setText("Laporan");
        jLabel80.setIconTextGap(12);

        javax.swing.GroupLayout btnlaporanLayout = new javax.swing.GroupLayout(btnlaporan);
        btnlaporan.setLayout(btnlaporanLayout);
        btnlaporanLayout.setHorizontalGroup(
            btnlaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnlaporanLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel80)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnlaporanLayout.setVerticalGroup(
            btnlaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnlaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnexit.setBackground(new java.awt.Color(0, 51, 153));
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexitMouseClicked(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jLabel84.setText("Keluar");
        jLabel84.setIconTextGap(12);

        javax.swing.GroupLayout btnexitLayout = new javax.swing.GroupLayout(btnexit);
        btnexit.setLayout(btnexitLayout);
        btnexitLayout.setHorizontalGroup(
            btnexitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnexitLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnexitLayout.setVerticalGroup(
            btnexitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnexitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel84)
                .addContainerGap())
        );

        lblwaktu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblwaktu.setForeground(new java.awt.Color(255, 255, 255));
        lblwaktu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/jam.png"))); // NOI18N
        lblwaktu.setText("jam");
        lblwaktu.setIconTextGap(12);

        tgl1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tgl1.setForeground(new java.awt.Color(255, 255, 255));
        tgl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tanggal.png"))); // NOI18N
        tgl1.setText("tanggal");
        tgl1.setIconTextGap(12);

        tgl.setBackground(new java.awt.Color(0, 51, 153));
        tgl.setForeground(new java.awt.Color(0, 51, 153));

        btnuser.setBackground(new java.awt.Color(0, 51, 153));
        btnuser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnuserMouseClicked(evt);
            }
        });

        txtuser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtuser.setForeground(new java.awt.Color(255, 255, 255));
        txtuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        txtuser.setText("Pengguna");
        txtuser.setIconTextGap(12);

        javax.swing.GroupLayout btnuserLayout = new javax.swing.GroupLayout(btnuser);
        btnuser.setLayout(btnuserLayout);
        btnuserLayout.setHorizontalGroup(
            btnuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnuserLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(txtuser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnuserLayout.setVerticalGroup(
            btnuserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnuserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtuser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sbLayout = new javax.swing.GroupLayout(sb);
        sb.setLayout(sbLayout);
        sbLayout.setHorizontalGroup(
            sbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnpenyewaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnhome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnmember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btntransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnlaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sbLayout.createSequentialGroup()
                .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sbLayout.createSequentialGroup()
                .addGroup(sbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sbLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2))
                    .addGroup(sbLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sbLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(sbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tgl1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(lblwaktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(btnuser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sbLayout.setVerticalGroup(
            sbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sbLayout.createSequentialGroup()
                .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnhome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnpenyewaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnmember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tgl1)
                .addGap(18, 18, 18)
                .addComponent(lblwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelcontent.setBackground(new java.awt.Color(255, 255, 255));
        panelcontent.setLayout(new java.awt.CardLayout());

        pnlhome.setBackground(new java.awt.Color(255, 255, 255));
        pnlhome.setPreferredSize(new java.awt.Dimension(800, 680));
        pnlhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Al - Yamin Futsal");
        pnlhome.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 390, -1));

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bb.jpg"))); // NOI18N
        pnlhome.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        panelcontent.add(pnlhome, "card2");

        pnlpemesanan.setBackground(new java.awt.Color(255, 255, 255));
        pnlpemesanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 660));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 153));
        jLabel20.setText("Menu Pemesanan");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 153));
        jLabel21.setText("Tabel Anggota");

        tabelfp.setAutoCreateRowSorter(true);
        tabelfp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabelfp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelfp.setGridColor(new java.awt.Color(255, 255, 255));
        tabelfp.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tabelfp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelfpMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelfp);

        bsavefp.setBackground(new java.awt.Color(255, 255, 255));
        bsavefp.setForeground(new java.awt.Color(0, 51, 153));
        bsavefp.setText("Simpan");
        bsavefp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsavefpActionPerformed(evt);
            }
        });

        bdeletefp.setBackground(new java.awt.Color(255, 255, 255));
        bdeletefp.setForeground(new java.awt.Color(0, 51, 153));
        bdeletefp.setText("Hapus");
        bdeletefp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeletefpActionPerformed(evt);
            }
        });

        bclearfp.setBackground(new java.awt.Color(255, 255, 255));
        bclearfp.setForeground(new java.awt.Color(0, 51, 153));
        bclearfp.setText("Bersih");
        bclearfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearfpActionPerformed(evt);
            }
        });

        bcarimemberfp.setBackground(new java.awt.Color(255, 255, 255));
        bcarimemberfp.setForeground(new java.awt.Color(0, 51, 153));
        bcarimemberfp.setText("Cari");
        bcarimemberfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarimemberfpActionPerformed(evt);
            }
        });

        jSeparator18.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator18.setForeground(new java.awt.Color(255, 255, 255));

        txtcarimemberfp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcarimemberfp.setForeground(new java.awt.Color(0, 51, 153));
        txtcarimemberfp.setBorder(null);
        txtcarimemberfp.setCaretColor(new java.awt.Color(0, 51, 153));

        beditsp.setBackground(new java.awt.Color(255, 255, 255));
        beditsp.setForeground(new java.awt.Color(0, 51, 153));
        beditsp.setText("Ubah");
        beditsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditspActionPerformed(evt);
            }
        });

        tabelmemberfp.setAutoCreateRowSorter(true);
        tabelmemberfp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabelmemberfp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelmemberfp.setGridColor(new java.awt.Color(255, 255, 255));
        tabelmemberfp.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tabelmemberfp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelmemberfpMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelmemberfp);

        txtcarifp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcarifp.setForeground(new java.awt.Color(0, 51, 153));
        txtcarifp.setBorder(null);
        txtcarifp.setCaretColor(new java.awt.Color(0, 51, 153));
        txtcarifp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarifpActionPerformed(evt);
            }
        });

        jSeparator19.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator19.setForeground(new java.awt.Color(255, 255, 255));

        bcarifp.setBackground(new java.awt.Color(255, 255, 255));
        bcarifp.setForeground(new java.awt.Color(0, 51, 153));
        bcarifp.setText("Cari");
        bcarifp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarifpActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 153));
        jLabel25.setText("No faktur :");

        jSeparator11.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 153));
        jLabel26.setText("Nama          :");

        txtnamafp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnamafp.setForeground(new java.awt.Color(0, 51, 153));
        txtnamafp.setBorder(null);
        txtnamafp.setCaretColor(new java.awt.Color(0, 51, 153));

        jSeparator12.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 153));
        jLabel27.setText("No Telp     :");

        txttelpfp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txttelpfp.setForeground(new java.awt.Color(0, 51, 153));
        txttelpfp.setBorder(null);
        txttelpfp.setCaretColor(new java.awt.Color(0, 51, 153));

        jSeparator13.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 51, 153));
        jLabel28.setText("Alamat      :");

        txtalamatfp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtalamatfp.setForeground(new java.awt.Color(0, 51, 153));
        txtalamatfp.setBorder(null);
        txtalamatfp.setCaretColor(new java.awt.Color(0, 51, 153));

        jSeparator14.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 51, 153));
        jLabel29.setText("Tanggal     :");

        clapanganfp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B" }));
        clapanganfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clapanganfpActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 51, 153));
        jLabel30.setText("Lapangan  :");

        bjammainfp.setBackground(new java.awt.Color(255, 255, 255));
        bjammainfp.setForeground(new java.awt.Color(0, 51, 153));
        bjammainfp.setText("Jam main");
        bjammainfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bjammainfpActionPerformed(evt);
            }
        });

        txtjammainfp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtjammainfp.setForeground(new java.awt.Color(0, 51, 153));
        txtjammainfp.setBorder(null);
        txtjammainfp.setCaretColor(new java.awt.Color(0, 51, 153));

        jSeparator15.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));

        bsisabayarfp.setBackground(new java.awt.Color(255, 255, 255));
        bsisabayarfp.setForeground(new java.awt.Color(0, 51, 153));
        bsisabayarfp.setText("sisabayar");
        bsisabayarfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsisabayarfpActionPerformed(evt);
            }
        });

        jSeparator20.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator20.setForeground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 153));
        jLabel31.setText("Jam mulai   :");

        cjammulaifp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        cjammulaifp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cjammulaifpActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 51, 153));
        jLabel32.setText("s/d");

        cjamselesaifp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 51, 153));
        jLabel33.setText("Harga Perjam :");

        jSeparator21.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));

        bbiayafp.setBackground(new java.awt.Color(255, 255, 255));
        bbiayafp.setForeground(new java.awt.Color(0, 51, 153));
        bbiayafp.setText("biaya");
        bbiayafp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbiayafpActionPerformed(evt);
            }
        });

        jSeparator22.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator22.setForeground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 51, 153));
        jLabel34.setText("Uang Muka :");

        txtuangmukafp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtuangmukafp.setForeground(new java.awt.Color(0, 51, 153));
        txtuangmukafp.setBorder(null);
        txtuangmukafp.setCaretColor(new java.awt.Color(0, 51, 153));

        jSeparator23.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator23.setForeground(new java.awt.Color(255, 255, 255));

        txthargaperjamfp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txthargaperjamfp.setForeground(new java.awt.Color(0, 51, 153));
        txthargaperjamfp.setText("...");

        txtbiayafp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtbiayafp.setForeground(new java.awt.Color(0, 51, 153));
        txtbiayafp.setText("....");

        txtsisabayarfp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsisabayarfp.setForeground(new java.awt.Color(0, 51, 153));
        txtsisabayarfp.setText(".....");

        txtktpfp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtktpfp.setForeground(new java.awt.Color(0, 51, 153));
        txtktpfp.setText("............");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(txtktpfp))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(clapanganfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtalamatfp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(bbiayafp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbiayafp))))
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtnamafp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtuangmukafp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(bjammainfp)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtjammainfp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(bsisabayarfp))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtsisabayarfp)
                                                    .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txthargaperjamfp)))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(calendarfp, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttelpfp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(32, 32, 32))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cjammulaifp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(cjamselesaifp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtktpfp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(txtnamafp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(txttelpfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(cjammulaifp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cjamselesaifp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32)
                        .addComponent(jLabel29)
                        .addComponent(calendarfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtalamatfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(clapanganfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel34)
                                        .addComponent(txtuangmukafp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bbiayafp))
                                    .addComponent(txtbiayafp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bjammainfp)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtjammainfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(txthargaperjamfp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bsisabayarfp)
                            .addComponent(txtsisabayarfp))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 51, 153));
        jLabel51.setText("Tabel pemesanan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtcarifp, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcarifp, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator18)
                            .addComponent(txtcarimemberfp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcarimemberfp, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bsavefp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(beditsp, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bdeletefp, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bclearfp, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(212, 212, 212))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcarifp)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcarifp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bclearfp)
                    .addComponent(bsavefp)
                    .addComponent(beditsp)
                    .addComponent(bdeletefp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcarimemberfp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bcarimemberfp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlpemesanan.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 670));

        panelcontent.add(pnlpemesanan, "card2");

        pnlmember.setBackground(new java.awt.Color(255, 255, 255));
        pnlmember.setPreferredSize(new java.awt.Dimension(800, 680));
        pnlmember.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 680));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setText("Menu Anggota");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        tabelfm.setAutoCreateRowSorter(true);
        tabelfm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tabelfm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelfm.setGridColor(new java.awt.Color(255, 255, 255));
        tabelfm.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tabelfm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelfmMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelfm);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 750, 277));

        bsave.setBackground(new java.awt.Color(255, 255, 255));
        bsave.setForeground(new java.awt.Color(0, 51, 153));
        bsave.setText("Simpan");
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });
        jPanel1.add(bsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 170, -1));

        bdelete.setBackground(new java.awt.Color(255, 255, 255));
        bdelete.setForeground(new java.awt.Color(0, 51, 153));
        bdelete.setText("Hapus");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(bdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, 180, -1));

        bclear.setBackground(new java.awt.Color(255, 255, 255));
        bclear.setForeground(new java.awt.Color(0, 51, 153));
        bclear.setText("Bersih");
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });
        jPanel1.add(bclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, 170, -1));

        bedit.setBackground(new java.awt.Color(255, 255, 255));
        bedit.setForeground(new java.awt.Color(0, 51, 153));
        bedit.setText("Ubah");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 170, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 153));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(976, 5, 22, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 153));
        jLabel17.setText("Tabel Anggota");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        txtcarifm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcarifm.setForeground(new java.awt.Color(0, 51, 153));
        txtcarifm.setBorder(null);
        txtcarifm.setCaretColor(new java.awt.Color(0, 51, 153));
        txtcarifm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcarifmActionPerformed(evt);
            }
        });
        jPanel1.add(txtcarifm, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 220, 20));

        bcarifm.setBackground(new java.awt.Color(255, 255, 255));
        bcarifm.setForeground(new java.awt.Color(0, 51, 153));
        bcarifm.setText("Cari");
        bcarifm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarifmActionPerformed(evt);
            }
        });
        jPanel1.add(bcarifm, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 87, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("No Anggota");

        jSeparator1.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 153));
        jLabel8.setText("Nama      :");

        txtnamafm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtnamafm.setForeground(new java.awt.Color(0, 51, 153));
        txtnamafm.setBorder(null);
        txtnamafm.setCaretColor(new java.awt.Color(0, 51, 153));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 153));
        jLabel10.setText("Alamat       :");

        txtalamatfm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtalamatfm.setForeground(new java.awt.Color(0, 51, 153));
        txtalamatfm.setBorder(null);
        txtalamatfm.setCaretColor(new java.awt.Color(0, 51, 153));

        jSeparator4.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 153));
        jLabel13.setText("Durasi    :");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 153));
        jLabel14.setText("Harga         :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 153));
        jLabel11.setText("Paket      :");

        cpaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih paket-" }));
        cpaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpaketActionPerformed(evt);
            }
        });

        txtdurasibulan.setForeground(new java.awt.Color(0, 51, 153));
        txtdurasibulan.setText(".....");

        txtdurasijam.setForeground(new java.awt.Color(0, 51, 153));
        txtdurasijam.setText("....");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 153));
        jLabel24.setText("&");

        txthargafm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txthargafm.setForeground(new java.awt.Color(0, 51, 153));
        txthargafm.setText("..........");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 51, 153));
        jLabel36.setText("Tanggal   :");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 51, 153));
        jLabel37.setText("s/d");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 51, 153));
        jLabel38.setText("Hari          :");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 51, 153));
        jLabel39.setText("Jam        :");

        cjammulaifm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        cjammulaifm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cjammulaifmActionPerformed(evt);
            }
        });

        clapanganfm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B" }));

        charifm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));

        cjamselesaifm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        cjamselesaifm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cjamselesaifmActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 51, 153));
        jLabel41.setText("s/d");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 153));
        jLabel15.setText("Telpon    :");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 153));
        jLabel16.setText("Lapangan :");

        txttelpfm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txttelpfm.setForeground(new java.awt.Color(0, 51, 153));
        txttelpfm.setBorder(null);
        txttelpfm.setCaretColor(new java.awt.Color(0, 51, 153));

        jSeparator6.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        txtfaktur.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtfaktur.setForeground(new java.awt.Color(0, 51, 153));
        txtfaktur.setText(".............");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfaktur)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(charifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtalamatfm, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txthargafm))))
                                .addGap(49, 49, 49)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpaket, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtnamafm, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(cjammulaifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addComponent(cjamselesaifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendar1fm, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clapanganfm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(txtdurasibulan)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel24)
                            .addGap(19, 19, 19)
                            .addComponent(txtdurasijam))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(40, 40, 40)
                                .addComponent(calendar2fm, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttelpfm, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtdurasibulan)
                                    .addComponent(jLabel24)
                                    .addComponent(txtdurasijam)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txttelpfm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(calendar2fm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clapanganfm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtfaktur))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtalamatfm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtnamafm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cpaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txthargafm)
                            .addComponent(jLabel36)
                            .addComponent(calendar1fm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(charifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cjammulaifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cjamselesaifm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))))
                .addGap(64, 64, 64))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 750, 190));

        jSeparator24.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator24.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 290, 220, 10));

        pnlmember.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 680));

        panelcontent.add(pnlmember, "card2");

        pnllaporan.setBackground(new java.awt.Color(255, 255, 255));
        pnllaporan.setPreferredSize(new java.awt.Dimension(800, 680));
        pnllaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel9.setForeground(new java.awt.Color(0, 0, 153));

        btnlaporanpenyewa.setBackground(new java.awt.Color(255, 255, 255));
        btnlaporanpenyewa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnlaporanpenyewa.setForeground(new java.awt.Color(0, 51, 153));
        btnlaporanpenyewa.setText("Laporan Pemesanan");
        btnlaporanpenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanpenyewaActionPerformed(evt);
            }
        });

        btnlaporanmember.setBackground(new java.awt.Color(255, 255, 255));
        btnlaporanmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnlaporanmember.setForeground(new java.awt.Color(0, 51, 153));
        btnlaporanmember.setText("Laporan Anggota");
        btnlaporanmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanmemberActionPerformed(evt);
            }
        });

        btnlaporantransaksi.setBackground(new java.awt.Color(255, 255, 255));
        btnlaporantransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnlaporantransaksi.setForeground(new java.awt.Color(0, 51, 153));
        btnlaporantransaksi.setText("Laporan Transaksi");
        btnlaporantransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporantransaksiActionPerformed(evt);
            }
        });

        btnlaporantransmember.setBackground(new java.awt.Color(255, 255, 255));
        btnlaporantransmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnlaporantransmember.setForeground(new java.awt.Color(0, 51, 153));
        btnlaporantransmember.setText("Laporan Transaksi Anggota");
        btnlaporantransmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporantransmemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlaporantransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlaporantransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlaporanmember, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlaporanpenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnlaporanpenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnlaporanmember, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnlaporantransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnlaporantransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pnllaporan.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 710, 530));

        jLabel79.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 51, 153));
        jLabel79.setText("Form laporan");
        pnllaporan.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        panelcontent.add(pnllaporan, "card2");

        pnltransaksi.setBackground(new java.awt.Color(255, 255, 255));
        pnltransaksi.setPreferredSize(new java.awt.Dimension(800, 680));
        pnltransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 153));
        jLabel12.setText("Transaksi pemesan");

        jSeparator3.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 153));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 153));
        jLabel18.setText("Nomor transaksi  :");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 153));
        jLabel19.setText("Nomor pemesan   :");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 153));
        jLabel22.setText("Nama                   :");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 153));
        jLabel23.setText("Tanggal main       :");

        txtnotransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnotransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtnotransaksi.setText("............");

        txtfakturtransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtfakturtransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtfakturtransaksi.setText("............");

        txtnamatransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnamatransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtnamatransaksi.setText("............");

        txttglmaintransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttglmaintransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txttglmaintransaksi.setText("............");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 51, 153));
        jLabel44.setText("Lapangan       :");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 51, 153));
        jLabel45.setText("Jam bermain  :");

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 153));
        jLabel46.setText("Biaya              :");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 51, 153));
        jLabel47.setText("Uang muka     :");

        txtlapangantransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtlapangantransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtlapangantransaksi.setText("..........");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 51, 153));
        jLabel49.setText("Sisa bayar   :");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 51, 153));
        jLabel50.setText("Bayar          :");

        txtbayartransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtbayartransaksi.setForeground(new java.awt.Color(0, 0, 153));
        txtbayartransaksi.setBorder(null);

        jSeparator7.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 153));

        txtjammaintransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtjammaintransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtjammaintransaksi.setText("..........");

        txtbiayatransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtbiayatransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtbiayatransaksi.setText("..........");

        txtumtransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtumtransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtumtransaksi.setText("..........");

        txtsisabayartransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsisabayartransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtsisabayartransaksi.setText("..........");

        txtkembalitransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtkembalitransaksi.setForeground(new java.awt.Color(0, 51, 153));
        txtkembalitransaksi.setText("..........");

        txtcaritransaksi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcaritransaksi.setForeground(new java.awt.Color(0, 0, 153));
        txtcaritransaksi.setBorder(null);

        btncaritransaksi.setBackground(new java.awt.Color(255, 255, 255));
        btncaritransaksi.setForeground(new java.awt.Color(0, 0, 153));
        btncaritransaksi.setText("Cari");
        btncaritransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaritransaksiActionPerformed(evt);
            }
        });

        jSeparator8.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 153));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 153));
        jButton2.setText("Selesai transaksi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btncetaktransaksi.setBackground(new java.awt.Color(255, 255, 255));
        btncetaktransaksi.setForeground(new java.awt.Color(0, 0, 153));
        btncetaktransaksi.setText("Cetak");
        btncetaktransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetaktransaksiActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnamatransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfakturtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnotransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttglmaintransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtlapangantransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtjammaintransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel46)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtbiayatransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel49)
                                            .addComponent(jLabel50)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(txtbayartransaksi)
                                    .addComponent(txtsisabayartransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtkembalitransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtumtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btncetaktransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator8)
                            .addComponent(txtcaritransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncaritransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(294, 294, 294))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcaritransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncaritransaksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtlapangantransaksi)
                    .addComponent(jLabel49)
                    .addComponent(txtsisabayartransaksi)
                    .addComponent(txtnotransaksi)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel50)
                    .addComponent(txtbayartransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjammaintransaksi)
                    .addComponent(jLabel19)
                    .addComponent(txtfakturtransaksi))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtkembalitransaksi)
                            .addComponent(jButton1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txtbiayatransaksi)
                            .addComponent(txtnamatransaksi)
                            .addComponent(jLabel22))))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txttglmaintransaksi)
                    .addComponent(jLabel47)
                    .addComponent(txtumtransaksi))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btncetaktransaksi))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pnltransaksi.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 740, 300));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Menu Transaksi");
        pnltransaksi.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 51, 153));
        jLabel58.setText("Transaksi Anggota");

        jSeparator9.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 153));

        txtcaritransmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcaritransmember.setForeground(new java.awt.Color(0, 0, 153));
        txtcaritransmember.setBorder(null);

        jSeparator10.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 153));

        btncaritransmember.setBackground(new java.awt.Color(255, 255, 255));
        btncaritransmember.setForeground(new java.awt.Color(0, 0, 153));
        btncaritransmember.setText("Cari");
        btncaritransmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaritransmemberActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 51, 153));
        jLabel59.setText("Nomor transaksi  :");

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 51, 153));
        jLabel60.setText("Nomor Anggota   :");

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 51, 153));
        jLabel62.setText("Nama                   :");

        btncetaktransmember.setBackground(new java.awt.Color(255, 255, 255));
        btncetaktransmember.setForeground(new java.awt.Color(0, 0, 153));
        btncetaktransmember.setText("Cetak");
        btncetaktransmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetaktransmemberActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(0, 0, 153));
        jButton5.setText("Selesai transaksi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtnotransmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnotransmember.setForeground(new java.awt.Color(0, 51, 153));
        txtnotransmember.setText("...........");

        txtnomember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnomember.setForeground(new java.awt.Color(0, 51, 153));
        txtnomember.setText("...........");

        txtnamatransmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnamatransmember.setForeground(new java.awt.Color(0, 51, 153));
        txtnamatransmember.setText("...........");

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 51, 153));
        jLabel66.setText("Paket        :");

        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 51, 153));
        jLabel67.setText("Harga        :");

        jLabel68.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 51, 153));
        jLabel68.setText("Bayar        :");

        txtkembalitransmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtkembalitransmember.setForeground(new java.awt.Color(0, 51, 153));
        txtkembalitransmember.setText("............");

        txtpakettransmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtpakettransmember.setForeground(new java.awt.Color(0, 51, 153));
        txtpakettransmember.setText("...........");

        txthargatransmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txthargatransmember.setForeground(new java.awt.Color(0, 51, 153));
        txthargatransmember.setText("...........");

        txtbayartransmember.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtbayartransmember.setForeground(new java.awt.Color(0, 0, 153));
        txtbayartransmember.setBorder(null);

        jSeparator16.setBackground(new java.awt.Color(0, 51, 153));
        jSeparator16.setForeground(new java.awt.Color(0, 0, 153));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(0, 0, 153));
        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btncetaktransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel59)
                                .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnotransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnomember, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnamatransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(75, 75, 75)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel66)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtpakettransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel67)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txthargatransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel68)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtbayartransmember))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jButton4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator16, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                        .addComponent(txtkembalitransmember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(txtcaritransmember))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btncaritransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(151, 151, 151))))
                .addGap(38, 38, 38))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcaritransmember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncaritransmember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtnotransmember)
                    .addComponent(jLabel66)
                    .addComponent(jLabel68)
                    .addComponent(txtpakettransmember)
                    .addComponent(txtbayartransmember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtkembalitransmember)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel60)
                        .addComponent(txtnomember)
                        .addComponent(jLabel67)
                        .addComponent(txthargatransmember)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txtnamatransmember))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(btncetaktransmember))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnltransaksi.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 740, 270));

        panelcontent.add(pnltransaksi, "card2");

        pnldashboard.setBackground(new java.awt.Color(255, 255, 255));
        pnldashboard.setPreferredSize(new java.awt.Dimension(800, 680));
        pnldashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setForeground(new java.awt.Color(0, 0, 153));
        jButton6.setText("Harga & Paket");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pnldashboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 720, 90));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 153));
        jLabel42.setText("Admin");

        jSeparator25.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator25.setForeground(new java.awt.Color(0, 0, 153));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 153));
        jLabel43.setText("Username    :");

        txtcariadmin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcariadmin.setForeground(new java.awt.Color(0, 0, 153));
        txtcariadmin.setBorder(null);

        jSeparator17.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator17.setForeground(new java.awt.Color(0, 0, 153));

        btncaripaket.setBackground(new java.awt.Color(255, 255, 255));
        btncaripaket.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btncaripaket.setForeground(new java.awt.Color(0, 0, 153));
        btncaripaket.setText("Cari");
        btncaripaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaripaketActionPerformed(evt);
            }
        });

        jSeparator27.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator27.setForeground(new java.awt.Color(0, 0, 153));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 153));
        jLabel48.setText("Nama          :");

        jSeparator28.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator28.setForeground(new java.awt.Color(0, 0, 153));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 153));
        jLabel53.setText("Password    :");

        jSeparator29.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator29.setForeground(new java.awt.Color(0, 0, 153));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 153));
        jLabel54.setText("Level           :");

        jSeparator30.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator30.setForeground(new java.awt.Color(0, 0, 153));

        btnsavep.setBackground(new java.awt.Color(255, 255, 255));
        btnsavep.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnsavep.setForeground(new java.awt.Color(0, 0, 153));
        btnsavep.setText("Save");
        btnsavep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsavepActionPerformed(evt);
            }
        });

        btnedditp.setBackground(new java.awt.Color(255, 255, 255));
        btnedditp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnedditp.setForeground(new java.awt.Color(0, 0, 153));
        btnedditp.setText("Edit");
        btnedditp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedditpActionPerformed(evt);
            }
        });

        btndeletep.setBackground(new java.awt.Color(255, 255, 255));
        btndeletep.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btndeletep.setForeground(new java.awt.Color(0, 0, 153));
        btndeletep.setText("Delete");
        btndeletep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletepActionPerformed(evt);
            }
        });

        tabeladmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabeladmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeladminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeladmin);

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 153));
        jLabel55.setText("Nik             :");

        jSeparator31.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator31.setForeground(new java.awt.Color(0, 0, 153));

        txtnik.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnik.setForeground(new java.awt.Color(0, 0, 153));
        txtnik.setBorder(null);

        txtusername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtusername.setForeground(new java.awt.Color(0, 0, 153));
        txtusername.setBorder(null);

        txtpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(0, 0, 153));
        txtpassword.setBorder(null);

        txtnamaadmin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnamaadmin.setForeground(new java.awt.Color(0, 0, 153));
        txtnamaadmin.setBorder(null);

        txtlevel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtlevel.setForeground(new java.awt.Color(0, 0, 153));
        txtlevel.setBorder(null);
        txtlevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlevelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator17, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtcariadmin))
                            .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addComponent(btncaripaket, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel55)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(txtnik))))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel53)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtpassword)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel54)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtlevel)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addComponent(btnsavep, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnedditp, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(btndeletep, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel48)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnamaadmin, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel43)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator27, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtusername)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcariadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncaripaket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel55))
                            .addComponent(txtnik, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel43)
                            .addComponent(txtusername, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel53)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel48)
                                .addComponent(txtnamaadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtlevel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndeletep)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnsavep)
                        .addComponent(btnedditp)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pnldashboard.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 720, 470));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 153));
        jLabel52.setText("Form Dashboard");
        pnldashboard.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 180, -1));

        panelcontent.add(pnldashboard, "card2");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(sb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelcontent, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelcontent, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnpenyewaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpenyewaanMouseClicked
        // TODO add your handling code here:
        setActiveMenu(btnpenyewaan);
        setActivePanel(panelcontent, pnlpemesanan);
    }//GEN-LAST:event_btnpenyewaanMouseClicked

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        // TODO add your handling code here:
        setActiveMenu(btnhome);
        setActivePanel(panelcontent, pnlhome);
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseEntered
        // TODO add your handling code here:
//       setActiveMenu(btnhome);
    }//GEN-LAST:event_btnhomeMouseEntered

    private void btnhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseExited
        // TODO add your handling code here:
        //    btnhome.setBackground(Color.decode("#003399"));
  //      resetActiveMenu();
    }//GEN-LAST:event_btnhomeMouseExited

    private void btnmemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmemberMouseClicked
        // TODO add your handling code here:
        setActiveMenu(btnmember);
        setActivePanel(panelcontent, pnlmember);
    }//GEN-LAST:event_btnmemberMouseClicked

    private void btntransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntransaksiMouseClicked
        // TODO add your handling code here:
        setActiveMenu(btntransaksi);
        setActivePanel(panelcontent, pnltransaksi);
    }//GEN-LAST:event_btntransaksiMouseClicked

    private void btnlaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlaporanMouseClicked
        // TODO add your handling code here:
        setActiveMenu(btnlaporan);
        setActivePanel(panelcontent, pnllaporan);
    }//GEN-LAST:event_btnlaporanMouseClicked

    private void btnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnexitMouseClicked

    private void btnuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnuserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnuserMouseClicked

    private void tabelfpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelfpMouseClicked
        // TODO add your handling code here:
        int bar = tabelfp.getSelectedRow();
        String a = tabmodefp.getValueAt(bar, 0).toString();
        String b = tabmodefp.getValueAt(bar, 1).toString();
        String c = tabmodefp.getValueAt(bar, 2).toString();
        String d = tabmodefp.getValueAt(bar, 3).toString();
        String e = tabmodefp.getValueAt(bar, 4).toString();
        String f = tabmodefp.getValueAt(bar, 5).toString();
        String g = tabmodefp.getValueAt(bar, 6).toString();
        String h = tabmodefp.getValueAt(bar, 7).toString();
        String i = tabmodefp.getValueAt(bar, 8).toString();
        String j = tabmodefp.getValueAt(bar, 9).toString();
        String k = tabmodefp.getValueAt(bar, 10).toString();
        String l = tabmodefp.getValueAt(bar, 11).toString();

        txtktpfp.setText(a);
        txtnamafp.setText(b);
        txttelpfp.setText(c);
        txtalamatfp.setText(d);
        cjammulaifp.setSelectedItem(e);
        cjamselesaifp.setSelectedItem(f);
        calendarfp.setSelectedItem(g);
        clapanganfp.setSelectedItem(h);
        txtjammainfp.setText(i);
        txtbiayafp.setText(j);
        txtuangmukafp.setText(k);
        txtsisabayarfp.setText(l);
    }//GEN-LAST:event_tabelfpMouseClicked

    private void bsavefpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsavefpActionPerformed
        // TODO add your handling code here:
        String sql = "insert into pemesanan values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, txtktpfp.getText());
            stat.setString(2, txtnamafp.getText());
            stat.setString(3, txttelpfp.getText());
            stat.setString(4, txtalamatfp.getText());
            stat.setString(5, cjammulaifp.getSelectedItem().toString());
            stat.setString(6, cjamselesaifp.getSelectedItem().toString());
            stat.setString(7, calendarfp.getSelectedItem().toString());
            stat.setString(8, clapanganfp.getSelectedItem().toString());
            stat.setString(9, txtjammainfp.getText());
            stat.setString(10, txtbiayafp.getText());
            stat.setString(11, txtuangmukafp.getText());
            stat.setString(12, txtsisabayarfp.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosongfp();
            txtktpfp.requestFocus();
            datatablefp();
            autonumber();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);
        }
    }//GEN-LAST:event_bsavefpActionPerformed

    private void bdeletefpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeletefpActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql ="delete from pemesanan where faktur ='"+txtktpfp.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil di hapus");
                kosongfp();
                txtktpfp.requestFocus();
                datatablefp();
                autonumber();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bdeletefpActionPerformed

    private void bclearfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearfpActionPerformed
        // TODO add your handling code here:
        kosongfp();
    }//GEN-LAST:event_bclearfpActionPerformed

    private void bcarimemberfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarimemberfpActionPerformed
        // TODO add your handling code here:
        String cari = txtcarimemberfp.getText();
        Object[] Baris ={"faktur","nama","telp","alamat","paket","harga","tanggalmulai","tanggalselesai","hari","jammulai","jamakhir","lapangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelmemberfp.setModel(tabmode);
        String sql = ("select * from member where faktur like'%"+cari+"%'"+ "or hari like '%"+cari+"%'");
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                String a = hasil.getString("faktur");
                String b = hasil.getString("nama");
                String c = hasil.getString("telp");
                String d = hasil.getString("alamat");
                String e = hasil.getString("paket");
                String f = hasil.getString("harga");
                String g = hasil.getString("tanggalmulai");
                String h = hasil.getString("tanggalselesai");
                String i = hasil.getString("hari");
                String j = hasil.getString("jammulai");
                String k = hasil.getString("jamakhir");
                String l = hasil.getString("lapangan");

                String[] data={a,b,c,d,e,f,g,h,i,j,k,l};
                tabmode.addRow(data);
            }else{
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
        }catch (Exception e){
        }
    }//GEN-LAST:event_bcarimemberfpActionPerformed

    private void beditspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditspActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "update pemesanan set nama=?,telp=?,alamat=?,mulai=?,selesai=?,tanggal=?,lapangan=?,jammain=?,biaya=?,uangmuka=?,sisabayar=? where faktur=?";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, txtnamafp.getText());
            stat.setString(2, txttelpfp.getText());
            stat.setString(3, txtalamatfp.getText());
            stat.setString(4, cjammulaifp.getSelectedItem().toString());
            stat.setString(5, cjamselesaifp.getSelectedItem().toString());
            stat.setString(6, calendarfp.getSelectedItem().toString());
            stat.setString(7, clapanganfp.getSelectedItem().toString());
            stat.setString(8, txtjammainfp.getText());
            stat.setString(9, txtbiayafp.getText());
            stat.setString(10, txtuangmukafp.getText());
            stat.setString(11, txtsisabayarfp.getText());
            stat.setString(12, txtktpfp.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosongfp();
            txtktpfp.requestFocus();
            datatablefp();

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
        }
    }//GEN-LAST:event_beditspActionPerformed

    private void tabelmemberfpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelmemberfpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelmemberfpMouseClicked

    private void txtcarifpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarifpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcarifpActionPerformed

    private void bcarifpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarifpActionPerformed
        // TODO add your handling code here:
        //         String sql = "select * from pemesanan where ktp like '%"+txtcarifp.getText()+"%'";
        //        try {
            //            java.sql.Statement stat = conn.createStatement();
            //            ResultSet aa = stat.executeQuery(sql);
            //            if (aa.next()){
                //                String a  = aa.getString("ktp");
                //                String b  = aa.getString("nama");
                //                String c = aa.getString("telp");
                //                String d = aa.getString("alamat");
                //                String e = aa.getString("mulai");
                //                String f = aa.getString("selesai");
                //                String g = aa.getString("tanggal");
                //                String h = aa.getString("lapangan");
                //                String i = aa.getString("jammain");
                //                String j = aa.getString("biaya");
                //                String k = aa.getString("uangmuka");
                //                String l = aa.getString("sisabayar");
                //                txtktpfp.setText(a);
                //                txtnamafp.setText(b);
                //                txttelpfp.setText(c);
                //                txtalamatfp.setText(d);
                //                cjammulaifp.setSelectedItem(e);
                //                cjamselesaifp.setSelectedItem(f);
                //                calendarfp.setSelectedItem(g);
                //                clapanganfp.setSelectedItem(h);
                //                txtjammainfp.setText(i);
                //                txtbiayafp.setText(j);
                //                txtuangmukafp.setText(k);
                //                txtsisabayarfp.setText(l);
                //
                //            }else{
                //                JOptionPane.showMessageDialog(this,"Nik Belum terdaftar");
                //            }
            //        }
        //        catch(Exception e){
            //
            //        }
        String cari = txtcarifp.getText();
        Object[] Baris ={"No Faktur","nama","telp","alamat","mulai","selesai","tanggal","lapangan","jammain","biaya","uangmuka","sisabayar"};
        tabmodefp = new DefaultTableModel(null, Baris);
        tabelfp.setModel(tabmodefp);
        String sql = ("select * from pemesanan where faktur like'%"+cari+"%'");
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                String a = hasil.getString("faktur");
                String b = hasil.getString("nama");
                String c = hasil.getString("telp");
                String d = hasil.getString("alamat");
                String e = hasil.getString("mulai");
                String f = hasil.getString("selesai");
                String g = hasil.getString("tanggal");
                String h = hasil.getString("lapangan");
                String i = hasil.getString("jammain");
                String j = hasil.getString("biaya");
                String k = hasil.getString("uangmuka");
                String l = hasil.getString("sisabayar");

                String[] data={a,b,c,d,e,f,g,h,i,j,k,l};
                tabmodefp.addRow(data);

            }else{
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
        }catch (Exception e){
        }
    }//GEN-LAST:event_bcarifpActionPerformed

    private void clapanganfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clapanganfpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clapanganfpActionPerformed

    private void bjammainfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bjammainfpActionPerformed
        // TODO add your handling code here:
        int a=Integer.parseInt((String) cjammulaifp.getSelectedItem());
        int b=Integer.parseInt((String) cjamselesaifp.getSelectedItem());
        int hitung=b-a;
        txtjammainfp.setText(String.valueOf(hitung));
    }//GEN-LAST:event_bjammainfpActionPerformed

    private void bsisabayarfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsisabayarfpActionPerformed
        // TODO add your handling code here:
        int a=Integer.parseInt(txtuangmukafp.getText());
        int b=Integer.parseInt(txtbiayafp.getText());
        int hitung=b-a;
        txtsisabayarfp.setText(String.valueOf(hitung));
    }//GEN-LAST:event_bsisabayarfpActionPerformed

    private void cjammulaifpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cjammulaifpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cjammulaifpActionPerformed

    private void bbiayafpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbiayafpActionPerformed
        // TODO add your handling code here:
        int c=Integer.parseInt(txtjammainfp.getText());
        int d=Integer.parseInt(txthargaperjamfp.getText());
        int hitung=c*d;
        txtbiayafp.setText(String.valueOf(hitung));
    }//GEN-LAST:event_bbiayafpActionPerformed

    private void tabelfmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelfmMouseClicked
        // TODO add your handling code here:
        int bar = tabelfm.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        String i = tabmode.getValueAt(bar, 8).toString();
        String j = tabmode.getValueAt(bar, 9).toString();
        String k = tabmode.getValueAt(bar, 10).toString();
        String l = tabmode.getValueAt(bar, 11).toString();

        txtfaktur.setText(a);
        txtnamafm.setText(b);
        txttelpfm.setText(c);
        txtalamatfm.setText(d);
        cpaket.setSelectedItem(e);
        txthargafm.setText(f);
        calendar1fm.setSelectedItem(g);
        calendar2fm.setSelectedItem(h);
        charifm.setSelectedItem(i);
        cjammulaifm.setSelectedItem(j);
        cjamselesaifm.setSelectedItem(k);
        clapanganfm.setSelectedItem(l);
    }//GEN-LAST:event_tabelfmMouseClicked

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        // TODO add your handling code here:
        String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtfaktur.getText());
            stat.setString(2, txtnamafm.getText());
            stat.setString(3, txttelpfm.getText());
            stat.setString(4, txtalamatfm.getText());
            stat.setString(5, cpaket.getSelectedItem().toString());
            stat.setString(6, txthargafm.getText());
            stat.setString(7, calendar1fm.getSelectedItem().toString());
            stat.setString(8, calendar2fm.getSelectedItem().toString());
            stat.setString(9, charifm.getSelectedItem().toString());
            stat.setString(10, cjammulaifm.getSelectedItem().toString());
            stat.setString(11, cjamselesaifm.getSelectedItem().toString());
            stat.setString(12, clapanganfm.getSelectedItem().toString());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosongfm();
            txtfaktur.requestFocus();
            automember();
            datatablemember();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);
        }
    }//GEN-LAST:event_bsaveActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql ="delete from member where faktur ='"+txtfaktur.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil di hapus");
                kosongfm();
                txtfaktur.requestFocus();
                automember();
                datatablemember();
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        // TODO add your handling code here:
        kosongfm();
    }//GEN-LAST:event_bclearActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "update member set nama=?,telp=?,alamat=?,paket=?,harga=?,tanggalmulai=?,tanggalselesai=?,hari=?,jammulai=?,jamakhir=?,lapangan=? where faktur=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtnamafm.getText());
            stat.setString(2, txttelpfm.getText());
            stat.setString(3, txtalamatfm.getText());
            stat.setString(4, cpaket.getSelectedItem().toString());
            stat.setString(5, txthargafm.getText());
            stat.setString(6, calendar1fm.getSelectedItem().toString());
            stat.setString(7, calendar2fm.getSelectedItem().toString());
            stat.setString(8, charifm.getSelectedItem().toString());
            stat.setString(9, cjammulaifm.getSelectedItem().toString());
            stat.setString(10, cjamselesaifm.getSelectedItem().toString());
            stat.setString(11, clapanganfm.getSelectedItem().toString());
            stat.setString(12, txtfaktur.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosongfm();
            txtfaktur.requestFocus();
            datatablemember();

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
        }
    }//GEN-LAST:event_beditActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtcarifmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcarifmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcarifmActionPerformed

    private void bcarifmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarifmActionPerformed
        // TODO add your handling code here:
        String cari = txtcarifm.getText();
        Object[] Baris ={"faktur","nama","telp","alamat","paket","harga","tanggalmulai","tanggalselesai","hari","jammulai","jamakhir","lapangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelfm.setModel(tabmode);
        String sql = ("select * from member where faktur like'%"+cari+"%'");
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                String a = hasil.getString("faktur");
                String b = hasil.getString("nama");
                String c = hasil.getString("telp");
                String d = hasil.getString("alamat");
                String e = hasil.getString("paket");
                String f = hasil.getString("harga");
                String g = hasil.getString("tanggalmulai");
                String h = hasil.getString("tanggalselesai");
                String i = hasil.getString("hari");
                String j = hasil.getString("jammulai");
                String k = hasil.getString("jamakhir");
                String l = hasil.getString("lapangan");

                String[] data={a,b,c,d,e,f,g,h,i,j,k,l};
                tabmode.addRow(data);
            }else{
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
        }catch (Exception e){
        }
    }//GEN-LAST:event_bcarifmActionPerformed

    private void cpaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpaketActionPerformed
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_cpaketActionPerformed

    private void cjammulaifmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cjammulaifmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cjammulaifmActionPerformed

    private void cjamselesaifmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cjamselesaifmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cjamselesaifmActionPerformed

    private void btnlaporanpenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanpenyewaActionPerformed
        // TODO add your handling code here:
        new laporanPemesanan().setVisible(true);
    }//GEN-LAST:event_btnlaporanpenyewaActionPerformed

    private void btnlaporanmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanmemberActionPerformed
        // TODO add your handling code here:
        new laporanMember().setVisible(true);
    }//GEN-LAST:event_btnlaporanmemberActionPerformed

    private void btnlaporantransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporantransaksiActionPerformed
        // TODO add your handling code here:
        new laporanTransaksi().setVisible(true);
    }//GEN-LAST:event_btnlaporantransaksiActionPerformed

    private void btnlaporantransmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporantransmemberActionPerformed
        // TODO add your handling code here:
        new laporanTransmember().setVisible(true);
    }//GEN-LAST:event_btnlaporantransmemberActionPerformed

    private void btncaritransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaritransaksiActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
        
           try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            com.mysql.jdbc.Connection koneksi = (com.mysql.jdbc.Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/futsal", "root", "");
            com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) koneksi.createStatement();
            String sql="SELECT * FROM pemesanan WHERE faktur like '"+txtcaritransaksi.getText()+"'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){

                String fktr = rs.getString("faktur");
                String nmt = rs.getString("nama");
                String tglt = rs.getString("tanggal");
                String lpt = rs.getString("lapangan");
                String jmt = rs.getString("jammain");
                String bmt = rs.getString("biaya");
                String umt = rs.getString("uangmuka");
                String sbt = rs.getString("sisabayar");
               
                txtfakturtransaksi.setText(fktr);
                txtnamatransaksi.setText(nmt);
                txttglmaintransaksi.setText(tglt);
                txtlapangantransaksi.setText(lpt);
                txtjammaintransaksi.setText(jmt);
                txtbiayatransaksi.setText(bmt);
                txtumtransaksi.setText(umt);
                txtsisabayartransaksi.setText(sbt);

            }else{
                JOptionPane.showMessageDialog(null,"Data tidak ditemukan");
                txtfakturtransaksi.setText("");
                txtnamatransaksi.setText("");
                txttglmaintransaksi.setText("");
                txtlapangantransaksi.setText("");
                txtjammaintransaksi.setText("");
                txtbiayatransaksi.setText("");
                txtumtransaksi.setText("");
                txtcaritransaksi.setText("");

                statement.close();
                koneksi.close();
            }
        }catch(Exception ex){
         //   JOptionPane.showMessageDialog(null,"Data tidak ditemukan"+ex);
        }
    }//GEN-LAST:event_btncaritransaksiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String sql = "insert into transaksi values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtnotransaksi.getText());
            stat.setString(2, txtfakturtransaksi.getText());
            stat.setString(3, txtnamatransaksi.getText());
            stat.setString(4, txttglmaintransaksi.getText());
            stat.setString(5, txtlapangantransaksi.getText());
            stat.setString(6, txtjammaintransaksi.getText());
            stat.setString(7, txtbiayatransaksi.getText());
            stat.setString(8, txtumtransaksi.getText());
            stat.setString(9, txtsisabayartransaksi.getText());
            stat.setString(10, txtbayartransaksi.getText());
            stat.setString(11, txtkembalitransaksi.getText());
            stat.setString(12, tgl.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Selesai transaksi");

            txtnotransaksi.requestFocus();

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal transaksi"+e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
  private static String path = System.getProperty("user.dir")+"/src/laporan/";
    private void btncetaktransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetaktransaksiActionPerformed
        // TODO add your handling code here:
          String filename = path+"strukPemesanan.jrxml";
        JasperReport jasrep;
        JasperPrint japri;
        JasperViewer javie = null;
        HashMap param = new HashMap(2);
        JasperDesign jasdes;
        try {
            param.put("user",txtuser.getText());
            param.put("transaksi",txtnotransaksi.getText());
            File report = new File(filename);
            jasdes = JRXmlLoader.load(report);
            jasrep = JasperCompileManager.compileReport(jasdes);
            japri = JasperFillManager.fillReport(jasrep,param,koneksilaporan.getKoneksi());
            javie.viewReport(japri,false);
       autotransaksi();
        } catch (Exception e) {
            System.out.print("gagal ngprint");
        }

    }//GEN-LAST:event_btncetaktransaksiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int a = Integer.valueOf(txtsisabayartransaksi.getText());
        int b = Integer.valueOf(txtbayartransaksi.getText());
        int hitung=b-a;
        txtkembalitransaksi.setText(String.valueOf(hitung));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int a = Integer.valueOf(txthargatransmember.getText());
        int b = Integer.valueOf(txtbayartransmember.getText());
        int hitung=b-a;
        txtkembalitransmember.setText(String.valueOf(hitung));  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btncaritransmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaritransmemberActionPerformed
        // TODO add your handling code here:
         try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            com.mysql.jdbc.Connection koneksi = (com.mysql.jdbc.Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/futsal", "root", "");
            com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) koneksi.createStatement();
            String sql="SELECT * FROM member WHERE faktur like '"+txtcaritransmember.getText()+"'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                String ktptm = rs.getString("faktur");
                String nmtm = rs.getString("nama");
                String pktm = rs.getString("paket");
                String hrgtm = rs.getString("harga");

                txtnomember.setText(ktptm);
                txtnamatransmember.setText(nmtm);
                txtpakettransmember.setText(pktm);
                txthargatransmember.setText(hrgtm);

            }else{
                JOptionPane.showMessageDialog(null,"Data tidak ditemukan");

                statement.close();
                koneksi.close();
            }
        }catch(Exception ex){
         //   JOptionPane.showMessageDialog(null,"Data tidak ditemukan"+ex);
        }
    }//GEN-LAST:event_btncaritransmemberActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         String sql = "insert into transmember values (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtnotransmember.getText());
            stat.setString(2, txtnomember.getText());  
            stat.setString(3, txtnamatransmember.getText());
            stat.setString(4, txtpakettransmember.getText());
            stat.setString(5, txthargatransmember.getText());
            stat.setString(6, txtbayartransmember.getText());
            stat.setString(7, txtkembalitransmember.getText());
            stat.setString(8, tgl.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Selesai transaksi");
         
            txtnotransmember.requestFocus();

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal transaksi"+e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btncetaktransmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetaktransmemberActionPerformed
        // TODO add your handling code here:
              String filename = path+"strukMember.jrxml";
        JasperReport jasrep;
        JasperPrint japri;
        JasperViewer javie = null;
        HashMap param = new HashMap(2);
        JasperDesign jasdes;
        try {
            param.put("user",txtuser.getText());
            param.put("transaksi",txtnotransmember.getText());
            File report = new File(filename);
            jasdes = JRXmlLoader.load(report);
            jasrep = JasperCompileManager.compileReport(jasdes);
            japri = JasperFillManager.fillReport(jasrep,param,koneksilaporan.getKoneksi());
            javie.viewReport(japri,false);
       autotransmember();
        } catch (Exception e) {
            System.out.print("gagal ngprint");
        }

    }//GEN-LAST:event_btncetaktransmemberActionPerformed

    private void btndeletepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletepActionPerformed
        // TODO add your handling code here:
          int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql ="delete from admin where nik ='"+txtnik.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil di hapus");
                txtusername.setText("");
                txtnamaadmin.setText("");
                txtpassword.setText("");
                txtlevel.setText("");
                txtnik.setText("");
                txtnik.requestFocus();
                datatableadmin();
               
              
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_btndeletepActionPerformed

    private void btnedditpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedditpActionPerformed
        // TODO add your handling code here:
           try{
            String sql = "update admin set username=?,password=?,nama_admin=?,level=? where nik=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtusername.getText());
            stat.setString(2, txtpassword.getText());
            stat.setString(3, txtnamaadmin.getText());
            stat.setString(4, txtlevel.getText());
            stat.setString(5, txtnik.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            datatableadmin();
            txtnik.requestFocus();
           
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
        }   
    }//GEN-LAST:event_btnedditpActionPerformed

    private void btnsavepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsavepActionPerformed
        // TODO add your handling code here:
          String sql = "insert into admin values (?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtnik.getText());
            stat.setString(2, txtusername.getText());
            stat.setString(3, txtpassword.getText());
            stat.setString(4, txtnamaadmin.getText());
            stat.setString(5, txtlevel.getText());
         
          
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            txtusername.setText("");
            txtnamaadmin.setText("");
            txtpassword.setText("");
            txtlevel.setText("");
            txtnik.setText("");
            txtnik.requestFocus();
            datatableadmin();
          
          
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);
        }
    }//GEN-LAST:event_btnsavepActionPerformed

    private void btncaripaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaripaketActionPerformed
        // TODO add your handling code here:
        String cari = txtcariadmin.getText();
        Object[] Baris ={"Nik","username","password","nama","level"};
        tabmodeadmin = new DefaultTableModel(null, Baris);
        tabeladmin.setModel(tabmodeadmin);
       String sql = ("select * from admin where nik like'%"+cari+"%'");
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nik");
                String b = hasil.getString("username");
                String c = hasil.getString("password");
                String d = hasil.getString("nama_admin");
                String e = hasil.getString("level");
     
                String[] data={a,b,c,d,e};
                tabmodeadmin.addRow(data);
                
            }
        }catch (Exception e){
        }
    }//GEN-LAST:event_btncaripaketActionPerformed

    private void tabeladminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeladminMouseClicked
        // TODO add your handling code here:
          int bar = tabeladmin.getSelectedRow();
        String a = tabmodeadmin.getValueAt(bar, 0).toString();
        String b = tabmodeadmin.getValueAt(bar, 1).toString();
        String c = tabmodeadmin.getValueAt(bar, 2).toString();
        String d = tabmodeadmin.getValueAt(bar, 3).toString();
        String e = tabmodeadmin.getValueAt(bar, 4).toString();
     
        txtnik.setText(a);
        txtusername.setText(b);
        txtpassword.setText(c);
        txtnamaadmin.setText(d);
        txtlevel.setText(e);
       
    }//GEN-LAST:event_tabeladminMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
//        paket n = new paket();
//        n.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtlevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlevelActionPerformed

    private void btnpenyewaanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpenyewaanMouseEntered
        // TODO add your handling code here:
    //    setActiveMenu(btnpenyewaan);
    }//GEN-LAST:event_btnpenyewaanMouseEntered

    private void btnmemberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmemberMouseEntered
        // TODO add your handling code here:
      //  setActiveMenu(btnmember);
    }//GEN-LAST:event_btnmemberMouseEntered

    private void btntransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntransaksiMouseEntered
        // TODO add your handling code here:
      //  setActiveMenu(btntransaksi);
    }//GEN-LAST:event_btntransaksiMouseEntered

    private void btnlaporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlaporanMouseEntered
        // TODO add your handling code here:
       // setActiveMenu(btnlaporan);
    }//GEN-LAST:event_btnlaporanMouseEntered

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbiayafp;
    private javax.swing.JButton bcarifm;
    private javax.swing.JButton bcarifp;
    private javax.swing.JButton bcarimemberfp;
    private javax.swing.JButton bclear;
    private javax.swing.JButton bclearfp;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bdeletefp;
    private javax.swing.JButton bedit;
    private javax.swing.JButton beditsp;
    private javax.swing.JButton bjammainfp;
    private javax.swing.JButton bsave;
    private javax.swing.JButton bsavefp;
    private javax.swing.JButton bsisabayarfp;
    private javax.swing.JButton btncaripaket;
    private javax.swing.JButton btncaritransaksi;
    private javax.swing.JButton btncaritransmember;
    private javax.swing.JButton btncetaktransaksi;
    private javax.swing.JButton btncetaktransmember;
    private javax.swing.JButton btndeletep;
    private javax.swing.JButton btnedditp;
    private javax.swing.JPanel btnexit;
    private javax.swing.JPanel btnhome;
    private javax.swing.JPanel btnlaporan;
    private javax.swing.JButton btnlaporanmember;
    private javax.swing.JButton btnlaporanpenyewa;
    private javax.swing.JButton btnlaporantransaksi;
    private javax.swing.JButton btnlaporantransmember;
    private javax.swing.JPanel btnmember;
    private javax.swing.JPanel btnpenyewaan;
    private javax.swing.JButton btnsavep;
    private javax.swing.JPanel btntransaksi;
    private javax.swing.JPanel btnuser;
    private org.freixas.jcalendar.JCalendarCombo calendar1fm;
    private org.freixas.jcalendar.JCalendarCombo calendar2fm;
    private org.freixas.jcalendar.JCalendarCombo calendarfp;
    private javax.swing.JComboBox<String> charifm;
    private javax.swing.JComboBox<String> cjammulaifm;
    private javax.swing.JComboBox<String> cjammulaifp;
    private javax.swing.JComboBox<String> cjamselesaifm;
    private javax.swing.JComboBox<String> cjamselesaifp;
    private javax.swing.JComboBox<String> clapanganfm;
    private javax.swing.JComboBox<String> clapanganfp;
    private javax.swing.JComboBox<String> cpaket;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblwaktu;
    private javax.swing.JPanel panelcontent;
    private javax.swing.JPanel pnldashboard;
    private javax.swing.JPanel pnlhome;
    private javax.swing.JPanel pnllaporan;
    private javax.swing.JPanel pnlmember;
    private javax.swing.JPanel pnlpemesanan;
    private javax.swing.JPanel pnltransaksi;
    private javax.swing.JPanel sb;
    private javax.swing.JTable tabeladmin;
    private javax.swing.JTable tabelfm;
    private javax.swing.JTable tabelfp;
    private javax.swing.JTable tabelmemberfp;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel tgl1;
    private javax.swing.JTextField txtalamatfm;
    private javax.swing.JTextField txtalamatfp;
    private javax.swing.JTextField txtbayartransaksi;
    private javax.swing.JTextField txtbayartransmember;
    private javax.swing.JLabel txtbiayafp;
    private javax.swing.JLabel txtbiayatransaksi;
    private javax.swing.JTextField txtcariadmin;
    private javax.swing.JTextField txtcarifm;
    private javax.swing.JTextField txtcarifp;
    private javax.swing.JTextField txtcarimemberfp;
    private javax.swing.JTextField txtcaritransaksi;
    private javax.swing.JTextField txtcaritransmember;
    private javax.swing.JLabel txtdurasibulan;
    private javax.swing.JLabel txtdurasijam;
    private javax.swing.JLabel txtfaktur;
    private javax.swing.JLabel txtfakturtransaksi;
    private javax.swing.JLabel txthargafm;
    private javax.swing.JLabel txthargaperjamfp;
    private javax.swing.JLabel txthargatransmember;
    private javax.swing.JTextField txtjammainfp;
    private javax.swing.JLabel txtjammaintransaksi;
    private javax.swing.JLabel txtkembalitransaksi;
    private javax.swing.JLabel txtkembalitransmember;
    private javax.swing.JLabel txtktpfp;
    private javax.swing.JLabel txtlapangantransaksi;
    private javax.swing.JTextField txtlevel;
    private javax.swing.JTextField txtnamaadmin;
    private javax.swing.JTextField txtnamafm;
    private javax.swing.JTextField txtnamafp;
    private javax.swing.JLabel txtnamatransaksi;
    private javax.swing.JLabel txtnamatransmember;
    private javax.swing.JTextField txtnik;
    private javax.swing.JLabel txtnomember;
    private javax.swing.JLabel txtnotransaksi;
    private javax.swing.JLabel txtnotransmember;
    private javax.swing.JLabel txtpakettransmember;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JLabel txtsisabayarfp;
    private javax.swing.JLabel txtsisabayartransaksi;
    private javax.swing.JTextField txttelpfm;
    private javax.swing.JTextField txttelpfp;
    private javax.swing.JLabel txttglmaintransaksi;
    private javax.swing.JTextField txtuangmukafp;
    private javax.swing.JLabel txtumtransaksi;
    private javax.swing.JLabel txtuser;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}

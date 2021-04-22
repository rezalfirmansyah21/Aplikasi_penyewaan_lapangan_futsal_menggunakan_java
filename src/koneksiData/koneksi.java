/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksiData;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author LENOVO-PC
 */
public class koneksi {
  private Connection koneksi;
    public Connection con;
  public Connection connect(){
    try {
        Class.forName ("com.mysql.jdbc.Driver");
        System.out.println("berhasil koneksi");
    }catch (ClassNotFoundException ex) {
        System.out.println("gagal koneksi"+ex);
    }
    String url = "jdbc:mysql://localhost/futsal";
    try{
        koneksi = DriverManager.getConnection(url,"root","");
        System.out.println("berhasil koneksi database");
    }catch (SQLException ex) {
        System.out.println("gagal koneksi database"+ex);
    }
    return koneksi;
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksiData;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Rima Regiani
 */
public class koneksilaporan {
     private static java.sql.Connection koneksi;
     
      public static java.sql.Connection getKoneksi(){
        if(koneksi == null){
          try{
              String url = "jdbc:mysql://localhost:3306/futsal";
              String user = "root";
              String password = "";
              
              DriverManager.registerDriver(new com.mysql.jdbc.Driver());
              
              koneksi = DriverManager.getConnection(url, user, password);
          }catch(SQLException t){
              System.out.println("Error Membuat Koneksi");
          }  
        }
        return koneksi;

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import javax.swing.JTextField;

/**
 *
 * @author LENOVO-PC
 */
public class session {
    
    private static String username;
    private static String level;
    public static void setUserLogin(String username){
        session.username = username;
    }
    
    public static String getUserLogin(){
        return username;
    }
    
    public static void setLevel(String level){
        session.level = level;
    }
    
    public static String getLevel(){
        return level;
    }

}

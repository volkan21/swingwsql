/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volkan2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author volkan
 */
public class DbHelper {

    private  String username="username";
     private  String password="********";
     private  String dburl="your local path";
    public Connection getconnect() throws SQLException{
        return DriverManager.getConnection(dburl,username,password);
    }
    public void showhata(SQLException e){
        System.out.println("hata oluştu"+e.getMessage());
    }
}
      


package com.nasr.hospital.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Muhamed S. NasR
 * this class is done for connecting Application to the DB 
 * it contains the driver,the connection in a method 
 * and another one for closing the connection after.....
 * 
 */
public class Dao {

    public static Connection getConnection() throws Exception {

        String user1 = "HOSPITAL";
        String pass1 = "01066525584";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        DriverManager.registerDriver(new OracleDriver());

        Connection con = DriverManager.getConnection(url, user1, pass1);

        if (con != null) {
            
            return con;
            
        }

        return null;

    }

    /*public static void main(String[] args) throws Exception {

     getConnection();
     closeConnection(getConnection());

     }*/
    
    public static void closeConnection(Connection con) throws Exception {

        if (con != null) {
            con.close();
            System.out.println("Connection Closed");

        }
    }
}

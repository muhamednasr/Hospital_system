
package com.nasr.hospital.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhamed S. NasR
 */
public class NewClass {

    
    
    public NewClass(){
    
    
    mm();
    
    }
    
    
    public void mm(){
        try {
          Connection con = Dao.getConnection();
          
            PreparedStatement st;
            st=con.prepareCall("select * from users");
            ResultSet rs;
            st.executeQuery();
            rs = st.executeQuery();
              if(rs == null){
                System.out.println("rs null");
            
            }
            else{
            
                System.out.println("not null");
            }
              
            rs.next();
            System.out.println(rs.getString("user_name"));

          
          
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

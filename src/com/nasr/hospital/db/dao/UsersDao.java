package com.nasr.hospital.db.dao;

import com.nasr.hospital.db.type.UsersType;
import com.nasr.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Muhamed S. NasR
 */
public class UsersDao extends Dao implements DaoList<UsersVo> {

    private static UsersDao usersDao;

    private UsersDao() {
    }

    public static UsersDao getInstance() {

        if (usersDao == null) {

            usersDao = new UsersDao();
            System.out.println("daaaaaaaaaaaaaaaaaaaaaao ");

        }
        
        return usersDao;

    }

    @Override
    public List<UsersVo> loadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsersVo getData(UsersVo uv) throws Exception {

Connection con= null;
        UsersVo usersVo = null;
        UsersType usersType = null;
        String sql = "select * from users where user_name ='" + uv.getUserName() + "'and password ='" + uv.getPassword() + "'";
        DriverManager.registerDriver(new OracleDriver());
boolean i ;
        try {
           con = getConnection();
            PreparedStatement st = con.prepareCall(sql);
            st.executeQuery();
            i = st.execute();
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                System.out.println("data is heere");
                System.out.println(rs.getString("user_name"));
             JOptionPane.showMessageDialog(null, i+"");
            }
            else{
                System.out.println("no data ");}
            
            while (rs.next()) {

                usersVo.setId(rs.getInt(1));
                usersVo.setPassword(rs.getString(3));
                usersVo.setUserName(rs.getString(2));
                //System.out.println(rs.getString(4));
                usersType = UsersType.getUserTypeById(rs.getInt(4));

                usersVo.setUsersType(usersType);


            }

rs.close();
st.close();

        } catch (Exception e) {

            System.out.println("dao exception" + e.getMessage());


        }
        finally{
        
        if(usersVo==null){
        
            System.out.println("users vo is nulllllllllllll");
        
        }
        else{System.out.println("users vo is nooooooooooooooooooooot nulllllllllllll");}
        
        
        closeConnection(con);
        
        }





        return usersVo;

    }
}

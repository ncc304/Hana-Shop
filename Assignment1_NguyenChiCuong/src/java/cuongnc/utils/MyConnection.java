/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongnc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author nguye
 */
public class MyConnection {

    public static Connection getConnection() throws Exception {
        Context context = new InitialContext();
        Context tomcatCtx = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatCtx.lookup("DB");
        Connection con = ds.getConnection();
        return con;
    }

    public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws Exception{
        if(rs != null) {
            rs.close();
        }
        if(ps != null){
            ps.close();
        }
        if(con != null){
            con.close();
        }
    }
}

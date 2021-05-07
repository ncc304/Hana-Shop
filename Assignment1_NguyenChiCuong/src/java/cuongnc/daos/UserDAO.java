/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongnc.daos;

import cuongnc.dtos.UserDTO;
import cuongnc.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
public class UserDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public UserDTO checkLogin(String userID, String password) throws Exception {
        String roleID, userName, userAddress, userPhone = null;
        UserDTO dto = null;
        try {
            String sql = "declare @Password nvarchar(50) "
                    + "set @Password = ? "
                    + "Select UserID, UserName, UserAddress, PhoneNum, RoleID From tbl_User Where UserID = ? AND "
                    + "CAST(Password AS varbinary(8)) = CAST(@Password AS varbinary(8))";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                userID = rs.getString("UserID");
                userName = rs.getString("UserName");
                userAddress = rs.getString("UserAddress");
                userPhone = rs.getString("PhoneNum");
                roleID = rs.getString("RoleID");
                dto = new UserDTO(userID, "", userName, userAddress, userPhone, roleID);
            }
        }finally {
            MyConnection.closeConnection(con, ps, rs);
        }
        return dto;
    }

    public boolean checkUserID(String userID) throws Exception {
        boolean check = false;
        try {
            String sql = "Select UserName From tbl_User Where UserID = ? ";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            MyConnection.closeConnection(con, ps, rs);
        }
        return check;
    }

}

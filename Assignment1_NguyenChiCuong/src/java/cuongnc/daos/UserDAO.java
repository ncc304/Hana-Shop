/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongnc.daos;

import cuongnc.dtos.UserDTO;
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
            String sql = "Select UserID, UserName, UserAddress, PhoneNum, RoleID, Password From tbl_User Where UserID = ? AND Password = ?";
            con = cuongnc.utils.MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                userID = rs.getString("UserID");
                userName = rs.getString("UserName");
                userAddress = rs.getString("UserAddress");
                userPhone = rs.getString("PhoneNum");
                roleID = rs.getString("RoleID");
                dto = new UserDTO(userID, "", userName, userAddress, userPhone, roleID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cuongnc.utils.MyConnection.closeConnection();
        }
        return dto;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new UserDAO().checkLogin("admin", "123456"));
    }
}

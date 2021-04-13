/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongnc.daos;

import cuongnc.dtos.CategoryDTO;
import cuongnc.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class CategoryDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<CategoryDTO> getAllCategory() throws Exception{
        List<CategoryDTO> list = new ArrayList<>();
        try {
            String sql = "Select CateID, CateName From tbl_Category";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String cateID = rs.getString("CateID");
                String CateName = rs.getString("CateName");
                CategoryDTO dto = new CategoryDTO(cateID, CateName);
                list.add(dto);
            }
        } finally{
            MyConnection.closeConnection(con, ps, rs);
        }
        return list;
    }
    
    
}

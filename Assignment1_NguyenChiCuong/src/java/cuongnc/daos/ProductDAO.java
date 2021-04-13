/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongnc.daos;

import cuongnc.dtos.ProductDTO;
import cuongnc.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nguye
 */
public class ProductDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ProductDTO> loadTable() throws Exception {
        List<ProductDTO> list = new ArrayList();
        try {
            String sql = "Select ProductID, ProductName, Price, Quantity, Status, Image, Description, CreateDate, CateID "
                    + "From tbl_Product ";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ProductID");
                String proName = rs.getString("ProductName");
                float proPrice = rs.getFloat("Price");
                int proQuantity = rs.getInt("Quantity");
                boolean proStatus = rs.getBoolean("Status");
                String proImg = rs.getString("Image");
                String proDescription = rs.getString("Description");
                Date proCreateDate = rs.getDate("CreateDate");
                String cateID = rs.getString("CateID");
                ProductDTO dto = new ProductDTO(id, proName, proPrice, proQuantity, proStatus, proImg, proDescription, proCreateDate, cateID);
                list.add(dto);
            }
        } finally {
            MyConnection.closeConnection(con, ps, rs);
        }
        return list;
    }

    public ProductDTO findProductByID(String idProduct) throws Exception {
        ProductDTO dto = null;
        try {
            String sql = "Select ProductName,Price,Quantity,Status,Image,Description,CreateDate,CateID From tbl_Product "
                    + "Where ProductID = ?";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idProduct);
            rs = ps.executeQuery();
            while (rs.next()) {
                String proName = rs.getString("ProductName");
                float proPrice = rs.getFloat("Price");
                int proQuantity = rs.getInt("Quantity");
                boolean proStatus = rs.getBoolean("Status");
                String proImg = rs.getString("Image");
                String ProDescription = rs.getString("Description");
                Date proDate = rs.getDate("CreateDate");
                String cateID = rs.getString("CateID");
                dto = new ProductDTO(idProduct, proName, proPrice, proQuantity, proStatus, proImg, ProDescription, proDate, cateID);
            }
        } finally {
            MyConnection.closeConnection(con, ps, rs);
        }
        return dto;
    }

    public boolean createProduct(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert INTO tbl_Product(ProductID,ProductName,Price,Quantity,Status,Image,Description,CreateDate,CateID) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getProID());
            ps.setString(2, dto.getProName());
            ps.setFloat(3, dto.getProPrice());
            ps.setInt(4, dto.getProQuantity());
            ps.setBoolean(5, true);
            ps.setString(6, dto.getProImage());
            ps.setString(7, dto.getProDescription());
            ps.setDate(8, new java.sql.Date(dto.getProCreateDate().getTime()));
            ps.setString(9, dto.getCateID());
            check = ps.executeUpdate() > 0;
        } finally {
            MyConnection.closeConnection(con, ps, rs);
        }
        return check;
    }

    public boolean deleteProduct(String idProduct) throws Exception {
        boolean check = false;
        try {
            String sql = "Update tbl_Product Set Status = 0 Where ProductID = ? ";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idProduct);
            check = ps.executeUpdate() > 0;
        } finally {
            MyConnection.closeConnection(con, ps, rs);
        }
        return check;
    }

    public boolean updateProduct(ProductDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "Update tbl_Product Set ProductName = ?, Price = ?, Quantity = ?, Status = ?, Image = ?, Description = ?, CateID = ? "
                    + "Where ProductID = ?";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getProName());
            ps.setFloat(2, dto.getProPrice());
            ps.setInt(3, dto.getProQuantity());
            ps.setBoolean(4, dto.isProStatus());
            ps.setString(5, dto.getProImage());
            ps.setString(6, dto.getProDescription());
            ps.setString(7, dto.getCateID());
            ps.setString(8, dto.getProID());
            check = ps.executeUpdate() > 0;
        } finally{
            MyConnection.closeConnection(con, ps, rs);
        }
        return check;
    }
    
    public List<Boolean> findAllStatus() throws Exception {
        List<Boolean> result = null;
        try {
            String sql = "select distinct status from tbl_Product";
            con = MyConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(rs.getBoolean("status"));
            }
        } finally {
            MyConnection.closeConnection(con, ps, rs);
        }
        return result;
    }

}

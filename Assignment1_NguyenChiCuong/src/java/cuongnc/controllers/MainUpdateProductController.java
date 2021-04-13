/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongnc.controllers;

import cuongnc.daos.ProductDAO;
import cuongnc.dtos.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nguye
 */
@MultipartConfig
public class MainUpdateProductController extends HttpServlet {

    private static final String ERROR = "updateProduct.jsp";
    private static final String SUCCESS = "LoadAdminController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String proID = request.getParameter("txtProductID");
            String proName = request.getParameter("txtProductName");
            float proPrice = Float.parseFloat(request.getParameter("txtProductPrice"));
            int proQuantity = Integer.parseInt(request.getParameter("txtProductQuantity"));
            boolean proStatus = Boolean.parseBoolean(request.getParameter("cbbStatus"));
            String proDescription = request.getParameter("txtProductDescription");
            String cateID = request.getParameter("cbbCate");
            String proImg = "";
            try {
                Part part = request.getPart("ProductImage");
                String applicationName = ((HttpServletRequest) request).getContextPath().replace("/", "");
                String realPath = request.getServletContext().getRealPath("/images");
                String[] saveFile = realPath.split(applicationName);
                String href = saveFile[0] + applicationName;
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                part.write(href + "/web/images/" + fileName);
                proImg = "images" + "\\" + fileName;
            } catch (Exception e) {
                proImg = request.getParameter("proImg");
            }
            
            ProductDAO dao = new ProductDAO();
            ProductDTO dto = new ProductDTO(proID, proName, proPrice, proQuantity, proStatus, proImg, proDescription, cateID);
            boolean check = dao.updateProduct(dto);
            if(check){
                url = SUCCESS;
            }
        } catch (Exception e) {
            
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package me.dannly.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.dannly.shop.data_source.ProductDAO;
import me.dannly.shop.domain.model.Product;

/**
 *
 * @author vinix
 */
@WebServlet(name = "ProductProcesser", urlPatterns = {"/adm/product_processer"})
public class ProductProcesser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO productDAO = new ProductDAO();
        if (request.getParameter("delete_id") != null) {
            productDAO.delete(new Product(Integer.parseInt(request.getParameter("delete_id")), null, null, null, null, null, null, null, null));
            response.sendRedirect("products.jsp");
            return;
        }
        final String name = request.getParameter("name"), description = request.getParameter("description"), extraInfo = request.getParameter("extraInfo"), image = request.getParameter("image");
        final boolean active = request.getParameter("active") != null, highlighted = request.getParameter("highlighted") != null;
        final int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        final float weight = Float.parseFloat(request.getParameter("weight"));
        productDAO.insert(new Product(request.getParameter("id") != null && !request.getParameter("id").equals("null") ? Integer.parseInt(request.getParameter("id")) : null, name, description, extraInfo, weight, highlighted, active, image, categoryId));
        response.sendRedirect("products.jsp");
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
        response.sendRedirect("products.jsp");
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

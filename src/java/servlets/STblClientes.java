/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import control.TblClientesControl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TblClientes;

/**
 *
 * @author iud_m
 */
public class STblClientes extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            TblClientesControl tblClientesControl = new TblClientesControl();
            
            Integer cedula= null;
            if(request.getParameter("cedula")!=null && request.getParameter("cedula")!=""){
                cedula = Integer.parseInt(request.getParameter("cedula"));
            }
            
            
            String cedulaClienteStr = request.getParameter("cedula");
            String nombreCliente = request.getParameter("nombre");
            String telefonoCliente = request.getParameter("telefono");
            String direccionCliente = request.getParameter("direccion");
            
            Integer cedulaCliente = null;
            
            if( cedulaClienteStr!=null ){
                cedulaCliente = Integer.parseInt(cedulaClienteStr);
            }
            
            TblClientes c = new TblClientes(cedulaCliente, nombreCliente, direccionCliente, telefonoCliente);
            
            if( cedula == null  ){
                tblClientesControl.insertar(c);
            } else {
                if(request.getParameter("eliminar")==null){
                    tblClientesControl.modificar(c);
                }else {
                    tblClientesControl.eliminar(c);
                }     
            }
            response.sendRedirect("clientes.jsp");
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

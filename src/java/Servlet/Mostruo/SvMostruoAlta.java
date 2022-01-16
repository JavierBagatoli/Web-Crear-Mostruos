/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Mostruo;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JavW11trial
 */
@WebServlet(name = "SvMostruoAlta", urlPatterns = {"/SvMostruoAlta"})
public class SvMostruoAlta extends HttpServlet {

    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String nombreMostruo = request.getParameter("nombreMostruo");
        String nombreCabeza = request.getParameter("nombreCabeza");
        String nombreOjo = request.getParameter("nombreOjo");
        String nombreCuerpo = request.getParameter("nombreCuerpo");
        String nombreBrazo = request.getParameter("nombreBrazo");
        String nombrePierna = request.getParameter("nombrePierna");
        int idFirmaUsuario = Integer.parseInt(request.getParameter("firmaUsuario"));
        
        control.mostruoGeneradorRapido(nombreMostruo, nombreCabeza, nombreOjo, nombreCuerpo, nombreBrazo, nombrePierna, idFirmaUsuario);
        response.sendRedirect("./index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Persona;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JavW11trial
 */
@WebServlet(name = "SvPersonaLogin", urlPatterns = {"/SvPersonaLogin"})
public class SvPersonaLogin extends HttpServlet {

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
        String emailUsuario = request.getParameter("emailUsuario");
        String passwordUsuario = request.getParameter("passwordUsuario");
        int idPersona = control.personaLogin(emailUsuario, passwordUsuario);
        if (idPersona > 0){
            HttpSession misession = request.getSession(true);
            misession.setAttribute("idUsuario", idPersona);
            response.sendRedirect("./index.jsp");
        }else{
            response.sendRedirect("./Usuario/UsuarioLogin.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

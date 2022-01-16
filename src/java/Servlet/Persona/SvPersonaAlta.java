package Servlet.Persona;

import Logica.Controladora;
import Logica.Firma;
import Logica.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JavW11trial
 */
@WebServlet(name = "SvPersonaAlta", urlPatterns = {"/SvPersonaAlta"})
public class SvPersonaAlta extends HttpServlet {
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        String nombreUsuario = request.getParameter("nombreUsuario");
        String apellidoUsuario = request.getParameter("apellidoUsuario");
        String emailUsuario = request.getParameter("emailUsuario");
        String contraseniaUsuario = request.getParameter("contraseniaUsuario");
        Date nacimientoUsuario = null;
        try {
            nacimientoUsuario =  formato.parse(request.getParameter("nacimientoUsuario"));
        } catch (ParseException ex) {
            Logger.getLogger(SvPersonaAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
        String firmaUsuario = request.getParameter("firmaUsuario");
        if (firmaUsuario == null){
            firmaUsuario = "Anonimo";
        }        
        control.altaPersona(nombreUsuario, apellidoUsuario, emailUsuario, contraseniaUsuario, nacimientoUsuario,firmaUsuario);
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

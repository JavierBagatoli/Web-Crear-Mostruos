package Servlet.Mostruo;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvMostruoEditar", urlPatterns = {"/SvMostruoEditar"})
public class SvMostruoEditar extends HttpServlet {

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
        String nombreMostruo = request.getParameter("nombreMostruo");
        String nombreCabeza = request.getParameter("nombreCabeza");
        String nombreOjo = request.getParameter("nombreOjo");
        String nombreCuerpo = request.getParameter("nombreCuerpo");
        String nombreBrazo = request.getParameter("nombreBrazo");
        String nombrePierna = request.getParameter("nombrePierna");
        int id = Integer.parseInt(request.getParameter("idCriatura"));
        
        try {
            control.mostruoEditar(id, nombreMostruo, nombreCabeza, nombreOjo, nombreCuerpo, nombreBrazo, nombrePierna);
        } catch (Exception ex) {
            Logger.getLogger(SvMostruoEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("./Mostruo/MostruoMostrar.jsp");
                
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

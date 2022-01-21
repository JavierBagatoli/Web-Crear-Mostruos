package Servlet.Mostruo;

import Logica.Controladora;
import java.io.IOException;
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
        String nombreCriatura = request.getParameter("nombreCriatura");
        int cabezaCriatura = Integer.parseInt(request.getParameter("cabezaCriatura"));
        int ojoCriatura = Integer.parseInt(request.getParameter("ojoCriatura"));
        int cuerpoCriatura = Integer.parseInt(request.getParameter("cuerpoCriatura"));
        int brazoCriatura = Integer.parseInt(request.getParameter("brazoCriatura"));
        int piernaCriatura = Integer.parseInt(request.getParameter("piernaCriatura"));
        int id = Integer.parseInt(request.getParameter("idCriatura"));
        int depredador1 = Integer.parseInt(request.getParameter("depredadorCriatura"));
        try {
            control.mostruoEditar(id, nombreCriatura, cabezaCriatura, ojoCriatura, cuerpoCriatura, brazoCriatura, piernaCriatura, depredador1);
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

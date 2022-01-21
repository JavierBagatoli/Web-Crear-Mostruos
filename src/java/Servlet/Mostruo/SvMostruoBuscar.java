package Servlet.Mostruo;

import Logica.Controladora;
import Logica.Criatura;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvMostruoBuscar", urlPatterns = {"/SvMostruoBuscar"})
public class SvMostruoBuscar extends HttpServlet {
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
        Criatura criatura = control.buscarCriatura(Integer.parseInt(request.getParameter("id")));
        
        HttpSession misession = request.getSession();
        misession.setAttribute("criatura", criatura);
        response.sendRedirect("./Mostruo/MostruoMostrar.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

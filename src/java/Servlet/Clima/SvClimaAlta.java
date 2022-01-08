/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Clima;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JavW11trial
 */
@WebServlet(name = "SvClimaAlta", urlPatterns = {"/SvClimaAlta"})
public class SvClimaAlta extends HttpServlet {

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
        //Parametros para crear clima
        String nombreClima = request.getParameter("nombreClima");
        int intervaloTemp1 = Integer.parseInt(request.getParameter("IntervaloTemp1"));
        int intervaloTemp2 = Integer.parseInt(request.getParameter("IntervaloTemp2"));
        int IntervaloHume1 = Integer.parseInt(request.getParameter("IntervaloTemp1"));
        int IntervaloHume2 = Integer.parseInt(request.getParameter("IntervaloTemp2"));
        int IntervaloPrep1 = Integer.parseInt(request.getParameter("IntervaloPrep1"));
        int IntervaloPrep2 = Integer.parseInt(request.getParameter("IntervaloPrep2"));
        int IntervaloVien1 = Integer.parseInt(request.getParameter("IntervaloVien1"));
        int IntervaloVien2 = Integer.parseInt(request.getParameter("IntervaloVien2"));
        int visibilidadClima = Integer.parseInt(request.getParameter("visibilidadClima"));
        String planeta = request.getParameter("planeta");
        //Parametros para Crear planeta
        String nombrePlaneta = request.getParameter("nombrePlaneta");
        String tamanioPlaneta = request.getParameter("tamanioPlaneta");
        int gravedadPlaneta = 0;
        try{
            gravedadPlaneta = Integer.parseInt(request.getParameter("gravedadPlaneta"));
        }catch(NullPointerException e ){
        }
        String recursoPlaneta1 = request.getParameter("recursoPlaneta1");
        String recursoPlaneta2 = request.getParameter("recursoPlaneta2");
        String recursoPlaneta3 = request.getParameter("recursoPlaneta3");
        int visibilidadPlaneta = Integer.parseInt(request.getParameter("visibilidadPlaneta"));
        //Enviar datos
        if ((nombrePlaneta != null) && (tamanioPlaneta != null) && (gravedadPlaneta != 0 )){
            control.crearPlaneta(nombrePlaneta, tamanioPlaneta, gravedadPlaneta, recursoPlaneta1, recursoPlaneta2, recursoPlaneta3, visibilidadPlaneta);
            control.crearClima(nombreClima, intervaloTemp1, intervaloTemp2, IntervaloHume1, IntervaloHume2, IntervaloPrep1, IntervaloPrep2, IntervaloVien1, IntervaloVien2, visibilidadClima);
        }else{
            control.crearClima(nombreClima, intervaloTemp1, intervaloTemp2, IntervaloHume1, IntervaloHume2, IntervaloPrep1, IntervaloPrep2, IntervaloVien1, IntervaloVien2, visibilidadClima, planeta);
        } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

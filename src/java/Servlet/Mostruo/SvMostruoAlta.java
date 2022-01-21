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
        //Set de Atributos minimos
        String nombreMostruo = request.getParameter("nombreMostruo");
        String nombreCabeza = request.getParameter("nombreCabeza");
        String nombreOjo1 = request.getParameter("nombreOjo1");
        String nombreOjo2 = request.getParameter("nombreOjo2");
        String nombreOjo3 = request.getParameter("nombreOjo3");
        String nombreCuerpo = request.getParameter("nombreCuerpo");
        String nombreBrazo1 = request.getParameter("nombreBrazo1");
        String nombreBrazo2 = request.getParameter("nombreBrazo2");
        String nombreBrazo3 = request.getParameter("nombreBrazo3");
        String nombrePierna1 = request.getParameter("nombrePierna1");
        String nombrePierna2 = request.getParameter("nombrePierna2");
        String nombrePierna3 = request.getParameter("nombrePierna3");
        
        int idFirmaUsuario = 0;
        
        short cantidadCabezas = 0;
        short cantidadOjos1 = 0;
        short cantidadOjos2 = 0;
        short cantidadOjos3 = 0;
        short cantidadBrazos1 = 0;
        short cantidadBrazos2 = 0;
        short cantidadBrazos3 = 0;
        short cantidadPiernas1 = 0;
        short cantidadPiernas2 = 0;
        short cantidadPiernas3 = 0;   
        
        try{
         idFirmaUsuario = Integer.parseInt(request.getParameter("firmaUsuario"));
        }catch(NullPointerException | NumberFormatException e){}
        try{
         cantidadCabezas = Short.parseShort(request.getParameter("cantidadCabezas"));
        }catch(NullPointerException | NumberFormatException e){cantidadCabezas = 1;}
        try{ 
         cantidadOjos1 = Short.parseShort(request.getParameter("cantidadOjos1"));
        }catch(NullPointerException | NumberFormatException e){cantidadOjos1 = 1;}
        try{
         cantidadOjos2 = Short.parseShort(request.getParameter("cantidadOjos2"));
        }catch(NullPointerException | NumberFormatException e){}
        try{
        cantidadOjos3 = Short.parseShort(request.getParameter("cantidadOjos3"));
        }catch(NullPointerException | NumberFormatException e){}
        try{
         cantidadBrazos1 = Short.parseShort(request.getParameter("cantidadBrazos1"));
         }catch(NullPointerException | NumberFormatException e){ cantidadBrazos1 = 1;}
        try{ 
         cantidadBrazos2= Short.parseShort(request.getParameter("cantidadBrazos2"));
         }catch(NullPointerException | NumberFormatException e){}
        try{ 
         cantidadBrazos3= Short.parseShort(request.getParameter("cantidadBrazos3"));
         }catch(NullPointerException | NumberFormatException e){}
        try{ 
         cantidadPiernas1 = Short.parseShort(request.getParameter("cantidadPiernas1"));
         }catch(NullPointerException | NumberFormatException e){ cantidadPiernas1 = 1;}
        try{ 
         cantidadPiernas2= Short.parseShort(request.getParameter("cantidadPiernas2"));
         }catch(NullPointerException | NumberFormatException e){}
        try{ 
         cantidadPiernas3 = Short.parseShort(request.getParameter("cantidadPiernas3"));        
            
        }catch(NullPointerException | NumberFormatException e){
        }
        
        //Atributos de descrioncion de partes
        String descripcionCabeza = request.getParameter("descripcionCabeza");
        String descripcionOjo1 = request.getParameter("descripcionOjo1");
        String descripcionOjo2 = request.getParameter("descripcionOjo2");
        String descripcionOjo3 = request.getParameter("descripcionOjo3");
        String descripcionCuerpo = request.getParameter("descripcionCuerpo");
        String descripcionBrazo1 = request.getParameter("descripcionBrazo1");
        String descripcionBrazo2 = request.getParameter("descripcionBrazo2");
        String descripcionBrazo3 = request.getParameter("descripcionBrazo3");
        String descripcionPierna1 = request.getParameter("descripcionPierna1");
        String descripcionPierna2 = request.getParameter("descripcionPierna1");
        String descripcionPierna3 = request.getParameter("descripcionPierna1");
        String descripcionCriatura = request.getParameter("descripcionCriatura");
        //Compruebo que metodo realizo, si el rapido o el completo
        int tamanioDescripciones = descripcionCabeza.length() + descripcionOjo1.length() 
                + descripcionCuerpo.length() + descripcionBrazo1.length() 
                + descripcionPierna1.length();
        if (tamanioDescripciones == 0){
            control.mostruoGeneradorRapido(nombreMostruo, nombreCabeza, nombreOjo1,
                    nombreOjo2, nombreOjo3 , nombreCuerpo, nombreBrazo1,
                    nombreBrazo2, nombreBrazo3, nombrePierna1, nombrePierna2 ,
                    nombrePierna3, idFirmaUsuario);
        }else if (tamanioDescripciones >0){
            control.MostruoAlta(nombreMostruo, descripcionCriatura,
                    nombreCabeza, cantidadCabezas, descripcionCabeza,
                    nombreOjo1, cantidadOjos1, descripcionOjo1,
                    nombreOjo2, cantidadOjos2, descripcionOjo2,
                    nombreOjo3, cantidadOjos3, descripcionOjo3,
                    nombreCuerpo, descripcionCuerpo,
                    nombreBrazo1, cantidadBrazos1, descripcionBrazo1,
                    nombreBrazo2, cantidadBrazos2, descripcionBrazo2,
                    nombreBrazo3, cantidadBrazos3, descripcionBrazo3,
                    nombrePierna1, cantidadPiernas1, descripcionPierna1,
                    nombrePierna2, cantidadPiernas2, descripcionPierna2,
                    nombrePierna3, cantidadPiernas3, descripcionPierna3,
                    idFirmaUsuario
                    
                      
                    );
        }
        response.sendRedirect("./index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

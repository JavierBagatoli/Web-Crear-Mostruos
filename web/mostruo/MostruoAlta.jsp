<%-- 
    Document   : MostruoAlta
    Created on : 31 dic 2021, 6:27:11
    Author     : JavW11trial
--%>

<%@page import="Logica.Persona"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Mostruo</title>
        <link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
        <style>
            .containerMostruo{
                padding: 30px;
                margin: 40px;
            }
            .textarea{
                width: 97%;
            }
            .titulo{
                margin: 50px 150px;
                content: center;
                align-content: center;
            }
            .contenedor{
                width: 100%;
            }
        </style>
    </head>
    <body id="top" >
        <div class="wrapper row1">
            <header id="header" class="hoc clear">
                <div id="logo" class="fl_left"> 
                    <!-- ################################################################################################ -->
                    <h1><a href="index.html">GenMos</a></h1>
                    <!-- ################################################################################################ -->
                </div>
                <nav id="mainav" class="fl_right"> 
                    <!-- ################################################################################################ -->
                    <ul class="clear">
                        <li><a class="drop" href="#">Galeria</a>
                            <ul>
                                <li><a href="Mostruo/MostruosMostrar.jsp">Mostruos</a></li>
                            </ul>
                        </li>
                        <li><a class="drop" href="#">Creacion</a>
                            <ul>
                                <li><a href="pages/font-icons.html">Font Icons</a></li>
                                <li><a href="Mostruo/MostruoAlta.jsp">Creacion rapida</a><li>
                            </ul>
                        </li>
                    </ul>
                    <!-- ################################################################################################ -->
                </nav>
            </header>
        </div>
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <h1 class="titulo">Nueva Criatura</h1>
        <div class="contenedor">
            <div class="wrapper row4 contenedor">

                <div id="comments">
                    <form action="../SvMostruoAlta" method="POST" class="containerMostruo">
                        <div class="one_third first">
                            <label for="nombreMostruo">Nombre: <span>*</span></label>
                            <input type="text" name="nombreMostruo" id="nombreMostruo" value="" size="22" required>
                        </div>

                        <div class="one_third first">
                            <label for="nombreCabeza">Cabeza: <span>*</span></label>
                            <input type="text" name="nombreCabeza" id="nombreCabeza" value="" size="22" required>
                        </div>

                        <div class="one_third first">
                            <label for="nombreOjo">Ojo: <span>*</span></label>
                            <input type="text" name="nombreOjo" id="nombreOjo" value="" size="22" required>
                        </div>

                        <div class="one_third first">
                            <label for="nombreCuerpo">Cuerpo: <span>*</span></label>
                            <input type="text" name="nombreCuerpo" id="nombreCuerpo" value="" size="22" required>
                        </div>
                        <div class="one_third first">
                            <label for="nombreBrazo">Brazo: <span>*</span></label>
                            <input type="text" name="nombreBrazo" id="nombreBrazo" value="" size="22" required>
                        </div>
                        <div class="one_third">
                            <label for="nombrePierna">Pierna: <span>*</span></label>
                            <input type="text" name="nombrePierna" id="nombrePierna" value="" size="22" required>
                        </div>                
                        
                        
                        <div class="block clear textarea">
                            <label for="descripcion">Descripción: </label>
                            <textarea class="" name="descripcion" id="descripcion" rows="10"></textarea>
                        </div>
                        
                        <% 
                            HttpSession misession = request.getSession();
                            Controladora control = new Controladora();
                            int idUsuario = (int) misession.getAttribute("idUsuario");
                            Persona usuario = control.personaBuscar(idUsuario);

                        %>
                        <input type="hidden" name="firmaUsuario" value="<%=usuario.getFirma().getIdFirma() %>">
                        <div>
                            <input type="submit" name="submit" value="Crear">
                            &nbsp;
                            <input type="reset" name="reset" value="Reset Form">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

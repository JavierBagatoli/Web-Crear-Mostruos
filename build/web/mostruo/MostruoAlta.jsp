<%-- 
    Document   : MostruoAlta
    Created on : 31 dic 2021, 6:27:11
    Author     : JavW11trial
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Visibilidad"%>
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
            .bodyFlex{
                display: flex;
                justify-content: space-around;
                margin-left: 20%;
                margin-right: 20%;
                width: 60%;
            }
            .contenedor1{
                width: 95%;
                justify-content: center;
            }
            .containerMostruo{
                padding: 30px;
                margin: 2.5%;
                background-color: #09090999;
            }
            .textarea{
                width: 100%;
            }
            .titulo{
                margin: 50px 150px;
                content: center;
                align-content: center;
            }
            .contenedor{
                width: 100%;
                display: flex;
            }
            input, textarea{
                background-color: #090909;
            }
            .dato{
                width: 100%;
            }
            .atributoNumerico{
                width: 10%;
            }
            .descripcion{
                width:50%;
            }
        </style>
    </head>
    <body id="top">
        <div class="wrapper row1">
            <header id="header" class="hoc clear">
                <div id="logo" class="fl_left"> 
                    <!-- ################################################################################################ -->
                    <h1><a href="../index.html">GenMos</a></h1>
                    <!-- ################################################################################################ -->
                </div>
                <nav id="mainav" class="fl_right"> 
                    <!-- ################################################################################################ -->
                    <ul class="clear">
                        <li><a class="drop" href="#">Galeria</a>
                            <ul>
                                <li><a href="./MostruosMostrar.jsp">Mostruos</a></li>
                                <li><a href="./MiMostruosMostrar.jsp">Mis Mostruos</a></li>
                                <li><a href="./MostruoCadenaTrofica.jsp">Mis Cadenas Troficas</a></li>
                            </ul>
                        </li>
                        <li><a class="drop" href="#">Creacion</a>
                            <ul>
                                <li><a href="../Clima/ClimaAlta.jsp">Creacion clima</a><li>
                                <li><a href="./MostruoAlta.jsp">Creacion rapida</a><li>
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
        <div class="bodyFlex">
            <div class="wrapper row4">

                <div id="comments" class="contenedor1">
                    <form action="../SvMostruoAlta" method="POST" class="containerMostruo">
                        <div class="dato">
                            <div class="one_third first">
                                <label for="nombreMostruo">Nombre: <span>*</span></label>
                                <input type="text" name="nombreMostruo" id="nombreMostruo" value="" size="22" required>
                            </div>
                        </div>
                        <!-- Cabeza -->
                        <div class="dato">
                            <div class="one_third first">
                                <label for="nombreCabeza">Cabeza: <span>*</span></label>
                                <input type="text" name="nombreCabeza" id="nombreCabeza" size="22" required>
                            </div>
                            <div class="one_third atributoNumerico">
                                <label for="cantidadCabezas">Cantidad: <span>*</span></label>
                                <input class="atributoNumerico" type="number" name="cantidadCabezas" id="cantidadCabezas" value="1" min="0" max="10">
                            </div>
                            <div class="two_third descripcion">
                                <label for="descripcionCabeza">Descripción cabeza: </label>
                                <input class="" type="text" name="descripcionCabeza" id="descripcionCabeza">
                            </div>
                        </div>

                        <!-- Ojos --> 
                        <div class="one_third first">
                            <label for="nombreOjo1">Primer set de ojos: <span>*</span></label>
                            <input type="text" name="nombreOjo1" id="nombreOjo1" required>
                        </div>
                        <div class="one_third atributoNumerico">
                            <label for="cantidadOjos1">Cantidad: <span>*</span></label>
                            <input class="atributoNumerico" type="number" name="cantidadOjos1" id="cantidadOjos1" value="2" min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionOjo1">Descripción ojo: </label>
                            <input type="text" name="descripcionOjo1" id="descripcionOjo1">
                        </div>
                        
                        <div class="one_third first">
                            <label for="nombreOjo2">Segundo set de ojos: </label>
                            <input type="text" name="nombreOjo2" id="nombreOjo2" value="">
                        </div>
                        <div class="one_third atributoNumerico">
                            <label for="cantidadOjos2">Cantidad: </label>
                            <input class="atributoNumerico" type="number" name="cantidadOjos2" id="cantidadOjos2"  min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionOjo2">Descripción ojo: </label>
                            <input type="text" name="descripcionOjo2" id="descripcionOjo2">
                        </div>
                        
                        <div class="one_third first">
                            <label for="nombreOjo3">Tercer set de ojos: </label>
                            <input type="text" name="nombreOjo3" id="nombreOjo3" value="">
                        </div>
                        <div class="one_third atributoNumerico">
                            <label for="cantidadOjos3">Cantidad: </label>
                            <input class="atributoNumerico" type="number" name="cantidadOjos3" id="cantidadOjos3"  min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionOjo3">Descripción ojo: </label>
                            <input type="text" name="descripcionOjo3" id="descripcionOjo3">
                        </div>
                        <!-- Cuerpo -->
                        <div class="one_third first">
                            <label for="nombreCuerpo">Cuerpo: <span>*</span></label>
                            <input type="text" name="nombreCuerpo" id="nombreCuerpo" required>
                        </div>
                        <div class="two_third">
                            <label for="descripcionCuerpo">Descripción cuerpo: </label>
                            <input type="text" name="descripcionCuerpo" id="descripcionCuerpo">
                        </div>
                        <!-- Brazos -->
                        <div class="one_third first">
                            <label for="nombreBrazo1">Primer set de brazos: <span>*</span></label>
                            <input type="text" name="nombreBrazo1" id="nombreBrazo1" value="" required>
                        </div>
                        <div class="one_third atributoNumerico">
                            <label for="cantidadBrazos1">Cantidad: <span>*</span></label>
                            <input class="atributoNumerico" type="number" name="cantidadBrazos1" id="cantidadBrazos1" value="2" min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionBrazo1">Descripción brazo: </label>
                            <input type="text" name="descripcionBrazo1" id="descripcionBrazo1">
                        </div>
                        <div class="one_third first">
                            <label for="nombreBrazo2">Segundo set de brazos: </label>
                            <input type="text" name="nombreBrazo2" id="nombreBrazo2" value="">
                        </div>
                        <div class="one_third atributoNumerico">
                            <label for="cantidadBrazos2">Cantidad: </label>
                            <input class="atributoNumerico" type="number" name="cantidadBrazos2" id="cantidadBrazos2"  min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionBrazo2">Descripción brazo: </label>
                            <input type="text" name="descripcionBrazo2" id="descripcionBrazo2">
                        </div>
                        <div class="one_third first">
                            <label for="nombreBrazo3">Tercer set de brazos: </label>
                            <input type="text" name="nombreBrazo3" id="nombreBrazo3" value="">
                        </div>
                        <div class="one_third atributoNumerico">
                            <label for="cantidadBrazos3">Cantidad: </label>
                            <input class="atributoNumerico" type="number" name="cantidadBrazos3" id="cantidadBrazos3"  min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionBrazo3">Descripción brazo: </label>
                            <input type="text" name="descripcionBrazo3" id="descripcionBrazo3">
                        </div>
                        <!-- Piernas -->
                        <div class="one_third first">
                            <label for="nombrePierna1">Primer set de piernas: <span>*</span></label>
                            <input type="text" name="nombrePierna1" id="nombrePierna1" required>
                        </div>  
                        <div class="one_third atributoNumerico">
                            <label for="cantidadPiernas1">Cantidad: <span>*</span></label>
                            <input class="atributoNumerico" type="number" name="cantidadPiernas1" id="cantidadPiernas1" value="2" min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionPierna1">Descripción pierna: </label>
                            <input type="text" name="descripcionPierna1" id="descripcionPierna1">
                        </div>
                        <div class="one_third first">
                            <label for="nombrePierna2">Sergundo set de piernas: </label>
                            <input type="text" name="nombrePierna2" id="nombrePierna2">
                        </div>  
                        <div class="one_third atributoNumerico">
                            <label for="cantidadPiernas2">Cantidad:</label>
                            <input class="atributoNumerico" type="number" name="cantidadPiernas2" id="cantidadPiernas2"  min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionPierna2">Descripción pierna: </label>
                            <input type="text" name="descripcionPierna2" id="descripcionPierna2">
                        </div>
                        <div class="one_third first">
                            <label for="nombrePierna3">Tercer set de piernas: </label>
                            <input type="text" name="nombrePierna3" id="nombrePierna3" value="">
                        </div>  
                        <div class="one_third atributoNumerico">
                            <label for="cantidadPiernas3">Cantidad: </label>
                            <input class="atributoNumerico" type="number" name="cantidadPiernas3" id="cantidadPiernas3"  min="0" max="10">
                        </div>
                        <div class="two_third descripcion">
                            <label for="descripcionPierna3">Descripción pierna: </label>
                            <input type="text" name="descripcionPierna3" id="descripcionPierna3">
                        </div>
                        <!-- Descripcion -->
                        <div class="block clear textarea">
                            <label for="descripcionCriatura">Descripción: </label>
                            <textarea class="" name="descripcionCriatura" id="descripcionCriatura" rows="10"></textarea>
                        </div>
                        
                        <% 
                            HttpSession misession = request.getSession();
                            Controladora control = new Controladora();
                            int idUsuario = (int) misession.getAttribute("idUsuario");
                            Persona usuario = control.personaBuscar(idUsuario);
                            ArrayList<Visibilidad> listaVisibilidad = new ArrayList<>();
                            
                        %>
                        <select>
                            <%for(Visibilidad visibilidad : listaVisibilidad){ %>
                                <option value="<%=visibilidad.getIdVisibilidad() %>">
                                    <%=visibilidad.getVisibilidad() %>
                                </option>
                            <%} %>
                        </select>
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

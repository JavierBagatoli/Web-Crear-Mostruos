<%@page import="Logica.Pierna"%>
<%@page import="Logica.Brazo"%>
<%@page import="Logica.Cuerpo"%>
<%@page import="Logica.Ojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Cabeza"%>
<%@page import="Logica.Controladora"%>
<%@page import="Logica.Criatura"%>
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
            .flex{
                display: flex;
            }
        </style>
    </head>
    <body id="top" >
        <%
        HttpSession misession = request.getSession();
        try{
            int idPersona = (int) misession.getAttribute("idUsuario");
        }catch(NullPointerException e){
            response.sendRedirect("./Usuario/UsuarioLogin.jsp");
        }
        %>
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
        
        <% 
            Criatura criatura = (Criatura) misession.getAttribute("criatura");
            {
                String ojo1 = "No se han ingresado Ojos";
                String brazo1 = "No se han ingresado Brazos";
                String pierna1 = "No se han ingresado Piernas";
                if (criatura.getCabeza().getOjos().size() > 0) {
                    ojo1 = criatura.getCabeza().getOjos().get(0).getNombre();
                }
                if (criatura.getCuerpo().getBrazos().size() > 0) {
                    brazo1 = criatura.getCuerpo().getBrazos().get(0).getNombre();
                }
                if (criatura.getCuerpo().getPiernas().size() > 0) {
                    pierna1 = criatura.getCuerpo().getPiernas().get(0).getNombrePierna();
                }
                Controladora control = new Controladora();
                List<Cabeza> cabezasLista = control.traerCabezas();
                List<Ojo> ojosLista = control.traerOjos();
                List<Cuerpo> cuerposLista = control.traerCuerpos();
                List<Brazo> brazosLista = control.traerBrazos();
                List<Pierna> piernasLista = control.traerPiernas();
                List<Criatura> DepredadoresLista = control.traerCriaturas();
        %>        
        <h1 class="titulo">Editar <%=criatura.getNombre()%></h1>
        <div class="contenedor">
            <div class="wrapper row4 contenedor">

                <div id="comments">
                    <form action="../SvMostruoEditar" method="POST" class="containerMostruo">
                        <div class="one_third first">
                            <label for="nombreCriatura">Nombre: <span>*</span></label>
                            <input type="text" name="nombreCriatura" id="nombreCriatura" value="<%=criatura.getNombre()%>" size="22" required>
                        </div>

                        <div class="first">
                            <label for="cabezaCriatura">Cabeza: </label>
                            <div class="one_third first flex">
                                <select name="cabezaCriatura" id="cabezaCriatura">
                                    <option value="vacio"></option>
                                    <%for (Cabeza cabeza : cabezasLista) {%>
                                    <option value="<%=criatura.getCabeza().getIdCabeza()%>" selected><%=criatura.getCabeza().getNombre()%> </option>
                                    <%if (criatura.getCabeza().getIdCabeza() != cabeza.getIdCabeza()) {%>
                                    <option value="<%=cabeza.getIdCabeza()%>"><%=cabeza.getNombre()%> </option>
                                    <%}} %>
                                </select>
                                <input class="one_third" type="text" name="nombreCabeza" id="nombreCabeza" value="" placeholder="Si desea crear escriba el nombre aqui">
                            </div>
                            <div class="block clear textarea">
                                <label for="descripcionCabeza">Descripción de la Cabeza: </label>
                                <textarea name="descripcionCabeza" id="descripcionCabeza" rows="3"><%=criatura.getCabeza().getDescripcion()%></textarea>
                            </div>
                        </div>
                        <div class="first">
                            <label for="ojoCriatura">Ojo: <span>*</span></label>
                            <div class="one_third first flex">
                                <select name="ojoCriatura" id="ojoCriatura">
                                    <option value="vacio"></option>
                                    <%for (Ojo ojo : ojosLista) {%>
                                    <option value="<%=criatura.getCabeza().getOjos().get(0).getIdOjo()%>" selected><%=criatura.getCabeza().getOjos().get(0).getNombre()%> </option>
                                    <%if (criatura.getCabeza().getOjos().get(0).getIdOjo() != ojo.getIdOjo()) {%>
                                    <option value="<%=ojo.getIdOjo()%>"><%=ojo.getNombre()%> </option>
                                    <%}} %>
                                </select>

                                <input class="one_third" type="text" name="nombreOjo" id="nombreOjo" value="" placeholder="Si desea crear escriba el nombre aqui">
                            </div>
                        </div>

                        <div class="first">
                            <label for="cuerpoCriatura">Cuerpo: <span>*</span></label>
                            <div class="one_third first flex">
                                <select name="cuerpoCriatura" id="cuerpoCriatura">
                                    <option value="vacio"></option>
                                    <%for (Cuerpo cuerpo : cuerposLista) {%>
                                    <option value="<%=criatura.getCuerpo().getIdCuerpo()%>" selected><%=criatura.getCuerpo().getNombre()%> </option>
                                    <%if (criatura.getCuerpo().getIdCuerpo() != cuerpo.getIdCuerpo()) {%>
                                    <option value="<%=cuerpo.getIdCuerpo()%>"><%=cuerpo.getNombre()%> </option>
                                    <%}} %>
                                </select>

                                <input class="one_third" type="text" name="nombreCuerpo" id="nombreCuerpo" value="" placeholder="Si desea crear escriba el nombre aqui">
                            </div>
                        </div>
                        <div class="first">
                            <label for="brazoCriatura">Brazo: <span>*</span></label>
                            <div class="one_third first flex">
                                <select name="brazoCriatura" id="brazoCriatura">
                                    <option value="vacio"></option>
                                    <%for (Brazo brazo : brazosLista) {   %>
                                    <option value="<%=criatura.getCuerpo().getBrazos().get(0).getIdBrazo()%>" selected><%=criatura.getCuerpo().getBrazos().get(0).getNombre()%> </option>
                                    <%if (criatura.getCuerpo().getBrazos().get(0).getIdBrazo() != brazo.getIdBrazo()) {%>
                                    <option value="<%=brazo.getIdBrazo()%>"><%=brazo.getNombre()%> </option>
                                    <%}} %>
                                </select>

                                <input class="one_third" type="text" name="nombreBrazo" id="nombreBrazo" value="" placeholder="Si desea crear escriba el nombre aqui">
                            </div>
                        </div>
                        <div class="first">
                            <label for="piernaCriatura">Cuerpo: <span>*</span></label>
                            <div class="one_third first flex">
                                <select name="piernaCriatura" id="piernaCriatura">
                                    <option value="vacio"></option>
                                    <%for (Pierna pierna : piernasLista) { %>
                                    <option value="<%=criatura.getCuerpo().getPiernas().get(0).getIdPierna()%>" selected><%=criatura.getCuerpo().getPiernas().get(0).getNombrePierna()%> </option>
                                    <%if (criatura.getCuerpo().getPiernas().get(0).getIdPierna() != pierna.getIdPierna()) {%>
                                    <option value="<%=pierna.getIdPierna()%>"><%=pierna.getNombrePierna()%> </option>
                                    <%}} %>
                                </select>

                                <input class="one_third" type="text" name="nombrePierna" id="nombrePierna" value="" placeholder="Si desea crear escriba el nombre aqui">
                            </div> 
                        </div>
                        <div class="block clear textarea">
                            <label for="descripcion">Descripción: </label>
                            <textarea class="" name="descripcion" id="descripcion" rows="10"></textarea>
                        </div>
                        
                         <div class="first">
                            <label for="depredadorCriatura">Depredador <span>*</span></label>
                            <div class="one_third first flex">
                                <select name="depredadorCriatura" id="depredadorCriatura">
                                    <option value="vacio"></option>
                                    <%for (Criatura depredador : DepredadoresLista) { %>
                                    <option value="<%=depredador.getIdCriatura() %>"><%=depredador.getNombre() %> </option>
                                    <%} %>
                                </select>
                            </div> 
                        </div>
                        <input type="hidden" name="idCriatura" value="<%=criatura.getIdCriatura() %>">
                        <!-- Botones -->
                        <div>
                            <input type="submit" name="submit" value="Editar">
                            &nbsp;
                            <input type="reset" name="reset" value="Reset Form">
                            <%}%>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

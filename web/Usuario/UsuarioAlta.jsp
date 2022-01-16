<%-- 
    Document   : MostruoAlta
    Created on : 31 dic 2021, 6:27:11
    Author     : JavW11trial
--%>

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
        <li><a class="drop" href="#">Pages</a>
          <ul>
            <li><a href="pages/gallery.html">Galeria</a></li>
          </ul>
        </li>
        <li><a class="drop" href="#">Dropdown</a>
          <ul>
            <li><a href="pages/full-width.html">Full Width</a></li>
            <li><a href="pages/sidebar-left.html">Sidebar Left</a></li>
            <li><a href="pages/sidebar-right.html">Sidebar Right</a></li>
            <li><a href="pages/basic-grid.html">Basic Grid</a></li>
            <li><a href="pages/font-icons.html">Font Icons</a></li>
            <li><a href="Mostruo/MostruoAlta.jsp">Creacion rapida</a><li>
            <li><a href="Mostruo/MostruosMostrar.jsp">Mostrar coleccion</a><li>
          </ul>
        </li>
      </ul>
      <!-- ################################################################################################ -->
    </nav>
  </header>
</div>
        <h1 class="titulo">Registrarse</h1>
        <div class="contenedor">
            <div class="wrapper row4 contenedor">

                <div id="comments">
                    <form action="../SvPersonaAlta" method="POST" class="containerMostruo">
                        <div class="one_third first">
                            <label for="nombreUsuario">Nombre: <span>*</span></label>
                            <input type="text" name="nombreUsuario" id="nombreUsuario" value="" required>
                        </div>

                        <div class="one_third first">
                            <label for="apellidoUsuario">Apellido: <span>*</span></label>
                            <input type="text" name="apellidoUsuario" id="apellidoUsuario" value="" required>
                        </div>

                        <div class="one_third first">
                            <label for="emailUsuario">Email: <span>*</span></label>
                            <input type="email" name="emailUsuario" id="emailUsuario" value="" required>
                        </div>

                        <div class="one_third first">
                            <label for="contraseniaUsuario">Contraseña: <span>*</span></label>
                            <input type="password" name="contraseniaUsuario" id="contraseniaUsuario" value=""  required>
                        </div>
                        <div class="one_third first">
                            <label for="nacimientoUsuario">Fecha de Nacimiento <span>*</span></label>
                            <input type="date" name="nacimientoUsuario" id="nacimientoUsuario" value="" required>
                        </div>
                        <div class="one_third">
                            <label for="firmaUsuario">Firma: <span>*</span></label>
                            <input type="text" name="firmaUsuario" id="firmaUsuario" value="" size="22" required>
                        </div>                

                        <div class="first">
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


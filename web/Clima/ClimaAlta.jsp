<%-- 
    Document   : MostruoAlta
    Created on : 31 dic 2021, 6:27:11
    Author     : JavW11trial
--%>

<%@page import="Logica.Ambiente.Planeta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Visibilidad"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Habitat</title>
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
        <div class="wrapper row1">
            <header id="header" class="hoc clear">
                <div id="logo" class="fl_left"> 
                    <!-- ################################################################################################ -->
                    <h1><a href="../index.jsp">GenMos</a></h1>
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
        <h1 class="titulo">Crear Clima</h1>
        <div class="contenedor">
            <% Controladora control = new Controladora();
               List<Visibilidad> visibilidadesLista = control.visibilidadTraer();
               List<Planeta> planetasLista = control.planetaTraer();
               
                int visibilidadPublico = -1;    //Si falla el for los ID seran negativos
                int visibilidadPrivado = -2;
                int visibilidadProtegido = -3;
                
                for(Visibilidad visibilidad : visibilidadesLista){
                    switch(visibilidad.getVisibilidad()){
                        case "Privado":
                            visibilidadPrivado = visibilidad.getIdVisibilidad();
                            break;
                        case "Protegido":
                            visibilidadProtegido = visibilidad.getIdVisibilidad();
                            break;
                        case "Publico":
                            visibilidadPublico = visibilidad.getIdVisibilidad();
                            break;
                        }
                    }
                                           

            %>
            <div class="wrapper row4 contenedor">
                <div id="comments">
                    <form action="../SvClimaAlta" method="POST" class="containerMostruo">
                        <div class="one_half first">
                            <div class="one_half first">
                                <label for="nombreClima">Nombre: <span>*</span></label>
                                <input type="text" name="nombreClima" id="nombreClima" value="" required>
                            </div>

                            <label class="first" for="IntervaloTemp">Intervalo de Temperatura: (min - max) <span>*</span></label>
                            <div class="first flex">
                                <input class="one_halfone_half first" type="number" name="IntervaloTemp1" id="IntervaloTemp" value="" required>
                                <input class="one_third" type="number" name="IntervaloTemp2" id="IntervaloTemp2" value="" required>
                            </div>

                            <label class="first" for="IntervaloHume">Intervalo de Humedad: (min - max) <span>*</span></label>
                            <div class=" first flex">
                                <input class="one_half first" type="number" name="IntervaloHume1" id="IntervaloHume" value="" required>
                                <input class="one_half" type="number" name="IntervaloHume2" id="IntervaloHume2" value="" required>
                            </div>

                            <label class="first" for="IntervaloPrep">Intervalo de Precipitaciones: (min - max) <span>*</span></label>
                            <div class="first flex">
                                <input class="one_half first" type="number" name="IntervaloPrep1" id="IntervaloPrep" value="" required>
                                <input class="one_half" type="number" name="IntervaloPrep2" id="IntervaloPrep2" value="" required>
                            </div>

                            <label class="first" for="IntervaloVien">Intervalo de Vientos: (min - max)<span>*</span></label>
                            <div class="first flex">
                                <input class="one_half first" type="number" name="IntervaloVien1" id="IntervaloVien" value="" required>
                                <input class="one_half" type="number" name="IntervaloVien2" id="IntervaloVien2" value="" required>
                            </div>
                            <div class="first">
                                <label for="visibilidadClima">Visibilidad: <span>*</span></label>
                                <div class="one_third first flex ">
                                    <select name="visibilidadClima" id="visibilidadClima">
                                        <option value="visibilidadPublico">Publico</option> <!-- Cualquier usuario puede encontrarlo -->
                                        <option value="visibilidadPrivado">Privado</option> <!-- Solo el creado puede verlo -->
                                        <option value="visibilidadProtegido">Protegido</option> <!-- Solo aquien comporta el creador puede verlo -->
                                    </select>
                                </div>
                            </div>
                            <div class="first">
                                <label for="planeta">Planeta: <span>*</span></label>
                                <div class="first flex">
                                    <select class="two_quarter first" name="planeta" id="planeta">
                                        <option value="vacio">default</option>
                                    </select>

                                    <input class="two_quarter" type="text" name="nombrePlaneta" id="nombreOjo" value="" placeholder="Si desea crear escriba el nombre aqui">
                                </div>
                            </div>
                        </div>
                        <div class="one_half">
                            <div class="one_half first">
                                <label for="nombrePlaneta">Nombre Planeta: <span>*</span></label>
                                <input  type="text" name="nombrePlaneta" id="nombrePlaneta" value="">
                            </div>

                            <label class="first" for="tamanioPlaneta">Tamaño planeta: <span>*</span></label>
                            <div class="one_half first flex">
                                <input class="first" type="number" name="tamanioPlaneta" id="tamanioPlaneta" value="" required>
                            </div>

                            <label class="first" for="gravedadPlaneta">Tamaño planeta: <span>*</span></label>
                            <div class="one_half first flex">
                                <input class="first" type="number" name="gravedadPlaneta" id="gravedadPlaneta" value="" required>
                            </div>

                            <label class="first" for="sistemaPlaneta">Tamaño planeta: <span>*</span></label>
                            <div class="one_half first flex">
                                <input class="first" type="number" name="sistemaPlaneta" id="sistemaPlaneta" value="" required>
                            </div>

                            <div class="first">
                                <label>Recursos disponibles: <span>*</span></label>
                                <div class="flex">
                                    <div>
                                        <div class="one_third first flex">
                                            <select name="recursoPlaneta1" id="recursoPlaneta1">
                                                <option value="Agua">Agua</option> 
                                                <option value="Aire">Aire</option> 
                                                <option value="Suelo fertil">Suelo fertil</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="">
                                        <div class="one_third first flex">
                                            <select name="recursoPlaneta2" id="recursoPlaneta2">
                                                <option value="Agua">Agua</option> 
                                                <option value="Aire">Aire</option> 
                                                <option value="Suelo fertil">Suelo fertil</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="">
                                        <div class="one_third first flex">
                                            <select name="recursoPlaneta2" id="recursoPlaneta2">
                                                <option value="Agua">Agua</option> 
                                                <option value="Aire">Aire</option> 
                                                <option value="Suelo fertil">Suelo fertil</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="first">
                                    <label for="visibilidadPlaneta">Visibilidad: <span>*</span></label>
                                    <div class="one_third first flex">
                                        <select name="visibilidadPlaneta" id="visibilidadPlaneta">
                                            <option value="visibilidadPublico">Publico</option> <!-- Cualquier usuario puede encontrarlo -->
                                            <option value="visibilidadPrivado">Privado</option> <!-- Solo el creado puede verlo -->
                                            <option value="visibilidadProtegido">Protegido</option> <!-- Solo aquien comporta el creador puede verlo -->
                                        </select>
                                    </div>
                                </div>
                            </div>
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


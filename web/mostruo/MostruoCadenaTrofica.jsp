<%-- 
    Document   : MostruosMostrar
    Created on : 31 dic 2021, 6:28:59
    Author     : JavW11trial
--%>

<%@page import="Logica.Persona"%>
<%@page import="Logica.Criatura"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
    <!-- To declare your language - read more here: https://www.w3.org/International/questions/qa-html-language-declarations -->
    <head>
        <title>Galeria Mostruos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
        <style>
            .imgOp{
                opacity: 1;
            }
            .imgOp:hover{
                opacity: 0.7;
                    
            }
            button{
                background-color: black;
                border-style: groove ;
                color: white;

                width: 250px;
                height: 250px;
                display: inline-block;
            }
        </style>
    </head>
    <body id="top">
        <%
        HttpSession misession = request.getSession();
        int idPersona = -1;
        try{
            idPersona = (int) misession.getAttribute("idUsuario");
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
        <div class="wrapper bgded overlay" style="background-image:url('../images/demo/backgrounds/01.jpg');">
            <div id="breadcrumb" class="hoc clear"> 
                <!-- ################################################################################################ -->
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Lorem</a></li>
                    <li><a href="#">Ipsum</a></li>
                    <li><a href="#">Dolor</a></li>
                </ul>
                <!-- ################################################################################################ -->
            </div>
        </div>
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <div class="wrapper row3">
            <main class="hoc container clear"> 
                <!-- main body -->
                <!-- ################################################################################################ -->
                <div class="content"> 
                    <!-- ################################################################################################ -->
                    <div id="gallery">
                        <figure>
                            <header class="heading">Gallery Title Goes Here</header>

                            <ul class="nospace clear">
                                <% Controladora control = new Controladora();
                                   Persona usuario = control.personaBuscar(idPersona);
                                    int i = 0;
                                    List<Criatura> listaCriaturas = control.traerCriaturas();
                                    for (Criatura criatura : listaCriaturas) {
                                    int idPropietario = 0;
                                    try{
                                      idPropietario =  criatura.getFirma().getIdFirma();
                                    }catch(NullPointerException e){
                                    
                                    }
                                    
                                        if (idPropietario == usuario.getFirma().getIdFirma()){
                                        String first = ""; //Creo varibale para poner en el css de la tabla
                                        i++;
                                        int resto = i % 4;
                                        Random r = new Random();
                                        int imagenAleatoria = r.nextInt(3);

                                        String image = "../images/demo/gallery/3.jpg";
                                        switch (imagenAleatoria) {
                                            case 0:
                                                image = "../images/demo/gallery/1.jpg";
                                                break;
                                            case 1:
                                                image = "../images/demo/gallery/2.jpg";
                                                break;
                                        }
                                        if (resto == 0) {//Es la primera posicion para el css?
                                            first = "first";
                                        }


                                %>
                                <li class="one_quarter <%=first%>">
                                    <form action="../SvMostruoBuscar" method="POST">
                                        <input type="hidden" name="id" value="<%=criatura.getIdCriatura() %>">
                                        <input class="imgOp" type="image" src=" <%=image%> " name="submit" alt="submit">
                                    </form>
                                    <a href="index.jsp"></a>
                                    <h6> <%=criatura.getNombre() %> </h6>
                                </li>
                                    <%}}%>
                            </ul>
                            <figcaption>Gallery Description Goes Here</figcaption>
                        </figure>
                    </div>
                    <!-- ################################################################################################ -->
                    <!-- ################################################################################################ -->
                    <nav class="pagination">
                        <ul>
                            <li><a href="#">&laquo; Previous</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><strong>&hellip;</strong></li>
                            <li><a href="#">6</a></li>
                            <li class="current"><strong>7</strong></li>
                            <li><a href="#">8</a></li>
                            <li><a href="#">9</a></li>
                            <li><strong>&hellip;</strong></li>
                            <li><a href="#">14</a></li>
                            <li><a href="#">15</a></li>
                            <li><a href="#">Next &raquo;</a></li>
                        </ul>
                    </nav>
                    <!-- ################################################################################################ -->
                </div>
                <!-- ################################################################################################ -->
                <!-- / main body -->
                <div class="clear"></div>
            </main>
        </div>
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <div class="wrapper row4">
            <footer id="footer" class="hoc clear"> 
                <!-- ################################################################################################ -->
                <div class="one_quarter first">
                    <h6 class="heading">Id ornare et lorem sed</h6>
                    <ul class="nospace linklist contact btmspace-30">
                        <li><i class="fas fa-map-marker-alt"></i>
                            <address>
                                Street Name &amp; Number, Town, Postcode/Zip
                            </address>
                        </li>
                        <li><i class="fas fa-phone"></i> +00 (123) 456 7890</li>
                        <li><i class="far fa-envelope"></i> info@domain.com</li>
                    </ul>
                    <ul class="faico clear">
                        <li><a class="faicon-facebook" href="#"><i class="fab fa-facebook"></i></a></li>
                        <li><a class="faicon-google-plus" href="#"><i class="fab fa-google-plus-g"></i></a></li>
                        <li><a class="faicon-linkedin" href="#"><i class="fab fa-linkedin"></i></a></li>
                        <li><a class="faicon-twitter" href="#"><i class="fab fa-twitter"></i></a></li>
                        <li><a class="faicon-vk" href="#"><i class="fab fa-vk"></i></a></li>
                    </ul>
                </div>
                <div class="one_quarter">
                    <h6 class="heading">Lacinia nunc et porta</h6>
                    <ul class="nospace linklist">
                        <li>
                            <article>
                                <p class="nospace btmspace-10"><a href="#">Porta tellus massa consectetuer sem eget pharetra ligula purus sit amet dui.</a></p>
                                <time class="block font-xs" datetime="2045-04-06">Friday, 6<sup>th</sup> April 2045</time>
                            </article>
                        </li>
                        <li>
                            <article>
                                <p class="nospace btmspace-10"><a href="#">Commodo ornare maximus donec consectetuer adipiscing elit pellentesque habitant.</a></p>
                                <time class="block font-xs" datetime="2045-04-05">Thursday, 5<sup>th</sup> April 2045</time>
                            </article>
                        </li>
                    </ul>
                </div>
                <div class="one_quarter">
                    <h6 class="heading">Non lobortis felis lacus</h6>
                    <ul class="nospace linklist">
                        <li><a href="#">Morbi tristique senectus</a></li>
                        <li><a href="#">Habitasse platea dictumst</a></li>
                        <li><a href="#">Egestas in hac habitasse</a></li>
                        <li><a href="#">Tellus ac convallis pellentesque</a></li>
                        <li><a href="#">Lacus tortor varius erat</a></li>
                    </ul>
                </div>
                <div class="one_quarter">
                    <h6 class="heading">Platea dictumst fusce</h6>
                    <ul class="nospace clear latestimg">
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                        <li><a class="imgover" href="#"><img src="../images/demo/100x100.png" alt=""></a></li>
                    </ul>
                </div>
                <!-- ################################################################################################ -->
            </footer>
        </div>
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <div class="wrapper row5">
            <div id="copyright" class="hoc clear"> 
                <!-- ################################################################################################ -->
                <p class="fl_left">Copyright &copy; 2018 - All Rights Reserved - <a href="#">Domain Name</a></p>
                <p class="fl_right">Template by <a target="_blank" href="https://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
                <!-- ################################################################################################ -->
            </div>
        </div>
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <!-- ################################################################################################ -->
        <a id="backtotop" href="#top"><i class="fas fa-chevron-up"></i></a>
        <!-- JAVASCRIPTS -->
        <script src="../layout/scripts/jquery.min.js"></script>
        <script src="../layout/scripts/jquery.backtotop.js"></script>
        <script src="../layout/scripts/jquery.mobilemenu.js"></script>
    </body>
</html>

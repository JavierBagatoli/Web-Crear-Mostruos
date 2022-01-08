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
        </style>
    </head>
    <body id="top" >
        <% HttpSession misession = request.getSession();
            Criatura criatura = (Criatura) misession.getAttribute("criatura");
            {
                String ojo1 = "No se han ingresado Ojos";
                String brazo1 = "No se han ingresado Brazos";
                String pierna1 = "No se han ingresado Piernas";
                if (criatura.getCabeza().getOjos().size() > 0){
                    ojo1 = criatura.getCabeza().getOjos().get(0).getNombre();
                }
                if (criatura.getCuerpo().getBrazos().size() > 0){
                    brazo1 = criatura.getCuerpo().getBrazos().get(0).getNombre();
                }
                if (criatura.getCuerpo().getPiernas().size() > 0){
                    pierna1 = criatura.getCuerpo().getPiernas().get(0).getNombrePierna();
                }
                
        %>        
        <h1 class="titulo"><%=criatura.getNombre() %></h1>
        <div class="contenedor">
            <div class="wrapper row4 contenedor">

                <div id="comments">
                    <form action="./MostruoEditar.jsp" method="POST" class="containerMostruo">
                        <div class="one_third first">
                            <h4 class="one_third">Cabeza:</h4>
                            <h6 class="one_half"><%=criatura.getCabeza().getNombre() %></h6>
                        </div>
                        
                        <div class="one_third first">
                            <h4 class="one_third">Ojo:</h4>
                            <h6 class="one_half"><%=ojo1 %></h6>
                        </div>
                        
                        <div class="one_third first">
                            <h4 class="one_third">Cuerpo: </h4>
                            <h6 class="one_half"><%=criatura.getCuerpo().getNombre() %></h6>
                        </div>

                        <div class="one_third first">
                            <h4 class="one_third">Brazos </h4>
                            <h6 class="one_half"><%=brazo1 %></h6>
                        </div>
                        
                        <div class="one_third first">
                            <h4 class="one_third">Piernas: </h4>
                            <h6 class="one_half"><%=pierna1 %></h6>
                        </div>               

                        <div class="block clear textarea">
                            <div class="one_third first">
                                <h4 class="one_third">Descripción: </h4>
                                <h6 class="one_half"><%=criatura.getCuerpo().getPiernas().get(0).getNombrePierna().getClass() + " " +criatura.getClass() %></h6>
                            </div>
                        </div>

                                <input type="hidden" name="id" value="<%=criatura.getIdCriatura() %>">

                        <div>
                            <input type="submit" name="submit" value="Editar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%} %>
    </body>
</html>

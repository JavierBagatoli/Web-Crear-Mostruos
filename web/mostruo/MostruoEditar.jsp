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
                    pierna1 = criatura.getCuerpo().getPiernas().get(0).getPierna();
                }
        %>        
        <h1 class="titulo">Editar <%=criatura.getNombre() %></h1>
        <div class="contenedor">
            <div class="wrapper row4 contenedor">

                <div id="comments">
                    <form action="../SvMostruoEditar" method="POST" class="containerMostruo">
                        <div class="one_third first">
                            <label for="nombreCriatura">Nombre: <span>*</span></label>
                            <input type="text" name="nombreMostruo" id="nombreMostruo" value="<%=criatura.getNombre() %>" size="22" required>
                        </div>

                        <div class="one_third first">
                            <label for="nombreCabeza">Cabeza: <span>*</span></label>
                            <input type="text" name="nombreCabeza" id="nombreCabeza" value="<%=criatura.getCabeza().getNombre() %>" size="22" required>
                        </div>

                        <div class="one_third first">
                            <label for="nombreOjo">Ojo: <span>*</span></label>
                            <input type="text" name="nombreOjo" id="nombreOjo" value="<%=ojo1 %>" size="22" required>
                        </div>

                        <div class="one_third first">
                            <label for="nombreCuerpo">Cuerpo: <span>*</span></label>
                            <input type="text" name="nombreCuerpo" id="nombreCuerpo" value="<%=criatura.getCuerpo().getNombre() %>" size="22" required>
                        </div>
                        <div class="one_third first">
                            <label for="nombreBrazo">Brazo: <span>*</span></label>
                            <input type="text" name="nombreBrazo" id="nombreBrazo" value="<%=brazo1 %>" size="22" required>
                        </div>
                        <div class="one_third">
                            <label for="nombrePierna">Pierna: <span>*</span></label>
                            <input type="text" name="nombrePierna" id="nombrePierna" value="<%=pierna1 %>" size="22" required>
                        </div>                

                        <div class="block clear textarea">
                            <label for="descripcion">Descripción: </label>
                            <textarea class="" name="descripcion" id="descripcion" rows="10"></textarea>
                        </div>
                        <!-- Campos ocultos -->
                        <input type="hidden" name="idCriatura" value="<%=criatura.getId_Criatura() %>">
                        <input type="hidden" name="idCabeza" value="<%=criatura.getCabeza().getId_Cabeza() %>">
                        <input type="hidden" name="idCriatura" value="<%=criatura.getCuerpo().getId_Persona() %>">
                        
                        <!-- Botones -->
                        <div>
                            <input type="submit" name="submit" value="Editar">
                            &nbsp;
                            <input type="reset" name="reset" value="Reset Form">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%} %>
    </body>
</html>

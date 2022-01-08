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
        </style>
    </head>
    <body id="top" >
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
                            <label for="IntervaloTemp">Intervalo de temperatura: <span>*</span></label>
                            <input type="text" name="IntervaloTemp1" id="IntervaloTemp" value="" required>
                            <input type="text" name="IntervaloTemp2" id="IntervaloTemp2" value="" required>
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


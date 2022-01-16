<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
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
        <h1 class="titulo">Login</h1>
        <div class="contenedor">
            <div class="wrapper row4 contenedor">

                <div id="comments">
                    <form action="../SvPersonaLogin" method="POST" class="containerMostruo">
                        <div class="one_third first">
                            <label for="emailUsuario">Email: <span>*</span></label>
                            <input type="text" name="emailUsuario" id="emailUsuario" value="" required>
                        </div>

                        <div class="one_third first">
                            <label for="passwordUsuario">Contraseña: <span>*</span></label>
                            <input type="password" name="passwordUsuario" id="passwordUsuario" value="" required>
                        </div>
                        <div class="first">
                            <input type="submit" name="submit" value="Iniciar Sesion">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

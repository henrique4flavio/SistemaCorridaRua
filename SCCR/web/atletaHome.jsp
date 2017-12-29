<%@page import="modelo.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>

        <title>Minha Conta</title>

        <style>
            .texto_grande {
                font-size: 2.5rem;
                color: white;
            } 
            #icone_grande {
                font-size: 8rem;
                color:#fff;
            } 
        </style>

        <script> function validaSenha(input) {
                if (input.value != document.getElementById('senha').value) {
                    input.setCustomValidity('Repita a senha corretamente');
                } else {
                    input.setCustomValidity('');
                }
            }
        </script>
        <script>
            function idAtleta1() {

                var id = prompt("Digite o id do Atleta:", "id");
                if (id == null || id == "") {
                    txt = "User cancelled the prompt.";
                } else {
                    location.href = 'ManterAtletaController?acao=prepararEditar&id=' + id;
                }

            }
        </script>

        <script>
            function idAtleta2() {

                var id = prompt("Digite o id do Atleta:", "id");
                if (id == null || id == "") {
                    txt = "User cancelled the prompt.";
                } else {
                    location.href = 'ManterAtletaController?acao=prepararExcluir&id=' + id;
                }

            }
        </script>



    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/> 

        <div class="container">


            <div class="panel-title">
                <h3><span class="glyphicon glyphicon-user"></span> <strong>Bem Vindo Atleta</strong> </h3>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10">
                            <a href="#" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Minhas Inscrições</a>
                            <button onclick="idAtleta1()" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-user"></span> <br/>Alterar dados Pessoais</a></button>
                            <a href="#" class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> <br/>Consultar Resultados</a> 
                            <a href="#" class="btn btn-primary btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Rankings</a>
                            <button onclick="idAtleta2()" class="btn btn-danger btn-lg" role="button"><span class="glyphicon glyphicon-floppy-remove"></span> <br/>Excluir Conta</a></button>
                            <a href="LoginController?acao=logout" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-log-out"></span> <br/>Sair</a>

                        </div>

                    </div>

                </div>
            </div>
        </div>
        <p class="text-center lead">Please remove this line =).
            <br>It will be better visualized in Bootstrap 3.2.0 Lumem Theme, to use lumem theme<br>
            please <a href="http://bootswatch.com/lumen/">visit the lumem theme page</a>. You can also, use bootstrap themes menu, just up here ^^.
            <br>To have access to a large icons list, please use  <a href="http://fortawesome.github.io/">FontAwesome</a> instead of bootstrap default option (Glyphicons).</p>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container">
            <div class="col-md-3">
                <a class="btn btn-block btn-lg btn-success" data-toggle="modal" data-target="#mymodal">
                    <i class="fa fa-users" id="icone_grande"></i> <br><br>
                    <span class="texto_grande"><i class="fa fa-plus-circle"></i> ADD Usuários</span></a>
            </div>
            <div class="col-md-3">
                <a class="btn btn-block btn-lg btn-danger" data-toggle="modal" data-target="#mymodal">
                    <i class="fa fa-user" id="icone_grande"></i> <br><br>
                    <span class="texto_grande"><i class="fa fa-times-circle-o"></i> DEL Usuários</span></a>
            </div>
            <div class="col-md-3">
                <a class="btn btn-block btn-lg btn-primary" data-toggle="modal" data-target="#mymodal">
                    <i class="fa fa-cog fa-spin" id="icone_grande"></i> <br><br>
                    <span class="texto_grande"><i class="fa fa-edit"></i> EDIT Usuários</span></a>
            </div>
            <div class="col-md-3">
                <a class="btn btn-block btn-lg btn-warning" data-toggle="modal" data-target="#mymodal">
                    <i class="fa fa-pied-piper-alt" id="icone_grande"></i> <br><br>
                    <span class="texto_grande"><i class="fa fa-list-ul"></i> LIST Usuários</span></a>
            </div> 
        </div>


        <jsp:include page="footer.jspf"/>


    </body>
</html>
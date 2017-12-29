

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Minha Conta</title>

        <script> function validaSenha(input) {
                if (input.value != document.getElementById('senha').value) {
                    input.setCustomValidity('Repita a senha corretamente');
                } else {
                    input.setCustomValidity('');
                }
            }
        </script>
        <script>
            function idOrganizador1() {

                var id = prompt("Digite o id do Organizador:", "id");
                if (id == null || id == "") {
                    txt = "User cancelled the prompt.";
                } else {
                    location.href = 'ManterOrganizadorController?acao=prepararEditar&id=' + id;
                }

            }
        </script>
        <script>
            function idOrganizador2() {

                var id = prompt("Digite o id do Organizador:", "id");
                if (id == null || id == "") {
                    txt = "User cancelled the prompt.";
                } else {
                    location.href = 'ManterOrganizadorController?acao=prepararExcluir&id=' + id;
                }

            }
        </script>


    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/> 

        <div class="container">


            <div class="panel-title">
                <h3><span class="glyphicon glyphicon-user"></span> <strong>Bem Vindo Organizador(a)</strong> </h3>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10">
                            <a href="#" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Minhas Provas</a>
                            <button onclick="idOrganizador1()" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-user"></span> <br/>Alterar dados Pessoais</a></button>
                            <a href="PesquisaRankingController" class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> <br/>Cadastrar Rankings</a> 
                            <a href="PesquisaInscricaoController" class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> <br/>Manter Inscrições</a> 
                            <a href="PesquisaItemController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> </br>Manter itens</a><br><br>
                            <a href="PesquisaKitController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> </br>Manter kits</a>
                            <a href="PesquisaElementoKitController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> </br>>Manter elementos kits</a>


                            <a href="PesquisaLoteController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> </br>Manter lotes</a>

                            <a href="PesquisaPercursoController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> </br>Manter percursos</a>
                            <a href="PesquisaProvaController?acao=listarProvas"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> </br>Manter provas</a> <br><br>
                            <a href="PesquisaRankingController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> </br>Manter rankings</a>



                            <button onclick="idOrganizador2()" class="btn btn-danger btn-lg" role="button"><span class="glyphicon glyphicon-floppy-remove"></span> <br/>Excluir Conta</a></button>
                            <a href="LoginController?acao=logout" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-log-out"></span> <br/>Sair</a>


                        </div>

                    </div>

                </div>
            </div>
        </div>


        <jsp:include page="footer.jspf"/>


    </body>
</html>
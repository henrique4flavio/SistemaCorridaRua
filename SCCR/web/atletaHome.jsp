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

                 <div class="row">
                        <div class="col-md-10">
                            <a  class="btn btn-warning btn-lg"  href="ObterInscricaoAtletaController?acao=exibirInscricoes&id=<c:out value="${atleta.id}"/>"><span class="glyphicon glyphicon-list-alt"></span> <br/>Minhas Inscrições</a></span>
                             <a class="btn btn-success btn-lg" href="ManterAtletaController?acao=editarAtleta&id=<c:out value="${atleta.id}"/>"><span class="glyphicon glyphicon-user"></span> <br/>Alterar Dados Pessoais</a></span>
                             <a class="btn btn-danger btn-lg" href="ManterAtletaController?acao=excluirAtleta&id=<c:out value="${atleta.id}"/>"><span class="glyphicon glyphicon-floppy-remove"></span> <br/>Excluir Conta</a></span><br><br>
                    <a href="LoginController?acao=logout" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-log-out"></span> <br/>Sair</a>

                                   
                        </div>

                    </div>

                </div>
                
            </div>
        </div>
    



                </div>
                
            </div>
        </div>
       

        <jsp:include page="footer.jspf"/>


    </body>
</html>
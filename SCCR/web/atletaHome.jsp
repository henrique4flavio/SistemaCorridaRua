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
       
    </head>
    <body>
        
         <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                       <li> <c:if test="${tipo != null}"> <a href="${tipo}Home.jsp">Sistema de Corrida de Rua</a></c:if> 
                        <c:if test="${tipo == null}"> <a href="index.jsp">Sistema de Corrida de Rua</a></c:if>
                             </li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="PesquisaProvaController?acao=gridProvas" ><span class=" glyphicon glyphicon-th"></span>  Provas</a> </li>

                            <li><a href="PesquisaResultadoRanking?acao=visualizarRanking"><span class="glyphicon glyphicon-list-alt"></span> Ranking</a> </li>
                            <li><a href="PesquisaResultadoProvasController?acao=visualizarProvas" ><span class="
                                                                                                         glyphicon glyphicon-expand"></span> Resultado Provas</a> </li>


                            <li><a href="${tipo}Home.jsp"><span class="glyphicon glyphicon-user"></span> 
                                <%
                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                                    String nome = usuario.getNome();
                                %>
                                <%=nome%> 

                            </a> </li>

                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">


            <div class="panel-title">
                <h3><span class="glyphicon glyphicon-user"></span> <strong>Bem Vindo(a) <%=nome%> </strong> </h3>

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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Administrador"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Resultado Provas</title>

        <script>
            function pesquisa(input) {

                var pesquisa = document.getElementById('search');
                location.href = 'PesquisaProvaController?acao=pesquisa&nome=' + pesquisa.value;
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
                        <li ><a href="${tipo}Home.jsp">Sistema de Corrida de Rua </a></li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="PesquisaProvaController?acao=gridProvas" ><span class=" glyphicon glyphicon-th"></span>  Provas</a> </li>

                        <li><a href="PesquisaResultadoRanking?acao=visualizarRanking"><span class="glyphicon glyphicon-list-alt"></span> Ranking</a> </li>
                        <li><a href="PesquisaResultadoProvasController?acao=visualizarProvas" ><span class="
                                                                                                     glyphicon glyphicon-expand"></span> Resultado Provas</a> </li>


                        <li><a href="administradorHome.jsp" ><span class="glyphicon glyphicon-user"></span> 
                                <%
                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                                    String nome = usuario.getNome();
                                %>
                                <%=nome%> 
                                
                            </a> </li>
                    </ul>
                </div>
            </div>
        </nav>
       
        <div id="main" class="container-fluid" style="margin-top: 50px">

            <h2>Prova - Asconcer - Resultado  - 01 Junho 2017</h2>
        </div>
        <div id="main" class="container-fluid" style="margin-top: 50px">
            <h3> Resultado</h3>
        </div>
        <hr />
        <div id="list" class="row">

            <div class="table-responsive col-md-12">
                <table class="table table-striped" cellspacing="0" cellpadding="0">
                    <thead>
                        <tr>
                            <th>Classificação</th>
                            <th>Atleta</th>
                            <th> Categoria</th>
                            <th>Tempo</th>
                            <th>Numero de Peito</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${resultadoProvas}" var="resultadoProvas">
                            <tr>
                                <td><c:out value = "${resultadoProvas.classificacao}" /></td>
                                <td><c:out value = "${resultadoProvas.nomeAtleta}" />
                                </td>


                                <td><c:out value = "${resultadoProvas.categoria}" /></td>
                                <td><c:out value = "${resultadoProvas.tempo}" /></td>
                                <td>  <c:out value = "${resultadoProvas.numeroPeito}" /></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>

        </div> <!-- /#list -->



        <!-- Modal -->
        <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir este item?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Sim</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <jsp:include page="footer.jspf"/>

    </body>
</html>




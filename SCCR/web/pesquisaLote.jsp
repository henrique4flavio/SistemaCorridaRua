
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter lotes</title>
        <script src="./resources/bootstrap/js/jquery-3.2.1.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#idTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
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
        <div class="col-sm-3">
            <h2>Lotes</h2>
        </div>
        <div class="col-sm-6">
            <input class="form-control" id="myInput" type="text" placeholder="Search..">


        </div> <!-- /#top -->
        <div class="col-sm-3">
            <form action ="ManterLoteController?acao=prepararIncluir" method="post">
                <input type="submit" name="btIncluir" value="Novo Lote" class="btn btn-primary pull-right h2">


            </form> 
        </div>
        <div id="list" class="row">
            <div class="table-responsive col-md-12">
                <table class="table table-striped" cellspacing="0" cellpadding="0" >

                    <thead>

                        <tr>

                            <th>Código do Lote</th>
                            <th>Identificação</th>
                            <th>Prova</th>
                            <th>Data de Inicio</th>
                            <th>Data do Fim</th>
                            <th>Desconto</th>

                        </tr>    
                        </thread>
                    <tbody id="idTable">
                        <c:forEach items="${lotes}" var="lote">
                            <tr>

                                <td><c:out value = "${lote.id}" /></td>
                                <td><c:out value = "${lote.identificacao}" /></td>

                                <td><c:forEach items="${provas}" var ="prova">
                                        <c:if test="${prova.id ==lote.prova_id}"> ${prova.nomeProva}</c:if>

                                    </c:forEach>
                                </td>
                                <td><c:out value = "${lote.dataInicio}" /></td>
                                <td><c:out value = "${lote.dataFim}" /></td>
                                <td><c:out value = "${lote.desconto}" /></td>

                                <td> <a href="ManterLoteController?acao=prepararEditar&id=<c:out value="${lote.id}"/>"><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                                <td> <a href="ManterLoteController?acao=prepararExcluir&id=<c:out value="${lote.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                                 
                </body>
                </html>



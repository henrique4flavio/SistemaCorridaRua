
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Ranking</title>
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


    <center><h3>${operacao} Ranking</h3></center>
    <div class="col-md-6">
            <form action="ManterRankingController?acao=confirmar${operacao}" method="post" name="frmManterRanking">
                <div class="form-group">

                    <label for="exampleInputEmail1">Código do Ranking:</label>
                    <input type="text" name="txtIdRanking" class="form-control" value="${ranking.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Nome:</label>
                        <input type="text" name="txtNomeRanking" class="form-control" value="${ranking.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    
                

                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="PesquisaRankingController" class="btn btn-default">Cancelar</a>

            </form>                   
        </div> 	
    
    <jsp:include page="footer.jspf"/>

</body>
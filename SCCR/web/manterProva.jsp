

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Prova</title>


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

                        
                    </ul>
                </div>
            </div>
        </nav>
    <center><h3>${operacao} Prova</h3></center>
    <div class="container">
        <div class="col-md-6">
            <form action="ManterProvaController?acao=confirmar${operacao}" method="post" name="frmManterProva">
                <div class="form-group">

                    <label for="exampleInputEmail1">Código do Prova:</label>
                    <input type="text" name="txtId" class="form-control" value="${prova.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Nome da Prova:</label>
                        <input type="text" name="txtNomeProva" class="form-control" value="${prova.nomeProva}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Local da largada:</label>
                        <input type="text" name="txtLocalLargada" value="${prova.localLargada}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Local de Retirada do Kit:</label>
                        <input type="text" name="txtLocalRetiradaKit" value="${prova.localRetiradaKit}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Horario da largada:</label>
                        <input type="text" name="txtHorarioLargada" value="${prova.horarioLargada}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Data da Prova:</label>
                        <input type="text" name="txtDataProva" value="${prova.dataProva}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Máximo de Participantes:</label>
                        <input type="text" name="txtmaxParticipantes" value="${prova.maxParticipantes}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Início das Inscrições:</label>
                        <input type="text" name="txtInicioInscricao" value="${prova.inicioInscricao}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Fim das Inscrições:</label>
                        <input type="text" name="txtFimInscricao" value="${prova.fimInscricao}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Faixa Etária:</label>
                        <input type="text" name="txtFaixaEtaria" value="${prova.faixaEtaria}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Valor da Prova:</label>
                        <input type="text" name="txtValorProva" value="${prova.valorTotal}" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Organizador:</label>
                        <select class="form-control" name="optOrganizador"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${prova.organizador_id == null}"> selected</c:if>> </option>  
                        <c:forEach items="${organizador}" var="organizador">
                            <option value="${organizador.id}" <c:if test="${organizador.id == prova.organizador_id}"> selected</c:if>>${organizador.nome}</option>  
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Ranking:</label>
                    <select class="form-control" name="optRanking"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option  value="0" <c:if test="${prova.ranking_id == null}"> selected</c:if>> </option>  
                        <c:forEach items="${ranking}" var="ranking">
                            <option value="${ranking.id}" <c:if test="${ranking.id == prova.ranking_id}"> selected</c:if>>${ranking.nome}</option>  
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="PesquisaProvaController" class="btn btn-default">Cancelar</a> <br><br><br><br><br><br>

            </form>                   
        </div> 	
    </div>

    <jsp:include page="footer.jspf"/>

</body>

</html>





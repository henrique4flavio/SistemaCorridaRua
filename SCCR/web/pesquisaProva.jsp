
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter provas</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <table class="table table-bordered">    
            <tr>

                <th>Código da prova</th>
                <th>Nome da prova</th>
                <th>Local de largada</th>
                <th>Local de Retirada do Kit</th>
                <th>Horario da largada</th>
                <th>Data da prova</th>
                <th>Maximo de participantes</th>
                <th>Inicio das inscrições</th>
                <th>Fim das inscrições</th>
                <th>Faixa etaria</th>
                <th>Nome do organizador</th>
                <th>Nome do ranking</th>

            </tr>    

            <c:forEach items="${provas}" var="prova">
                <tr>

                    <td><c:out value = "${prova.id}" /></td>
                    <td><c:out value = "${prova.nomeProva}" /></td>
                    <td><c:out value = "${prova.localLargada}" /></td>
                    <td><c:out value = "${prova.localRetiradaKit}" /></td>
                    <td><c:out value = "${prova.horarioLargada}" /></td>
                    <td><c:out value = "${prova.dataProva}" /></td>
                    <td><c:out value = "${prova.maxParticipantes}" /></td>
                    <td><c:out value = "${prova.inicioInscricao}" /></td>
                    <td><c:out value = "${prova.fimInscricao}" /></td>
                    <td><c:out value = "${prova.faixaEtaria}" /></td>
                    <td><c:forEach items="${organizadores}" var ="organizador">
                            ${organizador.nome} <c:if test="${organizadar.id ==prova.organizador_id}"></c:if>
                               
                       </td>
                        </c:forEach>
                    <td><c:forEach items="${ranking}" var ="ranking">
                            ${ranking.nome} <c:if test="${ranking.id ==prova.ranking_id}"></c:if>
                               
                       </td>
                        </c:forEach>

                    <td> <a href="ManterProvaController?acao=prepararEditar&id=<c:out value="${prova.id}"/>"> <button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterProvaController?acao=prepararExcluir&id=<c:out value="${prova.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>

               </tr>                                                                  
            </c:forEach>
        </table>
        <form action ="ManterProvaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

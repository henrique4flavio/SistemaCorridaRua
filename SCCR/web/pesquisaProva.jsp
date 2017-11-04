
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Provas</title>
    </head>
    <body>
        <h1>Provas</h1>
        <table border='1'>    
            <tr>

                <th>Código da prova</th>
                <th>Nome da prova</th>
                <th>Local de largada</th>
                <th>Horario da largada</th>
                <th>Data da prova</th>
                <th>Maximo de participantes</th>
                <th>Inicio das inscrições</th>
                <th>Fim das inscrições</th>
                <th>Faixa etaria</th>
                <th>Código do organizador</th>
                <th>Código do ranking</th>

            </tr>    

            <c:forEach items="${Prova}" var="prova">
                <tr>

                    <td><c:out value = "${prova.id}" /></td>
                    <td><c:out value = "${prova.nomeProva}" /></td>
                    <td><c:out value = "${prova.localLargada}" /></td>
                    <td><c:out value = "${prova.horarioLargada}" /></td>
                    <td><c:out value = "${prova.dataDaProva}" /></td>
                    <td><c:out value = "${prova.maxParticipantes}" /></td>
                    <td><c:out value = "${prova.dataInicioInscricao}" /></td>
                    <td><c:out value = "${prova.dataFimInscricao}" /></td>
                    <td><c:out value = "${prova.faixaEtaria}" /></td>
                    <td><c:out value = "${prova.organizador_id}" /></td>
                    <td><c:out value = "${prova.ranking_id}" /></td>

                    <td> <a href="ManterProvaController?acao=prepararEditar&Editar&id = <c:out value="${prova.id}"/>"> Editar </a></td>
                    <td> <a href="ManterProvaController?acao=prepararExcluir&id = <c:out value="${prova.id}"/>">Excluir </a><td>

               </tr>                                                                  
            </c:forEach>
        </table>
        <br><br>
        <form action ="ManterProvaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

<%-- 
    Document   : pesquisaInscricao
    Created on : 12/10/2017, 14:02:12
    Author     : Laís Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscrição</title>
    </head>
    <body>
        <h1>Inscrição do Atleta</h1>
        <table>    
            <tr>

                <th>Id</th>
                <th> dataInscricao</th>
                <th> numeroInscricao</th>
                <th>formaPagamento</th>
                <th>kit_ID</th>
                <th>controle_chip_retornavel_ID</th>
                <th>prova_ID</th>
                <th> percurso_ID</th>
                <th>atleta_ID</th>
            </tr>    
            <c:forEach items="${Inscricao}" var="Inscricao">
                <tr>

                    <td><c:out value = "${Inscricao.id}" /></td>
                <td><c:out value = "${Inscricao.dataInscricao}" /></td>
                <td><c:out value = "${Inscricao.numeroInscricao}" /></td>
                <td><c:out value = "${Inscricao.formaPagamento}" /></td>
                <td><c:out value = "${Inscricao.kit_id}" /></td>
                <td><c:out value = "${Inscricao.controle_chip_retornavel_id}" /></td>
                <td><c:out value = "${Inscricao.prova_id}" /></td>
                <td><c:out value = "${Inscricao.percurso_id}" /></td>
                <td><c:out value = "${Inscricao.atleta_id}" /></td>

                <td><a href ="ManterControleChipRetornavel?acao=prepararEditar&ID_administrador" <c:out value="${ControleChipRetornavel.id}"/>">Editar</a></td>
                <td><a href ="ManterControleChipRetornavel?acao=prepararEditar&ID_administrador" <c:out value="${ControleChipRetornavel.id}"/>">Excluir</a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterControleChipRetornavel?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    

    </body>
</html>

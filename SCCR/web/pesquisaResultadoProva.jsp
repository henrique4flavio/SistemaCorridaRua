
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado prova</title>
    </head>
    <body>
        <h1>Resultado das provas</h1>
        <table border='1'>    
            <tr>

                <th>Código do resultado da prova</th>
                <th>Resultado da classificação</th>
                 <th>Nome Prova</th>

            </tr>    

            <c:forEach items="${ResultadoProva}" var="resultadoProva">
                <tr>

                    <td><c:out value = "${resultadoProva.id}" /></td>
                    <td><c:out value = "${resultadoProva.resultadoClassificacao}" /></td>
                    <td><c:out value = "${resultadoProva.nomeProva}" /></td>
                    <td> <a href="ManterResultadoProvaController ?acao=prepararEditar&Editar&id = <c:out value="${resultadoProva.id}"/>"> Editar </a></td>
                    <td> <a href="ManterResultadoProvaController?acao=prepararExcluir&id = <c:out value="${resultadoProva.id}"/>">Excluir </a><td>
                        
                </tr>                                                                  
            </c:forEach>
        </table>
        <br><br>
        <form action ="ManterResultadoProvaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

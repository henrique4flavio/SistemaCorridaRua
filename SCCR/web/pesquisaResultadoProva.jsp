
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Resultado prova</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <table class="table table-bordered">   
            <tr>

                <th>Código do resultado da prova</th>
                <th>Resultado da classificação</th>
                 <th>Nome Prova</th>

            </tr>    

            <c:forEach items="${resultadoProvas}" var="resultadoProva">
                <tr>

                    <td><c:out value = "${resultadoProva.id}" /></td>
                    <td><c:out value = "${resultadoProva.resultadoClassificacao}" /></td>
                    <td><c:out value = "${resultadoProva.nomeProva}" /></td>
                    <td> <a href="ManterResultadoProvaController?acao=prepararEditar&id=<c:out value="${resultadoProva.id}"/>"> <button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterResultadoProvaController?acao=prepararExcluir&id=<c:out value="${resultadoProva.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>
                        
                </tr>                                                                  
            </c:forEach>
        </table>
        <form action ="ManterResultadoProvaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

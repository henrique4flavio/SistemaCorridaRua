
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter percursos</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <table class="table table-bordered">    
            <tr>
                
                <th>Código do percurso</th>
                <th>Nome do percurso</th>
                <th>Distancia</th>
                <th>Faixa Etaria</th>
                <th>Nome da Prova</th>
                            
            </tr>    

            <c:forEach items="${percursos}" var="percurso">
                <tr>

                    <td><c:out value = "${percurso.id}" /></td>
                    <td><c:out value = "${percurso.nome}" /></td>
                    <td><c:out value = "${percurso.distancia}" /></td>
                    <td><c:out value = "${percurso.faixaEtaria}" /></td>
                    <td> 
                    <c:forEach items="${provas}" var="prova">
                               ${prova.nomeProva} <c:if test="${prova.id == percurso.prova_id}"> </c:if>
                                 
 
                            </c:forEach> 
                    </td>


                    <td> <a href="ManterPercursoController?acao=prepararEditar&id=<c:out value="${percurso.id}"/>"> <button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterPercursoController?acao=prepararExcluir&id=<c:out value="${percurso.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>


                </tr>                                                                  
            </c:forEach>
        </table>
        <form action ="ManterPercursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

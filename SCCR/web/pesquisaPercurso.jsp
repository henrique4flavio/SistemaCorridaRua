
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Percursos</title>
    </head>
    <body>
        <h1>Percursos</h1>
        <table border='1'>    
            <tr>
                
                <th>Código do percurso</th>
                <th>Nome do percurso</th>
                <th>Distancia</th>
                <th>Faixa Etaria</th>
                <th>Código da prova</th>
                            
            </tr>    

            <c:forEach items="${Percurso}" var="percurso">
                <tr>

                    <td><c:out value = "${percurso.id}" /></td>
                    <td><c:out value = "${percurso.nome}" /></td>
                    <td><c:out value = "${percurso.distancia}" /></td>
                    <td><c:out value = "${percurso.faixaEtaria}" /></td>
                    <td><c:out value = "${percurso.prova_id}" /></td>


                    <td> <a href="ManterPercursoController ?acao=prepararEditar&Editar&ID_percurso = <c:out value="${percurso.id}"/>"> Editar </a></td>
                    <td> <a href="ManterPercursoController?acao=prepararExcluir&ID_percurso = <c:out value="${percurso.id}"/>">Excluir </a><td>


                </tr>                                                                  
            </c:forEach>
        </table>
        <form action ="ManterPercursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

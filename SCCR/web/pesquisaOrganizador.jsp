
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Pesquisa de Organizadores</title>
    </head>

    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3> Organizadores</h3>
        <table class="table table-bordered">
            <tr>
                <th> Código do Organizador  </th>
                <th> Nome</th>
                <th> Login </th>
                <th> Senha</th>
                <th> email</th>
                <th> Código do administrador</th>
                
            </tr>
            <c:forEach items="${organizadores}" var="organizador">
                <tr> 
                    <td> <c:out value="${organizador.id}"/> </td>
                    <td> <c:out value= "${organizador.nome}"/></td>
                    <td> <c:out value= "${organizador.login}"/></td>
                    <td> <c:out value="${organizador.senha}"/> </td>
                    <td> <c:out value="${organizador.email}"/> </td>
                    <td> <c:out value="${organizador.administrador_id}"/> </td>
                
                    <td> <a href="ManterOrganizadorController?acao=prepararEditar&id=<c:out value="${organizador.id}"/>"> Editar </a></td><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterOrganizadorController?acao=prepararExcluir&id=<c:out value="${organizador.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterOrganizadorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>     
    </body>
</html>


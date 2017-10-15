
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Organizadores</title>
    </head>
//int id, String nome, String senha, String login, String email, String administrador_id
    <body>
        <h1> Pesquisa de Organizadores</h1>
        <table border='1'>
            <tr>
                <th> Código do Organizador  </th>
                <th> Nome</th>
                <th> Login </th>
                <th> Senha</th>
                <th> email</th>
                <th> Administrador</th>
                
            </tr>
            <c:forEach items="${Organizador}" var="Organizador">
                <tr> 
                    <td> <c:out value="${Organizador.id}"/> </td>
                    <td> <c:out value= "${Organizador.nome}"/></td>
                    <td> <c:out value= "${Organizador.login}"/></td>
                    <td> <c:out value="${Organizador.senha}"/> </td>
                    <td> <c:out value="${Organizador.email}"/> </td>
                    <td> <c:out value="${Organizador.administrador_id}"/> </td>
                
                    <td> <a href="ManterOrganizadorController ?acao=prepararEditar&Editar&id = <c:out value="${Organizador.id}"/>"> Editar </a></td>
                    <td> <a href="ManterOrganizadorController?acao=prepararExcluir&id = <c:out value="${Organizador.id}"/>">Excluir </a><td>

                </tr>

            </c:forEach>
        </table>
        <form action ="ManterOrganizadorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>     


    </body>
</html>


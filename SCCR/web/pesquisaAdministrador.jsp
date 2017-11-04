
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administradores</title>
    </head>
    <body>
        <h1>Administradores</h1>
        <table border='1'>    
            <tr>

                <th>Código do administrador</th>
                <th>Nome do administrador</th>
                <th>Senha</th>
                <th>Login</th>
                <th>Email</th>



            </tr>    
                
            <c:forEach items="${Administrador}" var="administrador">
                <tr>

                    <td><c:out value = "${administrador.id}" /></td>
                    <td><c:out value = "${administrador.nome}" /></td>
                    <td><c:out value = "${administrador.senha}" /></td>
                    <td><c:out value = "${administrador.login}" /></td>
                    <td><c:out value = "${administrador.email}" /></td>
                    <td><a href ="ManterAdministradorController?acao=prepararEditar&ID_administrador <c:out value="${administrador.id}"/>">Editar</a></td>
                    <td><a href ="ManterAdministradorController?acao=prepararEditar&ID_administrador <c:out value="${administrador.id}"/>">Excluir</a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterAdministradorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    


    </body>
</html>


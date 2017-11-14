
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
       <jsp:include page="bootstrap.jspf"/>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>Administradores</h3>
        <table class="table table-bordered">
            <thead>
            <tr>

                <th>Código do administrador</th>
                <th>Nome do administrador</th>
                <th>Senha</th>
                <th>Login</th>
                <th>Email</th>
            </tr>  
         </thead>
                
            <c:forEach items="${administradores}" var="administrador">
                <tr>

                    <td><c:out value = "${administrador.id}" /></td>
                    <td><c:out value = "${administrador.nome}" /></td>
                    <td><c:out value = "${administrador.senha}" /></td>
                    <td><c:out value = "${administrador.login}" /></td>
                    <td><c:out value = "${administrador.email}" /></td>
                    <td><a href ="ManterAdministradorController?acao=prepararEditar&id=<c:out value="${administrador.id}"/>"><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td><a href ="ManterAdministradorController?acao=prepararExcluir&id=<c:out value="${administrador.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterAdministradorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    


    </body>
</html>


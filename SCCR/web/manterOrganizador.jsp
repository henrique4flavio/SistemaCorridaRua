

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
           
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter organizador</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>${operacao}</h3>

        <form class="form-horizontal" action="ManterOrganizadorController?acao=confirmar${operacao}" method="post" name="frmManterOrganizador">
            <table>
                <tr>
                    <td>Código do organizador:</td> 
                    <td><input type="text" name="txtIdOrganizador" value="${organizador.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome do organizador:</td> 
                        <td><input type="text" name="txtNomeOrganizador" value="${organizador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
            
                    <tr>
                        <td>Email:</td> 
                        <td><input type="text" name="txtEmail" value="${organizador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Login:</td> 
                        <td><input type="text" name="txtLogin" value="${organizador.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Senha:</td> 
                        <td><input type="text" name="txtSenha" value="${organizador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                        <td>Administrador:</td>
                        <td>
                         <select id="optAdministrador"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${organizador.administrador_id == null}"> selected</c:if>> </option>  
                            <c:forEach items="${administrador}" var="administrador">
                                <option value="${administrador.id}" <c:if test="${administrador.id == organizador.administrador_id}"> selected</c:if>>${administrador.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                        
                        </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>

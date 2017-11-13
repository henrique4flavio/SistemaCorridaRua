
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Organizador</title>
    </head>
    <body>
        <h1>Manter Organizador - ${operacao}</h1>

        <form action="ManterOrganizadorController?acao=confirmar${operacao}" method="post" name="frmManterOrganizador">
            <table>
                <tr>
                    <td>Código do Organizador:</td> 
                    <td><input type="text" name="txtIdOrganizador" value="${organizador.id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                    </tr>
                    
                    <tr>
                        <td>Nome do organizador:</td> 
                        <td><input type="text" name="txtNomeOrganizador" value="${organizador.nome}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>Senha:</td> 
                        <td><input type="text" name="txtSenhaOrganizador" value="${organizador.senha}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                    </tr>
                    <tr>
                        <td>login</td> 
                        <td><input type="text" name="txtloginOganizador" value="${organizador.login}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                    </tr>
                   
                    <tr>
                        <td>Email:</td> 
                        <td><input type="text" name="txtEmailOrganizador" value="${organizador.email}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                    </tr> 
                    <tr>
                        <td>Codigo do Administrador </td> 
                        <td><input type="text" name="txtCodigoAdministrador" value="${organizador.administrador_id}" <c:if test="${operacao != 'Incluir'}"> readonly </c:if>></td>
                    </tr>
                    
                    <tr>
                        <td>Administrador</td>
                    <td>
                                       
                        <select name="optAdministrador" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${organizador.administrador.id== null}"> selected</c:if>>Selecione o administrador</option>  
                            <c:forEach items="${administradores}" var="administrador">
                                <option value="${administrador.id}" <c:if test="${organizador.administrador_id == administrador.id}"> selected </c:if>>${administrador.nome}</option>  
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

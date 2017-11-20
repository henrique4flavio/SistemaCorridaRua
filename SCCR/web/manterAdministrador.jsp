

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Administrador</title>

        <script> function validaSenha(input) {
                if (input.value != document.getElementById('senha').value) {
                    input.setCustomValidity('Repita a senha corretamente');
                } else {
                    input.setCustomValidity('');
                }
            }
        </script>


    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <h3>${operacao}</h3>

        <form class="form-horizontal" action="ManterAdministradorController?acao=confirmar${operacao}" method="post" name="frmManterAdministrador">
            <table>
                <tr>
                    <td>Código do Administrador:</td> 
                    <td><input type="text" name="txtIdAdministrador" value="${administrador.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome do administrador:</td> 
                        <td><input type="text" name="txtNomeAdministrador" value="${administrador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Email:</td> 
                        <td><input type="text" name="txtEmail" value="${administrador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Login:</td> 
                        <td><input type="text" name="txtLoginAdm" value="${administrador.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Senha:</td> 
                        <td><input type="password" id="senha" name="txtSenhaAdm" value="${administrador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Confirmar Senha:</td> 
                        <td><input type="password" name="txtValidadaSenha" oninput="validaSenha(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>

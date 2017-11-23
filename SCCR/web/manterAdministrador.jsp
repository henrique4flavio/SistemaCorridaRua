

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
    <center><h3>${operacao}</h3></center>
    <div class="col-md-6">
            <form action="ManterAdministradorController?acao=confirmar${operacao}" method="post" name="frmManterAdministrador">
                <div class="form-group">

                    <label for="exampleInputEmail1">Código do Administrador:</label>
                    <input type="text" name="txtIdAdministrador" class="form-control" value="${administrador.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Nome:</label>
                        <input type="text" name="txtNomeAdministrador" class="form-control" value="${administrador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Email:</label>
                        <input type="text" name="txtEmail" class="form-control" value="${administrador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Login:</label>
                        <input type="text" name="txtLoginAdm" class="form-control" value="${administrador.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Senha:</label>
                        <input type="password" id="senha" name="txtSenhaAdm" class="form-control" value="${administrador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Confirmar Senha:</label>
                        <input type="password" name="txtValidadaSenha" class="form-control" oninput="validaSenha(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>

                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="PesquisaAdministradorController" class="btn btn-default">Cancelar</a>

            </form>                   
        </div> 	

</body>

</html>

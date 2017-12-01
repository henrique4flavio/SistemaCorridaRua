

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Atleta</title>

        <script> function validaSenha(input) {
                if (input.value != document.getElementById('senha').value) {
                    input.setCustomValidity('Repita a senha corretamente');
                } else {
                    input.setCustomValidity('');
                }
            }
        </script>
        <script> function validaEmail(input) {
                if (input.value != document.getElementById('email').value) {
                    input.setCustomValidity('Repita o email corretamente');
                } else {
                    input.setCustomValidity('');
                }
            }
        </script>

    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>




        <div class="container">
            <c:if test="${operacao != 'Incluir'}"> <h3>${operacao} Atleta</h3></c:if>
            <c:if test="${operacao == 'Incluir'}"> <h3 class="titAlterarDados">Cadastre-se</h3></c:if>

                <form action="ManterAtletaController?acao=confirmar${operacao}" method="post" name="frmManterAtleta">
                <div class="row">
                    <div class="col-md-2">

                        <label for="exampleInputEmail1">Código do Atleta:</label>
                        <input type="text" name="txtIdAtleta" class="form-control" value="${atleta.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                        </div>
                        <div class="col-md-6">
                            <label for="exampleInputPassword1">Nome Completo:</label>
                            <input type="text" name="txtNomeAtleta" class="form-control" value="${atleta.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>

                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Apelido:</label>
                            <input type="text" name="txtApelido" class="form-control" value="${atleta.apelido}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="col-md-4">
                            <label for="exampleInputPassword1">CPF:</label>
                            <input type="text" name="txtCpf" class="form-control" value="${atleta.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>

                        <div class="col-md-2">

                            <label for="exampleInputPassword1">Sexo:</label>
                            <select class="form-control" name="optSexo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Masculino" <c:if test="${atleta.sexo == 'Masculino'}"> selected</c:if>>Masculino</option>
                            <option value="Feminino" <c:if test="${atleta.sexo == 'Feminino'}"> selected</c:if>>Feminino</option>
                            </select>

                        </div>

                        <div class="col-md-2">
                            <label for="exampleInputPassword1">Data de Nascimento:</label>
                            <input type="text" name="txtDataNascimento" class="form-control" value="${atleta.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>



                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Tamanho da Camisa:</label>
                            <select class="form-control" name="optTamanhoCamisa" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="M" <c:if test="${tamCamisa == 'M'}"> selected</c:if>>M</option>
                            <option value="P" <c:if test="${tamCamisa == 'P'}"> selected</c:if>>P</option>
                            <option value="PP" <c:if test="${tamCamisa == 'PP'}"> selected</c:if>>PP</option>
                            <option value="G" <c:if test="${tamCamisa == 'G'}"> selected</c:if>>G</option>
                            <option value="GG" <c:if test="${tamCamisa == 'GG'}"> selected</c:if>>GG</option>
                            </select>

                        </div>
                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Pais:</label>
                            <input type="text" name="txtPais" class="form-control" value="${atleta.pais}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>

                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Cidade:</label>
                            <input type="text" name="txtCidadeAtleta" class="form-control" value="${atleta.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Estado:</label>
                            <input type="text" name="txtEstadoAtleta" class="form-control" value="${atleta.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="col-md-6">
                            <label for="exampleInputPassword1">Endereço:</label>
                            <input type="text" name="txtRuaAtleta" class="form-control" value="${atleta.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="col-md-6">
                            <label for="exampleInputPassword1">Bairro:</label>
                            <input type="text" name="txtBairroAtleta" class="form-control" value="${atleta.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>


                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <label for="exampleInputPassword1">Telefone Fixo:</label>
                            <input type="text" name="txtTelefoneFixo" class="form-control" value="${atleta.telefoneFixo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="col-md-2">
                            <label for="exampleInputPassword1">Telefone Celular:</label>
                            <input type="text" name="txtTelefoneCelular" class="form-control" value="${atleta.telefoneCel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>

                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Email:</label>
                            <input type="text" name="txtEmail" class="form-control" value="${atleta.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>

                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Confirmar Email:</label>
                            <input type="text" id="email" name="txtEmail" class="form-control" oninput="validaEmail(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>


                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Login:</label>
                            <input type="text" name="txtLoginAtleta" class="form-control" value="${atleta.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="col-md-4">
                            <label>Senha:</label>
                            <input type="password" id="senha" name="txtSenhaAtleta" class="form-control" value="${atleta.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        <div class="col-md-4">
                            <label for="exampleInputPassword1">Confirmar Senha:</label>
                            <input type="password" name="txtValidadaSenha" class="form-control" oninput="validaSenha(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>

                    <div class="col-md-6">
                        <br>
                        <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                        <a href="PesquisaAtletaController" class="btn btn-default">Cancelar</a>
                    </div>
            </form>                   
        </div>


    </body>

</html>



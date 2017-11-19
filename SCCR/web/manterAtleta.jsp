

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
      <jsp:include page="bootstrap.jspf"/>
      <title>Manter Atleta</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <h3>${operacao}</h3>

        <form action="ManterAtletaController?acao=confirmar${operacao}" method="post" name="frmManterAtleta">
            <table>
                <tr>
                    <td>Código do atleta:</td> 
                    <td><input type="text" name="txtIdAtleta" value="${atleta.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome do atleta:</td> 
                        <td><input type="text" name="txtNomeAtleta" value="${atleta.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Data de nascimento:</td> 
                        <td><input type="text" name="txtDataNascimento" value="${atleta.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Apelido:</td> 
                        <td><input type="text" name="txtApelido" value="${atleta.apelido}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>CPF:</td> 
                        <td><input type="text" name="txtCpf" value="${atleta.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
<!--                    <tr>
                        <td>Tamanho da camisa:</td> 
                        <td><input type="text" name="txtTamanhoCamisa" value="${atleta.tamCamisa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>-->
                    <tr> 
                        <td>Tamanho da camisa:</td> 
                        <td>
                            <select name="optTamanhoCamisa" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="M" <c:if test="${tamCamisa == 'M'}"> selected</c:if>>M</option>
                            <option value="P" <c:if test="${tamCamisa == 'P'}"> selected</c:if>>P</option>
                            <option value="PP" <c:if test="${tamCamisa == 'PP'}"> selected</c:if>>PP</option>
                            <option value="G" <c:if test="${tamCamisa == 'G'}"> selected</c:if>>G</option>
                            <option value="GG" <c:if test="${tamCamisa == 'GG'}"> selected</c:if>>GG</option>
                            </select>
                        </td>
                    </tr>                   
                    <tr> 
                        <td>Sexo:</td> 
                        <td>
                            <select name="optSexo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="Masculino" <c:if test="${atleta.sexo == 'Masculino'}"> selected</c:if>>Masculino</option>
                            <option value="Feminino" <c:if test="${atleta.sexo == 'Feminino'}"> selected</c:if>>Feminino</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td> 
                        <td><input type="text" name="txtEmail" value="${atleta.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Telefone fixo:</td> 
                        <td><input type="text" name="txtTelefoneFixo" value="${atleta.telefoneFixo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Telefone celular:</td> 
                        <td><input type="text" name="txtTelefoneCelular" value="${atleta.telefoneCel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>

                    <tr>
                        <td>Pais:</td> 
                        <td><input type="text" name="txtPais" value="${atleta.pais}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Estado:</td> 
                        <td><input type="text" name="txtEstadoAtleta" value="${atleta.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Rua:</td> 
                        <td><input type="text" name="txtRuaAtleta" value="${atleta.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Bairro:</td> 
                        <td><input type="text" name="txtBairroAtleta" value="${atleta.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Cidade:</td> 
                        <td><input type="text" name="txtCidadeAtleta" value="${atleta.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Login:</td> 
                        <td><input type="text" name="txtLoginAtleta" value="${atleta.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Senha:</td> 
                        <td><input type="password" name="txtSenhaAtleta" value="${atleta.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>

    </body>
</html>

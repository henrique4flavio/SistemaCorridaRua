
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atletas</title>
    </head>

    <body>
        <h1>Atletas</h1>
        <table border='1'>
            <tr>
                <th> Código do atleta  </th>
                <th> Nome do atleta </th>
                <th> Nome da equipe  </th>
                <th> Data de nascimento</th>
                <th> Apelido</th>
                <th> CPF</th>
                <th> Tamanho da camisa</th>
                <th> Sexo</th>
                <th> Telefone fixo</th>
                <th> Telefone celular</th>
                <th> Rua </th>
                <th> Bairro</th>
                <th> Estado </th>
                <th> Pais </th>
                <th> Cidade </th>       
                <th> Login</th>
                <th> Senha</th>
                <th> Email </th>       
            </tr>
            <c:forEach items="${atletas}" var="atleta">
                <tr> 
                    <td> <c:out value="${atleta.id}"/> </td>
                    <td> <c:out value= "${atleta.nome}"/></td>
                    <td> <c:out value= "${atleta.nomeDaEquipe}"/></td>
                    <td> <c:out value="${atleta.dataNascimento}"/> </td>
                    <td> <c:out value="${atleta.apelido}"/> </td>
                    <td> <c:out value="${atleta.cpf}"/> </td>
                    <td> <c:out value="${atleta.tamCamisa}"/> </td>
                    <td> <c:out value="${atleta.sexo}"/> </td>
                    <td> <c:out value="${atleta.telefoneFixo}"/> </td>
                    <td> <c:out value="${atleta.telefoneCel}"/> </td>
                    <td> <c:out value="${atleta.rua}"/> </td>
                    <td> <c:out value="${atleta.bairro}"/> </td>
                    <td> <c:out value="${atleta.estado}"/> </td>
                    <td> <c:out value="${atleta.pais}"/> </td>
                    <td> <c:out value="${atleta.cidade}"/> </td>
                    <td> <c:out value="${atleta.login}"/> </td>
                    <td> <c:out value="${atleta.senha}"/> </td>
                    <td> <c:out value="${atleta.email}"/> </td>
                    <td> <a href="ManterAtletaController?acao=prepararEditar&Editar&ID_atleta = <c:out value="${atleta.id}"/>"> Editar </a></td>
                    <td> <a href="ManterAtletaController?acao=prepararExcluir&ID_atleta = <c:out value="${atleta.id}"/>">Excluir </a><td>
                </tr>
            </c:forEach>
        </table>
        <form action ="ManterAtletaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>     


    </body>
</html>

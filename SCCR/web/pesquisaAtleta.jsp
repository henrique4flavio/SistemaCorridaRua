<%-- 
    Document   : pesquisaAtleta
    Created on : 10/10/2017, 17:09:10
    Author     : Laís Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Atletas</title>
    </head>
    
    <body>
        <h1> Pesquisa de Atletas</h1>
        <table border='1'>
            <tr>
                <th> Codigo  </th>
                <th> Nome do Atleta </th>
                <th> Nome da Equipe  </th>
                <th> Data de Nascimento</th>
                <th>  apelido</th>
                <th>  CPF</th>
                <th>  Tamanho Da Camisa</th>
                <th>  Sexo</th>
                <th>  Telefone Fixo</th>
                <th>  Telefone Celular</th>
                <th> Rua </th>
                <th> Bairro</th>
                <th> Estado </th>
                <th> Pais </th>
                <th> Cidade </th>       
               <th> Login</th>
                <th> Senha</th>
                <th> Email </th>       
            </tr>
            <c:forEach items="${Atleta}" var="Atleta">
                <tr> 
                    <td> <c:out value="${Atleta.id}"/> </td>
                    <td> <c:out value= "${Atleta.nome}"/></td>
                    <td> <c:out value= "${Atleta.nomeDaEquipe}"/></td>
                    <td> <c:out value="${Atleta.dataNascimento}"/> </td>
                    <td> <c:out value="${Atleta.apelido}"/> </td>
                    <td> <c:out value="${Atleta.cpf}"/> </td>
                    <td> <c:out value="${Atleta.tamCamisa}"/> </td>
                    <td> <c:out value="${Atleta.sexo}"/> </td>
                    <td> <c:out value="${Atleta.telefoneFixo}"/> </td>
                    <td> <c:out value="${Atleta.telefoneCel}"/> </td>
                    <td> <c:out value="${Atleta.rua}"/> </td>
                    <td> <c:out value="${Atleta.bairro}"/> </td>
                    <td> <c:out value="${Atleta.estado}"/> </td>
                    <td> <c:out value="${Atleta.pais}"/> </td>
                    <td> <c:out value="${Atleta.cidade}"/> </td>
                    <td> <c:out value="${Atleta.login}"/> </td>
                    <td> <c:out value="${Atleta.senha}"/> </td>
                    <td> <c:out value="${Atleta.email}"/> </td>
                    <td> <a href="ManterAtletaController ?acao=prepararEditar&Editar&id = <c:out value="${Atleta.id}"/>"> Editar </a></td>
                    <td> <a href="ManterAtletaController?acao=prepararExcluir&id = <c:out value="${Atleta.id}"/>">Excluir </a><td>

                </tr>

            </c:forEach>
        </table>
        <form action ="ManterAtletaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>     


    </body>
</html>

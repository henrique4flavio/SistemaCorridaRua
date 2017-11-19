
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Atleta</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
   
        <table class="table table-bordered">
            <tr>
                <th> Código do atleta  </th>
                <th> Nome do atleta </th>
<!--                <th> Data de nascimento</th> -->
<!--                <th> Apelido</th>-->
                <th> CPF</th>
                <th> Tamanho da camisa</th>
                <th> Sexo</th>
<!--                <th> Telefone fixo</th>
                <th> Telefone celular</th>
                <th> Rua </th>
                <th> Bairro</th>
                <th> Estado </th>
                <th> Pais </th>
                <th> Cidade </th>       -->
                <th> Login</th>
                <th> Senha</th>
                <th> Email </th>       
            </tr>
            <c:forEach items="${atletas}" var="atleta">
                <tr> 
                    <td> <c:out value="${atleta.id}"/> </td>
                    <td> <c:out value= "${atleta.nome}"/></td>
<!--                    <td>  value="${atleta.dataNascimento}"/> </td>-->
<!--                    <td>  value="${atleta.apelido}"/> </td>-->
                    <td> <c:out value="${atleta.cpf}"/> </td>
                    <td> <c:out value="${atleta.tamCamisa}"/> </td>
                    <td> <c:out value="${atleta.sexo}"/> </td>
<!--                <td>  value="${atleta.telefoneFixo}"/> </td>
                    <td>  value="${atleta.telefoneCel}"/> </td>
                    <td>  value="${atleta.rua}"/> </td>
                    <td>  value="${atleta.bairro}"/> </td>
                    <td>  value="${atleta.estado}"/> </td>
                    <td>  value="${atleta.pais}"/> </td>
                    <td>  value="${atleta.cidade}"/> </td>-->
                    <td> <c:out value="${atleta.login}"/> </td>
                    <td> <c:out value="${atleta.senha}"/> </td>
                    <td> <c:out value="${atleta.email}"/> </td>
                    <td> <a href="ManterAtletaController?acao=prepararEditar&Editar&id=<c:out value="${atleta.id}"/>"><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td> <a href="ManterAtletaController?acao=prepararExcluir&id=<c:out value="${atleta.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>
                </tr>
            </c:forEach>
        </table>
        <form action ="ManterAtletaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>     


    </body>
</html>

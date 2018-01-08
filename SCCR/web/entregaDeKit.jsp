
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html><html>
    <head>

        <title>Pesquisa Retirar Kit</title>
    </head>
    <body>
        
        <div class="container">
            <h2>Pesquisa Retirar Kit</h2>

            <table class="table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>CPF</th>
                        <th>Nome Kit</th>
                    </tr>
                </thead>
                <tbody>
                <form action="ManterRetirarKitController?acao=prepararRetirarKit&id=<c:out value="${inscricao.id}"/>&corridaId=<c:out value="${inscricao.lote.corridaId}"/>" method="post">
                    <c:forEach items="${inscricoes}" var="inscricao">
                        <tr  class="danger">
                            <td> <c:out value="${inscricao.numeroPeito}"/> </td>
                                <td> <c:out value="${inscricao.formaPagamento}"/> </td>
                                <td> 
                                    <c:forEach items="${kits}" var="kit">
                                        <c:if test="${kit.id == inscricao.kit_id}"> ${kit.nomeKit} </c:if>
                                    </c:forEach> 
                                </td>
                                 <td><c:out value = "${inscricao.categoria}" /></td>          
                        </tr>
                    </c:forEach>
                </form>

                </tbody>
            </table>

            <form action="ManterRetirarKitController?acao=escolherCorrida" method="post">
                <button type="submit" name="btnIncluir">Manter Retirar Kit</button>
            </form>
            <a href="index.jsp">Menu</a>
        </div>

    </body>
</html>
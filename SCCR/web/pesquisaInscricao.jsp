
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter inscrição</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <table class="table table-bordered"> 
            <tr>

                <th>Código da inscrição</th>


                <th>Forma de pagamento</th>
                <th>Kit</th>
                <th>Nome da prova</th>
                <th>Percurso</th>
                <th>Valor Total</th>

            </tr>   
            <c:forEach items="${inscricoes}" var="inscricao">
                <tr> 
                    <td> <c:out value="${inscricao.numeroPeito}"/> </td>
                    <td> <c:out value="${inscricao.formaPagamento}"/> </td>
                    <td> 
                        <c:forEach items="${kits}" var="kit">
                            <c:if test="${kit.id == inscricao.kit_id}"> ${kit.nomeKit} </c:if>
                        </c:forEach> 
                    </td>

                    <td> 
                        <c:forEach items="${provas}" var="prova">
                            <c:if test="${prova.id == inscricao.prova_id}">${prova.nomeProva} </c:if>


                        </c:forEach> 
                    </td>
                    <td> 
                        <c:forEach items="${percursos}" var="percurso">
                            <c:if test="${percurso.id == inscricao.percurso_id}"> ${percurso.nome} </c:if>


                        </c:forEach> 
                    </td>
                    <td> <c:out value="${inscricao.total}"/> </td>
                    <td><a href ="ManterInscricaoController?acao=prepararEditar&numeroPeito=<c:out value="${inscricao.numeroPeito}"/>"><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td><a href ="ManterInscricaoController?acao=prepararExcluir&numeroPeito=<c:out value="${inscricao.numeroPeito}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>

                </tr>
            </c:forEach>
        </table>
        <form action ="ManterInscricaoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btIncluir" value="Incluir"/>
        </form>                    
    </body>
</html>

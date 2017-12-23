
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter inscrição</title>

        <script>
            function pesquisa(input) {

                var pesquisa = document.getElementById('search');
                location.href = 'PesquisaInscricaoController?acao=pesquisa&numero=' + pesquisa.value;
            }
        </script>

    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>


        <div id="top" class="row">
            <div class="col-sm-3">
                <h2>Inscrições</h2>
            </div>
            <div class="col-sm-6">

                <div class="input-group h2">
                    <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Inscricao">
                    <span class="input-group-btn">
                        <button class="btn btn-primary" type="submit" onclick="pesquisa()">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>

            </div>

        </div> <!-- /#top -->


        <table class="table table-bordered"> 
            <tr>

                <th>Número da inscrição</th>


                <th>Total</th>
                <th>Kit</th>
                <th>Nome da prova</th>
                <th>Percurso</th>
                <th> Forma de Pagamento</th>


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
                    <td><a href ="ManterInscricaoController?acao=prepararEditar&numeroPeito=<c:out value="${inscricao.numeroPeito}"/>&prova_id=<c:out value="${prova.id}"/>"><button><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                    <td><a href ="ManterInscricaoController?acao=prepararExcluir&numeroPeito=<c:out value="${inscricao.numeroPeito}"/>&prova_id=<c:out value="${prova.id}"/>"><button><span class="glyphicon glyphicon-trash"></span></button></a></td>
                </tr>
            </c:forEach>
        </table>


    </body>
</html>

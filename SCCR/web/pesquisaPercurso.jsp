
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter percursos</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <div id="main" class="container-fluid" style="margin-top: 50px">

            <div id="top" class="row">
                <div class="col-sm-3">
                    <h2>Percursos</h2>
                </div>
                <div class="col-sm-6">

                    <div class="input-group h2">
                        <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Percurso">
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                    </div>

                </div>
                <div class="col-sm-3">
                    <form action ="ManterPercursoController?acao=prepararIncluir" method="post">
                        <input type="submit" name="btIncluir" value="Novo Percurso" class="btn btn-primary pull-right h2">


                    </form> 
                </div>
            </div> <!-- /#top -->


            <hr />
            <div id="list" class="row">

                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>Código do percurso</th>
                                <th>Nome do percurso</th
                                <th>Nome do percurso</th>
                                <th>Distancia</th>
                                <th>Faixa Etaria</th>
                                <th>Prova</th>
                                

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${percursos}" var="percurso">
                                <tr>

                                    <td><c:out value = "${percurso.id}" /></td>
                                    <td><c:out value = "${percurso.nome}" /></td>
                                    <td><c:out value = "${percurso.distancia}" /></td>
                                    <td><c:out value = "${percurso.faixaEtaria}" /></td>
                                    <td> 
                                        <c:forEach items="${provas}" var="prova">
                                            <c:if test="${prova.id == percurso.prova_id}"> ${prova.nomeProva}</c:if>


                                        </c:forEach> 
                                    </td>

                                    <td class="actions">

                                        <a class="btn btn-warning btn-xs" href="ManterPercursoController?acao=prepararEditar&id=<c:out value="${percurso.id}"/>">Editar</a>
                                        <a class="btn btn-danger btn-xs"  href="ManterPercursoController?acao=prepararExcluir&id=<c:out value="${percurso.id}"/>" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

            </div> <!-- /#list -->



            <!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="modalLabel">Excluir Percurso</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este percurso?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary">Sim</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                        </div>
                    </div>
                </div>
            </div>

            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>

            <jsp:include page="footer.jspf"/>

    </body>
</html>
</body>
</html>



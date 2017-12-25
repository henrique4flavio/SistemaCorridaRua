
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Atleta</title>
        <script src="./resources/bootstrap/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#idTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>    
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>

        <div id="main" class="container-fluid" style="margin-top: 50px">

            <div id="top" class="row">
                <div class="col-sm-3">
                    <h2>Atletas</h2>
                </div>


                <div class="col-sm-6">
                    <input class="form-control" id="myInput" type="text" placeholder="Search..">

                </div>
 <div class="col-sm-3">
                    <form action ="ManterAtletaController?acao=prepararIncluir" method="post">
                    <input type="submit" name="btIncluir" value="Novo Atleta" class="btn btn-primary pull-right h2">
                    
    
            </form> 
                </div>
            </div> <!-- /#top -->


            <hr />
            <div id="list" class="row">

                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>Código do atleta</th>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>Login</th>
                                <th>Email</th>

                            </tr>
                        </thead>
                        <tbody id="idTable">

                            <c:forEach items="${atletas}" var="atleta">
                                <tr>

                                    <td><c:out value = "${atleta.id}" /></td>
                                    <td><c:out value = "${atleta.nome}" /></td>
                                    <td> <c:out value="${atleta.cpf}"/> </td>
                                    <td><c:out value = "${atleta.login}" /></td>
                                    <td><c:out value = "${atleta.email}" /></td>



                                    <td class="actions">

                                        <a class="btn btn-warning btn-xs" href="ManterAtletaController?acao=prepararEditar&id=<c:out value="${atleta.id}"/>">Editar</a>
                                        <a class="btn btn-danger btn-xs"  href="ManterAtletaController?acao=prepararExcluir&id=<c:out value="${atleta.id}"/>" data-toggle="modal" data-target="#delete-modal">Excluir</a>
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
                            <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este item?
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

    </body>
</html>


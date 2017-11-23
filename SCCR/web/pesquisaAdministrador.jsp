
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter administrador</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>



        <div id="main" class="container-fluid" style="margin-top: 50px">

            <div id="top" class="row">
                <div class="col-sm-3">
                    <h2>Administradores</h2>
                </div>
                <div class="col-sm-6">

                    <div class="input-group h2">
                        <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Administrador">
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                    </div>

                </div>
                <div class="col-sm-3">
                    <form action ="ManterAdministradorController?acao=prepararIncluir" method="post">
                    <input type="submit" name="btIncluir" value="Novo Administrador" class="btn btn-primary pull-right h2">
                    
    
            </form> 
                </div>
            </div> <!-- /#top -->


            <hr />
            <div id="list" class="row">

                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>Código do administrador</th>
                                <th>Nome do administrador</th>
                                <th>Login</th>
                                <th>Email</th>
                                <th class="actions">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${administradores}" var="administrador">
                            <tr>
                                


                                    <td><c:out value = "${administrador.id}" /></td>
                                    <td><c:out value = "${administrador.nome}" /></td>
                                    <td><c:out value = "${administrador.login}" /></td>
                                    <td><c:out value = "${administrador.email}" /></td>
                                 
                                    <td class="actions">
                                        <a class="btn btn-success btn-xs" href="#">Visualizar</a>
                                        <a class="btn btn-warning btn-xs" href="ManterAdministradorController?acao=prepararEditar&id=<c:out value="${administrador.id}"/>">Editar</a>
                                        <a class="btn btn-danger btn-xs"  href="ManterAdministradorController?acao=prepararExcluir&id=<c:out value="${administrador.id}"/>" data-toggle="modal" data-target="#delete-modal">Excluir</a>
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



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter rankings</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
                  
   
<div id="main" class="container-fluid" style="margin-top: 50px">

            <div id="top" class="row">
                <div class="col-sm-3">
                    <h2>Rankings</h2>
                </div>
                <div class="col-sm-6">

                    <div class="input-group h2">
                        <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Ranking">
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                    </div>

                </div>
                <div class="col-sm-3">
                    <form action ="ManterRankingController?acao=prepararIncluir" method="post">
                    <input type="submit" name="btIncluir" value="Novo Ranking" class="btn btn-primary pull-right h2">
                    
    
            </form> 
                </div>
            </div> <!-- /#top -->


            <hr />
            <div id="list" class="row">

                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>Código do ranking</th>
                                <th>Nome do ranking</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${rankings}" var="ranking">
                            <tr>
                                


                                    <td><c:out value = "${ranking.id}" /></td>
                                    <td><c:out value = "${ranking.nome}" /></td>
                                    
                                 
                                    <td class="actions">
                                        
                                        <a class="btn btn-warning btn-xs" href="ManterRankingController?acao=prepararEditar&id=<c:out value="${ranking.id}"/>">Editar</a>
                                        <a class="btn btn-danger btn-xs"  href="ManterRankingController?acao=prepararExcluir&id=<c:out value="${ranking.id}"/>" data-toggle="modal" data-target="#delete-modal">Excluir</a>
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
                            <h4 class="modal-title" id="modalLabel">Excluir Ranking</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este ranking?
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
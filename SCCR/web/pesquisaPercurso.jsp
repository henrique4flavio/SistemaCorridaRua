
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter percursos</title>
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
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="${tipo}Home.jsp">Sistema de Corrida de Rua</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
        
  
        
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        
          <li class="nav-item">
          <a class="nav-link" href="${tipo}Home.jsp">
              <i class="fa fa-user-o"></i>
                                <%
                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                                    String nome = usuario.getNome();
                                %>
                                <%=nome%> </a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
        <div id="main" class="container-fluid" style="margin-top: 50px">

            <div id="top" class="row">
                <div class="col-sm-3">
                    <h2>Percursos</h2>
                </div>
               <div class="col-sm-6">
                   <br>
            <input class="form-control" id="myInput" type="text" placeholder="Search..">


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
                                <th>Nome do percurso</th>
                               
                                <th>Distancia</th>
                                <th>Faixa Etaria</th>
                                <th>Prova</th>
                                

                            </tr>
                        </thead>
                        <tbody id="idTable">
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



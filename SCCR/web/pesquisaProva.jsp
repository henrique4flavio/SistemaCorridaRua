
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter prova</title>

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


        <script>
            function pesquisa(input) {

                var pesquisa = document.getElementById('search');
                location.href = 'PesquisaProvaController?acao=pesquisa&nome=' + pesquisa.value;
            }
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
                    <h2>Provas</h2>
                </div>
                <div class="col-sm-6">
                    <br>
                    <input class="form-control" id="myInput" type="text" placeholder="Search..">


                </div>
                <div class="col-sm-3">
                    <form action ="ManterProvaController?acao=prepararIncluir" method="post">
                        <input type="submit" name="btIncluir" value="Nova Prova" class="btn btn-primary pull-right h2">


                    </form> 
                </div>
            </div> <!-- /#top -->


            <hr />
            <div id="list" class="row">

                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0">
                        <thead>
                            <tr>
                                <th>Código da prova</th>
                                <th>Nome da prova</th>
                                <th>Local de largada</th>
                                <th>Local de Retirada do Kit</th>
                                <th>Horario da largada</th>
                                <th>Data da prova</th>
                                <th>Nome do organizador</th>
                                <th>Nome do ranking</th>
                                <th class="actions">Ações</th>
                            </tr>
                        </thead>
                        <tbody id="idTable">
                            <c:forEach items="${provas}" var="prova">
                                <tr>



                                    <td><c:out value = "${prova.id}" /></td>
                                    <td><c:out value = "${prova.nomeProva}" /></td>
                                    <td><c:out value = "${prova.localLargada}" /></td>
                                    <td><c:out value = "${prova.localRetiradaKit}" /></td>
                                    <td><c:out value = "${prova.horarioLargada}" /></td>
                                    <td><c:out value = "${prova.dataProva}" /></td>

                                    
                                    <td><c:forEach items="${organizadores}" var ="organizador">
                                            <c:if test="${organizador.id ==prova.organizador_id}">${organizador.nome} </c:if>
                                        </c:forEach>
                                    </td>

                                    <td><c:forEach items="${ranking}" var ="ranking">
                                            <c:if test="${ranking.id ==prova.ranking_id}">${ranking.nome} </c:if>
                                        </c:forEach>
                                    </td>


                                    <td class="actions">

                                        <a class="btn btn-warning btn-xs" href="ManterProvaController?acao=prepararEditar&id=<c:out value="${prova.id}"/>">Editar</a>
                                        <a class="btn btn-danger btn-xs"  href="ManterProvaController?acao=prepararExcluir&id=<c:out value="${prova.id}"/>" data-toggle="modal" data-target="#delete-modal">Excluir</a>
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
            
       

            <jsp:include page="footer.jspf"/>

    </body>
</html>




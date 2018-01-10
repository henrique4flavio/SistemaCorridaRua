
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter inscrição</title>
        <meta charset="UTF-8">
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
                location.href = 'PesquisaInscricaoController?acao=pesquisa&numero=' + pesquisa.value;
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
  

        <div class="container">

            <div class="col-sm-10"><br><br>
                <h3>Gerenciar Pagamento de Inscrições</h3>
            </div>
            <div class="col-sm-6">
                <input class="form-control" id="myInput" type="text" placeholder="Search..">


            </div> <!-- /#top -->

            <div id="list" class="row">
                <div class="table-responsive col-md-12">
                    <table class="table table-striped" cellspacing="0" cellpadding="0" >
                        <thead>
                            <tr>

                                <th>Número da inscrição</th>
                                <th> Nome </th>

                                <th> Forma de Pagamento </th>

                                <th>Kit</th>
                                <th>Categoria</th>
                                <th>Nome da prova</th>

                                <th>Percurso</th>

                                <th>Total</th>

                                <th>Situação</th>


                            </tr>   
                            </thread>
                        <tbody id="idTable">
                            
                            
                            <c:forEach items="${inscricoes}" var="inscricao">
                                
                                <c:if test="${inscricao.pago == 0}">
                                
                               <tr class="table-danger"> </c:if>
                                    
                                    <c:if test="${inscricao.pago == 1}">
                                
                                <tr> </c:if>
                                
                                    <td> <c:out value="${inscricao.id}"/> </td>

                                    <td> 
                                        <c:forEach items="${atletas}" var="atleta">
                                            <c:if test="${atleta.id == inscricao.atleta_id}"> ${atleta.nome} </c:if>
                                        </c:forEach> 
                                    </td>
                                    <td> <c:out value="${inscricao.formaPagamento}"/> </td>




                                    <td> 
                                        <c:forEach items="${kits}" var="kit">
                                            <c:if test="${kit.id == inscricao.kit_id}"> ${kit.nomeKit} </c:if>
                                        </c:forEach> 
                                    </td>
                                    <td><c:out value = "${inscricao.categoria}" /></td>
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

                                    <td>

                                        <c:if test="${inscricao.pago == 1}"> Pago </c:if>
                                        <c:if test="${inscricao.pago == 0}"> Não Pago </c:if>


                                        </td>
                                    <c:if test="${inscricao.pago == 0}"> <td><a href ="ManterInscricaoController?acao=pagar&id=${inscricao.id}"/><button><span class="glyphicon glyphicon-pencil"></span> Pagar</button></a></td></c:if>
                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                </div>
            </div>
        </div>
                    
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Deseja realmente sair?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Selecione "Logout" se quiser encerrar a sessão.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="LoginController?acao=logout">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>


                    </body>
                    </html>

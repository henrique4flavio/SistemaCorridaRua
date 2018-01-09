

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Importar Resultados Provas</title>


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
    <center><h3>Incluir Resultados Provas</h3></center>
    <div class="container">
        <div class="col-md-6">
            <form action="ManterResultadoProvasController?acao=confirmarImportacaoProva" method="post" name="frmManterProva">
                <div class="form-group">

                    <label for="exampleInputEmail1">Id Resultado Prova:</label>
                    <input type="text"required name="txtId" class="form-control">

                </div>

                <div class="form-group">

                    <label for="exampleInputEmail1">Nome do Atleta:</label>
                    <input type="text" required name="txtNomeAtleta" class="form-control">

                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Número de Peito do Atleta:</label>
                    <input type="text" required name="txtNumeroPeito" class="form-control">
                </div>
                <div class="form-group">
                    <label>Categoria do Atleta:</label>
                    <select name="txtCategoria" class="form-control">
                        <option value="Feminino">Infantil</option>
                        <option value="Masculino">Adolescente</option>
                        <option value="Masculino">Adulto</option>
                        <option value="Masculino">Idoso</option>
                    </select>
                      </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Classificação:</label>
                    <input type="text" name="txtClassificacao"class="form-control">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Tempo:</label>
                    <input type="text" name="txtTempo"class="form-control"> <h4>h/min </h4>
                </div>

                <div class="form-group">
                    <label>Sexo:</label>
                    <select name="txtSexo" class="form-control">
                        <option value="Feminino">Feminino</option>
                        <option value="Masculino">Masculino</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Nome da Prova:</label>
                    <input type="text" name="txtProva"class="form-control">
                </div>


                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="organizadorHome.jsp" class="btn btn-default">Cancelar</a> <br><br><br><br><br><br>

            </form>                   
        </div> 	
    </div>

    <jsp:include page="footer.jspf"/>
     <!-- Logout Modal-->
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





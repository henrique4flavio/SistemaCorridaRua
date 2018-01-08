

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>Manter Administrador</title>

        <script> function validaSenha(input) {
                if (input.value != document.getElementById('senha').value) {
                    input.setCustomValidity('Repita a senha corretamente');
                } else {
                    input.setCustomValidity('');
                }
            }
        </script>

 
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>


<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Sistema de Corrida de Rua</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="index.html">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Painel Administrativo</span>
          </a>
        </li>
        
        
        
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Organizadores</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="navbar.html">Manter Provas</a>
            </li>
            <li>
              <a href="navbar.html">Manter Percursos</a>
            </li>
            <li>
              <a href="navbar.html">Manter Kits </a>
            </li>
            <li>
              <a href="navbar.html">Manter Lotes</a>
            </li>
            <li>
              <a href="cards.html">Manter Rankings</a>
            </li>
            <li>
              <a href="navbar.html">Manter Resultados</a>
            </li>
          </ul>
        </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
             <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Atletas</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseExamplePages">
            <li>
              <a href="login.html">Manter Inscrições</a>
            </li>
            <li>
              <a href="register.html">Registration </a>
            </li>
            <li>
              <a href="forgot-password.html">Forgot Password Page</a>
            </li>
            <li>
              <a href="blank.html">Blank Page</a>
            </li>
          </ul>
        </li>
        
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
        
        <div class="content-wrapper">
             
             <div class="container">
            
    
        
    <center><h3>${operacao} Administrador</h3></center>
    <div class="col-md-6">
            <form action="ManterAdministradorController?acao=confirmar${operacao}" method="post" name="frmManterAdministrador">
                <div class="form-group">

                    <label for="exampleInputEmail1">Código do Administrador:</label>
                    <input type="text" name="txtIdAdministrador" class="form-control" value="${administrador.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>

                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Nome:</label>
                        <input type="text" name="txtNomeAdministrador" class="form-control" value="${administrador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Email:</label>
                        <input type="text" name="txtEmail" class="form-control" value="${administrador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Login:</label>
                        <input type="text" name="txtLoginAdm" class="form-control" value="${administrador.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label>Senha:</label>
                        <input type="password" id="senha" name="txtSenhaAdm" class="form-control" value="${administrador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Confirmar Senha:</label>
                        <input type="password" name="txtValidadaSenha" class="form-control" oninput="validaSenha(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>

                <button type="submit" name="btnConfirmar" class="btn btn-primary" value="Confirmar">Confirmar</button>
                <a href="PesquisaAdministradorController" class="btn btn-default">Cancelar</a>

            </form>                   
        </div> 	
    
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2017</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
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
  </div>

        
        
        
    
    </body>
</html>

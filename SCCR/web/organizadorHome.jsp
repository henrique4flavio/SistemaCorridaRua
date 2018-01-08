
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>


<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
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
            <span class="nav-link-text">Provas</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="navbar.html">Manter Provas</a>
            </li>
            <li>
              <a href="navbar.html">Manter Percursos</a>
            </li>
            
            <li>
              <a href="navbar.html">Manter Lotes</a>
            </li>
            
            <li>
              <a href="navbar.html">Manter Resultados</a>
            </li>
          </ul>
        </li>
        
         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExample" data-parent="#exampleAccordion">
             <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Kits</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseExample">
            <li>
              <a href="PesquisaKitController">Manter Kits</a>
            </li>
            <li>
              <a href="PesquisaItensController">Manter Itens</a>
            </li> 
          </ul>
         </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
             <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Rankings</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseExamplePages">
            <li>
              <a href="cards.html">Manter Rankings</a>
            </li>
            
          </ul>
        </li>
        
        
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="kits">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapsekits" data-parent="#exampleAccordion">
             <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Configurações da Conta</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapsekits">
            <li>
              <a href="ManterOrganizadorController?acao=prepararEditar&id=${organizador.id}">Alterar dados</a>
            </li>
            <li>
              <a href="ManterOrganizadorController?acao=prepararExcluir&id=${organizador.id}">Excluir conta</a>
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
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-primary o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                 <i class="fa fa-fw fa-list"></i>
              </div>
              <div class="mr-5">Minhas Provas</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="PesquisaAdministradorController?acao=listar">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-success o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                 <i class="fa fa-fw fa-list"></i>
              </div>
              <div class="mr-5">Gerenciar Pagamento</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>  
          
          
          
          <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-warning o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-list"></i>
              </div>
              <div class="mr-5">Gerenciar Entrega de Kit</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="PesquisaOrganizadorController">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
          <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-success o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                 <i class="fa fa-fw fa-list"></i>
              </div>
              <div class="mr-5">Importar Resultado Provas</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="ManterResultadoProvasController?acao=importarResultadoProvas">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>  
       
      </div>
      <!-- Area Chart Example-->
     
      <!-- Example DataTables Card-->
      
        <div class="card-footer small text-muted"></div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
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


            <div class="panel-title">
                <h3><span class="glyphicon glyphicon-user"></span> <strong>Bem Vindo(a) <%=nome%></strong> </h3>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10">
                            <a href="PesquisaProvaController?acao=listarProvas" class="btn btn-warning btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Minhas Provas</a>
                           <a href="PesquisaRankingController" class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>Cadastrar Rankings</a> 
                            <a href="PesquisaInscricaoController" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-list"></span> <br/>Listar Inscrições</a> 
                            <a href="PesquisaElementoKitController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-th-list"></span> </br>Manter elementos kits</a>


                            <a href="PesquisaElementoKitController"cl <a href="PesquisaLoteController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> </br>Manter lotes</a>

                             <a href="PesquisaPercursoController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-list"></span> </br>Manter percursos</a>
                            <a href="PesquisaProvaController?acao=listarProvas"class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-list"></span> </br>Manter provas</a> <br><br>

        <a href="PesquisaPagamentoController"class="btn btn-info btn-lg" role="button"><span class="glyphicon glyphicon-file"></span> </br>Controle Pagamento</a>




                        </div>

                    </div>

                </div>
            </div>
        </div>


        <jsp:include page="footer.jspf"/>


    </body>
</html>





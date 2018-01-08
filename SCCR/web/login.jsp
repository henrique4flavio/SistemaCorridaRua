

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>

    <body class="bg-dark">
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Sistema de Corrida de Rua</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Rankings</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="manterAtleta.jsp"> <span class="glyphicon glyphicon-user"></span> Registrar-se</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>    <br>

<<<<<<< HEAD
        <div class="container">
            <div class="card card-login mx-auto mt-5">
                 <c:if test="${msgErro != null}">
                <div class="alert alert-danger alert-dismissable">
                    <strong>Erro! </strong> ${msgErro}
                </div>
                 </c:if>
                <div class="card-header">Login</div>
                <div class="card-body">
                    <form action="LoginController?acao=logar" method="post" name="frmLogar">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Login</label>
                            <input class="form-control" id="login" required name="login" type="text"  placeholder="Digite o login">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Senha</label>
                            <input class="form-control" id="senha" required name="senha" type="password" placeholder="Digite a senha">
                        </div>
                        <div class="form-group">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox"> Lembrar Senha</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Login</button>
                    </form>
                    <div class="text-center">
                        <a class="d-block small mt-3" href="manterAtleta.jsp">Registrar-se</a>
                        <a class="d-block small" href="recuperaSenha.jsp">Esqueci minha senha?</a>
                    </div>
                </div>
=======
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <form action="LoginController?acao=logar" method="post" name="frmLogar">
          <div class="form-group">
            <label for="exampleInputEmail1">Login</label>
            <input class="form-control" id="login" required name="login" type="text"  placeholder="Enter email">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Senha</label>
            <input class="form-control" id="senha" required name="senha" type="password" placeholder="Password">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Lembrar Senha</label>
>>>>>>> parent of be06671... up
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    </body>

</html>

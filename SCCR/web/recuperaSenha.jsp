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
     <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="PesquisaProvaController?acao=gridProvas">Sistema de Corrida de Rua</a>
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
              <a class="nav-link" href="registro.jsp"> <span class="glyphicon glyphicon-user"></span> Registrar-se</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.jsp"> <span class="glyphicon glyphicon-user"></span> Entrar</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
    
    
    
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Redefinir Senha</div>
      <div class="card-body">
        <div class="text-center mt-4 mb-5">
          <h4>Esqueceu sua Senha?</h4>
          <p>
              Digite seu endereço que iremos mandar as instruções para redefinir sua senha.</p>
        </div>
        <form>
          <div class="form-group">
            <input class="form-control" id="exampleInputEmail1" required type="email" aria-describedby="emailHelp" placeholder="Enter email address">
          </div>
             <a class="nav-link btn btn-primary btn-block" data-toggle="modal" data-target="#exampleModal" href="login.html">Redefinir Senha</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="registro.jsp">Registrar-se</a>
          <a class="d-block small" href="login.jsp">Pagina de Login</a>
        </div>
      </div>
    </div>
  </div>
    
    
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Email enviado com sucesso!</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Verifique sua caixa de email.</div>
          <div class="modal-footer">
           
              
              
            <a class="btn btn-primary" href="login.jsp">Ok</a>
          </div>
        </div>
      </div>
    </div>
    
    
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
<jsp:include page="bootstrap.jspf"/>
<title>SCCR</title>
 
</head>
<body>
   <jsp:include page="barra_superior.jspf"/>
 
   <div class="container">
       
        <a href="PesquisaAdministradorController">Manter administradores</a><br>
        <a href="PesquisaAtletaController">Manter atletas</a><br>
        <a href="PesquisaControleChipRetornavelController">Manter chips</a><br>
        <a href="PesquisaInscricaoController">Manter inscrições</a><br>
        <a href="PesquisaItemController">Manter itens</a><br>
         <a href="PesquisaKitController">Manter kits</a><br>
        <a href="PesquisaLoteController">Manter lotes</a><br>
        <a href="PesquisaOrganizadorController">Manter organizadores</a><br>
        <a href="PesquisaPercursoController">Manter percursos</a><br>
        <a href="PesquisaProvaController">Manter provas</a><br>
        <a href="PesquisaRankingController">Manter rankings</a><br>
        <a href="PesquisaResultadoProvaController">Manter resultados das provas</a><br>
    

   </div>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
 <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

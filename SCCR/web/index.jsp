
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>SCCR</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>

    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>


        <div class="container">

            <a href="atletaHome.jsp">Menu do Atleta - login</a><br>
            <a href="administradorHome.jsp">Menu do Administrador - login</a><br>
            <a href="organizadorHome.jsp">Menu do Organizador - login</a><br> 
            
            
            <a href="PesquisaElementoKitController">Manter elementos kits</a><br>
            <a href="PesquisaInscricaoController">Manter inscrições</a><br>
            <a href="PesquisaItemController">Manter itens</a><br>
            <a href="PesquisaKitController">Manter kits</a><br>
            <a href="PesquisaLoteController">Manter lotes</a><br>
   
            <a href="PesquisaPercursoController">Manter percursos</a><br>
            <a href="PesquisaProvaController?acao=listarProvas">Manter provas</a><br>
            <a href="PesquisaRankingController">Manter rankings</a><br>
            
            <br><br><a href="PesquisaProvaController?acao=gridProvas">Provas</a><br>
            
            <a href="PesquisaResultadoProvasController?acao=visualizarProvas"> Resultados Provas </a><br>
            <a hrf="PaginaRankingGeral"> Rancking das Corridas de Rua</a> <br>
            
            

        </div>

        <jsp:include page="footer.jspf"/>

</body>

</html>

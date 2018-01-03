<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="modelo.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>SCCR</title>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
 <script src="./resources/bootstrap/js/jquery-3.2.1.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                       <li> <c:if test="${tipo != null}"> <a href="${tipo}Home.jsp">Sistema de Corrida de Rua</a></c:if> 
                        <c:if test="${tipo == null}"> <a href="index.jsp">Sistema de Corrida de Rua</a></c:if>
                             </li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="PesquisaProvaController?acao=gridProvas" ><span class=" glyphicon glyphicon-th"></span>  Provas</a> </li>

                            <li><a href="PesquisaResultadoRanking?acao=visualizarRanking"><span class="glyphicon glyphicon-list-alt"></span> Ranking</a> </li>
                            <li><a href="PesquisaResultadoProvasController?acao=visualizarProvas" ><span class="
                                                                                                         glyphicon glyphicon-expand"></span> Resultado Provas</a> </li>


                            <li><a href="administradorHome.jsp" ><span class="glyphicon glyphicon-user"></span> 
                                <%
                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                                    String nome = usuario.getNome();
                                %>
                                <%=nome%> 

                            </a> </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <h4 class="page-header">RESULTADOS DE PROVAS DO  RAKING DE CORRIDAS DE RUA - 2017</h4>
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <table width="100%" class="col-sm-12 table-bordered table-striped table-condensed cf">
                        <tbody>

                            <tr>
                                <td height="5" colspan="2"></td>
                            </tr>

                            <tr class="titulo_tabela">
                                <td colspan="2" height="30" bgcolor="#888888"><b>1</b> - V CORRIDA DA Asconcer - 01 Junho 2017
                                   </td>
                            </tr>

                          
                            <tr class="texto_tabela">
                                <td colspan="2" bgcolor="#cccccc"><b>FAIXA ET&Aacute;RIA</b></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino-Infantil</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralFemininoInfantilAsconcer" >Abrir</a></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Masculino-Infantil</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralMasculinoInfantilAsconcer" >Abrir</a></td>
                            </tr>
                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino-Adulto</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralFemininoAdultoAsconcer">Abrir</a></td>
                            </tr>
                                <tr class="texto_tabela">
                                <td align="left">&bull; Masculino-Adulto</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralMasculinoAdultoAsconcer" >Abrir</a></td>
                            </tr>
                            <tr class="texto_tabela">
                                <td align="left">&bull; Masculino-Idoso</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralMasculinoIdosoAsconcer" >Abrir</a></td>
                            </tr>
                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino-Idoso</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralFemininoIdosoAsconcer">Abrir</a></td>
                            </tr>
                            <tr class="texto_tabela">
                                <td colspan="2" bgcolor="#cccccc"><b>GERAL</b></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralFemininoAsconcer">Abrir</a></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Masculino</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralMasculinoAsconcer">Abrir</a></
                    </table>
                            </tr>
            </div>
        </div>


        <jsp:include page="footer.jspf"/>

    </body>

</html>

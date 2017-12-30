<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <jsp:include page="bootstrap.jspf"/>
        <title>SCCR</title>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
 <script src="./resources/bootstrap/js/jquery-3.2.1.min.js"></script>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <div class="container">
            <h4 class="page-header">Ranking JF 2017</h4>
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <table width="100%" class="col-sm-12 table-bordered table-striped table-condensed cf">
                        <tbody>

                            <tr>
                                <td height="5" colspan="2"></td>
                            </tr>

                            <tr class="titulo_tabela">
                                <td colspan="2" height="30" bgcolor="#888888"><b>1</b> - Ranking JF 2017
                                   </td>
                            </tr>

                          
                            <tr class="texto_tabela">
                                <td colspan="2" bgcolor="#cccccc"><b>FAIXA ET&Aacute;RIA</b></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino-Infantil</td>
                                <td><a href="PesquisaResultadoRanking?acao=geralFemininoInfantilRankingJF">Abrir</a></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Masculino-Infantil</td>
                                <td><a href="PesquisaResultadoRanking?acao=geralMasculinoInfantilRankingJF" >Abrir</a></td>
                            </tr>
                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino-Adulto</td>
                                <td><a href="PesquisaResultadoRanking?acao=geralFemininoAdultoRankingJF">Abrir</a></td>
                            </tr>
                                <tr class="texto_tabela">
                                <td align="left">&bull; Masculino-Adulto</td>
                                <td><a href="PesquisaResultadoRanking?acao=geralMasculinoAdultoRankingJF" >Abrir</a></td>
                            </tr>
                            <tr class="texto_tabela">
                                <td align="left">&bull; Masculino-Idoso</td>
                                <td><a href="PesquisaResultadoRanking?acao=geralMasculinoIdosoRankingJF" >Abrir</a></td>
                            </tr>
                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino-Idoso</td>
                                <td><a href="PesquisaResultadoRanking?acao=geralFemininoIdosoRankingJF">Abrir</a></td>
                            </tr>
                            <tr class="texto_tabela">
                                <td colspan="2" bgcolor="#cccccc"><b>GERAL</b></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino</td>
                                <td><a href="PesquisaResultadoRanking?acao=geralFemininoRankingJF">Abrir</a></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Masculino</td>
                                <td><a href="PesquisaResultadoRanking?acao=geralMasculinoRankingJF">Abrir</a></td>
                                      </tr>
                    </table>
                          
            </div>
        </div>


        <jsp:include page="footer.jspf"/>

    </body>

</html>

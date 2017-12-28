<%@page import="modelo.Usuario"%>
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
                                <td align="left">&bull; Feminino</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralFemininoAsconcer" >Abrir</a></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Masculino</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralMasculinoAsconcer" >Abrir</a></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td colspan="2" bgcolor="#cccccc"><b>GERAL</b></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Feminino</td>
                                <td><a href="PesquisaResultadoProvasController?acao=geralAsconcer">Abrir</a></td>
                            </tr>

                            <tr class="texto_tabela">
                                <td align="left">&bull; Masculino</td>
                                <td><a href="arquivos/suprema/geral_masculino_oficial.pdf" target="_blank">Abrir</a></
                    </table>
                            </tr>
            </div>
        </div>

        

        <jsp:include page="footer.jspf"/>

    </body>

</html>

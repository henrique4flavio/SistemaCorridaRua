
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="bootstrap.jspf"/>
        <title>Resultado das Provas</title>
    </head>
    <body>
        <jsp:include page="barra_superior.jspf"/>
        <div class="container">
        <h3>RESULTADOS DE PROVAS DO 31º RAKING DE CORRIDAS DE RUA - 2017</h3>
        </div>
        <div class="container">
            <table width="100%" class="col-sm-12 table-bordered table-striped table-condensed cf">
                <tbody>

                    <tr>
                        <td height="5" colspan="2"></td>
                    </tr>

                    <tr class="titulo_tabela">
                        <td colspan="2" height="30" bgcolor="#888888"><b>1</b> - V CORRIDA DA SA&Uacute;DE SUPREMA/PJF - 9,9km - 
                            26/03/2017</td>
                    </tr>

                    <tr class="texto_tabela">
                        <td colspan="2" bgcolor="#cccccc"><b>EQUIPE</b></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td align="left">&bull; Feminino</td>
                        <td><a href="SCCR/equipes_feminino_oficial.pdf" target="_blank">Abrir</a></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td align="left">&bull; Masculino</td>
                        <td><a href="arquivos/suprema/equipes_masculino_oficial.pdf" target="_blank">Abrir</a></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td colspan="2" bgcolor="#cccccc"><b>FAIXA ET&Aacute;RIA</b></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td align="left">&bull; Feminino</td>
                        <td><a href="arquivos/suprema/faixa_etaria_feminino_oficial.pdf" target="_blank">Abrir</a></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td align="left">&bull; Masculino</td>
                        <td><a href="arquivos/suprema/faixa_etaria_masculino_oficial.pdf" target="_blank">Abrir</a></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td colspan="2" bgcolor="#cccccc"><b>GERAL</b></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td align="left">&bull; Feminino</td>
                        <td><a href="arquivos/suprema/geral_feminino_oficial.pdf" target="_blank">Abrir</a></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td align="left">&bull; Masculino</td>
                        <td><a href="arquivos/suprema/geral_masculino_oficial.pdf" target="_blank">Abrir</a></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td  colspan="2" bgcolor="#cccccc"><b>PCDs</b></td>
                    </tr>

                    <tr class="texto_tabela">
                        <td align="left">&bull; Feminino/Masculino</td>
                        <td><a href="arquivos/suprema/pcds_oficial.pdf" target="_blank">Abrir</a></td>
                    </tr>




                    </tbody>
            </table>
        </div>
    </body>
</html>

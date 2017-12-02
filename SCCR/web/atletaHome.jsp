<div class="loading">
    <div id="carLoading">
        <div>
            <img src="/img/loading.gif" /><br>
        </div>
        <!--<span>
                Aguarde.....<br>
                Estamos Processando<br>
                Sua Solicitação            </span> -->
    </div>
</div>
                <div class="btn-group">

    </div>
    <header class="header">
        <div class="inner">
            <h1>Central Ativo.com</h1>
            <p><a style="color: #c1c3c3; font-size:20px;" href="/user/home">Central Ativo.com</a></p>
                            <div class="siteSeguro">
                    Olá Jonathas!<br> <span class="naoevc">Não é você?                    <a href="/user/logout">clique aqui</a></span>
                </div>
                <!-- Single button -->

            <nav>
                <button type="button" class="linkMenu dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="/user/home">Minha Conta</a></li>
                    <li><a href="/user/orders">Meus Pedidos</a></li>
                    <li><a href="/user/friends">Meus Amigos</a></li>
                    <li role="separator" class="divider"></li>
                    <li> <a href="/user/logout"><b>Sair</b> <span aria-hidden="true" class="glyphicon glyphicon-log-out"></a></span></li>
                </ul>
            </nav>
        </div>
    </header>

        <section class="mensagens">
            <div class="container">
                <div class="row">
                    <div id="bread" class="col-md-6 col-sm-6 col-lg-6 col-xs-6">
                        <ol class='breadcrumb' style='margin-bottom: 5px;'>
                               <li class='active'>Home</li>
                           </ol>                    </div>
                    <div class="col-md-6 col-sm-6 col-lg-6 col-xs-6 pdright0 ultimoacesso">
                        <b>Último acesso</b>: 1 de dezembro de 2017 17:11                    </div>
                </div>
            </div>
        </section>
            <main class="full-main container">
    <div class="container">
        <!--<div class="col-md-12">
                                </div>-->
        
<style>
    .conteudo .conteiner .alterarEmail ul li label.error {
        bottom: auto;
        position: absolute;
        color: #d41f35;
    }
    .conteudo .conteiner .alterarEmail ul li input.error {
        border-color: #d41f35;
    }
    .conteudo .conteiner .alterarSenha ul li label.error {
        bottom: auto;
        position: absolute;
        color: #d41f35;
    }
    .conteudo .conteiner .alterarSenha ul li input.error {
        border-color: #d41f35;
    }
    header h2 {
        text-align: left;
    }
    label.error{
        position: relative;
        /*float: left;*/
        width: 100%;
        margin-top: 5px;
        bottom: 0;
        margin-bottom: 0px;
    }
    div.senha-error{
        display: none;
        float: left;
        width: 100%;
        border: 1px #d41f35 solid !important;
        padding: 5px;
        text-align: center;
        color: #d41f35;
        background: #f2dede;
        margin-top: 10px;
        font-size: 11px;
    }
    div.email-error{
        display: none;
        float: left;
        width: 100%;
        border: 1px #d41f35 solid !important;
        padding: 5px;
        text-align: center;
        color: #d41f35;
        background: #f2dede;
        margin-top: 10px;
        font-size: 11px;
    }
    .bootstrap-dialog-close-button {
        display: block;
        background-image: url(//checkout.akamaized.net/img/carrinho/btn_close.png);
        width: 40px;
        height: 40px;
        position: absolute;
        top: -20px;
        right: -20px;
        opacity: 1 !important;
        text-align: center;
        padding: 10px;
        font-size: 1px;
    }
    .btn_laranja {
        background-color: #e87c1e;
        border-bottom: 3px solid #c66a1a;
    }
    .btn_padrao {
        color: #fff !important;
        display: inline-block;
        font-family: "Helvetica",sans-serif;
        font-size: 14px;
        line-height: 32px;
        margin: 10px 0;
        min-height: 32px;
        min-width: 150px;
        outline: medium none !important;
        padding-left: 10px;
        padding-right: 10px;
        padding-top: 3px;
        text-align: center;
    }
</style>

<script>
    $(document).ready(function(){

        $(".altera-email").click(function(){
            $("#valida-email").submit();
        });

        $(".altera-senha").click(function() {
            $("#valida-senha").submit();
        });

        var erros = {
            required: "Campos em vermelho são obrigatórios.",
            equalTo: "Campos não estão iguais.",
            email: "E-mail inválido."
        };

        $("#valida-email").validate({
            rules: {
                ds_email: {
                    required: true,
                    email: true
                },
                ds_email_novo: {
                    required: true,
                    email: true
                },
                confirmar_email: {
                    required: true,
                    email: true,
                    equalTo: ".ds_email_novo"
                }
            },
            messages: {
                ds_email: {
                    required: $("input[name=ds_email]").data('vazio'),
                    email: $("input[name=ds_email]").data('valido')
                },
                ds_email_novo: {
                    required: $("input[name=ds_email_novo]").data('vazio'),
                    email: $("input[name=ds_email_novo]").data('valido')
                },
                confirmar_email: {
                    required: $("input[name=confirmar_email]").data('vazio'),
                    equalTo: $("input[name=confirmar_email]").data('igual')
                }
            },
            errorPlacement: function(error, element) {
                //just nothing, empty
            },
            invalidHandler: function(event, validator) {

                var errors = validator.numberOfInvalids();
                if (errors) {
                    for (var i=0;i<validator.errorList.length;i++){
                        if(validator.errorList[i]['method']){
                            message = erros[validator.errorList[i]['method']];
                            $("input[name=ds_email]").addClass('error');
                            $(".email-error span").html(message);
                            $(".email-error").show();
                            break;
                        }
                    }
                }else {
                    $(".email-error").hide();
                }
            },
            submitHandler: function(form) {
                var email = $('input[name=ds_email]').val();
                var emailNovo = $('input[name=ds_email_novo]').val();
                // validate if email already exists in the base
                var validarEmail = validaEmail(emailNovo);

                if (validarEmail) {
                    if (email && emailNovo) {
                        loading('.conteudo');
                        $.ajax({
                            type: "POST",
                            url: baseURL + '/usuario/principal/alterarEmail',
                            data: {ds_email: email, ds_email_novo: emailNovo},
                            dataType: 'json'
                        })
                            .done(function (data) {
                                if (data.error) {
                                    // Retorna o erro aqui ...
                                    $("input[name=ds_email]").addClass('error');
                                    $("input[name=ds_email_novo]").addClass('error');
                                    $("input[name=confirmar_email]").addClass('error');
                                    alert_dialog('E-mail', data.msg, 'modalPadronizadaAlerta');
                                } else {
                                    alert_dialog('E-mail', data.msg, 'modalPadronizadaAlerta');
                                }
                                $('input[name=ds_email]').val('');
                                $('input[name=ds_email_novo]').val('');
                                $('input[name=confirmar_email]').val('');
                                $(".email-error span").html('');
                                $(".email-error").hide();
                            });
                    }
                } else {
                    $('input[name=ds_email]').val('');
                    $('input[name=ds_email_novo]').val('');
                    $('input[name=confirmar_email]').val('');
                    $("input[name=ds_email]").addClass('error');
                    $("input[name=ds_email_novo]").addClass('error');
                    $("input[name=confirmar_email]").addClass('error');
                    alert_dialog('E-mail', 'Este e-mail ' + emailNovo + ' já esta cadastrado em nossa base.', 'modalPadronizadaAlerta');
                }
            }
        });

        $("#valida-senha").validate({
            rules: {
                ds_senha: {
                    required: true
                },
                ds_senha_nova: {
                    required: true
                },
                confirmar_senha: {
                    required: true,
                    equalTo: ".ds_senha_nova"
                }
            },
            messages: {
                ds_senha:{
                    required: $("input[name=ds_senha]").data('vazio')
                },
                ds_senha_nova:{
                    required: $("input[name=ds_senha_nova]").data('vazio'),
                    equalTo: $("input[name=confirmar_senha]").data('igual')
                },
                confirmar_senha:{
                    required: $("input[name=confirmar_senha]").data('vazio'),
                    equalTo: $("input[name=confirmar_senha]").data('igual')
                }
            },
            errorPlacement: function(error, element) {
                //just nothing, empty
            },
            invalidHandler: function(event, validator) {

                var errors = validator.numberOfInvalids();
                if (errors) {
                    for (var i=0;i<validator.errorList.length;i++){
                        if(validator.errorList[i]['method']){
                            message = erros[validator.errorList[i]['method']];
                            $("input[name=ds_senha]").addClass('error');
                            $(".senha-error span").html(message);
                            $(".senha-error").show();
                            break;
                        }
                    }
                }else {
                    $(".senha-error").hide();
                }
            },
            submitHandler: function(form) {
                var senha = $('input[name=ds_senha]').val();
                var senhaNova = $('input[name=ds_senha_nova]').val();

                if (senha && senhaNova) {
                    loading('.conteudo');
                    $.ajax({
                        type: "POST",
                        url: baseURL + '/usuario/principal/alterarSenha',
                        data: { ds_senha: senha, ds_senha_novo: senhaNova },
                        dataType: 'json'
                    })
                        .done(function (data) {
                            if (data.error) {
                                // Retorna o erro aqui ...
                                $("input[name=ds_senha]").addClass('error');
                                $("input[name=ds_senha_nova]").addClass('error');
                                $("input[name=confirmar_senha]").addClass('error');
                                alert_dialog('Senha', data.msg, 'modalPadronizadaAlerta');
                            } else {
                                alert_dialog('Senha', data.msg, 'modalPadronizadaAlerta');
                            }
                            $('input[name=ds_senha]').val('');
                            $('input[name=ds_senha_nova]').val('');
                            $('input[name=confirmar_senha]').val('');
                            $(".senha-error span").html('');
                            $(".senha-error").hide();
                        });
                }
            }
        });

        $("input[name=ds_email], input[name=ds_email_novo], input[name=confirmar_email]").change(function() {
            $('input[type=text]').removeClass("error");
            $(".email-error span").html('');
            $(".email-error").hide();
        });

        $("input[name=ds_senha], input[name=ds_senha_nova], input[name=confirmar_senha]").change(function() {
            $('input[type=password]').removeClass("error");
            $(".senha-error span").html('');
            $(".senha-error").hide();
        });

        $('input[type=text]').keydown(function() {
            $('input[type=text]').removeClass("error");
            $(".email-error span").html('');
            $(".email-error").hide();
        });

        $('input[type=password]').keydown(function() {
            $('input[type=password]').removeClass("error");
            $(".senha-error span").html('');
            $(".senha-error").hide();
        });

    });

    // Verifica se email já existe na base
    var validaEmail = function(ds_email) {
        if (ds_email != '') {
            //loading(classe);
            var response = $.ajax({
                type: "POST",
                url: baseURL + '/usuario/cadastro/verificaemail',
                data: { ds_email: ds_email },
                dataType: 'json',
                async: false
            })
                .done(function(data) {
                    // return values data to variable response ...
                });

            var valida = response['responseText'];

            if (valida == '{"erro":"existe"}') {
                return false;
            } else {
                return true;
            }
        }
    };
</script>
<section class="conteudo">
    <div class="inner">
        <header>
            <h2 class="bemvindo">Bem vindo a sua conta</h2>
        </header>
        
        <div class="conteiner">
            <nav class="menuPrincipal">
                <ul>
                    <li><a href="/user/orders" class="btnMeusPedidos"><span></span>Meus Pedidos</a></li>
                    <li><a href="/user/friends" class="btnMeusAmigos"><span></span>Meus Amigos</a></li>
                    <li><a href="/user/account" class="btnAlteraDados"><span></span>Alterar Meus Dados</a></li>
                    <li><a href="//www.ativo.com/newsletter/?mail=jonathas.maraujo@gmail.com" target="_blank" class="btnCentralNews"><span></span>Central de Newsletter</a></li>
                    <li><a href="/user/orders/photos" class="btnFotos"><span></span>Minhas Fotos</a></li>
                </ul>
            </nav>
        </div>
        
        <div class="conteiner cont2">
            <section class="box alterarEmail">
                <header><h4>Alterar meu e-mail</h4></header>
                <form id="valida-email">
                    <ul>
                        <li>
                            <label>E-mail Atual</label>
                            <input type="text" name="ds_email" placeholder="Digite seu e-mail atual" data-vazio="" />
                        </li>
                        <li>
                            <label>Novo E-mail</label>
                            <input type="text" name="ds_email_novo" class="ds_email_novo" placeholder="Digite seu novo e-mail" data-vazio="" />
                        </li>
                        <li>
                            <label>Repetir Novo E-mail</label>
                            <input type="text" name="confirmar_email" placeholder="Confirmar o e-mail" data-vazio="" data-igual=""/>
                        </li>
                        <li class="teste">
                            <a href="javascript:void(0);" class="altera-email">Alterar E-mail</a>
                        </li>
                    </ul>
                </form>
                <div class="email-error" style="margin: 0 0 10px 0;">
                    <span></span>
                </div>
            </section>

            <section class="box alterarSenha">
                <header><h4>Alterar minha senha</h4></header>
                <form id="valida-senha">
                    <ul>
                        <li>
                            <label>Senha Atual</label>
                            <input type="password" name="ds_senha" placeholder="Digite sua senha atual" data-vazio=""/>
                        </li>
                        <li>
                            <label>Nova Senha</label>
                            <input type="password" name="ds_senha_nova" class="ds_senha_nova" placeholder="Digite sua nova senha" data-vazio=""/>
                        </li>
                        <li>
                            <label>Repetir Nova Senha</label>
                            <input type="password" name="confirmar_senha" placeholder="Confirmar novamente a senha" data-vazio="" data-igual=""/>
                        </li>
                        <li class="teste">
                            <a href="javascript:void(0);" class="altera-senha">Alterar Senha</a>
                        </li>
                    </ul>
                </form>
                <div class="senha-error" style="margin: 0 0 10px 0;">
                    <span></span>
                </div>
            </section>
        </div>
    </div>
</section>    </div>
</main> <!-- /container -->
<!-- This site is converting visitors into subscribers and customers with OptinMonster - http://optinmonster.com --><script>var om58cadcf461c81,om58cadcf461c81_poll=function(){var r=0;return function(n,l){clearInterval(r),r=setInterval(n,l)}}();!function(e,t,n){if(e.getElementById(n)){om58cadcf461c81_poll(function(){if(window['om_loaded']){if(!om58cadcf461c81){om58cadcf461c81=new OptinMonsterApp();return om58cadcf461c81.init({"s":"28433.58cadcf461c81","staging":0,"dev":0,"beta":0});}}},25);return;}var d=false,o=e.createElement(t);o.id=n,o.src="//a.optnmstr.com/app/js/api.min.js",o.async=true,o.onload=o.onreadystatechange=function(){if(!d){if(!this.readyState||this.readyState==="loaded"||this.readyState==="complete"){try{d=om_loaded=true;om58cadcf461c81=new OptinMonsterApp();om58cadcf461c81.init({"s":"28433.58cadcf461c81","staging":0,"dev":0,"beta":0});o.onload=o.onreadystatechange=null;}catch(t){}}}};(document.getElementsByTagName("head")[0]||document.documentElement).appendChild(o)}(document,"script","omapi-script");</script><!-- / OptinMonster -->
</body>
</html>

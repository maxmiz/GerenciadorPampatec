/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* variavel para armazenar o objeto do botao anterior */
var objetoBotaoAnterior = null;

/* campo para armazenar a classe dO botao que o usuario esta visualizando antes de ir para outro */
var classeBotaoAnterior = null;


/**
 * @description 
 * Ao entrar em uma pagina na aba PRE AVALIAÇÃO contendo o workflow 
 * o metodo é chamado na declaração do body, passando o status do projeto
 * então ele usa o método MostraDiv 
 * para apresenta ou esconde componentes da tela conforme esse status 
 * a variavel andamentoProjeto = status do projeto
 * 
 * cada caso seria a apresentação das divs para aquele status usando o metodo MostraDiv
 * ja tranformando o workflow  clicavel ou nao dependendo do status
 * 
 * @returns {undefined}
 */
function carregaPagina() {

    var etapa1 = document.getElementById("etapa1");
    var etapa2 = document.getElementById("etapa2");
    var etapa3 = document.getElementById("etapa3");
    var etapa4 = document.getElementById("etapa4");
    var etapa5 = document.getElementById("etapa5");

    switch (andamentoProjeto) {

//      SUBMETIDO = 1;
        case 1:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");
            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('sessao_plano_nao_avaliado');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      RESUBMETIDO = 11;
        case 11:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");
            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('sessao_plano_nao_avaliado');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      EM PRE AVALIAÇÃO = 12;
        case 12:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");
            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('sessao_plano_nao_avaliado');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      SENDO AVALIADO = 10;
        case 10:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");
            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('sessao_plano_nao_avaliado');

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      ACEITO PARA AVALIAÇÃO = 2;    
        case 2:
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active etapaSelecionada");
            etapa3.setAttribute("class", "active etapaAtual");

            etapaAtualDoWorkflow = "etapa3";

            mostraDIV('sessao_resultado_avaliador');

            addFocoBotao("menuSuperior:botao_resultado_preavaliacao");

            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      REPROVADO = 6;
        case 6:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");

            var botaoResultadoPreAvaliacao = document.getElementById("menuSuperior:botao_resultado_preavaliacao");
            botaoResultadoPreAvaliacao.setAttribute("class", "btn btn-danger btnEstadoAtual");

            mostraDIV('sessao_resultado_avaliador');
            addFocoBotao("menuSuperior:botao_resultado_preavaliacao");

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");
            break;

//     NECESSITA_MELHORIA = 7
        case 7:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");

            var botaoResultadoPreAvaliacao = document.getElementById("menuSuperior:botao_resultado_preavaliacao");
            botaoResultadoPreAvaliacao.setAttribute("class", "btn btn-danger btnEstadoAtual");

            mostraDIV('sessao_resultado_avaliador');
            addFocoBotao("menuSuperior:botao_resultado_preavaliacao");

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");
            break;

 //     REVISANDO = 13
        case 13:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual etapaSelecionada");

            var botaoResultadoPreAvaliacao = document.getElementById("menuSuperior:botao_resultado_preavaliacao");
            botaoResultadoPreAvaliacao.setAttribute("class", "btn btn-danger btnEstadoAtual");

            mostraDIV('sessao_revisar_plano_pre_melhoria');
            addFocoBotao("menuSuperior:botao_revisar");

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");
            break;

        default :
            break;
    }
}

/**
 * @description Função que exibe o menu vertical referente a etapa de pré avaliação
 * @returns {undefined}
 */
function mostra_vertical_pre_avaliacao() {


    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated estiloDivVertical noprint");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");
}

/**
 * @description Função que bloqueia todos os campos da tela Enviar Projeto. Para o empreendedor apenas poder visualizar e não editar.
 * @returns {undefined}
 */
function bloquearCampos() {
    var d = document.getElementById('myTabContent').getElementsByTagName('input');
    var botaoOutro = document.getElementById('formulario_cadastro_projeto:estagioDeEvolucao');
    botaoOutro.disabled = "true";

    for (var i = 0; i < d.length; i++) {
        d[i].disabled = "true";
    }
    var d2 = document.getElementById('myTabContent').getElementsByTagName('textarea');
    for (var i = 0; i < d2.length; i++) {
        d2[i].disabled = "true";
    }
}


/**
 * @description Função para alternar entre as DIVs
 * @param {type} referencia
 * @returns {undefined}
 */
function mostraDIV(referencia) {
    div1 = document.getElementsByClassName("classeConteudo");
    for (var i = 0; i < div1.length; i++) {

        if (div1[i].getAttribute("id") === referencia) {
            div1[i].setAttribute("class", "classeConteudo col-md-10");
        } else {
            div1[i].setAttribute("class", "classeConteudo esconder-div");
        }
    }
}
/**
 * @description Esta função é chamada para validar que quando o plano está em pre avalaição os empreendedores poderão só Revisar o plano.
 * @param {type} referencia
 */
function mostraDIV2(referencia) {
    // se andamento está em elaboração
    if (andamentoProjeto === 0) {
        // se o empreendedor é correspondente
        if (tipoEmpreededor) {
            mostraDIV(referencia);
        } else {
            // se empreendedor não é correspondente, apenas mostra plano para revisar
            mostraDIV('div_revisar_plano');
        }
    } else {
        mostraDIV('div_revisar_plano');
    }
}

/**
 * @description Coloca foco no botao em que o usuário está visualizando no workflow vertical
 * @param {type} idDoItem
 * @returns {undefined}
 */
function addFocoBotao(idDoItem) {
    var etapaBotao = document.getElementById(idDoItem);
    if (objetoBotaoAnterior !== null) {
        retornarCorOriginalBotao();
    }
    classeBotaoAnterior = etapaBotao.getAttribute('class');
    etapaBotao.setAttribute("class", classeBotaoAnterior + " pulse animated bordaEstadoVisualizado");
    objetoBotaoAnterior = etapaBotao;

}


/**
 * @description Retorna a classe original do botao que o usuário deixou de visualizar
 * @returns {undefined}
 */
function retornarCorOriginalBotao() {
    objetoBotaoAnterior.setAttribute("class", classeBotaoAnterior);
}


function verificaComentariosRevisar() {

    verificaComentarioNegocioRevisar();
    verificaComentarioAnaliseMercadoRevisar();
    verificaComentarioProdutoServicoRevisar();
    verificaComentarioGestaoPessoasRevisar();
    verificaComentarioPlanoFinanceiroRevisar();

}

function verificaComentariosPreAvaliar() {

    verificaComentarioNegocioPreAvaliar();
    verificaComentarioAnaliseMercadoPreAvaliar();
    verificaComentarioProdutoServicoPreAvaliar();
    verificaComentarioGestaoPessoasPreAvaliar();
    verificaComentarioPlanoFinanceiroPreAvaliar();

}

function verificaComentarioNegocioRevisar() {

    var comentarioSegmentoDeClientes = document.getElementById("formulario_resubmeterplano:segmentoDeClientes3");
    var comentarioPropostaDeValor = document.getElementById("formulario_resubmeterplano:propostaDeValor3");
    var comentarioAtividadesChave = document.getElementById("formulario_resubmeterplano:atividadesChaves3");
    var tabNegocio = document.getElementById("tabNegocio");
    var listaCampos = new Array();

    listaCampos[0] = comentarioSegmentoDeClientes;
    listaCampos[1] = comentarioPropostaDeValor;
    listaCampos[2] = comentarioAtividadesChave;

    mudarCorLista(listaCampos, tabNegocio, "Negócio");
}

function verificaComentarioNegocioPreAvaliar() {

    var comentarioSegmentoDeClientes = document.getElementById("formulario_comentarpreavalizar:segmentoDeCliente2");
    var comentarioPropostaDeValor = document.getElementById("formulario_comentarpreavalizar:propostaDeValor2");
    var comentarioAtividadesChave = document.getElementById("formulario_comentarpreavalizar:atividadesChaves2");
    var tabNegocio = document.getElementById("tabNegocio");
    var listaCampos = new Array();

    listaCampos[0] = comentarioSegmentoDeClientes;
    listaCampos[1] = comentarioPropostaDeValor;
    listaCampos[2] = comentarioAtividadesChave;

    mudarCorLista(listaCampos, tabNegocio, "Negócio");
}


function verificaComentarioAnaliseMercadoRevisar() {

    var comentarioRelacoComClientes = document.getElementById("formulario_resubmeterplano:relacaoClientes3");
    var comentarioParceriasChaves = document.getElementById("formulario_resubmeterplano:parceriasChaves3");
    var comentarioCanais = document.getElementById("formulario_resubmeterplano:canais3");
    var comentarioRecursosPrincipais = document.getElementById("formulario_resubmeterplano:recursosPrincipais3");
    var comentarioConcorrentes = document.getElementById("formulario_resubmeterplano:concorrentes3");
    var tabAnaliseMercado = document.getElementById("tabAnaliseMercado");
    var listaCampos = new Array();

    listaCampos[0] = comentarioRelacoComClientes;
    listaCampos[1] = comentarioParceriasChaves;
    listaCampos[2] = comentarioCanais;
    listaCampos[3] = comentarioRecursosPrincipais;
    listaCampos[4] = comentarioConcorrentes;

    mudarCorLista(listaCampos, tabAnaliseMercado, "Análise de Mercado");
}

function verificaComentarioAnaliseMercadoAvaliar() {

    var comentarioRelacaoComClientes = document.getElementById("formulario_comentarpreavalizar:relacaoClientes2");
    var comentarioParceriasChave = document.getElementById("formulario_comentarpreavalizar:parceriasChave2");
    var comentarioCanais = document.getElementById("formulario_comentarpreavalizar:canais2");
    var comentarioRecursosPrincipais = document.getElementById("formulario_comentarpreavalizar:recursosPrincipais2");
    var comentarioConcorrentes = document.getElementById("formulario_comentarpreavalizar:concorrentes2");
    var tabAnaliseMercado = document.getElementById("tabAnaliseMercado");
    var listaCampos = new Array();

    listaCampos[0] = comentarioRelacaoComClientes;
    listaCampos[1] = comentarioParceriasChave;
    listaCampos[2] = comentarioCanais;
    listaCampos[3] = comentarioRecursosPrincipais;
    listaCampos[4] = comentarioConcorrentes;

    mudarCorLista(listaCampos, tabAnaliseMercado, "Análise de Mercado");
}

function verificaComentarioProdutoServicoRevisar() {
    
    var comentarioEstagioEvolucao = document.getElementById("formulario_resubmeterplano:comentarioEstagioEvolucao3");
    var comentarioTecnologiaProcessos = document.getElementById("formulario_resubmeterplano:tecnologiaProcessos3");
    var comentarioPotencialInovacaoTecnologica = document.getElementById("formulario_resubmeterplano:potencialInovacaoTecnologica3");
    var comentarioAplicacoes = document.getElementById("formulario_resubmeterplano:aplicacoes3");
    var comentarioDificuldadesEsperadas = document.getElementById("formulario_resubmeterplano:dificuldadesEsperadas3");
    var comentarioInteracaoEmpresaUniversidade = document.getElementById("formulario_resubmeterplano:interacaoEmpresaUniversidade3");
    var comentarioInteracaoEmpresaComunidadeGoverno = document.getElementById("formulario_resubmeterplano:interacaoEmpresaComunidadeGoverno3");
    var comentarioInfraestrutura = document.getElementById("formulario_resubmeterplano:infraestrutura3");
    var tabProdutoServico = document.getElementById("tabProdutoServico");
    var listaCampos = new Array();
    listaCampos[0] = comentarioEstagioEvolucao;
    listaCampos[1] = comentarioTecnologiaProcessos;
    listaCampos[2] = comentarioPotencialInovacaoTecnologica;
    listaCampos[3] = comentarioAplicacoes;
    listaCampos[4] = comentarioDificuldadesEsperadas;
    listaCampos[5] = comentarioInteracaoEmpresaUniversidade;
    listaCampos[6] = comentarioInteracaoEmpresaComunidadeGoverno;
    listaCampos[7] = comentarioInfraestrutura;

    mudarCorLista(listaCampos, tabProdutoServico, "Produto ou Serviço");
}

function verificaComentarioProdutoServicoAvaliar() {
    
    var comentarioEstagioEvolucao = document.getElementById("formulario_comentarpreavalizar:comentarioEstagioEvolucao2");
    var comentarioTecnologiaProcessos = document.getElementById("formulario_comentarpreavalizar:tecnologiaProcessos2");
    var comentarioPotencialInovacaoTecnologica = document.getElementById("formulario_comentarpreavalizar:potencialInovacaoTecnologica2");
    var comentarioAplicacoes = document.getElementById("formulario_comentarpreavalizar:aplicacoes2");
    var comentarioDificuldadesEsperadas = document.getElementById("formulario_comentarpreavalizar:dificuldadesEsperadas2");
    var comentarioInteracaoEmpresaUniversidade = document.getElementById("formulario_comentarpreavalizar:interacaoEmpresaUniversidade2");
    var comentarioInteracaoEmpresaComunidadeGoverno = document.getElementById("formulario_comentarpreavalizar:interacaoEmpresaComunidadeGoverno2");
    var comentarioInfraestrutura = document.getElementById("formulario_comentarpreavalizar:infraestrutura2");
    var tabProdutoServico = document.getElementById("tabProdutoServico");
    var listaCampos = new Array();
    
    listaCampos[0] = comentarioEstagioEvolucao;
    listaCampos[1] = comentarioTecnologiaProcessos;
    listaCampos[2] = comentarioPotencialInovacaoTecnologica;
    listaCampos[3] = comentarioAplicacoes;
    listaCampos[4] = comentarioDificuldadesEsperadas;
    listaCampos[5] = comentarioInteracaoEmpresaUniversidade;
    listaCampos[6] = comentarioInteracaoEmpresaComunidadeGoverno;
    listaCampos[7] = comentarioInfraestrutura;

    mudarCorLista(listaCampos, tabProdutoServico, "Produto ou Serviço");
}

function verificaComentarioGestaoPessoasRevisar() {

    var comentarioParticipacaoAcionaria = document.getElementById("formulario_resubmeterplano:participacaoAcionaria3");
    var comentarioPotencialEmprego = document.getElementById("formulario_resubmeterplano:potencialEmprego3");
    var tabGestaoPessoas = document.getElementById("tabGestaoPessoas");
    var listaCampos = new Array();

    listaCampos[0] = comentarioParticipacaoAcionaria;
    listaCampos[1] = comentarioPotencialEmprego;

    mudarCorLista(listaCampos, tabGestaoPessoas, "Gestão de Pessoas");
}

function verificaComentarioPlanoFinanceiroRevisar() {

    var comentarioFontesDeReceita = document.getElementById("formulario_resubmeterplano:fontesDeReceita3");
    var comentarioEstruturaCustos = document.getElementById("formulario_resubmeterplano:estruturaCustos3");
    var comentarioInvestimentoInicial = document.getElementById("formulario_resubmeterplano:investimentoInicial3");
    var comentarioTabelaCustoFixo = document.getElementById("formulario_resubmeterplano:comentarioCustoFixo2");
    var comentarioTabelaCustoVariavel = document.getElementById("formulario_resubmeterplano:comentarioCustoVariavel2");
    var tabPlanoFinanceiro = document.getElementById("tabPlanoFinanceiro");
    var listaCampos = new Array();

    listaCampos[0] = comentarioFontesDeReceita;
    listaCampos[1] = comentarioEstruturaCustos;
    listaCampos[2] = comentarioInvestimentoInicial;
    listaCampos[3] = comentarioTabelaCustoFixo;
    listaCampos[4] = comentarioTabelaCustoVariavel;

    mudarCorLista(listaCampos, tabPlanoFinanceiro, "Plano Financeiro");
}

function verificaComentarioPlanoFinanceiroAlaviar() {

    var comentarioFontesDeReceita = document.getElementById("formulario_comentarpreavalizar:fontesDeReceita2");
    var comentarioEstruturaCustos = document.getElementById("formulario_comentarpreavalizar:estruturaCustos2");
    var comentarioInvestimentoInicial = document.getElementById("formulario_comentarpreavalizar:investimentoInicial2");
    var comentarioTabelaCustoFixo = document.getElementById("formulario_comentarpreavalizar:comentarioCustoFixo2");
    var comentarioTabelaCustoVariavel = document.getElementById("formulario_comentarpreavalizar:comentarioCustoVariavel2");
    var tabPlanoFinanceiro = document.getElementById("tabPlanoFinanceiro");
    var listaCampos = new Array();

    listaCampos[0] = comentarioFontesDeReceita;
    listaCampos[1] = comentarioEstruturaCustos;
    listaCampos[2] = comentarioInvestimentoInicial;
    listaCampos[3] = comentarioTabelaCustoFixo;
    listaCampos[4] = comentarioTabelaCustoVariavel;

    mudarCorLista(listaCampos, tabPlanoFinanceiro, "Plano Financeiro");
}

function mudarCorLista(listaCampos, tab, nomeCampo) {
    var flagCompleto = false;
    for (var i = 0; i < listaCampos.length; i++) {
        if (verificaPreenchimentoComentario(listaCampos[i])) {
            flagCompleto = false;
            break;
        } else {
            flagCompleto = true;
        }
    }

    if (flagCompleto) {
        tab.innerHTML = nomeCampo + " <i id='idIconContato' class='fa fa-check-square'></i>";
        tab.style.color = "green";
    } else {
        tab.innerHTML = nomeCampo + " <i id='idIconContato' class='fa fa-comment-o'></i>";
        tab.style.color = "red";
    }
}

/**
 * @description Verifica o preenchimento do campo de formulário desejado
 * @param {type} campo
 * @returns {Boolean}
 */
function verificaPreenchimentoComentario(campo) {
    if (campo.value.trim() === "" || campo.value.trim() === null) {
        return false;
    } else {
        return true;
    }
}
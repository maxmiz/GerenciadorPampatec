/* 
 * JavaScript para a página PréAvaliarPlanoNegocio
 */

var POSICAO_REALIZAR_MELHORIA = 1;//Posição em que a opção de realizar ajustes está localizada.

/**
 * Método que mostra e esconde o aviso de que o usuário precisa preencher pelo
 * menos um campo ao enviar para realizar ajuste.
 * @returns {undefined}
 */
function mostrarMensagemCampoObrigatorio() {
    var mensagemRealizarAjustes = document.getElementById("formulario_comentarpreavalizar:mensagemStatusAvaliacao");
    var listacampos = document.getElementsByClassName("campoFeedBack");
    var listaCamposAbertos = document.getElementsByClassName("campoFeedBackOn");
    var cont = 0;

    juntarListas(listacampos, listaCamposAbertos);

    for (var i = 0; i < listacampos.tamanho; i++) {
        var campo = listacampos[i];
        if (campo != null && campo.value != "" &&
                campo.id != "formulario_comentarpreavalizar:campoObservacoes" &&
                campo.id != "formulario_comentarpreavalizar:observacoesPreDefinidas") {
            cont++;
            break;
        }
    }
    if (mensagemRealizarAjustes != null) {
        if (verificaPreechimentoRadioButton()) {
            if (cont == 0) {
                mensagemRealizarAjustes.style.display = "block";
            } else {
                mensagemRealizarAjustes.style.display = "none";
            }
        } else {
            mensagemRealizarAjustes.style.display = "none";
        }
    }
}

/**
 * método usado para juntar 2 listas
 *  disponibilizadas pelo método mostrarMensagemCampoObrigatorio.
 * @param {Array} array1
 * @param {Array} array2
 * @returns {undefined}
 */
function juntarListas(array1, array2) {
    var cont = 0;
    var posicao;
    for (var i = 0; i < array2.length; i++) {
        posicao = array1.length + i;
        array1[posicao] = array2[i];
        cont++;
    }

    array1.tamanho = array1.length + cont;
}
;

/**
 * Verifica se o radio button está com a opção de realizar ajustes selecionada.
 * @returns {Boolean}
 */
function verificaPreechimentoRadioButton() {

    if (document.forms['formulario_comentarpreavalizar']['formulario_comentarpreavalizar:avaliacao'][POSICAO_REALIZAR_MELHORIA].checked) {
        return true;
    }
    return false;
}


/**
 * Como Gerente
 * É chamado no body da página (ao caregar a página)
 * verifica a existencia de comentários em todos os campos dentro das abas
 * Se houver, os metodos das Abas mudam a cor das Abas.
 */
function verificaAlteracoesPreAvaliar() {

    verificaAlteracoesNegocioPreAvaliar();
    verificaAlteracoesAnaliseMercadoPreAvaliar();
    verificaAlteracoesProdutoServicoPreAvaliar();
    verificaAlteracoesGestaoPessoasPreAvaliar();
    verificaAlteracoesPlanoFinanceiroPreAvaliar();

}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos das alterações dos campos
 * verifica a existencia de alterações em  campos dentro da aba Negocio
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaAlteracoesNegocioPreAvaliar() {

    var tabNegocio = document.getElementById("tabNegocio");
    var listaCampos = document.getElementsByClassName("negocioAlteracao");

    mudarCorListaPreAvaliarAlteracoes(listaCampos, tabNegocio, "Negócio");
}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos das alterações dos campos
 * verifica a existencia de alterações em  campos dentro da aba Analise de Mercado
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaAlteracoesAnaliseMercadoPreAvaliar() {

    var tabAnaliseMercado = document.getElementById("tabAnaliseMercado");
    var listaCampos = document.getElementsByClassName("analiseMercadoAlteracao");

    mudarCorListaPreAvaliarAlteracoes(listaCampos, tabAnaliseMercado, "Análise de Mercado");
}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos das alterações dos campos
 * verifica a existencia de alterações em  campos dentro da aba Produto ou Serviço
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaAlteracoesProdutoServicoPreAvaliar() {

    var tabProdutoServico = document.getElementById("tabProdutoServico");
    var listaCampos = document.getElementsByClassName("produtoServicoAlteracao");

    mudarCorListaPreAvaliarAlteracoes(listaCampos, tabProdutoServico, "Produto ou Serviço");
}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos das alterações dos campos
 * verifica a existencia de alterações em  campos dentro da aba Gestão de Pessoas
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaAlteracoesGestaoPessoasPreAvaliar() {


    var tabGestaoPessoas = document.getElementById("tabGestaoPessoas");
    var listaCampos = document.getElementsByClassName("gestaoPessoasAlteracao");

    mudarCorListaPreAvaliarAlteracoes(listaCampos, tabGestaoPessoas, "Gestão de Pessoas");
}

/**
 * Como Gerente
 * Preenche uma lista contendo os elementos das alterações dos campos
 * verifica a existencia de alterações em  campos dentro da aba Plano Financeiro
 * Se houver, o metodo mudarCorLista muda a cor da Aba.
 */
function verificaAlteracoesPlanoFinanceiroPreAvaliar() {

    var tabPlanoFinanceiro = document.getElementById("tabPlanoFinanceiro");
    var listaCampos = document.getElementsByClassName("planoFinanceiroAlteracao");
    mudarCorListaPreAvaliarAlteracoes(listaCampos, tabPlanoFinanceiro, "Plano Financeiro");
}

/**
 * método que se houver alterações em uma determinada aba
 * muda de cor a mesma para vermelho
 * @param {type} listaCampos
 * @param {type} tab
 * @param {type} nomeCampo
 * @returns {undefined}
 */
function mudarCorListaPreAvaliarAlteracoes(listaCampos, tab, nomeCampo) {

    var flagCompleto = false;
    
        if (listaCampos.length === 0) {
            flagCompleto = true;
          
        } else {
            flagCompleto = false;        
    }

    if (flagCompleto) {
        tab.innerHTML = nomeCampo;
        tab.style.color = "#2780e3";
    } else {
        tab.innerHTML = nomeCampo + " <i id='idIconContato' class='fa fa-comment-o'></i>";
        tab.style.color = "red";
    }
}






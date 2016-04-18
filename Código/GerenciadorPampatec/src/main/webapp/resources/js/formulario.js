// This file is autogenerated via the `commonjs` Grunt task. You can require() this file in a CommonJS environment.


var precisaSalvar = false;

/* campo selecionado para VISUALIZAÇÃO pelo usuario */
var campoDoWorkflowSelecionado = null;

/* campo referente a etapa que está em EXECUÇÃO NO PROCESSO */
var etapaAtualDoWorkflow = null;

/* campo para armazenar a classe da etapa que o usuario esta visualizando antes de ir para outra */
var classeAnterior = null;

/* variavel para armazenar o objeto anterior */
var objetoAnterior = null;

/* variavel para armazenar o objeto do botao anterior */
var objetoBotaoAnterior = null;

/* campo para armazenar a classe dO botao que o usuario esta visualizando antes de ir para outro */
var classeBotaoAnterior = null;

/*
 * Funções de exibição de Informações
 * relativa as funcionalidades dos botões
 */

/*
 * Funções de Retorno de etapas no 
 * formulário de Envio de Plano de Negócio
 * Estas funções não estão sendo utilizadas, estão registradas aqui apenas para em caso de necessidade
 * futura já saber como implementar o fade de elementos
 */

function retornaPrimeiraParte() {
    $("#formularioParte02").fadeOut(1);
    $("#formularioParte01").fadeIn(1);
}
function retornaSegundaParte() {
    $("#formularioParte03").fadeOut(1);
    $("#formularioParte02").fadeIn(1);
}
function retornaTerceiraParte() {
    $("#formularioParte04").fadeOut(1);
    $("#formularioParte03").fadeIn(1);
}
function retornaQuartaParte() {
    $("#formularioParte05").fadeOut(1);
    $("#formularioParte04").fadeIn(1);
}
function retornaQuintaParte() {
    $("#formularioParte06").fadeOut(1);
    $("#formularioParte05").fadeIn(1);
}

/*
 * Fim das funções de retorno de etapas do formulário --------------------------
 */

/*
 * Início das funções de exibição das próximas
 * etapas do formulário de Envio do Plano de Negócio
 *
 * Estas funções não estão sendo utilizadas, estão registradas aqui apenas para em caso de necessidade
 * futura já saber como implementar o fade de elementos
 */

function exibeSegundaParte() {
    $("#formularioParte01").fadeOut(1);
    $("#formularioParte02").fadeIn(1);
}
function exibeTerceiraParte() {
    $("#formularioParte02").fadeOut(1);
    $("#formularioParte03").fadeIn(1);
}
function exibeQuartaParte() {
    $("#formularioParte03").fadeOut(1);
    $("#formularioParte04").fadeIn(1);
}
function exibeQuintaParte() {
    $("#formularioParte04").fadeOut(1);
    $("#formularioParte05").fadeIn(1);
}
function exibeSextaParte() {
    $("#formularioParte05").fadeOut(1);
    $("#formularioParte06").fadeIn(1);
}

/*
 * Fim das funções de exibição
 * das próximas etapas do fomulário
 * de envio do plano de negócio
 * -----------------------------------------------------------------
 */

/**
 * @description text
 * @returns {undefined}
 */
function carregaFeedBack() {
    var feedBack = document.getElementById("formulario_cadastro_projeto:modal-feedBackSalvar");
    feedBack.setAttribute("class", "modal-feedBackSalvar modal-feedBackSalvar-in");
}

/**
 * @description text
 * @returns {undefined}
 */
function fechaFeedBack() {
    var feedBack = document.getElementById("formulario_cadastro_projeto:modal-feedBackSalvar");
    feedBack.style.display = "none";
}

/**
 * @description Chama a verificação de todos os formulários de cada aba do cadastro de Plano
 * para inserir o ícone de "Certo" ao lado do nada da aba correspondente.
 * @returns {undefined}
 */
function verificarCampos() {
    verificaNegocio();
    verificaAnaliseMercado();
    verificarProdutoServico();
    verificaGestaoPessoas();
    verificaPlanoFinanceiro();
}


/**
 * @description Verifica se todos os campos do formulário referente ao Negócio foram preenchidos.
 * Se sim, irá adicionar um ícone de "certo em verde" ao lado do nome da aba.
 * @returns {undefined}
 */
function verificaNegocio() {
    var nomeProjeto = document.getElementById("formulario_cadastro_projeto:empresaProjeto");
    var segmentoDeClientes = document.getElementById("formulario_cadastro_projeto:segmentoDeClientes");
    var propostaDeValor = document.getElementById("formulario_cadastro_projeto:propostaDeValor");
    var atividadesChave = document.getElementById("formulario_cadastro_projeto:atividadesChave");
    var tabNegocio = document.getElementById("tabNegocio");
    var listaCampos = new Array();
    listaCampos[0] = nomeProjeto;
    listaCampos[1] = segmentoDeClientes;
    listaCampos[2] = propostaDeValor;
    listaCampos[3] = atividadesChave;
    mudarCorLista(listaCampos, tabNegocio, "Negócio");
}

/**
 * @description Verifica se todos os campos do formulário referente a Análise de Mercado foram preenchidos.
 * Se sim, irá adicionar um ícone de "certo em verde" ao lado do nome da aba.
 * @returns {undefined}
 */
function verificaAnaliseMercado() {
    var relacoComClientes = document.getElementById("formulario_cadastro_projeto:relacoComClientes");
    var parceriasChaves = document.getElementById("formulario_cadastro_projeto:parceriasChaves");
    var canais = document.getElementById("formulario_cadastro_projeto:canais");
    var recursosPrincipais = document.getElementById("formulario_cadastro_projeto:recursosPrincipais");
    var concorrentes = document.getElementById("formulario_cadastro_projeto:concorrentes");
    var tabAnaliseMercado = document.getElementById("tabAnaliseMercado");
    var listaCampos = new Array();
    listaCampos[0] = relacoComClientes;
    listaCampos[1] = parceriasChaves;
    listaCampos[2] = canais;
    listaCampos[3] = recursosPrincipais;
    listaCampos[4] = concorrentes;
    mudarCorLista(listaCampos, tabAnaliseMercado, "Análise de Mercado");
}

/**
 * @description Verifica se todos os campos do formulário referente ao Produto ou Serviço foram preenchidos.
 * Se sim, irá adicionar um ícone de "certo em verde" ao lado do nome da aba.
 * @returns {undefined}
 */
function verificarProdutoServico() {
    var tecnologiaProcessos = document.getElementById("formulario_cadastro_projeto:tecnologiaProcessos");
    var potencialInovacaoTecnologica = document.getElementById("formulario_cadastro_projeto:potencialInovacaoTecnologica");
    var aplicacoes = document.getElementById("formulario_cadastro_projeto:aplicacoes");
    var dificuldadesEsperadas = document.getElementById("formulario_cadastro_projeto:dificuldadesEsperadas");
    var interacaoEmpresaUniversidade = document.getElementById("formulario_cadastro_projeto:interacaoEmpresaUniversidade");
    var interacaoEmpresaComunidadeGoverno = document.getElementById("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno");
    var infraestrutura = document.getElementById("formulario_cadastro_projeto:infraestrutura");
    var tabProdutoServico = document.getElementById("tabProdutoServico");
    var listaCampos = new Array();

    listaCampos[0] = tecnologiaProcessos;
    listaCampos[1] = potencialInovacaoTecnologica;
    listaCampos[2] = aplicacoes;
    listaCampos[3] = dificuldadesEsperadas;
    listaCampos[4] = interacaoEmpresaUniversidade;
    listaCampos[5] = interacaoEmpresaComunidadeGoverno;
    listaCampos[6] = infraestrutura;
    mudarCorLista(listaCampos, tabProdutoServico, "Produto ou Serviço");
    verificarPreenchimentoRadioButton();
}

/**
 * @description Verifica se todos os campos do formulário referente a Gestão de Pessoas foram preenchidos.
 * Se sim, irá adicionar um ícone de "certo em verde" ao lado do nome da aba.
 * @returns {undefined}
 */
function verificaGestaoPessoas() {
    var participacaoAcionaria = document.getElementById("formulario_cadastro_projeto:participacaoAcionaria");
    var potencialEmprego = document.getElementById("formulario_cadastro_projeto:potencialEmprego");
    var tabGestaoPessoas = document.getElementById("tabGestaoPessoas");
    var listaCampos = new Array();
    listaCampos[0] = participacaoAcionaria;
    listaCampos[1] = potencialEmprego;
    mudarCorLista(listaCampos, tabGestaoPessoas, "Gestão de Pessoas");
}

/**
 * @description Verifica se todos os campos do formulário referente ao Plano Financeiro foram preenchidos.
 * Se sim, irá adicionar um ícone de "certo em verde" ao lado do nome da aba.
 * @returns {undefined}
 */
function verificaPlanoFinanceiro() {
    var fontesDeReceita = document.getElementById("formulario_cadastro_projeto:fontesDeReceita");
    var estruturaCustos = document.getElementById("formulario_cadastro_projeto:estruturaCustos");
    var investimentoInicial = document.getElementById("formulario_cadastro_projeto:investimentoInicial");
    var tabPlanoFinanceiro = document.getElementById("tabPlanoFinanceiro");
    var listaCampos = new Array();

    listaCampos[0] = fontesDeReceita;
    listaCampos[1] = estruturaCustos;
    listaCampos[2] = investimentoInicial;

    mudarCorLista(listaCampos, tabPlanoFinanceiro, "Plano Financeiro");

    if (!verificaTabelasCusto()) {
        tabPlanoFinanceiro.innerHTML = "Plano Financeiro";
        tabPlanoFinanceiro.style.color = "red";
    }
}

/**
 * Verifica se as tabelas do custo estão preenchidas
 * @returns {Boolean} true se elas estão preenchidas
 */
function verificaTabelasCusto() {
    var tabelaCustoFixo = document.getElementById("formulario_cadastro_projeto:novaTabelaCustosFixos_data");
    var tabelaCustoVariavel = document.getElementById("formulario_cadastro_projeto:novaTabelaCustosVariaveis_data");
    var listaTrFixo = tabelaCustoFixo.getElementsByTagName('tr');
    var listaTrVariavel = tabelaCustoVariavel.getElementsByTagName('tr');
    var preenchido;

    preenchido = percorrerTrs(listaTrFixo);
    if (preenchido) {
        preenchido = percorrerTrs(listaTrVariavel);
    }

    return preenchido;
}

/**
 * Percorre os trs para verificar se a tabela não está vazia.
 * @param {type} listaTr lista de trs
 * @returns {Boolean} true se ela não está vazia
 */
function percorrerTrs(listaTr) {
    var trLaco;
    for (var i = 0; i < listaTr.length; i++) {
        trLaco = listaTr[i];
        //Se a classe do tr indicar que a tabela está vazia
        if ($(trLaco).hasClass('ui-widget-content ui-datatable-empty-message')) {
            return false;
        } else {
            return true;
        }
    }
}


/**
 * @description text
 * @param {type} listaCampos
 * @param {type} tab
 * @param {type} nomeCampo
 * @returns {undefined}
 */
function mudarCorLista(listaCampos, tab, nomeCampo) {
    var flagCompleto = false;
    for (var i = 0; i < listaCampos.length; i++) {
        if (verificaPreenchimento(listaCampos[i])) {
            flagCompleto = true;
        } else {
            flagCompleto = false;
            break;
        }
    }

    if (flagCompleto) {
        tab.innerHTML = nomeCampo + " <i id='idIconContato' class='fa fa-check-square'></i>";
        tab.style.color = "green";
    } else {
        tab.innerHTML = nomeCampo;
        tab.style.color = "red";
    }
}

/**
 * @description Muda a cor do texto. Neste caso está sendo utilizado para colorir o texto
 * das abas do cadastro do plano de negócio. Preenchido = verde || Não preenchido = vermelho
 * @param {type} campo
 * @param {type} tab
 * @param {type} nomeCampo
 * @returns {undefined}
 */
function mudarCor(campo, tab, nomeCampo) {
    if (verificaPreenchimento(campo)) {
        tab.innerHTML = nomeCampo + " <i id='idIconContato' class='fa fa-check-square'></i>";
        tab.style.color = "green";
    } else {
        tab.innerHTML = nomeCampo;
        tab.style.color = "red";
    }
}

/**
 * @description Verifica o preenchimento do campo de formulário desejado
 * @param {type} campo
 * @returns {Boolean}
 */
function verificaPreenchimento(campo) {
    if (campo.value.trim() === "") {
        return false;
    } else {
        return true;
    }
}

//trim completo
/**
 * @description text
 * @returns {String.prototype@call;replace}
 */
String.prototype.trim = function () {
    return this.replace(/^\s+|\s+$/g, "");
};

/**
 * @description Verifica o preenchimento de elementos do tipo RadioButton.
 * Se estiver utilizando o PrimeFaces, sugiro fortemente substituir a utilização de
 * RadiosButtons por DropDows.
 * @returns {undefined}
 */
function verificarPreenchimentoRadioButton() {
    var elementos = document.getElementsByClassName('ui-radiobutton-box ui-widget ui-corner-all ui-state-default ui-state-active');
    for (var i = 0; i < elementos.length; i++) {
        console.log("Deu");
    }
}

/**
 * @description text
 * @param {type} listaComponentes
 * @param {type} pai
 * @param {type} contador
 * @returns {undefined}
 */
function percorrerArvoreObejetos(listaComponentes, pai, contador) {
    for (var i = 0; i < pai.children.length; i++) {
        if (pai.children[i].tagName === listaComponentes[contador]) {
            console.log("Nome da tag" + pai.children[i].tagName);
            console.log("Nome procurado" + listaComponentes[contador]);
            console.log(pai.children[i].className);
            if (contador === 5 && pai.children[i].className === "ui-radiobutton-box ui-widget ui-corner-all ui-state-default ui-state-active") {
                console.log("DEEEEUUUUUUUUU");
            }
            contador++;
            percorrerArvoreObejetos(listaComponentes, pai.children[i], contador);
        }
    }
}


/**
 * @description Exibe a modal para confirmação de salvamento
 * @returns {undefined}
 */
function infoSalvar() {
    $("#modalInfoSalvar").modal();
}

/**
 * @description Exibe a modal para confirmação de salvamento da equipe
 * @returns {undefined}
 */
function infoSalvarEquipe() {
    $("#modalInfoSalvarEquipe").modal();
}

/**
 * @description Exibe modal de confirmação de envio
 * @returns {undefined}
 */
function confirmacaoDeEnvio() {
    $("#modalInfoDeEnvio").modal();
}

/**
 * @description Metodo que exibe ou esconde os campos de adicionar comentarios na realizar pré-avaliação
 * @param {type} id
 * @returns {undefined}
 */
function mostrarFeedBack(id) {
    var campo = document.getElementById(id);
    if ($(campo).hasClass("form-control campoFeedBackOn")) {
        $(campo).fadeOut(900);
        campo.setAttribute("class", "form-control campoFeedBack");
    } else {
        $(campo).fadeIn(900);
        campo.setAttribute("class", "form-control campoFeedBackOn");
    }
}


/**
 * @description 
 * Ao entrar em uma pagina na aba EM ELABORAÇÃO contendo o workflow 
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

//      ELABORACAO = 0;
        case 0:
            etapa2.innerHTML = "<b>Pré-Avaliação</b>";
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();

            addFocoBotao("botao_revisar");
            
            mostraDIV2('div_apresentacao_formulario');

            etapaAtualDoWorkflow = "etapa1";

            var etapa = document.getElementById("etapa2");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");
            break;

//      SUBMETIDO = 1;
        case 1:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();

            etapaAtualDoWorkflow = "etapa2";
            
            addFocoBotao("botao_revisar");

            mostraDIV('div_revisar_plano');

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
            etapa2.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();

            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('div_revisar_plano');
            
            addFocoBotao("botao_revisar");

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
            etapa2.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();

            etapaAtualDoWorkflow = "etapa2";
            

            mostraDIV('div_revisar_plano');
            
            addFocoBotao("botao_revisar");

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
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
            etapa2.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();

            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('div_revisar_plano');
            
            addFocoBotao("botao_revisar");

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;
            
//      NECESSITA_MELHORIA = 7;
        case 7:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();

            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('div_revisar_plano');
            
            addFocoBotao("botao_revisar");

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
            etapa2.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();

            etapaAtualDoWorkflow = "etapa2";

            mostraDIV('div_revisar_plano');
            
            addFocoBotao("botao_revisar");

            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;
            
//      AVALIACAO = 2;    
        case 2:

            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active");
            etapa3.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();
            
            etapaAtualDoWorkflow = "etapa3";
            
            mostraDIV('div_revisar_plano');
            
            addFocoBotao("botao_revisar");

            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      FORMALIZACAO = 3;
        case 3:
            etapa5.innerHTML = "<b>Incubação</b>";

            etapaAtualDoWorkflow = "etapa4";

            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active");
            etapa3.setAttribute("class", "active");
            etapa4.setAttribute("class", "active, etapaAtual");

            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");

            break;

//      INCUBACAO = 4;
        case 4:

            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active");
            etapa3.setAttribute("class", "active");
            etapa4.setAttribute("class", "active");
            etapa5.setAttribute("class", "active, etapaAtual");
            etapaAtualDoWorkflow = "etapa5";

            break;
           
//      DEFININDO_EQUIPE = 8;
        case 8:
            etapa2.innerHTML = "<b>Pré-Avaliação</b>";
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();
            var botao_preavaliacao = document.getElementById("botao_elaboracao_equipe");

            botao_preavaliacao.setAttribute("class", "btn btn-danger btnEstadoAtual");
            mostraDIV('formParte01');

            etapaAtualDoWorkflow = "etapa1";

            var etapa = document.getElementById("etapa2");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa3");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa4");
            etapa.setAttribute("style", "cursor: default;");
            var etapa = document.getElementById("etapa5");
            etapa.setAttribute("style", "cursor: default;");
            
            break;

    }
}


/**
 * @description Função que exibe o menu vertical referente a etapa de elaboração
 * @returns {undefined}
 */
function mostra_vertical_elaboracao() {

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "col-md-2 text-center bounceInLeft animated estiloDivVertical noprint");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");
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
 * @description Função que exibe o menu vertical referente a etapa de Avaliação
 * @returns {undefined}
 */
function mostra_avaliacao() {

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated estiloDivVertical noprint");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");

}

/**
 * @description Função que exibe o menu vertical referente a etapa de Formalização
 * @returns {undefined}
 */
function mostra_formalizacao() {

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated estiloDivVertical noprint");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");


}

/**
 * @description Função que exibe o menu vertical referente a etapa de Incubação
 * @returns {undefined}
 */
function mostra_incubacao() {

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated estiloDivVertical noprint");

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
 * @description Coloca foco na etapa (círculo com nome e número) em que o usuário está visualizando no workflow
 * @param {type} idDoItem
 * @returns {undefined}
 */
function addFoco(idDoItem) {
    var etapa = document.getElementById(idDoItem);
    if (objetoAnterior !== null) {
        retornarCorOriginal();
    }
    classeAnterior = etapa.getAttribute('class');
    etapa.setAttribute("class", classeAnterior + " etapaSelecionada pulse animated");
    objetoAnterior = etapa;
}

/**
 * @description Retorna a classe original da etapa que o usuário deixou de visualizar
 * @returns {undefined}
 */
function retornarCorOriginal() {
    objetoAnterior.setAttribute("class", classeAnterior);
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

/**
 * @description Função para exibir o campo outro na etapa de seleção do estágio de evolução do plano de negócio
 * @returns {undefined}
 */
function exibeCampoOutro() {
    if (document.getElementById('hsbc').checked) {
        document.getElementById('mostrarOutro').setAttribute("readonly", true);
    } else {
        document.getElementById('form1:hit').removeAttribute("readonly");
    }
}

/**
 * @description Função para imprimir o conteúdo da página atual
 * @returns {undefined}
 */
function imprimirPaginaHtml() {
    document.window.print();
}

/**
 * Filtra os valores de entrada, para receber apenas números 
 * @param {type} e
 * @returns {Boolean}
 */
function SomenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58))
        return true;
    else {
        if (tecla == 8 || tecla == 0 || tecla == 46)
            return true;
        else
            return false;
    }
}

/**
 * Atualiza a tab do plano financeiro dependendo.
 * @param {data} data informações do requisição do ajax
 */
function atualizaTabAjax(data) {
    var status = data.status; // Can be "begin", "complete" or "success".
    var source = data.source; // The parent HTML DOM element.

    switch (status) {
        case "begin": // Before the ajax request is sent.
            // ...
            break;

        case "complete": // After the ajax response is arrived.
            // ...
            break;

        case "success": // After update of HTML DOM based on ajax response.
            verificaPlanoFinanceiro();
            break;
    }
}




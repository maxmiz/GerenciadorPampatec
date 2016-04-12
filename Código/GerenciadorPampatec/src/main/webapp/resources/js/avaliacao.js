/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function carregaPagina() {

    var etapa1 = document.getElementById("etapa1");
    var etapa2 = document.getElementById("etapa2");
    var etapa3 = document.getElementById("etapa3");
    var etapa4 = document.getElementById("etapa4");
    var etapa5 = document.getElementById("etapa5");

    switch (andamentoProjeto) {

//      AVALIACAO = 2;    
        case 2:
            
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";

            etapaAtualDoWorkflow = "etapa3";
            mostra_avaliacao();
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active");
            etapa3.setAttribute("class", "active, etapaAtual");

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
            
        default :
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

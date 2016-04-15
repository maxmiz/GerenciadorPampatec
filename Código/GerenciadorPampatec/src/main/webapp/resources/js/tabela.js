/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var botaoPadrao;

/**
 * Função que muda a classe do botão quando ele foi clicado pelo usuário, 
 * mas antes disso armazena o valor padrão do mesmo.
 * 
 * @param {type} botao
 * @returns {undefined}
 */
function filtroTabela(botao){
    
    if(botaoPadrao != null){
            botaoPadrao.setAttribute("class", "filtro");
    }
    
    botao.setAttribute("class", "filtro filtroClicado");
    botaoPadrao=botao;
    
}
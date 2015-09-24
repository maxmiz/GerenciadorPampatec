/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author GUTO
 */
@ManagedBean(name = "ajudaview")
public class AjudaView {

    /**
     * @since 22/09/2015
     * @param referencia metodo que recebe a referencia do botão de ajuda
     * clicado na parte de enviar projeto e exibe o componente de ajuda
     */
    public void showMessage(String referencia) {
        FacesMessage message = null; 
        switch (referencia) {
            case "nome":
    
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Nome", "Para mais informações: <a href=https://www.google.com target=_blank> Clique aqui</a>");
                break;
                
            case "email":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Email", "Descrição");
                break;
            
            case "segmentoDeClientes":
                message = new FacesMessage("Campo Segmento De Clientes", "Descrição");
//                ctx.addMessage(null, message);
                break;
            
            case "propostaDeValor":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Proposta De Valor", "Descrição");
                break;
            
            case "atividadesChave":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Atividades Chave", "Descrição");
                break;
            
            case "relacoComClientes":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Relação Com Clientes", "Descrição");
                break;
                
            case "parceriasChaves":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Parcerias Chaves", "Descrição <a href=https://www.google.com target=_blank> Clique aqui</a>");
                break;
                
            case "canais":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Canais", "Descrição");
                break;
            
            case "recursosPrincipais":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Recursos Principais", "Descrição");
                break;
                
            case "concorrentes":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Concorrentes", "Descrição");
                break;
            
            case "estagioDeEvolucao":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Estagio De Evolucao", "Descrição");
                break;
            
            case "tecnologiaProcessos":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Tecnologia e Processos", "Descrição");
                break;
            
            case "potencialInovacaoTecnologica":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Potencial de Inovacao e Tecnologica", "Descrição");
                break;
            
            case "aplicacoes":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Potencial de Aplicacoes", "Descrição");
                break;
            
            case "dificuldadesEsperadas":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Dificuldades Esperadas", "Descrição");
                break;
            
            case "interacaoEmpresaUniversidade":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Interacao entre empresa e universidade", "Descrição");
                break;
                
            case "interacaoEmpresaComunidadeGoverno":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Interacao entre empresa, comunidade e governo", "Descrição");
                break;
            
            case "infraestrutura":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Infraestrutura", "Descrição");
                break;
                
            case "participacaoAcionaria":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Participacao Acionaria", "Descrição");
                break;
                
            case "potencialEmprego":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Potencial de Emprego", "Descrição");
                break;
                
            case "fontesDeReceita":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Fontes de Receitas", "Descrição");
                break;
                
            case "estruturaCustos":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Estrutura de Custos", "Descrição");
                break;
                
            case "investimentoInicial":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Investimento Inicial", "Descrição");
                break;
                
            case "custosfixos":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Custos Fixos", "Descrição");
                break;
                
            case "custosvariaveis":
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Campo Custos Variaveis", "Descrição");
                break;
                
        }

        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

}

package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "buscaProjetoEmpreendedorBean")
@ViewScoped
public class BuscaProjetoEmpreendedorBean implements Serializable {

    private ArrayList<Projeto> listaProjetos;//Lista de projetos exibidos
    private ProjetoDao projetoDao;//Dao para acessar o banco de dados
    private Projeto projetoSelecionado;//Projeto que foi selecionado quando um usuário escolhe algum item da lista.

    public BuscaProjetoEmpreendedorBean() {
        projetoDao = new ProjetoDao();
        listaProjetos = buscaProjetoPorEmpreendedor();
    }

    public void setListaProjetos(ArrayList<Projeto> listaProjetos) {
        this.listaProjetos = listaProjetos;
    }

    public ArrayList<Projeto> getListaProjetos() {
        return listaProjetos;
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    public List<Projeto> buscarProjetos() {
        return projetoDao.buscar();
    }

    public ProjetoDao getProjeto() {
        return projetoDao;
    }

    /**
     * Remove o empreendedor do projeto selecionado
     */
    public void sairDoProjeto() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) sessao.getAttribute("empreendedor");
        for (Object object : projetoSelecionado.getEmpreendedores()) {
            Empreendedor emmpreendedorLaco = (Empreendedor) object;
            if (Objects.equals(empreendedor.getIdUsuario(), emmpreendedorLaco.getIdUsuario())) {
                projetoSelecionado.getEmpreendedores().remove(emmpreendedorLaco);
                break;
            }
        }

        listaProjetos.remove(projetoSelecionado);

        if (projetoSelecionado.getEmpreendedores().isEmpty()) {
            projetoDao.deletar(projetoSelecionado.getIdProjeto());
        } else {
            projetoDao.update(projetoSelecionado);
        }

    }

    /**
     * Busca os projetos que um empreendedor tem.
     *
     * @return Lista de projetos encontrada.
     */
    public ArrayList<Projeto> buscaProjetoPorEmpreendedor() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) sessao.getAttribute("empreendedor");
        empreendedor = Empreendedor.buscaPorEmail(empreendedor.getEmail());

        ArrayList<Projeto> projetosEmpreendedor = new ArrayList();
        for (Object projeto : empreendedor.getProjetos()) {
            projetosEmpreendedor.add((Projeto) projeto);
        }
        return projetosEmpreendedor;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }

    /**
     * Envia o usuário para a página de enviar projeto, de acordo com o projeto
     * que ele selecionou.
     */
    public void enviaProjetoEditar() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projetoSelecionado);
        try {

            if (projetoSelecionado.getStatus() == Projeto.NECESSITA_MELHORIA || 
                projetoSelecionado.getStatus() == Projeto.SUBMETIDO ||
                projetoSelecionado.getStatus() == Projeto.REPROVADO) {
                
                FacesContext.getCurrentInstance().getExternalContext().redirect("planoDeNegocio/revisarPlanoDeNegocio.jsf");
            
            }else if(projetoSelecionado.getStatus() == Projeto.ACEITO_PARA_AVALIACAO){
                    
                FacesContext.getCurrentInstance().getExternalContext().redirect("planoDeNegocio/avaliacaoPlanoDeNegocio.jsf");
            
            }else{
                
                FacesContext.getCurrentInstance().getExternalContext().redirect("enviarProjeto.jsf");
            }
        } catch (IOException ex) {
            Logger.getLogger(BuscaProjetoEmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Deleta o projeto que o usuário selecionou.
     */
    public void deletarProjeto(Projeto projeto) {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", null);
        Empreendedor empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        this.projetoDao.deletar(projetoSelecionado.getIdProjeto());
        listaProjetos.remove(projetoSelecionado);
        secao.setAttribute("empreendedor", Empreendedor.buscaPorEmail(empreendedor.getEmail()));
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Plano excluído", "O plano foi excluído com sucesso.");
        FacesContext.getCurrentInstance().addMessage("lista_planos:mensagensFeed", msg);
    }

    /**
     * Verifica se o empreendedor da seção é o empreendedor correspondente do
     * objeto especificado.
     *
     * @param projeto Projeto para se verificar se o empreendedor é
     * correspondente
     * @return true se o empreendedor é correspondente
     */
    public boolean verificarEmpreendedor(Projeto projeto) {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        return empreendedor.verificaTipoEmpreendedor(projeto.getEmpreendedorCorrespondente());
    }

    /**
     * Verifica se o botão excluir pode ser ativado olhando o tipo de
     * empreendedor e se o projeto está em pre-avaliação.
     *
     * @param projeto Projeto para se verificar.
     * @return true se o botão pode ser ativado.
     */
    public boolean verificaExcluir(Projeto projeto) {
        return verificarEmpreendedor(projeto)
                && projeto.verificaSubmetido()
                && projeto.verificarSendoAvaliado()
                && projeto.verificarAceitoParaAvaliacao()
                && projeto.verificarReprovado()
                && projeto.verificarNecessitaAvaliacao();
    }

    public String formatarDataCriacao(Projeto projeto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (projeto.getDataCriacao() != null) {
            return formato.format(projeto.getDataCriacao());
        } else {
            return "Plano não criado.";
        }
    }

    public String formatarDataEnvio(Projeto projeto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (projeto.getDataEnvio() != null) {
            return formato.format(projeto.getDataEnvio());
        } else {
            return "Plano não enviado.";
        }
    }
}

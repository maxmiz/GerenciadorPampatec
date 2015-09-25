package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class BuscaProjetoEmpreendedorBean implements Serializable{
    private ArrayList<Projeto> listaProjetos;
    private ProjetoDao projeto;
    private Projeto projetoSelecionado;
    
     public BuscaProjetoEmpreendedorBean() {
        projeto = new ProjetoDao();
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
        return projeto.buscar();
    }

    public ProjetoDao getProjeto() {
        return projeto;
    }
    /**
     * Remove o empreendedor do projeto selecionado
     */
    public void sairDoProjeto(){
        System.out.println("nome do projeto = "+projetoSelecionado.getNome());
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) sessao.getAttribute("empreendedor");
//        System.out.println("projeto = "+projetoSelecionado.getEmpreendedores()+" empreendedor = "+empreendedor);
        projetoSelecionado.getEmpreendedores().remove(empreendedor);
//        System.out.println("projeto = "+projetoSelecionado.getEmpreendedores()+" empreendedor = "+empreendedor);
        
        listaProjetos.remove(projetoSelecionado);
        
        if(projetoSelecionado.getEmpreendedores().isEmpty()){
            projeto.deletar(projetoSelecionado.getIdProjeto());
        }else{
            projeto.update(projetoSelecionado);
        }
    
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().dispatch("PaginaBuscaProjeto.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BuscaProjetoEmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Projeto> buscaProjetoPorEmpreendedor() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor empreendedor = (Empreendedor) sessao.getAttribute("empreendedor");

        Projeto selecaoProjeto;
        ArrayList<Projeto> projetosEmpreendedor = new ArrayList();

        for (Object projeto : empreendedor.getProjetos().toArray()) {
            selecaoProjeto = (Projeto) projeto;
            projetosEmpreendedor.add(selecaoProjeto);
        }
        return projetosEmpreendedor;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }

    public void enviaProjetoEditar() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projetoSelecionado);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("enviarProjeto.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BuscaProjetoEmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletarProjeto() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projetoSelecionado);
        Empreendedor empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        this.projeto.deletar(projetoSelecionado.getAnaliseemprego().getIdAnaliseEmprego());
        this.projeto.deletar(projetoSelecionado.getPlanofinanceiro().getIdPlanoFinanceiro());
        this.projeto.deletar(projetoSelecionado.getProdutoouservico().getIdProdutoOuServico());
        this.projeto.deletar(projetoSelecionado.getNegocio().getIdNegocio());
        this.projeto.deletar(projetoSelecionado.getIdProjeto());
        listaProjetos.remove(projetoSelecionado);
        secao.setAttribute("empreendedor", Empreendedor.buscaPorEmail(empreendedor.getEmail()));
    }
}

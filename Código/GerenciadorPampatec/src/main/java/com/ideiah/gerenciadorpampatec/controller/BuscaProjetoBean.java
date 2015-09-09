package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

@ManagedBean (name="buscaProjetoBean")
@ViewScoped
public class BuscaProjetoBean {

    private ProjetoDao projeto;
    private Projeto selectedProjeto;
   
    public BuscaProjetoBean() {
        projeto = new ProjetoDao();
    }

    public List<Projeto> buscarProjetos() {
        return projeto.buscar();
    }

    public ProjetoDao getProjeto() {
        return projeto;
    }
     
    public Projeto getSelectedProjeto() {
        return selectedProjeto;
    }
    
    public void setSelectedProjeto(Projeto selectedProjeto) {
        this.selectedProjeto = selectedProjeto;
    }

}

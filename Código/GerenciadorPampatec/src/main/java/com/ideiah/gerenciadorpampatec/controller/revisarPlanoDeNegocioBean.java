/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Custo;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Ideiah Computer
 */
@ManagedBean
@ViewScoped

public class revisarPlanoDeNegocioBean implements Serializable {

    private Projeto projeto;
    private ComentarioProjeto comentarioProjeto;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private String estagioEvolucao;
    private String estagioEvolucaoOutro;

    public revisarPlanoDeNegocioBean() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) session.getAttribute("projetoSelecionado");
        recuperaComentarioProjeto();
        setEstagioEvolucao(verificaEstagioEvolucao());
    }

    /**
     * <p>
     * Método para retornar os comentários do projeto selecionado que estão com
     * o status finalizado.
     * </p>
     */
    public void recuperaComentarioProjeto() {

        for (ComentarioProjeto objetoComentarioprojeto : projeto.getComentarioProjeto()) {
            if (objetoComentarioprojeto.getStatus() == ComentarioProjeto.FINALIZADO) {
                comentarioProjeto = objetoComentarioprojeto;
                break;
            }
        }
    }
    
    public boolean verificaExistenciaComentarioProjeto(Projeto projetoSelecionado){
        if (projetoSelecionado.getStatus() == Projeto.ACEITO_PARA_AVALIACAO) {
            
            if(comentarioProjeto.verificaCampos() != 0){
                return true;
            }
            
        }
        return false;
    }
    
    
        public boolean verificaStatusSendoAvaliado(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.SENDO_AVALIADO;
    }

    public boolean verificaStatusAceitoAvaliacao(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.ACEITO_PARA_AVALIACAO;
    }
    
    public boolean verificaStatusSubmetido(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.SUBMETIDO;
    }
    
    public boolean verificaStatusReSubmetido(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.RESUBMETIDO;
    }

    public boolean verificaStatusEmPreAvaliacao(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.EM_PRE_AVALIACAO;
    }
    
    public boolean verificaStatusNecessitaMelhoria(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");

        return projetoSelecionado.getStatus() == Projeto.NECESSITA_MELHORIA;
    }

    /**
     * <p>
     * Retorna o projeto da sessão, garantindo que ele está atualizado com o
     * servidor.</p>
     *
     * @return projeto da sessão
     */
    public int retornaStatusProjeto() {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) sessao.getAttribute("projetoSelecionado");
        return projeto.getStatus();
    }

    /**
     * <p>
     * Método para retornar o resultado da Avaliação em <code>String</code> para
     * a área de Avaliação.
     * </p>
     *
     * @return o resultado da avaliação pelo gerente.
     *
     */
    public String retornaResultadoAvaliacao() {
        String resultadoAvaliacao = "";

        switch (projeto.getStatus()) {
            case Projeto.NECESSITA_MELHORIA:
                resultadoAvaliacao = " Projeto Necessita Realizar Ajustes";
                break;
            case Projeto.REPROVADO:
                resultadoAvaliacao = " Projeto Reprovado";
                break;
            case Projeto.ACEITO_PARA_AVALIACAO:
                resultadoAvaliacao = " Projeto Aceito para Avaliação";
                break;
            default:
                break;
        }
        return resultadoAvaliacao;
    }

    /**
     * <p>
     * Método para verificar qual o tipo de estágio a empresa se encontra.
     * </p>
     *
     * @return
     */
    private String verificaEstagioEvolucao() {
        String status = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
        if (status.equals("Outro:")) {
            return projeto.getProdutoouservico().getEstagioEvolucao();
        } else {
            return status;
        }
    }

    /**
     * <p>
     * Muda o status do projeto em pré avaliação e redireciona para o início.
     * </p>
     */
    public void mudaStatusRedirecionaInicio() {
        getLoginBean().getInicio();

    }

    /**
     * <p>
     * Método para salvar as edições feitas no objeto do projeto.
     * </p>
     */
    public void salvarRevisaoProjeto() {
        ProjetoDao projetoDao = new ProjetoDao();
        projetoDao.salvar(projeto);

        /**
         * Para exibir a mensagem de salvo com sucesso.
         */
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Sua alteração foi salva com sucesso.");
        FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:tituloMensagem", msg);
    }

    /**
     * <p>
     * Método para salvar e terminar a revisão do projeto.
     * </p>
     */
    public void terminarRevisaoProjeto() {
        ProjetoDao projetoDao = new ProjetoDao();
        projeto.setStatus(Projeto.RESUBMETIDO);
        Date dataEnvio = new Date(System.currentTimeMillis());
        projeto.setDataEnvio(dataEnvio);
        projetoDao.salvar(projeto);

        getBuscarPlanoDeNegocio();
    }

    /**
     * <p>
     * Redireciona para a página de lista de Planos de Negócio.
     * </p>
     */
    private void getBuscarPlanoDeNegocio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../paginaBuscaPlanoDeNegocio.jsf");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * <p>
     * Redireciona para a página da fase de Avaliação.
     * </p>
     */
    public void redirecionaPaginaAvaliacao() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("avaliacaoPlanoDeNegocio.jsf");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    

    /**
     * <p>
     * Exibe o campo de texto para inserir conteúdo referente a opção OUTRO no
     * estado do negócio.</p>
     *
     * @return <code>true</code> se o usuário clicar no checkbox "Outro".
     */
    public boolean exibeCampoOutro() {
        return estagioEvolucao != null && estagioEvolucao.equals("Outro");
    }

//==============================================================================

    /**
     * *
     * Método para ação após linha ser editada, atualizando valores na tabela.
     *
     * @param event
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg;
        Custo custo = (Custo) event.getObject();

        msg = new FacesMessage("Custo Editado", custo.getDescricao());
        FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:mensagensFeed", msg);

//        calcularValorColunaCustoVariavel();
//        calcularValorColunaCustoFixo();

        ProjetoDao projetoDao = new ProjetoDao();
        projetoDao.salvar(custo);

    }


    /**
     * Método que cancela edição da linha na tabela.
     *
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {

        FacesMessage msg = new FacesMessage("Edição Cancelada", ((Custo) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Deleta registro na tabela.
     *
     * @param custo
     */
    public void deletarLinha(Custo custo) {
        FacesMessage msg;
        if (custo.getTipo() == Custo.CUSTO_FIXO) {
//            deletarCustoFixo(custo);
//            calcularValorColunaCustoFixo();
            msg = new FacesMessage("Custo fixo DELETADO");
            FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:mensagensFeed", msg);
        }
        if (custo.getTipo() == Custo.CUSTO_VARIAVEL) {
//            deletarCustoVariavel(custo);
//            calcularValorColunaCustoVariavel();
            msg = new FacesMessage("Custo variavel DELETADO");
            FacesContext.getCurrentInstance().addMessage("formulario_resubmeterplano:mensagensFeed", msg);
        }
        projeto.SalvarProjeto(projeto);

    }
    
    /**
     * Método para adicionar custo fixo ao projeto e à tabela.
     */
    public void adicionarLinhaFixo() {
        Custo custo = new Custo();
        int zero = 0;
        custo.setDescricao("Novo Custo");
        custo.setTipo(Custo.CUSTO_FIXO);
        custo.setTotal(zero);
        custo.setProjecao(zero);
        custo.setPodeExcluir(true);
        projeto.getPlanofinanceiro().getCusto().add(custo);
        custo.setPlanofinanceiro(projeto.getPlanofinanceiro());
//        salvarProjeto();
//        preencheListaCusto();
    }


    /**
     * Metodo que soma os valores de cada custo fixo adicionados na tabela e faz
     * a projeção para seis meses.
     *
     * @return somatorioFixo
     */
    public int calcularValorColunaCustoFixo() {
//        somatorioFixo = 0;
//        for (int i = 0; i < listaCustoFixo.size(); i++) {
//            somatorioFixo = somatorioFixo + listaCustoFixo.get(i).getTotal();
//        }
//        somatorioFixo = somatorioFixo * 6;
//        projeto.getPlanofinanceiro().setValorTotalFixo(somatorioFixo);
//        setSomatorioVariavel(somatorioFixo);
        return 50000;
    }
    
//==============================================================================    
    
    
    
    /**
     * @return the projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * @param projeto the projeto to set
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    /**
     * @return the comentarioProjeto
     */
    public ComentarioProjeto getComentarioProjeto() {
        return comentarioProjeto;
    }

    /**
     * @param comentarioProjeto the comentarioProjeto to set
     */
    public void setComentarioProjeto(ComentarioProjeto comentarioProjeto) {
        this.comentarioProjeto = comentarioProjeto;
    }

    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getEstagioEvolucao() {
        return estagioEvolucao;
    }

    public void setEstagioEvolucao(String estagioEvolucao) {
        this.estagioEvolucao = estagioEvolucao;
    }

    public String getEstagioEvolucaoOutro() {
        return estagioEvolucaoOutro;
    }

    public void setEstagioEvolucaoOutro(String estagioEvolucaoOutro) {
        this.estagioEvolucaoOutro = estagioEvolucaoOutro;
    }
}

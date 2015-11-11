package com.ideiah.gerenciadorpampatec.model;
// Generated 31/08/2015 13:49:28 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class Planofinanceiro implements java.io.Serializable {

    private int idPlanoFinanceiro;
    private String fontesReceita;
    private String estruturaCusto;
    private String investimentoInicial;
    private Set projetos = new HashSet(0);
    private Set<Custo> custo = new HashSet<>(0);
    private String totalMes1;
    private String totalMes2;
    private String totalMes3;
    private String totalMes4;
    private String totalMes5;
    private String totalMes6;
    private String valorTotal;

    public Planofinanceiro() {
    }

    public Planofinanceiro(int idPlanoFinanceiro, String fontesReceita, String estruturaCusto) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
        this.fontesReceita = fontesReceita;
        this.estruturaCusto = estruturaCusto;
    }

    public Planofinanceiro(int idPlanoFinanceiro, String fontesReceita, String estruturaCusto, String investimentoInicial) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
        this.fontesReceita = fontesReceita;
        this.estruturaCusto = estruturaCusto;
        this.investimentoInicial = investimentoInicial;
    }

    public int getIdPlanoFinanceiro() {
        return this.idPlanoFinanceiro;
    }

    public void setIdPlanoFinanceiro(int idPlanoFinanceiro) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
    }

    public String getFontesReceita() {
        return this.fontesReceita;
    }

    public void setFontesReceita(String fontesReceita) {
        this.fontesReceita = fontesReceita;
    }

    public String getEstruturaCusto() {
        return this.estruturaCusto;
    }

    public void setEstruturaCusto(String estruturaCusto) {
        this.estruturaCusto = estruturaCusto;
    }

    public String getInvestimentoInicial() {
        return this.investimentoInicial;
    }

    public void setInvestimentoInicial(String investimentoInicial) {
        this.investimentoInicial = investimentoInicial;
    }

    public Set getProjetos() {
        return this.projetos;
    }

    public void setProjetos(Set projetos) {
        this.projetos = projetos;
    }

    /**
     * @return the totalMes1
     */
    public String getTotalMes1() {
        return totalMes1;
    }

    /**
     * @param totalMes1 the totalMes1 to set
     */
    public void setTotalMes1(String totalMes1) {
        this.totalMes1 = totalMes1;
    }

    /**
     * @return the totalMes2
     */
    public String getTotalMes2() {
        return totalMes2;
    }

    /**
     * @param totalMes2 the totalMes2 to set
     */
    public void setTotalMes2(String totalMes2) {
        this.totalMes2 = totalMes2;
    }

    /**
     * @return the totalMes3
     */
    public String getTotalMes3() {
        return totalMes3;
    }

    /**
     * @param totalMes3 the totalMes3 to set
     */
    public void setTotalMes3(String totalMes3) {
        this.totalMes3 = totalMes3;
    }

    /**
     * @return the totalMes4
     */
    public String getTotalMes4() {
        return totalMes4;
    }

    /**
     * @param totalMes4 the totalMes4 to set
     */
    public void setTotalMes4(String totalMes4) {
        this.totalMes4 = totalMes4;
    }

    /**
     * @return the totalMes5
     */
    public String getTotalMes5() {
        return totalMes5;
    }

    /**
     * @param totalMes5 the totalMes5 to set
     */
    public void setTotalMes5(String totalMes5) {
        this.totalMes5 = totalMes5;
    }

    /**
     * @return the totalMes6
     */
    public String getTotalMes6() {
        return totalMes6;
    }

    /**
     * @param totalMes6 the totalMes6 to set
     */
    public void setTotalMes6(String totalMes6) {
        this.totalMes6 = totalMes6;
    }

    /**
     * @return the valorTotal
     */
    public String getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the custo
     */
    public Set<Custo> getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(Set<Custo> custo) {
        this.custo = custo;
    }

   

}

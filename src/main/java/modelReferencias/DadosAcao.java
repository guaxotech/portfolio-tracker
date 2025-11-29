/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelReferencias;

/**
 *
 * @author vinic
 */
public class DadosAcao {
    private String ticker;
    private String empresa; // casa com "empresa" no JSON
    private String precoAtual;
    private String fechamentoAnterior;
    private double variacaoPercentual;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(String precoAtual) {
        this.precoAtual = precoAtual;
    }

    public String getFechamentoAnterior() {
        return fechamentoAnterior;
    }

    public void setFechamentoAnterior(String fechamentoAnterior) {
        this.fechamentoAnterior = fechamentoAnterior;
    }

    public double getVariacaoPercentual() {
        return variacaoPercentual;
    }

    public void setVariacaoPercentual(double variacaoPercentual) {
        this.variacaoPercentual = variacaoPercentual;
    }
    
    
    
}

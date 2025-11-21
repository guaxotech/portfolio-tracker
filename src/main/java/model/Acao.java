/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 *
 * @author vinic
 * Subclasse de Ativo. Ativo de Renda Váriavel
 */

@Entity
@DiscriminatorValue("ACAO")

public class Acao extends Ativo {
    private String setor;
    private double dividendYield;
    
    public Acao(){
        super();
    }
    
    public Acao(String ticker, String nome, double valorAtual, String setor, double dividendYield)
    {
        super(ticker, nome, valorAtual);
        this.setor = setor;
        this.dividendYield = dividendYield;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(double dividendYield) {
        this.dividendYield = dividendYield;
    }
    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
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
    
    @Column(name = "setor")
    private String setor;
    
    @Column(name = "nome_empresa")
    private String nomeEmpresa;
      
    public Acao(){
        super();
    }
    
    public Acao(String ticker, String descricao, int quantidade, double valorCompra, String setor)
    {
        super(ticker, descricao, quantidade, valorCompra);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    
    
    
    
    
    
    
}

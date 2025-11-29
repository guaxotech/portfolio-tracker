/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author vinic
 * 
 * Abstrata, define o conceito de tudo que possa ser negociado
 */

@Entity
@Table(name = "ativos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Assim, tem-se somente uma tabela que armazena acao e fii
@DiscriminatorColumn(name = "TIPO_ATIVO")
public abstract class Ativo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ticker")
    protected String ticker;
    
    @Column(name = "descricao")
    protected String descricao;
    
    @Column(name = "valor_compra")
    protected double valorCompra;
    
    @Column(name = "valor_atual")
    protected double valorAtual;
    
    @Column(name = "quantidade")
    protected int quantidade;
    
    @Column(name = "data_compra")
    private LocalDateTime dataCompra;
    
    
    public Ativo(){
        
    }
    
    public Ativo(String ticker, String descricao, int quantidade, double valorCompra) {
        this.ticker = ticker;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
        this.valorAtual = valorCompra;
        this.dataCompra = LocalDateTime.now();
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    
    
    
    
    
}

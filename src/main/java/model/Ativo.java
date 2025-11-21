/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author vinic
 * 
 * Abstrata, define o conceito de tudo que possa ser negociado
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Assim, tem-se somente uma tabela que armazena acao e fii
@DiscriminatorColumn(name = "TIPO_ATIVO")
public abstract class Ativo {
    
    @Id
    protected String ticker;
    
    protected String nome;
    protected double valorAtual;
    private LocalDateTime dataUltimaCotacao;
    
    @OneToMany(mappedBy = "ativo")
    private List<Posicao> posicoes;
    
    public Ativo(){
        
    }
    
    public Ativo(String ticker, String nome, double valorAtual) {
        this.ticker = ticker;
        this.nome = nome;
        this.valorAtual = valorAtual;
    }
    
    
    
}

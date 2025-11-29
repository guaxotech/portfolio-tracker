/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author vinic
 */

@Entity
@Table(name = "transacoes")

public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransacao;
    
    private LocalDateTime data;
    
    public enum tipoTransacao {
        COMPRA,
        VENDA
    }
    
    private tipoTransacao tipo;
    
    private int quantiodade;
    private double precoUnitario;
   
    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo; // N:1
    
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private ContaInvestimento conta; // N:1
    

    public Transacao(){
        
    }
    
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public tipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(tipoTransacao tipo) {
        this.tipo = tipo;
    }

    public int getQuantiodade() {
        return quantiodade;
    }

    public void setQuantiodade(int quantiodade) {
        this.quantiodade = quantiodade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinic
 * 
 * Guarda o Saldo de Capital e se relaciona com as posições
 */
@Entity
@Table(name = "contas")

public class ContaInvestimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int idConta;
    
    
    @Column(name = "saldo_disponivel")
    private double saldoDisponivel;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente; // N:1
    
    @OneToMany(mappedBy = "conta")
    private List<Posicao> posicoes; // 1:N
    
    public ContaInvestimento() {
        this.posicoes = new ArrayList<>();
    }
    
}

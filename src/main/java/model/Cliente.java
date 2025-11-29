/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author vinic
 * 
 * Essa classe representa o Investidor.
 */

@Entity // Marcar a classe como uma entidade persistente (Tabela no BD)
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String cpf;
    private String email;
    
    
    
    @OneToMany(mappedBy = "cliente")
    private List<ContaInvestimento> conta; // 1:N
    
    public Cliente() {
        
    }
    public Cliente(String nome)
    {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ContaInvestimento> getConta() {
        return conta;
    }

    public void setConta(List<ContaInvestimento> conta) {
        this.conta = conta;
    }
    
    
    public boolean validarCPF(String cpf)
    {
        
        
        return false;
    }
    
    
}

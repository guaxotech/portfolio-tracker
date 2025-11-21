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
@Table(name = "posicao")
public class Posicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPosicao;
    
    private int quantidadeAtual;
    private double precoMedioCompra;
    private double lucroPrejuizo;
    
    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo; // 1:1
       
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private ContaInvestimento conta; // N:1
    
}

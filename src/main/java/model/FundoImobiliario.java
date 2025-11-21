/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

/**
 *
 * @author vinic  // Ativo de Renda Variável (FII)
 */
@Entity
@DiscriminatorValue("FII")

public class FundoImobiliario extends Ativo{
     public enum tipoFundo{
         PAPEL,
         TIJOLO
     }
     
     private tipoFundo tipo;
     private LocalDateTime dataPagamentoRendimento;

    public FundoImobiliario(){
        
    }     
    
    public FundoImobiliario(String ticker, String nome, Double valorAtual, tipoFundo tipo, LocalDateTime dataPagamentoRendimento)
    {
        super(ticker, nome, valorAtual);
    }
     
}

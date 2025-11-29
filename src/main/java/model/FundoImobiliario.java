/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Column;
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
     
     @Column(name = "tipo_fundo")
     private tipoFundo tipo;
     
     @Column(name = "fundo")
     protected String fundo;
     
     
     //private LocalDateTime dataPagamentoRendimento;

    public FundoImobiliario(){
        
    }     
    
    public FundoImobiliario(String ticker, String descricao, int quantidade, Double valorCompra, tipoFundo tipo)
    {
        super(ticker, descricao, quantidade, valorCompra);
        this.tipo = tipo;
    }

    public tipoFundo getTipo() {
        return tipo;
    }

    public void setTipo(tipoFundo tipo) {
        this.tipo = tipo;
    }

    public String getFundo() {
        return fundo;
    }

    public void setFundo(String fundo) {
        this.fundo = fundo;
    }
     
}

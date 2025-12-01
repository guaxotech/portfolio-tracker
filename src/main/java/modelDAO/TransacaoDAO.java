/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import model.Transacao;

/**
 *
 * @author vinic
 */
public class TransacaoDAO extends PersistenciaJPA{
    public List<Transacao> listaTransacoes(){
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Transacao> query = em.createQuery("SELECT t FROM Transacao t", Transacao.class);
            return query.getResultList();
        }
        catch(Exception e)
        {
               e.printStackTrace();
               return null;
        }
    }
    
    public Long ultimasTransacoesRealizadasPorPeriodo(int dias){
        EntityManager em = getEntityManager();
        try {
            
            LocalDate limite = LocalDate.now().minusDays(dias); // LocalDate com a data limite (Ex: A data de hoje - 30 dias)
            LocalDateTime limiteDateTime = limite.atStartOfDay();
            
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(t) FROM Transacao t WHERE t.data >= :limite", Long.class);
            query.setParameter("limite", limiteDateTime);
            
            return query.getSingleResult();
        
        }catch(Exception e){
               e.printStackTrace();
               return null;
        }
    }
    public Long quantidadeAtivosMovimentadosPorPeriodo(int dias){
        EntityManager em = getEntityManager();
        try{
            LocalDate limite = LocalDate.now().minusDays(dias);
            LocalDateTime limiteDateTime = limite.atStartOfDay();
            
            TypedQuery<Long> query = em.createQuery("SELECT SUM(t.quantidade) FROM Transacao t WHERE t.data >= :limite", Long.class);
            query.setParameter("limite", limiteDateTime);
            
            return query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
            TypedQuery<Transacao> query = em.createQuery("SELECT t FROM transacoes t", Transacao.class);
            return query.getResultList();
        }
        catch(Exception e)
        {
               e.printStackTrace();
               return null;
        }
    }
    
}

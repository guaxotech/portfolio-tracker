/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.Optional;
import model.Cliente;

/**
 *
 * @author vinic
 */
public class ClienteDAO extends PersistenciaJPA{
    
    public Optional<Cliente> buscarCliente() {
        EntityManager em = getEntityManager();
        
        try{
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);    
            query.setMaxResults(1);
            
            return query.getResultList().stream().findFirst();
        }
        catch(NoResultException e)
        {
            return Optional.empty();
        }
        finally{
            em.close();
        }
    }
    /*
    public Optional<Cliente> buscarCliente(int idCliente) {
        EntityManager em = getEntityManager();
        
        try{
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM clientes WHERE c.cliente_id = :cliente_id", Cliente.class);
            query.setParameter("cliente_id", idCliente);
            
            return query.getResultList().stream().findFirst();
        }
        catch(NoResultException e)
        {
            return Optional.empty();
        }
        finally{
            em.close();
        }
    }
    */
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import model.Ativo;

/**
 *
 * @author vinic
 */
public class AtivoDAO extends PersistenciaJPA {
    public List<Ativo> listaAtivos(){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<Ativo> query = em.createQuery("Select a FROM ativos a", Ativo.class);
            return query.getResultList();
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
}

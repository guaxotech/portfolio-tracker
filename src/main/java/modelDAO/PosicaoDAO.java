/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import model.Posicao;

/**
 *
 * @author vinic
 */
public class PosicaoDAO extends PersistenciaJPA{
    public List<Posicao> listaPosicoes()
    {
        EntityManager em = getEntityManager();
        try
        {
            TypedQuery<Posicao> query = em.createQuery("SELECT p FROM posicoes p", Posicao.class);
            return query.getResultList();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import model.ContaInvestimento;

/**
 *
 * @author vinic
 */
public class ContaInvestimentoDAO extends PersistenciaJPA {

    public Optional<ContaInvestimento> buscarConta(int idConta) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<ContaInvestimento> query = em.createQuery("SELECT c FROM contas WHERE c.conta_id = conta_id", ContaInvestimento.class);
            query.setParameter("conta_id", idConta);
            return query.getResultList().stream().findFirst();
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import model.Ativo;
import model.ContaInvestimento;

/**
 *
 * @author vinic
 */
public class AtivoDAO extends PersistenciaJPA {
    public List<Ativo> listaAtivos(){
        EntityManager em = getEntityManager();
        em.clear();
        try{
            TypedQuery<Ativo> query = em.createQuery("Select a FROM Ativo a WHERE a.ativoNaCarteira = true", Ativo.class);
            return query.getResultList();
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    public double calcularPatrimonioTotal(){
        EntityManager em = getEntityManager();
           
        try {
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.valorAtual * a.quantidade) FROM Ativo a WHERE a.ativoNaCarteira = true", Double.class);
            
            Double resultado = query.getSingleResult();
            
            return (resultado != null) ? resultado : 0.0;
        }
        finally {
            if (em != null)
            {
                em.close();
            }
        }
    }
    public double calcularPatrimonioAcoes(){
        EntityManager em = getEntityManager();
        
        try {
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.valorAtual * a.quantidade) FROM Ativo a WHERE TYPE(a) = 'ACAO' AND a.ativoNaCarteira = true", Double.class);
        
            Double resultado = query.getSingleResult();
            
            return (resultado != null) ? resultado : 0.0;
        }
        finally {
            if(em != null)
            {
                em.close();
            }
        }
    }
    public double calcularPatrimonioFiis(){
        EntityManager em = getEntityManager();
        
        try{
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.valorAtual * a.quantidade) FROM Ativo a WHERE TYPE(a) = 'FII' AND a.ativoNaCarteira = true", Double.class);
            
            Double resultado = query.getSingleResult();
            
            return (resultado != null) ? resultado : 0.0;
        }
        finally {
            if(em != null)
            {
                em.close();
            }
        }
    }
    public Boolean buscarAtivoJaCadastrado(String ticker) { ///
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Ativo> query = em.createQuery(
                    "SELECT a FROM Ativo a WHERE a.ticker = :ticker AND a.ativoNaCarteira = true", Ativo.class
            );
            query.setParameter("ticker", ticker);

            query.setMaxResults(1);
            
            Boolean ativoExiste = !query.getResultList().isEmpty(); // verificar se a o resultado retornado na query n está vazio

            return ativoExiste;

        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean verificarAtivoDesincorporado(String ticker) { ///
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Ativo> query = em.createQuery(
                    "SELECT a FROM Ativo a WHERE a.ticker = :ticker AND a.ativoNaCarteira = false", Ativo.class
            );
            query.setParameter("ticker", ticker);

            query.setMaxResults(1);
            
            Boolean ativoExiste = !query.getResultList().isEmpty(); // verificar se a o resultado retornado na query n está vazio

            return ativoExiste;

        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public List<Ativo> listaAtivosPorTipo(Class<? extends Ativo> tipoClasse) {
    EntityManager em = getEntityManager(); 
    em.clear(); // limpar o em para que a tabela seja att fielmente
    try {
        TypedQuery<Ativo> query = em.createQuery(
            "SELECT a FROM Ativo a WHERE TYPE(a) = :tipo AND a.ativoNaCarteira = true", Ativo.class);
        query.setParameter("tipo", tipoClasse);
        return query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        return Collections.emptyList(); // melhor que retornar null
    }
}
    public Ativo buscarAtivo(String ticker) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Ativo> query = em.createQuery(
                    "SELECT a FROM Ativo a WHERE a.ticker = :ticker AND a.ativoNaCarteira = true", Ativo.class
            );
            query.setParameter("ticker", ticker);

            query.setMaxResults(1);
            
            return query.getSingleResult();

        } catch (NoResultException e) {
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public Ativo buscarAtivoDesincorporado(String ticker) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Ativo> query = em.createQuery(
                    "SELECT a FROM Ativo a WHERE a.ticker = :ticker AND a.ativoNaCarteira = false", Ativo.class
            );
            query.setParameter("ticker", ticker);

            query.setMaxResults(1);
            
            return query.getSingleResult();

        } catch (NoResultException e) {
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public Long quantidadeTotalAtivos() {
        EntityManager em = getEntityManager();
        
        try{
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(a) FROM Ativo a WHERE a.ativoNaCarteira = true", Long.class );
            
            Long resultado = query.getSingleResult();
            return (resultado != null) ? resultado : 0L;
        }catch(Exception e){
            e.printStackTrace();
            return 0L;
        }
    }
    public Long quantidadeTotalCotas() {
        EntityManager em = getEntityManager();
        
        try{
            TypedQuery<Long> query = em.createQuery("SELECT SUM(a.quantidade) FROM Ativo a WHERE a.ativoNaCarteira = true", Long.class );
            
            Long resultado = query.getSingleResult();
            return (resultado != null) ? resultado : 0L;
        }catch(Exception e){
            e.printStackTrace();
            return 0L;
        }
    }
    public Long quantidadeTotalCotasPorTipo(Class<? extends Ativo> tipoClasse) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<Long> query = em.createQuery(
            "SELECT SUM(a.quantidade) FROM Ativo a WHERE TYPE(a) = :tipo AND a.ativoNaCarteira = true", Long.class);
        query.setParameter("tipo", tipoClasse);
        Long resultado = query.getSingleResult();
        return resultado != null ? resultado : 0L;
    } catch (Exception e) {
        e.printStackTrace();
        return 0L; // nunca retorne null, sempre um valor válido
    }
    
}
    
    public void desincorporar(Ativo ativo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ativo.setAtivoNaCarteira(false); // marca como desincorporado
            em.merge(ativo);                 // atualiza no banco
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
}
    public void reencorporar(Ativo ativo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            ativo.setAtivoNaCarteira(true); // marca como desincorporado
            em.merge(ativo);                 // atualiza no banco
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
}
    
}
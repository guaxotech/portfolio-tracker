/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
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
        try{
            TypedQuery<Ativo> query = em.createQuery("Select a FROM ativos a", Ativo.class);
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
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.valorAtual * a.quantidade) FROM Ativo a ", Double.class);
            
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
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.valorAtual * a.quantidade) FROM Ativo a WHERE TYPE(a) = 'ACAO'", Double.class);
        
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
            TypedQuery<Double> query = em.createQuery("SELECT SUM(a.valorAtual * a.quantidade) FROM Ativo a WHERE TYPE(a) = 'FII'", Double.class);
            
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
    public Boolean buscarAtivoJaCadastrado(String ticker) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Ativo> query = em.createQuery(
                    "SELECT a FROM Ativo a WHERE a.ticker = :ticker", Ativo.class
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
    public List<Ativo> listaAcoes(){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<Ativo> query = em.createQuery("SELECT a FROM Ativo a WHERE TYPE(a) = 'ACAO'", Ativo.class);
            return query.getResultList();
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Ativo> listaFiis(){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<Ativo> query = em.createQuery("SELECT a FROM Ativo a WHERE TYPE(a) = 'FII'", Ativo.class);
            return query.getResultList();
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Ativo buscarAtivo(String ticker) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Ativo> query = em.createQuery(
                    "SELECT a FROM Ativo a WHERE a.ticker = :ticker", Ativo.class
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
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(a) FROM Ativo a", Long.class );
            
            return query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Long quantidadeTotalCotas() {
        EntityManager em = getEntityManager();
        
        try{
            TypedQuery<Long> query = em.createQuery("SELECT SUM(a.quantidade) FROM Ativo a", Long.class );
            
            return query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Cuerpo;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author JavW11trial
 */
public class CuerpoJpaController implements Serializable {

    public CuerpoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    CuerpoJpaController() {
        emf = Persistence.createEntityManagerFactory("MostruosPU");
    }
private EntityManagerFactory emf = null;
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cuerpo cuerpo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cuerpo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cuerpo cuerpo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cuerpo = em.merge(cuerpo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cuerpo.getIdCuerpo();
                if (findCuerpo(id) == null) {
                    throw new NonexistentEntityException("The cuerpo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cuerpo cuerpo;
            try {
                cuerpo = em.getReference(Cuerpo.class, id);
                cuerpo.getIdCuerpo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cuerpo with id " + id + " no longer exists.", enfe);
            }
            em.remove(cuerpo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cuerpo> findCuerpoEntities() {
        return findCuerpoEntities(true, -1, -1);
    }

    public List<Cuerpo> findCuerpoEntities(int maxResults, int firstResult) {
        return findCuerpoEntities(false, maxResults, firstResult);
    }

    private List<Cuerpo> findCuerpoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cuerpo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cuerpo findCuerpo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cuerpo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCuerpoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cuerpo> rt = cq.from(Cuerpo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

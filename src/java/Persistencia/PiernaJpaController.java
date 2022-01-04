/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Pierna;
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
public class PiernaJpaController implements Serializable {

    public PiernaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    PiernaJpaController() {
        emf = Persistence.createEntityManagerFactory("MostruosPU");
    }
private EntityManagerFactory emf = null;
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pierna pierna) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pierna);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pierna pierna) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pierna = em.merge(pierna);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pierna.getIdPierna();
                if (findPierna(id) == null) {
                    throw new NonexistentEntityException("The pierna with id " + id + " no longer exists.");
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
            Pierna pierna;
            try {
                pierna = em.getReference(Pierna.class, id);
                pierna.getIdPierna();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pierna with id " + id + " no longer exists.", enfe);
            }
            em.remove(pierna);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pierna> findPiernaEntities() {
        return findPiernaEntities(true, -1, -1);
    }

    public List<Pierna> findPiernaEntities(int maxResults, int firstResult) {
        return findPiernaEntities(false, maxResults, firstResult);
    }

    private List<Pierna> findPiernaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pierna.class));
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

    public Pierna findPierna(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pierna.class, id);
        } finally {
            em.close();
        }
    }

    public int getPiernaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pierna> rt = cq.from(Pierna.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

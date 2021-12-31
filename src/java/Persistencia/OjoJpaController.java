/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Ojo;
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
public class OjoJpaController implements Serializable {

    public OjoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    OjoJpaController() {
        emf = Persistence.createEntityManagerFactory("MostruosPU");
    }
private EntityManagerFactory emf = null;
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ojo ojo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ojo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ojo ojo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ojo = em.merge(ojo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ojo.getId_ojo();
                if (findOjo(id) == null) {
                    throw new NonexistentEntityException("The ojo with id " + id + " no longer exists.");
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
            Ojo ojo;
            try {
                ojo = em.getReference(Ojo.class, id);
                ojo.getId_ojo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ojo with id " + id + " no longer exists.", enfe);
            }
            em.remove(ojo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ojo> findOjoEntities() {
        return findOjoEntities(true, -1, -1);
    }

    public List<Ojo> findOjoEntities(int maxResults, int firstResult) {
        return findOjoEntities(false, maxResults, firstResult);
    }

    private List<Ojo> findOjoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ojo.class));
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

    public Ojo findOjo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ojo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOjoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ojo> rt = cq.from(Ojo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

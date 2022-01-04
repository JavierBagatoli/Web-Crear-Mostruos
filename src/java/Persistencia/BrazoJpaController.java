/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Brazo;
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
public class BrazoJpaController implements Serializable {

    public BrazoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    BrazoJpaController() {
        emf = Persistence.createEntityManagerFactory("MostruosPU");
    }
    private EntityManagerFactory emf = null;
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Brazo brazo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(brazo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Brazo brazo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            brazo = em.merge(brazo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = brazo.getIdBrazo();
                if (findBrazo(id) == null) {
                    throw new NonexistentEntityException("The brazo with id " + id + " no longer exists.");
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
            Brazo brazo;
            try {
                brazo = em.getReference(Brazo.class, id);
                brazo.getIdBrazo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The brazo with id " + id + " no longer exists.", enfe);
            }
            em.remove(brazo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Brazo> findBrazoEntities() {
        return findBrazoEntities(true, -1, -1);
    }

    public List<Brazo> findBrazoEntities(int maxResults, int firstResult) {
        return findBrazoEntities(false, maxResults, firstResult);
    }

    private List<Brazo> findBrazoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Brazo.class));
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

    public Brazo findBrazo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Brazo.class, id);
        } finally {
            em.close();
        }
    }

    public int getBrazoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Brazo> rt = cq.from(Brazo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

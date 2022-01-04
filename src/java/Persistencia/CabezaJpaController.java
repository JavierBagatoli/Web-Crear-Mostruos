/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Cabeza;
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
public class CabezaJpaController implements Serializable {

    public CabezaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    CabezaJpaController() {
        emf = Persistence.createEntityManagerFactory("MostruosPU");
    }

    private EntityManagerFactory emf = null;
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cabeza cabeza) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cabeza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cabeza cabeza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cabeza = em.merge(cabeza);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cabeza.getIdCabeza();
                if (findCabeza(id) == null) {
                    throw new NonexistentEntityException("The cabeza with id " + id + " no longer exists.");
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
            Cabeza cabeza;
            try {
                cabeza = em.getReference(Cabeza.class, id);
                cabeza.getIdCabeza();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cabeza with id " + id + " no longer exists.", enfe);
            }
            em.remove(cabeza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cabeza> findCabezaEntities() {
        return findCabezaEntities(true, -1, -1);
    }

    public List<Cabeza> findCabezaEntities(int maxResults, int firstResult) {
        return findCabezaEntities(false, maxResults, firstResult);
    }

    private List<Cabeza> findCabezaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cabeza.class));
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

    public Cabeza findCabeza(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cabeza.class, id);
        } finally {
            em.close();
        }
    }

    public int getCabezaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cabeza> rt = cq.from(Cabeza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

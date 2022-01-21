/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Visibilidad;
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
public class VisibilidadJpaController implements Serializable {

    public VisibilidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    VisibilidadJpaController() {
        emf = Persistence.createEntityManagerFactory("MostruosPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Visibilidad visibilidad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(visibilidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Visibilidad visibilidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            visibilidad = em.merge(visibilidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = visibilidad.getIdVisibilidad();
                if (findVisibilidad(id) == null) {
                    throw new NonexistentEntityException("The visibilidad with id " + id + " no longer exists.");
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
            Visibilidad visibilidad;
            try {
                visibilidad = em.getReference(Visibilidad.class, id);
                visibilidad.getIdVisibilidad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The visibilidad with id " + id + " no longer exists.", enfe);
            }
            em.remove(visibilidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Visibilidad> findVisibilidadEntities() {
        return findVisibilidadEntities(true, -1, -1);
    }

    public List<Visibilidad> findVisibilidadEntities(int maxResults, int firstResult) {
        return findVisibilidadEntities(false, maxResults, firstResult);
    }

    private List<Visibilidad> findVisibilidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Visibilidad.class));
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

    public Visibilidad findVisibilidad(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Visibilidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getVisibilidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Visibilidad> rt = cq.from(Visibilidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

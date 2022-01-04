/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Visibilidad;
import Logica.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
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

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Visibilidad visibilidad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Visibilidad visibilidadRel = visibilidad.getVisibilidad();
            if (visibilidadRel != null) {
                visibilidadRel = em.getReference(visibilidadRel.getClass(), visibilidadRel.getIdVisibilidad());
                visibilidad.setVisibilidad(visibilidadRel);
            }
            em.persist(visibilidad);
            if (visibilidadRel != null) {
                Visibilidad oldVisibilidadOfVisibilidadRel = visibilidadRel.getVisibilidad();
                if (oldVisibilidadOfVisibilidadRel != null) {
                    oldVisibilidadOfVisibilidadRel.setVisibilidad(null);
                    oldVisibilidadOfVisibilidadRel = em.merge(oldVisibilidadOfVisibilidadRel);
                }
                visibilidadRel.setVisibilidad(visibilidad);
                visibilidadRel = em.merge(visibilidadRel);
            }
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
            Visibilidad persistentVisibilidad = em.find(Visibilidad.class, visibilidad.getIdVisibilidad());
            Visibilidad visibilidadRelOld = persistentVisibilidad.getVisibilidad();
            Visibilidad visibilidadRelNew = visibilidad.getVisibilidad();
            if (visibilidadRelNew != null) {
                visibilidadRelNew = em.getReference(visibilidadRelNew.getClass(), visibilidadRelNew.getIdVisibilidad());
                visibilidad.setVisibilidad(visibilidadRelNew);
            }
            visibilidad = em.merge(visibilidad);
            if (visibilidadRelOld != null && !visibilidadRelOld.equals(visibilidadRelNew)) {
                visibilidadRelOld.setVisibilidad(null);
                visibilidadRelOld = em.merge(visibilidadRelOld);
            }
            if (visibilidadRelNew != null && !visibilidadRelNew.equals(visibilidadRelOld)) {
                Visibilidad oldVisibilidadOfVisibilidadRel = visibilidadRelNew.getVisibilidad();
                if (oldVisibilidadOfVisibilidadRel != null) {
                    oldVisibilidadOfVisibilidadRel.setVisibilidad(null);
                    oldVisibilidadOfVisibilidadRel = em.merge(oldVisibilidadOfVisibilidadRel);
                }
                visibilidadRelNew.setVisibilidad(visibilidad);
                visibilidadRelNew = em.merge(visibilidadRelNew);
            }
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
            Visibilidad visibilidadRel = visibilidad.getVisibilidad();
            if (visibilidadRel != null) {
                visibilidadRel.setVisibilidad(null);
                visibilidadRel = em.merge(visibilidadRel);
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

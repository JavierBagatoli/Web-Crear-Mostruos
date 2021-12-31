/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Criatura;
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
public class CriaturaJpaController implements Serializable {

    public CriaturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    CriaturaJpaController() {
        emf = Persistence.createEntityManagerFactory("MostruosPU");
    }
    private EntityManagerFactory emf = null;
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Criatura criatura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(criatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Criatura criatura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            criatura = em.merge(criatura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = criatura.getId_Criatura();
                if (findCriatura(id) == null) {
                    throw new NonexistentEntityException("The criatura with id " + id + " no longer exists.");
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
            Criatura criatura;
            try {
                criatura = em.getReference(Criatura.class, id);
                criatura.getId_Criatura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The criatura with id " + id + " no longer exists.", enfe);
            }
            em.remove(criatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Criatura> findCriaturaEntities() {
        return findCriaturaEntities(true, -1, -1);
    }

    public List<Criatura> findCriaturaEntities(int maxResults, int firstResult) {
        return findCriaturaEntities(false, maxResults, firstResult);
    }

    private List<Criatura> findCriaturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Criatura.class));
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

    public Criatura findCriatura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Criatura.class, id);
        } finally {
            em.close();
        }
    }

    public int getCriaturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Criatura> rt = cq.from(Criatura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

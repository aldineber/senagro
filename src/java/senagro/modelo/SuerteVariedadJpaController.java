/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senagro.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import senagro.entidade.SuerteVariedad;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class SuerteVariedadJpaController implements Serializable {

    public SuerteVariedadJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SuerteVariedad suerteVariedad) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(suerteVariedad);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findSuerteVariedad(suerteVariedad.getIdsuertevariedadcol()) != null) {
                throw new PreexistingEntityException("SuerteVariedad " + suerteVariedad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SuerteVariedad suerteVariedad) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            suerteVariedad = em.merge(suerteVariedad);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = suerteVariedad.getIdsuertevariedadcol();
                if (findSuerteVariedad(id) == null) {
                    throw new NonexistentEntityException("The suerteVariedad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            SuerteVariedad suerteVariedad;
            try {
                suerteVariedad = em.getReference(SuerteVariedad.class, id);
                suerteVariedad.getIdsuertevariedadcol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The suerteVariedad with id " + id + " no longer exists.", enfe);
            }
            em.remove(suerteVariedad);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SuerteVariedad> findSuerteVariedadEntities() {
        return findSuerteVariedadEntities(true, -1, -1);
    }

    public List<SuerteVariedad> findSuerteVariedadEntities(int maxResults, int firstResult) {
        return findSuerteVariedadEntities(false, maxResults, firstResult);
    }

    private List<SuerteVariedad> findSuerteVariedadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SuerteVariedad.class));
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

    public SuerteVariedad findSuerteVariedad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SuerteVariedad.class, id);
        } finally {
            em.close();
        }
    }

    public int getSuerteVariedadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SuerteVariedad> rt = cq.from(SuerteVariedad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

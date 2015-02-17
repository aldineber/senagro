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
import senagro.entidade.SuerteUsoDeLaSuerte;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class SuerteUsoDeLaSuerteJpaController implements Serializable {

    public SuerteUsoDeLaSuerteJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SuerteUsoDeLaSuerte suerteUsoDeLaSuerte) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(suerteUsoDeLaSuerte);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findSuerteUsoDeLaSuerte(suerteUsoDeLaSuerte.getSuerteUsoDeLaSuertecol()) != null) {
                throw new PreexistingEntityException("SuerteUsoDeLaSuerte " + suerteUsoDeLaSuerte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SuerteUsoDeLaSuerte suerteUsoDeLaSuerte) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            suerteUsoDeLaSuerte = em.merge(suerteUsoDeLaSuerte);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = suerteUsoDeLaSuerte.getSuerteUsoDeLaSuertecol();
                if (findSuerteUsoDeLaSuerte(id) == null) {
                    throw new NonexistentEntityException("The suerteUsoDeLaSuerte with id " + id + " no longer exists.");
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
            SuerteUsoDeLaSuerte suerteUsoDeLaSuerte;
            try {
                suerteUsoDeLaSuerte = em.getReference(SuerteUsoDeLaSuerte.class, id);
                suerteUsoDeLaSuerte.getSuerteUsoDeLaSuertecol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The suerteUsoDeLaSuerte with id " + id + " no longer exists.", enfe);
            }
            em.remove(suerteUsoDeLaSuerte);
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

    public List<SuerteUsoDeLaSuerte> findSuerteUsoDeLaSuerteEntities() {
        return findSuerteUsoDeLaSuerteEntities(true, -1, -1);
    }

    public List<SuerteUsoDeLaSuerte> findSuerteUsoDeLaSuerteEntities(int maxResults, int firstResult) {
        return findSuerteUsoDeLaSuerteEntities(false, maxResults, firstResult);
    }

    private List<SuerteUsoDeLaSuerte> findSuerteUsoDeLaSuerteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SuerteUsoDeLaSuerte.class));
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

    public SuerteUsoDeLaSuerte findSuerteUsoDeLaSuerte(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SuerteUsoDeLaSuerte.class, id);
        } finally {
            em.close();
        }
    }

    public int getSuerteUsoDeLaSuerteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SuerteUsoDeLaSuerte> rt = cq.from(SuerteUsoDeLaSuerte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

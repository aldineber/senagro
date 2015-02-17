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
import senagro.entidade.UsoDeLaSuerte;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class UsoDeLaSuerteJpaController implements Serializable {

    public UsoDeLaSuerteJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsoDeLaSuerte usoDeLaSuerte) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(usoDeLaSuerte);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findUsoDeLaSuerte(usoDeLaSuerte.getIdUsoDeLaSuerte()) != null) {
                throw new PreexistingEntityException("UsoDeLaSuerte " + usoDeLaSuerte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsoDeLaSuerte usoDeLaSuerte) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            usoDeLaSuerte = em.merge(usoDeLaSuerte);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usoDeLaSuerte.getIdUsoDeLaSuerte();
                if (findUsoDeLaSuerte(id) == null) {
                    throw new NonexistentEntityException("The usoDeLaSuerte with id " + id + " no longer exists.");
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
            UsoDeLaSuerte usoDeLaSuerte;
            try {
                usoDeLaSuerte = em.getReference(UsoDeLaSuerte.class, id);
                usoDeLaSuerte.getIdUsoDeLaSuerte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usoDeLaSuerte with id " + id + " no longer exists.", enfe);
            }
            em.remove(usoDeLaSuerte);
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

    public List<UsoDeLaSuerte> findUsoDeLaSuerteEntities() {
        return findUsoDeLaSuerteEntities(true, -1, -1);
    }

    public List<UsoDeLaSuerte> findUsoDeLaSuerteEntities(int maxResults, int firstResult) {
        return findUsoDeLaSuerteEntities(false, maxResults, firstResult);
    }

    private List<UsoDeLaSuerte> findUsoDeLaSuerteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsoDeLaSuerte.class));
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

    public UsoDeLaSuerte findUsoDeLaSuerte(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsoDeLaSuerte.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsoDeLaSuerteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsoDeLaSuerte> rt = cq.from(UsoDeLaSuerte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

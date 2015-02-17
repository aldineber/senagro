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
import senagro.entidade.SuerteCicloVida;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class SuerteCicloVidaJpaController implements Serializable {

    public SuerteCicloVidaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SuerteCicloVida suerteCicloVida) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(suerteCicloVida);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findSuerteCicloVida(suerteCicloVida.getIdsuertecicloVidacol()) != null) {
                throw new PreexistingEntityException("SuerteCicloVida " + suerteCicloVida + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SuerteCicloVida suerteCicloVida) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            suerteCicloVida = em.merge(suerteCicloVida);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = suerteCicloVida.getIdsuertecicloVidacol();
                if (findSuerteCicloVida(id) == null) {
                    throw new NonexistentEntityException("The suerteCicloVida with id " + id + " no longer exists.");
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
            SuerteCicloVida suerteCicloVida;
            try {
                suerteCicloVida = em.getReference(SuerteCicloVida.class, id);
                suerteCicloVida.getIdsuertecicloVidacol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The suerteCicloVida with id " + id + " no longer exists.", enfe);
            }
            em.remove(suerteCicloVida);
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

    public List<SuerteCicloVida> findSuerteCicloVidaEntities() {
        return findSuerteCicloVidaEntities(true, -1, -1);
    }

    public List<SuerteCicloVida> findSuerteCicloVidaEntities(int maxResults, int firstResult) {
        return findSuerteCicloVidaEntities(false, maxResults, firstResult);
    }

    private List<SuerteCicloVida> findSuerteCicloVidaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SuerteCicloVida.class));
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

    public SuerteCicloVida findSuerteCicloVida(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SuerteCicloVida.class, id);
        } finally {
            em.close();
        }
    }

    public int getSuerteCicloVidaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SuerteCicloVida> rt = cq.from(SuerteCicloVida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

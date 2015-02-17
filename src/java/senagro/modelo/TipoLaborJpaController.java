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
import senagro.entidade.TipoLabor;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class TipoLaborJpaController implements Serializable {

    public TipoLaborJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoLabor tipoLabor) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(tipoLabor);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTipoLabor(tipoLabor.getIdLabor()) != null) {
                throw new PreexistingEntityException("TipoLabor " + tipoLabor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoLabor tipoLabor) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            tipoLabor = em.merge(tipoLabor);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoLabor.getIdLabor();
                if (findTipoLabor(id) == null) {
                    throw new NonexistentEntityException("The tipoLabor with id " + id + " no longer exists.");
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
            TipoLabor tipoLabor;
            try {
                tipoLabor = em.getReference(TipoLabor.class, id);
                tipoLabor.getIdLabor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoLabor with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoLabor);
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

    public List<TipoLabor> findTipoLaborEntities() {
        return findTipoLaborEntities(true, -1, -1);
    }

    public List<TipoLabor> findTipoLaborEntities(int maxResults, int firstResult) {
        return findTipoLaborEntities(false, maxResults, firstResult);
    }

    private List<TipoLabor> findTipoLaborEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoLabor.class));
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

    public TipoLabor findTipoLabor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoLabor.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoLaborCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoLabor> rt = cq.from(TipoLabor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

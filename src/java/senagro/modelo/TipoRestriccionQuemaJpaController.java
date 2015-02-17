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
import senagro.entidade.TipoRestriccionQuema;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class TipoRestriccionQuemaJpaController implements Serializable {

    public TipoRestriccionQuemaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoRestriccionQuema tipoRestriccionQuema) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(tipoRestriccionQuema);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findTipoRestriccionQuema(tipoRestriccionQuema.getIdTipoRestrincion()) != null) {
                throw new PreexistingEntityException("TipoRestriccionQuema " + tipoRestriccionQuema + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoRestriccionQuema tipoRestriccionQuema) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            tipoRestriccionQuema = em.merge(tipoRestriccionQuema);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoRestriccionQuema.getIdTipoRestrincion();
                if (findTipoRestriccionQuema(id) == null) {
                    throw new NonexistentEntityException("The tipoRestriccionQuema with id " + id + " no longer exists.");
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
            TipoRestriccionQuema tipoRestriccionQuema;
            try {
                tipoRestriccionQuema = em.getReference(TipoRestriccionQuema.class, id);
                tipoRestriccionQuema.getIdTipoRestrincion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoRestriccionQuema with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoRestriccionQuema);
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

    public List<TipoRestriccionQuema> findTipoRestriccionQuemaEntities() {
        return findTipoRestriccionQuemaEntities(true, -1, -1);
    }

    public List<TipoRestriccionQuema> findTipoRestriccionQuemaEntities(int maxResults, int firstResult) {
        return findTipoRestriccionQuemaEntities(false, maxResults, firstResult);
    }

    private List<TipoRestriccionQuema> findTipoRestriccionQuemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoRestriccionQuema.class));
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

    public TipoRestriccionQuema findTipoRestriccionQuema(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoRestriccionQuema.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoRestriccionQuemaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoRestriccionQuema> rt = cq.from(TipoRestriccionQuema.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

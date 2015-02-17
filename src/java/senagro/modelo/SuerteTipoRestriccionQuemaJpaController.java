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
import senagro.entidade.SuerteTipoRestriccionQuema;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class SuerteTipoRestriccionQuemaJpaController implements Serializable {

    public SuerteTipoRestriccionQuemaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SuerteTipoRestriccionQuema suerteTipoRestriccionQuema) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(suerteTipoRestriccionQuema);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findSuerteTipoRestriccionQuema(suerteTipoRestriccionQuema.getSuertetipoRestriccionquemacol()) != null) {
                throw new PreexistingEntityException("SuerteTipoRestriccionQuema " + suerteTipoRestriccionQuema + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SuerteTipoRestriccionQuema suerteTipoRestriccionQuema) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            suerteTipoRestriccionQuema = em.merge(suerteTipoRestriccionQuema);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = suerteTipoRestriccionQuema.getSuertetipoRestriccionquemacol();
                if (findSuerteTipoRestriccionQuema(id) == null) {
                    throw new NonexistentEntityException("The suerteTipoRestriccionQuema with id " + id + " no longer exists.");
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
            SuerteTipoRestriccionQuema suerteTipoRestriccionQuema;
            try {
                suerteTipoRestriccionQuema = em.getReference(SuerteTipoRestriccionQuema.class, id);
                suerteTipoRestriccionQuema.getSuertetipoRestriccionquemacol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The suerteTipoRestriccionQuema with id " + id + " no longer exists.", enfe);
            }
            em.remove(suerteTipoRestriccionQuema);
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

    public List<SuerteTipoRestriccionQuema> findSuerteTipoRestriccionQuemaEntities() {
        return findSuerteTipoRestriccionQuemaEntities(true, -1, -1);
    }

    public List<SuerteTipoRestriccionQuema> findSuerteTipoRestriccionQuemaEntities(int maxResults, int firstResult) {
        return findSuerteTipoRestriccionQuemaEntities(false, maxResults, firstResult);
    }

    private List<SuerteTipoRestriccionQuema> findSuerteTipoRestriccionQuemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SuerteTipoRestriccionQuema.class));
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

    public SuerteTipoRestriccionQuema findSuerteTipoRestriccionQuema(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SuerteTipoRestriccionQuema.class, id);
        } finally {
            em.close();
        }
    }

    public int getSuerteTipoRestriccionQuemaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SuerteTipoRestriccionQuema> rt = cq.from(SuerteTipoRestriccionQuema.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import senagro.entidade.DescripcionServicio;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class DescripcionServicioJpaController implements Serializable {

    public DescripcionServicioJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DescripcionServicio descripcionServicio) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(descripcionServicio);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findDescripcionServicio(descripcionServicio.getIdServivio()) != null) {
                throw new PreexistingEntityException("DescripcionServicio " + descripcionServicio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DescripcionServicio descripcionServicio) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            descripcionServicio = em.merge(descripcionServicio);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = descripcionServicio.getIdServivio();
                if (findDescripcionServicio(id) == null) {
                    throw new NonexistentEntityException("The descripcionServicio with id " + id + " no longer exists.");
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
            DescripcionServicio descripcionServicio;
            try {
                descripcionServicio = em.getReference(DescripcionServicio.class, id);
                descripcionServicio.getIdServivio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The descripcionServicio with id " + id + " no longer exists.", enfe);
            }
            em.remove(descripcionServicio);
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

    public List<DescripcionServicio> findDescripcionServicioEntities() {
        return findDescripcionServicioEntities(true, -1, -1);
    }

    public List<DescripcionServicio> findDescripcionServicioEntities(int maxResults, int firstResult) {
        return findDescripcionServicioEntities(false, maxResults, firstResult);
    }

    private List<DescripcionServicio> findDescripcionServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DescripcionServicio.class));
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

    public DescripcionServicio findDescripcionServicio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DescripcionServicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getDescripcionServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DescripcionServicio> rt = cq.from(DescripcionServicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

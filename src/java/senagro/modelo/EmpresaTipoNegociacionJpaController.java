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
import senagro.entidade.EmpresaTipoNegociacion;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class EmpresaTipoNegociacionJpaController implements Serializable {

    public EmpresaTipoNegociacionJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmpresaTipoNegociacion empresaTipoNegociacion) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(empresaTipoNegociacion);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEmpresaTipoNegociacion(empresaTipoNegociacion.getEmpresaTipoNegociacioncol()) != null) {
                throw new PreexistingEntityException("EmpresaTipoNegociacion " + empresaTipoNegociacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmpresaTipoNegociacion empresaTipoNegociacion) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            empresaTipoNegociacion = em.merge(empresaTipoNegociacion);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empresaTipoNegociacion.getEmpresaTipoNegociacioncol();
                if (findEmpresaTipoNegociacion(id) == null) {
                    throw new NonexistentEntityException("The empresaTipoNegociacion with id " + id + " no longer exists.");
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
            EmpresaTipoNegociacion empresaTipoNegociacion;
            try {
                empresaTipoNegociacion = em.getReference(EmpresaTipoNegociacion.class, id);
                empresaTipoNegociacion.getEmpresaTipoNegociacioncol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresaTipoNegociacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(empresaTipoNegociacion);
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

    public List<EmpresaTipoNegociacion> findEmpresaTipoNegociacionEntities() {
        return findEmpresaTipoNegociacionEntities(true, -1, -1);
    }

    public List<EmpresaTipoNegociacion> findEmpresaTipoNegociacionEntities(int maxResults, int firstResult) {
        return findEmpresaTipoNegociacionEntities(false, maxResults, firstResult);
    }

    private List<EmpresaTipoNegociacion> findEmpresaTipoNegociacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmpresaTipoNegociacion.class));
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

    public EmpresaTipoNegociacion findEmpresaTipoNegociacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpresaTipoNegociacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaTipoNegociacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmpresaTipoNegociacion> rt = cq.from(EmpresaTipoNegociacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

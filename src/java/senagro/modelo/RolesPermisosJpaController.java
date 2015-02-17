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
import senagro.entidade.RolesPermisos;
import senagro.modelo.exceptions.NonexistentEntityException;
import senagro.modelo.exceptions.PreexistingEntityException;
import senagro.modelo.exceptions.RollbackFailureException;

/**
 *
 * @author johann
 */
public class RolesPermisosJpaController implements Serializable {

    public RolesPermisosJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RolesPermisos rolesPermisos) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(rolesPermisos);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findRolesPermisos(rolesPermisos.getRolesPermisoscol()) != null) {
                throw new PreexistingEntityException("RolesPermisos " + rolesPermisos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RolesPermisos rolesPermisos) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            rolesPermisos = em.merge(rolesPermisos);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rolesPermisos.getRolesPermisoscol();
                if (findRolesPermisos(id) == null) {
                    throw new NonexistentEntityException("The rolesPermisos with id " + id + " no longer exists.");
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
            RolesPermisos rolesPermisos;
            try {
                rolesPermisos = em.getReference(RolesPermisos.class, id);
                rolesPermisos.getRolesPermisoscol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rolesPermisos with id " + id + " no longer exists.", enfe);
            }
            em.remove(rolesPermisos);
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

    public List<RolesPermisos> findRolesPermisosEntities() {
        return findRolesPermisosEntities(true, -1, -1);
    }

    public List<RolesPermisos> findRolesPermisosEntities(int maxResults, int firstResult) {
        return findRolesPermisosEntities(false, maxResults, firstResult);
    }

    private List<RolesPermisos> findRolesPermisosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RolesPermisos.class));
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

    public RolesPermisos findRolesPermisos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RolesPermisos.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolesPermisosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RolesPermisos> rt = cq.from(RolesPermisos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

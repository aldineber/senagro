/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senagro.entidade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johann
 */
@Stateless
public class SuerteCicloVidaFacade extends AbstractFacade<SuerteCicloVida> {
    @PersistenceContext(unitName = "Web_SenagroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SuerteCicloVidaFacade() {
        super(SuerteCicloVida.class);
    }
    
}

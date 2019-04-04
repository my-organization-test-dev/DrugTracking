/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Fmhacamanager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp
 */
@Stateless
public class FmhacamanagerFacade extends AbstractFacade<Fmhacamanager> {

    @PersistenceContext(unitName = "DrugTrackingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FmhacamanagerFacade() {
        super(Fmhacamanager.class);
    }
    
        
     public String findAccountNO(){
        String x= em.createNamedQuery("Account.findByNo").getSingleResult().toString();
        return x;
    }
}

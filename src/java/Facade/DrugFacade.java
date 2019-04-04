/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Drug;
import Entity.Organization;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hp
 */
@Stateless
public class DrugFacade extends AbstractFacade<Drug> {

    @PersistenceContext(unitName = "DrugTrackingPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DrugFacade() {
        super(Drug.class);
    }
    
     public List<Drug> expirDateCheck(){
        
       Date today=new Date();
       Date now = new Date();
    Date thirtyDaysAgo = new Date(now.getTime() - ((now.getDate()-2) * 88400000));
        System.out.println(thirtyDaysAgo);
      //  Date d=DATE( DATE_SUB( today , INTERVAL 21 DAY ));
//        List<Drug> list=em.createNamedQuery("Drug.findByExpirDate")
//                .setParameter("today", new Date(),TemporalType.DATE)
//                .getResultList();
   List<Drug> l=em.createQuery("SELECT  a from Drug a where a.expirDate > CURRENT_TIMESTAMP")
            .getResultList();
                // SELECT  * from drug where expirDate = DATE( DATE_SUB( NOW() , INTERVAL 21 DAY ) )
        return l;
    }

    public void deactiveDrugs(int id) {
        
        em.createNamedQuery("Drug.findByDrugIdDactive")
                .setParameter("drugId", id);
        
      }

    public List<Drug> findActiveDrugs() {
        List<Drug> l=em.createQuery("SELECT  a from Drug a where a.status='active' ")
            .getResultList();
                // SELECT  * from drug where expirDate = DATE( DATE_SUB( NOW() , INTERVAL 21 DAY ) )
        return l;
      }
    
    
    public Organization oldOwner(int id){
        Query q=em.createNamedQuery("Drug.findOldOwner")
                .setParameter("drugId", id);
        Organization owner=(Organization) q.getSingleResult();
        return owner;
        
    }
    
    public float findAmount(int id){
        Query q=em.createNamedQuery("Drug.findByAmount")
                .setParameter("drugId", id);
        
        float amount=(float) q.getSingleResult();
        return amount;
    }
    
}

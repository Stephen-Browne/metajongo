/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import src.entities.Vendors;

/**
 *
 * @author Stephen
 */
public class VendorDatabaseAccess {
    
    
    public static boolean addVendor(Vendors vendorToAdd){
        
      EntityManager em = dbUtil.getEnf().createEntityManager();

        EntityTransaction trans = em.getTransaction();
            
            try{
                trans.begin();
                em.persist(vendorToAdd);
                trans.commit();
                return true;
               
            }catch(Exception ex){
                System.out.println(ex.toString());
                return false;
                
            }
            
            finally {
            em.close();
            }
    }
    
    public static Vendors getVendorWithID(int VendorId){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
        Vendors vendor = null;
        

        try{
          
         vendor =  em.find(Vendors.class, VendorId); // find vendor with ID 
         return vendor;
         
        }
        
        catch(Exception ex){
            
            //TODO
            
        }
        
        finally{
            
            em.close();
        }
        
        
        return vendor;

    }
    
    
    
    
    
    
    
    
    
    
    
    
}

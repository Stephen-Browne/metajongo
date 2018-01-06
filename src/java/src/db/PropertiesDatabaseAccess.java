/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import src.entities.Properties;

/**
 *
 * @author Stephen
 */
public class PropertiesDatabaseAccess {
    
    
     public static List<Properties> getAllProperties(){
               
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
        List<Properties> List = null;
        
        try{
            TypedQuery<Properties> tq = em.createNamedQuery("Properties.findAll", Properties.class); // Get list of authors from db
            List = tq.getResultList();

        }
        
        catch(Exception ex){
            
        }
        
        
        finally{
            em.close();
        }
        
        return List;
    }
     
    
    public static Properties getPropertyWithID(int propertyId){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
        Properties propertyFromDB = new Properties();
        
                
        try{
             propertyFromDB =  em.find(Properties.class, propertyId); // find author with id 
             return propertyFromDB;

        }catch(Exception ex){
            System.out.println(ex.toString());
            return null;
        }

    }
    
    
    public static boolean insertProperty(Properties thisproperty){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();

        EntityTransaction trans = em.getTransaction();
            
            try{
                trans.begin();
                em.persist(thisproperty);
                trans.commit();
                return true;
               
            }catch(Exception ex){
                return false;
            }
            
            finally {
            em.close();
            }

    }




    
    
}

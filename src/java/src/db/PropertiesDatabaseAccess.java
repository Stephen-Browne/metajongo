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
    
    public static boolean updateProperty(Properties propertyToEdit){
        
        
        EntityManager em = dbUtil.getEnf().createEntityManager();

        EntityTransaction trans = em.getTransaction();
            
            try{
                trans.begin();
                em.merge(propertyToEdit);
                trans.commit();
                em.close();
                return true;
               
            }catch(Exception ex){
                em.close();
                return false;
            }

    }
    
    
   public static List getTenOldestRecords(){       
       // Getting build error when I try and add this as a named query in properties class
       String query = "SELECT p FROM Properties p WHERE p.active = 1 ORDER BY p.dateAdded ASC";
       
       
         EntityManager em = dbUtil.getEnf().createEntityManager();
        
        List<Properties> List = null;
        
        try{

            TypedQuery<Properties> tq = em.createQuery(query, Properties.class); // Get list of authors from db
            tq.setMaxResults(10);  // this is used instead of the 'LIMIT 10' within the sql query
            List = tq.getResultList();

        }
        
        catch(Exception ex){
            
            System.out.println(ex.toString());
            
        }
        
        
        finally{
            em.close();
        }
        
        return List;
       
   }




    
    
}

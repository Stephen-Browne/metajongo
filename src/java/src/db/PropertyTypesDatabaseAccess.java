/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import src.entities.Properties;
import src.entities.Propertytypes;
import src.entities.Vendors;

/**
 *
 * @author Stephen
 */
public class PropertyTypesDatabaseAccess {
    
    public static List<Propertytypes> GetAllPropertyTypes(){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
        List<Propertytypes> List = null;
        
        try{
            TypedQuery<Propertytypes> tq = em.createNamedQuery("Propertytypes.findAll", Propertytypes.class); // Get list of authors from db
            List = tq.getResultList();

        }
        
        catch(Exception ex){
            
            // TODO
            
        }
        
        
        finally{
            em.close();
        }
        
        return List;

    } 
    
    public static Propertytypes getPropertyTypeWithID(int propertyTypeId){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
        Propertytypes thisType = null;
        

        try{
          
         thisType =  em.find(Propertytypes.class, propertyTypeId); // find vendor with ID 
         return thisType;
         
        }
        
        catch(Exception ex){
            
            //TODO
            
        }
        
        finally{
            
            em.close();
        }
        
        
        return thisType;
        
        
        
        
        
    }
    
    
    
    
    
}

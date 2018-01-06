/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import src.entities.Garagetypes;
import src.entities.Propertytypes;

/**
 *
 * @author Stephen
 */
public class GarageTypesDatabaseAccess {
    
    public static List GetAllGarageTypes(){
    
     EntityManager em = dbUtil.getEnf().createEntityManager();
        
        List<Garagetypes> List = null;
        
        try{
            TypedQuery<Garagetypes> tq = em.createNamedQuery("Garagetypes.findAll", Garagetypes.class); // Get list of authors from db
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
    
    
    
    public static Garagetypes getGarageTypeWithID(int typeId){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
        Garagetypes thisType = null;
        

        try{
          
         thisType =  em.find(Garagetypes.class, typeId); // find vendor with ID 
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

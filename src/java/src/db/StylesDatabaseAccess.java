/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import src.entities.Propertytypes;
import src.entities.Styles;

/**
 *
 * @author Stephen
 */
public class StylesDatabaseAccess {
    
    public static List GetAllStyleTypes(){
    
     EntityManager em = dbUtil.getEnf().createEntityManager();
        
        List<Styles> List = null;
        
        try{
            TypedQuery<Styles> tq = em.createNamedQuery("Styles.findAll", Styles.class); // Get list of authors from db
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
    
    public static Styles getStyleWithID(int styleId){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
        Styles thisType = null;
        

        try{
          
         thisType =  em.find(Styles.class, styleId); // find vendor with ID 
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

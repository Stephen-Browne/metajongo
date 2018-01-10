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
import src.entities.Agents;

/**
 *
 * @author Stephen
 */
public class AgentDatabaseAccess {
    
    public static Agents getAgentByID(int agentID){
        
         EntityManager em = dbUtil.getEnf().createEntityManager();
        
         Agents returnedAgent = em.find(Agents.class, agentID);
        
        if(returnedAgent != null)
        {
            return returnedAgent;
        }
        
        else{
            return null;
        }
        
        
    }
    
    public static Agents getAgentByUsername(String AgentUsername){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
         try{
             
            TypedQuery<Agents> tq = em.createNamedQuery("Agents.findByUsername", Agents.class); // Get list of authors from db
            tq.setParameter("username", AgentUsername); // Pass the agents username
            Agents ReturnedAgent = tq.getSingleResult(); // return Agent Object from db matching the name provided.
            
            return ReturnedAgent;
            
            

        }catch(Exception ex){
             System.out.println(ex.toString()); // Throwing Error Agents cannot be cast to Agents
             return null;
        }
        
        
        
        
        
    }
    
    public static boolean updateAgentDetails(Agents agentToUpdate){
        
        
        EntityManager em = dbUtil.getEnf().createEntityManager();

        EntityTransaction trans = em.getTransaction();
            
            try{
                trans.begin();
                em.merge(agentToUpdate);
                trans.commit();
                return true;
               
            }catch(Exception ex){
                return false;
            }
            
            finally {
            em.close();
            }
    }
    
    public static List getAllAgents(){
        
        EntityManager em = dbUtil.getEnf().createEntityManager();
        
        List<Agents> List = null;
        
        try{
            TypedQuery<Agents> tq = em.createNamedQuery("Agents.findAll", Agents.class); // Get list of authors from db
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
    
    
    
    
    
    
    
    
    
    
    
    
    
}

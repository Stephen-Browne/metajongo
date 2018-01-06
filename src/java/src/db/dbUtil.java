/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stephen
 */
public class dbUtil {
    
      private static final EntityManagerFactory enf = Persistence.createEntityManagerFactory("LitRealtyPU");
    
    
    public static EntityManagerFactory getEnf(){
        return enf;
    }
    
    
}

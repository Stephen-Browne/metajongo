/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

import java.util.Comparator;
import src.entities.Agents;

/**
 *
 * @author Stephen
 */
// Defining a custom comparator object. This allows me to sort the list of Agents by the number of properties their managing.
// I'll use this for the report generation...
public class CompareAgentsByNumberOfProperties implements Comparator<Agents>{ 
    
    @Override
    public int compare(Agents bob, Agents alice){
        
        // If bob has more properties return -1, if they've an equal amount return 0, otherwise Alice has more so return 1.
        return alice.getNumberOfProperties() < bob.getNumberOfProperties() ? -1 : alice.getNumberOfProperties() == bob.getNumberOfProperties() ? 0 : 1;
        
    }
    
}

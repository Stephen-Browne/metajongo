/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Stephen
 */
public class DateHelper {
    
    
      
   public static Calendar toCalendar(Date date){ 
       
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
}

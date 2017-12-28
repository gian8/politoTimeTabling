/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polito.timetabling;

import java.util.List;
import java.util.Map;

/**
 *
 * @author gianluca.mangiapelo
 */
public class PolitoTimeTabling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Polito Time Tabling First commit");
        Map<Integer,List<String>> data = DataProviderHelper.getAll();
        for(int exam: data.keySet()){
            System.out.println(exam + " ********************** " + data.get(exam).size());
            for(String student: data.get(exam)){
                System.out.println(student);
            }
            
            /*data.get(exam).forEach((examList)->{
                System.out.println(examList);
            });*/
            System.out.println("**********************");
        }
        
         
      
    }
    
}

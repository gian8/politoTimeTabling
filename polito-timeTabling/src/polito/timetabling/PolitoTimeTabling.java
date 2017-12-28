/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polito.timetabling;

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
        DataProviderHelper.getExams();
        DataProviderHelper.getStudents();
        DataProviderHelper.getTimeslot();
    }
    
}

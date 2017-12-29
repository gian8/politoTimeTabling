/*
 * Copyright (C) 2017 gianluca.mangiapelo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
        int timeSlot = DataProviderHelper.getTimeslot();
        
        
        
        
        // Only for Test
        /*for(int exam: data.keySet()){
            System.out.println(exam + " ********************** " + data.get(exam).size());
            for(String student: data.get(exam)){
                System.out.println(student);
            }
            System.out.println("**********************");
        }*/  
    }
    
}

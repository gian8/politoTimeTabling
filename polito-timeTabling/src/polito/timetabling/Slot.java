/*
 * Copyright (C) 2018 gianluca.mangiapelo
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author gianluca.mangiapelo
 */
public class Slot {
    private final HashMap<Integer,List<Integer>> timeSlot;
    private final int maxTimeSlot;
    private final List<Integer> listExams;
    
    public Slot(int maxTimeSlot,List<Integer> listExams){
        this.listExams = listExams;
        this.maxTimeSlot = maxTimeSlot;
        this.timeSlot = new HashMap<>(this.maxTimeSlot);
        this.setExamInSlot();
    }
    
    private void setExamInSlot(){
        
        if(this.listExams.size()>this.maxTimeSlot){
            for(int i = 0; i < this.listExams.size(); i++){
                //mi devo preparare le liste
                if(i != this.listExams.size()-1){
                    //ultima iterazione
                }
                List<Integer> listSingleExams = new ArrayList<>();
                listSingleExams.add(listExams.get(i));
                
            }
            //this.timeSlot.put(i, listSingleExams);
        }
        else{
            for(int i = 0; i < this.listExams.size(); i++){
                List<Integer> listSingleExams = new ArrayList<>();
                listSingleExams.add(listExams.get(i));
                this.timeSlot.put(i, listSingleExams);
            }
        }
        
    }
    
    public HashMap<Integer,List<Integer>> getExamInSlot(){
        return this.timeSlot;
    }
    
}

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

import java.util.HashMap;
import java.util.List;
import org.graphstream.graph.Edge;

/**
 *
 * @author gianluca.mangiapelo
 */
public class ObjFunction {
    private final double objValue;
    private final ConflictGraph gr;
    private final Slot slot;
    private List<Edge> edge;
    
    public ObjFunction(ConflictGraph gr,Slot slot) {
        this.slot = slot;
        this.gr = gr;
        this.objValue = this.calculateObjValue(this.slot);
    }
    
    public double getObjFunctionValue(){
        return this.objValue;
    }
    
    private double calculateObjValue(Slot slot){
        
       double objFun = 0;
       int totalStudent = DataProviderHelper.getTotalNumberStudent();
       this.edge = this.gr.getEdgeWeight();
        
        for(Edge e : edge){
            String idNode0 = e.getNode0().getId();
            String idNode1 = e.getNode1().getId();
            int weight = e.getAttribute("weight");
            int diff = this.calculateDistance(Integer.parseInt(idNode0), Integer.parseInt(idNode1));
            objFun+=Math.pow(2, 5-diff)*weight;
        }
        
        objFun = objFun/totalStudent;      
        return objFun;
    }
    
    //to fix - check all element in List<Integer>
    private int calculateDistance(int node1,int node2){
        
        int distance = 0;
        HashMap<Integer,List<Integer>> listSlot = slot.getExamInSlot();
        for( Integer idSlot : listSlot.keySet()){
            int examFirst = listSlot.get(idSlot).get(0); // only first exam in slot
            if(examFirst == node1){
                //mi scorro tutti gli slot confrontando gli esami degli slot
                for( Integer idSlot1 : listSlot.keySet()){
                    int examCheck = listSlot.get(idSlot1).get(0); // only first exam in slot
                    if(examCheck == node2){
                        distance = Math.abs(idSlot1-idSlot); 
                    }
                }
            }
        }
        
        return distance;
    }
    
}

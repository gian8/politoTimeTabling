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
import java.util.ArrayList;
import java.util.HashMap;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author gianluca.mangiapelo
 */
public final class ConflictGraph {
    private final Graph graph;
    private final Map<Integer,List<String>> data;
    private HashMap<Integer, ArrayList<Conflict>> mapConflict;
    
    public ConflictGraph(Map<Integer,List<String>> data){
        this.graph = new SingleGraph("Conflict graph");
        this.data = data;
        for(int exam:data.keySet()){
            Node n = graph.addNode(Integer.toString(exam));
        }
        this.mapConflict = this.calculateNumberConflict(this.calculateConflict());
        
       this.setEdges();
       this.displayConflictGraph();
       this.getEdgeWeight();
    }
    
    public void displayConflictGraph(){
        this.graph.display();
    }
    
    private void setEdges(){
        for(int key:this.mapConflict.keySet()){
            for(Conflict conf: this.mapConflict.get(key)){
                Edge e = this.graph.addEdge(Integer.toString(key)+"-"+Integer.toString(conf.getExam()), Integer.toString(key), Integer.toString(conf.getExam()));
                e.setAttribute("weight", conf.getNumberConflict());
            }
        }
    }
    
    private void getEdgeWeight(){
        for(Edge e:this.graph.getEachEdge()) {
            System.out.println("Edge: "+e.getId()+", Conflict number: "+e.getAttribute("weight") );
        }
    }
    
    
    /*
    Return an hash Map with the conflict focusing from-to which exam 
    */
    public HashMap<Integer, ArrayList<Conflict>> calculateConflict(){
        HashMap<Integer, ArrayList<Conflict>> map =  new HashMap<>();
        for(int exam: data.keySet()){
            ArrayList<Conflict> arr = new ArrayList<>();
            for(String student: data.get(exam)){
                for (int key1 = exam+1; key1<=data.keySet().size();key1++){
                    for(String value1 : data.get(key1)){
                        if(key1 != exam){
                            if(student.equals(value1)){
                                arr.add(new Conflict(key1,true));
                            }
                        }
                    }
                }
            } 
            map.put(exam, arr);
        }
        return map;
    }
    
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
}
   
    public HashMap<Integer, ArrayList<Conflict>> calculateNumberConflict(HashMap<Integer, ArrayList<Conflict>> map){
        HashMap<Integer, ArrayList<Conflict>> mapNumber = new HashMap<>();
        
        for(Integer key: map.keySet()){
            ArrayList<Conflict> listConf = new ArrayList<>();
            ArrayList<Conflict> conflictList = map.get(key);
            List<Conflict> listDistinct = conflictList.stream().filter(distinctByKey(Conflict::getExam)).collect(Collectors.toList());
            
            for(Conflict conf : listDistinct){
                int freq = this.occurency(conflictList, conf);
                if(freq != 0){
                    listConf.add(new Conflict(conf.getExam(),freq));
                }
            }
            
            if(listConf.size()>0 ){
                mapNumber.put(key, listConf);
            }
        }
        
    return mapNumber;
    }

 private int occurency(ArrayList<Conflict> conflictList,Conflict conf){
     int occ=0;
     
     for(Conflict conflict: conflictList){
         if(conflict.getExam() == conf.getExam()){
             occ++;
         }
     }
     
     return occ;
 }
    
}

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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gianluca.mangiapelo
 */
public class DataProviderHelper {
    
    /**
     *
     * @return
     */
    public static Map<Integer,Integer> getExams(){
        Map<Integer,Integer> exams = new HashMap<>();
        
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\gianluca.mangiapelo\\Desktop\\DESK\\Polito\\Optimization methods and Algorithms\\Assignee\\polito-timetabling\\politoTimeTabling\\polito-timeTabling\\assets\\istanze\\instance03.exm");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
                String strLine;
                
                while ((strLine = br.readLine()) != null) {
                    String[] lineSplit = strLine.split(" ");
                    if(lineSplit.length < 2){
                        System.err.println("Warning: format file is changed"); //fix with exceptions
                    }
                    else{
                        exams.put(Integer.parseInt(lineSplit[0]),Integer.parseInt(lineSplit[1]));
                    }
                }
                br.close();
            }
        }
        catch(IOException e){
            System.err.println(e);
            return null;
        }
        
        return exams;
    }
    
    public static Map<String,List<Integer>> getStudents(){
        Map<String,List<Integer>> student = new HashMap<>();
        
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\gianluca.mangiapelo\\Desktop\\DESK\\Polito\\Optimization methods and Algorithms\\Assignee\\polito-timetabling\\politoTimeTabling\\polito-timeTabling\\assets\\istanze\\instance03.stu");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
                String strLine;
                String oldKey = "";
                int counter = 0;
                List<Integer> examsList = new ArrayList<>();
                
                while ((strLine = br.readLine()) != null) {
                    String[] lineSplit = strLine.split(" ");
                    if(counter == 0){
                        oldKey = lineSplit[0];
                        counter++;
                    }
                    if(lineSplit.length < 2){
                        System.err.println("Warning: format file is changed"); //fix with exceptions
                    }
                    else{
                        if(oldKey.equals(lineSplit[0])){
                            //popolo la lista di esami;
                            examsList.add(Integer.parseInt(lineSplit[1]));
                            
                        }
                        else{
                            student.put(oldKey,examsList);
                            examsList = new ArrayList<>();;
                            examsList.add(Integer.parseInt(lineSplit[1]));
                        }
                    }
                    oldKey = lineSplit[0];
                    counter++;
                }
                br.close();
                student.put(oldKey,examsList); //for the last line
            }
        }
        catch(IOException e){
            System.err.println(e);
            return null;
        }
        
        return student;
    }
    
    public static int getTimeslot(){
    
        int timeslot = 0;
        
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\gianluca.mangiapelo\\Desktop\\DESK\\Polito\\Optimization methods and Algorithms\\Assignee\\polito-timetabling\\politoTimeTabling\\polito-timeTabling\\assets\\istanze\\instance03.slo");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
                String strLine;
                
                while ((strLine = br.readLine()) != null) {
                    timeslot = Integer.parseInt(strLine);
                }
                br.close();
            }
        }
        catch(IOException e){
            System.err.println(e);
        }
    
        return timeslot;
    }
    
    public static Map<Integer,List<String>> getAll(){  
     Map<Integer,List<String>> dataComplete = new HashMap<>();
     Map<Integer,Integer> exams = null;
     Map<String,List<Integer>> students = null;
     
     exams = DataProviderHelper.getExams();
     students = DataProviderHelper.getStudents();
     
     for(Integer exam: exams.keySet()){
        List<String> studentEn = new ArrayList<>();
        
        for(String student: students.keySet()){
            List<Integer> idExamsListFromStudent = students.get(student);
            int idExamsFromExams = exam;
            for (Integer idExamFromStudent:idExamsListFromStudent )
                if(idExamFromStudent == idExamsFromExams){
                    studentEn.add(student);
                }
        }
        
            dataComplete.put(exam,studentEn);
     }
     
     return dataComplete;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            
            /**** Only for control ****
            exams.keySet().forEach((key) -> {
                System.out.println(key + " " + exams.get(key));
            });
            System.out.println("dictionary lenght: " + exams.size());
            /**************************/
        }
        catch(IOException e){
            System.err.println(e);
            return null;
        }
        
        return exams;
    }
    
    public static Map<String,Integer> getStudents(){
        Map<String,Integer> student = new HashMap<>();
        
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\gianluca.mangiapelo\\Desktop\\DESK\\Polito\\Optimization methods and Algorithms\\Assignee\\polito-timetabling\\politoTimeTabling\\polito-timeTabling\\assets\\istanze\\instance03.stu");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
                String strLine;
                
                while ((strLine = br.readLine()) != null) {
                    String[] lineSplit = strLine.split(" ");
                    if(lineSplit.length < 2){
                        System.err.println("Warning: format file is changed"); //fix with exceptions
                    }
                    else{
                        student.put(lineSplit[0],Integer.parseInt(lineSplit[1]));
                    }
                }
                br.close();
            }
            
            /**** Only for control ****
            student.keySet().forEach((key) -> {
                System.out.println(key + " " + student.get(key));
            });
            System.out.println("dictionary lenght: " + student.size());
            /**************************/
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
            
            /**** Only for control ****
            System.out.println(timeslot);
            /**************************/
        }
        catch(IOException e){
            System.err.println(e);
        }
    
        return timeslot;
    }
    
    public static Map<Integer,List<String>> getAll(){  
     Map<Integer,List<String>> dataComplete = new HashMap<>();
     Map<Integer,Integer> exams = null;
     Map<String,Integer> students = null;
     
     exams = DataProviderHelper.getExams();
     students = DataProviderHelper.getStudents();
     
     for(Integer exam: exams.keySet()){
        List<String> studentEn = new ArrayList<>();
        
        for(String student: students.keySet()){
            int idExamFromStudent = students.get(student);
            int idExamsFromExams = exam;
            if(idExamFromStudent == idExamsFromExams){
                studentEn.add(student);
            }
        }
        
            dataComplete.put(exam,studentEn);
        
     }
     
     return dataComplete;
    }
    
    
}

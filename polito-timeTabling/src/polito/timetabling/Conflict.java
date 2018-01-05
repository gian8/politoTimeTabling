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


/**
 *
 * @author gianluca.mangiapelo
 */
public class Conflict {
    private int exam;
    private boolean conflict;
    private int numberOfConflict;
    
    public Conflict(int exam,boolean conflict){
        this.exam = exam;
        this.conflict = conflict;
    }
    
    public Conflict(int exam,int numberConflict){
        this.exam = exam;
        this.numberOfConflict = numberConflict;
    }
    
    public int getExam(){
        return this.exam;
    }
    public int getNumberConflict(){
        return this.numberOfConflict;
    }
    public boolean getConflict(){
        return this.conflict;
    }
    public void setExam(int exam){
        this.exam = exam;
    }
    public void setNumberConflict( int number){
        this.numberOfConflict = number;
    }
    public void setConflict(boolean conflict){
        this.conflict = conflict;
    }
    
}

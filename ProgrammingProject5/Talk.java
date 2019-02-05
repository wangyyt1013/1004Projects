/*
 * This class simulates an individual talk.
 * 
 * @author: Yuanyuting Wang
 * @date: 2018.11.20
 */

import java.util.ArrayList;
import java.io.IOException;

public class Talk implements Comparable<Talk>{
    private String name;
    private int start;
    private int end;
    
    public Talk(ArrayList<String> paras){
        name = paras.get(0);
        start = Integer.parseInt(paras.get(1).trim());
        end = Integer.parseInt(paras.get(2).trim());
        
        //If the information from reading the file has a flawed format, 
        //throw an exception
        if (start < 0 || end < 0 || start > 2400 || end > 2400){
            throw new IllegalArgumentException("Start and end time should be"
                                                   + "within 0000 to 2400.");
        }
        if (start >= end){
            throw new IllegalArgumentException("Start time should be earlier" 
                                                   + "than end time.");
        }
    }
    
    //The talks are sorted according to their end time
    public int compareTo(Talk other){
        if (this.end < other.end){
            return -1;
        }
        else if (this.end > other.end){
            return 1;
        }
        else {
            return 0;
        }
    }
    
    //This method prints out the info of every Talk object in a 
    //human-readable form
    public String toString(){
        String printed = "";
        printed += String.format("%-15s", name);
        printed += String.format("%6d", start);
        printed += String.format("%6d", end);
        return printed;
    }
    
    public int getStart(){
        return start;
    }
    
    public int getEnd(){
        return end;
    }
    

}
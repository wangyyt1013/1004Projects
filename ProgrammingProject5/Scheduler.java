/*
 * This static class creates lists of talks and creates the schedule that 
 * could fit in the maximum number of talks.
 * 
 * @author: Yuanyuting Wang
 * @date: 2018.11.20
 */

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Scheduler{
    
    //Each line in the talk file should contain only three parameters
    private static int PARA_NUM = 3;
    
    //This method returns a list of talks from the input file
    public static ArrayList<Talk> makeTalks(String filename) throws IOException{
        
        File talkFile = new File(filename);
        Scanner in = new Scanner(talkFile);
        ArrayList<Talk> talkList = new ArrayList<Talk>();
        
        while (in.hasNextLine()){
            
            //Process every line by reading the parameters one by one
            String line = in.nextLine();
            
            //Create a new Scanner object to read the items in each line
            Scanner lineReader = new Scanner(line);
            ArrayList<String> paras = new ArrayList<String>();
            while(lineReader.hasNext()){
                paras.add(lineReader.next());
            }
            
            //Check if there are checked exceptions from the input file
            if (paras.size() != PARA_NUM){
                throw new IllegalArgumentException("Talk information should" +
                                           "contain only three parameters.");
            }
            if (!paras.get(1).matches("[0-9]+") ||
                !paras.get(2).matches("[0-9]+")){
                throw new IllegalArgumentException("Talk start and end time"
                                           + "should include only integers.");
            }
            
            //Create a new talk object for each line
            Talk newTalk = new Talk(paras);
            talkList.add(newTalk);
        }
        return talkList;
    }
    
    //This method returns the talk schedule that accommodates the maximum 
    //number of talks given in the same room
    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talkList){
        
        ArrayList<Talk> talkSchedule = new ArrayList<Talk>();
        ArrayList<Talk> talkListCopy = (ArrayList) talkList.clone();
        Collections.sort(talkListCopy);
        
        //start with the talk that ends the earliest
        talkSchedule.add(talkListCopy.get(0));
        talkListCopy.remove(0);
        
        int counter = 0;
        boolean hasCompatible = true;
        
        //Every time a talk is scheduled, find the talks in the rest of the list
        //that are compatible with it, choose the talk that ends the earliest
        //from the newly generated list, and shift that talk from the overall
        //list of talks to the schedule
        while (hasCompatible){
            ArrayList<Talk> compatibles = 
                findCompatible(talkSchedule.get(counter), talkListCopy);
            
            if (compatibles.size() > 0){
                talkSchedule.add(compatibles.get(0));
                talkListCopy.remove(compatibles.get(0));
                counter ++;
            }
            
            //If no more talks are compatible with the current schedule, 
            //stop adding to the schedule
            else {
                hasCompatible = false;
            }
        }
        return talkSchedule;
    }
    
    //This method finds the talks compatible with the current schedule, i.e. talks that start
    //later than the end time of the last talk scheduled
    private static ArrayList<Talk> findCompatible(Talk scheduledTalk, 
                                                 ArrayList<Talk> talkList){
        ArrayList<Talk> compatibles = new ArrayList<Talk>();
        for (int i = 0; i < talkList.size(); i++){
            if (talkList.get(i).getStart() >= scheduledTalk.getEnd()){
                compatibles.add(talkList.get(i));
            }
        }
        
        //sort the list of compatible talks to make operations on it easier
        Collections.sort(compatibles);
        return compatibles;
    }
}
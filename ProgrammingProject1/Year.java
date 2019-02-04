/**
*
* This class represents a calendar year. It contains 
* a method that determines if the year is a leap year.
* 
* @author: <Yuanyuting Wang>
* @date: <20180919>
*
*/

public class Year{
    
    // declare your instance variables here

    private int year;

    // write your constructor here
    
    public Year(int y){
        // your code here
        year = y;
    }
    
    public boolean isLeapYear(){
        // your code here 
        
        if (year%4!=0){
            return false;
        }
        else if (year%100!=0){
            return true;
        }
        else if (year%400!=0){
            return false;
        }
        else{
            return true;
        }
        
    }

}    


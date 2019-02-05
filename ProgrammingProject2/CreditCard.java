/* 
 * This class stores a credit card number as a string and examines 
 * if this number is valid. If not, it tests which rule the number has 
 * failed to follow first.
 * 
 * @input: the credit card number (stored in a String variable).
 * @author: Yuanyuting Wang
 * @date: 20180925.
 */

public class CreditCard{
    
    // declare and initialize the instance variables.
    
    private String number;
    private boolean valid;
    private int errorCode;
    
    public CreditCard(String input){
        number = input.trim();
        errorCode = 0;
        valid = true;
    }
    
    // this mutator method checks if the number follows rule1.
    
    private void check1(){
        if (!(Integer.parseInt(number.substring(0,1)) == 4)){
            valid = false;
            errorCode = 1;
        }
    }

    // this mutator method checks if the number follows rule2.
    
    private void check2(){
        if (!(Integer.parseInt(number.substring(3,4)) - 
              Integer.parseInt(number.substring(4,5)) == 1)){
            valid = false;
            errorCode = 2;
        }
    }
    
    // this mutator method checks if the number follows rule3.
    
    private void check3(){
        if (!(Integer.parseInt(number.substring(0,1))*
              Integer.parseInt(number.substring(4,5))*
              Integer.parseInt(number.substring(8,9))==24)){
            valid = false;
            errorCode = 3;
        }
    }
    
    // this mutator method checks if the number follows rule4.

    private void check4(){
        int sum = 0;
        
        for (int i = 0; i <= number.length()-1; i++){
            sum += Integer.parseInt(number.substring(i,i+1));
        }
        
        if (!(sum % 4 == 0)){
            valid = false;
            errorCode = 4;
        }
    }
    
    // this mutator method checks if the number follows rule5.

    private void check5(){
        int sum1 = 0;
        int sum2 = 0;
        
        for (int i = 0; i <= number.length()-1; i++){
            if (i<=3)
                sum1 += Integer.parseInt(number.substring(i,i+1));
            if (i>= number.length()-4)
                sum2 += Integer.parseInt(number.substring(i,i+1));
        }
        
        if (!(sum1 + 1 == sum2)){
            valid = false;
            errorCode = 5;
        }
    }
    
    // this mutator method checks if the number follows rule6.

    private void check6(){
        if (!((Integer.parseInt(number.substring(0,1))+
               Integer.parseInt(number.substring(6,7)))*10 + 
              Integer.parseInt(number.substring(1,2)) + 
              Integer.parseInt(number.substring(7,8)) == 100)){
            valid = false;
            errorCode = 6;
        }
    }
    
    /* 
     * this public mutator method checks if the number follows all six rules,
     * and change the error code value to the first instance where the number fails
     * to follow a rule.
     */
   
    public void check(){
        this.check6();
        this.check5();
        this.check4();
        this.check3();
        this.check2();
        this.check1();
    }
    
    // access the value of the instance variable "valid".
    
    public boolean isValid(){
        return valid;
    }
    
    // access the value of the instance variable "errorCode".
    
    public int getErrorCode(){
        return errorCode;
    }
}
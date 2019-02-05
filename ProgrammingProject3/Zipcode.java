/*****************************************
 * This program conducts conversion between ZIP codes and UPS-regulated bar codes.
 * 
 * @author Yuanyuting Wang
 * @date 10/15/2018
 ****************************************/ 
public class Zipcode {
    
    private static final int DIGITS_ZIP;//the number of ZIP code digits.
    private static int[][] WEIGHT_TABLE;//the table of different combinations of 
                                        //column weights corresponding to different
                                        //digit values.
    private static int[] WEIGHTS;//the column weights.
    private static int DIGITS_WEIGHT;//the number of column weights.
    private String zipcode;
    private String barcode;
    private String checkDigit;
    
    static {
        DIGITS_ZIP = 5;
        DIGITS_WEIGHT = 5;
        WEIGHT_TABLE = new int[][] {{1,1,0,0,0},
                       {0,0,0,1,1},
                       {0,0,1,0,1},
                       {0,0,1,1,0},
                       {0,1,0,0,1},
                       {0,1,0,1,0},
                       {0,1,1,0,0},
                       {1,0,0,0,1},
                       {1,0,0,1,0},
                       {1,0,1,0,0}};
        WEIGHTS = new int[] {7,4,2,1,0};
    }
    
    //calculat check digit and bar code with given ZIP code and store results in instance variables.
    public Zipcode(int zip){
        zipcode = String.format("%0" + DIGITS_ZIP + "d", zip);
        checkDigit = this.calculateCheckDigit();
        barcode = this.calculateBarcode();
    }
    
    //calculate check digit and ZIP code with given bar code and store results in instance variables.
    public Zipcode(String bar){
        barcode = bar;
        zipcode = this.calculateZIPcode();
        checkDigit = this.calculateCheckDigit();
    }
    
    //find check digit given ZIP code.
    private String calculateCheckDigit(){
        
        //calculate sum of ZIP code digits.
        int sum = 0;
        for (int i = 1; i <= DIGITS_ZIP ; i++){
            int digitZip = Integer.parseInt(zipcode.substring(i-1,i));
            sum += digitZip;
        }
        
        //calculate check digit that brings digit sum to nearest larger multiple of 10.
        if (sum%10==0) {
            return "0";
        }
        else {
            return String.format("%01d", 10 * (sum/10 + 1) - sum);
        }
    }
    
    //find bar code given ZIP code and check digit.
    public String calculateBarcode(){
        
        String bar = "|";//full-height frame bar on the left sight.
        String zipcodeplus = zipcode + checkDigit;
        
        //find bar code for each digit and then add results together.
        for (int i = 1; i <= DIGITS_ZIP+1 ; i++){
            int digitZip = Integer.parseInt(zipcodeplus.substring(i-1,i));
            for (int j = 1; j <= DIGITS_WEIGHT ; j++){
                if (WEIGHT_TABLE[digitZip][j-1] == 1){
                    bar += "|";
                }
                else {
                    bar += ":";
                }
            }
        }
        
        return bar + "|"; //add full-height frame bar on the right side.
    }
        
    //find ZIP code given bar code.
    public String calculateZIPcode(){
        
        String zipcodeInt = "";
        
        for (int i = 1; i <= DIGITS_ZIP; i++){
            
            int temporarySum = 0;
             
            //divide bar code into 5-bar segments.
            String barCodePart = 
                barcode.substring(DIGITS_WEIGHT*(i-1)+1, DIGITS_WEIGHT*i+1);
            
            //find ZIP digit each segment corresponds to and add results together.
            if (barCodePart.equals("||:::")){
                temporarySum = 0;
            }
            else {
                for (int j = 1; j <= DIGITS_WEIGHT; j++){
                    if (barCodePart.substring(j-1, j).equals("|")){
                    temporarySum += 1 * WEIGHTS[j-1];
                    }
                }
            }
            zipcodeInt += String.format("%01d", temporarySum);
        }
        return zipcodeInt;
    }

    //return value of instance variable barcode.
    public String getBarcode(){
        return barcode;
    }
    
    //return value of instance variable zipcode.
    public String getZIPcode(){
        return zipcode;
    }
}
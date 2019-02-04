public class getNumber_new{
    private String charFirst;
    private String charSecond;
    private String charThird;
    private int First;
    private int Second;
    private int Third;
    public getNumber_new(String[] catalog){
        charFirst = catalog[0];
        charSecond = catalog[1];
        charThird = catalog[2];
    }
    public String convert(int number){
        int a = number % 5;
        int b = number / 5;
        int nFirst = 0;
        int nSecond = 0;
        int nThird = 0;
        boolean reverse = false;
        String RNumber = "";
        if (a==4){
            nFirst = 1;
            reverse = true;
            if (b == 1){
                nThird = 1;
            }
            else {
                nSecond = 1;
            }
        }
        else {
            nFirst = a;
            nSecond = b;
        }
        if (reverse == true){
            RNumber = new String(new char[nFirst]).replace("\0", charFirst) + new String(new char[nSecond]).replace("\0", charSecond) + new String(new char[nThird]).replace("\0", charThird);        
        }
        else 
            RNumber = new String(new char[nThird]).replace("\0", charThird) + new String(new char[nSecond]).replace("\0", charSecond) + new String(new char[nFirst]).replace("\0", charFirst);
        return RNumber;
    }
}
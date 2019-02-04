public class getNumber{
    private String charFirst;
    private String charSecond;
    private String charThird;
    private int First;
    private int Second;
    private int Third;
    public getNumber(String[] catalog){
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
        boolean doublereverse = false; 
        String RNumber = "";
        if (a==4){
            nFirst = 1;
            reverse = true;
            if (b/2==1)
                doublereverse = true;
            if (b%2 == 1){
                nThird = b/2 + 1;
            }
            else {
                nThird = b/2;
                nSecond = 1;
            }
        }
        else {
            nFirst = a;
            nSecond = b;
            nThird = b/2;
        }
        if (reverse == true){
            if (doublereverse == true){
                if (nThird==2)
                    RNumber = charThird + charFirst + charThird;
                else
                    RNumber = charThird + charFirst + charSecond;
            }
            else
                RNumber = new String(new char[nFirst]).replace("\0", charFirst) + new String(new char[nSecond]).replace("\0", charSecond) + new String(new char[nThird]).replace("\0", charThird);        
        }
        else 
            RNumber = new String(new char[nThird]).replace("\0", charThird) + new String(new char[nSecond]).replace("\0", charSecond) + new String(new char[nFirst]).replace("\0", charFirst);
        return RNumber;
    }
}
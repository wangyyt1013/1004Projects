Name: Yuanyuting Wang
UNI: yw3241
Assignment: Programming Project 2

===============================================================================
<Problem 2>
===============================================================================

The CreditCard class stores a credit card number as a string and examines if this number is valid. 
If not, it tests which rule the number has failed to follow first.

The six rules for testing the validity of the number are listed as follows:
1.  The first digit must be a 4.  
2.  The fourth digit must be one greater than the fifth digit  
3.  The product of the first, fifth, and ninth digits must be 24  
4.  The sum of all digits must be evenly divisible by 4  
5.  The sum of the first four digits must be one less than the sum of the last four digits  
6.  If you treat the first two digits as a two-digit number, and the seventh and eight digits as a two digit number, their sum must be 100. 

To design a class that fulfills the requirement, I first store the input card number as
the value for one of the instance variables. The other two instance variables are meant 
to denote the first rule (if any) that the card number fails to follow, and the validity
of the card number. I then use six private methods that respectively tests whether the 
input card number follows the six listed rules. Finally, the mutator check() method calls the 
six methods from that associated from rule6 to that associated with rule1, so that the
output error code is the first instance of the number's failure to follow one rule. 
Finally, the two accessor methods isValid() and getErrorCode() return the result of the 
tests (I.e. whether the number is valid and, if not, which rule it fails to follow).

To start using this class, first store the account number into a String variable.
Then, create a CreditCard object with the String variable as the argument for its constructor.
1. To check the validity of a number, call the check() method, which will reset the validity and the error code of the number.
2. To get the result for the validity check, call the isValid() method. If the number is valid, the method returns the boolean value "true". Otherwise, it returns "false".
3. To get the error code, call the getErrorCode() method. The method returns the int value of the No. of the rule that the number first fails to follow. 

P.S.1. If the check() method is uncalled, by default, the credit card number is valid and the error code is 0.
P.S.2. If the number is valid, the getErrorCode() method will just return 0.
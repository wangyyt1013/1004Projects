# COMS W1004 

## Fall 2018

## Programming Project 2 
### Due October 1, 11:59PM


**Problem 2 (50 points)**
 
Credit card companies use built-in "checksums" as added security measures when creating the account numbers on credit cards. This means that there are only certain valid credit card numbers, and validity can instantly be detected by using an algorithm that may involve adding up parts of the numbers or performing other checks.  In this problem, you will implement a security algorithm on a credit card number, and your program will indicate whether or not the card number is valid, according to the security check. Note that this algorithm is purely made-up; don't try to use it to detect fake credit card numbers! 

To check that the credit card number is valid, verify that it conforms to the following rules:  

	1.	The first digit must be a 4.  
	2.	The fourth digit must be one greater than the fifth digit  
	3.	The product of the first, fifth, and ninth digits must be 24  
	4.	The sum of all digits must be evenly divisible by 4  
	5.	The sum of the first four digits must be one less than the sum of the last four digits  
	6.	If you treat the first two digits as a two-digit number, and the seventh and eight digits as a two digit number, their sum must be 100.  
	
*Hint: valid card numbers according to this set of rules include 4807-6052-1766 and 4094-3460-2754.*  

You should use these for testing out your program.
Your job is to create a CreditCard class that represents a card number as a String. Hence you will have an instance variable of type String to store this. In addition the CreditCard class must have a mutator method called check( ) that determines if the credit card is valid or not. This information (whether the card is valid or not) should be stored in an instance variable of type boolean. Your class should also have an accessor method called isValid( ) that returns the value of this boolean.  Your class CreditCard should also have an instance variable of type int called errorCode. This variable should be initialized to 0 and changed to an integer between 1 and 6 if the CreditCard object fails one of the tests above. That is, the check( ) method should change errorCode to the number corresponding to the first test the number failed. If the number does not fail any tests then you can leave the errorCode variable at 0. Finally, you should have an accessor method called getErrorCode( ) that returns the value of the variable errorCode. You might find this method useful when you are verifying that your check( ) method works correctly.


included here you will find a test class called CreditCardTester. Your CreditCard class must work with the test class provided without modification. ** You must NOT alter the test class.**


To complete this problem, you may wish to use various methods of the String class, described in Horstmann and in the Java online documentation for String. In particular, you may want to use methods for getting the character at a certain index and for converting characters to Strings. If you go this route you will also need to use the Integer.parseInt method to convert a String to an int as seen in the PhoneNumber example from lecture.


**What to hand in:**  
In addition to the source files for your programs include a text file named readMe.txt with an explanation of what you did for each programming problem. That is, write in plain English, instructions for using your software, explanations for how and why you chose to design your code the way you did. The readMe.txt file is also an opportunity for you to get partial credit when certain requirements of the assignment are not met.  Put the readMe.txt file in the same directory as your source and use the usual submission instructions for submitting the assignment.

### Submitting your assignment
Please develop your programs on Codio but submit all of your work on Canvas. You must export source code from codio, then together with your readMe.txt compress them into a single zip file, and submit it on Canvas. The compressed file you submit should be called [your UNI]_pp2.zip so for example my submission would be called ac1076_pp2.zip  
    


### A word about Grading: 
Each programming question on assignment will be graded as follows:

* 30% if it compiles  
* 30% if it runs properly (expected output for given input, etc.)  
* 20% for style (formatting of code, variable names, comments, etc. Use the style guide posted on Coursworks!)  
* 20% for design (efficiency, class  orginaization, method length, etc...)  

Please make sure your programw at least compile before you submit them! There will be no partial credit for a program that "almost" compiles.

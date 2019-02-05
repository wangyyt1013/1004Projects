Problem 1:

#General design: 
 The Game class takes in the parameter of difficulty (1 is low difficulty,
 2 is high difficulty), generates a pile of marbles with a random number between 10 
 and 100, and uses the Human and the Computer class to simulate the actions of the human
 and the computer players for each round until only one marble is left.
 
 When it's the human player's turn, the user will be asked to input their choice that 
 should fall within a given range. When it's the computer player's turn, if the user 
 has chosen low difficulty, the computer only removes a random number of marbles. If
 the user has chosen high difficulty, the computer always follows the winning strategy 
 of the Nim game, and is unbeatable unless the human player gets the first move.
 
 The program is designed so that the user can choose the level of difficulty. This makes sure 
 that the game experience is more customized and caters to the user's entertainmnet needs.
 Besides the number of difficulty, the user only needs to choose the number of marbles 
 they want to remove each round, and the rest of the implementation is hidden from the user
 from the public interface. This simplifies the game experience for the user.

#Instruction for use:
 When running the game, first create a Game object with the difficulty level as the parameter 
 of its constructor. Then call the play() method on the object, and the rest of the game will 
 be implemented by the Game class.
 
 
Problem 2:

#General design:
 The Zipcode class can conduct the conversion of ZIP code to bar code as well as bar code to 
 ZIP code.
 
 For conversion of ZIP code to bar code, it takes in the ZIP code as a String, 
 calculates the check digit for the ZIP code, and construct the bar code using for loops according 
 to the generator method recommended by the UPS. 
 
 For conversion of bar code to ZIP code, it takes in the bar code as a String, 
 find the ZIP digit each 5-bar segment corresponds to, and add the 5 resultant digits together
 to form the ZIP code.
 
 The result of both conversions are stored in the instance variables of the Zipcode object. In 
 fact, the mutator methods that set the value of the ZIP code, bar code, and check digit are called
 within the constructor of the class. In this way, when a Zipcode object is created, its corresponding
 bar code and check digit are found and saved simultaneously. This separates the accessor method
 from the mutator method, and the user can call the accessor method immediately after creating
 the Zipcode object to directly get the converted result. This design simplifies the process of 
 conversion for the user.
 
 Also, the ZIP code and check digit are stored and circulated as String objects, both to account for 
 0 digits that may appear on the leftmost end of the code, and to make the process of visiting each 
 digit of the ZIP code more simplified in format by making use of the substring() method of String 
 objects. However, the parameters for the two constructors are still of different data types (int for 
 ZIP code and String for bar code) to distinguish the two operations from each other. The instance 
 variable zipcode takes in the value of the int-type input after it is converted to a String object.
 
#Instruction for use:
 To convert ZIP code to bar code, initialize a Zipcode object with the ZIP code of data type int. Then
 call the accessor method getBarcode() on the object, which returns its bar code of type String.
 
 To convert bar code to ZIP code, initialize a Zipcode object with the bar code of data type String. Then
 call the accessor method getZIPcode() on the object, which returns its ZIP code of type String.

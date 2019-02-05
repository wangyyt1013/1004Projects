Talk Scheduler
@author: Yuanyuting Wang
@date: 2018.11.21

The program is designed to schedule as many talks, given in the same day
in the same room, as possible, from a list of available talks that include
information about the name of the speaker, the start and the end time 
(using the 2400 time-keeping system). 

To find the schedule that accommodates the maximum number of talks, the algorithm
is so designed that every time when a new talk is included into the schedule, 
the program chooses the talk that ends the earliest from the rest of the talks
that are compatible with the schedule, and adds that talk to the schedule. The
program will keep doing this until there are no more talks left that are compatible
with the current schedule.

To run the program, include the name of the text file of all the available talks 
as the command line argument. Note that to allow the program to function correctly, 
the text file must use the 2400 time-keeping sysem, with all the afternoon and 
evening talks starting at 1200 or later. Failure to do so will lead the program 
to wrongly assume that all the afternoon and evening talks are 12 hours earlier 
than they are actually scheduled to be. 

The file should also be formatted in the following way: 
1. the information about each talk should occupy a separate line.
2. each line only contains the three parameters (name, start time, end time)
separated by white spaces.
3. the start and end time should be within the 24 hours (0000 - 2400), and 
the start time should be earlier than the end time.
4. the start and end time should include only integral numbers.
If the text file does not satisfy these requirements, an IOException will be 
thrown, and the program will be terminated.

Enjoy talk scheduling! :)
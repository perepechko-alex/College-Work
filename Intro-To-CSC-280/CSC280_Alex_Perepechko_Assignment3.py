'''
*********************************************************************
* CSC 280 - Programming Project 3                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC280_Alex_Perepechko_Assignment3.py          *
* modified from:     CSC 280 Programing Project 3 handout           *
* date last modified: February 12, 2014                             *
*                                                                   *
* Programing Project 3 - Part 1:                                    *
*                                                                   *
* action: computes max, min, and average from a specified number of *
*         user inputs.                                              *
*                                                                   *
* input: the amount of items the user wants to enter, the values    *
*                                                                   *
* output: the max, min, and average of user inputed values          *
*                                                                   *
* Programing Project - Part 3:                                      *
*                                                                   *
* action: compares 3 values and displays the max and min from values*
*                                                                   *
* input: Three numbers from the user                                *
*                                                                   *
* output: The max and min of the three user inputed values          *
*                                                                   *
* Programing Project - Part 3:                                      *
* action: computes the total and average values from user inputs.   *
*         if the user inputs a number that is less than the last    *
*         inputed number, the average and total are computed,       *
*         excluding the value that was less than the previous number*
*                                                                   *
* input: any number                                                 *   
*                                                                   *
* output: The total and average of inputed values up to and not     *
*         including the value that was less than previous inputs    *
*                                                                   *                                                                   *
*********************************************************************
'''

'''NOTE: The lone Print statements exist in the code to add a space between
the different parts of the assignment'''

#part 1

#Declaring all the variables that will be used
counter = 0
total = 0
average = 0
values = 0

#No value is assigned to maximum or minimum. Makes comparisons easier
maximum = None
minimum = None

#Takes in the user input for how many scores they want to enter
user = float(input("Enter the total number of scores: "))
print "Enter the scores:"

'''Loop compares what user enters to the counter. While the counter is less
than what the user enters, it will accept inputs'''
while user > counter:

    #The counter + 1 is for the scores to display correctly (score 1, score 2).
    values = float(input("Score " + str(counter + 1) + " "))

    '''If statements to check the current user input to the last input.
    This determinds whether a value is a max or min'''

    '''Compares min and max to input. If both are none (which they start
    out as), then max = min. The next number the user inputs is compared,
    and the values are set to max or min according to the conditions fulfilled'''
    if values < minimum or minimum is None:
        minimum = values
    if values > maximum or maximum is None:
        maximum = values
    counter+=1
    total+=values

#Calculates average
average = total/counter

#Prints the values
print "The minimum is: " + str(minimum)
print "The maximum is: " + str(maximum)
print "The average is: " + str(average)
print

'''Enter the total number of scores: 4
Enter the scores:
Score 1 10
Score 2 36
Score 3 5.5
Score 4 0.5
The minimum is: 0.5
The maximum is: 36.0
The average is: 13.0
>>> 
Enter the total number of scores: 7
Enter the scores:
Score 1 89
Score 2 78
Score 3 90
Score 4 76
Score 5 70
Score 6 88
Score 7 79
The minimum is: 70.0
The maximum is: 90.0
The average is: 81.4285714286'''

#Part 2

#Takes in user input as floats
first = float(input("Enter the first number: "))
second = float(input("Enter the second number: "))
third = float(input("Enter the third number: "))

#Evaluates if first > second
if first > second:
    #If above is true, evalutes the following conditions
    if first > third:
        if second > third:
            print "The smallest of the values is: " + str(third)
            print "The largest of the values is: " + str(first)
            print
        else:
            print "The smallest of the values is: " + str(second)       
            print "The largest of the values is: " + str(first)
            print
    #If none of the nested statements are true, below condition executes
    else:
        print "The smallest of the values is: " + str(second)
        print "The largest of the values is: " + str(third)
        print
        
#If second > first, following conditions is evaluated        
else:
    if second > third:
        #If above condition is true, evaluates the nested statement
        if third > first:
            print "The smallest of the values is: " + str(first)
            print "The largest of the values is: " + str(second)
            print
        else:
            print "The smallest of the values is: " + str(third)
            print "The largest of the values is: " + str(second)
            print
            
    #If none of the nested statements are true, below condition executes
    else:
            print "The smallest of the values is: " + str(first)
            print "The largest of the values is: " + str(third)
            print

'''Enter the first number: 20.5
Enter the second number: 14.3
Enter the third number: 90.9
The smallest of the values is: 14.3
The largest of the values is: 90.9
>>> 
Enter the first number: 12.5
Enter the second number: 25.75
Enter the third number: 30.8
The smallest of the values is: 12.5
The largest of the values is: 30.8
>>> 
Enter the first number: 55.7
Enter the second number: 30.4
Enter the third number: 34.5
The smallest of the values is: 30.4
The largest of the values is: 55.7
>>>
Enter the first number: 110.2
Enter the second number: 43.5
Enter the third number: 35
The smallest of the values is: 35.0
The largest of the values is: 110.2
'''

#Part 3

#declare variables
counter = 0
lastnumber = 0
total = 0
average = 0

#Prints the prompt
print "Enter the scores: "

'''Input is taken in as a float for more precision. countr + 1 is utlized
to avoid having a second counter for displaying the values in the Score prompt'''
user = float(input("Score " + str(counter + 1) + " "))

'''If the user initially inputs a negative or 0, this statement makes the last number
one less than the user inputs. Otherwise, user is never less than 0 or a negative.
This is only required inititally when the user enters a value'''
lastnumber = user - 1

#Loop compares the user input to the last number inputed.
while user > lastnumber:
    lastnumber = user
    counter += 1
    user = float(input("Score " + str(counter + 1) + " "))
    total+=lastnumber

#Calculates average
average = total/(counter)

#Prints the total and average values
print "The total score is: " + str(total)
print "The average score is: " + str(average)
    
'''Enter the scores: 
Score 1 80
Score 2 89
Score 3 90
Score 4 98
Score 5 100
Score 6 100
The total score is: 457.0
The average score is: 91.4
>>> 
Enter the scores: 
Score 1 30
Score 2 32
Score 3 45
Score 4 47
Score 5 74
Score 6 -1
The total score is: 228.0
The average score is: 45.6
'''


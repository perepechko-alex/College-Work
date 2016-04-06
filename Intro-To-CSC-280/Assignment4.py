'''
*********************************************************************
* CSC 280 - Programming Project 4                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC280_Alex_Perepechko_Assignment4.py          *
* modified from:     CSC 280 Programing Project 4 handout           *
* date last modified: March 5, 2014                                 *
*                                                                   *
* Programing Project 4 - Part 1:                                    *
*                                                                   *
* action: calculates and outputs the sum of whole numbers from 1-N  *
*                                                                   *
* input: the invocation, and the number that the user wishes to find*
         the sum of                                                 *
*                                                                   *
* output: the sum of numbers from 1 to                              *
*                                                                   *
* Programing Project - Part 2:                                      *
*                                                                   *
* action: computes new college tuition from current user-specified  *
          year to a specified target year.                          *
*                                                                   *
* input: current tuition, current year, target year                 *
*                                                                   *
* output: The new tuition of the target year                        *
*********************************************************************
'''

#Part 1

#Function that calculates sum of whole numbers
def SumOfWholeNums(n):
    sums = 0

    '''while n . 0, add n to sums, and then iterate n until it reaches 0.
    e.x n = 4, 4 + 3 + 2 + 1. The n values keep decreasing until it reaches 0,
    at which point the total sum is retearned'''
    #while (n > 0):
    for n in range (n, -1, -1):
        sums = sums + n
        if (n == 0):
            return sums

#main function
def main():

    #invocation of how many times the user wants to find the SumOfWholeNums
    invoc = int(input("How many invocations for SumOfWholeNums(): "))
    counter = 0

    '''Counted loop that keeps prompting for user input and displaying the sum
    until the counter is equal to the invocation amount that the user has entered.
    no need to be counter <= invoc since counter = 0'''
    #while (counter < invoc):
    for counter in range(invoc):
        num = int(input("Enter the value of the function's argument N: "))
        summation = SumOfWholeNums(num)
        print "The sum of numbers from 1 to " + str(num) + " is: " + str(summation)
        
        
#call the main function        
main()

'''
How many invocations for SumOfWholeNums(): 2
Enter the value of the function's argument N: 4
The sum of numbers from 1 to 4 is: 10
Enter the value of the function's argument N: 6
The sum of numbers from 1 to 6 is: 21
'''

#Part 2

#Tuition function
def Tuition(current, thisYear, targetYear):
    '''If the user enters a year that is equal to target year, tuition doesn't
        go up, thus it is whatever the current tuition value is'''
    if (thisYear == targetYear):
        return current

    #Calculate newTuition and return the value
    while (thisYear < targetYear):
        newTuition = (current*1.15)
        current = newTuition
        thisYear+=1
        if (thisYear == targetYear):
            return newTuition

#Main function
def main():
    #Print information for user
    print ""
    print "Tuition predictions at 15% annual increase"
    print ""
    print "At the ?, enter a tuition, the current year, and the target year."
    print "Enter zero in any field to quit."

    #Define variables to be used as arguments; equal to 1 so that user can enter the loop
    tuitionNow = 1
    currentYear = 1
    futureYear = 1
    
    #While none of the user inputs are 0, prompt user for input
    while (tuitionNow !=0 or currentYear !=0 or futureYear !=0):
        tuitionNow = float(input("Tuition?  "))
        currentYear = int(input("Current Year? "))
        futureYear = int(input("Target Year? "))

        '''if the user inputs a variable that doesn't make sense (negatives,
            target year being greater than current year, etc), then display
            a message saying that input is invalid, and prompt user for input'''
        if ((futureYear < currentYear and futureYear != 0) or tuitionNow < 0 or currentYear < 0 or futureYear < 0):
            print "Invalid values, please enter info again."
            tuitionNow = float(input("Tuition?  "))
            currentYear = int(input("Current Year? "))
            futureYear = int(input("Target Year? "))

        #If any of the inputs are 0, get out of the loop and don't calculate newTuition
        if (tuitionNow == 0 or currentYear == 0 or futureYear == 0):
            break

        #Pass arguments and then call Tuition Function for the new tuition
        newerTuition = Tuition(tuitionNow, currentYear, futureYear)
        print "In " + str(futureYear) + ", tuition will be " + str(newerTuition)
        print ""

#Call the main function
main()
'''
Tuition predictions at 15% annual increase

At the ?, enter a tuition, the current year, and the target year.
Enter zero in any field to quit.
Tuition? 4500.00
Current Year? 2013
Target Year? 2017
In 2017, tuition will be 7870.528125

Tuition? 2000.00
Current Year? 2013
Target Year? 2019
In 2019, tuition will be 4626.12153125

Tuition? 12000
Current Year? 2013
Target Year? 2027
In 2027, tuition will be 84908.4691739

Tuition? 0.0
Current Year? 0
Target Year? 0
>>> 
'''

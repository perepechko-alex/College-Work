'''
*********************************************************************
* CSC 280 - Programming Project 5                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC280_Alex_Perepechko_Assignment5.py          *
* modified from:     CSC 280 Programing Project 5 handout           *
* date last modified: March 28, 2014                                *
*                                                                   *
* Programing Project 5 - Part 1:                                    *
*                                                                   *
* action: calculates the total cost of a loan                       *
*                                                                   *
* input: the initial loan amount, the months to pay off the loan,   *
         and the interest rate                                      * 
*                                                                   *
* output: The final cost of the loan                                *
*********************************************************************
'''

#function calculates the cost of the loan
def LoanCost (principal, months, payment):
    princ = principal
    mon = months
    pay = payment
    #call function MonthlyPayment and assigns it to variable monthPay
    monthPay = MonthlyPayment(princ, mon, pay)
    #The value of the MonthlyPayment is used to calculate the final cost
    cost = mon*monthPay-princ
    return cost

#Function calculates how much money is payed per month
def MonthlyPayment (amountOfLoan, numberOfPeriods, yearlyInterestRate):
    rate = yearlyInterestRate
    period = numberOfPeriods
    principal = amountOfLoan
    payment = ((rate/12)/(1-(1+(rate/12))**-period))*principal
    return payment

'''Main function takes in user input and displays prompts, as well as the
final cost of the loan.'''
def main():
    print "Enter the principal payment amount, months to pay, and interest rate (as a percent) as a whole number:"
    loan = float(input("Amount: $"))
    periods = int(input("Months: " ))
    interest = float(input("Interest (%): "))
    interest = interest/100
    monthPay = MonthlyPayment(loan, periods, interest)
    costOfLoan = LoanCost(loan, periods, interest)
    print "The cost of the loan is: " + str(costOfLoan)
    
main()

'''
The cost of the loan is: 306820.759425
The cost of the loan is: 400673.639896
The cost of the loan is: 134325.475925
The cost of the loan is: 340911.954917
'''

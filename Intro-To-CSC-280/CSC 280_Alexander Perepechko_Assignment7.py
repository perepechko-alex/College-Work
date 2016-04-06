'''
*********************************************************************
* CSC 280 - Programming Project 7                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC 280_Alex_Perepechko_Assignment7.py         *
* modified from:     CSC 280 Programing Project 7 handout           *
* date last modified: April 27, 2014                                *
*                                                                   *
* Programing Project 7:                                             *
*                                                                   *
* action: calculates the factorial iteratively and recursively      *
*                                                                   *
* input: the number that user wants to find factorial of            * 
*                                                                   *
* output: the factorial of the value entered, found recursively and *
          iteratively                                               *
*********************************************************************
'''
def FactorialIter(n):
    fact = 1
    while (n>=1):
        fact = fact * n
        n = n - 1
    return fact

def FactorialRecursive(n):
    if (n == 0):
        return 1
    if (n < 0 and n!=-1):
        return "Please enter a positive value!"
    else:
        return n * FactorialRecursive(n-1)

'''
*********************************************************************
* CSC 280 - Programming Project 7                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC 280_Alex_Perepechko_Assignment7.py         *
* modified from:     CSC 280 Programing Project 7 handout           *
* date last modified: April 27, 2014                                *
*                                                                   *
* Programing Project 7:                                             *
*                                                                   *
* action: calculates a multiple of 5 iteratively and recursively    *
*                                                                   *
* input: the number that user wants to find a multiple of 5 of      * 
*                                                                   *
* output: the multiple of 5 that the user has entered, both         *
          iteratively and recursively                               *
*********************************************************************
'''
def MultipleIterative(n):
        return 5*n

def MultipleRecursive(n):
    if (n==0):
        return 0
    else:
        return 5 + MultipleRecursive(n-1)

'''
*********************************************************************
* CSC 280 - Programming Project 7                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC 280_Alex_Perepechko_Assignment7.py         *
* modified from:     CSC 280 Programing Project 7 handout           *
* date last modified: April 27, 2014                                *
*                                                                   *
* Programing Project 7:                                             *
*                                                                   *
* action: calculates the deceremental values iteratively and        *
          recursively by 1                                          *
*                                                                   *
* input: the number that user wants to find decrements of           * 
*                                                                   *
* output: the decremented values all the way to 0, at which point   *
          the string 'great' is displayed                           *
*********************************************************************
'''
def DecrementIter(n):
    for q in range(n, -1, -1):
        if (n<=0):
            print "Great"
        else:
            print n
            n = n - 1
               
def DecrementRecurs(n):
    if (n <= 0):
        return "Great"
    else:
        return n
        n - DecrementRecurs(n-1)

'''
*********************************************************************
* CSC 280 - Programming Project 7                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC 280_Alex_Perepechko_Assignment7.py         *
* modified from:     CSC 280 Programing Project 7 handout           *
* date last modified: April 27, 2014                                *
*                                                                   *
* Programing Project 7:                                             *
*                                                                   *
* action: finds the fibonacci sequence iteratively and recursively  *
*                                                                   *
* input: the number of the fibonacci sequence that the user wants to*
         find the values up to                                      * 
*                                                                   *
* output: the numbers in the fibonacci sequence up to the point that*
          the user entered                                          *
*********************************************************************
'''
#This will return the first n values of the fibonacci sequence
def fibIter(n):
    a = 0
    var1 = 0
    var2 = 1
    list1 = [] 
    while (a < n):
        var3 = var1 + var2
        list1+= [var1]
        var1 = var2
        var2 = var3
        n-=1
    return list1

#This was the easiest way to solve the problem without resorting to using a list
def FibRecurs(n):
   if (n==0):
        return 0
   elif(n == 1):
       return 1
   else:
        return FibRecurs(n-1)+FibRecurs(n-2)

'''
*********************************************************************
* CSC 280 - Programming Project 7                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC 280_Alex_Perepechko_Assignment7.py         *
* modified from:     CSC 280 Programing Project 7 handout           *
* date last modified: April 27, 2014                                *
*                                                                   *
* Programing Project 7:                                             *
*                                                                   *
* action: prints out a string a certain number of times iteratively *
          and recursively                                           *
*                                                                   *
* input: the string, and the number of times the user wants it to be*
         be displayed                                               * 
*                                                                   *
* output: prints out the string n amount of times                   *
*********************************************************************
'''
def PrintStringRecursive(word, n):
    if (n==0):
        return('')
    else:
        return (word)
        PrintStringRecursive(n-1)

def PrintStringIterative(sameWord, n):
    for y in range (n, 0, -1):
        print sameWord

'''
*********************************************************************
* CSC 280 - Programming Project 7                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC 280_Alex_Perepechko_Assignment7.py         *
* modified from:     CSC 280 Programing Project 7 handout           *
* date last modified: April 27, 2014                                *
*                                                                   *
* Programing Project 7:                                             *
*                                                                   *
* action: calls and prints out previous functions                   *
*                                                                   *
* input: the nterms and typeString; the appropriate arguments       * 
*                                                                   *
* output: outputs values and statements for all functions above     *
*********************************************************************
'''
def main():
    nterms = int(raw_input("How many terms? "))
    print "The Factorial of " + str(nterms) + "(recursively) is: " + str(FactorialRecursive(nterms))
    print "The Factorial of " + str(nterms) + "(iteratively) is: " + str(FactorialIter(nterms))

    nterms = int(raw_input("How many terms? "))
    print "The multiple of five for " + str(nterms) + "(recursively) is: "
    for j in range(0, nterms + 1, 1):
        print str(MultipleRecursive(j))
    print "The multiple of five for " + str(nterms) + "(iteratively) is: "
    for a in range(0, nterms + 1, 1):
        print str(MultipleIterative(a))

    nterms = int(raw_input("How many terms? "))
    print "The decremental value of " + str(nterms) + "(recursively) are: "
    for d in range (nterms, -1, -1):
        print str(DecrementRecurs(d))
    print "The decremental value of " + str(nterms) + "(iteratively) are: "
    str(DecrementIter(nterms))

    nterms = int(raw_input("How many terms? "))
    print "The Fibonacci Sequence of " + str(nterms) + "(recursively) is: "
    for i in range (nterms):
        print FibRecurs(i)
    print "The Fibonacci Sequence of " + str(nterms) + "(iteratively) is: " + str(fibIter(nterms))

    typeString = raw_input("Type in a word or phrase: ")
    nterms = int(raw_input("How many terms? "))
    for z in range (nterms, 0, -1):
        print PrintStringRecursive(typeString, nterms)
    print
    PrintStringIterative(typeString, nterms)
main()


'''How many terms? 10
The Factorial of 10(recursively) is: 3628800
The Factorial of 10(iteratively) is: 3628800
How many terms? 10
The multiple of five for 10(recursively) is: 
0
5
10
15
20
25
30
35
40
45
50
The multiple of five for 10(iteratively) is: 
0
5
10
15
20
25
30
35
40
45
50
How many terms? 10
The decremental value of 10(recursively) are: 
10
9
8
7
6
5
4
3
2
1
Great
The decremental value of 10(iteratively) are: 
10
9
8
7
6
5
4
3
2
1
Great
How many terms? 10
The Fibonacci Sequence of 10(recursively) is: 
0
1
1
2
3
5
8
13
21
34
The Fibonacci Sequence of 10(iteratively) is: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
Type in a word or phrase: I love CS
How many terms? 10
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS

I love CS
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS
I love CS'''
    


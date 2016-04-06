'''
*********************************************************************
* CSC 280 - Programming Project 2                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          Assignment2.py                                 *
* modified from:     CSC 280 Programing Project 2 handout           *
* date last modified: February 5, 2014                              *
*                                                                   *
* Programing Project 2 - Part 1:                                    *
*                                                                   *
*  action: computes the area and circumference of a circle          * 
*                                                                   *
* input: the rectangle length and width                             *
*                                                                   *
* output: The rectangle's area and circumference as integers        *
*                                                                   *
* Programing Project - Part 2:                                      *
*                                                                   *
*   action: computes the answers for various mathematical equations *
*                                                                   *
*    input: There is no user input                                  *
*                                                                   *
*     output: the equations and their corresponding answers         *
*                                                                   *
* Programing Project - Part 3:                                      *
*     action: Calculates the area and circumference of a circle     *
*                                                                   *
*     input: the radius                                             *   
*                                                                   *
*     output: the area and circumference of the circle as floating  *             point numbers, along with the appropriate units       *
*                                                                   *                                                                   *
*********************************************************************
'''

#Project 2 - Part 1

#Promt user for input:
print " Enter the dimensions of the rectangle:"
l = int(raw_input("Length: "))
w = int(raw_input("Width: "))

#Compute required results:
a = l*w
c = 2*(l+w)

#Report computations:
print "Area is: " + str(a) + " square units."
print "Circumference is: " + str(c) + " units."

#Creates a space between programs for clearer organization
print

'''
Enter the dimensions of the rectangle:
Length: 4
Width: 6
Area is: 24 square units.
Circumference is: 20 units.
'''

#Project 2 - Part 2

'''a, b, and c all have .0 at the end in order to make them floating points,
otherwise python will do math with them as integers, and you will get a whole
number'''

#Assigns values to variables
a = 10.0
b = 7.0
c = -3.0
t = .0725 
x = 41.5 
y = 5.25 
z = 2.35 

#Computes various equations and outputs the results
print "a) a-b/cb = " + str((a-b)/(c*b))
print "b) (x-y)^3 = " + str((x-y)**3)
print "c) 4z^3+3z^2-6 = " + str((4*(z)**3)+(3*(z)**2)-6)
print "d) 40y+1.5y*(x-40)= " + str(40*(y)+1.5*(y)*(x-40))
print "e) (1+t)*x = " + str((1+t)*x)
print "f) (x+xt-y) = " + str(x+(x*t)-y)

#Creates a space between programs for clearer organization
print

'''
a) a-b/cb = -0.142857142857
b) (x-y)^3 = 47634.765625
c) 4z^3+3z^2-6 = 62.479
d) 40y+1.5y*(x-40) = 221.8125
e) (1+t)*x = 44.50875
f (x+xt-y) = 39.25875
'''

#Project 2 - Part 3

'''Declare the radius of the circle as whatever the user inputs.
Casted as a float so that decimals can be inputed as well'''

rad = float(raw_input("Please enter the radius of a circle: "))

#Declare pi as 3.14
pi = 3.14

#Declare the diamater, which is twice the radius
diam = 2*rad

#Declare the area of the circle
area = pi*(rad**2)

#Declare the cirumference of the circle
circum = pi*diam

#print out the area of the circle with units
print "The area of the circle is " + str(area) + " square units."

#print out the circumference of the circle with units
print "The circumference of the circle is " + str(circum) + " circumference units."

'''
Please enter the radius of a circle: 10
The area of the circle is 314.0 square units.
The circumference of the circle is 62.8 circumference units.
'''

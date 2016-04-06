"""
*********************************************************************
* CSC 280 - Programming Practice #1                                 *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          Assignment1.py                                 *
* modified from:     CSC 280 Proj #1 handout                        *
* date last modified: January 31, 2014                              *
* Part 1:                                                           *
*                                                                   *
*  action: asks for your name and says hello                        * 
*                                                                   *
* input: your name                                                  *
*                                                                   *
* output: Hello, and your name                                      *
*                                                                   *
* Part 2:                                                           *
*                                                                   *
*     action: asks for your name and favorite hobby                 *
*                                                                   *
*    input: name and favorite hobby                                 *
*                                                                   *
*     output: Makes a sentence with your age and your hobby         *
*                                                                   *
* Part 3:                                                           *
*     action: Tells you whether your number is between 1 and 100    *
*                                                                   *
*     input: any number                                             *   
*                                                                   *
*     output: tells you whether your number is between 1 and 100    *
*                                                                   *
* Part 4:                                                           *
*                                                                   *
* action: computes the area and circumference of a rectangle.       *
*                                                                   *
* input: the rectangle's length and then its width, entered by the  *
*        user as prompted for, and given as real numbers.           *
*                                                                   *
* output: the rectangle's area and cifcumference are output to the  *
*         screen, also as real numbers.                             *
*                                                                   *
*********************************************************************
"""

#Part 1
x = raw_input('Bonjour there! What is your name? ')
print "Tres bien, I'm please to meet you, " + x + " -- Merci!"


#Part 2
age = raw_input("How old are you? ")
hobby = raw_input("What is your favorite hobby? ")
print "Really, a " + age + " year old who loves " + hobby + ". That is cool!"

#Part 3
age = raw_input("How old are you? ")
hobby = raw_input("What is your favorite hobby? ")
print "Really, a " + age + " year old who loves " + hobby + ". That is cool!"

#Part 4
"""
*********************************************************************
* CSC 280 - Programming Practice #1                                 *
*                                                                   *
* modifier: PUT YOUR NAME HERE                                      *
*                                                                   *
* filename:          Project_Comment.py                             *
* modified from:     PUT FILENAME YOU USE HERE! (ex: CSCProj1.py)   *                       *
* date last modified: PUT CURRENT DATE HERE!                        *
*                                                                   *
* action: computes the area and circumference of a rectangle.       *
*                                                                   *
* input: the rectangle's length and then its width, entered by the  *
*        user as prompted for, and given as real numbers.           *
*                                                                   *
* output: the rectangle's area and cifcumference are output to the  *
*         screen, also as real numbers.                             *
*                                                                   *
*********************************************************************
"""
print "Enter the dimensions of the rectangle: "
length = int(input("Length: "))
width = int(input("Width: "))
area = length * width
circumference = 2 * (length + width)

print "Area is: " + str(area) + " square units"
print "Circumference is : " + str(circumference) + " circumference units"

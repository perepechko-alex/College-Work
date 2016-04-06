'''
*********************************************************************
* CSC 280 - Programming Project 6                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC280_Alex_Perepechko_Assignment6.py          *
* modified from:     CSC 280 Programing Project 6 handout           *
* date last modified: April 16, 2014                                *
*                                                                   *
* Programing Project 6:                                             *
*                                                                   *
* action: Creates an alphabetical shopping list with items. One list*
*         contains duplicates, the other doesn't. Also shows how    *
*         many instances there are of every item on the list.       *
*                                                                   *
* input: Items that the user wants in the shopping list             * 
*                                                                   *
* output: Alphabetical list (with duplicates), list w/out duplicates*
*         Shows every item and how many of them appear in the       *
*         alphabetical list                                         *
*********************************************************************
'''

'''
*********************************************************************
* CSC 280 - Programming Project 6                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC280_Alex_Perepechko_Assignment6.py          *
* modified from:     CSC 280 Programing Project 6 handout           *
* date last modified: April 16, 2014                                *
*                                                                   *
* Programing Project 6:                                             *
*                                                                   *
* action: Takes in user input and adds it to a list                 *
*                                                                   *
* input: Items that the user wants in the shopping list             * 
*                                                                   *
* output: returns shopList, and SortShopingList calls the function  *
*********************************************************************
'''
#Takes user input for shopping list, and breaks list when nothing is entered
def ShopingList():
    shopList = []
    user = raw_input("Please enter an item (to quit, hit Enter without typing anything in): ")
    while (user != ""):
        shopList += [user]
        user = raw_input("Please enter an item (to quit, hit Enter without typing anything in): ")
        if (user == ""):
            return shopList
            break
'''
*********************************************************************
* CSC 280 - Programming Project 6                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC280_Alex_Perepechko_Assignment6.py          *
* modified from:     CSC 280 Programing Project 6 handout           *
* date last modified: April 16, 2014                                *
*                                                                   *
* Programing Project 6:                                             *
*                                                                   *
* action: Takes in user-entered list and sorts it in alphabetical   *
*         order                                                     *
*                                                                   *
* input: The paramater sortList                                     * 
*                                                                   *
* output: An alphabetical list with duplicates                      *
*********************************************************************
'''
#Uses bubblesort to sort the inputed list in alphabetical order
def SortShopingList(sortlist):
    for n in range (len(sortlist) - 1):
        for m in range (len(sortlist) - n - 1):
            if (sortlist[m] > sortlist[m+1]):
                var1 = sortlist[m]
                sortlist[m] = sortlist[m+1]
                sortlist[m+1] = var1
    return sortlist

'''
*********************************************************************
* CSC 280 - Programming Project 6                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC280_Alex_Perepechko_Assignment6.py          *
* modified from:     CSC 280 Programing Project 6 handout           *
* date last modified: April 16, 2014                                *
*                                                                   *
* Programing Project 6:                                             *
*                                                                   *
* action: Takes alphabetical list and strips it of duplicate items  *
*                                                                   *
* input: The paramater sortedList                                   * 
*                                                                   *
* output: An alphabetical list without duplicates                      *
*********************************************************************
'''
#Strips duplicate items from the alphabetical list and returns a newer list
def StripShopingList(sortedList):
    newList = []
    
    #If element i is in sortedList, but not in newList, append unique item to newList
    for i in sortedList:
        if not i in newList:
            newList.append(i)
    return newList

'''
*********************************************************************
* CSC 280 - Programming Project 6                                   *
*                                                                   *
* modifier: Alex Perepechko                                         *
*                                                                   *
* filename:          CSC280_Alex_Perepechko_Assignment6.py          *
* modified from:     CSC 280 Programing Project 6 handout           *
* date last modified: April 16, 2014                                *
*                                                                   *
* Programing Project 6:                                             *
*                                                                   *
* action: Prints out the alphabetical list, stripped list, and      *
*         how many times each item appears in the alphabetical list *
*                                                                   *
* input: The paramaters alphList and stripList                      * 
*                                                                   *
* output: The alphabetical list, stripped list, and how many times  *
*         every item appears in the list                            *
*********************************************************************
'''
#Report the alphabetical and stripped list, and return how many times an item appears in the list       
def ReportShopingList(alphList, stripList):
    print
    print "Alphabetical List: " + str(alphList)
    print "Alphabetical list without duplicates: " + str(stripList)
    print
    finalList = []
    #For element k in alphabet list, if item is not in finalList, put it in Final List
    for k in alphList:
        if not k in finalList:
            if alphList.count(k) == 1:
                var = 'one'
                print str(k) + " appears in " +  str(var) + " instance(s)"
                finalList.append(k)
            if alphList.count(k) == 2:
                var = 'two'
                print str(k) + " appears in " +  str(var) + " instance(s)"
                finalList.append(k)
            if alphList.count(k) == 3:
                var = 'three'
                print str(k) + " appears in " +  str(var) + " instance(s)"
                finalList.append(k)
            if alphList.count(k) == 4:
                var = 'four'
                print str(k) + " appears in " +  str(var) + " instance(s)"
                finalList.append(k)
            if alphList.count(k) == 5:
                var = 'five'
                print str(k) + " appears in " +  str(var) + " instance(s)"
                finalList.append(k)
    
#Invoke all functions and call the main
def main():
    shopLis = ShopingList()
    alphabetList = SortShopingList(shopLis)
    strip = StripShopingList(alphabetList)
    report = ReportShopingList(alphabetList, strip)
main()

'''
Please enter an item (to quit, hit Enter without typing anything in): A box of milk
Please enter an item (to quit, hit Enter without typing anything in): Turkey
Please enter an item (to quit, hit Enter without typing anything in): Orange
Please enter an item (to quit, hit Enter without typing anything in): Banana
Please enter an item (to quit, hit Enter without typing anything in): Spaghetti
Please enter an item (to quit, hit Enter without typing anything in): Potatoes
Please enter an item (to quit, hit Enter without typing anything in): Lasagna
Please enter an item (to quit, hit Enter without typing anything in): Juice
Please enter an item (to quit, hit Enter without typing anything in): Banana
Please enter an item (to quit, hit Enter without typing anything in): Banana
Please enter an item (to quit, hit Enter without typing anything in): Zucchini bread
Please enter an item (to quit, hit Enter without typing anything in): Turkey
Please enter an item (to quit, hit Enter without typing anything in): Apple
Please enter an item (to quit, hit Enter without typing anything in): Potatoes
Please enter an item (to quit, hit Enter without typing anything in): Zucchini bread
Please enter an item (to quit, hit Enter without typing anything in): 

Alphabetical List: ['A box of milk', 'Apple', 'Banana', 'Banana', 'Banana', 'Juice', 'Lasagna', 'Orange', 'Potatoes', 'Potatoes',
'Spaghetti', 'Turkey', 'Turkey', 'Zucchini bread', 'Zucchini bread']
Alphabetical list without duplicates: ['A box of milk', 'Apple', 'Banana', 'Juice', 'Lasagna', 'Orange', 'Potatoes',
'Spaghetti', 'Turkey', 'Zucchini bread']

A box of milk appears in one instance(s)
Apple appears in one instance(s)
Banana appears in three instance(s)
Juice appears in one instance(s)
Lasagna appears in one instance(s)
Orange appears in one instance(s)
Potatoes appears in two instance(s)
Spaghetti appears in one instance(s)
Turkey appears in two instance(s)
Zucchini bread appears in two instance(s)
'''



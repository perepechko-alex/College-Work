# CSC568_Project1

American University

College of Arts and Sciences

Department of Computer Science

Spring 2015

Generic A* algorithm to be interfaced with Solarus game engine

Authors:

Kevin Gerstein

Adam Lind

Alexander Perepechko

Link to project website: https://sites.google.com/a/student.american.edu/csc568-project1/

Link to GitHub repository: https://github.com/adamlind323/CSC568_Project1

The goal of the project was to create an A* algorithm that would allow Link to navigate from his starting position 
at the beginning of the original Legend of Zelda, all the way to acquiring the Triforce after defeating the boss 
of the first dungeon. The primary objective of the project was in developing an A* algorithm that was efficient and worked. 
Having the algorithm interact with the world of The Legend of Zelda (changed to Solarus, due to it being open-source) 
became secondary, and would only be focused on after implementing the A* code. In the grand scheme of things, our goals 
were met with mixed success. We were able to develop and implement a working, efficient A* algorithm that can interface 
with a given world. However, we were not able to implement A* into Solarus. Instead, we settled on creating our own 
environments to showcase our algorithm and its efficiency.

All files necessary to run this program are included in the repository, and all files must be in the same directory 
in order to run. To run this program on any operating system, C++ compilers must be installed as this program is run 
on command line.

All included files should be:

finalastar.cpp

grid1.txt

grid2.txt

grid3.txt

grid4.txt

To run on MacOS, open terminal, enter the project directory, and enter these commands:


g++ finalastar.cpp -o astar
./astar

The program will then prompt the user to enter which map they would like to see A* executed on, with a choice of 
four different maps. Input an interger value between 1-4, and the program with compute the optimal path for the chosen map.

As with all A* algorithms, ours uses a combinaiton of Dijkstra's algorithm along with Euclidean distance heuristics in 
order to compute the optimal path from start to goal with the smallest time complexity. The general process for our 
algorithm can be found in the method pathFinding(), located at line 265 in astar.cpp. We use a prioity queue to keep track 
of which nodes are the most ideal for traversal with the A* algorithm.

While pathFinding() handles the actual A* algorithm computationally, the components of A* can be found in the node class, 
located at line 111. Within this class, the method for our heuristic measurements can be found in the estimate() method, 
where the Euclidean distance between nodes is caluclated. 

Our modified Dijkstra's algorithm costs are located within the nextCost() method, where nodes are given a traversal cost. 
These two node-to-node measurements are combined in the heuristic() method within the node class in order to give us the 
traversal cost to be used with the A* algorithm. 

In order to compute which node to move to next, we use the boolean operator method to compare the costs between possible 
nodes to traverse, returning whether one of the two inputs nodes on the priority queue has a greater value than the other 
input node.

Our main() method for the program first asks the user to input which map they would like to see A* pathfind on. The program 
then begins to clock how long the algorithm takes to compute the path, returning a graphical representation of the map and 
the path on command line, as long as the amount of time taken to compute the path. The program than automatically terminates, 
and must be run again to see a different map.

Our maps were handwritten in text files, and can only be modified by changing the text file itself. In each map, 0 denotes a 
traversable node, 1 denotes an obstacle, 2 denotes the starting position, and 4 denotes the final position. When the algorithm 
computes the path, a copy of the map is used for computation in the program, and 3 is used to denote the path, overwriting 0s 
in the temporary computational map. To change the start and end positions, 2 and 4 can be changed with any 0 on each map.

For any questions, comments, or concerns, please contact us:

Kevin Gerstein <kg1941a@student.american.edu>

Adam Lind <al3133a@student.american.edu>

Alexander Perepechko <ap1109a@student.american.edu>

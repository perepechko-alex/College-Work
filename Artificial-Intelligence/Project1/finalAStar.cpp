/**
 * @file
 * @author  Adam Lind <al3133a@student.american.edu>
 * @author  Kevin Gerstein <kg1941a@student.american.edu>
 * @author  Alexander Perepechko <email@student.american.edu>
 * @version 1.0
 *
 * @section LICENSE
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details at
 * https://www.gnu.org/copyleft/gpl.html
 *
 * @section DESCRIPTION
 *
 * This program pathfinds using a generic A* algorithm.
 */

#include <iostream>
#include <fstream>
#include <iomanip>
#include <queue>
#include <string>
#include <math.h>
#include <ctime>
#include <cstdlib>
#include <stdio.h>
using namespace std;

//grid dimensions
const int WIDTH = 100;
const int HEIGHT = 100;

//2x2 grids
static int grid[WIDTH][HEIGHT];
static int directionGrid[WIDTH][HEIGHT];

//general map.
static int map[WIDTH][HEIGHT];

//Open and closed lists
static int oList[WIDTH][HEIGHT];
static int cList[WIDTH][HEIGHT];

//How you are moving along the grid.
//Starts directly right, then goes clockwise.
//8 different directions.
const int d = 8;
static int directions[WIDTH][HEIGHT];
static int dx[d] = {1, 1, 0, -1, -1, -1, 0, 1};
static int dy[d] = {0, 1, 1, 1, 0, -1, -1, -1};

static string lines[10];

static int xA, yA;
static int xB, yB;

/*
*Gets the map to be used for the A* algorithm.
*@param filename the file containing the map to be used.
*/
void getMap(string filename)
{
	string templine, tempnode;
	int intnode;
	ifstream mapfile;
	mapfile.open(filename, ios::in);

	for(int y = 0; y < 100; y++)
	{
		getline(mapfile, templine);

		for(int x = 0; x < 100; x++)
		{
			tempnode = templine.substr(x, 1); //Slice grid string character by character
			intnode = stoi(tempnode);

			//Setting the start node.
			if(intnode == 2)
			{
				xA = x;
				yA = y;
				map[x][y] = intnode;
			}

			//Setting the goal node.
			else if(intnode == 4)
			{
				xB = x;
				yB = y;
				map[x][y] = intnode;
			}
			//Save other nodes
			else
			{
				map[x][y] = intnode;
			}
		}
	}
	mapfile.close();
}


class node
{
	//the position currently
	int xPos;
	int yPos;

	//The values for A* to use.
	int cost;
	int heuristic;

	public:

		/**
		* Constructor that sets the x,y positions,
		* the cost, and the heuristic estimate.
		* @param x the x position of the node.
		* @param y the y position of the node.
		* @param gX the actual physical cost of the node.
		* @param hX the estimate of the cost from node to goal.
		*/
		node(int x, int y, int gX, int hX)
		{
			xPos = x;
			yPos = y;
			cost = gX;
			heuristic = hX;
		}

		/**
		* Gets the x position.
		*
		* @returns the x position.
		*/
		int getXPos() const
		{
			return xPos;
		}

		/*
		* Gets the y position.
		*
		* @returns the y position.
		*/
		int getYPos() const
		{
			return yPos;
		}

		/*
		* Gets the cost.
		*
		* @returns the cost.
		*/
		int getCost() const
		{
			return cost;
		}

		/*
		* Get the heuristic estimate.
		*
		* @returns the heuristic estimate.
		*/
		int getHeuristic() const
		{
			return heuristic;
		}

		/**
		* Calculates the euclidean distance of node from goal.
		* @param xF the goal's x position.
		* @paran yF the goal's y position
		*
		* @return distance calculated through distance formula.
		*/
		const int& estimate(const int& xF, const int& yF) const
		{
			static int xDist, yDist, distance;

			//Caclulates x and y distances.
			xDist = xF - xPos;
			yDist = yF - yPos;

			//Heuristic Estimate
			//Euclidian Distance
			distance = static_cast<int>(sqrt(xDist*xDist + yDist*yDist));

			return distance;

		}

		/**
		* Get cost + heuristic
		*
		* @param xFinal is the goal's x position
		* @param yFinal is the goal's y position
		*
		*/
		void totalCost(const int& xFinal, const int& yFinal)
		{
			heuristic = cost + estimate(xFinal, yFinal);
		}

		/**
		* Function exists to give going straight
		* priority over diagonal.
		*
		* @param dir the direction of path.
		*
		*/
		void nextCost(const int& dir)
		{
			// This assigns a higher cost of going
			// diagonal than going straight.
			if(d == 8)
			{
				if(dir % 2 == 0)
					cost += 10;
				else
					cost += 14;
			}
			else
				cost += 10;
		}

};

/**
* Gets the node with the lowest cost in the priority queue.
*
* @param a is a node in the priority queue.
* @param b is a node in the priority queue.
*
* @return Returns if a or b has "priority".
*/
bool operator<(const node& a, const node& b)
{
	//Poorly Labeled tbh.
	//This is actually the total cost on the open list.
	return a.getHeuristic() > b.getHeuristic();
}


/**
* Gets the path from the start node to the goal node.
*
* @param xFirst is the starting node's x position.
* @param yFirst is the starting node's y position.
* @param xLast is the starting node's x position.
* @param yLast is the starting node's y position.
*
* @return the path generated. If no path,
*  returns an empty path.
*/
string pathFinding(const int& xFirst, const int& yFirst,const int& xLast,const int& yLast)
{
	//This is the open list!
	static priority_queue<node> hQ[2];
	static int index; //heuristic queue index.
	static node* n1;
	static node* n2;
	static int i, j, x, y, xdx, ydy;
	static char c;
	index = 0;

	//0 the node map.
	for(y=0;y<HEIGHT;y++)
	{
		for(x=0;x<WIDTH;x++)
		{
			oList[x][y] = 0;
			cList[x][y] = 0;
		}
	}

	//Making the starting node and placing it in open list.
	n1 = new node(xFirst, yFirst, 0, 0);
	n1->totalCost(xLast, yLast);
	hQ[index].push(*n1);
	oList[x][y]=n1->getHeuristic();

	//The search
	while(!hQ[index].empty())
	{
		n1 = new node( hQ[index].top().getXPos(), hQ[index].top().getYPos(), hQ[index].top().getCost(), hQ[index].top().getHeuristic());

		x = n1->getXPos();
		y = n1->getYPos();


		//Remove the node from the Open list.
		hQ[index].pop();
		oList[x][y] = 0;

		//marking it on the closed list.
		cList[x][y] = 1;



		//End the search when we reach goal.
		if(x == xLast && y == yLast)
		{
			//Create the path between the nodes.
			//The optimal path.
			string path = "";

			//Create the path from the end to the beginning
			while(!(x == xFirst && y == yFirst))
			{
				j = directions[x][y];
				c='0' + (j + d/2)%d;
				path = c + path;
				x += dx[j];
				y += dy[j];
			}

			//Some garbage collection
			delete n1;

			while(!hQ[index].empty())
			{
				hQ[index].pop();
			}

			return path;
		}


		//Generate moves aka the child nodes in all possible directions.
		for(i=0;i<d;i++)
		{
			//Changes in x and y.
			xdx = x + dx[i];
			ydy = y + dy[i];

			if(!(xdx < 0 || xdx > WIDTH - 1 || ydy < 0 || ydy > HEIGHT - 1 || map[xdx][ydy] == 1 || cList[xdx][ydy] == 1))
			{
						n2 = new node(xdx, ydy, n1->getCost(), n1->getHeuristic());
						n2->nextCost(i);
						n2->totalCost(xLast, yLast);

						//add top open list if not yet there.
						if(oList[xdx][ydy] == 0)
						{
							oList[xdx][ydy] = n2->getHeuristic();
							hQ[index].push(*n2);

							//keep track of its parent node direction.
							directions[xdx][ydy] = (i + d/2)%d;
						}
						else if(oList[xdx][ydy] > n2->getHeuristic())
						{
							oList[xdx][ydy] = n2->getHeuristic();

							//update parent direction
							directions[xdx][ydy] = (i + d/2)%d;

							//Replace node by emptying one hQ to another one.
							//node to be replaced will be ignored
							//and new node will be pushed in instead.
								//change comment
							while(!(hQ[index].top().getXPos() == xdx && hQ[index].top().getYPos() == ydy))
							{
								hQ[1 - index].push(hQ[index].top());
								hQ[index].pop();
							}

							hQ[index].pop(); //remove wanted node
							if(hQ[index].size() > hQ[1-index].size())
								{
								while(!hQ[index].empty())
									{
									hQ[1-index].push(hQ[index].top());
									hQ[index].pop();
									}
								}

							index = 1 - index;
							hQ[index].push(*n2);
						}
						else delete n2;


			}

		}

		delete n1;


	}
	return ""; // no path found
}

int main()
{
	srand(time(NULL));

	/**
	 * Check to see which map the user wants to see.
	 * Loop will onlt terminate on valid integer selection.
	 *
	 * @param mapCheck boolean for loop termination
	 *
	 * @param gint Saves the integer user input for selecting map.
	 */
	bool mapCheck = true;
	while(mapCheck)
	{
		int gint;
		cout << "Please select which grid to use (1, 2, 3, or 4): " << endl;
		cin >> gint;
		if (gint == 1)
		{
			getMap("grid1.txt");
			mapCheck = false;
		}
		else if (gint == 2)
		{
			getMap("grid2.txt");
			mapCheck = false;
		}
		else if (gint == 3)
		{
			getMap("grid3.txt");
			mapCheck = false;
		}
		else if (gint == 4)
		{
			getMap("grid4.txt");
			mapCheck = false;
		}
		else
		{
			cout << "Invalid selection. Please enter a valid integer between 1-4." << endl;
		}
	}

	//Read in the maps to be used.
	//getMap("grid3.txt");

	cout<<"The Map's dimensions are " << WIDTH << "x" << HEIGHT << endl;
	cout << "The starting node is located at: " << xA << ", " << yA << endl;
	cout << "The goal node is located at: " << xB << ", " << yB << endl;

	//Retrieve the path.
	clock_t start = clock();

	string route = pathFinding(xA, yA, xB, yB);
	if(route == "")
		cout << "An empty route has been created" << endl;

	clock_t end = clock();
	double timeElapsed = double (end - start);

	cout << "The time to calculate the route in milliseconds was: " << timeElapsed << endl;
	cout << "route" << endl;
	cout << route << endl;

	//Follow the route on the map and display it
	if(route.length() > 0)
	{
		cout << "in route " << endl;
		int j;
		char c;
		int x = xA;
		int y = yA;
		map[x][y] = 2;

		for(int i = 0;i < route.length(); i++)
		{
			c=route.at(i);
			j=atoi(&c);
			x = x + dx[j];
			y = y + dy[j];
			map[x][y] = 3;
		}

		map[x][y] = 4;

		//Display the grid and path on command line
		for(int y=0; y<HEIGHT;y++)
		{
			for(int x=0; x<WIDTH;x++)
			{

				if(map[x][y] == 0)
					cout << "\033[1;37m-\033[0m"; //empty (Gray)
				else if(map[x][y] == 1)
					cout << "\033[1;40m|\033[0m";//obstacle (Black background)
				else if(map[x][y] == 2)
					cout << "\033[1;34mS\033[0m"; //start (Blue)
				else if(map[x][y] == 3)
					cout << "\033[1;31m+\033[0m"; //path  (Red)
				else if(map[x][y] == 4)
					cout << "\033[1;36mG\033[0m"; //goal  (Cyan)
			}

			cout << endl;
		}
	}
	getchar();
	return(0);
}

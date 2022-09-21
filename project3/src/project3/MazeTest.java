package project3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class MazeTest 
{
	//4x4Test
	String expected4x4 = 
			  "DFS\n"
			  + "(0,0)\n"
			  + "(0,1)\n"
			  + "(1,1)\n"
			  + "(2,1)\n"
			  + "(2,0)\n"
			  + "(3,0)\n"
			  + "(3,1)\n"
			  + "(3,2)\n"
			  + "(2,2)\n"
			  + "(1,2)\n"
			  + "(0,2)\n"
			  + "(0,3)\n"
			  + "(1,3)\n"
			  + "(2,3)\n"
			  + "(3,3)\n"
			  + "BFS\n"
			  + "(0,0)\n"
			  + "(0,1)\n"
			  + "(1,1)\n"
			  + "(2,1)\n"
			  + "(2,0)\n"
			  + "(1,0)\n"
			  + "(3,0)\n"
			  + "(3,1)\n"
			  + "(3,2)\n"
			  + "(2,2)\n"
			  + "(1,2)\n"
			  + "(0,2)\n"
			  + "(0,3)\n"
			  + "(1,3)\n"
			  + "(2,3)\n"
			  + "(3,3)\n"
			  + "\n"
			  + "Empty Maze:\n"
			  + "+ +-+-+-+\n"
			  + "|   |   |\n"
			  + "+-+ + + +\n"
			  + "| | | | |\n"
			  + "+ + + + +\n"
			  + "|   | | |\n"
			  + "+ +-+ + +\n"
			  + "|     | |\n"
			  + "+-+-+-+ +\n"
			  + "\n"
			  + "DFS Solution:\n"
			  + "+ +-+-+-+\n"
			  + "|1 2|2 3|\n"
			  + "+-+ + + +\n"
			  + "|6|3|1|4|\n"
			  + "+ + + + +\n"
			  + "|5 4|0|5|\n"
			  + "+ +-+ + +\n"
			  + "|7 8 9|6|\n"
			  + "+-+-+-+ +\n"
			  + "+ +-+-+-+\n"
			  + "|# #|# #|\n"
			  + "+-+ + + +\n"
			  + "| |#|#|#|\n"
			  + "+ + + + +\n"
			  + "|# #|#|#|\n"
			  + "+ +-+ + +\n"
			  + "|# # #|#|\n"
			  + "+-+-+-+ +\n"
			  + "\n"
			  + "BFS Solution:\n"
			  + "+ +-+-+-+\n"
			  + "|1 2|2 3|\n"
			  + "+-+ + + +\n"
			  + "|6|3|1|4|\n"
			  + "+ + + + +\n"
			  + "|5 4|0|5|\n"
			  + "+ +-+ + +\n"
			  + "|7 8 9|6|\n"
			  + "+-+-+-+ +\n"
			  + "+ +-+-+-+\n"
			  + "|# #|# #|\n"
			  + "+-+ + + +\n"
			  + "| |#|#|#|\n"
			  + "+ + + + +\n"
			  + "|# #|#|#|\n"
			  + "+ +-+ + +\n"
			  + "|# # #|#|\n"
			  + "+-+-+-+ +";
	
	@Test
	void test4x4Maze() 
	{
		String actual = "";
		Maze maze = new Maze(4);
        maze.generateMaze();
        MazeSolver solver = new MazeSolver();
        Stack<Cell> cellStack = new Stack<Cell>();
        Queue<Cell> cellQueue = new LinkedList<Cell>();
        ArrayList<Cell> DFSresults = solver.DFS(maze, maze.getCells()[0][0], cellStack);
        maze.resetVisitedValues();
        ArrayList<Cell> BFSresults = solver.BFS(maze, maze.getCells()[0][0], cellQueue);
        
        actual += "DFS\n";
        for (Cell cell : cellStack)
        	actual += cell + "\n";
        actual += "BFS\n";
        for (Cell cell : BFSresults)
        	actual += cell + "\n";
        actual += "\n";
        actual += "Empty Maze:\n";
        actual += maze.printMaze(maze.getCells()) + "\n\n";      
        actual += "DFS Solution:\n";
        actual += maze.printMaze(maze.getCells(), true, true, DFSresults) + "\n";
        actual += maze.printMaze(maze.getCells(), true, false, DFSresults) + "\n\n";       
        actual += "BFS Solution:\n";
        actual += maze.printMaze(maze.getCells(), true, true, BFSresults) + "\n";
        actual += maze.printMaze(maze.getCells(), true, false, BFSresults);
        assertEquals(expected4x4, actual);
	}

	
	
	
	
	
	
	
	
	//6x6 Test
	String expected6x6 = "DFS\n"
			+ "(0,0)\n"
			+ "(0,1)\n"
			+ "(1,1)\n"
			+ "(2,1)\n"
			+ "(2,0)\n"
			+ "(3,0)\n"
			+ "(3,1)\n"
			+ "(3,2)\n"
			+ "(4,2)\n"
			+ "(4,3)\n"
			+ "(4,4)\n"
			+ "(3,4)\n"
			+ "(3,3)\n"
			+ "(2,3)\n"
			+ "(2,4)\n"
			+ "(1,4)\n"
			+ "(1,3)\n"
			+ "(1,2)\n"
			+ "(0,2)\n"
			+ "(0,3)\n"
			+ "(0,4)\n"
			+ "(0,5)\n"
			+ "(1,5)\n"
			+ "(2,5)\n"
			+ "(3,5)\n"
			+ "(4,5)\n"
			+ "(5,5)\n"
			+ "BFS\n"
			+ "(0,0)\n"
			+ "(0,1)\n"
			+ "(1,1)\n"
			+ "(2,1)\n"
			+ "(2,0)\n"
			+ "(1,0)\n"
			+ "(3,0)\n"
			+ "(3,1)\n"
			+ "(3,2)\n"
			+ "(4,2)\n"
			+ "(4,3)\n"
			+ "(4,4)\n"
			+ "(3,4)\n"
			+ "(3,3)\n"
			+ "(2,3)\n"
			+ "(2,4)\n"
			+ "(1,4)\n"
			+ "(1,3)\n"
			+ "(1,2)\n"
			+ "(0,2)\n"
			+ "(2,2)\n"
			+ "(0,3)\n"
			+ "(0,4)\n"
			+ "(0,5)\n"
			+ "(1,5)\n"
			+ "(2,5)\n"
			+ "(3,5)\n"
			+ "(4,5)\n"
			+ "(5,5)\n"
			+ "(5,5)\n"
			+ "\n"
			+ "Empty Maze:\n"
			+ "+ +-+-+-+-+-+\n"
			+ "|   |       |\n"
			+ "+-+ + +-+-+ +\n"
			+ "| | |     | |\n"
			+ "+ + + +-+ + +\n"
			+ "|   | |   | |\n"
			+ "+ +-+-+ +-+ +\n"
			+ "|     |   | |\n"
			+ "+-+-+ +-+ + +\n"
			+ "|   |     | |\n"
			+ "+ +-+-+-+-+ +\n"
			+ "|           |\n"
			+ "+-+-+-+-+-+ +\n"
			+ "\n"
			+ "DFS Solution:\n"
			+ "+ +-+-+-+-+-+\n"
			+ "|1 2|0 2 3 4|\n"
			+ "+-+ + +-+-+ +\n"
			+ "|6|3|9 8 7|5|\n"
			+ "+ + + +-+ + +\n"
			+ "|5 4| |5 6|6|\n"
			+ "+ +-+-+ +-+ +\n"
			+ "|7 8 9|4 3|7|\n"
			+ "+-+-+ +-+ + +\n"
			+ "|   |0 1 2|8|\n"
			+ "+ +-+-+-+-+ +\n"
			+ "|          9|\n"
			+ "+-+-+-+-+-+ +\n"
			+ "+ +-+-+-+-+-+\n"
			+ "|# #|# # # #|\n"
			+ "+-+ + +-+-+ +\n"
			+ "| |#|# # #|#|\n"
			+ "+ + + +-+ + +\n"
			+ "|# #| |# #|#|\n"
			+ "+ +-+-+ +-+ +\n"
			+ "|# # #|# #|#|\n"
			+ "+-+-+ +-+ + +\n"
			+ "|   |# # #|#|\n"
			+ "+ +-+-+-+-+ +\n"
			+ "|          #|\n"
			+ "+-+-+-+-+-+ +\n"
			+ "\n"
			+ "BFS Solution:\n"
			+ "+ +-+-+-+-+-+\n"
			+ "|1 2|0 2 3 4|\n"
			+ "+-+ + +-+-+ +\n"
			+ "|6|3|9 8 7|5|\n"
			+ "+ + + +-+ + +\n"
			+ "|5 4|1|5 6|6|\n"
			+ "+ +-+-+ +-+ +\n"
			+ "|7 8 9|4 3|7|\n"
			+ "+-+-+ +-+ + +\n"
			+ "|   |0 1 2|8|\n"
			+ "+ +-+-+-+-+ +\n"
			+ "|          9|\n"
			+ "+-+-+-+-+-+ +\n"
			+ "+ +-+-+-+-+-+\n"
			+ "|# #|# # # #|\n"
			+ "+-+ + +-+-+ +\n"
			+ "| |#|# # #|#|\n"
			+ "+ + + +-+ + +\n"
			+ "|# #| |# #|#|\n"
			+ "+ +-+-+ +-+ +\n"
			+ "|# # #|# #|#|\n"
			+ "+-+-+ +-+ + +\n"
			+ "|   |# # #|#|\n"
			+ "+ +-+-+-+-+ +\n"
			+ "|          #|\n"
			+ "+-+-+-+-+-+ +";
	@Test
	void test6x6Maze() 
	{
		String actual = "";
		Maze maze = new Maze(6);
        maze.generateMaze();
        MazeSolver solver = new MazeSolver();
        Stack<Cell> cellStack = new Stack<Cell>();
        Queue<Cell> cellQueue = new LinkedList<Cell>();
        ArrayList<Cell> DFSresults = solver.DFS(maze, maze.getCells()[0][0], cellStack);
        maze.resetVisitedValues();
        ArrayList<Cell> BFSresults = solver.BFS(maze, maze.getCells()[0][0], cellQueue);
        
        actual += "DFS\n";
        for (Cell cell : cellStack)
        	actual += cell + "\n";
        actual += "BFS\n";
        for (Cell cell : BFSresults)
        	actual += cell + "\n";
        actual += "\n";
        actual += "Empty Maze:\n";
        actual += maze.printMaze(maze.getCells()) + "\n\n";      
        actual += "DFS Solution:\n";
        actual += maze.printMaze(maze.getCells(), true, true, DFSresults) + "\n";
        actual += maze.printMaze(maze.getCells(), true, false, DFSresults) + "\n\n";       
        actual += "BFS Solution:\n";
        actual += maze.printMaze(maze.getCells(), true, true, BFSresults) + "\n";
        actual += maze.printMaze(maze.getCells(), true, false, BFSresults);
        assertEquals(expected6x6, actual);
	}
	
	
	
	
	
	
	
	//8x8Test
	String expected8x8 = "DFS\n"
			+ "(0,0)\n"
			+ "(0,1)\n"
			+ "(1,1)\n"
			+ "(2,1)\n"
			+ "(2,0)\n"
			+ "(3,0)\n"
			+ "(3,1)\n"
			+ "(3,2)\n"
			+ "(4,2)\n"
			+ "(4,3)\n"
			+ "(4,4)\n"
			+ "(3,4)\n"
			+ "(3,3)\n"
			+ "(2,3)\n"
			+ "(2,4)\n"
			+ "(1,4)\n"
			+ "(1,3)\n"
			+ "(1,2)\n"
			+ "(0,2)\n"
			+ "(0,3)\n"
			+ "(0,4)\n"
			+ "(0,5)\n"
			+ "(0,6)\n"
			+ "(0,7)\n"
			+ "(1,7)\n"
			+ "(2,7)\n"
			+ "(2,6)\n"
			+ "(2,5)\n"
			+ "(3,5)\n"
			+ "(3,6)\n"
			+ "(4,6)\n"
			+ "(5,6)\n"
			+ "(5,7)\n"
			+ "(6,7)\n"
			+ "(6,6)\n"
			+ "(7,6)\n"
			+ "(7,7)\n"
			+ "BFS\n"
			+ "(0,0)\n"
			+ "(0,1)\n"
			+ "(1,1)\n"
			+ "(2,1)\n"
			+ "(2,0)\n"
			+ "(1,0)\n"
			+ "(3,0)\n"
			+ "(3,1)\n"
			+ "(3,2)\n"
			+ "(4,2)\n"
			+ "(4,3)\n"
			+ "(4,4)\n"
			+ "(3,4)\n"
			+ "(3,3)\n"
			+ "(2,3)\n"
			+ "(2,4)\n"
			+ "(1,4)\n"
			+ "(1,3)\n"
			+ "(1,2)\n"
			+ "(0,2)\n"
			+ "(2,2)\n"
			+ "(0,3)\n"
			+ "(0,4)\n"
			+ "(0,5)\n"
			+ "(0,6)\n"
			+ "(0,7)\n"
			+ "(1,7)\n"
			+ "(2,7)\n"
			+ "(2,6)\n"
			+ "(2,5)\n"
			+ "(1,5)\n"
			+ "(3,5)\n"
			+ "(1,6)\n"
			+ "(3,6)\n"
			+ "(4,6)\n"
			+ "(5,6)\n"
			+ "(5,7)\n"
			+ "(4,7)\n"
			+ "(6,7)\n"
			+ "(3,7)\n"
			+ "(6,6)\n"
			+ "(7,6)\n"
			+ "(7,7)\n"
			+ "(7,7)\n"
			+ "\n"
			+ "Empty Maze:\n"
			+ "+ +-+-+-+-+-+-+-+\n"
			+ "|   |           |\n"
			+ "+-+ + +-+-+-+-+ +\n"
			+ "| | |     |   | |\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "|   | |   |     |\n"
			+ "+ +-+-+ +-+ +-+-+\n"
			+ "|     |   |   | |\n"
			+ "+-+-+ +-+ +-+ + +\n"
			+ "|   |     | | | |\n"
			+ "+ + +-+-+-+ + + +\n"
			+ "| |   |     |   |\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "| | |     | |   |\n"
			+ "+ + +-+-+-+-+ +-+\n"
			+ "| |             |\n"
			+ "+-+-+-+-+-+-+-+ +\n"
			+ "\n"
			+ "DFS Solution:\n"
			+ "+ +-+-+-+-+-+-+-+\n"
			+ "|1 2|0 2 3 4 5 6|\n"
			+ "+-+ + +-+-+-+-+ +\n"
			+ "|6|3|9 8 7|1 3|7|\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "|5 4| |5 6|0 9 8|\n"
			+ "+ +-+-+ +-+ +-+-+\n"
			+ "|7 8 9|4 3|2 4|0|\n"
			+ "+-+-+ +-+ +-+ + +\n"
			+ "|   |0 1 2| |5|8|\n"
			+ "+ + +-+-+-+ + + +\n"
			+ "| |   |     |6 7|\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "| | |     | |1 9|\n"
			+ "+ + +-+-+-+-+ +-+\n"
			+ "| |          2 3|\n"
			+ "+-+-+-+-+-+-+-+ +\n"
			+ "+ +-+-+-+-+-+-+-+\n"
			+ "|# #|# # # # # #|\n"
			+ "+-+ + +-+-+-+-+ +\n"
			+ "| |#|# # #|   |#|\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "|# #| |# #|# # #|\n"
			+ "+ +-+-+ +-+ +-+-+\n"
			+ "|# # #|# #|# #| |\n"
			+ "+-+-+ +-+ +-+ + +\n"
			+ "|   |# # #| |#| |\n"
			+ "+ + +-+-+-+ + + +\n"
			+ "| |   |     |# #|\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "| | |     | |# #|\n"
			+ "+ + +-+-+-+-+ +-+\n"
			+ "| |          # #|\n"
			+ "+-+-+-+-+-+-+-+ +\n"
			+ "\n"
			+ "BFS Solution:\n"
			+ "+ +-+-+-+-+-+-+-+\n"
			+ "|1 2|0 2 3 4 5 6|\n"
			+ "+-+ + +-+-+-+-+ +\n"
			+ "|6|3|9 8 7|1 3|7|\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "|5 4|1|5 6|0 9 8|\n"
			+ "+ +-+-+ +-+ +-+-+\n"
			+ "|7 8 9|4 3|2 4|0|\n"
			+ "+-+-+ +-+ +-+ + +\n"
			+ "|   |0 1 2| |5|8|\n"
			+ "+ + +-+-+-+ + + +\n"
			+ "| |   |     |6 7|\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "| | |     | |1 9|\n"
			+ "+ + +-+-+-+-+ +-+\n"
			+ "| |          2 3|\n"
			+ "+-+-+-+-+-+-+-+ +\n"
			+ "+ +-+-+-+-+-+-+-+\n"
			+ "|# #|# # # # # #|\n"
			+ "+-+ + +-+-+-+-+ +\n"
			+ "| |#|# # #|   |#|\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "|# #| |# #|# # #|\n"
			+ "+ +-+-+ +-+ +-+-+\n"
			+ "|# # #|# #|# #| |\n"
			+ "+-+-+ +-+ +-+ + +\n"
			+ "|   |# # #| |#| |\n"
			+ "+ + +-+-+-+ + + +\n"
			+ "| |   |     |# #|\n"
			+ "+ + + +-+ + +-+ +\n"
			+ "| | |     | |# #|\n"
			+ "+ + +-+-+-+-+ +-+\n"
			+ "| |          # #|\n"
			+ "+-+-+-+-+-+-+-+ +";
	@Test
	void test8x8Maze() 
	{
		String actual = "";
		Maze maze = new Maze(8);
        maze.generateMaze();
        MazeSolver solver = new MazeSolver();
        Stack<Cell> cellStack = new Stack<Cell>();
        Queue<Cell> cellQueue = new LinkedList<Cell>();
        ArrayList<Cell> DFSresults = solver.DFS(maze, maze.getCells()[0][0], cellStack);
        maze.resetVisitedValues();
        ArrayList<Cell> BFSresults = solver.BFS(maze, maze.getCells()[0][0], cellQueue);
        
        actual += "DFS\n";
        for (Cell cell : cellStack)
        	actual += cell + "\n";
        actual += "BFS\n";
        for (Cell cell : BFSresults)
        	actual += cell + "\n";
        actual += "\n";
        actual += "Empty Maze:\n";
        actual += maze.printMaze(maze.getCells()) + "\n\n";      
        actual += "DFS Solution:\n";
        actual += maze.printMaze(maze.getCells(), true, true, DFSresults) + "\n";
        actual += maze.printMaze(maze.getCells(), true, false, DFSresults) + "\n\n";       
        actual += "BFS Solution:\n";
        actual += maze.printMaze(maze.getCells(), true, true, BFSresults) + "\n";
        actual += maze.printMaze(maze.getCells(), true, false, BFSresults);
        assertEquals(expected8x8, actual);
	}
	
	
	
	
	
	
	
	
	
	//10x10 Test
	String expected10x10 ="DFS\n"
			+ "(0,0)\n"
			+ "(0,1)\n"
			+ "(1,1)\n"
			+ "(2,1)\n"
			+ "(2,0)\n"
			+ "(3,0)\n"
			+ "(3,1)\n"
			+ "(3,2)\n"
			+ "(4,2)\n"
			+ "(4,3)\n"
			+ "(4,4)\n"
			+ "(3,4)\n"
			+ "(3,3)\n"
			+ "(2,3)\n"
			+ "(2,4)\n"
			+ "(1,4)\n"
			+ "(1,3)\n"
			+ "(1,2)\n"
			+ "(0,2)\n"
			+ "(0,3)\n"
			+ "(0,4)\n"
			+ "(0,5)\n"
			+ "(0,6)\n"
			+ "(0,7)\n"
			+ "(1,7)\n"
			+ "(1,8)\n"
			+ "(1,9)\n"
			+ "(2,9)\n"
			+ "(2,8)\n"
			+ "(2,7)\n"
			+ "(3,7)\n"
			+ "(4,7)\n"
			+ "(4,8)\n"
			+ "(3,8)\n"
			+ "(3,9)\n"
			+ "(4,9)\n"
			+ "(5,9)\n"
			+ "(5,8)\n"
			+ "(5,7)\n"
			+ "(5,6)\n"
			+ "(4,6)\n"
			+ "(4,5)\n"
			+ "(5,5)\n"
			+ "(5,4)\n"
			+ "(5,3)\n"
			+ "(6,3)\n"
			+ "(6,2)\n"
			+ "(6,1)\n"
			+ "(5,1)\n"
			+ "(4,1)\n"
			+ "(4,0)\n"
			+ "(5,0)\n"
			+ "(6,0)\n"
			+ "(7,0)\n"
			+ "(8,0)\n"
			+ "(9,0)\n"
			+ "(9,1)\n"
			+ "(9,2)\n"
			+ "(8,2)\n"
			+ "(8,1)\n"
			+ "(7,1)\n"
			+ "(7,2)\n"
			+ "(7,3)\n"
			+ "(7,4)\n"
			+ "(7,5)\n"
			+ "(6,5)\n"
			+ "(6,6)\n"
			+ "(7,6)\n"
			+ "(8,6)\n"
			+ "(9,6)\n"
			+ "(9,7)\n"
			+ "(9,8)\n"
			+ "(9,9)\n"
			+ "BFS\n"
			+ "(0,0)\n"
			+ "(0,1)\n"
			+ "(1,1)\n"
			+ "(2,1)\n"
			+ "(2,0)\n"
			+ "(1,0)\n"
			+ "(3,0)\n"
			+ "(3,1)\n"
			+ "(3,2)\n"
			+ "(4,2)\n"
			+ "(4,3)\n"
			+ "(4,4)\n"
			+ "(3,4)\n"
			+ "(3,3)\n"
			+ "(2,3)\n"
			+ "(2,4)\n"
			+ "(1,4)\n"
			+ "(1,3)\n"
			+ "(1,2)\n"
			+ "(0,2)\n"
			+ "(2,2)\n"
			+ "(0,3)\n"
			+ "(0,4)\n"
			+ "(0,5)\n"
			+ "(0,6)\n"
			+ "(0,7)\n"
			+ "(1,7)\n"
			+ "(1,8)\n"
			+ "(1,9)\n"
			+ "(0,9)\n"
			+ "(2,9)\n"
			+ "(0,8)\n"
			+ "(2,8)\n"
			+ "(2,7)\n"
			+ "(3,7)\n"
			+ "(4,7)\n"
			+ "(4,8)\n"
			+ "(3,8)\n"
			+ "(3,9)\n"
			+ "(4,9)\n"
			+ "(5,9)\n"
			+ "(5,8)\n"
			+ "(5,7)\n"
			+ "(5,6)\n"
			+ "(4,6)\n"
			+ "(4,5)\n"
			+ "(3,5)\n"
			+ "(5,5)\n"
			+ "(3,6)\n"
			+ "(5,4)\n"
			+ "(2,6)\n"
			+ "(5,3)\n"
			+ "(2,5)\n"
			+ "(6,3)\n"
			+ "(1,5)\n"
			+ "(6,2)\n"
			+ "(1,6)\n"
			+ "(6,1)\n"
			+ "(5,1)\n"
			+ "(4,1)\n"
			+ "(5,2)\n"
			+ "(4,0)\n"
			+ "(5,0)\n"
			+ "(6,0)\n"
			+ "(7,0)\n"
			+ "(8,0)\n"
			+ "(9,0)\n"
			+ "(9,1)\n"
			+ "(9,2)\n"
			+ "(8,2)\n"
			+ "(8,1)\n"
			+ "(7,1)\n"
			+ "(7,2)\n"
			+ "(7,3)\n"
			+ "(7,4)\n"
			+ "(7,5)\n"
			+ "(6,5)\n"
			+ "(6,6)\n"
			+ "(6,4)\n"
			+ "(7,6)\n"
			+ "(8,6)\n"
			+ "(9,6)\n"
			+ "(9,7)\n"
			+ "(9,5)\n"
			+ "(9,8)\n"
			+ "(9,4)\n"
			+ "(9,9)\n"
			+ "(9,9)\n"
			+ "\n"
			+ "Empty Maze:\n"
			+ "+ +-+-+-+-+-+-+-+-+-+\n"
			+ "|   |           |   |\n"
			+ "+-+ + +-+-+-+-+ +-+ +\n"
			+ "| | |     |   |     |\n"
			+ "+ + + +-+ + +-+-+-+ +\n"
			+ "|   | |   |   |     |\n"
			+ "+ +-+-+ +-+-+ + +-+-+\n"
			+ "|     |   |   | |   |\n"
			+ "+-+-+ +-+ + +-+ + + +\n"
			+ "|   |     |   |   | |\n"
			+ "+ + +-+-+-+ + +-+-+ +\n"
			+ "| |   |     |       |\n"
			+ "+ + +-+ +-+-+-+-+-+-+\n"
			+ "| |     |     |     |\n"
			+ "+ +-+-+-+-+ + + +-+ +\n"
			+ "| |         | | | | |\n"
			+ "+ + +-+-+-+-+ + + + +\n"
			+ "| |   |     | |   | |\n"
			+ "+ +-+ + +-+-+ +-+-+ +\n"
			+ "|     |             |\n"
			+ "+-+-+-+-+-+-+-+-+-+ +\n"
			+ "\n"
			+ "DFS Solution:\n"
			+ "+ +-+-+-+-+-+-+-+-+-+\n"
			+ "|1 2|0 2 3 4 5 6|2 0|\n"
			+ "+-+ + +-+-+-+-+ +-+ +\n"
			+ "|6|3|9 8 7|5 7|7 8 9|\n"
			+ "+ + + +-+ + +-+-+-+ +\n"
			+ "|5 4| |5 6|3 1|4 3 1|\n"
			+ "+ +-+-+ +-+-+ + +-+-+\n"
			+ "|7 8 9|4 3|7 9|5|8 9|\n"
			+ "+-+-+ +-+ + +-+ + + +\n"
			+ "|2 0|0 1 2|6 5|6 7|0|\n"
			+ "+ + +-+-+-+ + +-+-+ +\n"
			+ "|3|9  |2 0 8|4 3 2 1|\n"
			+ "+ + +-+ +-+-+-+-+-+-+\n"
			+ "|4|8 6 4|  7 8|     |\n"
			+ "+ +-+-+-+-+ + + +-+ +\n"
			+ "|5|2 3 4 5 6|0| | | |\n"
			+ "+ + +-+-+-+-+ + + + +\n"
			+ "|6|1 0|     |1|   | |\n"
			+ "+ +-+ + +-+-+ +-+-+ +\n"
			+ "|7 8 9|      2 3 5 7|\n"
			+ "+-+-+-+-+-+-+-+-+-+ +\n"
			+ "+ +-+-+-+-+-+-+-+-+-+\n"
			+ "|# #|# # # # # #|   |\n"
			+ "+-+ + +-+-+-+-+ +-+ +\n"
			+ "| |#|# # #|   |# # #|\n"
			+ "+ + + +-+ + +-+-+-+ +\n"
			+ "|# #| |# #|   |# # #|\n"
			+ "+ +-+-+ +-+-+ + +-+-+\n"
			+ "|# # #|# #|   |#|# #|\n"
			+ "+-+-+ +-+ + +-+ + + +\n"
			+ "|# #|# # #|# #|# #|#|\n"
			+ "+ + +-+-+-+ + +-+-+ +\n"
			+ "|#|#  |# # #|# # # #|\n"
			+ "+ + +-+ +-+-+-+-+-+-+\n"
			+ "|#|# # #|  # #|     |\n"
			+ "+ +-+-+-+-+ + + +-+ +\n"
			+ "|#|# # # # #|#| | | |\n"
			+ "+ + +-+-+-+-+ + + + +\n"
			+ "|#|# #|     |#|   | |\n"
			+ "+ +-+ + +-+-+ +-+-+ +\n"
			+ "|# # #|      # # # #|\n"
			+ "+-+-+-+-+-+-+-+-+-+ +\n"
			+ "\n"
			+ "BFS Solution:\n"
			+ "+ +-+-+-+-+-+-+-+-+-+\n"
			+ "|1 2|0 2 3 4 5 6|2 0|\n"
			+ "+-+ + +-+-+-+-+ +-+ +\n"
			+ "|6|3|9 8 7|5 7|7 8 9|\n"
			+ "+ + + +-+ + +-+-+-+ +\n"
			+ "|5 4|1|5 6|3 1|4 3 1|\n"
			+ "+ +-+-+ +-+-+ + +-+-+\n"
			+ "|7 8 9|4 3|7 9|5|8 9|\n"
			+ "+-+-+ +-+ + +-+ + + +\n"
			+ "|2 0|0 1 2|6 5|6 7|0|\n"
			+ "+ + +-+-+-+ + +-+-+ +\n"
			+ "|3|9 1|2 0 8|4 3 2 1|\n"
			+ "+ + +-+ +-+-+-+-+-+-+\n"
			+ "|4|8 6 4|9 7 8|     |\n"
			+ "+ +-+-+-+-+ + + +-+ +\n"
			+ "|5|2 3 4 5 6|0| | | |\n"
			+ "+ + +-+-+-+-+ + + + +\n"
			+ "|6|1 0|     |1|   | |\n"
			+ "+ +-+ + +-+-+ +-+-+ +\n"
			+ "|7 8 9|  6 4 2 3 5 7|\n"
			+ "+-+-+-+-+-+-+-+-+-+ +\n"
			+ "+ +-+-+-+-+-+-+-+-+-+\n"
			+ "|# #|# # # # # #|   |\n"
			+ "+-+ + +-+-+-+-+ +-+ +\n"
			+ "| |#|# # #|   |# # #|\n"
			+ "+ + + +-+ + +-+-+-+ +\n"
			+ "|# #| |# #|   |# # #|\n"
			+ "+ +-+-+ +-+-+ + +-+-+\n"
			+ "|# # #|# #|   |#|# #|\n"
			+ "+-+-+ +-+ + +-+ + + +\n"
			+ "|# #|# # #|# #|# #|#|\n"
			+ "+ + +-+-+-+ + +-+-+ +\n"
			+ "|#|#  |# # #|# # # #|\n"
			+ "+ + +-+ +-+-+-+-+-+-+\n"
			+ "|#|# # #|  # #|     |\n"
			+ "+ +-+-+-+-+ + + +-+ +\n"
			+ "|#|# # # # #|#| | | |\n"
			+ "+ + +-+-+-+-+ + + + +\n"
			+ "|#|# #|     |#|   | |\n"
			+ "+ +-+ + +-+-+ +-+-+ +\n"
			+ "|# # #|      # # # #|\n"
			+ "+-+-+-+-+-+-+-+-+-+ +";
	@Test
	void test10x10Maze() 
	{
		String actual = "";
		Maze maze = new Maze(10);
        maze.generateMaze();
        MazeSolver solver = new MazeSolver();
        Stack<Cell> cellStack = new Stack<Cell>();
        Queue<Cell> cellQueue = new LinkedList<Cell>();
        ArrayList<Cell> DFSresults = solver.DFS(maze, maze.getCells()[0][0], cellStack);
        maze.resetVisitedValues();
        ArrayList<Cell> BFSresults = solver.BFS(maze, maze.getCells()[0][0], cellQueue);
        
        actual += "DFS\n";
        for (Cell cell : cellStack)
        	actual += cell + "\n";
        actual += "BFS\n";
        for (Cell cell : BFSresults)
        	actual += cell + "\n";
        actual += "\n";
        actual += "Empty Maze:\n";
        actual += maze.printMaze(maze.getCells()) + "\n\n";      
        actual += "DFS Solution:\n";
        actual += maze.printMaze(maze.getCells(), true, true, DFSresults) + "\n";
        actual += maze.printMaze(maze.getCells(), true, false, DFSresults) + "\n\n";       
        actual += "BFS Solution:\n";
        actual += maze.printMaze(maze.getCells(), true, true, BFSresults) + "\n";
        actual += maze.printMaze(maze.getCells(), true, false, BFSresults);
        assertEquals(expected10x10, actual);
	}
}

package project3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import javax.lang.model.util.ElementScanner6;

public class Maze {
    private int size; // length and height of the maze
    private Cell[][] cells = new Cell[size][size];

    public Maze(int size) 
    {
        this.cells = new Cell[size][size];
        this.size = size;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                this.cells[i][j] = new Cell(i, j);
    }

    public Cell[][] getCells() 
    {
        return this.cells;
    }

    public int getSize() 
    {
        return size;
    }

    public void resetVisitedValues() 
    {
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                if (this.cells[i][j].getVisited())
                    this.cells[i][j].toggleVisited();
    }

    public void generateMaze() 
    {
        // https://www.youtube.com/watch?v=SqqOB2HgGsM
        // find all currentCell's neighbors
        // if one or more found choose one at random
        // knock down the wall between it and CurrentCell
        // push CurrentCell location on the CellStack
        // make the new cell CurrentCell
        // add 1 to VisitedCells
        // else
        // pop the most recent cell entry off the cellStack
        // make it current cell
        Stack<Cell> cellStack = new Stack<Cell>();
        int totalCells = size * size; // total size is size squared
        Cell currentCell = cells[0][0]; // starting cell (Top left corner (0,0)) ending cell bottom right corner(size, size)
        int visitedCells = 1;
        cellStack.push(currentCell);
        Random r = new Random();
        r.setSeed(299);
        while (visitedCells < totalCells) 
        {

            int i = currentCell.getX();
            int j = currentCell.getY();
            HashMap<String, Cell> neighborMap = new HashMap<String, Cell>();

            // Find neighbors
            try 
            {
                if (cells[i][j + 1].allWallsIntact())
                    neighborMap.put("East", cells[i][j + 1]);
            } 
            catch (IndexOutOfBoundsException e) {} 
            try 
            {
                if (cells[i][j - 1].allWallsIntact())
                    neighborMap.put("West", cells[i][j - 1]);
            } 
            catch (IndexOutOfBoundsException e) {}
            try 
            {
                if (cells[i - 1][j].allWallsIntact())
                    neighborMap.put("North", cells[i - 1][j]);
            } 
            catch (IndexOutOfBoundsException e) {}

            try 
            {
                if (cells[i + 1][j].allWallsIntact())
                    neighborMap.put("South", cells[i + 1][j]);
            } 
            catch (IndexOutOfBoundsException e) {}

            if (neighborMap.isEmpty()) 
            {
                cellStack.pop();
                currentCell = cellStack.lastElement();
            } 
            else 
            {
                // Array of all keys to be used to choose random HashMap
                ArrayList<String> neighborKeys = new ArrayList<String>(neighborMap.keySet());
                // picks random key then uses that to find the associated Cell in neighborMap
                String neighborDirectionString = neighborKeys.get(r.nextInt(neighborKeys.size()));
                Cell randomNeighbor = neighborMap.get(neighborDirectionString);
                if (neighborDirectionString.equals("East")) 
                {
                    currentCell.toggleWall(1);
                    randomNeighbor.toggleWall(3);
                }
                if (neighborDirectionString.equals("West"))
                {
                    currentCell.toggleWall(3);
                    randomNeighbor.toggleWall(1);
                }
                if (neighborDirectionString.equals("North")) 
                {
                    currentCell.toggleWall(0);
                    randomNeighbor.toggleWall(2);
                }
                if (neighborDirectionString.equals("South"))
                {
                    currentCell.toggleWall(2);
                    randomNeighbor.toggleWall(0);
                }
                cellStack.push(randomNeighbor);
                currentCell = randomNeighbor;
                visitedCells++;
            }
        }
    }

    // Print maze without graphing path;
    public String printMaze(Cell[][] cellMaze) 
    {
        return printMaze(cellMaze, false, false, new ArrayList<Cell>());
    }

    public String printMaze(Cell[][] cellMaze, boolean graphPath, boolean numberGraphPath, ArrayList<Cell> path) 
    {
        String output = "";
        for (int i = 0; i < cellMaze.length; i++) 
        {
            String cellRow = "|";
            String upperRow = "";
            String bottomRow = "";
            for (int j = 0; j < cellMaze.length; j++) 
            {
                // upper line: (+-+-+-+-+)
                upperRow += "+";
                if (i == 0 && j == 0) // take out starting wall
                    upperRow += " ";
                else if (cellMaze[i][j].getWalls()[0] == true) // checks North wall
                    upperRow += "-";
                else
                    upperRow += " ";

                // bottom border special case
                if (i == cellMaze.length - 1) 
                {
                    if (j == cellMaze.length - 1) // take out ending wall
                        bottomRow += "+ ";
                    else
                        bottomRow += "+-";
                }

                // cell line: (| | | | |)
                if (cellMaze[i][j].getWalls()[1] == true) // checks East wall
                {

                    if (graphPath && path.contains(cellMaze[i][j])) 
                    {
                        if (numberGraphPath)
                            cellRow += cellMaze[i][j].getVisitedOrder() % 10 + "|";
                        else if (cellMaze[i][j].getPath())
                            cellRow += "#|";
                        else
                            cellRow += " |";
                    } 
                    else
                        cellRow += " |";
                } 
                else 
                {
                    if (graphPath && path.contains(cellMaze[i][j])) 
                    {
                        if (numberGraphPath)
                            cellRow += cellMaze[i][j].getVisitedOrder() % 10 + " ";
                        else if (cellMaze[i][j].getPath())
                            cellRow += "# ";
                        else
                            cellRow += "  ";
                    } 
                    else
                        cellRow += "  ";
                }

            }
            // add right-most piece of border
            upperRow += "+";

            output += upperRow + "\n";
            output += cellRow + "\n";
            if (i == cellMaze.length - 1) 
            {
                bottomRow += "+";
                output += bottomRow;
            }
        }
        return output;
    }

    public static void main(String[] args) 
    {
        Maze maze = new Maze(10);
        maze.generateMaze();

        MazeSolver solver = new MazeSolver();
        Stack<Cell> cellStack = new Stack<Cell>();
        Queue<Cell> cellQueue = new LinkedList<Cell>();
        ArrayList<Cell> DFSresults = solver.DFS(maze, maze.getCells()[0][0], cellStack);

        // Reset the cells that have been labelled visited to not visited
        maze.resetVisitedValues();
        ArrayList<Cell> BFSresults = solver.BFS(maze, maze.getCells()[0][0], cellQueue);

        System.out.println("DFS");
        for (Cell cell : cellStack)
            System.out.println(cell);

        System.out.println("BFS");
        for (Cell cell : BFSresults)
            System.out.println(cell);

        System.out.println("\n" + "Empty Maze:");
        System.out.println(maze.printMaze(maze.getCells()));
        // This arraylist is in reversed order

        System.out.println("\nDFS Solution:\n" + maze.printMaze(maze.getCells(), true, true, DFSresults));
        System.out.println(maze.printMaze(maze.getCells(), true, false, DFSresults));
        System.out.println("\nBFS Solution:\n" + maze.printMaze(maze.getCells(), true, true, BFSresults));
        System.out.println(maze.printMaze(maze.getCells(), true, false, BFSresults));

    }
}


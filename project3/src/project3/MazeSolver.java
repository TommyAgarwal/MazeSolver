package project3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class MazeSolver {

    public ArrayList<Cell> DFS(Maze maze, Cell currentCell, Stack<Cell> cellStack) 
    {
        ArrayList<Cell> arr = new ArrayList<Cell>();
        boolean finishedMaze = false;
        int visited_order = 1;
        currentCell.setVisitedOrder(visited_order);
        while (finishedMaze == false) 
        {
            if(!arr.contains(currentCell)) 
                arr.add(currentCell);
            currentCell.setVisited(true);
            ArrayList<Cell> neighbors = findOpenNeighbors(currentCell, maze);
            if (neighbors.isEmpty()) 
            {
                currentCell = cellStack.lastElement();
                cellStack.pop();
            } 
            else 
            {
                Cell cell = neighbors.get(0);
                visited_order++;
                cell.setVisitedOrder(visited_order);
                cellStack.push(currentCell);             
                currentCell = cell;
            }
            // we define the end of the maze as [size-1][size-1] so we check both cordinates
            // to see if we have reached the final cell
            if (currentCell.getX() == maze.getSize() - 1 && currentCell.getY() == maze.getSize() - 1) 
            {
                arr.add(currentCell);
                currentCell.setPath(true);
                finishedMaze = true;
                cellStack.push(currentCell);

                for(Cell cell : cellStack) 
                {
                    cell.setPath(true);
                }
                return arr;
            }
        }
        return arr;
    }

    public ArrayList<Cell> BFS(Maze maze, Cell currentCell, Queue<Cell> cellQueue) 
    {
        // End of maze is located in bottom right
        Cell endCell = maze.getCells()[maze.getSize() - 1][maze.getSize() - 1];
        ArrayList<Cell> arr = new ArrayList<Cell>();
        ArrayList<Cell> path = new ArrayList<Cell>();
        int visited_order = 1;
        currentCell.setVisitedOrder(visited_order);
        cellQueue.add(currentCell);
        while (!cellQueue.isEmpty()) 
        {
            if (currentCell.getX() == endCell.getX() && currentCell.getY() == endCell.getY()) 
            {
                arr.add(currentCell);
                currentCell.setPath(true);              
                Cell temp = arr.get(arr.size() - 1);
                while (true==true) 
                {
                    temp = temp.getprev();
                    temp.setPath(true);
                    if(temp == arr.get(0))
                        break;
                }
                //Beginning cell is always part of the shortest path as it where we start
                arr.get(0).setPath(true);
                return arr;
            }
            // Holds value of first in Queue
            currentCell = cellQueue.poll();
            arr.add(currentCell);
            currentCell.setVisited(true);
            ArrayList<Cell> neighbors = findOpenNeighbors(currentCell, maze);
            for (Cell cell : neighbors) 
            {
                visited_order++;
                cell.setVisitedOrder(visited_order);
                cell.setPrev(currentCell);
                cell.setVisited(true);
                cellQueue.add(cell);
            }
        }
        //Beginning cell is always part of the shortest path as it where we start
        arr.get(0).setPath(true);
        return arr;
    }

    public ArrayList<Cell> findOpenNeighbors(Cell currentCell, Maze maze) {
        int i = currentCell.getX();
        int j = currentCell.getY();
        Cell[][] cells = maze.getCells();
        ArrayList<Cell> neighbors = new ArrayList<Cell>();
        boolean[] walls = currentCell.getWalls();
        // North
        if (walls[0] == false)
            neighbors.add(cells[i - 1][j]);
        // East
        if (walls[1] == false)
            neighbors.add(cells[i][j + 1]);
        // South
        if (walls[2] == false)
            neighbors.add(cells[i + 1][j]);
        // West
        if (walls[3] == false)
            neighbors.add(cells[i][j - 1]);
        // Iterates though and removes cells that have already been visited
        Iterator<Cell> iter = neighbors.iterator();
        while (iter.hasNext()) 
        {
            if (iter.next().getVisited() == true)
                iter.remove();
        }
        return neighbors;
    }
}


package project3;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class Cell {
    private boolean[] walls = { true, true, true, true }; // {North, East, South, West}
    int x;
    int y;
    boolean path;
    int visited_order;
    private boolean visited;
    private HashMap neighborMap;
    Cell prev;

    public Cell(int x, int y) 
    {
        this.x = x;
        this.y = y;
        this.visited = false;
        this.path = false;
    }


    // Visited Order represents how many nodes were searched before this node, including the current node itself
    public int getVisitedOrder() 
    {
        return this.visited_order;
    }

    public void setVisitedOrder(int order) 
    {
        this.visited_order = order;
    }

    // Path is used for when we draw the path so we can differentiate between the direct path between two points and cells that were just searched 
    public boolean getPath() 
    {
        return this.path;
    }

    //True means it is part of the shortest path 
    public void setPath(boolean setPath) 
    {
        this.path = setPath;
    }

    //Previous is used in BFS in order for us to find our way back from the end node to where we started
    public void setPrev(Cell cell) 
    {
        this.prev = cell;
    }

    public Cell getprev() 
    {
        return this.prev;
    }
    
    public boolean allWallsIntact() 
    {
        for (int i = 0; i < 4; i++)
            if (this.walls[i] == false)
                return false;
        return true;
    }

    public boolean getVisited() 
    {
        return this.visited;
    }

    public void toggleVisited() 
    {
        this.visited = !this.visited;
    }

    public void setVisited(boolean visited) 
    {
        this.visited = visited;
    }

    public int getX() 
    {
        return this.x;
    }

    public int getY() 
    {
        return this.y;
    }

    public boolean equals(Cell that) 
    {
        if(this.compareTo(that) != 0)
            return false;
        return true;
    }

    public int compareTo(Cell that) 
    {
        if (this.x == that.x) 
        {
            if (this.y == that.y) 
            {
                if (Arrays.equals(this.walls, that.walls))
                    return 0;
                if (this.walls[0] == true)
                    return 1;
                else 
                    return -1;
            }
            return Integer.compare(this.y, that.y);
        }
        return Integer.compare(this.x, that.x);
    }

    // {North, East, South, West}
    public void toggleWall(int index) 
    {
        walls[index] = !walls[index];
    }

    public boolean[] getWalls() 
    {
        return this.walls;
    }

    public String toString() 
    {
        return "(" + this.x + "," + this.y + ")"; // + " North " + this.walls[0] + " East " + this.walls[1] + " South " +
                                               	  // this.walls[2] + " West " + this.walls[3] + " Visited " + this.visited;
    }
}

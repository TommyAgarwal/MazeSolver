package project3;

public class TestMain {

	public static void main(String[] args) 
	{
		
		Maze testMaze = new Maze(6);
		testMaze.generateMaze();
		testMaze.printMaze(testMaze.getCells());
		
		

	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Krietallo
 */
public class Game   
{

	static int rows = 6;
	static int cols = 7;

	int[] height = new int[cols];

	int[][] grid = new int[rows][cols];

	Game()
	{
		for(int i = 0; i < cols; i++)
		{
			height[i] = 0;
		}
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
			{
				grid[i][j] = 0;
			}
	}
	
	boolean isWinner(int player, int row, int column)
	{
		int horizontal = 1, vertical = 1, diagonal1 = 1, diagonal2 = 1;
		
		for(int r = row - 1; r >= 0 && grid[r][column] == player; r--, vertical++);
		// for(int r = row + 1; r < height[column] && grid[r][column] == player; r++, vertical++); // already on top
		if(vertical >= 4)	return true;
		
		for(int c = column - 1; c >= 0 && grid[row][c] == player; c--, horizontal++);
		for(int c = column + 1; c < cols && grid[row][c] == player; c++, horizontal++);
		if(horizontal >= 4)	return true;
		
		for(int r = row + 1, c = column + 1; r < rows && c < cols && grid[r][c] == player; r++, c++, diagonal1++);
		for(int r = row - 1, c = column - 1; r >= 0 && c >= cols && grid[r][c] == player; r--, c--, diagonal1++);
		if(diagonal1 >= 4)	return true;
		
		for(int r = row + 1, c = column - 1; r < rows && c >= 0 && grid[r][c] == player; r++, c--, diagonal2++);
		for(int r = row - 1, c = column + 1; r >= 0 && c <cols && grid[r][c] == player; r--, c++, diagonal2++);
		if(diagonal2 >= 4)	return true;
		
		return false;
	}
	
	
	boolean addCoin(int player, int column)
	{
		if(column < 0 || column >= cols || height[column] == 6)
		{
			System.out.println("Invalid move. Please try again.");
			return false;
		}
		int row = height[column];
		
		grid[row][column] = player;
		height[column]++;
		
		return true;
	}
	
}


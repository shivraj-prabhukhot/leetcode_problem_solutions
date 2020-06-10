public class NoOfIslands {

	public static int numIslands(char[][] grid) {
		if(grid == null || grid.length ==0)
			return 0;
		int numberOfRows = grid.length;
		int numberOfColumns = grid[0].length;
		int numOfIslands=0;
		for(int i = 0; i < numberOfRows; ++i ){
			for(int j = 0; j < numberOfColumns; ++j){
				if(grid[i][j] == '1') {
					++numOfIslands;
					DFS(grid, i, j);
				}
			}
		}
		return numOfIslands;
	}
	public static void DFS(char[][] grid, int row, int column){
		int numberOfRows = grid.length;
		int numberOfColumns = grid[0].length;

		if(row< 0 || column <0 || row >= numberOfRows || column >= numberOfColumns || grid[row][column] == '0')
			return;

		grid[row][column] ='0';
		DFS(grid,row, column+1);
		DFS(grid, row, column-1);
		DFS(grid, row+1, column);
		DFS(grid, row-1, column);
	}
	public static void main(String[] args){
		char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','1','1','1'}};
		System.out.println(numIslands(grid));
	}
}

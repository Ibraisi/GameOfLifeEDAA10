public class LifeBoard {
	
     int rows,cols;
     boolean gameSpace[][];
     int gen;
	

	public LifeBoard(int rows, int cols) {
		this.rows = rows;
        this.cols = cols;
		gameSpace = new boolean[rows][cols];
		gen = 1;
	}

	public boolean isAlive(int row, int col) {
		if(row>= rows || col>= cols || row<0 || col<0) {
			return false;
					}
        return gameSpace[row][col];
	}

	public void put(int row, int col, boolean val) {
		gameSpace[row][col] = val;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public int getGeneration() {
		return gen;
	}

	public void increaseGeneration() {
		gen++;
	}
}

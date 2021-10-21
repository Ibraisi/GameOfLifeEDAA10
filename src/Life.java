

public class Life {
	
	private LifeBoard board;
	LifeView window;
	
	public Life(LifeBoard board) {
		this.board =board;
		window = new LifeView(board);
		window.drawBoard();
	}
	public void newGeneration() {
		board.increaseGeneration();
		boolean helpMatrix[][] = new boolean[board.getRows()][board.getCols()];
		for(int i=0; i< board.getRows(); i++) {
			for(int j =0; j<board.getCols(); j++) {
				if(board.get(i, j) && (getNeighbours(i,j) ==3 || getNeighbours(i,j) ==2)){
					helpMatrix[i][j] =true;
				}else if(board.gameSpace[i][j] == true && (getNeighbours(i,j) >=4 || getNeighbours(i,j)<=1)) {
					helpMatrix[i][j] = false;
				}
				else if (!(board.get(i, j))&& getNeighbours(i,j) ==3) {
					helpMatrix[i][j] = true;
				}
				else {
					helpMatrix[i][j] = board.gameSpace[i][j];
				}
			}
		}
		board.gameSpace = helpMatrix;
	}
	/** Ändrar innehållet i rutan med index row, col från individ till tome ller tvärtom */
	public void flip(int row, int col) {
		if(board.get(row, col)) {
			board.put(row, col, false);
		}else
			board.put(row, col, true);
	}
	
	
	private int getNeighbours(int row, int col) {
		int counter = 0;
//		if(row!=0 && row != board.rows-1 && col!=0 && col != board.cols-1 ) {
			for(int i = row -1; i<= row+1;i++)
			{
				for(int j = col-1; j<=col+1; j++)
				{
					if(i==row && j ==col ) {
						continue;
					}
					else if(board.get(i, j)) {
						counter++;
					}
				}
			}
//		}
//			if(board.gameSpace[row+1][col] == true)
//				counter++;
//			if(board.gameSpace[row-1][col] == true)
//				counter++;
//			if(board.gameSpace[row][col+1] == true)
//				counter++;
//			if(board.gameSpace[row][col-1] == true)
//				counter++;
//			if(board.gameSpace[row+1][col+1] == true)
//				counter++;
//			if(board.gameSpace[row-1][col-1] == true)
//				counter++;
//			else if((1 < col && col < board.gameSpace.length-1) && row == board.gameSpace.length-1 ) {
//			if(board.gameSpace[row][col+1] == true)
//				counter++;
//			if(board.gameSpace[row][col-1] == true)
//			counter++;
//			if(board.gameSpace[row-1][col] == true)
//			counter++;
//			if(board.gameSpace[row-1][col+1] == true)
//			counter++;
//			if(board.gameSpace[row-1][col-1] == true)
//			counter++;
//		}else if((1 < col && col < board.gameSpace.length-1) && row == 1 ) {
//			if(board.gameSpace[row][col+1] == true)
//				counter++;
//			if(board.gameSpace[row][col-1] == true)
//			counter++;
//			if(board.gameSpace[row+1][col] == true)
//			counter++;
//			if(board.gameSpace[row+1][col+1] == true)
//			counter++;
//			if(board.gameSpace[row+1][col-1] == true)
//			counter++;
//		}
		return counter;
	} 

}

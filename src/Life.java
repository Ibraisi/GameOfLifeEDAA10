public class Life {
	
	private LifeBoard board;
	LifeView window;
	
	public Life(LifeBoard board) {
		this.board = board;
		window = new LifeView(board);
		window.drawBoard();
	}
	public void newGeneration() {
		boolean helpMatrix[][] = new boolean[board.getRows()][board.getCols()];

		for(int i = 0; i< board.getRows(); i++) {
			for(int j = 0; j<board.getCols(); j++) {
				if(shouldLivNext(i, j)){
					helpMatrix[i][j] = true;  
				}else if(!shouldLivNext(i, j)){
					helpMatrix[i][j] = false;
				}
				else {
					helpMatrix[i][j] = board.gameSpace[i][j];
				}
			}
		}
		board.gameSpace = helpMatrix;
		board.increaseGeneration();
	}

    private boolean shouldLivNext(int row, int col)
    {
        if(board.isAlive(row, col) && (getNeighbours(row, col) == 2 || getNeighbours(row, col) == 3))
        {
            return true;
        }else if(!board.isAlive(row, col) && getNeighbours(row, col) == 3 ){
            return true;
            }
        else if(board.isAlive(row, col) && getNeighbours(row, col) < 2 || getNeighbours(row, col) > 3)
        {
            return false;
        }
        return false;
    }

	public void flip(int row, int col) {
		if(board.isAlive(row, col)) {
			board.put(row, col, false);
		}else
			board.put(row, col, true);
	}
	
	
	private int getNeighbours(int row, int col) {
		int counter = 0;

			for(int i = row -1; i<= row+1;i++)
			{
				for(int j = col-1; j<=col+1; j++)
				{
					if(i==row && j ==col ) {
						continue;
					}
					else if(board.isAlive(i, j)) {
						counter++;
					}
				}
			}
	return counter;
	} 
}

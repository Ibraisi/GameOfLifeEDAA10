

public class LifeController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LifeBoard board = new LifeBoard(10,10);
		Life game = new Life(board);

		while(true) {
			int check = game.window.getCommand();
			switch(check) {
			case 1:
				game.flip(game.window.getRow(), game.window.getCol());
				game.window.update();
				break;
			case 2:
				game.newGeneration();
				game.window.update();
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}
}

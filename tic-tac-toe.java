import java.util.Scanner;

/**
 * @author:
 * Tyler Mestery
 * Harsh
 * Dan
 * Austin
 * 
 * A tic-tac-toe game.
 */
public class tictactoe {
	
	private static int count = 1;
	private static boolean gameDone = false;
	
	// Displays the game to users
	public static void print() {
		String[][] xy = new String[3][3];
		String line = "";
		xy[1][2] = "x";
		line += "+-+-+-+\n";
		
		for(int i = 0; i < xy.length; i++) {
			if (i != 0) {
				line += "|\n+-+-+-+ \n";
			}
			
			for(int j = 0; j < xy[i].length; j ++) {
				if (xy[j][i] == "o") {
					line += "|o";
					
				} else if (xy[j][i] == "x") {
					line += "|x";
				} else {
					line += "| ";
				}
			}
		}
		
		line += "|\n+-+-+-+ \n";
		System.out.println(line);
	}
	
	// Game logic function
	public static void game () {
		int[][] gameBoard = new int[3][3];
		int player = 1;
				
		 // While game is ongoing...
		while(!gameDone) {
			print();
			if (count % 2 == 1) {
				player = 1;
			} else {
				player = 2;
			}
			
			if (count >= 5) {
				boolean winner = checkWin(gameBoard, player);
				if (winner) {
					gameDone = true;
				}
			}
			
			System.out.println("Player " + player + "'s turn!");
			Scanner playerXPositionInput = new Scanner(System.in);
			int x = playerXPositionInput.nextInt();
			Scanner playerYPositionInput = new Scanner(System.in);
			int y = playerXPositionInput.nextInt();
			System.out.println("Player " + player + " has selected spot (" + x + ", " + y + ")");
			gameBoard[x][y] = player;
			count += 1;
			
			
		}
	}
	
	public static boolean checkWin (int[][] gameBoard, int player) {
		// Diagonal Check
		boolean diagonal = diagonalCheck(gameBoard, player);
		
		// Horizontal Check
		boolean vertical = verticalCheck(gameBoard, player);

		// Vertical Check
		boolean horizontal = horizontalCheck(gameBoard, player);
		
		if (diagonal || vertical || horizontal) {
			return true;
		}
		
		return false;
	}
	
	// Checks if a player has won diagonally
	public static boolean diagonalCheck(int[][] gameBoard, int player) {
		if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
			return true;
		} else if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
			return true;
		}
		
		return false;
	}
	
	// Checks if a player has won vertically
	public static boolean verticalCheck(int[][] gameBoard, int player) {
	    if (gameBoard[0][0] == player && gameBoard[1][0] == player && gameBoard[2][0] == player) {
	        return true;
	    } else if (gameBoard[0][1] == player && gameBoard[1][1] == player && gameBoard[2][1] == player) {
	        return true;
	    } else if (gameBoard[0][2] == player && gameBoard[1][2] == player && gameBoard[2][2] == player) {
	        return true;
	    }
	    
	    return false;
	}
	
	// Checks if a player has won horizontally
	public static boolean horizontalCheck(int[][] gameBoard, int player) {
		if (gameBoard[0][0] == player && gameBoard[0][1] == player && gameBoard[0][2] == player) {
			return true;
		} else if (gameBoard[1][0] == player && gameBoard[1][1] == player && gameBoard[1][2] == player) {
			return true;
		} else if (gameBoard[2][0] == player && gameBoard[2][1] == player && gameBoard[2][2] == player) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[]Args) {
		game();
	}
}

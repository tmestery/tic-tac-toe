import java.util.Scanner;

/**
 * @author:
 * Tyler Mestery:
 * - Worked on the game and checkwin function and all contributed to row checks
 * 
 * Harshith Jaladi
 * - Worked on the print function and all contributed to row checks
 * 
 * Dan Habiger
 * - Worked on the game and checkwin function and all contributed to row checks
 * 
 * Austin Das
 * - Worked on the print function and all contributed to row checks
 * 
 * A tic-tac-toe game.
 */
public class TicTacToe {
	
	private static int count = 1;
	private static boolean gameDone = false;
	private static String[][] xy = new String[3][3];
	private static int player = 1;
	
	// Displays the game to users
	public static void print() {
		String line = "";
		line += "+-+-+-+\n";
		
		for(int i = 0; i < xy.length; i++) {
			if (i != 0) {
				line += "|\n+-+-+-+ \n";
			}
			
			for(int j = 0; j < xy[i].length; j ++) {
				if (xy[i][j] == null) {
				    line += "| ";
				} else if (xy[i][j].equals("o")) {
					line += "|o";
				} else if (xy[i][j].equals("x")) {
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
		Scanner scanner = new Scanner(System.in);
		print();
				
		 // While game is ongoing...
		while(!gameDone) {
			if (count % 2 == 1) {
				player = 1;
			} else {
				player = 2;
			}
			
			// Getting player inputs:
			System.out.println("Player " + player + "'s turn!");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			System.out.println("Player " + player + " has selected spot (" + x + ", " + y + ")");
			
			// Updating GameBoard:
			gameBoard[x][y] = player;
			if (player == 1) {
				xy[x][y] = "x";
			} else {
				xy[x][y] = "o";
			}
			
			// Printing GameBoard:
			print();
			if (count >= 5) {
				boolean winner = checkWin(gameBoard);
				if (winner) {
					gameDone = true;
					System.out.println("Player " + player + " is the winner!");
					return;
				}
			}
			
			if (count >= 9 && !gameDone) {
				gameDone = true;
				System.out.println("GAME OVER!");
				return;
			}
			count += 1;
		}
	}
	
	public static boolean checkWin (int[][] gameBoard) {
		// Diagonal Check
		boolean diagonal = diagonalCheck(gameBoard);
		
		// Vertical Check
		boolean vertical = verticalCheck(gameBoard);

		// Horizontal Check
		boolean horizontal = horizontalCheck(gameBoard);
		
		if (diagonal || vertical || horizontal) {
			return true;
		}
		
		return false;
	}
	
	// Checks if a player has won diagonally
	public static boolean diagonalCheck(int[][] gameBoard) {
		if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
			return true;
		} else if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
			return true;
		}
		
		return false;
	}
	
	// Checks if a player has won vertically
	public static boolean verticalCheck(int[][] gameBoard) {
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
	public static boolean horizontalCheck(int[][] gameBoard) {
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

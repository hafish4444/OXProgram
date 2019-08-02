import java.util.*;

public class OX {
	static Scanner kb = new Scanner(System.in);
	static String  board[][] = {{" "," "," "},
								{" "," "," "},
								{" "," "," "}};
	// First turn is O //
	static String turn = "O";
	
	public static void main(String[] args) {
		printStart();
		//Loop GameStart
		while (true) {
			printBoard();
			inputPosition();
			if (checkWin()) {
				printWin();
				break;
			}else if (checkDraw()) {
				printDraw();
				break;
			}
			switchTurn();
		}
	}
	
	public static void printStart() {
		System.out.println("Start Game OX");
	}
	
	public static void printBoard() {
		System.out.println("  1 2 3 ");
		for (int i = 0; i < 3; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < 3; j++) {
				System.out.print("|"+ board[i][j]);
			}
			System.out.println("|");
		}
	}
	
	public static boolean checkWin() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == turn && board[i][1] == turn && board[i][2] == turn) {
				return true;
			}
			if (board[0][i] == turn && board[1][i] == turn && board[2][i] == turn) {
				return true;
			}
		}
		if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) {
			return true;
		}
		if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn) {
			return true;
		}
		return false;
	}
	
	public static void inputPosition() {
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.println("Turn: " + turn);
			System.out.print("Plz choose position (R,C) :");
			
			try {
				int R = Integer.parseInt(kb.next()) - 1;
				int C = Integer.parseInt(kb.next()) - 1;			
				if (R > 2 || R < 0 || C < 0 || C > 2) {
					System.out.println("Row and Column must be number 1 - 3");
					printBoard();
					continue;
				}
				else if(!board[R][C].equals(" ") ) {
					System.out.println("Row "+(R+1)+" and Column "+(C+1)+" can't choose again");
					printBoard();
					continue;
				}
				board[R][C] = turn;
				break ;
			}
			catch(Exception a ) {
				System.out.println("Row and Column must be number");
				printBoard();
				continue;				
			}
			
		}
	}
	public static boolean checkDraw() {
		boolean chk = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == " ") {
					chk = true;
				}
			}
		}
		if (chk == false) {
			return true ;
		}
		return false ;
	}
	public static void switchTurn() {
		if (turn.equals("X")) {
			turn = "O";
		} else {
			turn = "X";
		}	
	}
	public static void printWin() {
		printBoard();
		System.out.print(turn + " : WIN");
	}
	public static void printDraw() {
		printBoard();
		System.out.print("DRAW");
	}
}
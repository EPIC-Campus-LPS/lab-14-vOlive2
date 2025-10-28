import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) throws IOException {
		System.out.print("Input: ");
		Scanner scan = new Scanner(System.in);
		File f = new File(scan.nextLine());
		scan = new Scanner(f);
		String[][] board = new String[10][10];
		for(int i = 0; i < 10; i++) {
			String line = scan.nextLine();
			String[] splitline = line.split(",");
			if(splitline.length != 10) {}//false;
			board[i] = splitline;
		}
		scan.close();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(board[i][j] + ", ");
			}
			System.out.println();
		}
		
		
	}
}

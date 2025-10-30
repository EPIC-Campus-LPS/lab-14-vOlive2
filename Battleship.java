import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Battleship {
	public static void main(String[] args) throws IOException {
		boolean valid = true;
		System.out.print("Input: ");
		Scanner scan = new Scanner(System.in);
		File f = new File(scan.nextLine());
		scan = new Scanner(f);
		String[][] board = new String[12][12];
		String [] topbottom = {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"};;
		board[0] = topbottom;
		board[11] = topbottom;
		for(int i = 1; i < 11; i++) {
			String line = scan.nextLine();
			String[] splitline = line.split(",");
			if(splitline.length != 10) valid = false;
			String [] row = {"|", splitline[0], 
										splitline[1], 
										splitline[2],
										splitline[3], 
										splitline[4], 
										splitline[5],
										splitline[6],
										splitline[7],
										splitline[8],
										splitline[9], "|"};;
			board[i] = row;
		}
		scan.close();
		System.out.println("Valid: " + (valid&&validate(board)));
		System.out.println("Balanced: " + (balanced(board)));
		for(String[] i : board) {
			for(String j : i) {
				System.out.print(j + " ");
			}
			System.out.print("\n");
		}
	}
	public static boolean validate(String board[][]) {
		boolean valid = true;
		int c = 5, b = 4, r = 3, s = 3, d = 2;
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 11; j++) {
				if(!(board[i][j].equals("0"))) {
					boolean left = board[i][j].equals(board[i][j-1]);
					boolean right = board[i][j].equals(board[i][j+1]);
					boolean down = board[i][j].equals(board[i-1][j]);
					boolean up = board[i][j].equals(board[i+1][j]);
					if(!(left||right||down||up)) valid = false;
					if((board[i][j].equals("C"))) c--;
					if((board[i][j].equals("B"))) b--;
					if((board[i][j].equals("R"))) r--;
					if((board[i][j].equals("S"))) s--;
					if((board[i][j].equals("D"))) d--;
				}
			}
		}
		if ((c+b+r+s+d) != 0) valid = false; 
		return valid;
	}
	public static boolean balanced(String board[][]) {
		boolean balance = true;
		for(int i = 1; i < 11; i++) { //Rows
			int c = 0, b = 0, r = 0, s = 0, d = 0;
			for(int j = 1; j < 11; j++) {
				if((board[i][j].equals("C"))) c=1;
				if((board[i][j].equals("B"))) b=1;
				if((board[i][j].equals("R"))) r=1;
				if((board[i][j].equals("S"))) s=1;
				if((board[i][j].equals("D"))) d=1;
			}
			if((c+b+r+s+d) > 2) balance = false;
		}
		for(int i = 1; i < 11; i++) { //Columns
			int c = 0, b = 0, r = 0, s = 0, d = 0;
			for(int j = 1; j < 11; j++) {
				if((board[j][i].equals("C"))) c=1;
				if((board[j][i].equals("B"))) b=1;
				if((board[j][i].equals("R"))) r=1;
				if((board[j][i].equals("S"))) s=1;
				if((board[j][i].equals("D"))) d=1;
			}
			if((c+b+r+s+d) > 2) balance = false;
		}
		return balance;
	}
}

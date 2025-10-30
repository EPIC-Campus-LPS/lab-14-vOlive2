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
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				System.out.print(board[i][j] + ", ");
			}
			System.out.println();
		}
		int c = 5;
		int b = 4;
		int r = 3;
		int s = 3;
		int d = 2;
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
		System.out.print(valid);
	}
}

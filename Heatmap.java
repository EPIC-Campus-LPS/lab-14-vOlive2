import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Heatmap {
	private double[][] data;
	public Heatmap(int rows, int cols, String filename) throws IOException {
		data = new double[rows][cols];
		System.out.println();
		setData(filename);
	}
	private void setData(String filename) throws IOException {
		File f = new File(filename);
		System.out.print("R: " + data.length + ", C: " + data[0].length + "\n\n");
		Scanner scan = new Scanner(f);
		String line = scan.nextLine();
		for(int i = 0; i < data.length; i++) {
			line = scan.nextLine();
			String[] splitline = line.split(",");
			for(int j = 0; j < data[0].length; j++) {
				data[i][j] = Double.parseDouble(splitline[j+1]);
			}
		}
		scan.close();
	}
	public void printHeatmap() {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + ", ");
			}
			System.out.println();
		}
	}
	public double sumHeatmap() {
		double sum = 0.0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				sum+=data[i][j];
			}
		}
		return sum;
	}
	public double avgHeatmap() {
		double sum = 0.0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				sum+=data[i][j];
			}
		}
		return sum/(data.length * data[0].length);
	}
	public double sumColumn(int col) {
		double sum = 0.0;
		for(int i = 0; i < data.length; i++) {
			sum+=data[i][col];
		}
		return sum;
	}
	public double sumRow(int row) {
		double sum = 0.0;
		for(int i = 0; i < data[0].length; i++) {
			sum+=data[row][i];
		}
		return sum;
	}	
	public int areCold() {
		int total = 0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] <= 10)
				total++;
			}
		}
		return total;

	}
}

package metrix;

import java.util.Scanner;


public class Metrix {

	public static void search(int matrix[][]) {
		int largest=Integer.MIN_VALUE;
		int smallest= Integer.MAX_VALUE;
		for(int i=0; i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(largest<matrix[i][j]) {
					largest=matrix[i][j];
				}
				System.out.println("found"+i+" "+j+" "+largest);

				if(smallest>matrix[i][j]) {
					smallest=matrix[i][j];
				}
				System.out.println("found"+i+" "+j+" "+smallest);

			}
		}
		System.out.println("largest"+" "+largest);
		System.out.println("smallest"+" "+smallest);
		
	}
	
	public static void main(String[] args) {
		int matrix[][]= new int[3][3];
		
		int n=matrix.length;  /// row
				int m=matrix[0].length;  // column
		
		Scanner sc= new Scanner(System.in);
for(int i=0; i<n;i++) {
	for(int j=0;j<m;j++) {
		matrix[i][j]=sc.nextInt();
	}
}

// output 
for(int i=0; i<n;i++) {
	for(int j=0;j<m;j++) {
		System.out.print(matrix[i][j]+ " ");
		
	}
	System.out.println();
}
search(matrix);
	}

}

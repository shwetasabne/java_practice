package ctci_chapter1;

import java.util.Random;

public class ArrayProblems {

	private static int [][] baseArray;

	private static void generateBaseArrayNN(int M, int N){
		Random rand = new Random();
		
		for(int i=0; i < M; i++){
			for(int j=0; j< N; j++){
				baseArray[i][j] = rand.nextInt((10))   ;
				System.out.print( baseArray[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	
	public static void rotateArrayBy90(int N){
		
		// Initialize the array N
		baseArray = new int[N][N];
		
		// Generate the array randomly
		generateBaseArrayNN(N, N);
		
		System.out.println();
		System.out.println();
		// Now do my ninja computing
		int [][] newArr = new int[N][N];
		
		for(int i=0; i < N; i++){
			for(int j=0; j< N; j++){
				newArr[N-1-i][j] = baseArray[j][i];
			}
		}
		baseArray = newArr;
		for(int i=0; i < N; i++){
			for(int j = 0 ; j < N; j++ ){
				System.out.print( baseArray[i][j] + "  ");
			}
			System.out.println();
		}
	
	}
	
	
	public static void nullify(int M, int N){

		// Initialize the array N
		baseArray = new int[M][N];

		// Generate the array randomly
		generateBaseArrayNN(M, N);
		
		//Now work on nullification, 2 boolean arrays
		boolean[] row = new boolean[baseArray.length];
		boolean[] col = new boolean[baseArray[0].length];
		
		for(int i=0; i < M; i++){
			for(int j=0; j < N ; j++){
				if(baseArray[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for (int i=0; i < row.length; i++){
			if(row[i]) nullifyRow(i);
		}
		
		for(int j=0; j < col.length; j++){
			if(col[j]) nullifyCol(j);
		}
		
		System.out.println();
		for(int i=0; i < baseArray.length; i++){
			for(int j=0; j < baseArray[0].length; j++){
				System.out.print( baseArray[i][j] + "  ");
			}
			System.out.println();
		}
	}

	private static void nullifyRow(int i) {
		
		for(int j=0; j < baseArray[0].length; j++){
			baseArray[i][j] = 0;
		}
	}

	private static void nullifyCol(int i) {
		
		for(int j=0; j < baseArray.length; j++){
			baseArray[j][i] = 0;
		}
	}
	
	public static void main(String[] args) {
		
	//	System.out.println("Testing Rotation");
	//	rotateArrayBy90(4);		
		
		System.out.println("Testing Nullify");
		nullify(4,5);
	}

}

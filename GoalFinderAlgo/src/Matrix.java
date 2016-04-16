
public class Matrix {
	
	public int maxRowSize;

	public char[][] grid ;
	
	public Matrix(int val){
		this.maxRowSize = val;
		this.grid = new char [this.maxRowSize][this.maxRowSize];
	}
	
	public void drawMatrix(){
		
		for(int i=0; i<this.maxRowSize; i++){
			for(int j=0; j<this.maxRowSize; j++){
				this.grid[i][j]=' ';
			}
		}
		for(int i=0; i<this.maxRowSize; i++){
			this.grid[i][0] = 'B';
			this.grid[i][5] = 'B';
		}
		for(int i=0; i<this.maxRowSize; i++){
			this.grid[0][i] = 'B';
			this.grid[5][i] = 'B';
		}
		this.grid[0][3] ='S';
		this.grid[3][2] = 'G';
		this.grid[2][3] = 'B';
		this.grid[4][2] = 'B';
		this.grid[3][4] = 'B';

	}
	
	public void printMatrix(){
		
		for(int i=0; i< this.maxRowSize; i++){
			for(int j=0; j<this.maxRowSize; j++){
				
				System.out.print(this.grid[i][j] + " ");
			}
			System.out.println("");
		}
	}
	

}

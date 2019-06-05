
public class chessBoard {
	
	private static int board[][];
	private int numQueens;

	public chessBoard() {
		
		numQueens = 0;
		board = new int[8][8];
		
		for( int i = 0 ; i < 8 ; i++){
			
			for( int j = 0 ; j < 8 ; j++){
				
				board[i][j] = 0 ;
			}
		}
		
	}

	public int getNumQueens() {
		return numQueens;
	}

//	public void setNumQueens(int numQueens) {
//		this.numQueens = numQueens;
//	}
	
	public void start(){
		
		solve(0);
	}
	
	public boolean solve(int numQueens){
		
		
		if( numQueens == 8){
			System.out.println("DONE" + "\n");
			this.printBoard();
			return true;
		}
		else{
			
			for(int i = 0 ; i < 8 ; i++){
				
				for( int j = 0 ; j < 8 ; j++){
					if(validMove(i, j) == 0){
						this.placeQueen(i, j, 0);
						numQueens++;
						if(solve(numQueens)){
							return true;
						}
						else{
							this.placeQueen(i, j, 1);
							numQueens--;
						}
					}
				}
			}
		}
		
		return false;	
	}
	
	public static int get(int x, int y){
		
		if(x < 0 || y < 0 || x > 7 || y > 7){
			//System.out.println("Needs debugging in get()");
			return -1;
		}
		
		return board[x][y];
	}
	
	public static int validMove(int x, int y){
		
		for( int i = 0 ; i < 8 ; i++){
			
			if(get(x, i) == 1){
				return -1;
			}
			if(get(i, y) == 1){
				return -1;
			}
		}
		
		//check diagonal
		
		for( int i = 0 ; i < 8 ; i++){
			
			if(get(x-i, y-i) == 1){
				return -1;
			}
			if(get(x-i, y+i) == 1){
				return -1;
			}
			if(get(x+i, y-i) == 1){
				return -1;
			}
			if(get(x+i, y+i) == 1){
				return -1;
			}
		}
		return 0;
	}
	
	public int placeQueen(int x, int y, int type){
		
		if(type == 0){
			board[x][y] = 1;
			numQueens++;
			return 0;
		}
		else if(type == 1){
			board[x][y] = 0;
			return 0;
		}
		
		System.out.println("Input correctly!");
		return -3;
	}
	
	public void printBoard(){
		
		for( int i = 0 ; i < 8 ; i++){
			
			for( int j = 0 ; j < 8 ; j++){
				System.out.print(this.get(i, j) + " ");
			}
			System.out.println("");
		}
	}
}

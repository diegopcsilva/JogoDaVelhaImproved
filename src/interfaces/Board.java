package interfaces;


public class Board {
	
	private  final int EMPTY = 0;
	private final int ROW_1 = 0;
	private final int COLUMN_1 = 0;
	private final int PC = 1;
	private final int ROW_2 = 1;
	private final int COLUMN_2 = 1;
	private final int HUMAN = 2;
	private final int ROW_3 = 2;
	private final int COLUMN_3 = 2;
	
	int board[][] = new int[3][3];
	
	public Board() {
		
		for(int i=0;i<3;i++){
			
			for(int j=0;j<3;j++){
				board[i][j]=0;	
			}
		}	
	}
	
	private boolean isEmptyBoard(int linha, int coluna, int[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == board[linha][coluna]){
					if(board[i][j] != 0){
						return false;
					}					
				}
			}
		}
		return true;
	}
	
	public boolean playerPlay(int a,int b,int[][] board){
		if(isEmptyBoard(a,b,board)){
			board[a][b]=HUMAN;
			return true;
		}
		System.out.println("Ja existe uma peça neste local.\n   Por Favor jogue em outra posição!");
		System.out.println("------------------------------------------------------------------");
		return false;
	}
		
	
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}

	public void reset() {
		for(int i=0;i<3;i++){
			
			for(int j=0;j<3;j++){
				board[i][j]=0;	
			}
		}
	}
	
	public void playerView(boolean change){
		
		if(change){
		
			if(board[ROW_1][COLUMN_1] == EMPTY) System.out.print("  ");
			if(board[ROW_1][COLUMN_1] == PC)    System.out.print("O ");//1 = AI
			if(board[ROW_1][COLUMN_1] == HUMAN) System.out.print("X ");//2 = Humano
			
			if(board[ROW_1][COLUMN_2] == EMPTY) System.out.print("  ");
			if(board[ROW_1][COLUMN_2] == PC)    System.out.print("O ");
			if(board[ROW_1][COLUMN_2] == HUMAN) System.out.print("X ");
			
			if(board[ROW_1][COLUMN_3] == EMPTY) System.out.print("  |\n");
			if(board[ROW_1][COLUMN_3] == PC)    System.out.print("O |\n");
			if(board[ROW_1][COLUMN_3] == HUMAN) System.out.print("X |\n");
			
			
			if(board[ROW_2][COLUMN_1] == EMPTY) System.out.print("  ");
			if(board[ROW_2][COLUMN_1] == PC)    System.out.print("O ");
			if(board[ROW_2][COLUMN_1] == HUMAN) System.out.print("X ");
			
			if(board[ROW_2][COLUMN_2] == EMPTY) System.out.print("  ");
			if(board[ROW_2][COLUMN_2] == PC)    System.out.print("O ");
			if(board[ROW_2][COLUMN_2] == HUMAN) System.out.print("X ");
			
			if(board[ROW_2][COLUMN_3] == EMPTY) System.out.print("  |\n");
			if(board[ROW_2][COLUMN_3] == PC)    System.out.print("O |\n");
			if(board[ROW_2][COLUMN_3] == HUMAN) System.out.print("X |\n");
			
			
			if(board[ROW_3][COLUMN_1] == EMPTY) System.out.print("  ");
			if(board[ROW_3][COLUMN_1] == PC)    System.out.print("O ");
			if(board[ROW_3][COLUMN_1] == HUMAN) System.out.print("X ");
			
			if(board[ROW_3][COLUMN_2] == EMPTY) System.out.print("  ");
			if(board[ROW_3][COLUMN_2] == PC)    System.out.print("O ");
			if(board[ROW_3][COLUMN_2] == HUMAN) System.out.print("X ");
			
			if(board[ROW_3][COLUMN_3] == EMPTY) System.out.print("  |\n");
			if(board[ROW_3][COLUMN_3] == PC)    System.out.print("O |\n");
			if(board[ROW_3][COLUMN_3] == HUMAN) System.out.print("X |\n\n");
		
		}else{
		
			if(board[ROW_1][COLUMN_1] == EMPTY) System.out.print("  ");
			if(board[ROW_1][COLUMN_1] == PC)    System.out.print("X ");
			if(board[ROW_1][COLUMN_1] == HUMAN) System.out.print("O ");
			
			if(board[ROW_1][COLUMN_2] == EMPTY) System.out.print("  ");
			if(board[ROW_1][COLUMN_2] == PC)    System.out.print("X ");
			if(board[ROW_1][COLUMN_2] == HUMAN) System.out.print("O ");
			
			if(board[ROW_1][COLUMN_3] == EMPTY) System.out.print("  |\n");
			if(board[ROW_1][COLUMN_3] == PC)    System.out.print("X |\n");
			if(board[ROW_1][COLUMN_3] == HUMAN) System.out.print("O |\n");
			
			
			if(board[ROW_2][COLUMN_1] == EMPTY) System.out.print("  ");
			if(board[ROW_2][COLUMN_1] == PC)    System.out.print("X ");
			if(board[ROW_2][COLUMN_1] == HUMAN) System.out.print("O ");
			
			if(board[ROW_2][COLUMN_2] == EMPTY) System.out.print("  ");
			if(board[ROW_2][COLUMN_2] == PC)    System.out.print("X ");
			if(board[ROW_2][COLUMN_2] == HUMAN) System.out.print("O ");
			
			if(board[ROW_2][COLUMN_3] == EMPTY) System.out.print("  |\n");
			if(board[ROW_2][COLUMN_3] == PC)    System.out.print("X |\n");
			if(board[ROW_2][COLUMN_3] == HUMAN) System.out.print("O |\n");
			
			
			if(board[ROW_3][COLUMN_1] == EMPTY) System.out.print("  ");
			if(board[ROW_3][COLUMN_1] == PC)    System.out.print("X ");
			if(board[ROW_3][COLUMN_1] == HUMAN) System.out.print("O ");
			
			if(board[ROW_3][COLUMN_2] == EMPTY) System.out.print("  ");
			if(board[ROW_3][COLUMN_2] == PC)    System.out.print("X ");
			if(board[ROW_3][COLUMN_2] == HUMAN) System.out.print("O ");
			
			if(board[ROW_3][COLUMN_3] == EMPTY) System.out.print("  |\n");
			if(board[ROW_3][COLUMN_3] == PC)    System.out.print("X |\n");
			if(board[ROW_3][COLUMN_3] == HUMAN) System.out.print("O |\n\n");
			
		}
	}
}


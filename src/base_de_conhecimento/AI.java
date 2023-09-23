package base_de_conhecimento;



import java.util.Random;
public class AI {
	
	Random gerador = new Random();
			
	static int round=0;
	
	static int center;
	static int corner;
	
	private static  int row1;
	private static int row2;
	private static int row3;
	
	private static int column1;
	private static int column2;
	private static int column3;
	
	private static int inclined1;
	private static int inclined2;
	
	protected boolean easy    ;
	protected boolean medium ;
	protected boolean hard   ;
	
	private final int EMPTY	= 0;
	private final int ROW_1	= 0;
	private final int COLUMN_1 =0;
	private final int PC = 1;
	private final int ROW_2 = 1;
	private final int COLUMN_2 = 1;
	private final int HUMAN = 2;
	private final int ROW_3 = 2;
	private final int COLUMN_3 = 2;
	
	public AI() {
		easy = false;
		medium = false;
		hard = false;
		
	}
	
	private void reset(){
		setColumn1(0);
		setColumn2(0);
		setColumn3(0);
		setRow1(0);
		setRow2(0);
		setRow3(0);
		setInclined1(0);
		setInclined2(0);
		setCenter(0);
		setCorner(0);
	}


	
	public void updateScore(int[][] board){
		reset();
				
		if (!easy) {
			if (board[ROW_2][COLUMN_2] == EMPTY)
				center = 12;
			if (board[ROW_1][COLUMN_1] == EMPTY)
				corner = 11;
			if (board[ROW_3][COLUMN_3] == EMPTY)
				corner = 11;
			if (board[ROW_1][COLUMN_3] == EMPTY)
				corner = 11;
			if (board[ROW_3][COLUMN_1] == EMPTY)
				corner = 11;
		} 
		
		
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == EMPTY) row1 = 1;
		
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_1][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == EMPTY) row1 = 0;//computador ser� 1("X")
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == HUMAN) row1 = 0;
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_1][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == EMPTY) row1 = 0;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == HUMAN) row1 = 0;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == PC) row1 = 0;
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == PC) row1 = 0;
		
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == EMPTY) row1 = 10;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == PC) row1 = 10;
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == EMPTY) row1 = 10;
		
		if (!medium) {
			if (board[ROW_1][COLUMN_1] == HUMAN
					& board[ROW_2][COLUMN_2] == HUMAN
					& board[ROW_3][COLUMN_3] == PC)
				row1 = 13;
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == HUMAN
					& board[ROW_1][COLUMN_3] == HUMAN)
				row1 = 13;// proteger contra fork
		}
		
		if (!easy) {
			
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_1][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == EMPTY) row1 = 100;
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == PC) row1 = 100;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == PC) row1 = 100;
		} else {
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_1][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == EMPTY) row1 = 1;
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == PC) row1 = 1;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == PC) row1 = 1;
		}
		
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_1][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == PC) row1 = 1000;
		
		//defesa
		
		if (!easy) {
			
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == HUMAN) row1 = 20;
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_1][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == EMPTY) row1 = 20;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == HUMAN) row1 = 20;
		} else {
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_1][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == HUMAN) row1 = 10;
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_1][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == EMPTY) row1 = 10;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_1][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == HUMAN) row1 = 10;
		}
		
		
		
		////////////////////////////////
		
		if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == EMPTY) row2 = 1;
		
		if (board[ROW_2][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_3] == EMPTY) row2 = 0;
		if (board[ROW_2][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == HUMAN) row2 = 0;
		if (board[ROW_2][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == PC & board[ROW_2][COLUMN_3] == EMPTY) row2 = 0;
		if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_2][COLUMN_3] == HUMAN) row2 = 0;
		if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_3] == PC) row2 = 0;
		if (board[ROW_2][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == PC) row2 = 0;
		
		if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_2][COLUMN_3] == EMPTY) row2 = 10;
		if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == PC) row2 = 10;
		if (board[ROW_2][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == EMPTY) row2 = 10;
		
		if(!medium) {
			if(board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == HUMAN 
					& board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_3] == EMPTY) row2 = 15;// evitar fork
		}
		if (!easy) {
			if (board[ROW_2][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_2][COLUMN_3] == EMPTY) row2 = 100;
			if (board[ROW_2][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == PC) row2 = 100;
			if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_2][COLUMN_3] == PC) row2 = 100;
		} else {
			if (board[ROW_2][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_2][COLUMN_3] == EMPTY) row2 = 1;
			if (board[ROW_2][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == PC) row2 = 1;
			if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_2][COLUMN_3] == PC) row2 = 1;
		}
		
		if (board[ROW_2][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_2][COLUMN_3] == PC) row2 = 1000;
		
		//defesa
		
		if (!easy) {
			if (board[ROW_2][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == HUMAN) row2 = 20;
			if (board[ROW_2][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_3] == EMPTY) row2 = 20;
			if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_3] == HUMAN) row2 = 20;
		} else {
			if (board[ROW_2][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_3] == HUMAN) row2 = 10;
			if (board[ROW_2][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_3] == EMPTY) row2 = 10;
			if (board[ROW_2][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_3] == HUMAN) row2 = 10;
		}
		
		
		
		///////////////////////////////////
		
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == EMPTY) row3 = 1;
		
		if (board[ROW_3][COLUMN_1] == PC & board[ROW_3][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) row3 = 0;
		if (board[ROW_3][COLUMN_1] == PC & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) row3 = 0;
		if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == EMPTY) row3 = 0;
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == HUMAN) row3 = 0;
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == PC) row3 = 0;
		if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == PC) row3 = 0;
		
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == EMPTY) row3 = 10;
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == PC) row3 = 10;
		if (board[ROW_3][COLUMN_1] == PC & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == EMPTY) row3 = 10;
		
		if (!medium) {
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == HUMAN
					& board[ROW_3][COLUMN_3] == HUMAN)
				row3 = 13;// proteger contra for
			if (board[ROW_3][COLUMN_1] == HUMAN
					& board[ROW_2][COLUMN_2] == HUMAN
					& board[ROW_1][COLUMN_3] == PC)
				row3 = 13;
		}
		if (!easy) {
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_3][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == EMPTY) row3 = 100;
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == PC) row3 = 100;
			if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == PC) row3 = 100;
		} else {
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_3][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == EMPTY) row3 = 1;
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == PC) row3 = 1;
			if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == PC) row3 = 1;
		}
		
		
		if (board[ROW_3][COLUMN_1] == PC & board[ROW_3][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == PC) row3 = 1000;
		
		//defesa
		
		if (!easy) {
			if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) row3 = 20;
			if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) row3 = 20;
			if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) row3 = 20;
		} else {
			if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) row3 = 10;
			if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) row3 = 10;
			if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) row3 = 10;
		}
		
		
		////////////////////////////////////
		
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == EMPTY) column1 = 1;
		
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_1] == EMPTY) column1 = 0;
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == HUMAN) column1 = 0;
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_1] == PC & board[ROW_3][COLUMN_1] == EMPTY) column1 = 0;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == PC & board[ROW_3][COLUMN_1] == HUMAN) column1 = 0;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_1] == PC) column1 = 0;
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == PC) column1 = 0;
		
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == PC & board[ROW_3][COLUMN_1] == EMPTY) column1 = 10;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == PC) column1 = 10;
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == EMPTY) column1 = 10;
		
		if (!medium) {
			if (board[ROW_1][COLUMN_1] == HUMAN
					& board[ROW_2][COLUMN_2] == HUMAN
					& board[ROW_3][COLUMN_3] == PC)
				column1 = 13;// proteger contra fork
			if (board[ROW_3][COLUMN_1] == HUMAN
					& board[ROW_2][COLUMN_2] == HUMAN
					& board[ROW_1][COLUMN_3] == PC)
				column1 = 13;
		}
		if (!easy) {
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_1] == PC & board[ROW_3][COLUMN_1] == EMPTY) column1 = 100;
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == PC) column1 = 100;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == PC & board[ROW_3][COLUMN_1] == PC) column1 = 100;
		} else {
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_1] == PC & board[ROW_3][COLUMN_1] == EMPTY) column1 = 1;
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == PC) column1 = 1;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == PC & board[ROW_3][COLUMN_1] == PC) column1 = 1;
		}
		
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_1] == PC & board[ROW_3][COLUMN_1] == PC) column1 = 1000;
		
		//def
		
		
		if (!easy) {
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == HUMAN) column1 = 20;
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_1] == EMPTY) column1 = 20;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_1] == HUMAN) column1 = 20;
		} else {
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_1] == EMPTY & board[ROW_3][COLUMN_1] == HUMAN) column1 = 10;
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_1] == EMPTY) column1 = 10;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_1] == HUMAN) column1 = 10;
		}
		
		
		////////////////////////////////
		
		if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == EMPTY) column2 = 1;
		
		if (board[ROW_1][COLUMN_2] == PC & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_2] == EMPTY) column2 = 0;
		if (board[ROW_1][COLUMN_2] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == HUMAN) column2 = 0;
		if (board[ROW_1][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_2] == EMPTY) column2 = 0;
		if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_2] == HUMAN) column2 = 0;
		if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_2] == PC) column2 = 0;
		if (board[ROW_1][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == PC) column2 = 0;
		
		if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_2] == EMPTY) column2 = 10;
		if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == PC) column2 = 10;
		if (board[ROW_1][COLUMN_2] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == EMPTY) column2 = 10;
		
		if (!medium) {
			if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == PC
					& board[ROW_1][COLUMN_3] == HUMAN
					& board[ROW_1][COLUMN_2] == EMPTY
					& board[ROW_3][COLUMN_2] == EMPTY)
				column2 = 15;// evitar fork
		}
		if (!easy) {
			if (board[ROW_1][COLUMN_2] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_2] == EMPTY) column2 = 100;
			if (board[ROW_1][COLUMN_2] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == PC) column2 = 100;
			if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_2] == PC) column2 = 100;
		} else {
			if (board[ROW_1][COLUMN_2] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_2] == EMPTY) column2 = 1;
			if (board[ROW_1][COLUMN_2] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == PC) column2 = 1;
			if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_2] == PC) column2 = 1;
		}
		
		if (board[ROW_1][COLUMN_2] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_2] == PC) column2 = 1000;
		
		//def
		
		if (!easy) {
			if (board[ROW_1][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == HUMAN) column2 = 20;
			if (board[ROW_1][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_2] == EMPTY) column2 = 20;
			if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_2] == HUMAN) column2 = 20;
		} else {
			if (board[ROW_1][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_2] == HUMAN) column2 = 10;
			if (board[ROW_1][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_2] == EMPTY) column2 = 10;
			if (board[ROW_1][COLUMN_2] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_2] == HUMAN) column2 = 10;
		}
		
		
		///////////////////////////////////
		
		if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == EMPTY) column3 = 1;
		
		if (board[ROW_1][COLUMN_3] == PC & board[ROW_2][COLUMN_3] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) column3 = 0;
		if (board[ROW_1][COLUMN_3] == PC & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) column3 = 0;
		if (board[ROW_1][COLUMN_3] == HUMAN & board[ROW_2][COLUMN_3] == PC & board[ROW_3][COLUMN_3] == EMPTY) column3 = 0;
		if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == PC & board[ROW_3][COLUMN_3] == HUMAN) column3 = 0;
		if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == HUMAN & board[ROW_3][COLUMN_3] == PC) column3 = 0;
		if (board[ROW_1][COLUMN_3] == HUMAN & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == PC) column3 = 0;
		
		if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == PC & board[ROW_3][COLUMN_3] == EMPTY) column3 = 10;
		if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == PC) column3 = 10;
		if (board[ROW_1][COLUMN_3] == PC & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == EMPTY) column3 = 10;
		
		if (!medium) {
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == HUMAN
					& board[ROW_1][COLUMN_3] == HUMAN)
				column3 = 13;
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == HUMAN
					& board[ROW_3][COLUMN_3] == HUMAN)
				column3 = 13;// proteger contra fork
		}
		if (!easy) {
			if (board[ROW_1][COLUMN_3] == PC & board[ROW_2][COLUMN_3] == PC & board[ROW_3][COLUMN_3] == EMPTY) column3 = 100;
			if (board[ROW_1][COLUMN_3] == PC & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == PC) column3 = 100;
			if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == PC & board[ROW_3][COLUMN_3] == PC) column3 = 100;
		} else {
			if (board[ROW_1][COLUMN_3] == PC & board[ROW_2][COLUMN_3] == PC & board[ROW_3][COLUMN_3] == EMPTY) column3 = 1;
			if (board[ROW_1][COLUMN_3] == PC & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == PC) column3 = 1;
			if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == PC & board[ROW_3][COLUMN_3] == PC) column3 = 1;
		}
		
		
		if (board[ROW_1][COLUMN_3] == PC & board[ROW_2][COLUMN_3] == PC & board[ROW_3][COLUMN_3] == PC) column3 = 1000;
		
		//def
		
		if (!easy) {
			if (board[ROW_1][COLUMN_3] == HUMAN & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) column3 = 20;
			if (board[ROW_1][COLUMN_3] == HUMAN & board[ROW_2][COLUMN_3] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) column3 = 20;
			if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) column3 = 20;
		} else {
			if (board[ROW_1][COLUMN_3] == HUMAN & board[ROW_2][COLUMN_3] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) column3 = 10;
			if (board[ROW_1][COLUMN_3] == HUMAN & board[ROW_2][COLUMN_3] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) column3 = 10;
			if (board[ROW_1][COLUMN_3] == EMPTY & board[ROW_2][COLUMN_3] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) column3 = 10;
		}
		
		
		/////////////////////////////////////
		
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 1;
		
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 0;
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) inclined1 = 0;
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 0;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == HUMAN) inclined1 = 0;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == PC) inclined1 = 0;
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == PC) inclined1 = 0;
		
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 10;
		if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == PC) inclined1 = 10;
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 10;
		
		if (!easy) {
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 100;
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == PC) inclined1 = 100;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == PC) inclined1 = 100;
		} else {
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 1;
			if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == PC) inclined1 = 1;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == PC) inclined1 = 1;
		}
		
		if (board[ROW_1][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_3][COLUMN_3] == PC) inclined1 = 1000;
		
		//def
		
		if (!medium) {
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) inclined1 = 20;
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 20;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) inclined1 = 20;
		} else {
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_3][COLUMN_3] == HUMAN) inclined1 = 10;
			if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == EMPTY) inclined1 = 10;
			if (board[ROW_1][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) inclined1 = 10;
		}
		
		
		//////////////////////////////////
		
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == EMPTY) inclined2 = 1;
		
		if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == EMPTY) inclined2 = 0;
		if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == HUMAN) inclined2 = 0;
		if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == EMPTY) inclined2 = 0;
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == HUMAN) inclined2 = 0;
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == PC) inclined2 = 0;
		if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == PC) inclined2 = 0;
		
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == EMPTY) inclined2 = 10;
		if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == PC) inclined2 = 10;
		if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == EMPTY) inclined2 = 10;
		
		if (!easy) {
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == EMPTY) inclined2 = 100;
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == PC) inclined2 = 100;
			if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == PC) inclined2 = 100;
		} else {
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == EMPTY) inclined2 = 1;
			if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == EMPTY & board[ROW_1][COLUMN_3] == PC) inclined2 = 1;
			if (board[ROW_3][COLUMN_1] == EMPTY & board[ROW_2][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == PC) inclined2 = 1;
		}
		
		if (board[ROW_3][COLUMN_1] == PC & board[ROW_2][COLUMN_2] == PC & board[ROW_1][COLUMN_3] == PC) inclined2 = 1000;
		
		//player ganha
		
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_1][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == HUMAN) row1      = 1001;
		if (board[ROW_2][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_3] == HUMAN) row2 	 = 1001;
		if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) row3 	 = 1001;
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_1] == HUMAN & board[ROW_3][COLUMN_1] == HUMAN) column1 	 = 1001;
		if (board[ROW_1][COLUMN_2] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_2] == HUMAN) column2 	 = 1001;
		if (board[ROW_1][COLUMN_3] == HUMAN & board[ROW_2][COLUMN_3] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) column3 	 = 1001;
		if (board[ROW_1][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_3][COLUMN_3] == HUMAN) inclined1 = 1001;
		if (board[ROW_3][COLUMN_1] == HUMAN & board[ROW_2][COLUMN_2] == HUMAN & board[ROW_1][COLUMN_3] == HUMAN) inclined2 = 1001;
		
	}
	
	public int getCenter() {
		return center;
	}

	public void setCenter(int center) {
		AI.center = center;
	}

	public int getCorner() {
		return corner;
	}

	public static void setCorner(int corner) {
		AI.corner = corner;
	}

	public int getRow1() {
		return row1;
	}
	public void setRow1(int row1) {
		AI.row1 = row1;
	}
	public int getRow2() {
		return row2;
	}
	public void setRow2(int row2) {
		AI.row2 = row2;
	}
	public int getRow3() {
		return row3;
	}
	public static void setRow3(int row3) {
		AI.row3 = row3;
	}
	public int getColumn1() {
		return column1;
	}
	public static void setColumn1(int column1) {
		AI.column1 = column1;
	}
	public int getColumn2() {
		return column2;
	}
	public static void setColumn2(int column2) {
		AI.column2 = column2;
	}
	public int getColumn3() {
		return column3;
	}
	public static void setColumn3(int column3) {
		AI.column3 = column3;
	}
	public int getInclined1() {
		return inclined1;
	}
	public static void setInclined1(int inclined1) {
		AI.inclined1 = inclined1;
	}
	public int getInclined2() {
		return inclined2;
	}
	public static void setInclined2(int inclined2) {
		AI.inclined2 = inclined2;
	}
	
}


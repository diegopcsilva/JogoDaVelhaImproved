package interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

import motor_de_inferencia.Engine;


public class Start {

	private static Scanner sc;
	private int toStart;
	private boolean start;
	private int level;
	private int toPiece;
	private boolean piece;

	public void start() {
		
		try {
			while(true){
				System.out.println("Inicio - Jogo da Velha");
				sc = new Scanner(System.in);
				while(true){
					System.out.println("Quer começar? Se sim digite: 0. Se não digite: 1 ");
					toStart = sc.nextInt();
					if( toStart == 0 || toStart == 1){
						if(toStart==0) start =true;
						else start = false;
						break;
					}		
				}
				while(true){
					
					System.out.println("Quer ser X ou O? Se X, digite: 0. Se não digite: 1 ");
					
					toPiece = sc.nextInt();
					if( toPiece == 0 || toPiece == 1){
						if(toPiece==0) piece =true;
						else piece = false;
						break;
					}
				}
				while(true){
					System.out.println("Escolha o nível. Para fácil: 0 , médio: 1, difícil: 2.");
					level = sc.nextInt();
					if( level == 0 || level == 1 || level == 2) break;
				}
				play();
			}
		} catch (InputMismatchException ime) {
			System.out.println("Dado informado não corresponde ao que foi solicitado");
			System.out.println("----------------------------------------\n");
			start();			
		} catch(Exception e){
			e.getStackTrace();
		}
	}
public void play(){
		
		Board board = new Board();
		Engine engine = new Engine(level, board.getBoard());
				
		boolean loop = true;
		while (loop) {
			board.reset();

			boolean inGameJogo = true;
			while (inGameJogo) {

				if (start) {
					int whileBreaker = 0;
					do{
						int teste = getEixoX();
						int teste2 = getEixoY();
						
						
						boolean isPlayPossible = board.playerPlay(teste, teste2, board.getBoard() );
						if(isPlayPossible){
							engine.update();
							board.playerView(piece);
							whileBreaker = 1;
						} 
					} while (whileBreaker == 0);
					if(end()) break;
				}
				start = true;
				System.out.println("Vez do computador.");
				board.setBoard(engine.moviment());
				
				engine.update();
				board.playerView(piece);
				if(end()) break;
			}
				break;	
		}

	}
public boolean end(){
	if (Engine.velha()) {
		System.out.println("Deu velha.");
		System.out.println("----------------------------------------\n");
		return true;
	}
	if (Engine.aiWin()) {
		System.out.println("Voce Perdeu.");
		System.out.println("----------------------------------------\n");
		return true;
	}
	if (Engine.playerWin()) {
		System.out.println("Voce Ganhou.");
		System.out.println("----------------------------------------\n");
		return true;
	}
return false;
}
	public int getEixoX() {		
		
		try {
			int whileBreak = 0;
			int eixoX;
			do {
				sc.reset();
				System.out.println("Escolha uma posicao, digitando a linha (1-3)");
				eixoX = Integer.parseInt(sc.next());
				eixoX-= 1;
				if (eixoX >= 0 && eixoX <= 2) {
					whileBreak = 1;
				} else {
					System.out.println("Valor não está no intervalo entre 1 e 3\n");
					System.out.println("------------------------------------------\n");
				}
			} while (whileBreak == 0);
			return eixoX;
		} catch (Exception e) {
			System.out.println("valor digitado é invalido!");
			System.out.println("------------------------------------------\n");
			return getEixoX();
		}
	}


	public int getEixoY() {		
		
		try {
			int whileBreak = 0;
			int eixoY;
			do {
				sc.reset();
				System.out.println("Escolha uma posicao, digitando a coluna (1-3)");
				 eixoY = Integer.parseInt(sc.next());
				 eixoY-= 1;				 
				if (eixoY >= 0 && eixoY <= 2) {
					whileBreak =1;
				} else {
					System.out.println("Valor não está no intervalo entre 1 e 3\n");
					System.out.println("------------------------------------------\n");
				}				
			} while (whileBreak == 0);
			return eixoY;
		} catch (Exception e) {
			System.out.println("valor digitado é invalido!");
			System.out.println("------------------------------------------\n");
			return getEixoY();
		}
	}
}


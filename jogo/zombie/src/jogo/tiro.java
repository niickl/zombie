package jogo;

import jplay.Sprite;

public class tiro extends Sprite {


	public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;  
	
	protected static final int VELOCIDADE_TIRO = 1;
	protected int caminho = STOP;
	protected boolean movendo = false;
	protected int direcao = 3;
	
	
	public tiro(double x, double y, int caminho) {
		super("C:\\Users\\test\\Documents\\codigos\\java\\zombie\\jogo\\zombie\\src\\recursos\\sprites\\tiro.png", 16);
		this.caminho = caminho;
		this.x = x;
		this.y = y;
	}
	
	public void mover() {
		if(caminho == LEFT) {
			this.x -= VELOCIDADE_TIRO;
			if (direcao != 1) {
				setSequence(4, 7);
			}
		movendo = true;
		}
		if(caminho == RIGHT) {
			this.x += VELOCIDADE_TIRO;
			if (direcao != 2) {
				setSequence(7, 11);
			}
		movendo = true;
		}
		if(caminho == UP) {
			this.y -= VELOCIDADE_TIRO;
			if (direcao != 4) {
				setSequence(12, 15);
			}
		movendo = true;
		}
		if(caminho == DOWN || caminho == STOP) {
			this.y += VELOCIDADE_TIRO;
			if (direcao != 5) {
				setSequence(0, 3);
			}
		movendo = true;
		}
		if(movendo) {
			update();
			movendo = false;
		}
	}
	
}

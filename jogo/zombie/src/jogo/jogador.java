package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class jogador extends ator {
	
	static double energia = 2000;

	public jogador(int x, int y) {
		super("C:\\Users\\test\\Documents\\codigos\\java\\zombie\\jogo\\zombie\\src\\recursos\\sprites\\jogador.png", 20);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
	}
	
	
	controleTiros tiros = new controleTiros();
	public void atirar (Window janela, Scene cena, Keyboard teclado, ator inimigo ) {
		
		if(teclado.keyDown(KeyEvent.VK_A)) {
			tiros.addTiro(x + 5, y + 12, direcao, cena);
		}
		tiros.run(inimigo);
	}
	
	
	public void mover(Window janela, Keyboard teclado) {
		
		if (teclado.keyDown(Keyboard.LEFT_KEY) == true){
			if (this.x > 0) this.x -= velocidade;
			if (direcao != 1) {
				setSequence(4, 8);
				direcao = 1;
			}
			movendo = true;
		} else if (teclado.keyDown(Keyboard.RIGHT_KEY) == true) {
			if (this.x < janela.getWidth() - 60 ) this.x += velocidade;
			if (direcao != 2) {
				setSequence(8, 12);
				direcao = 2;
			}
			movendo = true;
			
		} else if (teclado.keyDown(Keyboard.UP_KEY) == true) {
			if (this.y >  0) this.y -= velocidade;
			if (direcao != 4) {
				setSequence(12, 16);
				direcao = 4;
			} 
			movendo = true;
			
		} else if (teclado.keyDown(Keyboard.DOWN_KEY) == true) {
			if (this.y < janela.getHeight() - 60) this.y += velocidade;
			if (direcao != 5) {
				setSequence(0, 4);
				direcao = 5;
			} 
			movendo = true;			
		}
		
		if(movendo) {
			update(); 
			movendo = false;
	}

   }


	Font f = new Font("Arial", Font.BOLD, 30);
	
	public void energia(Window janela) {
		janela.drawText("vida: " + jogador.energia, 30, 30, Color.GREEN, f);
	}
}
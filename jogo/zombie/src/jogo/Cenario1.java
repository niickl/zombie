package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;



public class Cenario1 {
	
	private jogador Jogador;

	private Window janela;
	private Scene cena;
	private Keyboard teclado;
	
	public Cenario1(Window window) {
		
		janela = window;
		cena = new Scene();
		cena.loadFromFile("C:\\Users\\nicel\\OneDrive\\Documentos\\codigos\\java\\jogo\\zombie\\src\\recursos\\scn\\Cenario1.scn");
		Jogador = new jogador(540, 350);
		teclado = janela.getKeyboard();
		run();
		
	}
	
	private void run () {
		while(true) {
			//cena.draw();
			Jogador.mover(janela, teclado);
			Jogador.caminho(cena);
			
			cena.moveScene(Jogador);
			
			Jogador.x += cena.getXOffset();
			Jogador.y += cena.getYOffset();
			
			Jogador.draw();
			janela.update();
		}
	}
}

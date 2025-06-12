package jogo;

import java.util.LinkedList;

import jplay.Scene;

public class controleTiros {

	LinkedList<tiro> tiros = new LinkedList<>();
	
	public void addTiro(double x, double y, int caminho, Scene cena) {
		tiro Tiro = new tiro(x, y , caminho);
		tiros.addFirst(Tiro);
		cena.addOverlay(Tiro);
		somDisparo();
	}
	
	public void run(ator inimigo) {
		for (int i = 0; i < tiros.size(); i++) {
			tiro Tiro = tiros.removeFirst();
			Tiro.mover();
			tiros.addLast(Tiro);
			
			if (Tiro.collided(inimigo)) {
				Tiro.x = 10_000;
				inimigo.energia -= 250;
				}
			}
		}
	
	private void somDisparo() {
		som.playEffect("C:\\Users\\test\\Documents\\codigos\\java\\zombie\\jogo\\zombie\\src\\recursos\\som\\tiro.WAV");
	}
	
}

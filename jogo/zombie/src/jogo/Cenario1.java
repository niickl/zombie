package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Cenario1  {
    
    private jogador Jogador;

    private Window janela;
    private Scene cena;
    private Keyboard teclado;
    private zumbi zumbi1[];
    
    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile("C:\\Users\\test\\Documents\\codigos\\java\\zombie\\jogo\\zombie\\src\\recursos\\scn\\Cenario1.scn");
        Jogador = new jogador(540, 350);
        teclado = janela.getKeyboard();

        zumbi1 = new zumbi[10];
        som.play("C:\\Users\\test\\Documents\\codigos\\java\\zombie\\jogo\\zombie\\src\\recursos\\som\\drama.wav");
        run();
    }
    
    private void run () {
        
        for(int i = 0; i < zumbi1.length; i++) {
            zumbi1[i] = new zumbi(100 * i, 100 * i);
        }
        
        while(true) {
            //cena.draw();
            Jogador.mover(janela, teclado);
            Jogador.caminho(cena);
            
            cena.moveScene(Jogador);
            
            Jogador.x += cena.getXOffset();
            Jogador.y += cena.getYOffset();
            
            for (int i = 0; i < zumbi1.length; i++) {
                zumbi1[i].caminho(cena);
                zumbi1[i].perseguir(Jogador.x, Jogador.y);
                zumbi1[i].x += cena.getXOffset();
                zumbi1[i].y += cena.getYOffset();
                zumbi1[i].draw();
                Jogador.atirar(janela, cena, teclado, zumbi1[i]);
                zumbi1[i].morrer();
                zumbi1[i].atacar(Jogador);
            }
            
            Jogador.draw();
            Jogador.energia(janela);
            
            janela.update();
        }
    }
}

package jogo;

import javax.sound.sampled.*;
import java.io.File;

public class som {

    private static Clip musica;

    public static void play(String audio) {
        try {
            if (musica != null && musica.isRunning()) {
                musica.stop();
            }
            File audioFile = new File(audio);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            musica = AudioSystem.getClip();
            musica.open(audioInputStream);
            musica.start();
            // Para loop infinito: musica.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (musica != null && musica.isRunning()) {
            musica.stop();
        }
    }

    // Novo método para efeitos sonoros (ex: tiro)
    public static void playEffect(String audio) {
        new Thread(() -> {
            try {
                File audioFile = new File(audio);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                Clip efeito = AudioSystem.getClip();
                efeito.open(audioInputStream);
                efeito.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

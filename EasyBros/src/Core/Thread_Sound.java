package Core;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Thread_Sound extends Thread{
    
    public Thread_Sound() {
        
    }

    public void play_main() {
        try {
            AudioInputStream AudioIn = AudioSystem.getAudioInputStream(getClass().getResource("/Recursos/S_main.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(AudioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error al Reproducir Main Theme" + e);
        }
    }
    
    public void play_Jump() {
        try {
            AudioInputStream AudioIn = AudioSystem.getAudioInputStream(getClass().getResource("/Recursos/S_Jump.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(AudioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error al Reproducir Jump" + e);
        }
    }
    
    public void play_Money() {
        try {
            AudioInputStream AudioIn = AudioSystem.getAudioInputStream(getClass().getResource("/Recursos/S_Money.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(AudioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error al Reproducir Moneda" + e);
        }
    }

    @Override
    public void run() {
        play_main();
    }
}

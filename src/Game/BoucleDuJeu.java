package Game;

import java.util.List;
import java.util.TimerTask;

import javax.swing.JFrame;

public class BoucleDuJeu extends TimerTask {
	

	public Dessin dessin;
	public Mario mario;
	public List<PlateForme> plateFormes;
	public float t = 0.0f;
	
	public BoucleDuJeu(Dessin dessin, Mario mario, List<PlateForme> plateFormes){
		this.mario = mario;
		this.dessin = dessin;
		this.plateFormes = plateFormes;
		
	}
	
	public void run() {
		Jeu.Score--;
		t=t+1;
		this.dessin.repaint();
	}

}

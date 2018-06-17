package Game;

import java.util.List;
import java.util.TimerTask;

import javax.swing.JFrame;

public class BoucleDuJeu extends TimerTask {
	

	public Dessin dessin;
	public Mario mario;
	public Tonneau tonneau;
	public List<PlateForme> plateFormes;
	public float t = 0.0f;
	
	public BoucleDuJeu(Dessin dessin, Mario mario, Tonneau tonneau, List<PlateForme> plateFormes){
		this.mario = mario;
		this.tonneau = tonneau;
		this.dessin = dessin;
		this.plateFormes = plateFormes;
		
	}
	
	public void run() {
		System.out.println("Main loop");
		tonneau.tombeTonneau();
		Jeu.Score--;
		t=t+1;
		this.dessin.repaint();
	}

}

package Game;

import javax.swing.JPanel;

public class Echelle {
	private Position p;
	private JPanel jp;
//	private int taille;
	private int nbPlateForme;
	private int positionReletifEchelle;
	
//	private int x;
	
	
	
	//hauteur, x, attacher en haut ou bas
	public  Echelle(JPanel  jp, Position p, int nbPateForme, int positionRelativeEchelle){
		this.jp = jp;
		this.p = p;
		this.nbPlateForme = nbPlateForme; 
		this.positionReletifEchelle = positionReletifEchelle;		
//		this.x = x;
//		this.taille = taille;
	}

	public Position positionEchelle(){
		return p;
	}
}

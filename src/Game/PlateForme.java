package Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;



public class PlateForme {

	private Position p;
	private int LONGUER_PLAT_FORME = 800;
	private int HAUTEUR_PLAT_FORME = 20;
	final int X_PLATFORM = 100;
	final int Y_PLATFORM = 50;
	private int solPlatForme;
	private JPanel jp;
	private ArrayList<Echelle> echelles;
	private int nbPlateForme;
	private int vecteurDirectionX = 0;
	private int vecteurDirectionY = 1;
	private int SPEED = 4;

	
	public PlateForme(JPanel jp, Position p, List<Echelle> echelles2, int nbPlateForme){
		this.jp = jp;	
		this.p = p;
		this.echelles = new ArrayList<Echelle>(echelles2);
		this.nbPlateForme = nbPlateForme;
	}
	
	public Position positionPlateForme(){
		return p;
	}
	
	public int nbPlateForme(){
		return nbPlateForme;
	}
	
	public ArrayList<Echelle> EchellesDePlateForme(){
		return echelles;		
	}
	
}

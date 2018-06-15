package Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;



public class PlateForme {

	private Position p;
	private int LONGUER_PLAT_FORME = 800;
	private int HAUTEUR_PLAT_FORME = 20;
	private int solPlatForme;
	private JPanel jp;
	private ArrayList<Echelle> echelles;
	private int nbPlateForme;

	
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
//	
//	public boolean EchelleAppartinAPlateForme(Echelle e){
//		for (int i = 0; i < echelles.length; i++){
//			if(this.echelles[i]== e){
//				return true;
//			}
//		}
//		return false;
//	}

//	for (int i = 0; i < echelles.size(); i++) {
//		this.echelles[i] = echelles[i];
//	}
	

}

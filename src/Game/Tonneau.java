package Game;

import javax.swing.JPanel;

public class Tonneau {
	private JPanel jp;
	public Position p; 
	public PlateForme platforme;
	
	public Tonneau(JPanel jp, PlateForme plateForme){
		this.jp=jp;
		this.platforme = plateForme;
		this.p = new Position(plateForme.positionPlateForme().getX() + 100, plateForme.positionPlateForme().getY());
		
	}
	
	public Position getP() {
		return p;
	}
	
	public void tombeTonneau(){
		
	}

}

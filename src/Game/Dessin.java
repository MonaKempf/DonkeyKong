package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dessin extends JPanel {
	private List<PlateForme> plateFormes;
	private Mario mario;
	private Tonneau tonneau;
//	public ArrayList<Echelle> echelles;
	final int X_PLATFORM = 100;
	final int Y_PLATFORM = 50;
	

	
	public Dessin(JFrame jf){
		this.mario = new Mario(this, true);
//		this.echelles = creeEchelles();
		this.plateFormes = creePlateFormes();
//		this.echelles = ;
//		this.tonneau = new Tonneau(this, );
		this.addKeyListener(this.mario);
			
	}
	
	public List<PlateForme> creePlateFormes(){
		List<PlateForme> plateForme = new ArrayList<PlateForme>();
		for (int i = 0; i < 7; i++) {
			Position p = new Position(X_PLATFORM, Y_PLATFORM +67*i);
			List<Echelle> e = new ArrayList<>();
			for (int j = 0; j < 2; j++){
				Position p2 = new Position(p.getX() +100 * i, p.getY());
				e.add(new Echelle(this, p2, i, 0));
			}
			plateForme.add(new PlateForme(this, p, e, i));	
		}
		return plateForme;
	}
	
//	public List<Echelle> creeEchelles( Position p)
	
//	chelle(JPanel  jp, Position p, int nbPateForme, int positionRelativeEchelle)
	
	//Je dois ajouté un random
//	public List<Echelle> creeEchelles( Position p){
//		List<Echelle> echelles = new ArrayList<>();
//		for (int i = 0; i < 2; i++) {
//			Position p2 = new Position(p.getX() +100, p.getY());
//			echelles.add(new Echelle(this, p2, i, 0 ));
//		}			
//		return echelles;
//	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g; 
		setBackground(new Color (231, 234,168));
		
		//plate-formes
//		g2D.fillRect(x, y, width, height);
		for(int i = 0; i< plateFormes.size(); i++){
			g2D.setColor(new Color (255, 152, 152));
			if(i%2 == 0){
//				AffineTransform old = g2D.getTransform();
//				g2D.rotate(Math.toRadians(1));
				g2D.fillRect(30, 50 + 67*i , 800, 20);
//				g2D.setTransform(old);
			}
			else{
//				AffineTransform old = g2D.getTransform();
//				g2D.rotate(Math.toRadians(-1));
				g2D.fillRect(30 + 70, Y_PLATFORM + 67*i , 800, 20);
//				g2D.setTransform(old);
			}
			
		//echelles
		for (int k = 0; k < 2; k++) {
				g2D.setColor(new Color (255, 152, 152));
				System.out.println(i);
				System.out.println(plateFormes.get(i).EchellesDePlateForme().get(k).positionEchelle().getX());
				g2D.fillRect(plateFormes.get(i).EchellesDePlateForme().get(k).positionEchelle().getX(),
						plateFormes.get(i).EchellesDePlateForme().get(k).positionEchelle().getY() ,
						20, 67);
				g2D.setColor(new Color (231, 234,168));
				for (int j = 0; j < 4; j++) {
					g2D.fillRect(plateFormes.get(i).EchellesDePlateForme().get(k).positionEchelle().getX() + 3,
							plateFormes.get(i).EchellesDePlateForme().get(k).positionEchelle().getY() + 20 + (13*j), 14, 10);
				}
				
		
		}
			
			
			
		}
		
		
		

		//Mario
		g2D.setColor(new Color (151, 21, 73));
		g2D.fillOval(mario.getP().getX(), mario.getP().getY(), 20, 20);
		
//		//Tonneau
//		g2D.setColor(new Color (151,0, 73));
//		g2D.fillOval(tonneau.getP().getX(), tonneau.getP().getY(), 20, 20);
		
	}

}

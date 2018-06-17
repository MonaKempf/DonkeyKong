package Game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Timer;

import javax.swing.JPanel;


public class Mario implements KeyListener {
	
	
	public Position p;
	public PlateForme plateForme;
	public Score animation;
	private JPanel jp;
//	private boolean surPlateforme;
	private BufferedImage[] m;
	private BufferedImage imgMario;
	
	// doit savoir ou il est sur une echelle ou une plateforme
	public Mario(JPanel  jp, Position p, PlateForme plateForme){
		this.jp = jp;
		this.plateForme = plateForme;
		this.p = p;
		this.m = splitImage(Dessin.imageMario, 4, 2);
		this.imgMario = m[3];
	}
	
	public Position getP() {
		return p;
	}
	
	public BufferedImage getImageMario() {
		return imgMario;
	}
	
	public Position getPositionPlateForme() {
		return plateForme.positionPlateForme();
	}
	
	public int nbPlatform(){
		return plateForme.nbPlateForme();
	}
	
	public BufferedImage mort(){
		imgMario = m[7];
		return imgMario;
	}

//	public boolean surPlateforme(Position p){
//		for (int i = 0; i < Dessin.NB_PLATEFORME; i++) {
//			if(p.getX() == Dessin.X_PLATEFORME + Dessin.ESPACE_PLATEFORME*i
//					&& p.getY() <= Dessin.Y_PLATEFORME + 800 && p.getY() >= Dessin.Y_PLATEFORME){
//				return true;
//			}
//		}return false;
//	}
//	
	
	
	
	public static BufferedImage[] splitImage(BufferedImage img, int cols, int rows) {  
        int w = img.getWidth()/cols;  
        int h = img.getHeight()/rows;  
        int num = 0;  
        BufferedImage imgs[] = new BufferedImage[w*h];  
        for(int y = 0; y < rows; y++) {  
            for(int x = 0; x < cols; x++) {  
            	//7 est un nombre magique pas sur pourquoi ça fonctionne?
            	//6 fonctionne aussi -_-
             	//(((imgs[num] = new BufferedImage(w, h, img.getType());)))
                imgs[num] = new BufferedImage(w, h, 7);  
               // On dessine un seul bloc de l'image 
                Graphics2D g = imgs[num].createGraphics();  
                g.drawImage(img, 0, 0, w, h, w*x, h*y, w*x+w, h*y+h, null);  
                g.dispose();  
                num++;  
            }  
        }  
        return imgs;  
    }  
	

	
	@Override
	public void keyPressed(KeyEvent e) {
		if(p.getX() >= 0 && e.getKeyCode() == KeyEvent.VK_LEFT){
			p.setX(p.getX()-30);
			if (imgMario != m[1]){
				imgMario = m[1];
			}else{
				imgMario = m[0];
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			p.setX(p.getX()+30);
			if (imgMario != m[3]){
				imgMario = m[3];
			}else{
				imgMario = m[2];
			}
		}
//		&& p.comparPosition(echelle.positionEchelle().getX(),echelle.positionEchelle().getY()) --> ERREUR
//		System.out.println(echelle);
		if(e.getKeyCode() == KeyEvent.VK_UP 
//				&& p.comparPosition(echelle.positionEchelle().getX(),echelle.positionEchelle().getY())
				){
			p.setY(p.getY()- Dessin.ESPACE_PLATEFORME );
			if (imgMario != m[5]){
				imgMario = m[5];
			}else{
				imgMario = m[6];
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			p.setY(p.getY()+ Dessin.ESPACE_PLATEFORME );
			if (imgMario != m[6]){
				imgMario = m[6];
			}else{
				imgMario = m[5];
			}
		}
		jp.repaint();
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {		
	}
}

package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class Mario implements KeyListener {
	
	
	public Position p;
	private JPanel jp;
	private Echelle echelle;
	private boolean surPlateforme;
	
	// doit savoir ou il est sur une echelle ou une plateforme
	public Mario(JPanel  jp, boolean surPlatforme){
		this.jp = jp;
		this.p = new Position(50,30 + 67*6);
		this.surPlateforme = surPlatforme;
	}
	
	public Position getP() {
		return p;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(p.getX() >= 0 && e.getKeyCode() == KeyEvent.VK_LEFT){
			p.setX(p.getX()-30);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			p.setX(p.getX()+30);
		}
//		&& p.comparPosition(echelle.positionEchelle().getX(),echelle.positionEchelle().getY()) --> ERREUR
		System.out.println(echelle);
		if(e.getKeyCode() == KeyEvent.VK_UP 
				&& p.comparPosition(echelle.positionEchelle().getX(),echelle.positionEchelle().getY())){
			p.setY(p.getY()-67);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			p.setY(p.getY()+67);
			
		}
		jp.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

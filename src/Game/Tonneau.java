package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Tonneau implements Runnable {
	public Position p;
	List<PlateForme> plateFormes;
	public int nbPlateForme;
	public int currentPlatform = 0;
	private int vecteurDirectionX = 1;
	private int vecteurDirectionY = 0;
	private int SPEED = 4;

	// //Faut besoin d'une ref de sa platfirme
	// public Tonneau(JPanel jp, Position p, ArrayList<PlateForme> plateFormes,
	// int nbPlateForme){
	// this.jp=jp;
	// this.plateFormes = plateFormes;
	// this.nbPlateForme = nbPlateForme;
	// this.p = new Position(p.getX() + 100, p.getY()- 20);
	// }

	public Tonneau(Position p, List<PlateForme> plateFormes) {
		this.p = new Position(p.getX() + Dessin.X_PLATEFORME, p.getY() - 20);
		this.plateFormes = plateFormes;
	}

	public Position getP() {
		return p;
	}

	@Override
	public void run() {
		while (true) {
			if (p.getX() >= 900 || p.getX() <= 100) {
				fall();

				if (p.getY() > Dessin.Y_PLATEFORME + Dessin.ESPACE_PLATEFORME
						* (currentPlatform + 1)) {
					stopFalling();
					if (p.getX() >= 900) {
						moveLeft();
					} else if (p.getX() <= 100) {
						moveRight();
					}
				}
			}
			move();
			
			System.out.println("Hello" + p.getX());
			try {
				Thread.currentThread().sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			Thread.currentThread().interrupt();
		}
	}

	private void stopFalling() {
		vecteurDirectionX = 0;
		vecteurDirectionY = 0;
		currentPlatform += 1;
	}

	private void fall() {
		vecteurDirectionX = 0;
		vecteurDirectionY = 1;
	}

	private void moveRight() {
		vecteurDirectionX = 1;
		vecteurDirectionY = 0;
	}

	private void moveLeft() {
		vecteurDirectionX = -1;
		vecteurDirectionY = 0;
	}

	private void move() {
		p.setX(p.getX() + vecteurDirectionX * SPEED);
		p.setY(p.getY() + vecteurDirectionY * SPEED);
	}

	public boolean marioMort(Position pMario) {
		if (p.comparPosition(
				pMario.getX() + Dessin.X_PLATEFORME,
				pMario.getY()
						+ (Dessin.ESPACE_PLATEFORME
								* (Dessin.NB_PLATEFORME - 1) + Dessin.Y_PLATEFORME))) {
			return true;
		}
		return false;
	}

}

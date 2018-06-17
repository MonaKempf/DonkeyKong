package Game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Tonneau {
	private JPanel jp;
	public Position p;
	ArrayList<PlateForme> plateFormes;
	public int nbPlateForme;
	public boolean surPlateForme;
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

	public Tonneau(JPanel jp, Position p, ArrayList<PlateForme> plateFormes,
			boolean surPlateForme) {
		this.jp = jp;
		this.p = new Position(p.getX() + Dessin.X_PLATEFORME, p.getY() - 20);
		this.plateFormes = plateFormes;
	}

	public Position getP() {
		return p;
	}

	// public void tombeTonneau(){
	//
	// for (int i = 1; i < plateFormes.size(); i = i+2) {
	// if ( !p.surPlateforme() && vecteurDirectionX == 1 && vecteurDirectionY ==
	// 0 ){
	// while(p.getY() <= Dessin.Y_PLATEFORME + Dessin.ESPACE_PLATEFORME * i ){
	// vecteurDirectionX = 0;
	// vecteurDirectionY = 1;
	//
	// p.setX(p.getX()+ vecteurDirectionX * SPEED);
	// p.setY(p.getY()+ vecteurDirectionY * SPEED);
	//
	// jp.repaint();
	// }
	// }
	// if (p.surPlateforme() && vecteurDirectionY == 1){
	// vecteurDirectionX = -1;
	// vecteurDirectionY = 0;
	//
	// p.setX(p.getX()+ vecteurDirectionX * SPEED);
	// p.setY(p.getY()+ vecteurDirectionY * SPEED);
	//
	// jp.repaint();
	//
	// }
	//
	// if (!p.surPlateforme() && vecteurDirectionX == -1 && vecteurDirectionY ==
	// 0){
	// while(p.getY() >= Dessin.Y_PLATEFORME + Dessin.ESPACE_PLATEFORME * i
	// && p.getY() <= Dessin.Y_PLATEFORME + Dessin.ESPACE_PLATEFORME * (i+1) ){
	// vecteurDirectionX = 0;
	// vecteurDirectionY = 1;
	//
	// p.setX(p.getX()+ vecteurDirectionX * SPEED);
	// p.setY(p.getY()+ vecteurDirectionY * SPEED);
	//
	// jp.repaint();
	// }
	// }
	//
	// if (p.surPlateforme() && vecteurDirectionY == 1){
	// vecteurDirectionX = 1;
	// vecteurDirectionY = 0;
	//
	// p.setX(p.getX()+ vecteurDirectionX * SPEED);
	// p.setY(p.getY()+ vecteurDirectionY * SPEED);
	//
	// jp.repaint();
	// }
	// }
	// p.setX(p.getX()+ vecteurDirectionX * SPEED);
	// p.setY(p.getY()+ vecteurDirectionY * SPEED);
	//
	// jp.repaint();
	//
	// }

	public void tombeTonneau() {
		for (int i = 1; i < plateFormes.size(); i = i + 2) {
			if (p.getX() >= 900 || p.getX() <= 100 && vecteurDirectionX == 1
					&& vecteurDirectionY == 0) {
				while (p.getY() <= Dessin.Y_PLATEFORME + Dessin.ESPACE_PLATEFORME
						* i) {
					vecteurDirectionX = 0;
					vecteurDirectionY = 1;

					move();
				}
			}
			if (p.getX() >= 900 && vecteurDirectionX == 0
					&& vecteurDirectionY == 1) {
				moveLeft();
			}

			if (p.getX() >= 900 || p.getX() <= 100 && vecteurDirectionX == -1
					&& vecteurDirectionY == 0) {
				while (p.getY() >= Dessin.Y_PLATEFORME + Dessin.ESPACE_PLATEFORME
						* i
						&& p.getY() <= Dessin.Y_PLATEFORME
								+ Dessin.ESPACE_PLATEFORME * (i + 1)) {
					vecteurDirectionX = 0;
					vecteurDirectionY = 1;

					move();
				}
			}

			if (p.getX() <= 100 && vecteurDirectionX == 0
					&& vecteurDirectionY == 1) {
				moveRight();
			}
		}
		move();
	}

	private void moveRight() {
		vecteurDirectionX = 1;
		vecteurDirectionY = 0;

		move();
	}

	private void moveLeft() {
		vecteurDirectionX = -1;
		vecteurDirectionY = 0;

		move();
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
			jp.repaint();
			return true;
		}
		return false;
	}

}

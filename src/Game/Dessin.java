package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.management.timer.TimerMBean;

public class Dessin extends JPanel {
	// FPS frames per second
	private static final int FPS = 60;
	private List<PlateForme> plateFormes;
	private Mario mario;
	// private Animation animation;
	private Kong donkeyKong;
	private BoucleDuJeu boucleDuJeu;
	private List<Tonneau> tonneaux = new ArrayList<Tonneau>();

	final static int X_PLATEFORME = 100;
	final static int Y_PLATEFORME = 160;
	final static int NB_PLATEFORME = 7;
	final static int ESPACE_PLATEFORME = 96;
	static public BufferedImage image;
	static public BufferedImage imageDonkeyKong;
	static public BufferedImage imageMario;
	static public BufferedImage imagePrincesse;
	static public boolean FIN_DU_JEU = false;
	
	private ExecutorService pool = Executors.newCachedThreadPool();
	Timer t = new Timer();

	public Dessin(JFrame jf) {

		this.donkeyKong = new Kong(this);
		this.plateFormes = creePlateFormes();
		this.mario = new Mario(this, new Position(0, 0),
				plateFormes.get(NB_PLATEFORME - 1));
		
		this.addKeyListener(this.mario);
		
		t.scheduleAtFixedRate(new CreeTonneaux(plateFormes), 0, 3000);
		
		this.boucleDuJeu = new BoucleDuJeu(this, mario, plateFormes);
		t.scheduleAtFixedRate(boucleDuJeu, 0, 1000 / FPS);
	}
	
	public class CreeTonneaux extends TimerTask{
		
		public List<PlateForme>  plateFormes;		
		
		public CreeTonneaux(List<PlateForme> plateFormes) {
			this.plateFormes = plateFormes;
		}
		
		@Override
		public void run() {
			Tonneau tonneau = new Tonneau(plateFormes.get(0).positionPlateForme(), plateFormes);
			tonneaux.add(tonneau);
			pool.execute(tonneau);
		}		
	}

	public List<PlateForme> creePlateFormes() {
		List<PlateForme> plateForme = new ArrayList<PlateForme>();
		int x;
		for (int i = 0; i < NB_PLATEFORME; i++) {
			if (i % 2 == 1) {
				x = X_PLATEFORME + 70;
			} else {
				x = X_PLATEFORME;
			}
			Position p = new Position(x, Y_PLATEFORME + ESPACE_PLATEFORME * i);
			List<Echelle> e = new ArrayList<>();
			for (int j = 0; j < 2; j++) {
				Position p2 = new Position(p.getX() + 100 * i, p.getY());
				e.add(new Echelle(this, p2, i, 0));
			}
			plateForme.add(new PlateForme(this, p, e, i));
		}
		return plateForme;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		setBackground(new Color(240, 230, 190));
		g2D.setColor(new Color(245, 220, 195));
		for (int b = 0; b < 20; b++) {
			g2D.fillRect(0 + 90 * b, 0, 12, Jeu.HEIGHT);
		}

		if (!FIN_DU_JEU) {

			// plate-formes
			// g2D.fillRect(x, y, width, height);
			for (int i = 0; i < plateFormes.size(); i++) {
				AffineTransform old = g2D.getTransform();
				g2D.setColor(new Color(200, 170, 170));

				g2D.translate(plateFormes.get(i).positionPlateForme().getX(),
						plateFormes.get(i).positionPlateForme().getY());
				g2D.translate(400, 0);
				if (i % 2 == 0) {
					g2D.rotate(Math.toRadians(Math
							.sin(this.boucleDuJeu.t * 0.04f)));
				} else {
					g2D.rotate(Math.toRadians(Math
							.sin(-this.boucleDuJeu.t * 0.04f)));
				}
				g2D.translate(-400, 0);
				g2D.fillRect(0, 0, 800, 20);
				g2D.setColor(new Color(255, 152, 152));
				g2D.fillRect(4, 4, 792, 12);

				// echelles
				for (int k = 0; k < 2; k++) {
					g2D.setColor(new Color(2, 152, 152));
					g2D.fillRect(
							plateFormes.get(i).EchellesDePlateForme().get(k)
									.positionEchelle().getX(), 0, 20, 67);
					g2D.setColor(new Color(240, 230, 190));
					for (int j = 0; j < 4; j++) {
						g2D.fillRect(plateFormes.get(i).EchellesDePlateForme()
								.get(k).positionEchelle().getX() + 3,
								20 + (13 * j), 14, 10);
					}

					// Mario
					// /faire une condition si mario apparitin a cette pf alors
					// on dessine mario
					if (mario.nbPlatform() == i) {
						int x = mario.getP().getX();
						int y = mario.getP().getY() - 25;
						g.drawImage(mario.getImageMario(), x, y, this);
					}
				}

				if (i == 0) {
					// DonkeyKong
					int x2 = donkeyKong.getP().getX();
					int y2 = donkeyKong.getP().getY();
					g.drawImage(imageDonkeyKong, x2, y2, this);
				}

				g2D.setTransform(old);
			}

			// Tonneau
			g2D.setColor(new Color(0, 152, 255));
			System.out.println("Dessin " + tonneaux.size());
			for (Tonneau tonneau : tonneaux) {
				g2D.fillOval(tonneau.getP().getX(), tonneau.getP().getY(), 20, 20);
				if (tonneau.marioMort(mario.getP())) {
					FIN_DU_JEU = true;
				}
			}

//			System.out.println("Tonneau x :" + tonneau.getP().getX());
//			System.out.println("Tonneau y :" + tonneau.getP().getY());
//			System.out.println("Mario x : " + mario.getP().getX());
//			System.out.println("Mario y : " + mario.getP().getY());
//			System.out.println(mario.getP().getX() + Dessin.X_PLATEFORME);
//			System.out.println(mario.getP().getY() + Dessin.ESPACE_PLATEFORME
//					* (Dessin.NB_PLATEFORME - 1) + Dessin.Y_PLATEFORME);


			// Princesse
			g2D.setColor(new Color(200, 170, 170));
			g2D.fillRect(400, Dessin.Y_PLATEFORME - Dessin.ESPACE_PLATEFORME,
					300, 20);
			g2D.setColor(new Color(255, 152, 152));
			g2D.fillRect(404, Dessin.Y_PLATEFORME - Dessin.ESPACE_PLATEFORME
					+ 4, 292, 12);
			g.drawImage(imagePrincesse, 450, 10, this);
		} else { // FIN DE JEU
			g2D.setColor(new Color(255, 255, 200));
			g2D.fillRect(100, 100, 400, 400);
			Jeu.Score = 0;

		}
	}

}

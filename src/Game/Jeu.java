package Game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class Jeu extends JFrame {
	
	public final static int WIDTH = 1400;
	public final static int HEIGHT = 800;
	public static int Score = 4000;
	BufferedImage image;
	BufferedImage imageDonkeyKong;
	
	public Jeu(){
		super();
		
		this.setTitle("Donky Kong ");
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
	}	
	
	
	public static BufferedImage loadImage(String ref) {  
        BufferedImage bimg = null;  
        try {    
            bimg = ImageIO.read(new File(ref));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return bimg;  
    }  


	public static void main(String[] args) {
		
		Dessin.image = loadImage("C:\\Users\\Mona Kempf\\workspace\\DonkeyKong\\sprit\\a299.png");
		Dessin.imageDonkeyKong = loadImage("C:\\Users\\Mona Kempf\\workspace\\DonkeyKong\\sprit\\donkeykong.png");
		Dessin.imageMario = loadImage("C:\\Users\\Mona Kempf\\workspace\\DonkeyKong\\sprit\\mario_sheet.png");
		Dessin.imagePrincesse = loadImage("C:\\Users\\Mona Kempf\\workspace\\DonkeyKong\\sprit\\pauline_sheet.png");
		
		
		JFrame fenetre = new Jeu();
		fenetre.setVisible(true);
		Container contentPan = fenetre.getContentPane();
		Dessin panel = new Dessin(fenetre);
		
		Score panelScore = new Score(fenetre);

		
		contentPan.add( panel, BorderLayout.WEST);
		contentPan.add( panelScore, BorderLayout.EAST);
		
		
		panel.setPreferredSize(new Dimension(WIDTH - 120, HEIGHT));
		panelScore.setPreferredSize(new Dimension(120, HEIGHT));
		fenetre.pack();
		
		panel.requestFocus();
		panel.setFocusable(true);
		fenetre.setVisible(true);
		
		
		// TODO Auto-generated method stub

	}

}

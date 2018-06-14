package Game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;




public class Jeu extends JFrame {
	
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 500;
	
	
	public Jeu(){
		super();
		
		this.setTitle("Donky Kong ");
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
	}	


	public static void main(String[] args) {
		JFrame fenetre = new Jeu();
		fenetre.setVisible(true);
		Container contentPan = fenetre.getContentPane();
		Dessin panel = new Dessin(fenetre);
		
		contentPan.add( panel, BorderLayout.WEST);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		fenetre.pack();
		
		panel.requestFocus();
		panel.setFocusable(true);
		fenetre.setVisible(true);
		
		
		// TODO Auto-generated method stub

	}

}

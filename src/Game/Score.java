package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Score extends JPanel{
	
	public Score(JFrame jf) {
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g; 
		setBackground(new Color (240, 240,240));
//		g2D.setColor(new Color (245, 0, 0));
//		g2D.fillRect(0 , 0, 400, Jeu.HEIGHT);
		add(new JLabel("TEPMPS"));
		String tmp = String.valueOf("t");
		add( new JTextField(tmp, 4));
		add(new JLabel("SCORE"));
		String score = String.valueOf(Jeu.Score);
		add( new JTextField(score, 4));
		repaint();
		add(new JButton("clique ici"));
	}
	
	
	
	

}

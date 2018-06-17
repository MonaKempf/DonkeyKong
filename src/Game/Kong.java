package Game;

import javax.swing.JPanel;

public class Kong {
	private JPanel jp;
	public Position p;
	
	public Kong(JPanel jp) {
		this.jp = jp;
		this.p = new Position(15, -30);
	}
	
	public Position getP() {
		return p;
	}

}

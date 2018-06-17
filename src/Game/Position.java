package Game;

public class Position {
	private int x;
	private int y;

	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
		
    public boolean comparPosition(int x, int y){
    	if((this.x <= x+50 && this.x >= x-10) && (this.y <= y+50 && this.y >= y-50)){
    		return true;
    	}
		return false;	
	}
    
    
    
	public boolean surPlateforme(){
		for (int i = 0; i < Dessin.NB_PLATEFORME; i++) {
			if(x == Dessin.X_PLATEFORME + Dessin.ESPACE_PLATEFORME*i
					&& y <= Dessin.Y_PLATEFORME + 800 && y >= Dessin.Y_PLATEFORME){
				return true;
			}
		}return false;
	}
	
    
    

}

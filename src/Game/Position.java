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
    	if((this.x <= x+200 && this.x >= x-200) && (this.y <= y+200 && this.y >= y-200)){
    		return true;
    	}
		return false;	
	}

}

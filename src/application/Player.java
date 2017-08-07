package application;

public class Player{
	
	private double Y;
	private boolean up = false;
	private boolean down = false;

	public Player(double y){
		this.Y = y;
	}
	
	public void move(){
		if(up)		{this.Y -= 5;}
		if(down)	{this.Y += 5;}
	}
	
	public void setUp(boolean up){
		this.up = up;
	}
	
	public void setDown(boolean down){
		this.down = down;
	}
	
	public double getY(){
		return this.Y;
	}
}

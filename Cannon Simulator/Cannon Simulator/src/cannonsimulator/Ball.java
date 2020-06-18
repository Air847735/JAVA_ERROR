package cannonsimulator;

import java.awt.Color;
import java.util.ArrayList;

public class Ball {
	private double x;
	private double y;
	private double diameter;
	
	private double speedX;
	private double speedY;
	
	private double velocity;
	private Color color;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	//----------------------------------------------------------//
	
	public Ball(int x, int y, int diameter, int speedX, int speedY, Color color) {
		this.x = (double) x;
		this.y = (double) y;
		this.diameter = (double) diameter;//球大小
		this.speedX = (double) speedX/2.5;//力道
		this.speedY = (double) ((speedY/2.5) * -1);
		this.color = color;
		
		this.velocity = this.speedY;
		
	}
	public int getX() {
		return (int) x;
	}
	public int getY() {
		return (int) y;
	}
	public int getDiameter() {
		return (int) diameter;
	}
	public Color getColor() {
		return color;
	}
	
	public void update() {
		
		//-------- X ----------//
		
		x = x + speedX;
		speedX = speedX * 0.996; //Air resistance

		//打到牆壁反彈並扣分
		if (x > GamePanel.WIDTH - diameter || x < 0) {
			speedX = speedX * -1;
			GamePanel.point=GamePanel.point-1;
		}
		
		//If it is slow enough stop
		if (speedX < 0 && speedX > -0.1 || speedX > 0 && speedX < 0.1) {
			speedX = 0;
		}
		
		//If the ball is done bouncing, add more resistance
		if (velocity < 0.1 && y == GamePanel.HEIGHT - diameter) {
			speedX = speedX * 0;
		}
		
		//-------- Y ----------//
		
		velocity = velocity * 0.999; //Air resistance
		velocity = velocity + 0.4; //Gravity
		y = y + velocity;
		
		// if it hits the bottom
		if (y + diameter >= GamePanel.HEIGHT) {
			speedY = 0;
			speedX = 0;
		}
		
	}
	

}

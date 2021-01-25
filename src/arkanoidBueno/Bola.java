package arkanoidBueno;

import java.awt.Color;
import java.awt.Graphics2D;


public class Bola extends Actor {
	public static final int DIAMETRO = 15;
	
	private int velocidadX = 3;
	private int velocidadY = 3;
	
	
	public Bola() {
		super();
		spriteActual = null;
		this.x = Arkanoid.getInstancia().getWidth() / 2;
		this.y = Arkanoid.getInstancia().getHeight() / 2;
	}

	
	public void paint(Graphics2D g){
		g.setColor(Color.LIGHT_GRAY);
		
		g.fillOval(this.x, this.y, DIAMETRO, DIAMETRO);
	}

	
	
	public void act() {
		
		if (this.x < 0 || this.x > Arkanoid.getInstancia().getWidth()- DIAMETRO) {
			this.velocidadX = 0 - this.velocidadX;
		}
		
		if (this.y < 0 || this.y > Arkanoid.getInstancia().getHeight() - DIAMETRO) {
			this.velocidadY = 0 - this.velocidadY;
		}
		
		this.x += this.velocidadX;
		this.y += this.velocidadY;
	}


}

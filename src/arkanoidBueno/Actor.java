
package arkanoidBueno;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Actor {
	
	protected int x, y;
	protected BufferedImage spriteActual;

	
	public Actor() {
		
	}

	
	public void paint(Graphics2D g) {
		
		if (this.spriteActual != null) {
			g.drawImage(this.spriteActual, this.x, this.y, null);
		}
	}

	
	public void act() {
	}

	// Metodos setters y getters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getSpriteActual() {
		return spriteActual;
	}

	public void setSpriteActual(BufferedImage spriteActual) {
		this.spriteActual = spriteActual;
	}
}

package arkanoidBueno;

import java.awt.Color;
import java.awt.Graphics2D;


public class Ladrillo extends Actor {

	public static final int ANCHO = 30;
	public static final int ALTO = 20;
	
	private Color color = null;
	
	/**
	 * 
	 */
	public Ladrillo() {
		super();
		spriteActual = null; 
		this.x = 10;
		this.y = 10;
		this.color = Color.WHITE;
	}

	
	
	public void paint(Graphics2D g){
		g.setColor(Color.RED);
		
		g.fillRect(this.x, this.y, ANCHO, ALTO);
	}


	
	public Color getColor() { return color; }
	public void setColor(Color color) { this.color = color; }
}

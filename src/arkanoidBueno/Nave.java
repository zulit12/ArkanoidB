package arkanoidBueno;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Clase que representa a la nave de nuestro juego
 * 
 * @author R
 *
 */
public class Nave extends Actor {
	
	public static final int ANCHO = 30;
	public static final int ALTO = 10;

	
	public Nave() {
		super();
		
		this.x = Arkanoid.getInstancia().getWidth() / 2;
		this.y = Arkanoid.getInstancia().getHeight() - 50;
	}
	
	public void paint(Graphics2D g){
		g.setColor(Color.BLUE);
		
		g.fillRect(this.x, this.y, ANCHO, ALTO);
	}


}

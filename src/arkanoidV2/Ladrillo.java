package arkanoidV2;

import java.awt.Color;
import java.awt.Graphics2D;


/**
 * Clase que representa a cada ladrillo de los que pondremos sobre la pantalla
 * @author R
 *
 */
public class Ladrillo extends Actor {
	// Damos un ancho y un alto espec�fico al ladrillo. Suponemos que todos los ladrillos ser�n iguales
	public static final int ANCHO = 30;
	public static final int ALTO = 20;
	public static final int ESPACIO_ENTRE_LADRILLOS = 2;
	private String nombreCarpetaParaFile = "./src/arkanoidV2";
	private String nombreCarpetaParaURL = "./";
	
	// Propiedades espec�ficas de cada ladrillo
	private Color color = null;
	
	/**
	 * Constructor
	 */
	public Ladrillo() {
		super();
		spriteActual = null; // El ladrillo se pinta vectorialmente, as� que no utilizo ning�n sprite
		this.x = 10;
		this.y = 10;
		this.color = Color.WHITE; // Por defecto pongo el ladrillo en color blanco
	}

	/**
	 * Constructor parametrizado
	 * @param x
	 * @param y
	 * @param color
	 */
	public Ladrillo(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	/**
	 * Pintado del ladrillo en pantalla
	 */
	public void paint(Graphics2D g){
		g.setColor(this.color);
		// Pinto el ladrillo como un rect�ngulo con v�rtices redondeados
		g.fillRoundRect(this.x, this.y, ANCHO, ALTO, 3, 3);
	}
	
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con un player o un disparo, eliminamos al monstruo
		if (a instanceof Bola || a instanceof Bola) {
			Arkanoid.getInstancia().eliminaActor(this);
			Arkanoid.getInstancia().incorporaNuevoActor(new Explosion(this.x, this.y));
		}
	}


	// M�todos getter y setter
	public Color getColor() { return color; }
	public void setColor(Color color) { this.color = color; }
}

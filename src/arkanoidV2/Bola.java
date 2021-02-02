package arkanoidV2;

import java.awt.Color;
import java.awt.Graphics2D;


/**
 * Clase que representa la bola del juego, que rebotar� y destruir� ladrillos
 * @author R
 *
 */
public class Bola extends Actor {
	// Pienso que, aunque m�s adelante en el juego pueda haber varias bolas, en principio su di�metro no cambia
	public static final int DIAMETRO = 15;
	
	// La bola necesita poder moverse en los dos ejes: x e y. Por tanto necesitamos dar valores de velocidad en los dos
	private int velocidadX = 3;
	private int velocidadY = 3;
	
	/**
	 * 
	 */
	public Bola() {
		super();
		spriteActual = null; // La bola se pinta de forma vectorial
		this.x = Arkanoid.getInstancia().getWidth() / 2;
		this.y = Arkanoid.getInstancia().getHeight() / 2;
	}

	/**
	 * Pintado de la bola en pantalla
	 */
	public void paint(Graphics2D g){
		g.setColor(Color.LIGHT_GRAY);
		// Se pinta la bola como un c�rculo
		g.fillOval(this.x, this.y, DIAMETRO, DIAMETRO);
	}

	
	/**
	 * La bola act�a en cada iteraci�n del programa
	 */
	public void act() {
		// Si la bola se toca el borde por la izquierda o por la derecha, su velocidad cambia de signo
		if (this.x < 0 || this.x > Arkanoid.ANCHO - DIAMETRO) {
			this.velocidadX = 0 - this.velocidadX;
		}
		// Si la bola se toca el borde por arriba o por abajo, su velocidad cambia de signo
		if (this.y < 0 || this.y > Arkanoid.ALTO - DIAMETRO) {
			this.velocidadY = 0 - this.velocidadY;
		}
		// Agregamos las velocidades respectivas a cada eje para la bola
		this.x += this.velocidadX;
		this.y += this.velocidadY;
	}
	
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con monstruo, eliminamos el disparo
		if (a instanceof Ladrillo) {
			this.velocidadY = +3;
		}
		if (a instanceof Nave) {
			this.velocidadY = -3;
		}
	}


}

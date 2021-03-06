package arkanoidBueno;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;



public class Nave extends Actor {
	private String nombre;
	private boolean moviendoAIzquierda = false;
	private boolean moviendoADerecha = false;
	private int velocidad = 5;

	

	public Nave() {
		super();

	}
	
	@Override
	public void actua() {
		// Controlo que el movimiento a derecha no haga que la nave se pierda por la derecha
		if (this.moviendoADerecha && (this.x + this.velocidad  + this.ancho <= Arkanoid.getInstancia().getWidth())) {
			this.x += this.velocidad;
		}
		// Control que el movimiento a izquierda no haga que la nave se pierda por la izquierda
		if (this.moviendoAIzquierda && (this.x - this.velocidad >= 0)) {
			this.x -= this.velocidad;
		}
	}
	
	public void mouseMoved(MouseEvent event) {
		// Cuando el rat�n se mueva sobre el canvas, la nave debe situarse a su mismo valor del eje X
		// Si el rat�n hace que la nave se pierda por la derecha o la izquierda debo contemplar el hecho de que la nave
		// no se pierda por ese margen
		if (event.getX() >= (this.ancho / 2) // La nave no se perder� por la izquierda
				&&
			event.getX() <= (Arkanoid.getInstancia().getWidth() - this.ancho / 2)) {
			this.x = event.getX() - this.ancho / 2;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			  case KeyEvent.VK_LEFT : moviendoAIzquierda = true; break;
			  case KeyEvent.VK_RIGHT : moviendoADerecha = true; break;
	  	}
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : moviendoAIzquierda = false; break; 
			case KeyEvent.VK_RIGHT : moviendoADerecha = false; break;
		}
	}

	public Nave(int x, int y, int ancho, int alto, String nombre) {
		super(x, y, ancho, alto);
		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nave [nombre=" + nombre + ", x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + "]";
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(Color.gray);
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}
	


	/**
	 * M�todos llamados desde el controlador del teclado, para delegar el evento del teclado
	 * @param event
	 */

	
}
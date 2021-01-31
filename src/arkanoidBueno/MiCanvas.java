package arkanoidBueno;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;



public class MiCanvas extends Canvas {
	List<Actor> actor = null;

	/**
	 * Constructor
	 * @param actores
	 */
	public MiCanvas (List<Actor> actor) {
		this.actor = actor;
	}
	/**
	 * Sobrescritura del mÃ©otod paint(), aquÃ­ tengo el control sobre aquello que se va a pintar en pantalla.
	 */
	@Override
	public void paint(Graphics g) {
		// Pinto el fondo
		this.setBackground(Color.BLACK);
		
		// Pinto cada uno de los actores
		for (Actor a : this.actor) {
			a.paint(g);
		}
}
}

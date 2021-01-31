package arkanoidV2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que implementa al MouseAdapter para poder controlar el movimiento del rat�n sobre el juego
 * @author R
 *
 */
public class ControladorRaton extends MouseAdapter {

	/**
	 * Override que permite manejar el evento de mover el rat�n sobre el Canvas
	 */
	@Override
	public void mouseMoved(MouseEvent event) {
		super.mouseMoved(event);
		// Al recibir un evento se le env�a directamente a la nave, para que ella lo maneje
		Arkanoid.getInstancia().getNave().mouseMoved(event);
	}

}

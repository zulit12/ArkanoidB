package arkanoidV2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase que controla las pulsaciones de teclado y las trasladamos a la nave
 * @author R
 *
 */
public class ControladorTeclado extends KeyAdapter {

	/**
	 * Se activa este m�todo cuando dejamos pulsada una tecla
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		super.keyPressed(event);
		Arkanoid.getInstancia().getNave().keyPressed(event);
	}

	/**
	 * Se activa este m�todo cuando levantamos una tecla pulsada
	 */
	@Override
	public void keyReleased(KeyEvent event) {
		super.keyReleased(event);
		Arkanoid.getInstancia().getNave().keyReleased(event);
	}

	
}

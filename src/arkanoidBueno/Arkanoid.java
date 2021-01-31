package arkanoidBueno;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class Arkanoid {
	// alto y ancho
	private static final int JFrame_WIDTH = 516;
	private static final int JFrame_HEIGHT = 640;

	// velocidad fotogramas

	private static int FPS = 60;
	private static JFrame ventana = null;
	private static List<Actor> actor = new ArrayList<Actor>();
	private static MiCanvas canvas = null;
	private static BufferStrategy strategy;
	private static Arkanoid instancia = null;
	Nave nave = null;
	
	
	public static Arkanoid getInstancia () {
		if (instancia == null) {
			instancia = new Arkanoid();
		}
		return instancia;
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ventana = new JFrame("Arkanoid");
		ventana.setBounds(0, 0, JFrame_WIDTH, JFrame_HEIGHT);

		// Para colocar objetos sobre la ventana debo asignarle un "layout" (plantilla)
		// al panel principal de la ventana
		ventana.getContentPane().setLayout(new BorderLayout());

		// Creo una lista de actores que intervendrÃ¡ en el juego.
		actor = creaActor();

		// Creo y agrego un canvas, es un objeto que permitirÃ¡ dibujar sobre Ã©l
		canvas = new MiCanvas(actor);
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		// Consigo que la ventana no se redibuje por los eventos de Windows
		ventana.setIgnoreRepaint(true);
		// Hago que la ventana sea visible
		ventana.setVisible(true);

		// desactivo el comportamiento por defecto del botón de cerrar
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		
			canvas.createBufferStrategy(2);
			strategy = canvas.getBufferStrategy();
			
			ventana.setIgnoreRepaint(true);
			
			ventana.setResizable(false);
			
			canvas.requestFocus();
			

				

		// Comienzo un bucle, que consistirá en el juego completo.
		juego();
	}

	private static void cerrarAplicacion() {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(ventana, "¿Desea cerrar la aplicación?", "Salir de la aplicación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * Bucle del juego principal
	 */
	public static void juego() {
		int millisPorCadaFrame = 1000 / FPS;
		do {
			// Redibujo la escena tantas veces por segundo como indique la variable FPS
			// Tomo los millis actuales
			long millisAntesDeProcesarEscena = new Date().getTime();

			// Redibujo la escena
			canvas.repaint();

			// Recorro todos los actores, consiguiendo que cada uno de ellos actÃºe
			for (Actor a : actor) {
				a.actua();
			}

			// Calculo los millis que debemos parar el proceso, generando 60 FPS.
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesDeProcesarEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0) ? 0 : millisPausa;
			// "Duermo" el proceso principal durante los milllis calculados.
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	private static List<Actor> creaActor() {
		List<Actor> actor = new ArrayList<Actor>();
		int x = 5;
		int y = 5;
		
		//actores.add(ladrillo);

		Bola bola = new Bola(350, 300, 20, 20, "Pelota");
		actor.add(bola);

		Nave nave = new Nave(240, 570, 45, 8, "Nave");
		actor.add(nave);
		
		for (int i = 0; i < 54; i++) {
			if (i==9 || i==18 || i==27 ||i==36 || i==45) {
				x = 5;
				y = y + 30;
			}
			
			Ladrillo ladrillo = new Ladrillo(x, y, 50, 25, "Ladrillo1");
			
			if (i <= 7) {
                ladrillo.setColor(Color.red);
            }
            
			if (i > 8 && i <= 17) {
                ladrillo.setColor(Color.yellow);
            }
            
            if (i > 17 && i <= 26) {
                ladrillo.setColor(Color.pink);
            }
           
            if (i > 26 && i <= 35) {
                ladrillo.setColor(Color.cyan);
            }
           
            if (i > 35 && i <= 44) {
                ladrillo.setColor(Color.green);
            }
           
            if (i > 44) {
                ladrillo.setColor(Color.orange);
            }
			
            actor.add(ladrillo);
            x = x + 55;
		}

		// Devuelvo la lista con todos los actores del juego
		return actor;
	}

	public Nave getNave() {
		// TODO Auto-generated method stub
		return nave;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

}

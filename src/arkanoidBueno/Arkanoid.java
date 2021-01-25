package arkanoidBueno;
	
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	
	
public class Arkanoid extends Canvas {
		// Variables estaticas
		public static final int ANCHO = 400;
		public static final int ALTO = 600;
		public static final int FPS = 101; // Frames por segundo
		// Ventana
		JFrame ventana = null;
		// Lista de actores que se representan en pantalla
		List<Actor> actores = new ArrayList<Actor>();
		//Doble Buffer
		private BufferStrategy strategy;
		// Variable para patron Singleton
		private static Arkanoid instancia = null;
	
		/**
		 * Getter Singleton
		 * 
		 * @return
		 */
		public static Arkanoid getInstancia() {
			if (instancia == null) {
				instancia = new Arkanoid();
			}
			return instancia;
		}
	
		/**
		 * Constructor
		 */
		public Arkanoid() {
			ventana = new JFrame("Arkanoid");
			JPanel panel = (JPanel) ventana.getContentPane();
			panel.setLayout(new BorderLayout());
			panel.add(this, BorderLayout.CENTER);
			ventana.setBounds(0, 0, ANCHO, ALTO);
			ventana.setVisible(true);
			ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			ventana.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					cerrarAplicacion();
				}
			});
			this.createBufferStrategy(2);
			strategy = this.getBufferStrategy();
			ventana.setIgnoreRepaint(true);
			ventana.setResizable(false);
			
			this.requestFocus();
			
		}
	
		
		private void cerrarAplicacion() {
			String[] opciones = { "Aceptar", "Cancelar" };
			int eleccion = JOptionPane.showOptionDialog(ventana, "¿Desea cerrar la aplicacion?", "Salir de la aplicación",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
			if (eleccion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	
		
		public void iniciarMundo() {
			actores.add(new Nave());
			actores.add(new Ladrillo());
			actores.add(new Bola());
		}
	
		
		public void updateWorld() {
			for (Actor actor : this.actores) {
				actor.act();
			}
		}
	
		
		public void paintWorld() {
			Toolkit.getDefaultToolkit().sync();
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
	
			
			for (Actor actor : this.actores) {
				actor.paint(g);
			}
			
			strategy.show();
		}
	
		
		public void game() {
		
			iniciarMundo();
			
			while (this.isVisible()) {
				
				long millisAntesDeConstruirEscena = System.currentTimeMillis();
				
				updateWorld();
				paintWorld();
				
				int millisUsados = (int) (System.currentTimeMillis() - millisAntesDeConstruirEscena);
				
				try {
					int millisADetenerElJuego = 1000 / FPS - millisUsados;
					if (millisADetenerElJuego >= 0) {
						Thread.sleep(millisADetenerElJuego);
					}
				} catch (InterruptedException e) {
				}
			}
		}
	
		
		public static void main(String[] args) {
			Arkanoid.getInstancia().game();
		}
	}

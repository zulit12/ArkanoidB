package arkanoidV2;

import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * Esta clase se utiliza como un almac�n de ficheros de imagen. Para almacenar las im�genes utilizamos
 * un HashMap<String, BufferedImage>. Adem�s esta clase incorpora un patr�n Singleton
 * @author R
 *
 */
public class CacheImagenes {
	// HashMap que act�a como almac�n de im�genes
	private HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();
	private String nombreCarpetaParaURL = "./";
	// Instancia Singleton
	private static CacheImagenes instancia= null;
	
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static CacheImagenes getInstancia () {
		if (instancia == null) {
			instancia = new CacheImagenes();
		}
		return instancia;
	}
	
	private void cargarFicheroEnHashMap (String nombreFichero) {
		// Obtengo un objeto URL para localizar el recurso
		URL url = null;

		url = getClass().getResource(nombreCarpetaParaURL + nombreFichero);
		// Discriminará el caso de que intento cargar un sonido del caso de cargar imágenes
		try {
			if (nombreFichero.endsWith(".wav") || nombreFichero.endsWith(".mp3")) {
				this.sprites.put(nombreFichero, (BufferedImage) Applet.newAudioClip(url));
			} 
			else { // Si no es un sonido entiendo que se trata de una imagen
				this.sprites.put(nombreFichero, ImageIO.read(url));
			}
		}
		catch (Exception ex) {
			System.out.println("No se pudo cargar el recurso " + nombreFichero);
			ex.printStackTrace();
		}
	}
	


	
	/**
	 * Este m�todo carga un fichero de imagen del sistema de ficheros y lo devuelve
	 * como un objeto de tipo BufferedImage
	 * @param nombre
	 * @return
	 */
	private BufferedImage cargarImagen (String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) { // algo ha fallado, se acaba el programa si no podemos cargar alguna imagen
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}
	
	/**
	 * M�todo utilizado desde fuera de esta clase para permitir acceder a las im�genes. En primer lugar se 
	 * busca la imagen en el almac�n, si no se encuentra se busca en el sistema de ficheros.
	 * @param nombre
	 * @return
	 */
	public BufferedImage getImagen(String nombre) {
		BufferedImage img = sprites.get(nombre);
		if (img == null) {
			img = cargarImagen("./"+nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
}

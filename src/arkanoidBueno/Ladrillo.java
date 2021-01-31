package arkanoidBueno;

import java.awt.Color;
import java.awt.Graphics;

public class Ladrillo extends Actor {
	private String nombre;
	private Color color;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void actua() {
		// TODO Auto-generated method stub

	}

	public Ladrillo() {
		super();
	}

	public Ladrillo(int x, int y, int ancho, int alto, String nombre) {
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
		return "Ladrillo [nombre=" + nombre + ", x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + "]";
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}
}

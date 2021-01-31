package arkanoidBueno;

import java.awt.Color;
import java.awt.Graphics;

public class Bola extends Actor {
	private String nombre;
	private int velocidadX = -5;
	private int velocidadY = -5;

	public Bola() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bola(int x, int y, int ancho, int alto, String nombre) {
		super(x, y, ancho, alto);
		this.nombre = nombre;
		
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVelocidadX() {
		return velocidadX;
	}

	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	public int getVelocidadY() {
		return velocidadY;
	}

	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	@Override
	public void actua() {
		this.x += this.velocidadX;
		if (this.x < 0 || this.x > 478) {
			this.velocidadX = -this.velocidadX;
		}

		this.y += this.velocidadY;
		if (this.y < 0 || this.y > 580) {
			this.velocidadY = -this.velocidadY;

		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.magenta);
		g.fillOval(this.x, this.y, this.ancho, this.alto);
	}
}
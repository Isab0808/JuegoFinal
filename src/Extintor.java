import processing.core.PApplet;
import processing.core.PImage;

public class Extintor extends Herramienta {

	protected int x, y, tiempoVida;
	
// PImage Herramienta: Extintor
	Principal refPrincipal;
	PImage extintor;
	Extintor myExtintor;
	
	public Extintor(int fil, int col, PImage extintor) {
		super(fil, col);
		this.x =9+(col*67);
		this.y =23+(fil*67);
		this.extintor = extintor;
	}

	@Override
	public void pintar(PApplet app, PImage extintor) {
		app.image(extintor, x, y);
	}
	
	public void pintar(PApplet app, PImage extintor, Personaje pj) {
		app.image(extintor, pj.getX(), pj.getY());
	}

	@Override
	protected PImage loadImage(String string) {
		extintor = loadImage("Herra.ExtintorN1.png");
		return null;
	}
	
	boolean validarPersonaje(int personajeX, int personajeY) {
		return false;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}

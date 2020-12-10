import processing.core.PApplet;
import processing.core.PImage;

public abstract class Enemigo {

	protected int x, y, x1, y1;
	
// PImage Enemigo: Fuego
	Principal refPrincipal;
	PImage fuego;
	Fuego myFuego;
	
	public Enemigo() {
		this.x = (int) (Math.random() * 1006);
		this.y = (int) (Math.random() * 700);
	}
	
	public Enemigo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void pintar(PApplet app, PImage fuego) {
		this.fuego = fuego;
		fuego = loadImage("Ene.FuegoN1.png");
	}
		
	protected abstract PImage loadImage(String string);

	public void moverHorizontal(PImage fuego) {
		x++;
	}

	public void moverVertical(PImage fuego) {
		y++;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return fuego.width;
	}
	
	public int getHeight() {
		return fuego.height;
	}
	
}

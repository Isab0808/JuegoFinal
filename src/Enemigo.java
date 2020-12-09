import processing.core.PApplet;
import processing.core.PImage;

public abstract class Enemigo {

	protected int fil, col;
	
// PImage Enemigo: Fuego
	Principal refPrincipal;
	PImage fuego;
	Fuego myFuego;
	
	public Enemigo(int fil, int col) {
		this.fil = fil;
		this.col = col;
	}

	public abstract void pintar(PApplet app, PImage String);
		
	protected abstract PImage loadImage(String string);

	public abstract void moverVertical(PImage String);
	
	public abstract void moverHorizontal(PImage String);
	
}

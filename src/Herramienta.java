import processing.core.PApplet;
import processing.core.PImage;

public abstract class Herramienta {

	protected int fil, col;
	
// PImage Herramienta: Manguera
	Principal refPrincipal;
	PImage manguera;
	Manguera myManguera;
	
	public Herramienta(int fil, int col) {
		this.fil = fil;
		this.col = col;
	}
	
	public abstract void pintar(PApplet app, PImage String);
	
	protected abstract PImage loadImage(String string);
	
}

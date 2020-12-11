import processing.core.PApplet;
import processing.core.PImage;

public  class Herramienta {

	protected int x, y, aumentoVida;
	protected int fil, col;
	Principal refPrincipal;
	PImage herramienta;
	
	public Herramienta(int fil, int col, PImage herramienta) {
		this.fil = fil;
		this.col = col;
		this.x =9+(col*67);
		this.y =23+(fil*67);
		this.herramienta = herramienta;
		
	}

	public void pintar(PApplet app, PImage herramienta) {
		app.image(herramienta, x, y);
	}
	public void pintar(PApplet app, PImage extintor, Personaje pj) {
		app.image(extintor, pj.getX(), pj.getY());
	}
	
	protected PImage loadImage(String string) {
		herramienta = loadImage("Herra.herramientaN1.png");
		return null;
	}
	
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}

	/*protected int fil, col;
	
// PImage Herramienta: herramienta
	Principal refPrincipal;
	PImage herramienta;
	herramienta myherramienta;
	
	public Herramienta(int fil, int col) {
		this.fil = fil;
		this.col = col;
	}
	
	public abstract void pintar(PApplet app, PImage String);
	
	protected abstract PImage loadImage(String string);*/
	
}

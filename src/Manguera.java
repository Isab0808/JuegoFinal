import processing.core.PApplet;
import processing.core.PImage;

public class Manguera extends Herramienta {

	protected int x, y, aumentoVida;
	Principal refPrincipal;
	PImage manguera;
	Manguera myManguera;
	
	public Manguera(int fil, int col, PImage manguera) {
		super(fil, col);
		this.x =9+(col*67);
		this.y =23+(fil*67);
		this.manguera = manguera;
		
	}

	@Override
	public void pintar(PApplet app, PImage manguera) {
		app.image(manguera, x, y);
	}

	@Override
	protected PImage loadImage(String string) {
		manguera = loadImage("Herra.MangueraN1.png");
		return null;
	}
	
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}

}

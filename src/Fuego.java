import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Fuego extends Enemigo {
	Principal refPrincipal;
	PImage fuego;
	protected boolean e1, e2;
	Fuego myFuego;
	
	public Fuego(int x, int y) {
		super(x, y);
		this.e1 = true;
		this.e2 = false;
	}

	@Override
	public void pintar(PApplet app, PImage fuego) {
		app.imageMode(PConstants.CENTER);
		app.image(fuego, x, y);
		app.imageMode(PConstants.CORNER);
	}
	
	public void moverVertical(PImage fuego) {
		if (e1) {
			e2 = false;
			y++;
			if (y >= 700) {
				e2 = true;
			}
		}
		if (e2) {
			e1 = false;
			y--;
			if (y <= 0) {
				e1 = true;
			}
		}
	}

	public void moverHorizontal(PImage fuego) {//a�n no est� en funcionamiento
		if (e1) {
			e2 = false;
			x++;
			if (x >= 975) {
				e2 = true;
			}
		}
		if (e2) {
			e1 = false;
			x--;
			if (x <= 0) {
				e1 = true;
			}
		}
	}
	
	protected PImage loadImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}
	
	public int getDa�oEne() {
		return da�oEne;
	}

}

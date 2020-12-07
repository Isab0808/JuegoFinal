import processing.core.PApplet;
import processing.core.PImage;

public class Fuego extends Enemigo {
// PImage Enemigo: Fuego
	Principal refPrincipal;
	PImage fuego;
	Fuego myFuego;
	
	protected boolean e1, e2;
	
	public Fuego(int x, int y) {
		super(x, y);
		this.e1 = true;
		this.e2 = false;
	}

	@Override
	public void pintar(PApplet app, PImage fuego) {
		app.image(fuego, x, y);
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

	public void moverHorizontal(PImage fuego) {//aún no está en funcionamiento
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

}

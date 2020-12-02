import processing.core.PApplet;

public class Fuego extends Enemigo {
	protected boolean e1, e2;
	
	public Fuego(int x, int y) {
		super(x, y);
		this.e1 = true;
		this.e2 = false;
	}

	@Override
	public void pintar(PApplet app) {
		app.pushStyle();
		app.fill(255, 255, 0);
		app.rectMode(app.CENTER);
		app.rect(x, y, 60, 95, 25, 25, 0, 0);
		app.rectMode(app.CORNER);
		app.popStyle();
	}
	
	public void moverVertical() {
		if (e1) {
			e2 = false;
			y++;
			if (y >= 660) {
				e2 = true;
			}
		}
		if (e2) {
			e1 = false;
			y--;
			if (y <= 40) {
				e1 = true;
			}
		}
	}

	public void moverHorizontal() {
		if (e1) {
			e2 = false;
			x++;
			if (x >= 1006) {
				e2 = true;
			}
		}
		if (e1) {
			e1 = false;
			x--;
			if (y <= 0) {
				e1 = true;
			}
		}
	}

}

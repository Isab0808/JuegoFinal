import processing.core.PApplet;

public abstract class Enemigo {

	protected int x, y;
	
	public Enemigo() {
		this.x = (int) (Math.random() * 1006);
		this.y = (int) (Math.random() * 700);
	}
	
	public Enemigo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void pintar(PApplet app);

	public void moverHorizontal() {
		x++;

	}

	public void moverVertical() {
		y++;
	}
	
}

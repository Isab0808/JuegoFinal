import processing.core.PApplet;
import processing.core.PImage;

public class Fuego extends Enemigo {
// PImage Enemigo: Fuego
	Principal refPrincipal;
	PImage fuego;
	Fuego myFuego;
	
	Mapa refMapa;
	
	protected int x, y;
	protected boolean e1, e2;
	
	public Fuego(int fil, int col, PImage fuego) {
		super(fil, col);
		this.x =3+(col*67);
		this.y =23+(fil*67);
		this.fuego = fuego;
	}

	@Override
	public void pintar(PApplet app, PImage fuego) {
		app.image(fuego, x, y);
	}
	
	@Override
	protected PImage loadImage(String String) {
		fuego = loadImage("Ene.FuegoN1.png");
		return null;
	}
	
	@Override
	public void moverVertical(PImage fuego) {
		if (e1) {
			e2 = false;
			y++;
			if (y >= 700) {
				e2 = true;}
		}
		
		if (e2) {
			e1 = false;
			y--;
			if (y <= 0) {
				e1 = true;}
		}
	}
	
	@Override
	public void moverHorizontal(PImage String) {
		if (e1) {
			e2 = false;
			x++;
			if (x >= 700) {
				e2 = true;}
		}
		
		if (e2) {
			e1 = false;
			x--;
			if (x <= 0) {
				e1 = true;}
		}
	}
	
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}

	

}

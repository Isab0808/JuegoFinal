import java.util.Random;

import processing.core.PApplet;

public class PuzzleN1 extends PApplet{
	int xBolitaPrincipal;
	int yBolitaPrincipal;
	
	int xBolitas [];
	int yBolitas [];
	
	boolean atrapado [];
	boolean visible [];

	int tamaño;
	
	public PuzzleN1(PApplet app, int size) {
		xBolitaPrincipal = app.width / 2;
		yBolitaPrincipal = app.height / 2;
		
		xBolitas = new int [size];
		yBolitas = new int [size];
		
		atrapado = new boolean [size];
		visible = new boolean [size];
		
		Random bolitas = new Random();
		for (int i = 0; i < size; i++) {
			bolitas.nextInt(app.width);
			int x = bolitas.nextInt(app.width);
			int y = bolitas.nextInt(app.height);;
			xBolitas[i] = x;
			yBolitas[i] = y;
			visible[i] = true;
		}
		tamaño = 90;
	}
	
	public void pintar(PApplet app) {
		app.background(255, 236, 245);
		app.fill(218, 0, 172);
		app.ellipse(xBolitaPrincipal, yBolitaPrincipal, tamaño, tamaño);
		
		for (int i = 0; i < visible.length; i++) {
			if (visible [i] == true) {
				app.fill(255);
				app.ellipse(xBolitas[i], yBolitas[i], 40, 40);
			}
		}
	}
	
	public void mousePressed(PApplet app) {
		
		for (int i = 0; i < xBolitas.length; i++) {
			if (dist(xBolitas[i], yBolitas[i], app.mouseX, app.mouseY) < 20) {
				atrapado[i]  = true;
			}
		}
	}

	public void mouseMover(int x,int y) {
		for (int i = 0; i < xBolitas.length; i++) {
			if (atrapado[i] == true) {
				
				xBolitas[i] = x;
				yBolitas[i] = y;
			}
		}
	}

	public void mouseConfirm() {

		for (int i = 0; i < xBolitas.length; i++) {
			if (dist(xBolitas[i], yBolitas[i], xBolitaPrincipal, yBolitaPrincipal) < tamaño / 2 && visible[i]==true) {
				tamaño += 20;
				visible[i] = false;
			}
		}

		for (int i = 0; i < xBolitas.length; i++) {
			atrapado[i] = false;
		}
		
	}
	public boolean win() {
		boolean v = true;
		for (int i = 0; i < visible.length; i++) {
			if (visible[i] == true) {
				v = false;
				break;
			}
		}
		return v;
	}
	

}

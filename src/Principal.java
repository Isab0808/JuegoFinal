import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() {
		size(1200, 700);
	}
	
	PImage[] pantalla;
	
	int estado;
	
// x y y de Boton Inicio
	int xBotonInicio;
	int yBotonInicio;
	
	int [][] mapa;
	
	@Override
	public void setup() {
		pantalla = new PImage[15];
		pantalla[0] = loadImage("PantallaInicio.jpg");
		pantalla[1] = loadImage("BotonInicio.png");
		pantalla[2] = loadImage("BotonInicioOprimido.png");
		pantalla[3] = loadImage("InstruccionesG.jpg");
		pantalla[4] = loadImage("BotonSiguienteIG.png");
		pantalla[5] = loadImage("Ins.Nivel1.jpg");
		pantalla[6] = loadImage("BotonSiguienteN1.png");
		pantalla[7] = loadImage("EscenarioN1.jpg");
		pantalla[8] = loadImage("NuevaPartidaN1.png");
		pantalla[9] = loadImage("VidaN1.png");
		pantalla[10] = loadImage("Ene.FuegoN1.png");
		pantalla[11] = loadImage("Herra.ExtintorN1.png");
		pantalla[12] = loadImage("Herra.MangueraN1.png");
		pantalla[13] = loadImage("Muro1.png");
		pantalla[14] = loadImage("Muro2.png");
		
		
		estado = 0;
		
	// x y y de Boton Inicio
		xBotonInicio = 480;
		yBotonInicio = 430;
		
		mapa = new int [10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				mapa [i][j] = 0;
			}
		}
	}
	
	@Override
	public void draw() {
		System.out.println(mouseX + "," + mouseY);
		
		switch (estado) {
		case 0:
		//INICIO
			//Imagen Inicio
			imageMode(CENTER);
			image(pantalla[0], 600, 350);
			imageMode(CORNER);
			
			// BOTON INICIO
			// Imagen Boton Inicio
			image(pantalla[1], xBotonInicio, yBotonInicio);
			
			// Si esta el mouse encima del Boton Inicio mostrar imagen Boton Inicio Oprimido
			if (mouseX > xBotonInicio && mouseX < xBotonInicio + 106 
				&& mouseY > yBotonInicio && mouseY < yBotonInicio + 107) {
				image(pantalla[2], xBotonInicio, yBotonInicio);}
			
			break;

		default:
			break;
		}
	}

}

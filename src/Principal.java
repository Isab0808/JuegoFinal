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
	
// x y y de Boton Instrucciones
		int xBotonInstrucciones;
		int yBotonInstrucciones;
	
	int [][] mapa;
	
	@Override
	public void setup() {
		pantalla = new PImage[17];
		pantalla[0] = loadImage("PantallaInicio.jpg");
		pantalla[1] = loadImage("BotonInicio.png");
		pantalla[2] = loadImage("BotonInicioOprimido.png");
		pantalla[3] = loadImage("InstruccionesG.jpg");
		pantalla[4] = loadImage("BotonSiguienteIG.png");
		pantalla[5] = loadImage("BotonSiguienteIGOprimido.png");
		pantalla[6] = loadImage("Ins.Nivel1.jpg");
		pantalla[7] = loadImage("BotonSiguienteN1.png");
		pantalla[8] = loadImage("BotonSiguienteOprimidoN1.png");
		pantalla[9] = loadImage("EscenarioN1.jpg");
		pantalla[10] = loadImage("NuevaPartidaN1.png");
		pantalla[11] = loadImage("VidaN1.png");
		pantalla[12] = loadImage("Ene.FuegoN1.png");
		pantalla[13] = loadImage("Herra.ExtintorN1.png");
		pantalla[14] = loadImage("Herra.MangueraN1.png");
		pantalla[15] = loadImage("Muro1.png");
		pantalla[16] = loadImage("Muro2.png");
		
		
		estado = 0;
		
	// x y y de Boton Inicio
		xBotonInicio = 480;
		yBotonInicio = 430;
		
	// x y y de Boton Instrucciones
		xBotonInstrucciones= 1060;
		yBotonInstrucciones = 565;
		
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
			
		case 1:
		//INSTRUCCIONES GENERALES
			//Imagen Instrucciones Generales
			imageMode(CENTER);
			image(pantalla[3], 600, 350);
			imageMode(CORNER);
				
			// BOTON INICIO
			// Imagen Boton Instrucciones
			image(pantalla[4], xBotonInstrucciones, yBotonInstrucciones);
				
			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
				&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
				image(pantalla[5], xBotonInstrucciones, yBotonInstrucciones);}
				
				break;
				
		case 2:
		//INSTRUCCIONES NIVEL 1
			//Imagen Instrucciones Nivel 1
			imageMode(CENTER);
			image(pantalla[6], 600, 350);
			imageMode(CORNER);
					
			// BOTON INICIO
			// Imagen Boton Instrucciones Nivel 1
			image(pantalla[7], xBotonInstrucciones, yBotonInstrucciones);
					
			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
				&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
				image(pantalla[8], xBotonInstrucciones, yBotonInstrucciones);}
					
			break;
			
		case 3:
		//INSTRUCCIONES NIVEL 1
			//Imagen Instrucciones Nivel 1
			imageMode(CENTER);
			image(pantalla[9], 600, 350);
			imageMode(CORNER);
			
			int x = 25;
			int y = 25;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
				switch (mapa [i][j]) {
				case 0:
					fill(0);
				break;
				case 1:
					fill(255,255,0);
				break;}
				rectMode(CENTER);
				rect(x,y, 68, 68);
				rectMode(CORNER);
				x+= 68;
				if (x >= 700) {
					x = 25;
					y += 68;}
			}	
		}
						
			break;
		}
	}
	
	@Override
	public void mousePressed() {
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
			
			// Cuando se le de clic en Boton Inicio pasar a la pantalla Instrucciones Generales
			if (mouseX > xBotonInicio && mouseX < xBotonInicio + 106 
				&& mouseY > yBotonInicio && mouseY < yBotonInicio + 107) {
				estado = 1;}
			
			break;
			
		case 1:
		//INSTRUCCIONES GENERALES
			//Imagen Instrucciones Generales
			imageMode(CENTER);
			image(pantalla[3], 600, 350);
			imageMode(CORNER);
					
			// BOTON INICIO
			// Imagen Boton Instrucciones
			image(pantalla[4], xBotonInstrucciones, yBotonInstrucciones);
					
			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
				&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
				image(pantalla[5], xBotonInstrucciones, yBotonInstrucciones);}
			
			// Cuando se le de clic en Boton Inicio pasar a la pantalla Instrucciones Generales
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
				&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
				estado = 2;}
					
			break;
			
		case 2:
		//INSTRUCCIONES NIVEL 1
			//Imagen Instrucciones Nivel 1
			imageMode(CENTER);
			image(pantalla[6], 600, 350);
			imageMode(CORNER);
						
			// BOTON INICIO
			// Imagen Boton Instrucciones Nivel 1
			image(pantalla[7], xBotonInstrucciones, yBotonInstrucciones);
						
			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
				&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
				image(pantalla[8], xBotonInstrucciones, yBotonInstrucciones);}
			
			// Cuando se le de clic en Boton Inicio pasar a la pantalla Instrucciones Generales
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
				&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
				estado = 3;}
						
			break;
		}
	}

}

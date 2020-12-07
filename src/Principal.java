import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet{

	private ArrayList<Fuego>listaEnemigos;
	
	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() {
		size(1200, 700);
	}
	
// Arreglo de imagenes Pantalla
	PImage[] pantalla;
	
// PImage Enemigo: Fuego
	PImage fuego;
	Fuego myFuego;
	
// PImage Personaje Mujer
	PImage personajeM;
	Personaje myPersonajeM;
	
// PImage Herramienta: Manguera
	PImage manguera;
	Manguera myManguera;
	
// PImage Herramienta: Extintor
	PImage extintor;
	
// PImage Escenario: Muro1
	PImage muro1;
	Mapa myMuro1;
	
// PImage Escenario: Muro2
	PImage muro2;
	Mapa myMuro2;

// Para el switch de las pantallas
	int estado;
	
//Llamar clases
	Mapa mapa;
	Fuego fuegoE;
	Personaje personaje;
	//Extintor extintorH;

// Arraylist de Enemigo
	ArrayList<Enemigo> EnemyV;
	ArrayList<Enemigo> EnemyH;
	
	ArrayList<Enemigo> enemigo;

// Arraylist de Herramienta: Manguera
	ArrayList<Manguera> listaManguera;
	
// x y y de Boton Inicio
	int xBotonInicio;
	int yBotonInicio;
	
// x y y de Boton Instrucciones
	int xBotonInstrucciones;
	int yBotonInstrucciones;
	
// Temporizador
	int segundos;
	int minutos;
	
	@Override
	public void setup() {
		pantalla = new PImage[18];
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
		pantalla[17] = loadImage("GameOver.jpg");
		
	//Cargando las imagenes: Fuego, manguera, muro, etc..
		fuego = loadImage("Ene.FuegoN1.png");
		personajeM = loadImage("PersonajeMujer.png");
		manguera = loadImage("Herra.MangueraN1.png");
		extintor = loadImage("Herra.ExtintorN1.png");
		muro1 = loadImage("Muro1.png");
		muro2 = loadImage("Muro2.png");
		
	// Para el switch de las pantallas
		estado = 0;
		
	//Llamar clases
		mapa = new Mapa ();
		personaje = new Personaje(4,5, mapa);
		//extintorH = new Extintor(5, 8, extintor);
		
	//Inicializar el arraylist de enemigo: Fuego y agregar nuevos
		listaEnemigos = new ArrayList<>();
		
		int x = 12;
		int y = 0;
		for (int i = 0; i < 2; i++) {
			Fuego enemigo = new Fuego(x, y);
			listaEnemigos.add(enemigo);
			x+= 895;}
		
		/*myFuego = new Fuego(250, 250);
		
		EnemyV = new ArrayList<Enemigo>();
		EnemyV.add(new Fuego(12, 0));
		EnemyV.add(new Fuego(906, 700));

		EnemyH = new ArrayList<Enemigo>();
		EnemyH.add(new Fuego(25, 100));*/
		
	//Inicializar el arraylist de herramienta: Manguera y agregar nuevos
		myManguera = new Manguera(0, 0, manguera);
		listaManguera = new ArrayList<Manguera>();
		listaManguera.add(new Manguera(0, 5, manguera));
		listaManguera.add(new Manguera(3, 0, manguera));
		
	// x y y de Boton Inicio
		xBotonInicio = 480;
		yBotonInicio = 430;
		
	// x y y de Boton Instrucciones
		xBotonInstrucciones= 1060;
		yBotonInstrucciones = 565;
		
	// Temporizador
		segundos = 59;
		minutos = 2;
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
					
			// BOTON INSTRUCCIONES NIVEL 1
			// Imagen Boton Instrucciones Nivel 1
			image(pantalla[7], xBotonInstrucciones, yBotonInstrucciones);
					
			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
				&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
				image(pantalla[8], xBotonInstrucciones, yBotonInstrucciones);}
					
			break;
			
		case 3:
		//ESCENARIO NIVEL 1
			//Imagen Escenario Nivel 1
			imageMode(CENTER);
			image(pantalla[9], 600, 350);
			imageMode(CORNER);
		
			temporizador();
			
			mapa.pintar(this, muro1, muro2, extintor);
			
		//For para pintar la Herramienta: Manguera
			for (int i = 0; i < listaManguera.size(); i++) {
				listaManguera.get(i).pintar(this, manguera);}
			
			//extintorH.pintar(this, extintor);
			personaje.pintar(this, personajeM, extintor);
			
		//For para pintar y mover el Enemigo: Fuego
			/*for (int i = 0; i < EnemyV.size(); i++) {
				EnemyV.get(i).pintar(this, fuego);
				EnemyV.get(i).moverVertical(fuego);}*/		
			
		//For para pintar y mover el Enemigo: Fuego
			for (int i = 0; i < listaEnemigos.size(); i++) {
				Fuego enemigoActual = listaEnemigos.get(i);
				enemigoActual.pintar(this, fuego);
				enemigoActual.moverVertical(fuego);}
			
			break;
			
		case 4:
			//GAME OVER - PERDIO
				//Imagen Game Over
				imageMode(CENTER);
				image(pantalla[17], 600, 350);
				imageMode(CORNER);
				
				// BOTON INSTRUCCIONES NIVEL 1
				// Imagen Boton Instrucciones Nivel 1
				image(pantalla[4], xBotonInstrucciones, yBotonInstrucciones);
						
				// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton Instrucciones Oprimido
				if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
					&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
					image(pantalla[5], xBotonInstrucciones, yBotonInstrucciones);}
				
				break;
		}
	}
	
	public void temporizador() {
		if (frameCount % 60 == 0 && minutos >= 0) {
	        segundos--;}
	    if (segundos == 0) {
	        minutos--;
	        segundos = 59;}
	    if (minutos < 0) {
	    	fill(255);
	        textSize(23);
	        text("0:00", 1082, 325);
	    } else if (segundos <= 9) {
	    	fill(255);
	        textSize(23);
	        text(minutos + ":0" + segundos, 1082, 325);
	    } else if (segundos > 9) {
	    	fill(255);
	        textSize(23);
	        text(minutos + ":" + segundos, 1082, 325);
	    }

	    if (minutos < 0) {
	        estado = 4;
	    }
	}
	
	@Override
	public void keyPressed() {
		switch (key) {
		case 'w':
			personaje.mover("arriba");
			break;
		case 'a':
			personaje.mover("izquierda");
			break;
		case 's':
			personaje.mover("abajo");
			break;
		case 'd':
			personaje.mover("derecha");
			break;
		default:	
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
			
		case 3:
			//ESCENARIO NIVEL 1
			//Imagen Escenario Nivel 1
			imageMode(CENTER);
			image(pantalla[9], 600, 350);
			imageMode(CORNER);
		
			temporizador();
			
			mapa.pintar(this, muro1, muro2, extintor);
			
		//For para pintar la Herramienta: Manguera
			for (int i = 0; i < listaManguera.size(); i++) {
				listaManguera.get(i).pintar(this, manguera);}
			
			//extintorH.pintar(this, extintor);
			personaje.pintar(this, personajeM, extintor);
			
		//For para pintar y mover el Enemigo: Fuego
			/*for (int i = 0; i < EnemyV.size(); i++) {
				EnemyV.get(i).pintar(this, fuego);
				EnemyV.get(i).moverVertical(fuego);}*/		
			
		//For para pintar y mover el Enemigo: Fuego
			for (int i = 0; i < listaEnemigos.size(); i++) {
				Fuego enemigoActual = listaEnemigos.get(i);
				enemigoActual.pintar(this, fuego);
				enemigoActual.moverVertical(fuego);}
				break;
				
		case 4:
			//GAME OVER - PERDIO
				//Imagen Game Over
				imageMode(CENTER);
				image(pantalla[17], 600, 350);
				imageMode(CORNER);
				
				// BOTON INSTRUCCIONES NIVEL 1
				// Imagen Boton Instrucciones Nivel 1
				image(pantalla[4], xBotonInstrucciones, yBotonInstrucciones);
						
				// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton Instrucciones Oprimido
				if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
					&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
					image(pantalla[5], xBotonInstrucciones, yBotonInstrucciones);}
				
				// Cuando se le de clic en Boton Siguiente pasar a la pantalla de Inicio
				if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 
					&& mouseY > yBotonInstrucciones && mouseY < yBotonInstrucciones + 107) {
					estado = 0;}
				
				break;
		
		}
	}

}

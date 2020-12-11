import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	private ArrayList<Fuego> listaEnemigos;

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() {
		size(1200, 700);
	}
// Arreglo de imagenes Pantalla
	PImage[] pantalla;
	PImage[] instrucciones;
	PImage[] botonesIns;
	PImage[] escenarios;
	PImage[] botonesEsce;
	PImage[] vidas;
	PImage[] enemigos;
	PImage[] herramientas;
	PImage[] personajeSeleccionado;

// PImage Enemigo: Fuego
	PImage fuego;
	Fuego myFuego;
	
// PImage Personaje Seleccionado, para que aparezca en el escenario
	PImage personajePrincipal;

// PImage Personaje Mujer
	PImage personajeM;
	Personaje myPersonajeM;

// PImage Herramienta: herramienta
	PImage herramienta;
	Herramienta myHerramienta;

// PImage Herramienta: Extintor
	PImage extintor;

// PImage Escenario: Muro1
	PImage muro1;
	Mapa myMuro1;

// PImage Escenario: Muro2
	PImage muro2;
	Mapa myMuro2;
	
// PImage Escenario: Muro2
	PImage puertaCerrada;
	Mapa myPuertaCerrada;
	
// PImage Escenario: Muro2
	PImage puertaAbierta;
	Mapa myPuertaAbierta;
	
// PImage Puzzle
	PImage puzzle;

// Para el switch de las pantallas
	int estado;

//Llamar clases
	Mapa mapa;
	Fuego fuegoE;
	Personaje personaje;
	PuzzleN1 puzzleN1;

// Arraylist de Herramienta: herramienta
	ArrayList<Herramienta> listaHerramienta;

// x y y de Boton Inicio
	int xBotonInicio;
	int yBotonInicio;

// x y y de Boton Instrucciones
	int xBotonInstrucciones;
	int yBotonInstrucciones;

// x y y de Boton Nueva Patida
	int xBotonNuevaPartida;
	int yBotonNuevaPartida;

// Temporizador
	int segundos;
	int minutos;

// Variable para las vidas del personaje
	int inicio;
	
// Variable para saber si se gano
	boolean win;
	
// Variable para cambiar de imagenes(estado) a medida que aumenta de nivel
	int nivelActual;
	
// x y y de pantalla personaje: Personaje seleccionado
	int xPM;
	int yPM;
	
	int xPH;
	int yPH;
	

	@Override
	public void setup() {
		pantalla = new PImage[26];
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
		pantalla[18] = loadImage("NuevaPartidaN1Oprimido.png");
		pantalla[19] = loadImage("PuertaAbierta.png");
		pantalla[20] = loadImage("Ganaste.jpg");
		pantalla[21] = loadImage("BotonSiguienteG.png");
		pantalla[22] = loadImage("BotonSiguienteGOprimido.png");
		pantalla[23] = loadImage("SeleccionPersonaje.jpg");
		pantalla[24] = loadImage("BotonSiguientePersonaje.png");
		pantalla[25] = loadImage("BotonSiguientePersonajeOprimidoN4.png");
		
		instrucciones = new PImage[5];
		instrucciones[0] = loadImage("Ins.Nivel1.jpg");
		instrucciones[1] = loadImage("Ins.Nivel2.jpg");
		instrucciones[2] = loadImage("Ins.Nivel3.jpg");
		instrucciones[3] = loadImage("Ins.Nivel4.jpg");
		instrucciones[4] = loadImage("Ins.Nivel5.jpg");
		
		botonesIns = new PImage[10];
		botonesIns[0] = loadImage("BotonSiguienteN1.png");
		botonesIns[1] = loadImage("BotonSiguienteOprimidoN1.png");
		botonesIns[2] = loadImage("BotonSiguienteN2.png");
		botonesIns[3] = loadImage("BotonSiguienteOprimidoN2.png");
		botonesIns[4] = loadImage("BotonSiguienteN3.png");
		botonesIns[5] = loadImage("BotonSiguienteOprimidoN3.png");
		botonesIns[6] = loadImage("BotonSiguienteN4.png");
		botonesIns[7] = loadImage("BotonSiguienteOprimidoN4.png");
		botonesIns[8] = loadImage("BotonSiguienteN5.png");
		botonesIns[9] = loadImage("BotonSiguienteOprimidoN5.png");
		
		escenarios = new PImage[5];
		escenarios[0] = loadImage("EscenarioN1.jpg");
		escenarios[1] = loadImage("EscenarioN2.jpg");
		escenarios[2] = loadImage("EscenarioN3.jpg");
		escenarios[3] = loadImage("EscenarioN4.jpg");
		escenarios[4] = loadImage("EscenarioN5.jpg");
		
		botonesEsce = new PImage[10];
		botonesEsce[0] = loadImage("NuevaPartidaN1.png");
		botonesEsce[1] = loadImage("NuevaPartidaN1Oprimido.png");
		botonesEsce[2] = loadImage("NuevaPartidaN2.png");
		botonesEsce[3] = loadImage("NuevaPartidaN2Oprimido.png");
		botonesEsce[4] = loadImage("NuevaPartidaN3.png");
		botonesEsce[5] = loadImage("NuevaPartidaN3Oprimido.png");
		botonesEsce[6] = loadImage("NuevaPartidaN4.png");
		botonesEsce[7] = loadImage("NuevaPartidaN4Oprimido.png");
		botonesEsce[8] = loadImage("NuevaPartidaN5.png");
		botonesEsce[9] = loadImage("NuevaPartidaN5Oprimido.png");
		
		vidas = new PImage[5];
		vidas[0] = loadImage("VidaN1.png");
		vidas[1] = loadImage("VidaN2.png");
		vidas[2] = loadImage("VidaN3.png");
		vidas[3] = loadImage("VidaN4.png");
		vidas[4] = loadImage("VidaN5.png");
		
		enemigos = new PImage[5];
		enemigos[0] = loadImage("Ene.FuegoN1.png");
		enemigos[1] = loadImage("Ene.TanqueGuerraN2.png");
		enemigos[2] = loadImage("Ene.HuracanN3.png");
		enemigos[3] = loadImage("Ene.ExtraterrestreN4.png");
		enemigos[4] = loadImage("Ene.CoronavirusN5.png");
		
		herramientas = new PImage[10];
		herramientas[0] = loadImage("Herra.ExtintorN1.png");
		herramientas[1] = loadImage("Herra.MangueraN1.png");
		herramientas[2] = loadImage("Herra.LlaveN2.png");
		herramientas[3] = loadImage("Herra.CascoGuerraN2.png");
		herramientas[4] = loadImage("Herra.ComidaN3.png");
		herramientas[5] = loadImage("Herra.BaldeN3.png");
		herramientas[6] = loadImage("Herra.GorroProtectorN4.png");
		herramientas[7] = loadImage("Herra.RayoLaserN4.png");
		herramientas[8] = loadImage("Herra.VacunaN5.png");
		herramientas[9] = loadImage("Herra.TapabocasN5.png");
		
		personajeSeleccionado = new PImage[4];
		personajeSeleccionado[0] = loadImage("PersonajeSeleccionadoM.png");
		personajeSeleccionado[1] = loadImage("PersonajeSeleccionadoH.png");
		personajeSeleccionado[2] = loadImage("PersonajeMujer.png");
		personajeSeleccionado[3] = loadImage("PersonajeHombre.png");
		
		// Cargando las imagenes: Fuego, herramienta, muro, etc..
		fuego = loadImage("Ene.FuegoN1.png");
		personajeM = loadImage("PersonajeMujer.png");
		herramienta = loadImage("Herra.MangueraN1.png");
		extintor = loadImage("Herra.ExtintorN1.png");
		muro1 = loadImage("Muro1.png");
		muro2 = loadImage("Muro2.png");
		puertaCerrada = loadImage("PuertaCerrada.png");
		puertaAbierta = loadImage("PuertaAbierta.png");
		puzzle = loadImage("Puzzle.jpg");

		// Para el switch de las pantallas
		estado = 0;

		// Llamar clases
		mapa = new Mapa();
		personaje = new Personaje(6, 5, mapa);
		puzzleN1 = new PuzzleN1(this, nivelActual*2+6);

		// x y y de Boton Inicio
		xBotonInicio = 480;
		yBotonInicio = 430;

		// x y y de Boton Instrucciones
		xBotonInstrucciones = 1060;
		yBotonInstrucciones = 565;

		// x y y de Boton Instrucciones
		xBotonNuevaPartida = 1075;
		yBotonNuevaPartida = 565;

		// Temporizador
		segundos = 59;
		minutos = 2;

		// Variable para las vidas del personaje
		inicio = minutos * 60 + segundos + 3;
		
		// Variable para cambiar de imagenes(estado) a medida que aumenta de nivel
		nivelActual = 0;
		
		// x y y de pantalla personaje: Personaje seleccionado
		xPM= 295;
		yPM = 270;
		
		xPH = 670;
		yPH = 280;
		
	}

	@Override
	public void draw() {
		switch (estado) {
		case 0:
			// INICIO
			// Imagen Inicio
			imageMode(CENTER);
			image(pantalla[0], 600, 350);
			imageMode(CORNER);
			
			// BOTON INICIO
			// Imagen Boton Inicio
			image(pantalla[1], xBotonInicio, yBotonInicio);

			// Si esta el mouse encima del Boton Inicio mostrar imagen Boton Inicio Oprimido
			if (mouseX > xBotonInicio && mouseX < xBotonInicio + 106 && mouseY > yBotonInicio
					&& mouseY < yBotonInicio + 107) {
				image(pantalla[2], xBotonInicio, yBotonInicio);
			}

			break;

		case 1:
			// INSTRUCCIONES GENERALES
			// Imagen Instrucciones Generales
			imageMode(CENTER);
			image(pantalla[3], 600, 350);
			imageMode(CORNER);

			// BOTON INICIO
			// Imagen Boton Instrucciones
			image(pantalla[4], xBotonInstrucciones, yBotonInstrucciones);

			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton
			// Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
				&& mouseY < yBotonInstrucciones + 107) {
				image(pantalla[5], xBotonInstrucciones, yBotonInstrucciones);
			}

			break;

		case 2:
			// INSTRUCCIONES NIVEL 1
			// Imagen Instrucciones Nivel 1
			imageMode(CENTER);
			image(instrucciones[nivelActual], 600, 350);
			imageMode(CORNER);
			
			mapa = new Mapa();
			personaje = new Personaje(6, 5, mapa);

			// BOTON INSTRUCCIONES NIVEL 1
			// Imagen Boton Instrucciones Nivel 1
			image(botonesIns[nivelActual*2], xBotonInstrucciones, yBotonInstrucciones);

			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton
			// Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
				&& mouseY < yBotonInstrucciones + 107) {
				image(botonesIns[nivelActual*2+1], xBotonInstrucciones, yBotonInstrucciones);
			}
			
			// Inicializar el arraylist de enemigo: Enemigos y agregar nuevos
			int x = 300;
			int y = 0;
			listaEnemigos = new ArrayList<>();
			Random ene = new Random();
			for (int i = 0; i < nivelActual+1; i++) {
				Fuego enemigo = new Fuego(x, y);
				listaEnemigos.add(enemigo);
				x = ene.nextInt(13*67)+67;
			}
			
			// Inicializar el arraylist de herramienta: Herramienta y agregar nuevas
			myHerramienta = new Herramienta(0, 0, herramienta);
			listaHerramienta = new ArrayList<Herramienta>();
			listaHerramienta.add(new Herramienta(3, 9, herramienta));
			listaHerramienta.add(new Herramienta(9, 14, herramienta));

			break;

		case 3:
			// ESCENARIO NIVEL 1
			// Imagen Escenario Nivel 1
			imageMode(CENTER);
			image(escenarios[nivelActual], 600, 350);
			imageMode(CORNER);

			// BOTON ATRAS
			// Imagen Boton Atras
			image(botonesEsce[nivelActual*2], xBotonNuevaPartida, yBotonNuevaPartida);

			// Si esta el mouse encima del Boton Atras mostrar imagen Boton Atras Oprimido
			if (mouseX > xBotonNuevaPartida && mouseX < xBotonNuevaPartida + 58 && mouseY > yBotonNuevaPartida
				&& mouseY < yBotonNuevaPartida + 71) {
				image(botonesEsce[nivelActual*2+1], xBotonNuevaPartida, yBotonNuevaPartida);
			}
			
			//For para agregar las vidas al personaje
			for (int i = 0; i < personaje.getVidas(); i++) {
				image(vidas[nivelActual], 1065 + i*30, 420);}

			temporizador();

			mapa.pintar(this, muro1, muro2, herramientas[nivelActual*2], puertaCerrada, puertaAbierta);
			personaje.pintar(this, personajePrincipal, herramientas[nivelActual*2]);

			// For para pintar la Herramienta: herramienta
			for (int i = 0; i < listaHerramienta.size(); i++) {
				listaHerramienta.get(i).pintar(this, herramientas[nivelActual*2+1]);
				Herramienta herramientaActual = listaHerramienta.get(i);
				if ((personaje.getX() -34 >= herramientaActual.getX()-9 && personaje.getX() -34 <= herramientaActual.getX()-9 + 67)
						|| (personaje.getX() -34 + 67 >= herramientaActual.getX()-9
								&& personaje.getX()-34 + 67 <= herramientaActual.getX()-9 + 67)) {
					if ((personaje.getY()-45 >= herramientaActual.getY()-23
							&& personaje.getY()-45 <= herramientaActual.getY() + 67)
						|| (personaje.getY()-45 + personajeM.height >= herramientaActual.getY() -23
								&& personaje.getY()-45 + personajeM.height <= herramientaActual.getY()-23 + 67)) {
						personaje.darVida();
						listaHerramienta.remove(i);
					}
				}
			}

			// Indicar que si ya elimine a los enemigos entonces gano
			if(listaEnemigos.size()==0) {
				estado=5;
				personaje.quitarExtintor();
				win = false;}
			
			// For para pintar la Enemigo: Enemigos
			for (int i = 0; i < listaEnemigos.size(); i++) {
				Enemigo enemigoActual = listaEnemigos.get(i);
				enemigoActual.pintar(this, enemigos[nivelActual]);
				enemigoActual.moverVertical(enemigos[nivelActual]);
				 if(personaje.haveExtintor()) {
					 win=true;
				 }
				 if(!personaje.haveExtintor()&& win) {
					 estado = 4;
					 win = false;
				 }
				if ((personaje.getX() >= enemigoActual.getX() && personaje.getX() <= enemigoActual.getX() + fuego.width)
						|| (personaje.getX() + personajeM.width >= enemigoActual.getX()
								&& personaje.getX() + personajeM.width <= enemigoActual.getX() + fuego.width)) {
					if ((personaje.getY() >= enemigoActual.getY()
							&& personaje.getY() <= enemigoActual.getY() + fuego.height)
							|| (personaje.getY() + personajeM.height >= enemigoActual.getY()
									&& personaje.getY() + personajeM.height <= enemigoActual.getY() + fuego.height)) {
						if (personaje.haveExtintor()) {
							listaEnemigos.remove(i);
						} else if (inicio - 3 > (minutos * 60 + segundos)) {
							personaje.quitarVida(enemigoActual.getDañoEne());
							//System.out.println("have extintor");
							if (personaje.getVidas() == 0) {
								estado = 4;
								win= false;
							}
							inicio = minutos * 60 + segundos;
						}
					}
				}
			}
			break;

		case 4:
			// GAME OVER - PERDIO
			// Imagen Game Over
			imageMode(CENTER);
			image(pantalla[17], 600, 350);
			imageMode(CORNER);

			// BOTON SIGUIENTE
			// Imagen Siguiente
			image(pantalla[4], xBotonInstrucciones, yBotonInstrucciones);

			// Si esta el mouse encima del Boton Siguiente mostrar imagen Boton
			// Siguiente Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
				&& mouseY < yBotonInstrucciones + 107) {
				image(pantalla[5], xBotonInstrucciones, yBotonInstrucciones);}
			break;
			
		case 5:
			// GANASTE
			// Imagen Ganaste
			imageMode(CENTER);
			image(pantalla[20], 600, 350);
			imageMode(CORNER);

			// BOTON SIGUIENTE
			// Imagen Boton Siguiente
			image(pantalla[21], xBotonInstrucciones, yBotonInstrucciones);

			// Si esta el mouse encima del Boton Siguiente mostrar imagen Boton
			// Siguiente Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
				&& mouseY < yBotonInstrucciones + 107) {
				image(pantalla[22], xBotonInstrucciones, yBotonInstrucciones);}
			break;
			
		case 6:
			// PUZZLE
			// Puzzle Nivel 1
			puzzleN1.pintar(this, puzzle);
			if(puzzleN1.win()) {
				estado =3;
				mapa.openDoor();
			}
			break;
		case 7:
			// SELECCIONAR PERSONAJE
			// Imagen Seleccion Personaje
			imageMode(CENTER);
			image(pantalla[23], 600, 350);
			imageMode(CORNER);
			
			// Si esta el mouse encima del Boton Mujer mostrar imagen Boton
			// Mujer Oprimido
			if (mouseX > xPM && mouseX < xPM + 255 && mouseY > yPM
					&& mouseY < yBotonInstrucciones + 252) {
					image(personajeSeleccionado[0], xPM, yPM);}
				
			// Si esta el mouse encima del Boton Mujer mostrar imagen Boton
			// Mujer Oprimido
			if (mouseX > xPH && mouseX < xPH + 256 && mouseY > yPH
				&& mouseY < yPH + 238) {
				image(personajeSeleccionado[1], xPH, yPH);}
			break;
		}
	}

	public void temporizador() {
		if (frameCount % 60 == 0 && minutos >= 0) {
			segundos--;
		}
		if (segundos == 0) {
			minutos--;
			segundos = 59;
		}
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
		//Para la barra espaciadora
		if(keyCode == 32) {
			if((personaje.getX()-34>= 8*64 - 67) && (personaje.getX()-34<= 8*64 + 67)) {
				if((personaje.getY()-45>= 9*64 - 67) && (personaje.getY()-45<= 9*64 + 67)) {
					estado = 6;}
			}
		}
		
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
		//Para que lea el mousePressed de la clase Puzzle en la principal
		if (estado == 6) {
			puzzleN1.mousePressed(this);}
		
		switch (estado) {
		case 0:
			// INICIO
			// Imagen Inicio
			imageMode(CENTER);
			image(pantalla[0], 600, 350);
			imageMode(CORNER);

			// BOTON INICIO
			// Imagen Boton Inicio
			image(pantalla[1], xBotonInicio, yBotonInicio);

			// Si esta el mouse encima del Boton Inicio mostrar imagen Boton Inicio Oprimido
			if (mouseX > xBotonInicio && mouseX < xBotonInicio + 106 && mouseY > yBotonInicio
					&& mouseY < yBotonInicio + 107) {
				image(pantalla[2], xBotonInicio, yBotonInicio);
			}

			// Cuando se le de clic en Boton Inicio pasar a la pantalla Instrucciones
			// Generales
			if (mouseX > xBotonInicio && mouseX < xBotonInicio + 106 && mouseY > yBotonInicio
				&& mouseY < yBotonInicio + 107) {
				estado = 1;
			}

			break;

		case 1:
			// INSTRUCCIONES GENERALES
			// Imagen Instrucciones Generales
			imageMode(CENTER);
			image(pantalla[3], 600, 350);
			imageMode(CORNER);

			// BOTON INICIO
			// Imagen Boton Instrucciones
			image(pantalla[4], xBotonInstrucciones, yBotonInstrucciones);

			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton
			// Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
					&& mouseY < yBotonInstrucciones + 107) {
				image(pantalla[5], xBotonInstrucciones, yBotonInstrucciones);
			}

			// Cuando se le de clic en Boton Inicio pasar a la pantalla Seleccion de
			// Personaje
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
				&& mouseY < yBotonInstrucciones + 107) {
				estado = 7;
			}

			break;

		case 2:
			// INSTRUCCIONES NIVEL 1
			// Imagen Instrucciones Nivel 1
			imageMode(CENTER);
			image(pantalla[6], 600, 350);
			imageMode(CORNER);

			// BOTON INICIO
			// Imagen Boton Instrucciones Nivel 1
			image(pantalla[7], xBotonInstrucciones, yBotonInstrucciones);

			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton
			// Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
					&& mouseY < yBotonInstrucciones + 107) {
				image(pantalla[8], xBotonInstrucciones, yBotonInstrucciones);
			}

			// Cuando se le de clic en Boton Instrucciones pasar a la pantalla Escenario Nivel (i)
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
				&& mouseY < yBotonInstrucciones + 107) {
				estado = 3;}
			break;

		case 3:
			// ESCENARIO NIVEL 1
			// Imagen Escenario Nivel 1
			imageMode(CENTER);
			image(pantalla[9], 600, 350);
			imageMode(CORNER);

			// BOTON ATRAS
			// Imagen Boton Atras
			image(pantalla[10], xBotonNuevaPartida, yBotonNuevaPartida);

			// Si esta el mouse encima del Boton Atras mostrar imagen Boton Atras Oprimido
			if (mouseX > xBotonNuevaPartida && mouseX < xBotonNuevaPartida + 58 && mouseY > yBotonNuevaPartida
				&& mouseY < yBotonNuevaPartida + 71) {
				image(pantalla[18], xBotonNuevaPartida, yBotonNuevaPartida);
			}

			// Cuando se le de clic en Boton Nueva Partida pasar a la pantalla de Inicio
			if (mouseX > xBotonNuevaPartida && mouseX < xBotonNuevaPartida + 58 && mouseY > yBotonNuevaPartida
				&& mouseY < yBotonNuevaPartida + 71) {
				estado = 0;
			}

			temporizador();

			mapa.pintar(this, muro1, muro2, extintor, puertaCerrada, puertaAbierta);
			personaje.pintar(this, personajePrincipal, herramientas[nivelActual*2]);
			System.out.println("asasd");
			// For para pintar la Herramienta: herramienta
			for (int i = 0; i < listaHerramienta.size(); i++) {
				listaHerramienta.get(i).pintar(this, herramienta);
			}

			// For para pintar y mover el Enemigo: Fuego
			for (int i = 0; i < listaEnemigos.size(); i++) {
				Fuego enemigoActual = listaEnemigos.get(i);
				enemigoActual.pintar(this, fuego);
				enemigoActual.moverVertical(fuego);}
			break;

		case 4:
			// GAME OVER - PERDIO
			// Imagen Game Over
			imageMode(CENTER);
			image(pantalla[17], 600, 350);
			imageMode(CORNER);

			// BOTON INSTRUCCIONES NIVEL 1
			// Imagen Boton Instrucciones Nivel 1
			image(pantalla[4], xBotonInstrucciones, yBotonInstrucciones);

			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton
			// Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
					&& mouseY < yBotonInstrucciones + 107) {
				image(pantalla[5], xBotonInstrucciones, yBotonInstrucciones);
			}

			// Cuando se le de clic en Boton Siguiente pasar a la pantalla de Inicio y 
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
				&& mouseY < yBotonInstrucciones + 107) {
				estado = 0;
				setup();
			}

			break;
			
		case 5:
			// GANASTE
			// Imagen Ganaste
			imageMode(CENTER);
			image(pantalla[20], 600, 350);
			imageMode(CORNER);

			// BOTON INSTRUCCIONES NIVEL 1
			// Imagen Boton Instrucciones Nivel 1
			image(pantalla[21], xBotonInstrucciones, yBotonInstrucciones);

			// Si esta el mouse encima del Boton Instrucciones mostrar imagen Boton
			// Instrucciones Oprimido
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
					&& mouseY < yBotonInstrucciones + 107) {
				image(pantalla[22], xBotonInstrucciones, yBotonInstrucciones);
			}
			
			// Cuando se le de clic en Boton Siguiente pasar a la pantalla de Inicio
			if (mouseX > xBotonInstrucciones && mouseX < xBotonInstrucciones + 106 && mouseY > yBotonInstrucciones
				&& mouseY < yBotonInstrucciones + 107) {
				if (nivelActual == 4) {
					setup();
				}else {
					nivelActual ++;
					estado = 2;
					puzzleN1 = new PuzzleN1(this, nivelActual*2+6);
				}
			}
			break;
			
		case 7:
			// SELECCIONAR PERSONAJE
			// Imagen Seleccion Personaje
			imageMode(CENTER);
			image(pantalla[23], 600, 350);
			imageMode(CORNER);

			// BOTON INSTRUCCIONES NIVEL 1
			// Imagen Boton Instrucciones Nivel 1
			image(pantalla[24], xBotonInstrucciones, yBotonInstrucciones);
			
			if (mouseX > xPM && mouseX < xPM + 255 && mouseY > yPM
				&& mouseY < yBotonInstrucciones + 252) {
				image(personajeSeleccionado[0], xPM, yPM);
				personajePrincipal = personajeSeleccionado[2];
				estado = 2;
			}
				
			if (mouseX > xPH && mouseX < xPH + 256 && mouseY > yPH
				&& mouseY < yPH + 238) {
				image(personajeSeleccionado[1], xPH, yPH);
				personajePrincipal = personajeSeleccionado[3];
				estado = 2;
			}
			break;

		}
		
	}
	@Override
	public void mouseDragged(){
		puzzleN1.mouseMover(mouseX,mouseY);
	}
	@Override
	public void mouseReleased() {
		puzzleN1.mouseConfirm();
	}
}

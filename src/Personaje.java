import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Personaje {

// PImage Personaje: Mujer
	Principal refPrincipal;
	PImage personajePrincipal;
	Personaje myPersonajeM;
	
// PImage Herramienta: Extintor
	PImage extintor;
	Extintor myExtintor;
	
//Referencia de las clases
	Mapa refMapa;
	Herramienta refExtintorInventario;
	
	double tiempoInicial;
	
	int x, y, col, fil, vidas;
	
	public Personaje(int fil, int col, Mapa refMapa) {
		this.fil = fil;
		this.col = col;
		this.vidas = 1;
		this.x =34+(col*67);
		this.y =45+(fil*67);
		this.refMapa = refMapa;
		tiempoInicial = 0;
	}
	
	public void pintar(PApplet app, PImage personajePrincipal, PImage extintor) {
		app.imageMode(PConstants.CENTER);
		app.image(personajePrincipal, x, y);
		System.out.println("bjjmh");
		if (refExtintorInventario != null) {
			refExtintorInventario.pintar(app, extintor, this);
			tiempo();
		}
		app.imageMode(PConstants.CORNER);

	}
	
	public boolean haveExtintor()	{
		return refExtintorInventario!=null;
	}
	
	public void mover(String dir) {
		int valorDestino = -1;
		
		switch (dir) {
		case "arriba":
			valorDestino = refMapa.getTipoMapa(fil-1, col);
			if(valorDestino == 0|| valorDestino ==4) {
				fil = fil-1;
				
				this.x =34+(col*67);
				this.y =45+(fil*67);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
					tiempoInicial = System.currentTimeMillis();
				}
			}
			break;
		case "abajo":
			valorDestino = refMapa.getTipoMapa(fil+1, col);
			if(valorDestino == 0 || valorDestino ==4) {
				fil = fil+1;
				
				this.x =34+(col*67);
				this.y =45+(fil*67);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
					tiempoInicial = System.currentTimeMillis();
				}
			}
			
			break;
		case "derecha":
			valorDestino = refMapa.getTipoMapa(fil, col+1);
			if(valorDestino == 0|| valorDestino ==4) {
				col = col+1;
				
				this.x =34+(col*67);
				this.y =45+(fil*67);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
					tiempoInicial = System.currentTimeMillis();
				}
			}
			
			break;
		case "izquierda":
			valorDestino = refMapa.getTipoMapa(fil, col-1);
			if(valorDestino == 0 || valorDestino ==4) {
				col = col-1;
				
				this.x =34+(col*67);
				this.y =45+(fil*67);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
					tiempoInicial = System.currentTimeMillis();
				}
			}
			
			break;
		}

	}
	
	//temporizador
	public void tiempo() {
		double tiempoActual = System.currentTimeMillis();
		if(tiempoActual-tiempoInicial > 15000) {
			refExtintorInventario = null;
		}
	}
	
	public void darVida () {
		if (vidas < 3) {
			vidas ++;
		}
	}
	
	public void quitarVida (int vida) {
		vidas -= vida;
	}
	
	public int getVidas () {
		return vidas;
	}
	
	public void quitarExtintor () {
		refExtintorInventario = null;
	}
	
//GET ----
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}
	
	public int getWidht() {
		return personajePrincipal.width;
	}
	
	public int getHeight() {
		return personajePrincipal.height;
	}
	
	
	
}

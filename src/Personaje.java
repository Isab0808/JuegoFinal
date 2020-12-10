import processing.core.PApplet;
import processing.core.PImage;

public class Personaje {

// PImage Personaje: Mujer
	Principal refPrincipal;
	PImage personajeM;
	Personaje myPersonajeM;
	
// PImage Herramienta: Extintor
	PImage extintor;
	Extintor myExtintor;
	
//Referencia de las clases
	Mapa refMapa;
	Extintor refExtintorInventario;
	
	double tiempoInicial;
	
	int x, y, col, fil, vidas;
	
	public Personaje(int fil, int col, Mapa refMapa) {
		this.fil = fil;
		this.col = col;
		this.vidas = 100;
		this.x =16+(col*112);
		this.y =20+(fil*118);
		this.refMapa = refMapa;
		tiempoInicial = 0;
	}
	
	public void pintar(PApplet app, PImage personajeM, PImage extintor) {
		app.image(personajeM, x, y);
		if (refExtintorInventario != null) {
			refExtintorInventario.pintar(app, extintor, this);
			tiempo();
		}

	}
	
	public boolean haveExtintor()	{
		return refExtintorInventario!=null;
	}
	
	public void mover(String dir) {
		int valorDestino = -1;
		
		switch (dir) {
		case "arriba":
			valorDestino = refMapa.getTipoMapa(fil-1, col);
			if(valorDestino == 0) {
				fil = fil-1;
				
				this.x =16+(col*112);
				this.y =20+(fil*118);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
					tiempoInicial = System.currentTimeMillis();
				}
			}
			break;
		case "abajo":
			valorDestino = refMapa.getTipoMapa(fil+1, col);
			if(valorDestino == 0) {
				fil = fil+1;
				
				this.x =16+(col*112);
				this.y =20+(fil*118);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
					tiempoInicial = System.currentTimeMillis();
				}
			}
			
			break;
		case "derecha":
			valorDestino = refMapa.getTipoMapa(fil, col+1);
			if(valorDestino == 0) {
				col = col+1;
				
				this.x =16+(col*112);
				this.y =20+(fil*118);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
					tiempoInicial = System.currentTimeMillis();
				}
			}
			
			break;
		case "izquierda":
			valorDestino = refMapa.getTipoMapa(fil, col-1);
			if(valorDestino == 0) {
				col = col-1;
				
				this.x =16+(col*112);
				this.y =20+(fil*118);
				
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
	
//GET ----
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}
	
	public int getWidht() {
		return personajeM.width;
	}
	
	public int getHeight() {
		return personajeM.height;
	}
	
	
	
}

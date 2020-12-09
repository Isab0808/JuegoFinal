import processing.core.PApplet;
import processing.core.PConstants;
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
	
	int x, y, col, fil;
	
	public Personaje(int fil, int col, Mapa refMapa) {
		this.fil = fil;
		this.col = col;
		this.x =34+(col*67);
		this.y =45+(fil*67);
		this.refMapa = refMapa;
	}
	
	public void pintar(PApplet app, PImage personajeM, PImage extintor) {
		app.imageMode(PConstants.CENTER);
		app.image(personajeM, x, y);
		if (refExtintorInventario != null) {
			refExtintorInventario.pintar(app, extintor, this);
		}
		app.imageMode(PConstants.CORNER);

	}
	
	public void mover(String dir) {
		int valorDestino = -1;
		
		switch (dir) {
		case "arriba":
			valorDestino = refMapa.getTipoMapa(fil-1, col);
			if(valorDestino == 0) {
				fil = fil-1;
				
				this.x =34+(col*67);
				this.y =45+(fil*67);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
				}
			}
			break;
		case "abajo":
			valorDestino = refMapa.getTipoMapa(fil+1, col);
			if(valorDestino == 0) {
				fil = fil+1;
				
				this.x =34+(col*67);
				this.y =45+(fil*67);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
				}
			}
			
			break;
		case "derecha":
			valorDestino = refMapa.getTipoMapa(fil, col+1);
			if(valorDestino == 0) {
				col = col+1;
				
				this.x =34+(col*67);
				this.y =45+(fil*67);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
				}
			}
			
			break;
		case "izquierda":
			valorDestino = refMapa.getTipoMapa(fil, col-1);
			if(valorDestino == 0) {
				col = col-1;
				
				this.x =34+(col*67);
				this.y =45+(fil*67);
				
				if(refExtintorInventario == null && refMapa.validarExtintor(x,y)) {
					refExtintorInventario = refMapa.getExtintor();
				}
			}
			
			break;
		}

	}
	
//GET ----
	public int getX() {
		return x;}
	
	public int getY() {
		return y;}
	
}

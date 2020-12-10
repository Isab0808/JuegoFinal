import processing.core.PApplet;
import processing.core.PImage;

public class Mapa {

	private int [][] mapa;
	private Extintor extintorH;
	
// PImage Escenario: Muro1
	Principal refPrincipal;
	PImage muro1;
	Mapa myMuro1;
	
// PImage Escenario: Muro2
	PImage muro2;
	Mapa myMuro2;
	
// PImage Herramienta: Extintor
	PImage extintor;
	Extintor myExtintor;
	
	PImage manguera;
	Manguera myManguera;
	
	public Mapa() {
		mapa = new int [6][9];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				mapa [i][j] = 0;
			}
		}
		mapa [1][1] = 1;
		mapa [1][2] = 1;
		mapa [1][3] = 1;
		mapa [1][4] = 1;
		mapa [1][5] = 1;
		mapa [2][1] = 1;
		mapa [3][1] = 1;
		mapa [4][1] = 1;
		mapa [2][2] = 2;
		mapa [3][5] = 1;
		mapa [3][6] = 1;
		mapa [3][7] = 1;
		mapa [5][3] = 1;
		mapa [5][4] = 1;
		mapa [5][5] = 1;
		mapa [5][6] = 1;
		mapa [5][7] = 1;
		mapa [4][6] = 2;
		mapa [0][7] = 2;
		mapa [0][8] = 2;
		mapa [2][7] = 2;
		
		extintorH = new Extintor(5, 8, extintor);
	}
	
	public void pintar (PApplet app, PImage muro1, PImage muro2, PImage extintor) {
		int x = 0;
		int y = 0;
		
	//For para crear el escenario con una Matriz
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				switch (mapa [i][j]) {
				case 0:
					app.noStroke();
					app.fill(255, 238, 176);
					app.rect(x, y, 112, 118);
					break;
				case 1:
					app.image(muro1, x, y);
					break;
				case 2:
					app.image(muro2, x, y);
					break;
				}
				x+=112;
				if(x>=1006) {
					x=0;
					y+=118;}
			}
		}
		
		if (extintorH != null) {
			extintorH.pintar(app, extintor);
		}
	}
	public int getTipoMapa(int fil, int col) {
		if (col >=9 || fil>=6 || col< 0 || fil< 0) {
			return 1;
		}else {
		return mapa[fil][col];}
	}
	public boolean validarExtintor(int px, int py) {
		if(extintorH!=null) {
			float dx = (extintorH.getX()-px)*(extintorH.getX()-px);
			float dy = (extintorH.getY()-py)*(extintorH.getY()-py);
			
			double resultado = Math.sqrt(dx + dy);
			if (resultado < 37) {
				return true;
			}
		}
		return false;
	}
	
	public Extintor getExtintor() {
		if(extintorH != null) {
		Extintor tempExtintor = extintorH;
		extintorH = null;
		return tempExtintor;
	}
		return null;
}

}

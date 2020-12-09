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
	
	public Mapa() {
		mapa = new int [10][15];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				mapa [i][j] = 0;
			}
		}
		mapa [0][0] = 2;
		mapa [1][0] = 2;
		mapa [2][0] = 2;
		mapa [3][0] = 2;
		mapa [4][0] = 1;
		mapa [5][0] = 1;
		mapa [6][0] = 1;
		mapa [7][0] = 2;
		mapa [8][0] = 2;
		mapa [9][0] = 2;
		
		mapa [0][1] = 1;
		mapa [1][1] = 2;
		mapa [4][1] = 1;
		mapa [5][1] = 1;
		mapa [6][1] = 2;
		mapa [7][1] = 1;
		mapa [8][1] = 1;
		
		mapa [0][2] = 1;
		mapa [8][2] = 2;
		
		mapa [0][3] = 2;
		mapa [2][3] = 1;
		mapa [8][3] = 1;
		
		mapa [0][4] = 2;
		mapa [2][4] = 1;
		mapa [8][4] = 1;
		
		mapa [0][5] = 1;
		mapa [2][5] = 1;
		mapa [4][5] = 1;
		mapa [5][5] = 2;
		mapa [7][5] = 1;
		mapa [8][5] = 2;
		
		mapa [0][6] = 1;
		mapa [2][6] = 1;
		mapa [4][6] = 1;
		mapa [7][6] = 1;
		mapa [8][6] = 1;
		
		mapa [0][7] = 1;
		mapa [4][7] = 1;
		mapa [7][7] = 1;
		mapa [8][7] = 2;
		
		mapa [0][8] = 2;
		mapa [1][8] = 1;
		mapa [3][8] = 2;
		mapa [4][8] = 1;
		mapa [5][8] = 2;
		mapa [6][8] = 2;
		mapa [7][8] = 1;
		
		mapa [4][9] = 2;
		mapa [5][9] = 1;
		mapa [7][9] = 2;
		mapa [9][9] = 1;
		mapa [9][10] = 2;
		mapa [9][11] = 1;
		
		mapa [0][10] = 1;
		mapa [4][10] = 1;
		mapa [7][10] = 2;
		
		mapa [0][11] = 2;
		mapa [4][11] = 1;
		
		mapa [0][12] = 2;
		mapa [4][12] = 2;
		mapa [5][12] = 1;
		mapa [6][12] = 1;
		mapa [7][12] = 2;
		
		mapa [0][13] = 1;
		mapa [6][13] = 2;
		mapa [7][13] = 2;
		
		mapa [0][14] = 1;
		
		extintorH = new Extintor(9, 14, extintor);
	}
	public void pintar (PApplet app, PImage muro1, PImage muro2, PImage extintor) {
		int x = 1;
		int y = 13;
		
	//For para crear el escenario con una Matriz
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				switch (mapa [i][j]) {
				case 0:
					app.noStroke();
					app.fill(255, 238, 176);
					app.rect(x, y, 67, 67);
					break;
				case 1:
					app.image(muro1, x, y);
					break;
				case 2:
					app.image(muro2, x, y);
					break;
				}
				x+=67;
				if(x>=1000) {
					x=1;
					y+=67;}
			}
		}
		
		if (extintorH != null) {
			extintorH.pintar(app, extintor);
		}
	}
	public int getTipoMapa(int fil, int col) {
		if (col >=15 || fil>=10 || col< 0 || fil< 0) {
			return 1;
		}else {
		return mapa[fil][col];}
	}
	public boolean validarExtintor(int px, int py) {
		float dx = (extintorH.getX()-px)*(extintorH.getX()-px);
		float dy = (extintorH.getY()-py)*(extintorH.getY()-py);
		
		double resultado = Math.sqrt(dx + dy);
		if (resultado < 37) {
			return true;
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

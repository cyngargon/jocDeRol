package personatge;

public class Tabler {
	private int[][] tauler;
	private int[] posicioPersonatge;

	public Tabler() {
		this.posicioPersonatge = new int [2]; 
	}
	
	public Tabler(int[][] tauler, int[] posicioPersonatge) {
		this();
		this.tauler = tauler;
		this.posicioPersonatge = posicioPersonatge;
	}

	public int[][] getTauler() {
		return tauler;
	}

	public void setTauler(int[][] tauler) {
		this.tauler = tauler;
	}

	public int[] getPosicioPersonatge() {
		return posicioPersonatge;
	}

	public void setPosicioPersonatge(int[] posicioPersonatge) {
		this.posicioPersonatge = posicioPersonatge;
	}
	
	
	public void iniciPrograma() {
		int [] dimensions = new int [2];
		//Condicional 5 al 20
		System.out.print("Introduce las columnas del mapa: ");
		dimensions[0] = Teclat.llegirInt();
		System.out.print("Introduce las filas del mapa: ");
		dimensions[1] = Teclat.llegirInt();
		tauler = new int[dimensions[0]][dimensions[1]];
	}
	
	public void generarTauler() {		
		iniciPrograma();
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				tauler[i][j] = (int) (Math.random()*3);
			}
		}
		/*
		for (int i = 0; i < 2; i++) {
			tauler[i][j] = (int) (Math.random()*3);
		}
		*/
	}
	
	public void mostrarTauler(){
		
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				if (i == posicioPersonatge[0] && j == posicioPersonatge[1]) {
					System.out.print("[x]");
				} else if (i == tauler.length - 1 && j == tauler[0].length - 1) {
					System.out.print("[SALIDA]");
				}
				else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
	}
	
}

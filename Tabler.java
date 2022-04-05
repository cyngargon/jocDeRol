package personatge;

public class Tabler {
	//Atributs de Tabler --> ARRAY BIDIMENSIONAL | POSICIO PERSONATGE i,j
	//0 --> RES
	//1 --> ENEMIC
	//2 --> MONEDA
	//3 --> CLAU
	private int[][] tauler;
	private int[] posicioPersonatge;
	private final int RES = 0;
	private final int ENEMIC = 1;
	private final int MONEDA = 2;
	private final int CLAU = 3;

	//Constructor buit
	public Tabler() {
		this.posicioPersonatge = new int [] {0, 0};
	}
	
	//GETTER AND SETTERS
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
	//FI GETTERS AND SETTERS
	
	//Metode al iniciar programa
	public void iniciPrograma() {
		int [] dimensions = new int [2];
		boolean checkDimension;
		//Condicional 5 al 20
		do{
			System.out.print("Introduce las columnas del mapa: ");
			dimensions[0] = Teclat.llegirInt();
			System.out.print("Introduce las filas del mapa: ");
			dimensions[1] = Teclat.llegirInt();
			if (dimensions[0] < 5 || dimensions[0] > 20 || dimensions[1] < 5 || dimensions[1] > 20) {
				System.out.println("No se pueden crear este número de filas i columnas. Intentalo de nuevo...");
				checkDimension = false;
			} else {
				System.out.println("Creando mapa...");
				checkDimension = true;
			}
		}while(checkDimension == false);
		tauler = new int[dimensions[0]][dimensions[1]];
	}
	
	public void generarTauler() {		
		int filaClau, columnaClau;
		iniciPrograma();
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				tauler[i][j] = (int) (Math.random()*3);
			}
		}
		filaClau = (int) (Math.random()*tauler.length);
		columnaClau = (int) (Math.random()*tauler[0].length);
		tauler [filaClau][columnaClau] = CLAU;
		
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

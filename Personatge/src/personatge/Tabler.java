package personatge;

public class Tabler {
    //0 --> RES
	//1 --> ENEMIC
	//2 --> MONEDA
	//3 --> CLAU
    //Attributes
	private int[][] tauler;
	private int[] posicioPersonatge;
        private final int RES = 0;
	private final int ENEMIC = 1;
	private final int MONEDA = 2;
	private final int CLAU = 3;
    
    //Constructors
	public Tabler() {
		this.posicioPersonatge = new int [] {0, 0};
	}
        
    //Getter and setter
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
	
        public int getRES() {
            return RES;
        }

        public int getENEMIC() {
            return ENEMIC;
        }

        public int getMONEDA() {
            return MONEDA;
        }

        public int getCLAU() {
            return CLAU;
        }
    //Methods
        /**
         * Pregunta files i columnes del mapa
         */
        /**
         * Comprova que les dimensions del tauler siguin correctes
         * @param dimensions
         * @return 
         */
        public boolean checkDimensions(int[] dimensions){
            boolean checkDimension;
            if (dimensions[0] < 5 || dimensions[0] > 20 || dimensions[1] < 5 || dimensions[1] > 20) {
				System.out.println("No se pueden crear este número de filas i columnas. Intentalo de nuevo...");
				checkDimension = false;
			} else {
				System.out.println("Creando mapa...");
				checkDimension = true;
			}
            return checkDimension;
        }
        
	/**
         * Genera el tauler
         */
	public void generarTauler() {		
		int filaClau, columnaClau;
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				tauler[i][j] = (int) (Math.random()*3);
			}
		}
		filaClau = (int) (Math.random()*tauler.length);
		columnaClau = (int) (Math.random()*tauler[0].length);
		tauler [filaClau][columnaClau] = CLAU;
	}
        
	/**
         * Mostra el tauler
         */
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
        
        /**
         * Mostra la posició en la que es trova el jugador
         */
        public void mostrarPosicio(){
            final int ZERO = 0, U = 1;
            System.out.println("Estas en la posición: " + posicioPersonatge[ZERO] + "," + posicioPersonatge[U]);
        }
	
}

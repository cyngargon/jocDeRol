package personatge;

public abstract class Personatge extends Tabler{
    //Attributes
	private int vides;
	private int monedes;
        private boolean clau;
	
    //Constructors
        public Personatge(){
        }
        public Personatge(int vides, int monedes, boolean clau) {
            this.vides = vides;
            this.monedes = monedes;
            this.clau = clau;
        }
        
    //Getter and setter
        public int getVides() {
            return vides;
        }

        public void setVides(int vides) {
            this.vides = vides;
        }

        public int getMonedes() {
            return monedes;
        }

        public void setMonedes(int monedes) {
            this.monedes = monedes;
        }
        
        public boolean isClau() {
            return clau;
        }

        public void setClau(boolean clau) {
            this.clau = clau;
        }
        
        
    //Methods
	public abstract String missatgePosicio();
        public abstract void moure();
        public abstract void batalla();
        
	public void mostrarMenu() {
            int [] posicio = super.getPosicioPersonatge();
            int [][] tauler = super.getTauler();
            int numero = tauler[posicio[0]][posicio[1]];
            char respuesta;
            switch (numero){
                case 0:
                    System.out.println("M: Moverse" + 
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    Character.toUpperCase(respuesta);
                    //Cridar funció
                    break;
                case 1:
                    System.out.println("B: Batalla" +
                                        "\nM: Moverse" +
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    Character.toUpperCase(respuesta);
                    //Cridar funcio
                    break;
                case 3: case 2:
                    System.out.println("M: Moverse" + 
                                        "\nR: Recoger" +
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    Character.toUpperCase(respuesta);
                    //Cridar funcio
                    break;
                default:
                    System.out.println("ERROR!");
            }
	}
	public String mostrarPosicio() {
		return	"W -> Arriba"
				+ "S -> Abajo"
				+ "D -> Derecha"
				+ "A -> Izquierda";
	}
	public void checkCasilla() {
		
	}
	public void checkPosicio() {
		
	}
	public void chackOpcionesMenu(int casella, char respuesta) {
            switch (respuesta){
                case 'B':
                    if(casella == 2||casella == 3||casella == 0){
                        
                    }
            }
	}
}

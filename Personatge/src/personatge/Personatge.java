package personatge;
/**
 * Classe Personatge
 * @author MarcSerra, CynthiaGarcia, PolCrespo 
 */
public abstract class Personatge{
    //	Attributes
	private int vides;
	private int monedes;
	private boolean clau;
	private int [] posicio;
        
    //	Constructors
	public Personatge(){
		this.vides = 3;
		this.monedes = 5;
		this.clau = false;
		this.posicio=new int [] {0,0};
	}
	public Personatge(int vides, int monedes, boolean clau, int [] posicio) {
		this();
		this.vides = vides;
		this.monedes = monedes;
		this.clau = clau;
	}
        
    //	Getter and setter
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
        
        public int[] getPosicio() {
            return posicio;
        }

        public void setPosicio(int[] posicio) {
            this.posicio = posicio;
        }
        
    //	Methods 
	/**
	 * Mètode abstracte Batalla
	 * @return 
	 */
	public abstract int batalla();
	/**
	 * Mètode Abstracte Canvi
	 * @return 
	 */
	public abstract char canvi();
	/**
	 * Mètode Moure Personatge
	 * @param direccio
	 * @param correcte 
	 */
	public void moure(char direccio, boolean correcte) {
		direccio = Character.toUpperCase(direccio);
		switch (direccio){
			case 'W':
				if(correcte==true){
					getPosicio()[0]--;
					setPosicio(posicio);
				}
				break;
			case 'S':
				if(correcte==true){
					getPosicio()[0]++;
					setPosicio(posicio);
				}
				break;
			case 'A':
				if(correcte==true){
					getPosicio()[1]--;
					setPosicio(posicio);
				}
				break;
			case 'D':
				if(correcte==true){
					getPosicio()[1]++;
					setPosicio(posicio);
				}
				break;
		}
	}
	/**
	 * Mètode Mostrar Direccio
	 */
	public void mostrarDireccio(){
		System.out.println("Et pots moure:");
		System.out.println("W -> Amunt"
			  + "\nS -> Avall"
			  + "\nD -> Dreta"
			  + "\nA -> Esquerra");
	}
	/**
	 * Mètode Recollir
	 * @param casella 
	 */
	public void recollir(int casella){
		switch (casella){
			case 3:
				monedes++;
				System.out.println("S'ha recollit una moneda.");
				break;
			case 4:
				clau = true;
				System.out.println("S'ha recollit la clau. Ara tens la clau.");
				break;
			default:
				System.out.println("ERROR");
		}
	}
	/**
	 * Mètode Sortir Programa
	 * @return 
	 */
	public int salir(){
	   char respuesta;
	   int exit;
	   do{
		System.out.print("Segur que vols sortir del joc? Resposta (S/N): ");
		respuesta = Teclat.llegirChar();
		exit = confirmacion(respuesta);
	   }while(exit == -1);
	   return exit;
	}
	/**
	 * Mètode Confirmar Sortir Programa
	 * @param respuesta
	 * @return 
	 */
	public int confirmacion(char respuesta){
	   int exit;
	   respuesta = Character.toUpperCase(respuesta);
	   switch(respuesta){
		   case 'S':
			   exit = 1;
			   break;
		   case 'N':
			   exit = 0;
			   break;
		   default:
			   System.out.println("ERROR! Introdueix una resposta vàlida");
			   exit = -1;
	   }
	   return exit;
   }
	/**
	 * Mètode Generacio Aleatoria d'Enemics
	 * @return 
	 */
	public int RandomizEnemic(){
		int enemic;
		int randomizer = (int)(Math.random() * 100);
		if(randomizer < 33){
			enemic = 1; //Enemic Guerrer
		}
		else if (randomizer < 66){
			enemic = 2; //Enemic Sacerdot
		}
		else{
			enemic = 3; //Enemic Mag
		}
		return enemic;
	}
	/**
	 * Mètode Guanyar Batalla
	 */
	public void GuanyoBatalla(){
		monedes++;
	}
	/**
	 * Mètode Perdre Batalla
	 */
	public void PerdoBatalla(){
			if(getMonedes() < 1){
					System.out.println("Monedes actuals: " + getMonedes());
					System.out.println("Perds una vida");
					System.out.println("Vides actuals: " + getVides());
					this.vides--;
			}
			else{
					System.out.println("Monedes actuals: " + getMonedes());
					System.out.println("Perds una moneda");
					this.monedes--;
			}
	}        
}

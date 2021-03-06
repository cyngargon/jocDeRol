package jocderol;

import java.util.Optional;
/**
 * Classe Teclat
 * @author MarcSerra, CynthiaGarcia, PolCrespo 
 */
public class Tabler{
    //0 --> SORTIDA
	//1 --> RES
	//2 --> ENEMIC
	//3 --> MONEDA
    //4 --> CLAU
	
    //	Attributes
	private int[][] tauler;
	private Personatge personatge;
        
    //	Constructors
	public Tabler() {
	}
    
    //	Getter and setter
	public int[][] getTauler() {
		return tauler;
	}
	public void setTauler(int[][] tauler) {
		this.tauler = tauler;
	}
	public Personatge getPersonatge() {
		return personatge;
	}
	public void setPersonatge(Personatge personatge) {
		this.personatge = personatge;
	}
	
    //	Codis per colors
	public static final String RESET = "\u001B[0m";
	public static final String ROJO = "\u001B[31m";
	public static final String AZUL = "\u001B[34m";
	public static final String AMARILLO = "\u001B[33m";
	
	
    //	Mètodes
	/**
	 * Mètode Generar Personatge
	 * @param tipus 
	 */
	public void generarPersonatge(Optional<Integer> tipus){
	   Personatge personatge1 = null;
	   int tp;

	   if(!tipus.isPresent()){
		   tp = (int) (Math.random()*3);
	   }else{
		   tp = tipus.get();
	   }

	   switch(tp){
		   case 0:
			   personatge1 = new Guerrer();
			   break;
		   case 1:
			   personatge1 = new Sacerdot();
			   break;
		   case 2:
			   personatge1 = new Mag();
			   break;
	   }
	   this.personatge = personatge1;
	}
	/**
	 * Mètode Dimensions Tauler Segons l'Usuari
	 */
	public void dimensioTauler() {
		int [] dimensions = new int [2];
		int [][] tauler1;
		boolean checkDimension;
		do{
			System.out.print("Introdueix les columnas del mapa (5-20): ");
			dimensions[0] = Teclat.llegirInt();
			System.out.print("Introdueix las files del mapa (5-20): ");
			dimensions[1] = Teclat.llegirInt();
			checkDimension = checkDimensions(dimensions);
		}while(checkDimension == false);
		tauler1 = new int[dimensions[0]][dimensions[1]];
		this.tauler = tauler1;
	}
	/**
	 * Mètode Comprovacio Dimensions Correcte
	 * @param dimensions
	 * @return 
	 */
	public boolean checkDimensions(int[] dimensions){
		boolean checkDimension;
		if (dimensions[0] < 5 || dimensions[0] > 20 || dimensions[1] < 5 || dimensions[1] > 20) {
			System.out.println("No es pot crear un mapa amb aquesta mida de files i columnes. Intenta-ho de nou...");
			checkDimension = false;
		} else {
			System.out.println("Creant mapa...");
			checkDimension = true;
		}
		return checkDimension;
	}
	/**
	 * Mètode Generacio Tauler
	 */
	public void generarTauler() {		
		int filaClau, columnaClau, filaSortida, columnaSortida;
		//RES, ENEMIC I MONEDA
		for (int[] tauler1 : tauler) {
			for (int j = 0; j < tauler[0].length; j++) {
				tauler1[j] = (int)(1 + (Math.random()*3));
			}
		}
		//CLAU
		filaClau = (int) (Math.random()*tauler.length);
		columnaClau = (int) (Math.random()*tauler[0].length);
		tauler [filaClau][columnaClau] = TFicha.LLAVE.ordinal();
		//SORTIDA
		filaSortida = tauler.length -1;
		columnaSortida = tauler[0].length -1;
		tauler[filaSortida][columnaSortida] = TFicha.SALIDA.ordinal();
	}
	/**
	 * Mètode Mostra Tauler
	 */
	public void mostrarTauler(){
		int [] posicioPersonatge=personatge.getPosicio();
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				if (i == posicioPersonatge[0] && j == posicioPersonatge[1]) {
					System.out.print("[" + AZUL + "x" + RESET + "]");
				} else if (i == tauler.length - 1 && j == tauler[0].length - 1) {
					System.out.print("[" + AZUL + "S" + RESET + "]");
				} else{
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
	}
	/**
	 * Mètode Mostra Tauler (PERO AMB DADES DE CADA CASELLA A DINS)
	 */
	public void mostrarTaulerDev(){
		int [] posicioPersonatge=personatge.getPosicio();
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				if (i == posicioPersonatge[0] && j == posicioPersonatge[1]) {
					System.out.print("[" + AZUL + "x" + RESET + "]");
				} else if (i == tauler.length - 1 && j == tauler[0].length - 1) {
					System.out.print("[" + AZUL + "S" + RESET + "]");
				} else if(tauler[i][j] == 2){
					System.out.print("[" + ROJO + "E" + RESET + "]");
				} else if(tauler[i][j] == 3){
					System.out.print("[" + AMARILLO + "M" + RESET + "]");
				} else if(tauler[i][j] == 4){
					System.out.print("[" + AZUL + "C" + RESET + "]");
				} else{
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
	}
	/**
	 * Mètode Mostrar Totes Dades Jugador
	 */
	public void mostrarDatos(){
		mostrarPosicio();
		//Personatge
		mostrarPersonatge();
		//Vides
		mostrarVides();
		//Monedes
		mostrarMonedes();
		//Clau
		mostrarClau();
	}
	/**
	 * Mètode Mostra Posicio Jugador
	 */
	public void mostrarPosicio(){
		final int ZERO = 0, U = 1;
		int [] posicioPersonatge = personatge.getPosicio();
		System.out.println("Estas a la posició: " + AZUL + posicioPersonatge[ZERO] + "," + posicioPersonatge[U] + RESET);
	}
	/**
	 * Mètode Mostra Personatge Que Tenim
	 */
	public void mostrarPersonatge(){
		if(personatge instanceof Guerrer){
			System.out.println("El teu personatge és un " + AZUL + "Guerrer" + RESET);
		}else if(personatge instanceof Sacerdot){
			System.out.println("El teu personatge és un " + AZUL + "Sacerdot" + RESET);
		}else if(personatge instanceof Mag){
			System.out.println("El teu personatge és un " + AZUL + "Mag" + RESET);
		}
	}
	/**
	 * Mètode Mostra Vides
	 */
	public void mostrarVides(){
		System.out.println("Tens " + ROJO + getPersonatge().getVides() + " vides." + RESET);
	}
	/**
	 * Mètode Mostra Monedes
	 */
	public void mostrarMonedes(){
		System.out.println("Tens " + AMARILLO + getPersonatge().getMonedes() + " monedes." + RESET);
	}
	/**
	 * Mètode Mostra Clau
	 */
	public void mostrarClau(){
		if(getPersonatge().isClau()==true){
			System.out.println("Tens la clau");
		}else{
			System.out.println("No tens la clau");
		}
	}
	/**
	 * Mètode Menú
	 * @return 
	 */
	public int menu(){
		char respuesta;
		int exit = -1;
			int fixa = getTauler()[getPersonatge().getPosicio()[0]][getPersonatge().getPosicio()[1]];
			switch (fixa){
				case 1: //Res
					System.out.println("La sala està buida. Escull la teva acció: ");
					System.out.print("M: Moure's" + 
										"\nC: Canviar personatge" +
										"\nS: Sortir del joc" + 
										"\nSeleciona: ");
					respuesta = Teclat.llegirChar();
					respuesta = Character.toUpperCase(respuesta);
					System.out.println("");
					//Comprovem que la resposta sigui valida
					exit = checkOpcionesMenu(fixa, respuesta);
					break;
				case 2: //Enemic
					System.out.println("Has trobat un enemic! Escull la teva acció: ");
					System.out.print("B: Batalla" +
										"\nM: Moure's" +
										"\nC: Canviar personatge" +
										"\nS: Sortir del joc" + 
										"\nSeleciona: ");
					respuesta = Teclat.llegirChar();
					respuesta = Character.toUpperCase(respuesta);
					System.out.println("");
					//Comprovem que la resposta sigui valida
					exit = checkOpcionesMenu(fixa, respuesta);
					break;
				case 3: //MONEDA
					System.out.println("Has trobat una moneda! Escull la teva acció: ");
					System.out.print("M: Moure's" + 
										"\nR: Recollir" +
										"\nC: Canviar personatge" +
										"\nS: Sortir del joc" + 
										"\nSeleciona: ");
					respuesta = Teclat.llegirChar();
					respuesta = Character.toUpperCase(respuesta);
					System.out.println("");
					//Comprovem que la resposta sigui valida
					exit = checkOpcionesMenu(fixa, respuesta);
					break;
				case 4: //CLAU
					System.out.println("Has trobat una clau! Escull la teva acció: ");
					System.out.print("M: Moure's" + 
										"\nR: Recollir" +
										"\nC: Canviar personatge" +
										"\nS: Sortir del joc" + 
										"\nSeleciona: ");
					respuesta = Character.toUpperCase(Teclat.llegirChar());
					System.out.println("");
					//Comprovem que la resposta sigui valida
					exit = checkOpcionesMenu(fixa, respuesta);
					break;
				default:
					System.out.println("ERROR!");
			}
		return exit;
	}
    /**
	 * Mètode Comprova les Opcions del Menú
	 * @param casella
	 * @param respuesta
	 * @return 
	 */    
	public int checkOpcionesMenu(int casella, char respuesta){
		int exit;

		switch (respuesta){
			case 'B':
				if(!(casella == TFicha.LLAVE.ordinal()||casella == TFicha.MONEDA.ordinal()||casella == TFicha.NADA.ordinal() || casella==TFicha.SALIDA.ordinal())){
					if(getPersonatge().batalla() == 2){
						tauler[this.getPersonatge().getPosicio()[0]][this.getPersonatge().getPosicio()[1]] = TFicha.NADA.ordinal();
					}
				}else{
					System.out.println("Opció incorrecte.");
				}
				exit=0;
				break;
			case 'R':
				if(casella == TFicha.ENEMIGO.ordinal() || casella == TFicha.NADA.ordinal() || casella == TFicha.SALIDA.ordinal()){
					System.out.println("Opció incorrecte.");
				}else{
					recollir(casella);
				}
				exit = 0;
				break;
			case 'M':
				missatgeMoure(1);
				exit = 0;
				break;
			case 'C': 
				canviarPersonatge();
				exit = 0;
				break;
			case 'S':
				exit = getPersonatge().salir();
				break;
			case 'K':
				mostrarTaulerDev();
				exit = 0;
				break;
			default:
				System.out.println("Opció incorrecte.");
				exit = 0;
		}
		return exit;

	}
	/**
	* Mètode Recollir Objecte
	* @param casella 
	*/
	public void recollir(int casella){
		this.getPersonatge().recollir(casella);
		tauler[getPersonatge().getPosicio()[0]][getPersonatge().getPosicio()[1]] = TFicha.NADA.ordinal();
	}
	/**
	 * Mètode Comprova Moviment Jugador
	 * @param direccio
	 * @return 
	 */
	public boolean checkMoviment(char direccio){
		int [] posicio = this.getPersonatge().getPosicio();
		int maxLengthVertical = tauler.length - 1;
		int maxLengthHoritzontal = tauler[0].length - 1;
		boolean correcte = true;
		switch(direccio){
			case 'S':
				if(posicio[0] >= 0 && posicio[0] < maxLengthVertical){
					correcte=true;
				}else{
					correcte=false;
				}
				break;
			case 'W':
				if(posicio[0] > 0 && posicio[0] <= maxLengthVertical){
					correcte=true;
				}else{
					correcte=false;
				}
				break;
			case 'D':
				if(posicio[1] >= 0 && posicio[1] < maxLengthHoritzontal){
					correcte=true;
				}else{
					correcte=false;
				}
				break;
			case 'A':
				if(posicio[1] > 0 && posicio[1] <= maxLengthHoritzontal){
					correcte=true;
				}else{
					correcte=false;
				}
				break;
			default:
				System.out.println("Error del programa.");
		}
		if(correcte==false){
			System.out.println("ERROR! No et pots moure cap allà.");
		}
		return correcte;
	}
	/**
	 * Mètode Missatge Moviment
	 * @param moviments 
	 */
	public void missatgeMoure(int moviments) {
	boolean errorDireccio, correcte;
	   char [] direccio = new char[moviments];
	   int i=0;
	   int guanyar = sortida();
	   if(guanyar==-1||guanyar==0){
		do{
			this.getPersonatge().mostrarDireccio();
			System.out.print("Selecciona: ");
			direccio[i] = Character.toUpperCase(Teclat.llegirChar());
			errorDireccio = checkDireccio(direccio[i]);
			correcte = checkMoviment(direccio[i]);
			this.getPersonatge().moure(direccio[i], correcte);
			i++;
		}while(errorDireccio==true && i<direccio.length);
	   }
	}
	/**
	 * Mètode Comprovar Direcció Jugador
	 * @param respuesta
	 * @return 
	 */
	public boolean checkDireccio(char respuesta){
		respuesta = Character.toUpperCase(respuesta);
		boolean error;
		switch (respuesta){
			case 'W': case 'S': case 'A': case 'D':
				error = false;
				break;
			default:
				error = true;
				System.out.println("Opció incorrecte.");
		}
		return error;
	}
    /**
	 * Mètode CanviPersonatge
	 */   
	public void canviarPersonatge(){
		Personatge personatgeC = null;
		int canvi = 1, monedes = getPersonatge().getMonedes(), vides = getPersonatge().getVides();
		boolean clau = getPersonatge().isClau();
		int [] posicio = new int [] {getPersonatge().getPosicio()[0], getPersonatge().getPosicio()[1]};
		if(personatge instanceof Guerrer){
			switch(this.getPersonatge().canvi()){
				case 'S':
					personatgeC = new Sacerdot();
					break;
				case 'M':
					personatgeC = new Mag();
					break;
				default:
					System.out.println("Opció incorrecte, no es canvia el personatge.");
					canvi = -1;
					break;
			}
		}else if(personatge instanceof Sacerdot){
			switch(this.getPersonatge().canvi()){
				case 'G':
					personatgeC = new Guerrer();
					break;
				case 'M':
					personatgeC = new Mag();
					break;
				default:
					System.out.println("Opció incorrecte, no es canvia el personatge");
					canvi = -1;
					break;
			}
		}else if(personatge instanceof Mag){
			switch(this.getPersonatge().canvi()){
				case 'G':
					personatgeC = new Guerrer();
					break;
				case 'S':
					personatgeC = new Sacerdot();
					break;
				default:
					System.out.println("Opció incorrecte, no es canvia el personatge");
					canvi = -1;
					break;
			}
		}

		if(canvi > 0){
			if(getPersonatge().getMonedes()>0){
				this.personatge = personatgeC;
				editaItemsCanvi(monedes, vides, clau, posicio[0], posicio[1]);
			}
			else{
				System.out.println("No tens prou monedes, no es canviarà el personatge");
			}
		}
	}
	/**
	 * Mètode Editar Items Canviar Personatge
	 * @param monedes
	 * @param vides
	 * @param clau
	 * @param posicio1
	 * @param posicio2 
	 */
	public void editaItemsCanvi(int monedes, int vides, boolean clau, int posicio1, int posicio2){
		int [] posicio = new int[]{posicio1, posicio2}; 
		getPersonatge().setMonedes(monedes - 1);
		getPersonatge().setVides(vides);
		getPersonatge().setClau(clau);
		getPersonatge().setPosicio(posicio);
	}
	/**
	 * Mètode Sortida
	 * @return 
	 */
	public int sortida(){
	   int guanyar=-1;
	   final int MONEDES_FINAL = 10; //Monedes amb les que pots acabar el joc
	   if(tauler[getPersonatge().getPosicio()[0]][getPersonatge().getPosicio()[1]] == TFicha.SALIDA.ordinal()){
		   System.out.println("Estas a la sortida.");
		   if(getPersonatge().getMonedes()>=MONEDES_FINAL && getPersonatge().isClau()==true){
			   System.out.println("Has guanyat!");
			   guanyar = 1;
		   }else{
			   if(getPersonatge().getMonedes()<MONEDES_FINAL && getPersonatge().isClau()==false){
				   System.out.println("No pots acabar el joc encara. Et falten monedes");
			   }else if(getPersonatge().getMonedes()<MONEDES_FINAL){
				   System.out.println("No pots acabar el joc encara. Et falten monedes");
			   }else if(getPersonatge().isClau()==false){
				   System.out.println("No pots acabar el joc encara. Has de trovar la clau");
			   }
			   System.out.println("Tornes a l'inici. Torna-ho a intentar quan puguis pagar el preu!");
			   guanyar = 0;
			   getPersonatge().getPosicio()[0]=0;
			   getPersonatge().getPosicio()[1]=0;
			   this.getPersonatge().setPosicio(getPersonatge().getPosicio());
		   }
	   }
	   return guanyar;
	}
}
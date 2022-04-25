package personatge;

public abstract class Personatge extends Tabler{
    //Attributes
	private int vides; 
	private int monedes;
    private boolean clau;
	//1 --> GUERRER
	//2 --> SACERDOT
	//3 --> MAG
	private final int GUERRER = 1;
	private final int SACERDOT = 2;
	private final int MAG = 3;
	
    //Constructors
        public Personatge(){
			this.vides = 3;
			this.monedes = 0;
			this.clau = false;
        }
        public Personatge(int vides, int monedes, boolean clau) {
            this();
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
    
	public void programa(){
		int exit;
		System.out.println("---------------INICI PROGRAMA---------------");
		dimensioTauler();
		generarTauler();
		generarPersonatge();
		do{
			mostrarTauler();
			super.mostrarPosicio();
			exit = mostrarMenu();
		}while(exit==0);
    }	
	
	/**
	 * Demana les dimensions del mapa i fa un array amb aquestes dimensions
	 */
	public void dimensioTauler() {
		int [] dimensions = new int [2];
		boolean checkDimension;
        int [][] tauler;
		do{
			System.out.print("Introduce las columnas del mapa: ");
			dimensions[0] = Teclat.llegirInt();
			System.out.print("Introduce las filas del mapa: ");
			dimensions[1] = Teclat.llegirInt();
            checkDimension = checkDimensions(dimensions);
		}while(checkDimension == false);
		tauler = new int[dimensions[0]][dimensions[1]];
        super.setTauler(tauler);   
	}
    /**
	 * Genera un personatge
	 * @return 
	 */
	public int generarPersonatge() {
		int personatge;
		personatge = (int) (Math.random()*(3) + 1);
		return personatge;
	}
	/**
    * Mostra el menú depenent de la casella en la que es trovi el personatge
	* @return 
    */
	public int mostrarMenu() {
            int [] posicio = super.getPosicioPersonatge();
            int [][] tauler = super.getTauler();
            int numero = tauler[posicio[0]][posicio[1]];
            char respuesta;
            int exit = -1;
            switch (numero){
                case 0: //Res
                    System.out.println("No hay nada en tu casilla. Elige entre estas opciones: ");
                    System.out.println("M: Moverse" + 
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    respuesta = Character.toUpperCase(respuesta);
                    //Comprovem que la resposta sigui valida
                    exit = checkOpcionesMenu(numero, respuesta);
                    break;
                case 1: //Enemic
                    System.out.println("Te has encontrado con un enemigo. Elige entre estas opciones: ");
                    System.out.println("B: Batalla" +
                                        "\nM: Moverse" +
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    respuesta = Character.toUpperCase(respuesta);
                    //Comprovem que la resposta sigui valida
                    exit = checkOpcionesMenu(numero, respuesta);
                    break;
                case 2:
                    System.out.println("Te has encontrado con una moneda. Elige entre estas opciones: ");
                    System.out.println("M: Moverse" + 
                                        "\nR: Recoger" +
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    respuesta = Character.toUpperCase(respuesta);
                    //Comprovem que la resposta sigui valida
                    exit = checkOpcionesMenu(numero, respuesta);
                    break;
                case 3:
                    System.out.println("Te has encontrado con una llave. Elige entre estas opciones: ");
                    System.out.println("M: Moverse" + 
                                       "\nR: Recoger" +
                                       "\nC: Cambiar personaje" +
                                       "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    respuesta = Character.toUpperCase(respuesta);
                    //Comprovem que la resposta sigui valida
                    exit = checkOpcionesMenu(numero, respuesta);
                    break;
                default:
                    System.out.println("ERROR!");
            }
            return exit;
	}
	/**
	 * Comprovar que les respostes siguin valides
	 * @param casella
	 * @param respuesta 
	 * @return  
	 */
	public int checkOpcionesMenu(int casella, char respuesta) {
            int exit = -1;
            switch (respuesta){
                case 'B':
                    if(casella == 2||casella == 3||casella == 0){
                        System.out.println("No hay ningun enemigo.");
                    }else{
                        batalla();
                    }
				//Canvis en la condicio i paso per parametre la casella
                case 'R':
                    if(casella != 2 || casella != 3){
                        System.out.println("No hay nada que recoger");
                    }else{
                        recollir(casella);
                    }
                    break;
                case 'M':
                    missatgeMoure();
                    break;
                case 'C':   
                    cambiarPersonatge();
                    break;
                case 'S':
                    exit = salir();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
            return exit;
	}
	/**
	 * Funcio de Batalla
	 */
	public abstract void batalla();
	/**
	 * Funcio de recollir
	 * @param casella 
	 */
	public void recollir(int casella){
		int [] posicio = super.getPosicioPersonatge();
		int [][] tauler = super.getTauler();
		int res = super.getRes();
		switch (casella){
			case 2:
				monedes++;
				System.out.println("S'ha recollit una moneda. Ara en tens |" + monedes + "| monedes.");
				break;
			case 3:
				clau = true;
				System.out.println("S'ha recollit la clau. Ara tens la clau.");
				break;
			default:
				System.out.println("ERROR");
		}			
		tauler[posicio[0]][posicio[1]] = res;
	}
	/**
    * Mostra el missatge de la posicio i chequeja de que ho hagi introduit bé
    */
    public abstract void missatgeMoure();
	/**
	 * Funcio Canvi Personatge
	 */
	public void cambiarPersonatge(){
		int personatge = 1;
		int respostaPersonatge;
		boolean repetirPregunta = false;
		switch (personatge) {
			case 1:
				do {
					System.out.print("Tens el Guerrer, pots canviar a Sacerdot (2) o Mag (3): ");
					respostaPersonatge = Teclat.llegirInt();
					if (respostaPersonatge != 2 && respostaPersonatge != 3) {
						System.out.println("ERROR");
						repetirPregunta = true;
					} else if (respostaPersonatge == 2) {
						personatge = 2;
						repetirPregunta = false;
					} else if (respostaPersonatge == 3) {
						personatge = 3;
						repetirPregunta = false;
					}
				} while (repetirPregunta == true);
				break;
			case 2:
				do {
					System.out.print("Tens el Sacerdot, pots canviar a Guerrer (1) o Mag (3): ");
					respostaPersonatge = Teclat.llegirInt();
					if (respostaPersonatge != 1 && respostaPersonatge != 3) {
						System.out.println("ERROR");
						repetirPregunta = true;
					} else if (respostaPersonatge == 1) {
						personatge = 1;
						repetirPregunta = false;
					} else if (respostaPersonatge == 3) {
						personatge = 3;
						repetirPregunta = false;
					}
				} while (repetirPregunta == true);
				break;
			case 3:
				do {
					System.out.print("Tens el Mag, pots canviar a Guerrer (1) o Sacerdot (2): ");
					respostaPersonatge = Teclat.llegirInt();
					if (respostaPersonatge != 1 && respostaPersonatge != 2) {
						System.out.println("ERROR");
						repetirPregunta = true;
					} else if (respostaPersonatge == 1) {
						personatge = 1;
						repetirPregunta = false;
					} else if (respostaPersonatge == 2) {
						personatge = 2; 
						repetirPregunta = false;
					}
				} while (repetirPregunta == true);
				break;
			default:
				break;
		}
		
		System.out.println("El personatge que tens ara és el: " + personatge);//Mostrar els dos personatges que podem canviar
	}
	/**
	 * Funcio Sortir
	 * @return 
	 */
	public int salir(){
		char respuesta;
		int exit;
		do{
		 System.out.println("Seguro que quieres salir del juego? Respuesta S/N");
		 respuesta = Teclat.llegirChar();
		 exit = confirmacion(respuesta);
		}while(exit == -1);
		return exit;
    }
    /**
	 * Funcio Confirmacio
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
				System.out.println("Error.");
				exit = -1;
		}
		return exit;
	}
    
	//Methods
	public abstract String missatgePosicio();
        public void moure(char [] direccio) {
            int [] posicio;
            boolean correcte;
            posicio = super.getPosicioPersonatge();

            for (int i = 0; i < direccio.length; i++) {
                direccio[i] = Character.toUpperCase(direccio[i]);
                switch (direccio[i]){
                    case 'W': case 'S':
                        correcte = checkMoviment(direccio[i]);
                        if(correcte==true){
                            posicio[0]++;
                            super.setPosicioPersonatge(posicio);
                        }else{
                            System.out.println("Error. No te puedes mover");
                        }
                        break;
                    case 'A': case 'D':
                        correcte = checkMoviment(direccio[i]);
                        if(correcte==true){
                            posicio[1]++;
                            super.setPosicioPersonatge(posicio);
                        }else{
                            System.out.println("Error. No te puedes mover");
                        }
                        break;
                }
            }
        }
		
        
        public void mostrarDireccio(){
            System.out.println(missatgePosicio());
            System.out.println("W -> Arriba"
                  + "\nS -> Abajo"
                  + "\nD -> Derecha"
                  + "\nA -> Izquierda");
        }
        
        
        public boolean checkDireccio(char respuesta){
            respuesta = Character.toUpperCase(respuesta);
            boolean error;
            switch (respuesta){
                case 'W': case 'S': case 'A': case 'D':
                    error = false;
                    break;
                default:
                    error = true;
                    System.out.println("Opción incorrecta.");
            }
            return error;
        }
        /**
         * Comprovar que es pot moure cap a aquella direccio
         * @param direccio
         * @return 
         */
        public boolean checkMoviment(char direccio){
            //si no es choca
            //total - posicion < al length de la direccio
            int [] posicio = super.getPosicioPersonatge();
            int [][] tauler = super.getTauler();
            //FILAS W y S
            //COLUMNAS A y D
            //tauler[0].length y posicio[0] --> filas 
            //tauler.length y posicio [1] --> columnas
            int maxLengthVertical = tauler[0].length - posicio[0];
            int maxLengthHoritzontal = tauler.length - posicio[1];
            boolean correcte = true;
            switch(direccio){
                case 'S':
                    if(maxLengthVertical>0){
                        correcte=true;
                    }else{
                        correcte=false;
                    }
                    break;
                case 'W':
                    if(posicio[0]>0){
                        correcte=true;
                    }else{
                        correcte=false;
                    }
                    break;
                case 'D':
                    if(maxLengthHoritzontal>0){
                        correcte=true;
                    }else{
                        correcte=false;
                    }
                    break;
                case 'A':
                    if(posicio[1]>0){
                        correcte=true;
                    }else{
                        correcte=false;
                    }
                    break;
                default:
                    System.out.println("Error del programa.");
            }
            return correcte;
		}
}

package personatge;

public abstract class Personatge extends Tabler{
    //Attributes
	private int vides;
	private int monedes;
        private boolean clau;
	
    //Constructors
        public Personatge(){
            this.vides = 3;
            this.monedes = 5;
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
        
        
    //Methods
	public abstract String missatgePosicio();
        public void moure(char direccio, boolean correcte) {
            int [] posicio;
            posicio = super.getPosicioPersonatge();
            direccio = Character.toUpperCase(direccio);
            switch (direccio){
                case 'W':
                    if(correcte==true){
                        posicio[0]--;
                        super.setPosicioPersonatge(posicio);
                    }
                    break;
                case 'S':
                    if(correcte==true){
                        posicio[0]++;
                        super.setPosicioPersonatge(posicio);
                    }
                    break;
                case 'A':
                    if(correcte==true){
                        posicio[1]--;
                        super.setPosicioPersonatge(posicio);
                    }
                    break;
                case 'D':
                    if(correcte==true){
                        posicio[1]++;
                        super.setPosicioPersonatge(posicio);
                    }
                    break;
            }
            if(correcte==false){
                System.out.println("ERROR! No te puedes mover para alla.");
            }
        }
        public abstract void batalla();
        public void programa(){
            int exit;
            dimensioTauler();
            generarTauler();
            do{
                mostrarTauler();
                super.mostrarPosicio();
                System.out.println("Tens " + getMonedes() + " monedes.");
                exit = mostrarMenu();
            }while(exit==0);
        }
        public void dimensioTauler() {
		int [] dimensions = new int [2];
		boolean checkDimension;
                int [][] tauler;
		//Condicional 5 al 20
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
        public void mostrarDireccio(){
            System.out.println(missatgePosicio());
            System.out.println("W -> Arriba"
                  + "\nS -> Abajo"
                  + "\nD -> Derecha"
                  + "\nA -> Izquierda");
        }
        public void cambiarPersonatge(int personatge){
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
                
        public void recollir(int casella){
            int [] posicio = super.getPosicioPersonatge();
		int [][] tauler = super.getTauler();
		int res = super.getRES();
		switch (casella){
			case 2:
				monedes++;
				System.out.println("S'ha recollit una moneda.");
				break;
			case 3:
				clau = true;
				System.out.println("S'ha recollit la clau. Ara tens la clau.");
				break;
			default:
				System.out.println("ERROR");
		}			
		tauler[posicio[0]][posicio[1]] = res;
		super.setTauler(tauler);
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
         * Mostra el menú depenent de la casella en la que es trovi el personatge
         */
	public int mostrarMenu() {
            int [] posicio = super.getPosicioPersonatge();
            int [][] tauler = super.getTauler();
            int numero = tauler[posicio[0]][posicio[1]];
            char respuesta;
            int exit = -1;
            do{
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
            }while(exit==-1);
            return exit;
	}
        /**
         * Comprovar que les respostes siguin valides
         * @param casella
         * @param respuesta 
         */
	public int checkOpcionesMenu(int casella, char respuesta) {
            int exit = -1;
            switch (respuesta){
                case 'B':
                    if(casella == 2||casella == 3||casella == 0){
                        System.out.println("No hay ningun enemigo.");
                    }else{
                        batalla();
                        exit=0;
                    }
                case 'R':
                    if(casella == 0 || casella == 1){
                        System.out.println("No hay nada que recoger");
                    }else{
                        recollir(casella);
                        exit=0;
                    }
                    break;
                case 'M':
                    missatgeMoure();
                    exit=0;
                    break;
                case 'C':  
                    //Com obtenim el nostre personatge?
                    //cambiarPersonatge();
                    exit=0;
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
            if(correcte==false){
                System.out.println("Compte! Et chocaràs!");
            }
            return correcte;
        }
        
        /**
        * Mostra el missatge de la posicio i chequeja de que ho hagi introduit bé
        */
       public abstract void missatgeMoure();
       
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
                   System.out.println("ERROR! Introduce una respuesta valida");
                   exit = -1;
           }
           return exit;
       }
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
		
        public void PerdoBatalla(){
                if(getMonedes() < 1){
                        System.out.println("Monedes actuals: " + getMonedes());
                        System.out.println("Perds una vida");
                        System.out.println("Vides actuals: " + getVides());
                        setVides(getVides() - 1);
                }
                else{
                        System.out.println("Monedes actuals: " + getMonedes());
                        System.out.println("Perds una moneda");
                        setMonedes(getMonedes() - 1);
                }
        }
		
        public void GuanyoBatalla(){
                int [] posicio = super.getPosicioPersonatge();
                int [][] tauler = super.getTauler();
                int res = super.getRES();
                setMonedes(getMonedes() + 1);
                tauler[posicio[0]][posicio[1]] = res;
                super.setTauler(tauler);
        }
        
        public int generarPersonatge() {
		int personatge;
		personatge = (int) (Math.random()*(3) + 1);
		return personatge;
        }
        
        public int sortida(){
        int[][] tauler = super.getTauler();
           final int SORTIDA = super.getSORTIDA();
           int [] posicio = super.getPosicioPersonatge();
           int monedes = getMonedes();
           boolean clau = isClau();
           int guanyar=-1;
           if(tauler[posicio[0]][posicio[1]] == SORTIDA){
               System.out.println("Estas en la sortida.");
               if(monedes>=5 && clau==true){
                   System.out.println("Has guanyat!");
                   guanyar = 1;
               }else{
                   if(monedes<5){
                       System.out.println("No pots acabar el joc encara. Et falten monedes");
                   }else if(clau==false){
                       System.out.println("No pots acabar el joc encara. Has de trovar la clau");
                   }
                   System.out.println("Tornes a l'inici.");
                   guanyar = 0;
                   posicio[0]=0;
                   posicio[1]=0;
                   super.setPosicioPersonatge(posicio);
               }
           }
           return guanyar;
    }
}

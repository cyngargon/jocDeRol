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
        public void moure(char direccio) {
            int [] posicio;
            boolean correcte=true;
            posicio = super.getPosicioPersonatge();
            direccio = Character.toUpperCase(direccio);
            switch (direccio){
                case 'W': case 'S':
                    correcte = checkMoviment(direccio);
                    if(correcte==true){
                        posicio[0]++;
                        super.setPosicioPersonatge(posicio);
                    }
                    break;
                case 'A': case 'D':
                    correcte = checkMoviment(direccio);
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
        /*
        
        
        
        
        
        */
        public void mostrarDireccio(){
            System.out.println(missatgePosicio());
            System.out.println("W -> Arriba"
                  + "\nS -> Abajo"
                  + "\nD -> Derecha"
                  + "\nA -> Izquierda");
        }
        public void cambiarPersonatge(){
            
        }
        public void recollir(){
            
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
                        recollir();
                        exit=0;
                    }
                    break;
                case 'M':
                    missatgeMoure();
                    exit=0;
                    break;
                case 'C':   
                    cambiarPersonatge();
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
                   System.out.println("Error.");
                   exit = -1;
           }
           return exit;
       }
        
}

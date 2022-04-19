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
        public abstract void moure(char [] direccio);
        public abstract void batalla();
        public void mostrarDireccio(){
        System.out.println(missatgePosicio());
        System.out.println("W -> Arriba"
              + "\nS -> Abajo"
              + "\nD -> Derecha"
              + "\nA -> Izquierda");
    }
        public boolean checkDireccio(char [] direccio){
            boolean error;
            switch (direccio[0]){
                case 'W': case 'S': case 'D': case 'A':
                    error = true;
                    break;
                default:
                    error = false;
            }
            return error;
        }
        public void cambiarPersonatge(){
            
        }
        public void sortir(){
            
        }
        public void recollir(){
            
        }
        
        
        /**
         * Mostra el menú depenent de la casella en la que es trovi el personatge
         */
	public void mostrarMenu() {
            int [] posicio = super.getPosicioPersonatge();
            int [][] tauler = super.getTauler();
            int numero = tauler[posicio[0]][posicio[1]];
            char respuesta;
            
            switch (numero){
                case 0: //Res
                    System.out.println("M: Moverse" + 
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    Character.toUpperCase(respuesta);
                    //Comprovem que la resposta sigui valida
                    checkOpcionesMenu(numero, respuesta);
                    break;
                case 1: //Enemic
                    System.out.println("B: Batalla" +
                                        "\nM: Moverse" +
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    Character.toUpperCase(respuesta);
                    //Comprovem que la resposta sigui valida
                    checkOpcionesMenu(numero, respuesta);
                    break;
                case 3: case 2: //Moneda i clau
                    System.out.println("M: Moverse" + 
                                        "\nR: Recoger" +
                                        "\nC: Cambiar personaje" +
                                        "\nS: Salir del juego");
                    respuesta = Teclat.llegirChar();
                    Character.toUpperCase(respuesta);
                    //Comprovem que la resposta sigui valida
                    checkOpcionesMenu(numero, respuesta);
                    break;
                default:
                    System.out.println("ERROR!");
            }
	}
        /**
         * Comprovar que les respostes siguin valides
         * @param casella
         * @param respuesta 
         */
	public void checkOpcionesMenu(int casella, char respuesta) {
            switch (respuesta){
                case 'B':
                    if(casella == 2||casella == 3||casella == 0){
                        System.out.println("No hay ningun enemigo.");
                    }else{
                        batalla();
                    }
                case 'R':
                    if(casella == 0 || casella == 1){
                        System.out.println("No hay nada que recoger");
                    }else{
                        recollir();
                    }
                    break;
                case 'M':
                    mostrarDireccio();
                    break;
                case 'C':   
                    cambiarPersonatge();
                    break;
                case 'S':
                    sortir();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
	}
        /**
         * Comprovar que es pot moure cap a aquella direccio
         * @param direccio
         */
        public void checkMoviment(char direccio){
            //si no es choca
            //total - posicion < al length de la direccio
            int [] posicio = super.getPosicioPersonatge();
            int [][] tauler = super.getTauler();
            
            switch(direccio){
                case 'W':
                    break;
            }
        }
        
        /**
        * Mostra el missatge de la posicio i chequeja de que ho hagi introduit bé
        * @param direccio 
        */
       public void missatgeMoure(char [] direccio) {
           boolean errorDireccio;

           for (int i = 0; i < direccio.length; i++) {
               do{
                   missatgePosicio();
                   mostrarDireccio();
                   direccio[i] = Teclat.llegirChar();
                   Character.toUpperCase(direccio[i]);
                   errorDireccio = checkDireccio(direccio);
               }while(errorDireccio==true);
           }
           moure(direccio);
       }
        
}

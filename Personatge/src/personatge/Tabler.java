package personatge;

import java.util.Optional;
import personatge.TFicha;

public class Tabler{
    //0 --> SORTIDA
	//1 --> RES
	//2 --> ENEMIC
	//3 --> MONEDA
        //4 --> CLAU
    //Attributes
	private int[][] tauler;
	private Personatge personatge;
        
        
    //Constructors
	public Tabler() {
	}
    
    //Getter and setter
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
        
    //Methods
        public void recollir(int casella){
            this.getPersonatge().recollir(casella);
            tauler[getPersonatge().getPosicio()[0]][getPersonatge().getPosicio()[1]] = TFicha.NADA.ordinal();
        }
        public void dimensioTauler() {
            int [] dimensions = new int [2];
            boolean checkDimension;
            int [][] tauler1;
            do{
                    System.out.print("Introduce las columnas del mapa: ");
                    dimensions[0] = Teclat.llegirInt();
                    System.out.print("Introduce las filas del mapa: ");
                    dimensions[1] = Teclat.llegirInt();
                    checkDimension = checkDimensions(dimensions);
            }while(checkDimension == false);
            tauler1 = new int[dimensions[0]][dimensions[1]];
            this.tauler = tauler1;
	}
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
	public void generarTauler() {		
            int filaClau, columnaClau, filaSortida, columnaSortida;
            //RES, ENEMIC I MONEDA
            for (int[] tauler1 : tauler) {
                for (int j = 0; j < tauler[0].length; j++) {
                    tauler1[j] = (int)(1 + (Math.random()*4));
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
	public void mostrarTauler(){
            int [] posicioPersonatge=personatge.getPosicio();
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
        public void mostrarPosicio(){
            final int ZERO = 0, U = 1;
            int [] posicioPersonatge = personatge.getPosicio();
            System.out.println("Estas en la posición: " + posicioPersonatge[ZERO] + "," + posicioPersonatge[U]);
        }
        public void mostrarClau(){
            if(getPersonatge().isClau()==true){
                    System.out.println("Tens la clau");
                }else{
                    System.out.println("No tens la clau");
                }
        }
        public void mostrarMonedes(){
            System.out.println("Tens " + getPersonatge().getMonedes() + " monedes.");
        }
        public void mostrarVides(){
            System.out.println("Tens " + getPersonatge().getVides() + " vides.");
        }
        public void mostrarDatos(){
            mostrarPosicio();
            //Monedes
            mostrarMonedes();
            //Clau
            mostrarClau();
            //Vides
            mostrarVides();
        }
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
                   personatge1 = new Sacerdot();
                   break;
           }
           this.personatge = personatge1;
        }
        public int menu(){
            char respuesta;
            int exit = -1;
                int fixa = getTauler()[getPersonatge().getPosicio()[0]][getPersonatge().getPosicio()[1]];
                switch (fixa){
                    case 1: //Res
                        System.out.println("No hay nada en tu casilla. Elige entre estas opciones: ");
                        System.out.println("M: Moverse" + 
                                            "\nC: Cambiar personaje" +
                                            "\nS: Salir del juego");
                        respuesta = Teclat.llegirChar();
                        respuesta = Character.toUpperCase(respuesta);
                        //Comprovem que la resposta sigui valida
                        exit = checkOpcionesMenu(fixa, respuesta);
                        break;
                    case 2: //Enemic
                        System.out.println("Te has encontrado con un enemigo. Elige entre estas opciones: ");
                        System.out.println("B: Batalla" +
                                            "\nM: Moverse" +
                                            "\nC: Cambiar personaje" +
                                            "\nS: Salir del juego");
                        respuesta = Teclat.llegirChar();
                        respuesta = Character.toUpperCase(respuesta);
                        //Comprovem que la resposta sigui valida
                        exit = checkOpcionesMenu(fixa, respuesta);
                        break;
                    case 3: //MONEDA
                        System.out.println("Te has encontrado con una moneda. Elige entre estas opciones: ");
                        System.out.println("M: Moverse" + 
                                            "\nR: Recoger" +
                                            "\nC: Cambiar personaje" +
                                            "\nS: Salir del juego");
                        respuesta = Teclat.llegirChar();
                        respuesta = Character.toUpperCase(respuesta);
                        //Comprovem que la resposta sigui valida
                        exit = checkOpcionesMenu(fixa, respuesta);
                        break;
                    case 4: //CLAU
                        System.out.println("Te has encontrado con una llave. Elige entre estas opciones: ");
                        System.out.println("M: Moverse" + 
                                            "\nR: Recoger" +
                                            "\nC: Cambiar personaje" +
                                            "\nS: Salir del juego");
                        respuesta = Character.toUpperCase(Teclat.llegirChar());
                        //Comprovem que la resposta sigui valida
                        exit = checkOpcionesMenu(fixa, respuesta);
                        break;
                    default:
                        System.out.println("ERROR!");
                }
                return exit;
        }
        public int checkOpcionesMenu(int casella, char respuesta){
            int exit = -1, resultatBatalla;
            
            switch (respuesta){
                case 'B':
                    if(casella == TFicha.LLAVE.ordinal()||casella == TFicha.MONEDA.ordinal()||casella == TFicha.NADA.ordinal() || casella==TFicha.SALIDA.ordinal()){
                        System.out.println("No hay ningun enemigo.");
                    }else{
                        resultatBatalla = getPersonatge().batalla();
                        switch(resultatBatalla){
                            case 0:
                                this.getPersonatge().PerdoBatalla();
                                break;
                            case 1:
                                guanyoBatalla();
                                break;
                            case -1:
                                System.out.println("Has empatado.");
                            default:
                                System.out.println("Error");
                        }
                        exit=0;
                    }
                case 'R':
                    if(casella == TFicha.ENEMIGO.ordinal() || casella == TFicha.NADA.ordinal() || casella == TFicha.SALIDA.ordinal()){
                        System.out.println("No hay nada que recoger");
                    }else{
                        recollir(casella);
                        exit=0;
                    }
                    break;
                case 'M':
                    if(personatge instanceof Guerrer){
                        missatgeMoure(1);
                    }else if(personatge instanceof Sacerdot){
                        missatgeMoure(2);
                    }else if(personatge instanceof Mag){
                        missatgeMoure(3);
                    }
                    exit=0;
                    break;
                case 'C':  
                    exit = -2;
                    break;
                case 'S':
                    exit = getPersonatge().salir();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
					exit =0;
            }
            return exit;
	
        }
        public boolean checkMoviment(char direccio){
            //si no es choca
            //total - posicion < al length de la direccio
            int [] posicio = this.getPersonatge().getPosicio();
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
        public void missatgeMoure(int moviments) {
        boolean errorDireccio, correcte;
           char [] direccio = new char[moviments];
           int i=0;
           int guanyar = sortida();
           if(guanyar==-1||guanyar==0){
            do{
                this.getPersonatge().missatgePosicio();
                this.getPersonatge().mostrarDireccio();
                direccio[i] = Character.toUpperCase(Teclat.llegirChar());
                errorDireccio = checkDireccio(direccio[i]);
                correcte = checkMoviment(direccio[i]);
				this.getPersonatge().moure(direccio[i], correcte);
                i++;
            }while(errorDireccio==true && i<direccio.length);
           }
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
	public void guanyoBatalla(){
                getPersonatge().guanyoBatalla();
                tauler[this.getPersonatge().getPosicio()[0]][this.getPersonatge().getPosicio()[1]] = TFicha.NADA.ordinal();
        }
        public int sortida(){
           int guanyar=-1;
           if(tauler[getPersonatge().getPosicio()[0]][getPersonatge().getPosicio()[1]] == TFicha.SALIDA.ordinal()){
               System.out.println("Estas en la sortida.");
               if(getPersonatge().getMonedes()>=5 && getPersonatge().isClau()==true){
                   System.out.println("Has guanyat!");
                   guanyar = 1;
               }else{
                   if(getPersonatge().getMonedes()<5){
                       System.out.println("No pots acabar el joc encara. Et falten monedes");
                   }else if(getPersonatge().isClau()==false){
                       System.out.println("No pots acabar el joc encara. Has de trovar la clau");
                   }
                   System.out.println("Tornes a l'inici.");
                   guanyar = 0;
                   getPersonatge().getPosicio()[0]=0;
                   getPersonatge().getPosicio()[1]=0;
                   this.getPersonatge().setPosicio(getPersonatge().getPosicio());
               }
           }
           return guanyar;
        }
}
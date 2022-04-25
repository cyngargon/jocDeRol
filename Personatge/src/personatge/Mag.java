package personatge;

public class Mag extends Personatge{

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1 | de 2 en 2 | de 3 en 3";
    }

    @Override
    public void batalla() {
        int enemic = RandomizEnemic();
		if(enemic == 2){ //Perdo
			System.out.println("L'enemic és un Sacerdot! Perds la batalla");
			PerdoBatalla();
		}
		else if (enemic == 1){ //Guanyo
			System.out.println("L'enemic és un Guerrer! Guanyes la batalla");
			GuanyoBatalla();
		}
		else{
			batalla();
		}
    }
    
    @Override
    public void missatgeMoure() {
        boolean errorDireccio, correcte;
        char [] direccio = new char[3];
        int i=0, exit, a=0, error;
        
        do{
            super.mostrarTauler();
            super.mostrarPosicio();
            do{
                mostrarDireccio();
                direccio[i] = Teclat.llegirChar();
                direccio[i] = Character.toUpperCase(direccio[i]);
                //checks
                errorDireccio = checkDireccio(direccio[i]);
                error = checkUnicaDireccio(direccio, a);
                correcte = checkMoviment(direccio[i]);
            }while(errorDireccio==true|| error==1 ||correcte==false);
            moure(direccio[i], correcte);
            i++;
            a++;
            exit = seguirMovente(i, direccio);
        }while(exit == 1 && i<direccio.length );
    }
    
    public int seguirMovente(int i, char [] direccio){
        char respuesta;
        int exit=0;
        if(i<direccio.length -1 || i==direccio.length -1){
                do{
                    System.out.println("Quieres seguir moviendote? Responde con S/N");
                    respuesta = Teclat.llegirChar();
                    exit = super.confirmacion(respuesta);
                }while(exit == -1);
            }
        return exit;
    }
    public int checkUnicaDireccio(char [] direccio, int a){
        int error=-1;
        if(a>0){
            do{
                if(direccio[a]!= direccio[0]){
                    error=1;
                    System.out.println("ERROR! Solo te puedes mover para una direccion. ");
                }else{
                    error=0;
                }
                a--;
            }while(error==0 && a>0);
        }
        return error;
    }
	
}

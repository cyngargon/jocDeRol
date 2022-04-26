package personatge;

public class Guerrer extends Personatge {

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1";
    }
    
    

    @Override
    public void batalla() {
        int enemic = RandomizEnemic();
		if(enemic == 3){ //Perdo
			System.out.println("L'enemic és un Mag! Perds la batalla");
			PerdoBatalla();
		}
		else if (enemic == 2){ //Guanyo
			System.out.println("L'enemic és un Sacerdot! Guanyes la batalla");
			GuanyoBatalla();
		}
		else{
			batalla();
		}
    }

    @Override
    public void missatgeMoure() {
        boolean errorDireccio, correcte;
           char [] direccio = new char[1];
           int i=0;
           int guanyar = sortida();
           if(guanyar==-1||guanyar==0){
            do{
                missatgePosicio();
                mostrarDireccio();
                direccio[i] = Teclat.llegirChar();
                Character.toUpperCase(direccio[i]);
                errorDireccio = checkDireccio(direccio[i]);
                correcte = checkMoviment(direccio[i]);
                i++;
            }while(errorDireccio==true && i<direccio.length);
            moure(direccio[i], correcte);
           }
    }
    
    
	
}

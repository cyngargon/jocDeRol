package personatge;

public class Sacerdot extends Personatge{

    public Sacerdot(){
        
    }
    
    public Sacerdot(Personatge personatge){
        super(personatge.getVides(), personatge.getMonedes(), personatge.isClau(), personatge.isActiu());
    }
    
    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1 | de 2 en 2";
    }

    @Override
    public void batalla() {
        int enemic = RandomizEnemic();
		if(enemic == 1){ //Perdo
			System.out.println("L'enemic és un Guerrer! Perds la batalla");
			PerdoBatalla();
		}
		else if (enemic == 3){ //Guanyo
			System.out.println("L'enemic és un Mag! Guanyes la batalla");
			GuanyoBatalla();
		}
		else{
			batalla();
		}
    }
    
    @Override
    public void missatgeMoure() {
        boolean errorDireccio, correcte;
           char [] direccio = new char[2];
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

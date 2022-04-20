package personatge;

public class Guerrer extends Personatge {

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1";
    }
    
    

    @Override
    public void batalla() {
        
    }

    @Override
    public void missatgeMoure() {
        boolean errorDireccio;
           char [] direccio = new char[1];
           int i=0;
            do{
                mostrarDireccio();
                direccio[i] = Teclat.llegirChar();
                Character.toUpperCase(direccio[i]);
                errorDireccio = checkDireccio(direccio[i]);
                i++;
            }while(errorDireccio==true && i<direccio.length);
           moure(direccio[i]);
    }
    
    
	
}

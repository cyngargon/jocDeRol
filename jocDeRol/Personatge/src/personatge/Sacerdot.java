package personatge;

public class Sacerdot extends Personatge{

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1 | de 2 en 2";
    }

    @Override
    public void batalla() {
        
    }
    
    @Override
    public void missatgeMoure() {
        boolean errorDireccio;
           char [] direccio = new char[2];
           int i=0;
            do{
                missatgePosicio();
                mostrarDireccio();
                direccio[i] = Teclat.llegirChar();
                Character.toUpperCase(direccio[i]);
                errorDireccio = checkDireccio(direccio[i]);
                i++;
            }while(errorDireccio==true && i<direccio.length);
           moure(direccio);
    }
	
}
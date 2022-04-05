package personatge;

public class Mag extends Personatge{

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1 | de 2 en 2 | de 3 en 3";
    }

    @Override
    public void moure(char [] direccio) {
        
    }

    @Override
    public void batalla() {
        
    }

    @Override
    public void mostrarDireccio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkDireccio(char [] direccio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}

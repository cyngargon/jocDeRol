package personatge;

public class Guerrer extends Personatge {

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1";
    }
    
    @Override
    public void moure(char [] direccio) {
        
    }
    

    @Override
    public void batalla() {
        
    }
    

    @Override
    public boolean checkDireccio(char[] direccio) {
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
    
    
	
}

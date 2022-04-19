package personatge;

public class Guerrer extends Personatge {

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1";
    }
    
    @Override
    public void moure(char [] direccio) {
        int [] posicio;
        posicio = super.getPosicioPersonatge();
        
        for (int i = 0; i < direccio.length; i++) {
            switch (direccio[i]){
                case 'W':
                    super.checkMoviment(direccio[i]);
                    posicio[0]++;
            }
        }
    }
    

    @Override
    public void batalla() {
        
    }
    
    
	
}

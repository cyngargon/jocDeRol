package personatge;

public class Guerrer extends Personatge {

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1" + super.mostrarPosicio();
    }

    @Override
    public void moure() {
        
    }

    @Override
    public void batalla() {
        
    }
	
}

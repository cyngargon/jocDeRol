package personatge;

public class Mag extends Personatge{

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1 | de 2 en 2 | de 3 en 3" + super.mostrarPosicio();
    }

    @Override
    public void moure() {
        
    }

    @Override
    public void batalla() {
        
    }
	
}

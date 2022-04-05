package personatge;

public class Sacerdot extends Personatge{

	@Override
	public String missatgePosicio() {
		return "Et pots moures d'1 en 1 | de 2 en 2" + super.mostrarPosicio();
	}
	
}

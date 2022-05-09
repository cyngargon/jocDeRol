package personatge;

/**
 * Classe Filla de Personatge --Sacerdot--
 * @author MarcSerra, CynthiaGarcia, PolCrespo 
 */

public class Sacerdot extends Personatge{
	//	Constructor
    public Sacerdot(){
        
    }
    //	Mètodes   
	/**
	 * Mètode Batlla Classe Sacerdot
	 * @return 
	 */
    @Override
    public int batalla() {
		int resultat = -1;
        int enemic = RandomizEnemic();
        do{
			switch (enemic) {
            case 1:
                //Perdo
                System.out.println("L'enemic és un Guerrer! Perds la batalla");
				resultat = 1;
				PerdoBatalla();
                break;
            case 3:
                //Guanyo
                System.out.println("L'enemic és un Mag! Guanyes la batalla");
				resultat = 2;
				GuanyoBatalla();
                break;
			case 2:
				enemic = RandomizEnemic();
				break;
			}
		}while(resultat == -1);
		return resultat;
    }
	/**
	 * Mètode Canviar Personatge Classe Sacerdot
	 * @return 
	 */
	@Override
    public char canvi() {
        char resposta;
        System.out.println("El teu personatge és un Sacerdot. "
                + "Pots canviar a:\nG. Guerrer\nM. Mag"
                + "\nCost per canviar de personatge: 1 moneda");
        
        System.out.print("Selecciona: ");
        resposta = Character.toUpperCase(Teclat.llegirChar());
        
        return resposta;
    }
	
}

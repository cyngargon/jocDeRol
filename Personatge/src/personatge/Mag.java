package personatge;

/**
 * Classe Filla de Personatge --Mag--
 * @author MarcSerra, CynthiaGarcia, PolCrespo
 */

public class Mag extends Personatge{
    //	Constructor
    public Mag(){
        
    }
    //	Mètodes
	/**
	 * Mètode Batalla Classe Mag
	 * @return 
	 */
    @Override
    public int batalla() {
		int resultat = -1;
        int enemic = RandomizEnemic();
		do{
        switch (enemic) {
            case 2:
                //Perdo
                System.out.println("L'enemic és un Sacerdot! Perds la batalla");
				PerdoBatalla();
				resultat = 1;
                break;
            case 1:
                //Guanyo
                System.out.println("L'enemic és un Guerrer! Guanyes la batalla");
				GuanyoBatalla();
				resultat = 2;
                break;
			case 3:
				enemic = RandomizEnemic();
				break;
			}
		}while(resultat == -1);
		return resultat;
    }
	/**
	 * Mètode Canviar Personatge Classe Mag
	 * @return 
	 */
    @Override
    public char canvi() {
        char resposta;
        System.out.println("El teu personatge és un Mag. "
                + "Pots canviar a:\n G.Guerrer\n M.Sacerdot"
                + "\nCost per canviar de personatge: 1 moneda");
        
        System.out.print("Selecciona: ");
        resposta = Character.toUpperCase(Teclat.llegirChar());
        
        return resposta;
    }	
}

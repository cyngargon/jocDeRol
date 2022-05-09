package personatge;

/**
 * Classe Filla de Personatge --Sacerdot--
 * @author MarcSerra, CynthiaGarcia, PolCrespo
 */

public class Guerrer extends Personatge {
    //	Constructor
    public Guerrer(){
        
    }
	//	Mètodes
	/**
	 * Mètode Batalla Classe Guerrer
	 * @return 
	 */
    @Override
    public int batalla() {
		int resultat = -1;
        int enemic = RandomizEnemic();
		do{
        switch (enemic) {
            case 3:
                //Perdo
                System.out.println("L'enemic és un Mag! Perds la batalla");
				PerdoBatalla();
				resultat = 1;
                break;
            case 2:
                //Guanyo
                System.out.println("L'enemic és un Sacerdot! Guanyes la batalla");
				GuanyoBatalla();
				resultat = 2;
                break;
			case 1:
				enemic = RandomizEnemic();
				break;
			}
		}while(resultat == -1);
		return resultat;
    }
	/**
	 * Mètode Canviar Personatge Classe Guerrer 
	 * @return 
	 */
	@Override
    public char canvi() {
        char resposta;
        System.out.println("El teu personatge és un Guerrer. "
                + "Pots canviar a:\nS. Sacerdot\nM. Mag"
                + "\nCost per canviar de personatge: 1 moneda");
        
        System.out.print("Selecciona: ");
        resposta = Character.toUpperCase(Teclat.llegirChar());
        
        return resposta;
    }
    
    
    
	
}

package personatge;

public class Sacerdot extends Personatge{

    public Sacerdot(){
        
    }
       
    @Override
    public char Canvi() {
        char resposta;
        System.out.println("El teu personatge és un Sacerdot. "
                + "Pots canviar a:\nG. Guerrer\nM. Mag"
                + "\nCost per canviar de personatge: 1 moneda");
        
        System.out.print("Selecciona: ");
        resposta = Character.toUpperCase(Teclat.llegirChar());
        
        return resposta;
    }

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
				System.out.println("emp");
				enemic = RandomizEnemic();
				break;
			}
		}while(resultat == -1);
		return resultat;
    }
	
}

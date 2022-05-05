package personatge;

public class Sacerdot extends Personatge{

    public Sacerdot(){
        
    }
    
    @Override
    public String missatgePosicio() {
            return "Et pots moure d'1 en 1 | de 2 en 2";
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
        int enemic = RandomizEnemic(), resultatBatalla=-1;
        switch (enemic) {
            case 1:
                //Perdo
                System.out.println("L'enemic és un Guerrer! Perds la batalla");
                resultatBatalla = 0;
                break;
            case 3:
                //Guanyo
                System.out.println("L'enemic és un Mag! Guanyes la batalla");
                resultatBatalla = 1;
                break;
            default:
                batalla();
                break;
        }
        return resultatBatalla;
    }
	
}

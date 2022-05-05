package personatge;

public class Guerrer extends Personatge {
    
    public Guerrer(){
        
    }
    @Override
    public String missatgePosicio() {
            return "Et pots moure d'1 en 1";
    }
    
    @Override
    public char Canvi() {
        char resposta;
        System.out.println("El teu personatge és un Guerrer. "
                + "Pots canviar a:\nS. Sacerdot\nM. Mag"
                + "\nCost per canviar de personatge: 1 moneda");
        
        System.out.print("Selecciona: ");
        resposta = Character.toUpperCase(Teclat.llegirChar());
        
        return resposta;
    }

    @Override
    public int batalla() {
        int enemic = RandomizEnemic();
        int resultatBatalla;
            if(enemic == 3){ //Perdo
                    System.out.println("L'enemic és un Mag! Perds la batalla");
                    resultatBatalla=0;
            }
            else if (enemic == 2){ //Guanyo
                    System.out.println("L'enemic és un Sacerdot! Guanyes la batalla");
                    resultatBatalla = 1;
            }
            else{ //Empat
                resultatBatalla = -1;
                    batalla();
            }
            return resultatBatalla;
    }

    
    
    
	
}

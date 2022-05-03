package personatge;

public class Guerrer extends Personatge {
    
    public Guerrer(){
        
    }
    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1";
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

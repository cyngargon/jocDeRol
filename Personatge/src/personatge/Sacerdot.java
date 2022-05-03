package personatge;

public class Sacerdot extends Personatge{

    public Sacerdot(){
        
    }
    
    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1 | de 2 en 2";
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

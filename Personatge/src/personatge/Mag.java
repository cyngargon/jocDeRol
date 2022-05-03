package personatge;

public class Mag extends Personatge{
    
    public Mag(){
        
    }
    
    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1 | de 2 en 2 | de 3 en 3";
    }

    @Override
    public int batalla() {
        int enemic = RandomizEnemic(), resultatBatalla=-1;
        switch (enemic) {
            case 2:
                //Perdo
                System.out.println("L'enemic és un Sacerdot! Perds la batalla");
                resultatBatalla=0;
                break;
            case 1:
                //Guanyo
                System.out.println("L'enemic és un Guerrer! Guanyes la batalla");
                resultatBatalla=1;
                break;
            default:
                //Empat
                System.out.println("Has empatat");
                batalla();
                break;
        }
            return resultatBatalla;
    }
    
    public int seguirMovente(int i, char [] direccio){
        char respuesta;
        int exit=0;
        if(i<direccio.length -1 || i==direccio.length -1){
                do{
                    System.out.println("Quieres seguir moviendote? Responde con S/N");
                    respuesta = Teclat.llegirChar();
                    exit = super.confirmacion(respuesta);
                }while(exit == -1);
            }
        return exit;
    }
    public int checkUnicaDireccio(char [] direccio, int a){
        int error=-1;
        if(a>0){
            do{
                if(direccio[a]!= direccio[0]){
                    error=1;
                    System.out.println("ERROR! Solo te puedes mover para una direccion. ");
                }else{
                    error=0;
                }
                a--;
            }while(error==0 && a>0);
        }
        return error;
    }
	
}

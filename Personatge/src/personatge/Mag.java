package personatge;

public class Mag extends Personatge{
    
    public Mag(){
        
    }
    

    @Override
    public char Canvi() {
        char resposta;
        System.out.println("El teu personatge és un Mag. "
                + "Pots canviar a:\n G.Guerrer\n M.Sacerdot"
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
				System.out.println("emp");
				enemic = RandomizEnemic();
				break;
			}
		}while(resultat == -1);
		return resultat;
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
                    System.out.println("ERROR! Només et pots moure en una direcció. ");
                }else{
                    error=0;
                }
                a--;
            }while(error==0 && a>0);
        }
        return error;
    }
	
}

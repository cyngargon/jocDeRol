package personatge;

public class Mag extends Personatge{

    @Override
    public String missatgePosicio() {
            return "Et pots moures d'1 en 1 | de 2 en 2 | de 3 en 3";
    }

    @Override
    public void batalla() {
        
    }
    
    @Override
    public void missatgeMoure() {
        boolean errorDireccio, errorMoviment;
        
           char [] direccio = new char[3];
           int i=0, exit, a=0, error;
           char respuesta;
            do{
                do{
                    do{
                        super.mostrarTauler();
                        super.mostrarPosicio();
                        missatgePosicio();
                        mostrarDireccio();
                        direccio[i] = Teclat.llegirChar();
                        direccio[i] = Character.toUpperCase(direccio[i]);
                        errorDireccio = checkDireccio(direccio[i]);
                        moure(direccio[i]);
                    }while(errorDireccio==true);
                    error = checkUnicaDireccio(direccio, a);
                    a++;
                }while(error==1);
                i++;
                
                System.out.println("Quieres seguir moviendote? Responde con S/N");
                respuesta = Teclat.llegirChar();
                exit = super.confirmacion(respuesta);

            }while(exit == 1 || exit == -1);
    }
    
    public int checkUnicaDireccio(char [] direccio, int a){
        int error;
        if(a>0){
            do{
                if(direccio[a]!= direccio[a-1]){
                    error=1;
                    System.out.println("ERROR! Solo te puedes mover para una direccion. ");
                }else{
                    error=0;
                }
            }while(error==0 && a<direccio.length);
        }
        error=-1;
        return error;
    }
	
}

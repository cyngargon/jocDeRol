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
        boolean errorDireccio, error;
           char [] direccio = new char[3];
           int i=0, exit, a=0;
           char respuesta;
            do{
                do{
                    missatgePosicio();
                    mostrarDireccio();
                    direccio[i] = Teclat.llegirChar();
                    direccio[i] = Character.toUpperCase(direccio[i]);
                    errorDireccio = checkDireccio(direccio[i]);
                    error = checkUnicaDireccio();
                }while(errorDireccio==true);
                i++;
                
                System.out.println("Quieres seguir moviendote? Responde con S/N");
                respuesta = Teclat.llegirChar();
                exit = super.confirmacion(respuesta);

            }while(exit == 0);
           moure(direccio);
    }
    
    public void checkUnicaDireccio(){
        do{
                    if(direccio[i]!=direccio[i-1]){
                        error=true;
                        System.out.println("ERROR! Solo te puedes mover para una direccion. ");
                    }else{
                        error=false;
                    }
                }while(error==false&&a<direccio.length);
    }
	
}
